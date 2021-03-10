package cn.edu.ctbu.crm.settings.service.impl;

import cn.edu.ctbu.crm.exception.LoginException;
import cn.edu.ctbu.crm.settings.dao.UserDao;
import cn.edu.ctbu.crm.settings.domain.User;
import cn.edu.ctbu.crm.settings.service.UserService;
import cn.edu.ctbu.crm.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException{
        Map<String,Object> map = new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user = userDao.login(map);
        if(user == null){
            throw new LoginException("账号密码错误");
        }
        //判断失效时间
        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(currentTime.compareTo(expireTime) > 0){
            throw new LoginException("账号已失效");
        }
        //判断锁定状态
        String lockState = user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }
        //判断ip地址
        String allowIps = user.getAllowIps();
        if(allowIps != null && !allowIps.contains(ip)){
            throw new LoginException("ip地址受限，请联系管理员");
        }

        return user;
    }
}
