package com.mozip.util;

import javax.sql.rowset.serial.SerialClob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.NClob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
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

    public static Timestamp stringToTimestamp(String strDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREAN);
        java.util.Date parsedDate = dateFormat.parse(strDate);
        return new java.sql.Timestamp(parsedDate.getTime());
    }

    // 날짜 형식 포맷
    public static String formatTimestamp(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        Date date = new Date(timestamp.getTime());
        return sdf.format(date);
    }

    // 날짜 형식 포맷
    public static String formatLocalDateTime(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDateTime 객체를 "yyyy-MM-dd" 형식의 문자열로 변환
        return date.format(formatter);
    }

    public static LocalDateTime stringToLocalDateTime(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 문자열을 LocalDate로 파싱
        LocalDate localDate = LocalDate.parse(strDate, formatter);
        return localDate.atStartOfDay();

    }
}
