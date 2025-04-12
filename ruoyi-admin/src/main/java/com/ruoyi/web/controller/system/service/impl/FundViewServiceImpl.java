package com.ruoyi.web.controller.system.service.impl;

import com.ruoyi.web.controller.system.domain.ExpensesUsed;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.domain.FundViewVo;
import com.ruoyi.web.controller.system.mapper.FundProjectsMapper;
import com.ruoyi.web.controller.system.mapper.FundViewMapper;
import com.ruoyi.web.controller.system.service.FundViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: mizy3
 * @Date: 2025/04/12/下午2:05
 * @Description:
 */
@Service
public class FundViewServiceImpl implements FundViewService {
    @Resource
    private FundViewMapper fundViewMapper;
    @Autowired
    private FundProjectsMapper fundProjectsMapper;
    @Override
    public List<FundProjectExecutions> selectFundProjectsList() {
        List<FundProjectExecutions> fundProjectExecutions = fundViewMapper.selectFundProjectsList();
        for (FundProjectExecutions fundProjectExecutions1 : fundProjectExecutions) {
            fundProjectExecutions1.setFundProjects(fundProjectsMapper.selectFundProjectsById(fundProjectExecutions1.getProjectId()));
        }
        return fundProjectExecutions ;
    }

    @Override
    public int selectExecuteProjectsCount() {
        return fundViewMapper.selectExecuteProjectsCount();
    }

    @Override
    public int selectAcceptanceProjectsCount() {
        return fundViewMapper.selectAcceptanceProjectsCount();
    }

    @Override
    public int selectDeadlineProjectsCount() {
        return fundViewMapper.selectDeadlineProjectsCount();
    }

    @Override
    public int selectTotleExpenses() {
        return fundViewMapper.selectTotleExpenses();
    }

    @Override
    public List<FundProjects> selectAlertsList() {
        return fundProjectsMapper.selectAlertsList();
    }

    @Override
    public List<ExpensesUsed> selectExpensesUsedList() {
        return fundViewMapper.selectExpensesUsedList();
    }

    @Override
    public int selectUsedExpense() {
        return fundViewMapper.selectUsedExpense();
    }

    @Override
    public int selectCheckingTotalCount() {
        return fundViewMapper.selectCheckingTotalCount();
    }

    @Override
    public int selectPassedTotalCount() {
        return fundViewMapper.selectPassedTotalCount();
    }

    @Override
    public int selectPassAndRejectCount() {
        return fundViewMapper.selectPassAndRejectCount();
    }
}
