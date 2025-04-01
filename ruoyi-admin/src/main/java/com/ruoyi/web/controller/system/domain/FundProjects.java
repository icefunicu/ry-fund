package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目信息对象 fund_projects
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjects extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 申请人ID */
    @Excel(name = "申请人ID")
    private Long applicantId;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String description;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String status;

    /** 项目开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 项目结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setApplicantId(Long applicantId)
    {
        this.applicantId = applicantId;
    }

    public Long getApplicantId()
    {
        return applicantId;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
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

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("applicantId", getApplicantId())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
