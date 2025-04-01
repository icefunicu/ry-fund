package com.ruoyi.web.controller.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统预警提醒对象 fund_alerts
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundAlerts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预警ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    /** 预警类型，如“进度预警”、“经费预警” */
    @Excel(name = "预警类型，如“进度预警”、“经费预警”")
    private String alertType;

    /** 预警消息内容 */
    @Excel(name = "预警消息内容")
    private String message;

    /** 是否已读：0-未读，1-已读 */
    @Excel(name = "是否已读：0-未读，1-已读")
    private Integer isRead;

    /** 预警生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预警生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

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

    public void setAlertType(String alertType)
    {
        this.alertType = alertType;
    }

    public String getAlertType()
    {
        return alertType;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setIsRead(Integer isRead)
    {
        this.isRead = isRead;
    }

    public Integer getIsRead()
    {
        return isRead;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("alertType", getAlertType())
            .append("message", getMessage())
            .append("isRead", getIsRead())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
