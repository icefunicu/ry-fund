package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectReviewsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectReviews;
import com.ruoyi.web.controller.system.service.IFundProjectReviewsService;

/**
 * 项目评审信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectReviewsServiceImpl implements IFundProjectReviewsService
{
    @Autowired
    private FundProjectReviewsMapper fundProjectReviewsMapper;

    /**
     * 查询项目评审信息
     *
     * @param id 项目评审信息主键
     * @return 项目评审信息
     */
    @Override
    public FundProjectReviews selectFundProjectReviewsById(Long id)
    {
        return fundProjectReviewsMapper.selectFundProjectReviewsById(id);
    }

    /**
     * 查询项目评审信息列表
     *
     * @param fundProjectReviews 项目评审信息
     * @return 项目评审信息
     */
    @Override
    public List<FundProjectReviews> selectFundProjectReviewsList(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.selectFundProjectReviewsList(fundProjectReviews);
    }

    /**
     * 新增项目评审信息
     *
     * @param fundProjectReviews 项目评审信息
     * @return 结果
     */
    @Override
    public int insertFundProjectReviews(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.insertFundProjectReviews(fundProjectReviews);
    }

    /**
     * 修改项目评审信息
     *
     * @param fundProjectReviews 项目评审信息
     * @return 结果
     */
    @Override
    public int updateFundProjectReviews(FundProjectReviews fundProjectReviews)
    {
        return fundProjectReviewsMapper.updateFundProjectReviews(fundProjectReviews);
    }

    /**
     * 批量删除项目评审信息
     *
     * @param ids 需要删除的项目评审信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectReviewsByIds(Long[] ids)
    {
        return fundProjectReviewsMapper.deleteFundProjectReviewsByIds(ids);
    }

    /**
     * 删除项目评审信息信息
     *
     * @param id 项目评审信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectReviewsById(Long id)
    {
        return fundProjectReviewsMapper.deleteFundProjectReviewsById(id);
    }
}
