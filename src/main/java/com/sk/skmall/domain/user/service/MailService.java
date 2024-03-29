package com.sk.skmall.domain.user.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private static int verificationNumber;
    @Value("${spring.mail.username}")
    private String sendEmail;

    public static void createVerificationNumber(){
        verificationNumber = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    /**
     * 이메일 생성 메소드
     * @param mail 인증번호 받을 이메일
     * @return
     */
    public MimeMessage createMail(String mail){
        createVerificationNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(sendEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + verificationNumber + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    /**
     * 이메일 전송 메소드
     * @param mail 인증번호 받을 이메일
     * @return
     */
    public int sendMail(String mail){
        MimeMessage message = createMail(mail);
        javaMailSender.send(message);

        return verificationNumber;
    }
}
