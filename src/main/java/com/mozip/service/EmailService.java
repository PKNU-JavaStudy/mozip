package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmailService {
    private final AuthRepository authRepository;

    private final JavaMailSender mailSender;

    public void emailSender(int memberId) {
        String memberEamil = authRepository.findById(memberId);
        String title = "제목입니다.";
        String content = "<a href='http://localhost:8082'>mo.zip</a>";

        String from = "chlwodud199720327@gmail.com";
        String to = memberEamil;

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "utf-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
