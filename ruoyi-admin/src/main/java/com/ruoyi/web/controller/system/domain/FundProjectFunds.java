package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目经费支出记录对象 fund_project_funds
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectFunds extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 经费记录ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 经费支出类型 */
    @Excel(name = "经费支出类型")
    private String expenseType;

    /** 支出金额 */
    @Excel(name = "支出金额")
    private BigDecimal amount;

    /** 支出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expenseDate;

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

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setExpenseDate(Date expenseDate)
    {
        this.expenseDate = expenseDate;
    }

    public Date getExpenseDate()
    {
        return expenseDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("expenseType", getExpenseType())
            .append("amount", getAmount())
            .append("expenseDate", getExpenseDate())
            .append("remark", getRemark())
            .toString();
    }
}
