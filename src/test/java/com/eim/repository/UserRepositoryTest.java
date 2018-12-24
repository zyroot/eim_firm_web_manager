package com.eim.repository;

import com.eim.dataObject.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Zy on 2018/12/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void find(){
        User sss = repository.findOne("sss");
        System.out.println(sss);
        Assert.assertNotNull(sss);
    }

    @Test
    public void add(){
        User user = new User();
        user.setId("sss");
        user.setName("admin");
        user.setPassword("pwd");
        User save = repository.save(user);
        Assert.assertNotNull(save);
    }

    @Test
    public void findNameAndPwd(){
        User user = new User();
        user.setId("sss");
        user.setName("admin");
        user.setPassword("pwe");
        User l = repository.findByNameAndAndPassword(user.getName(), user.getPassword());
        System.out.println(l);
        Assert.assertNotNull(l);
    }



}