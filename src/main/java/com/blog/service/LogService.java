package com.blog.service;

import com.blog.data.dto.DeleteDTO;
import com.blog.data.dto.EditDTO;
import com.blog.data.dto.LoginDTO;
import com.blog.data.dto.LogoutDTO;
import com.blog.data.entity.User;
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
