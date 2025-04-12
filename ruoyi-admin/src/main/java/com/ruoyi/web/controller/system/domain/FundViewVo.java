package com.ruoyi.web.controller.system.domain;

import lombok.Data;

import java.util.List;

@Data
public class FundViewVo {

    private List<FundProjects> fundProjectsList;

    private int executeProjectsCount;

    private int acceptanceProjectsCount;

    private int deadlineProjectsCount;

    private int totleExpenses;

    private List<FundProjects> alertsList;

    private List<ExpensesUsed> expensesUsedList;
}
