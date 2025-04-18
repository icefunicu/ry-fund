package com.ruoyi.web.controller.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目评审记录对象 fund_project_reviews
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Data
public class FundProjectReviews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评审记录ID */
    private String id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String projectId;

    /** 评审专家ID */
    @Excel(name = "评审专家ID")
    private String expertId;

    /** 评审分数 */
    @Excel(name = "评审分数")
    private BigDecimal score;

    /** 评审意见 */
    @Excel(name = "评审意见")
    private String comments;

    /** 评审时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评审时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewDate;

    private FundProjects fundProjects;

    private String reason;
}
