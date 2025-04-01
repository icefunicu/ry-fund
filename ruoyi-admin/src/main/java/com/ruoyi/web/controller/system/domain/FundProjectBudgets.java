package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目经费预算记录对象 fund_project_budgets
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectBudgets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预算记录ID */
    private Long id;

    /** 项目ID（对应fund_projects） */
    @Excel(name = "项目ID", readConverterExp = "对=应fund_projects")
    private Long projectId;

    /** 经费支出类型 */
    @Excel(name = "经费支出类型")
    private String expenseType;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private BigDecimal budget;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }

    public void setExpenseType(String expenseType)
    {
        this.expenseType = expenseType;
    }

    public String getExpenseType()
    {
        return expenseType;
    }

    public void setBudget(BigDecimal budget)
    {
        this.budget = budget;
    }

    public BigDecimal getBudget()
    {
        return budget;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("expenseType", getExpenseType())
            .append("budget", getBudget())
            .append("createTime", getCreateTime())
            .toString();
    }
}
