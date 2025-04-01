package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectBudgets;

/**
 * 项目经费预算记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectBudgetsService
{
    /**
     * 查询项目经费预算记录
     *
     * @param id 项目经费预算记录主键
     * @return 项目经费预算记录
     */
    public FundProjectBudgets selectFundProjectBudgetsById(Long id);

    /**
     * 查询项目经费预算记录列表
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 项目经费预算记录集合
     */
    public List<FundProjectBudgets> selectFundProjectBudgetsList(FundProjectBudgets fundProjectBudgets);

    /**
     * 新增项目经费预算记录
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 结果
     */
    public int insertFundProjectBudgets(FundProjectBudgets fundProjectBudgets);

    /**
     * 修改项目经费预算记录
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 结果
     */
    public int updateFundProjectBudgets(FundProjectBudgets fundProjectBudgets);

    /**
     * 批量删除项目经费预算记录
     *
     * @param ids 需要删除的项目经费预算记录主键集合
     * @return 结果
     */
    public int deleteFundProjectBudgetsByIds(Long[] ids);

    /**
     * 删除项目经费预算记录信息
     *
     * @param id 项目经费预算记录主键
     * @return 结果
     */
    public int deleteFundProjectBudgetsById(Long id);
}
