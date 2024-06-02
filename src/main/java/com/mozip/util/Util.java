package com.mozip.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.NClob;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class Util {
    public static String clobToString(NClob clob) {

        String result = null;
        Reader reader = null;
        BufferedReader br = null;
        try {
            reader = clob.getCharacterStream();
            br = new BufferedReader(reader);
            result = br.lines().collect(Collectors.joining());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return result;
    }
}
