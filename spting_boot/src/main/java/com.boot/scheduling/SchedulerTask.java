package com.boot.scheduling;

import com.boot.Entity.User;
import com.boot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wb.zhengcheng on 2017/8/17.
 */
@Component
public class SchedulerTask {
    @Autowired
    private UserDao userDao;

    @Scheduled(cron="*/5 * * * * ?")
    private void process(){
        User user = new User();
        user.setAccountName(System.currentTimeMillis()+"");
        user.setPassword("111111");
        user.setNickName("auto add");
        userDao.save(user);
    }
}
