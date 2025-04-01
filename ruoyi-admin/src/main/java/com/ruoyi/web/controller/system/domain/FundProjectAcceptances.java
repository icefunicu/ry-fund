package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目验收信息对象 fund_project_acceptances
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectAcceptances extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 验收记录ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 结题报告文件路径 */
    @Excel(name = "结题报告文件路径")
    private String finalReport;

    /** 延期报告文件路径 */
    @Excel(name = "延期报告文件路径")
    private String delayReport;

    /** 延期时长（单位：月） */
    @Excel(name = "延期时长", readConverterExp = "单=位：月")
    private Long delayedTime;

    /** 验收状态 */
    @Excel(name = "验收状态")
    private String acceptanceStatus;

    /** 验收申请提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "验收申请提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acceptanceDate;

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

    public void setFinalReport(String finalReport)
    {
        this.finalReport = finalReport;
    }

    public String getFinalReport()
    {
        return finalReport;
    }

    public void setDelayReport(String delayReport)
    {
        this.delayReport = delayReport;
    }

    public String getDelayReport()
    {
        return delayReport;
    }

    public void setDelayedTime(Long delayedTime)
    {
        this.delayedTime = delayedTime;
    }

    public Long getDelayedTime()
    {
        return delayedTime;
    }

    public void setAcceptanceStatus(String acceptanceStatus)
    {
        this.acceptanceStatus = acceptanceStatus;
    }

    public String getAcceptanceStatus()
    {
        return acceptanceStatus;
    }

    public void setAcceptanceDate(Date acceptanceDate)
    {
        this.acceptanceDate = acceptanceDate;
    }

    public Date getAcceptanceDate()
    {
        return acceptanceDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("finalReport", getFinalReport())
            .append("delayReport", getDelayReport())
            .append("delayedTime", getDelayedTime())
            .append("acceptanceStatus", getAcceptanceStatus())
            .append("acceptanceDate", getAcceptanceDate())
            .toString();
    }
}
