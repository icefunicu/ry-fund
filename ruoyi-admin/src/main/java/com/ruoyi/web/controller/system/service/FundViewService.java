package com.ruoyi.web.controller.system.service;

import com.ruoyi.web.controller.system.domain.ExpensesUsed;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.domain.FundViewVo;

import java.util.List;

/**
 * @Author: mizy3
 * @Date: 2025/04/12/下午2:04
 * @Description:
 */
public interface FundViewService {

    List<FundProjectExecutions> selectFundProjectsList();

    int selectExecuteProjectsCount();

    int selectAcceptanceProjectsCount();

    int selectDeadlineProjectsCount();

    int selectTotleExpenses();

    List<FundProjects> selectAlertsList();

    List<ExpensesUsed> selectExpensesUsedList();

    int selectUsedExpense();
}
