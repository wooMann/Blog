package com.blog.manager;

import com.blog.manager.DTO.MailServiceMessage;
import com.blog.manager.DTO.MailServiceSetting;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class SendMailManager implements SendEmailManager,MailType {
    @Override
    public MailServiceSetting mailTrap() {
        return MailServiceSetting.builder()
                .from("from@example.com")
                .username("2ee152d4bfe31d")
                .password("285a9a3392b65f")
                .host("smtp.mailtrap.io")
                .build();
    }

    @Override
    public MailServiceMessage signUpMail(String userTokenId) {
        return MailServiceMessage.builder()
                .title("회원가입 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("회원가입 메일 확인입니다")
                .build();
    }

    @Override
    public MailServiceMessage findPasswordMail(String userTokenId) {

        return MailServiceMessage.builder()
                .title("비밀번호 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("비밀번호 찾기 메일입니다")
                .build();
    }



}
