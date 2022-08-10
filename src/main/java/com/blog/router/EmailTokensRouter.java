package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.emailTokens.JoinConfirmController;

import java.util.HashMap;

public class EmailTokensRouter {
    public EmailTokensRouter(HashMap<String , Controller> router){
        router.put("/joinConfirm.do", new JoinConfirmController());
    }
}
