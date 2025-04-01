package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectBudgetsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectBudgets;
import com.ruoyi.web.controller.system.service.IFundProjectBudgetsService;

/**
 * 项目经费预算记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectBudgetsServiceImpl implements IFundProjectBudgetsService
{
    @Autowired
    private FundProjectBudgetsMapper fundProjectBudgetsMapper;

    /**
     * 查询项目经费预算记录
     *
     * @param id 项目经费预算记录主键
     * @return 项目经费预算记录
     */
    @Override
    public FundProjectBudgets selectFundProjectBudgetsById(Long id)
    {
        return fundProjectBudgetsMapper.selectFundProjectBudgetsById(id);
    }

    /**
     * 查询项目经费预算记录列表
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 项目经费预算记录
     */
    @Override
    public List<FundProjectBudgets> selectFundProjectBudgetsList(FundProjectBudgets fundProjectBudgets)
    {
        return fundProjectBudgetsMapper.selectFundProjectBudgetsList(fundProjectBudgets);
    }

    /**
     * 新增项目经费预算记录
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 结果
     */
    @Override
    public int insertFundProjectBudgets(FundProjectBudgets fundProjectBudgets)
    {
        fundProjectBudgets.setCreateTime(DateUtils.getNowDate());
        return fundProjectBudgetsMapper.insertFundProjectBudgets(fundProjectBudgets);
    }

    /**
     * 修改项目经费预算记录
     *
     * @param fundProjectBudgets 项目经费预算记录
     * @return 结果
     */
    @Override
    public int updateFundProjectBudgets(FundProjectBudgets fundProjectBudgets)
    {
        return fundProjectBudgetsMapper.updateFundProjectBudgets(fundProjectBudgets);
    }

    /**
     * 批量删除项目经费预算记录
     *
     * @param ids 需要删除的项目经费预算记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectBudgetsByIds(Long[] ids)
    {
        return fundProjectBudgetsMapper.deleteFundProjectBudgetsByIds(ids);
    }

    /**
     * 删除项目经费预算记录信息
     *
     * @param id 项目经费预算记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectBudgetsById(Long id)
    {
        return fundProjectBudgetsMapper.deleteFundProjectBudgetsById(id);
    }
}
