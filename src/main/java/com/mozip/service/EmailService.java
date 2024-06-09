package com.mozip.service;

import com.mozip.domain.member.AuthRepository;
import com.mozip.domain.project.ProjectRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmailService {
    private final AuthRepository authRepository;
    private final ProjectRepository projectRepository;
    private final JavaMailSender mailSender;

    @Transactional
    public void emailSender(int memberId, int projectId) {
        String memberEmail = authRepository.findById(memberId);
        String username = authRepository.findToUsername(memberId);
        String title = "제목입니다.";
        String content =
                """
                        <!DOCTYPE html>
                        <html lang="en">
                                        
                        <head>
                          <meta charset="UTF-8" />
                          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                          <title>이메일폼</title>
                          <!-- css / font -->
                          <!-- 아이콘 : font-awesome -->
                          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
                            integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
                            crossorigin="anonymous" referrerpolicy="no-referrer" />
                                        
                          <!-- favicon -->
                          <link rel="icon" href="./img/favicon.ico">
                        </head>
                                        
                        <body style="background-color:#f1f1f1;">
                          <div class="container" style="    margin: 40px auto; width: 710px; text-align: center;">
                            <a href="http://localhost:8082/"><img src="https://i.ibb.co/wpPC5hH/logo.png" alt="logo"
                                style="width:200px;"></a><br /><a target='_blank' href='https://imgbb.com/'></a><br />
                            <div class="box" style="text-align: left;
                            border: 1px solid #c3c3c3;
                            padding: 50px;
                            background-color:#fff;
                            margin-top:40px;">
                              <h1 style="    font-weight: 400;
                              text-align: left;
                              font-size: 1.5rem;
                              padding-bottom: 22px;">안녕하세요.
                              """
                              +username+
                              """
                              님,</h1>
                              <p style="    font-size: 1.1rem;
                              line-height: 1.5rem;
                              color: #888;
                              font-weight: 300;">가입 신청하신 프로젝트에서 작성자의 승인이 완료되었습니다.</p>
                              <a href="http://localhost:8082/project/
                              """
                              +projectId+
                              """
                              " style="    text-decoration: underline;
                              font-size: 0.875rem;">
                              <button style="    padding: 14px 25px;
                              display: block;
                              margin: 35px auto 20px;
                              background: #7353ea;
                              border: none;
                              border-radius: 5px;
                              color: #fff;
                              font-size:1.2rem;
                          ">프로젝트 가입</button>
                              </a>
                            </div>
                          </div>
                        </body>
                        </html>
                """;

        String from = "chlwodud199720327@gmail.com";
        String to = memberEmail;

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "utf-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);

            authRepository.projectJoin(memberId,projectId);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // 초대할려는 멤버가 이미 프로젝트 멤버인 경우
    public int emailValidation(int memberId, int projectId) {
        List<Integer> ids = projectRepository.findProjectMemberIdList(projectId);
        for (Integer id : ids) {
            if (memberId == id)
                return 1;
        }
        return -1;
    }
}
