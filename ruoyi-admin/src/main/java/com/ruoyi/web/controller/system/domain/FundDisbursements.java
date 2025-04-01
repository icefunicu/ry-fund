package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目经费拨付记录对象 fund_disbursements
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundDisbursements extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 拨付记录ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    /** 拨付类型 */
    @Excel(name = "拨付类型")
    private String disbursementType;

    /** 拨付金额 */
    @Excel(name = "拨付金额")
    private BigDecimal amount;

    /** 申请拨款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请拨款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requestDate;

    /** 拨款备注 */
    @Excel(name = "拨款备注")
    private String remarks;

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

    public void setDisbursementType(String disbursementType)
    {
        this.disbursementType = disbursementType;
    }

    public String getDisbursementType()
    {
        return disbursementType;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setRequestDate(Date requestDate)
    {
        this.requestDate = requestDate;
    }

    public Date getRequestDate()
    {
        return requestDate;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("disbursementType", getDisbursementType())
            .append("amount", getAmount())
            .append("requestDate", getRequestDate())
            .append("remarks", getRemarks())
            .toString();
    }
}
