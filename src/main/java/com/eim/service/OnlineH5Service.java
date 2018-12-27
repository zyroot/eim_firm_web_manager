package com.eim.service;

import com.eim.form.OnlineH5Form;

import java.util.List;

/**
 * Created by Zy on 2018/12/25.
 */
public interface OnlineH5Service {

    //修改
    void update(OnlineH5Form onlineH5);

    //保存
    void save(OnlineH5Form onlineH5);

    //删除
    void delete(List<String> idList);

    //模糊查询
}
