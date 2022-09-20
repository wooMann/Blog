package com.blog.library.mail;

public class SignUpMail implements SendMail{

    @Override
    public MailServiceMessageDTO message(String userTokenId) {
        return MailServiceMessageDTO.builder()
                .title("회원가입 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("회원가입 메일 확인입니다")
                .build();
    }
}
