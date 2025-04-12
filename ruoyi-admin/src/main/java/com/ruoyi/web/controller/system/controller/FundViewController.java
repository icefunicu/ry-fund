package com.ruoyi.web.controller.system.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.system.domain.FundViewVo;
import com.ruoyi.web.controller.system.service.FundViewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/view")
public class FundViewController {

    @Resource
    public FundViewService fundViewService;

    //首页大屏数据展示接口
    @RequestMapping("/index")
    public AjaxResult index(){
        FundViewVo fundViewVo = new FundViewVo();
        //查询项目列表
        fundViewVo.setFundProjectsList(fundViewService.selectFundProjectsList());
        //查询执行中的项目数量
        fundViewVo.setExecuteProjectsCount(fundViewService.selectExecuteProjectsCount());
        //查询验收中的项目数量
        fundViewVo.setAcceptanceProjectsCount(fundViewService.selectAcceptanceProjectsCount());
        //查询逾期的项目数量
        fundViewVo.setDeadlineProjectsCount(fundViewService.selectDeadlineProjectsCount());
        //查询总支出金额
        fundViewVo.setTotleExpenses(fundViewService.selectTotleExpenses());
        //查询预警列表
        fundViewVo.setAlertsList(fundViewService.selectAlertsList());
        //查询支出类型统计列表
        fundViewVo.setExpensesUsedList(fundViewService.selectExpensesUsedList());
        return AjaxResult.success(fundViewVo);
    }

}
