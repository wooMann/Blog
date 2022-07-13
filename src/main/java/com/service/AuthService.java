package com.service;

import com.dto.DeleteDTO;
import com.dto.EditDTO;
import com.dto.LoginDTO;
import com.dto.LogoutDTO;
import com.entity.User;
import com.log.BizLog;

public class AuthService {

    public final BizLog bizLog;

    public AuthService(BizLog bizLog) {
        this.bizLog = bizLog;
    }

    public void login(LoginDTO loginDTO){
        User result = new User();

        if(result == null){
            return;
        }
        loginDTO.setEmail(result.getEmail());
        bizLog.save(loginDTO);
    }

    public void logout(LogoutDTO logoutDTO){
        bizLog.save(logoutDTO);
    }

    public void delete(DeleteDTO deleteDTO){
        bizLog.save(deleteDTO);
    }

    public void edit(EditDTO editDTO){
        bizLog.save(editDTO);
    }
}
