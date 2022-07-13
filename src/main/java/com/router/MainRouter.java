package com.router;

import com.controller.*;

import java.util.HashMap;

public class MainRouter {
    public MainRouter(HashMap<String, Controller> map){
        map.put("/login.do",new LoginController());
        map.put("/join.do",new JoinController());
        map.put("/joinProc.do",new JoinProcController());
        map.put("/logout.do",new LogoutController());
        map.put("/userEdit.do",new UserEditController());
        map.put("/userDelete.do",new UserDeleteController());
    }
}
