package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目执行记录对象 fund_project_executions
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Data
public class FundProjectExecutions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 执行记录ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    private String title;
    private String status;
    /** 中期报告文件路径 */
    @Excel(name = "中期报告文件路径")
    private String midTermReport;

    /** 中期报告提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "中期报告提交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date midTermDate;

    /** 执行状态 */
    @Excel(name = "执行状态")
    private String executionStatus;

    /** 项目进度（百分比） */
    @Excel(name = "项目进度", readConverterExp = "百=分比")
    private Long progress;

    /** 执行备注 */
    @Excel(name = "执行备注")
    private String remarks;

    private FundProjects fundProjects;

    private List<FundProjectExpenses> fundProjectExpenses;

    public List<FundProjectExpenses> getFundProjectExpenses() {
        return fundProjectExpenses;
    }
    public void setFundProjectExpenses(List<FundProjectExpenses> fundProjectExpenses) {
        this.fundProjectExpenses = fundProjectExpenses;
    }

    public FundProjects getFundProjects() {
        return fundProjects;
    }
    public void setFundProjects(FundProjects fundProjects) {
        this.fundProjects = fundProjects;
    }

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

    public void setMidTermReport(String midTermReport)
    {
        this.midTermReport = midTermReport;
    }

    public String getMidTermReport()
    {
        return midTermReport;
    }

    public void setMidTermDate(Date midTermDate)
    {
        this.midTermDate = midTermDate;
    }

    public Date getMidTermDate()
    {
        return midTermDate;
    }

    public void setExecutionStatus(String executionStatus)
    {
        this.executionStatus = executionStatus;
    }

    public String getExecutionStatus()
    {
        return executionStatus;
    }

    public void setProgress(Long progress)
    {
        this.progress = progress;
    }

    public Long getProgress()
    {
        return progress;
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
            .append("midTermReport", getMidTermReport())
            .append("midTermDate", getMidTermDate())
            .append("executionStatus", getExecutionStatus())
            .append("progress", getProgress())
            .append("remarks", getRemarks())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
