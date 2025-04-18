package com.ruoyi.web.controller.system.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.mapper.FundProjectExecutionsMapper;
import com.ruoyi.web.controller.system.mapper.FundProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectReviewsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectReviews;
import com.ruoyi.web.controller.system.service.IFundProjectReviewsService;

/**
 * 项目评审记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectReviewsServiceImpl implements IFundProjectReviewsService
{
    @Autowired
    private FundProjectReviewsMapper fundProjectReviewsMapper;
    @Autowired
    private FundProjectsMapper fundProjectsMapper;
    @Autowired
    private FundProjectExecutionsMapper fundProjectExecutionsMapper;
    /**
     * 查询项目评审记录
     *
     * @param id 项目评审记录主键
     * @return 项目评审记录
     */
    @Override
    public FundProjectReviews selectFundProjectReviewsById(String id)
    {
        return fundProjectReviewsMapper.selectFundProjectReviewsById(id);
    }

    /**
     * 查询项目评审记录列表
     *
     * @param fundProjectReviews 项目评审记录
     * @return 项目评审记录
     */
    @Override
    public List<FundProjectReviews> selectFundProjectReviewsList(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.selectFundProjectReviewsList(fundProjectReviews);
    }

    /**
     * 新增项目评审记录
     *
     * @param fundProjectReviews 项目评审记录
     * @return 结果
     */
    @Override
    public int insertFundProjectReviews(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.insertFundProjectReviews(fundProjectReviews);
    }

    /**
     * 修改项目评审记录
     *
     * @param fundProjectReviews 项目评审记录
     * @return 结果
     */
    @Override
    public int updateFundProjectReviews(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.updateFundProjectReviews(fundProjectReviews);
    }

    /**
     * 批量删除项目评审记录
     *
     * @param ids 需要删除的项目评审记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectReviewsByIds(String[] ids)
    {
        return fundProjectReviewsMapper.deleteFundProjectReviewsByIds(ids);
    }

    /**
     * 删除项目评审记录信息
     *
     * @param id 项目评审记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectReviewsById(String id)
    {
        return fundProjectReviewsMapper.deleteFundProjectReviewsById(id);
    }
    /**
     * 通过项目评审
     * */
    @Override
    public int pass(FundProjectReviews fundProjectReviews)
    {
        FundProjects fundProjects = fundProjectsMapper.selectFundProjectsById(fundProjectReviews.getProjectId());
        fundProjects.setStatus("执行中");
        fundProjectsMapper.updateFundProjects(fundProjects);
        FundProjectExecutions fundProjectExecutions = new FundProjectExecutions();
        fundProjectExecutions.setProjectId(fundProjectReviews.getProjectId());
        fundProjectExecutions.setExecutionStatus("进行中");
        fundProjectExecutions.setProgress(0L);
        fundProjectExecutionsMapper.insertFundProjectExecutions(fundProjectExecutions);
        return fundProjectReviewsMapper.insertFundProjectReviews(fundProjectReviews);
    }

    @Override
    public int reject(FundProjectReviews fundProjectReviews) {
        FundProjects fundProjects = fundProjectsMapper.selectFundProjectsById(fundProjectReviews.getProjectId());
        fundProjects.setStatus("驳回");
        fundProjectsMapper.updateFundProjects(fundProjects);
        fundProjectReviews.setComments(fundProjectReviews.getReason());
        return fundProjectReviewsMapper.insertFundProjectReviews(fundProjectReviews);
    }

    @Override
    public List<FundProjectReviews> getReason(FundProjectReviews fundProjectReviews) {
        return fundProjectReviewsMapper.getReasonByProjectId(fundProjectReviews.getProjectId());
    }


}
