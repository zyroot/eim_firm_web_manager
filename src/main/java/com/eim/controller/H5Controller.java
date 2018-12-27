package com.eim.controller;

import com.eim.Vo.AjaxTableResultVo;
import com.eim.Vo.ResultVo;
import com.eim.dataObject.OnlineH5;
import com.eim.enums.ExceptionEnums;
import com.eim.exception.WebException;
import com.eim.form.OnlineH5Form;
import com.eim.repository.OnlineH5Repository;
import com.eim.service.OnlineH5Service;
import com.eim.util.AjaxTableResultVoUtil;
import com.eim.util.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Zy on 2018/12/25.
 */
@Slf4j
@Controller
@RequestMapping("/category/h5")
public class H5Controller {

    @Autowired
    private OnlineH5Repository onlineH5Repository;

    @Autowired
    private AjaxTableResultVoUtil ajaxTableResultVoUtil;

    @Autowired
    private OnlineH5Service onlineH5Service;

    @GetMapping("/h5.do")
    public String h5Page(){
        return "category/h5";
    }

    /**
     * 分页查询
     * @return
     */
    @ResponseBody
    @GetMapping("/list.do")
    public String list(@RequestParam(name = "page",defaultValue = "1")Integer page,
                       @RequestParam(name = "rows",defaultValue = "10")Integer size){
        Page<OnlineH5> h5Page = onlineH5Repository.findAll(new PageRequest((page - 1), size));
        return ajaxTableResultVoUtil.getResult(h5Page.getTotalElements(), h5Page.getContent());
    }

    /**
     * 修改
     */
    @ResponseBody
    @PostMapping("/update.do")
    public ResultVo update(@Valid OnlineH5Form onlineH5,BindingResult result){
        try {
            if(result.hasErrors()|| StringUtils.isEmpty(onlineH5.getH5Id())){
                log.error("【h5保存】 参数不正确 result={}",result);
                throw new WebException(ExceptionEnums.PARAMS_ERROE.getCode(),result.getFieldError().getDefaultMessage());
            }
            onlineH5Service.update(onlineH5);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVoUtil.error();
        }
        return ResultVoUtil.success();
    }
    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save.do")
    public ResultVo save(@Valid OnlineH5Form onlineH5Form, BindingResult result){
        try {
            if(result.hasErrors()){
                log.error("【h5保存】 参数不正确 result={}",result);
                throw new WebException(ExceptionEnums.PARAMS_ERROE.getCode(),result.getFieldError().getDefaultMessage());
            }
            onlineH5Service.save(onlineH5Form);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVoUtil.error();
        }
        return ResultVoUtil.success();
    }

    /**
     *
     * @param idlist 删除的id 字符串
     * @return
     */
    @ResponseBody
    @PostMapping("/delete.do")
    public ResultVo delete(@RequestParam("idlist")String idlist){
        String[] split = idlist.split(",");
        List<String> idStrings = Arrays.asList(split);
        try {
            onlineH5Service.delete(idStrings);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【h5删除操作】 删除失败");
            return ResultVoUtil.error();
        }
        return ResultVoUtil.success();
    }
}
