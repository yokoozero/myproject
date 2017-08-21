package com.boot.controller;

import com.boot.Entity.User;
import com.boot.dao.UserDao;
import com.boot.domain.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wb.zhengcheng on 2017/8/14.
 */
@RestController
public class ApiController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/getUser")
    public User getUser(HttpServletRequest request) {
        String accountName = request.getParameter("accountName");
        String password = request.getParameter("password");
        List<User> users = userDao.findByAccountName(accountName);
        if (users != null && users.size() > 0) {
            if (password.equals(users.get(0).getPassword())) {
                return users.get(0);
            }
        }
        return null;
    }

    @RequestMapping("/getUserDiy")
    public User getUserByPage(HttpServletRequest request) {
        User result =  userDao.getDiy("tanwanzero");
        return  result;
    }

    @RequestMapping("/addUser")
    public User addUser(HttpServletRequest request) {
        String accountName = request.getParameter("accountName");
        String password = request.getParameter("password");
        String nickName = request.getParameter("nickName");

        User user = new User();
        List<User> users = userDao.findByAccountName(accountName);
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            user.setAccountName(accountName);
            user.setPassword(password);
            user.setNickName(nickName);
            userDao.save(user);
            return user;
        }
    }

    @RequestMapping("/putRedis")
    public boolean putRedis(HttpServletRequest request) {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        stringRedisTemplate.opsForValue().set(key,value);
        return  true;
    }

    @RequestMapping("/gutRedis")
    public String gutRedis(HttpServletRequest request) {
        String key = request.getParameter("key");
        String value = stringRedisTemplate.opsForValue().get(key);
        return  value;
    }
}
