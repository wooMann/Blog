package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.emailTokens.JoinConfirmController;

import java.util.HashMap;

public class EmailTokensRoute {
    public EmailTokensRoute(HashMap<String , Controller> router){
        router.put("/joinConfirm.do", new JoinConfirmController());
    }
}
