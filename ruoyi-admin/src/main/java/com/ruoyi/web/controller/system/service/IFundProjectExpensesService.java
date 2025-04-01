package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;

/**
 * 项目费用记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectExpensesService
{
    /**
     * 查询项目费用记录
     *
     * @param id 项目费用记录主键
     * @return 项目费用记录
     */
    public FundProjectExpenses selectFundProjectExpensesById(String id);

    /**
     * 查询项目费用记录列表
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 项目费用记录集合
     */
    public List<FundProjectExpenses> selectFundProjectExpensesList(FundProjectExpenses fundProjectExpenses);

    /**
     * 新增项目费用记录
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 结果
     */
    public int insertFundProjectExpenses(FundProjectExpenses fundProjectExpenses);

    /**
     * 修改项目费用记录
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 结果
     */
    public int updateFundProjectExpenses(FundProjectExpenses fundProjectExpenses);

    /**
     * 批量删除项目费用记录
     *
     * @param ids 需要删除的项目费用记录主键集合
     * @return 结果
     */
    public int deleteFundProjectExpensesByIds(String[] ids);

    /**
     * 删除项目费用记录信息
     *
     * @param id 项目费用记录主键
     * @return 结果
     */
    public int deleteFundProjectExpensesById(String id);
}
