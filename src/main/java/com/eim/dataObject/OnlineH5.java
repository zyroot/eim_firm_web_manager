package com.eim.dataObject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Zy on 2018/12/25.
 */
@Data
@Entity
@Table(name = "online_h5")
public class OnlineH5 {
    /**
     * CREATE TABLE `online_h5` (
     `h5_id` varchar(55) NOT NULL,
     `h5_img` varchar(55) NOT NULL,
     `h5_title` varchar(55) NOT NULL,
     `h5_code` varchar(55) NOT NULL,
     `h5_sort` int(11) NOT NULL,
     `h5_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
     `h5_state` varchar(2000) NOT NULL COMMENT 'h5描述',
     PRIMARY KEY (`h5_id`),
     UNIQUE KEY `uni_h5_id` (`h5_id`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线上h5';
     */
    @Id
    @Column(name = "h5_id")
    private String h5Id;

    @Column(name = "h5_img")
    private String h5Img;

    @Column(name = "h5_title")
    private String h5Title;

    @Column(name = "h5_code")
    private String h5Code;

    @Column(name = "h5_sort")
    private Integer h5Sort;

    @Column(name = "h5_time")
    private Date h5Time;

    @Column(name = "h5_state")
    private String h5State;


}
