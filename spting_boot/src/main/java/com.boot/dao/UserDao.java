package com.boot.dao;

import com.boot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wb.zhengcheng on 2017/8/16.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    List<User> findByAccountName(String accountName);

    @Query("select u from User u where u.accountName =?1")
    User getDiy(String accountName);
}
