package com.blog.manager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class SendMailManager {

    @Getter
    @Setter
    @ToString
    public static class MailServiceInfo{
        String from ;
        String username;
        String password ;
        String host;
    }

    @Getter
    @Setter
    @ToString
    public static class MailServiceType{
        String title ;
        String body;
    }

    public MailServiceInfo mailTrap(){
        MailServiceInfo mailServiceInfo = new MailServiceInfo();
        mailServiceInfo.setFrom("from@example.com");
        mailServiceInfo.setUsername("2ee152d4bfe31d");
        mailServiceInfo.setPassword("285a9a3392b65f");
        mailServiceInfo.setHost("smtp.mailtrap.io");
        return mailServiceInfo;
    }

    public MailServiceType signUpMail(String userTokenId){
        String mailBody = "회원가입 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token="+userTokenId+"'> 확인 </a>";
        String mailTitle = "회원가입 메일 확인입니다";

        MailServiceType mailServiceType = new MailServiceType();
        mailServiceType.setBody(mailBody);
        mailServiceType.setTitle(mailTitle);

        return mailServiceType;
    }

    public MailServiceType findPasswordMail(String userTokenId){
        String mailBody = "비밀번호 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token="+userTokenId+"'> 확인 </a>";
        String mailTitle = "비밀번호 찾기 메일입니다";

        MailServiceType mailServiceType = new MailServiceType();
        mailServiceType.setBody(mailBody);
        mailServiceType.setTitle(mailTitle);

        return mailServiceType;
    }






}
