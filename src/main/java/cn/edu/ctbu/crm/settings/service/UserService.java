package cn.edu.ctbu.crm.settings.service;

import cn.edu.ctbu.crm.exception.LoginException;
import cn.edu.ctbu.crm.settings.domain.User;

public interface UserService {

    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
