package com.ruoyi.web.controller.system.domain;

import lombok.Data;

@Data
public class ExpensesUsed {

    private String  expenseType;
    //对应数量的百分比
    private int  expensePercent;
}
