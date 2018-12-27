package com.eim.service.impl;

import com.eim.dataObject.OnlineH5;
import com.eim.enums.ExceptionEnums;
import com.eim.exception.WebException;
import com.eim.form.OnlineH5Form;
import com.eim.repository.OnlineH5Repository;
import com.eim.service.OnlineH5Service;
import com.eim.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 线上h5
 * Created by Zy on 2018/12/25.
 */
@Slf4j
@Service
public class OnlineH5ServiceImpl implements OnlineH5Service{

    @Autowired
    private OnlineH5Repository h5Repository;

    @Transactional
    @Override
    public void update(OnlineH5Form onlineH5) {
        OnlineH5 h5 = new OnlineH5();
        BeanUtils.copyProperties(onlineH5,h5);
        OnlineH5 save = h5Repository.save(h5);
        if(save == null){
            log.error("【h5保存】 更新失败 h5={}",save);
            throw new WebException(ExceptionEnums.H5_UPDATE_ERROE);
        }
    }

    @Transactional
    @Override
    public void save(OnlineH5Form onlineH5) {
        onlineH5.setH5Id(KeyUtil.getUniKey());

        OnlineH5 h5 = new OnlineH5();
        BeanUtils.copyProperties(onlineH5,h5);

        OnlineH5 save = h5Repository.save(h5);
        if(save == null){
            log.error("【h5保存】 保存失败 h5={}",save);
            throw new WebException(ExceptionEnums.H5_SAVE_ERROE);
        }
    }

    @Transactional
    @Override
    public void delete(List<String> idList) {
        for (String id : idList) {
            h5Repository.delete(id);
        }
    }
}
