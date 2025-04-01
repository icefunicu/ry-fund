package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目申请信息对象 fund_project_applications
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectApplications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 上传的Word文件路径（项目申请书） */
    @Excel(name = "上传的Word文件路径", readConverterExp = "项=目申请书")
    private String wordFilePath;

    /** 论证报告文件路径 */
    @Excel(name = "论证报告文件路径")
    private String demonstrationReport;

    /** 申请提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

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

    public void setWordFilePath(String wordFilePath)
    {
        this.wordFilePath = wordFilePath;
    }

    public String getWordFilePath()
    {
        return wordFilePath;
    }

    public void setDemonstrationReport(String demonstrationReport)
    {
        this.demonstrationReport = demonstrationReport;
    }

    public String getDemonstrationReport()
    {
        return demonstrationReport;
    }

    public void setApplicationDate(Date applicationDate)
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate()
    {
        return applicationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("wordFilePath", getWordFilePath())
            .append("demonstrationReport", getDemonstrationReport())
            .append("applicationDate", getApplicationDate())
            .toString();
    }
}
