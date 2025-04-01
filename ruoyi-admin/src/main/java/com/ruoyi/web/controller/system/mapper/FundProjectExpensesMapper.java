package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;

/**
 * 项目费用记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectExpensesMapper
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
     * 删除项目费用记录
     *
     * @param id 项目费用记录主键
     * @return 结果
     */
    public int deleteFundProjectExpensesById(String id);

    /**
     * 批量删除项目费用记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectExpensesByIds(String[] ids);
}
