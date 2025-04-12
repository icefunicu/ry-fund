package com.ruoyi.web.controller.system.mapper;

import com.ruoyi.web.controller.system.domain.ExpensesUsed;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.domain.FundViewVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: mizy3
 * @Date: 2025/04/12/下午2:07
 * @Description:
 */
public interface FundViewMapper {


    List<FundProjectExecutions> selectFundProjectsList();

    int selectExecuteProjectsCount();

    int selectAcceptanceProjectsCount();

    int selectDeadlineProjectsCount();

    int selectTotleExpenses();


    List<ExpensesUsed> selectExpensesUsedList();

    int selectUsedExpense();

    int selectCheckingTotalCount();

    int selectPassedTotalCount();

    int selectPassAndRejectCount();
}
