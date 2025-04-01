package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectExecutionsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.service.IFundProjectExecutionsService;

/**
 * 项目执行信息Service业务层处理
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
     * 查询项目执行信息
     *
     * @param id 项目执行信息主键
     * @return 项目执行信息
     */
    @Override
    public FundProjectExecutions selectFundProjectExecutionsById(Long id)
    {
        return fundProjectExecutionsMapper.selectFundProjectExecutionsById(id);
    }

    /**
     * 查询项目执行信息列表
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 项目执行信息
     */
    @Override
    public List<FundProjectExecutions> selectFundProjectExecutionsList(FundProjectExecutions fundProjectExecutions)
    {
        return fundProjectExecutionsMapper.selectFundProjectExecutionsList(fundProjectExecutions);
    }

    /**
     * 新增项目执行信息
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 结果
     */
    @Override
    public int insertFundProjectExecutions(FundProjectExecutions fundProjectExecutions)
    {
        return fundProjectExecutionsMapper.insertFundProjectExecutions(fundProjectExecutions);
    }

    /**
     * 修改项目执行信息
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 结果
     */
    @Override
    public int updateFundProjectExecutions(FundProjectExecutions fundProjectExecutions)
    {
        return fundProjectExecutionsMapper.updateFundProjectExecutions(fundProjectExecutions);
    }

    /**
     * 批量删除项目执行信息
     *
     * @param ids 需要删除的项目执行信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExecutionsByIds(Long[] ids)
    {
        return fundProjectExecutionsMapper.deleteFundProjectExecutionsByIds(ids);
    }

    /**
     * 删除项目执行信息信息
     *
     * @param id 项目执行信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectExecutionsById(Long id)
    {
        return fundProjectExecutionsMapper.deleteFundProjectExecutionsById(id);
    }
}
