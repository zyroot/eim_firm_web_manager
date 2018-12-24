package com.eim.repository;

import com.eim.dataObject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *用户管理员
 * Created by Zy on 2018/12/24.
 */
public interface UserRepository extends JpaRepository<User,String>{

    /**
     * 根据用户名查找用户
     */
     User findByNameAndAndPassword(String name,String password);
}
