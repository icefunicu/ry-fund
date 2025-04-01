package com.ruoyi.web.controller.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目通知提醒对象 fund_project_notifications
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectNotifications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 通知ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 通知接收用户ID（对应用户表） */
    @Excel(name = "通知接收用户ID", readConverterExp = "对=应用户表")
    private Long userId;

    /** 通知类型 */
    @Excel(name = "通知类型")
    private String notificationType;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String content;

    /** 是否已读：0-未读，1-已读 */
    @Excel(name = "是否已读：0-未读，1-已读")
    private Integer isRead;

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

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setNotificationType(String notificationType)
    {
        this.notificationType = notificationType;
    }

    public String getNotificationType()
    {
        return notificationType;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public void setIsRead(Integer isRead)
    {
        this.isRead = isRead;
    }

    public Integer getIsRead()
    {
        return isRead;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("userId", getUserId())
            .append("notificationType", getNotificationType())
            .append("content", getContent())
            .append("isRead", getIsRead())
            .append("createTime", getCreateTime())
            .toString();
    }
}
