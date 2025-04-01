package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目费用记录对象 fund_project_expenses
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectExpenses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 费用记录ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    /** 费用类型（如出差、耗材） */
    @Excel(name = "费用类型", readConverterExp = "如=出差、耗材")
    private String expenseType;

    /** 费用金额 */
    @Excel(name = "费用金额")
    private BigDecimal expenseAmount;

    /** 费用发生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "费用发生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expenseDate;

    /** 费用说明 */
    @Excel(name = "费用说明")
    private String description;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getProjectId()
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

    public void setExpenseAmount(BigDecimal expenseAmount)
    {
        this.expenseAmount = expenseAmount;
    }

    public BigDecimal getExpenseAmount()
    {
        return expenseAmount;
    }

    public void setExpenseDate(Date expenseDate)
    {
        this.expenseDate = expenseDate;
    }

    public Date getExpenseDate()
    {
        return expenseDate;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("expenseType", getExpenseType())
            .append("expenseAmount", getExpenseAmount())
            .append("expenseDate", getExpenseDate())
            .append("description", getDescription())
            .toString();
    }
}
