package com.eim.repository;

import com.eim.dataObject.JoinUs;
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
public class JoinUsRepositoryTest {

    @Autowired
    private JoinUsRepository repository;

    @Test
    public void findone(){
        String id = "20180626142752";
        JoinUs joinUs = repository.findOne(id);
        System.out.println(joinUs);
        Assert.assertNotNull(joinUs);
    }

    @Test
    public void  add(){
        JoinUs joinUs = new JoinUs();
        joinUs.setJoin_id("dfdfd");
        joinUs.setJoin_demand("sdfsd");
        joinUs.setJoin_department("dsfsdf");
        joinUs.setJoin_duty("sdfsdf");
        joinUs.setJoin_position("sdfsdf");
        joinUs.setJoin_position_state("sdfsdf");
        JoinUs save = repository.save(joinUs);
        Assert.assertNotNull(save);
    }

}