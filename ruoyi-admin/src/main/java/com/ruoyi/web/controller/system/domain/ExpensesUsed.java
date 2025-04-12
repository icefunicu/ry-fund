package com.ruoyi.web.controller.system.domain;

import lombok.Data;

@Data
public class ExpensesUsed {

    private String  ExpenseType;
    //对应数量的百分比
    private int  ExpensePercent;
}
