package com.blog.service;

import com.blog.dto.DeleteDTO;
import com.blog.dto.EditDTO;
import com.blog.dto.LoginDTO;
import com.blog.dto.LogoutDTO;
import com.blog.entity.User;
import com.blog.log.BizLog;

public class LogService {

    public final BizLog bizLog;

    public LogService(BizLog bizLog) {
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
