package com.blog.manager.DTO.mail;

import com.blog.manager.DTO.MailServiceMessage;

public class FindPasswordMail implements SendMail{

    @Override
    public MailServiceMessage message(String userTokenId) {
        return MailServiceMessage.builder()
                .title("비밀번호 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("비밀번호 찾기 메일입니다")
                .build();
    }
}
