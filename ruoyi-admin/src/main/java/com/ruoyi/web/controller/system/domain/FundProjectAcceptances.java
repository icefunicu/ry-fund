package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目验收记录对象 fund_project_acceptances
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectAcceptances extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 验收记录ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    /** 结题报告文件路径 */
    @Excel(name = "结题报告文件路径")
    private String finalReport;

    /** 延期报告文件路径 */
    @Excel(name = "延期报告文件路径")
    private String extensionReport;

    /** 延期时长（单位：月） */
    @Excel(name = "延期时长", readConverterExp = "单=位：月")
    private Long extensionTime;

    /** 验收状态 */
    @Excel(name = "验收状态")
    private String acceptanceStatus;

    /** 验收评审意见 */
    @Excel(name = "验收评审意见")
    private String reviewComments;

    /** 报告提交日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告提交日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionDate;


    private List<String> commonList;

    public List<String> getCommonList() {
        return commonList;
    }

    public void setCommonList(List<String> commonList) {
        this.commonList = commonList;
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

    public void setFinalReport(String finalReport)
    {
        this.finalReport = finalReport;
    }

    public String getFinalReport()
    {
        return finalReport;
    }

    public void setExtensionReport(String extensionReport)
    {
        this.extensionReport = extensionReport;
    }

    public String getExtensionReport()
    {
        return extensionReport;
    }

    public void setExtensionTime(Long extensionTime)
    {
        this.extensionTime = extensionTime;
    }

    public Long getExtensionTime()
    {
        return extensionTime;
    }

    public void setAcceptanceStatus(String acceptanceStatus)
    {
        this.acceptanceStatus = acceptanceStatus;
    }

    public String getAcceptanceStatus()
    {
        return acceptanceStatus;
    }

    public void setReviewComments(String reviewComments)
    {
        this.reviewComments = reviewComments;
    }

    public String getReviewComments()
    {
        return reviewComments;
    }

    public void setSubmissionDate(Date submissionDate)
    {
        this.submissionDate = submissionDate;
    }

    public Date getSubmissionDate()
    {
        return submissionDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("finalReport", getFinalReport())
            .append("extensionReport", getExtensionReport())
            .append("extensionTime", getExtensionTime())
            .append("acceptanceStatus", getAcceptanceStatus())
            .append("reviewComments", getReviewComments())
            .append("submissionDate", getSubmissionDate())
            .toString();
    }
}
