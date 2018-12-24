package com.eim.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 加入我们 人才招聘
 * Created by Zy on 2018/12/24.
 */
@Entity
@Data
@Table(name = "join_us")
public class JoinUs {
    /**
     * CREATE TABLE `join_us` (
     `join_id` varchar(125) NOT NULL COMMENT '岗位id',
     `join_department` varchar(125) NOT NULL COMMENT '岗位部门',
     `join_position` varchar(20) NOT NULL COMMENT '岗位',
     `join_duty` varchar(1000) NOT NULL COMMENT '岗位主要职责',
     `join_demand` varchar(1000) NOT NULL COMMENT '岗位要求',
     `join_position_state` varchar(1000) DEFAULT '' COMMENT '岗位描述',
     PRIMARY KEY (`join_id`),
     UNIQUE KEY `uni_jion_id` (`join_id`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位招聘表';
     */
    @Id
    private String join_id;

    private String join_department;

    private String join_position;

    private String join_duty;

    private String join_demand;

    private String join_position_state;
}
