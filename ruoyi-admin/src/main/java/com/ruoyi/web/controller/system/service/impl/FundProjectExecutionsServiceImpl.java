package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectExecutionsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.service.IFundProjectExecutionsService;

/**
 * 项目执行记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectExecutionsServiceImpl implements IFundProjectExecutionsService
{
    @Autowired
    private FundProjectExecutionsMapper fundProjectExecutionsMapper;

    /**
     * 查询项目执行记录
     *
     * @param id 项目执行记录主键
     * @return 项目执行记录
     */
    @Override
    public FundProjectExecutions selectFundProjectExecutionsById(String id)
    {
        return fundProjectExecutionsMapper.selectFundProjectExecutionsById(id);
    }

    /**
     * 查询项目执行记录列表
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 项目执行记录
     */
    @Override
    public List<FundProjectExecutions> selectFundProjectExecutionsList(FundProjectExecutions fundProjectExecutions)
    {
        return fundProjectExecutionsMapper.selectFundProjectExecutionsList(fundProjectExecutions);
    }

    /**
     * 新增项目执行记录
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 结果
     */
    @Override
    public int insertFundProjectExecutions(FundProjectExecutions fundProjectExecutions)
    {
        return fundProjectExecutionsMapper.insertFundProjectExecutions(fundProjectExecutions);
    }

    /**
     * 修改项目执行记录
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 结果
     */
    @Override
    public int updateFundProjectExecutions(FundProjectExecutions fundProjectExecutions)
    {
        fundProjectExecutions.setUpdateTime(DateUtils.getNowDate());
        return fundProjectExecutionsMapper.updateFundProjectExecutions(fundProjectExecutions);
    }

    /**
     * 批量删除项目执行记录
     *
     * @param ids 需要删除的项目执行记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExecutionsByIds(String[] ids)
    {
        return fundProjectExecutionsMapper.deleteFundProjectExecutionsByIds(ids);
    }

    /**
     * 删除项目执行记录信息
     *
     * @param id 项目执行记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExecutionsById(String id)
    {
        return fundProjectExecutionsMapper.deleteFundProjectExecutionsById(id);
    }
}
