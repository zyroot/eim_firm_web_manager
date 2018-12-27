package com.eim.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Zy on 2018/12/26.
 */
@Data
public class OnlineH5Form {

    private String h5Id;

    @NotEmpty(message = "图片不能为空")
    private String h5Img;

    @NotEmpty(message = "标题不能为空")
    private String h5Title;

    @NotEmpty(message = "二维码不能为空")
    private String h5Code;

    @NotNull(message = "排序字段不能为空")
    private Integer h5Sort;

    @Past(message = "日期不能为空")
    private Date h5Time;

    @NotEmpty(message = "描述不能为空")
    private String h5State;
}
