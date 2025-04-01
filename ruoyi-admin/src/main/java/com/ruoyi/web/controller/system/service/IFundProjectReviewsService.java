package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectReviews;

/**
 * 项目评审记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectReviewsService
{
    /**
     * 查询项目评审记录
     *
     * @param id 项目评审记录主键
     * @return 项目评审记录
     */
    public FundProjectReviews selectFundProjectReviewsById(String id);

    /**
     * 查询项目评审记录列表
     *
     * @param fundProjectReviews 项目评审记录
     * @return 项目评审记录集合
     */
    public List<FundProjectReviews> selectFundProjectReviewsList(FundProjectReviews fundProjectReviews);

    /**
     * 新增项目评审记录
     *
     * @param fundProjectReviews 项目评审记录
     * @return 结果
     */
    public int insertFundProjectReviews(FundProjectReviews fundProjectReviews);

    /**
     * 修改项目评审记录
     *
     * @param fundProjectReviews 项目评审记录
     * @return 结果
     */
    public int updateFundProjectReviews(FundProjectReviews fundProjectReviews);

    /**
     * 批量删除项目评审记录
     *
     * @param ids 需要删除的项目评审记录主键集合
     * @return 结果
     */
    public int deleteFundProjectReviewsByIds(String[] ids);

    /**
     * 删除项目评审记录信息
     *
     * @param id 项目评审记录主键
     * @return 结果
     */
    public int deleteFundProjectReviewsById(String id);
}
