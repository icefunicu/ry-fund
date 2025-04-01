package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectExpensesMapper;
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;
import com.ruoyi.web.controller.system.service.IFundProjectExpensesService;

/**
 * 项目费用记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectExpensesServiceImpl implements IFundProjectExpensesService
{
    @Autowired
    private FundProjectExpensesMapper fundProjectExpensesMapper;

    /**
     * 查询项目费用记录
     *
     * @param id 项目费用记录主键
     * @return 项目费用记录
     */
    @Override
    public FundProjectExpenses selectFundProjectExpensesById(String id)
    {
        return fundProjectExpensesMapper.selectFundProjectExpensesById(id);
    }

    /**
     * 查询项目费用记录列表
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 项目费用记录
     */
    @Override
    public List<FundProjectExpenses> selectFundProjectExpensesList(FundProjectExpenses fundProjectExpenses)
    {
        return fundProjectExpensesMapper.selectFundProjectExpensesList(fundProjectExpenses);
    }

    /**
     * 新增项目费用记录
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 结果
     */
    @Override
    public int insertFundProjectExpenses(FundProjectExpenses fundProjectExpenses)
    {
        return fundProjectExpensesMapper.insertFundProjectExpenses(fundProjectExpenses);
    }

    /**
     * 修改项目费用记录
     *
     * @param fundProjectExpenses 项目费用记录
     * @return 结果
     */
    @Override
    public int updateFundProjectExpenses(FundProjectExpenses fundProjectExpenses)
    {
        return fundProjectExpensesMapper.updateFundProjectExpenses(fundProjectExpenses);
    }

    /**
     * 批量删除项目费用记录
     *
     * @param ids 需要删除的项目费用记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExpensesByIds(String[] ids)
    {
        return fundProjectExpensesMapper.deleteFundProjectExpensesByIds(ids);
    }

    /**
     * 删除项目费用记录信息
     *
     * @param id 项目费用记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExpensesById(String id)
    {
        return fundProjectExpensesMapper.deleteFundProjectExpensesById(id);
    }
}
