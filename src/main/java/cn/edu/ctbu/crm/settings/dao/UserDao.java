package cn.edu.ctbu.crm.settings.dao;

import cn.edu.ctbu.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    User login(Map<String, Object> map);
}
