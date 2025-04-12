package com.ruoyi.web.controller.system.controller;

import com.ruoyi.web.controller.system.domain.FundViewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/view")
public class FundViewController {
    @Autowired
    public FundViewService fundViewService;

    //首页大屏数据展示接口
    @RequestMapping("/index")
    public FundViewVo index(){
        FundViewVo fundViewVo = new FundViewVo();
        //查询项目列表
        fundViewVo.setFundProjectsList(fundViewService.selectFundProjectsList(fundViewVo););
        //查询执行中的项目数量
        fundViewVo.setExecuteProjectsCount();
        //查询验收中的项目数量

        //查询逾期的项目数量

        //查询总支出金额

        //查询预警列表

        //查询支出类型统计列表

        return fundViewVo;
    }

}
