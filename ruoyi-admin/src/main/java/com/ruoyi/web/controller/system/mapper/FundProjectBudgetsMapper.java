package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectBudgets;

/**
 * 项目经费预算记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectBudgetsMapper
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
     * 删除项目经费预算记录
     *
     * @param id 项目经费预算记录主键
     * @return 结果
     */
    public int deleteFundProjectBudgetsById(Long id);

    /**
     * 批量删除项目经费预算记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectBudgetsByIds(Long[] ids);
}
