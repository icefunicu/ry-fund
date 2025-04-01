package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目评审信息对象 fund_project_reviews
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public class FundProjectReviews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评审记录ID */
    private Long id;

    /** 项目ID（对应项目信息表） */
    @Excel(name = "项目ID", readConverterExp = "对=应项目信息表")
    private Long projectId;

    /** 评审专家ID（对应用户表） */
    @Excel(name = "评审专家ID", readConverterExp = "对=应用户表")
    private Long reviewerId;

    /** 评审打分 */
    @Excel(name = "评审打分")
    private BigDecimal score;

    /** 评审排名 */
    @Excel(name = "评审排名")
    private Long ranking;

    /** 评审意见 */
    @Excel(name = "评审意见")
    private String reviewComment;

    /** 评审时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评审时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewDate;

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

    public void setReviewerId(Long reviewerId)
    {
        this.reviewerId = reviewerId;
    }

    public Long getReviewerId()
    {
        return reviewerId;
    }

    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public BigDecimal getScore()
    {
        return score;
    }

    public void setRanking(Long ranking)
    {
        this.ranking = ranking;
    }

    public Long getRanking()
    {
        return ranking;
    }

    public void setReviewComment(String reviewComment)
    {
        this.reviewComment = reviewComment;
    }

    public String getReviewComment()
    {
        return reviewComment;
    }

    public void setReviewDate(Date reviewDate)
    {
        this.reviewDate = reviewDate;
    }

    public Date getReviewDate()
    {
        return reviewDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("reviewerId", getReviewerId())
            .append("score", getScore())
            .append("ranking", getRanking())
            .append("reviewComment", getReviewComment())
            .append("reviewDate", getReviewDate())
            .toString();
    }
}
