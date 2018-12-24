package com.eim.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 管理员用户表
 * Created by Zy on 2018/12/24.
 */
@DynamicUpdate
@Data
@Entity
@Table(name = "user")
public class User {
    /**
     * CREATE TABLE `user` (
     `id` varchar(128) NOT NULL,
     `name` varchar(12) NOT NULL,
     `password` varchar(32) NOT NULL DEFAULT '123',
     `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */
    @Id
    private String id;

    private String name;

    private String password;

    private Date update_time;

}
