package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目基本信息对象 fund_projects
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjects extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private String id;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private String applicantId;

    /** 项目标题 */
    @Excel(name = "项目标题")
    private String title;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String description;

    /** 项目申请书文件路径 */
    @Excel(name = "项目申请书文件路径")
    private String applicationFile;

    /** 论证报告文件路径 */
    @Excel(name = "论证报告文件路径")
    private String demonstrationFile;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyDate;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String status;

    /** 项目开始日期（项目通过后确定） */
    @Excel(name = "项目开始日期", readConverterExp = "项=目通过后确定")
    private Date startDate;

    /** 项目截止日期（可因延期调整） */
    @Excel(name = "项目截止日期", readConverterExp = "可=因延期调整")
    private Date deadline;

    /** 项目预算金额 */
    @Excel(name = "项目预算金额")
    private BigDecimal budget;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 记录更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setApplicantId(String applicantId)
    {
        this.applicantId = applicantId;
    }

    public String getApplicantId()
    {
        return applicantId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setApplicationFile(String applicationFile)
    {
        this.applicationFile = applicationFile;
    }

    public String getApplicationFile()
    {
        return applicationFile;
    }

    public void setDemonstrationFile(String demonstrationFile)
    {
        this.demonstrationFile = demonstrationFile;
    }

    public String getDemonstrationFile()
    {
        return demonstrationFile;
    }

    public void setApplyDate(Date applyDate)
    {
        this.applyDate = applyDate;
    }

    public Date getApplyDate()
    {
        return applyDate;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }

    public Date getDeadline()
    {
        return deadline;
    }

    public void setBudget(BigDecimal budget)
    {
        this.budget = budget;
    }

    public BigDecimal getBudget()
    {
        return budget;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applicantId", getApplicantId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("applicationFile", getApplicationFile())
            .append("demonstrationFile", getDemonstrationFile())
            .append("applyDate", getApplyDate())
            .append("status", getStatus())
            .append("startDate", getStartDate())
            .append("deadline", getDeadline())
            .append("budget", getBudget())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
