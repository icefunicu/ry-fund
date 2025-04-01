package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目执行信息对象 fund_project_executions
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectExecutions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 执行记录ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 中期报告文件路径 */
    @Excel(name = "中期报告文件路径")
    private String midtermReport;

    /** 项目执行状态 */
    @Excel(name = "项目执行状态")
    private String executionStatus;

    /** 经费拨付类型 */
    @Excel(name = "经费拨付类型")
    private String fundType;

    /** 经费拨付状态 */
    @Excel(name = "经费拨付状态")
    private String fundStatus;

    /** 执行记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "执行记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date executionDate;

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

    public void setMidtermReport(String midtermReport)
    {
        this.midtermReport = midtermReport;
    }

    public String getMidtermReport()
    {
        return midtermReport;
    }

    public void setExecutionStatus(String executionStatus)
    {
        this.executionStatus = executionStatus;
    }

    public String getExecutionStatus()
    {
        return executionStatus;
    }

    public void setFundType(String fundType)
    {
        this.fundType = fundType;
    }

    public String getFundType()
    {
        return fundType;
    }

    public void setFundStatus(String fundStatus)
    {
        this.fundStatus = fundStatus;
    }

    public String getFundStatus()
    {
        return fundStatus;
    }

    public void setExecutionDate(Date executionDate)
    {
        this.executionDate = executionDate;
    }

    public Date getExecutionDate()
    {
        return executionDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("midtermReport", getMidtermReport())
            .append("executionStatus", getExecutionStatus())
            .append("fundType", getFundType())
            .append("fundStatus", getFundStatus())
            .append("executionDate", getExecutionDate())
            .toString();
    }
}
