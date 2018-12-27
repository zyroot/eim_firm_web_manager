package com.eim.repository;

import com.eim.Vo.AjaxTableResultVo;
import com.eim.dataObject.OnlineH5;
import com.eim.util.AjaxTableResultVoUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Zy on 2018/12/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineH5RepositoryTest {

    @Autowired
    private OnlineH5Repository repository;

    @Autowired
    private AjaxTableResultVoUtil ajaxTableResultVoUtil;

    @Test
    public void find(){
        OnlineH5 one = repository.findOne("20180720163015");
        System.out.println(one.toString());
        Assert.assertNotNull(one);

        Page<OnlineH5> h5Page = repository.findAll(new PageRequest((1 - 1), 10));
        String result = ajaxTableResultVoUtil.getResult(h5Page.getTotalPages(), h5Page.getContent());
        System.out.println(result);
    }

    @Test
    public void delete(){



    }

}