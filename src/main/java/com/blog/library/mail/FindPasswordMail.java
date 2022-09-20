package com.blog.library.mail;

public class FindPasswordMail implements SendMail{

    @Override
    public MailServiceMessageDTO message(String userTokenId) {
        return MailServiceMessageDTO.builder()
                .title("비밀번호 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token=" + userTokenId + "'> 확인 </a>")
                .body("비밀번호 찾기 메일입니다")
                .build();
    }
}
