package com.blog.manager.DTO.mail;

import com.blog.manager.DTO.MailServiceMessage;

public class SignUpMail implements SendMail{

    @Override
    public MailServiceMessage message(String userTokenId) {
        return MailServiceMessage.builder()
                .title("회원가입 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("회원가입 메일 확인입니다")
                .build();
    }
}
