package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;

/**
 * 项目执行记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectExecutionsService
{
    /**
     * 查询项目执行记录
     *
     * @param id 项目执行记录主键
     * @return 项目执行记录
     */
    public FundProjectExecutions selectFundProjectExecutionsById(String id);

    /**
     * 查询项目执行记录列表
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 项目执行记录集合
     */
    public List<FundProjectExecutions> selectFundProjectExecutionsList(FundProjectExecutions fundProjectExecutions);

    /**
     * 新增项目执行记录
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 结果
     */
    public int insertFundProjectExecutions(FundProjectExecutions fundProjectExecutions);

    /**
     * 修改项目执行记录
     *
     * @param fundProjectExecutions 项目执行记录
     * @return 结果
     */
    public int updateFundProjectExecutions(FundProjectExecutions fundProjectExecutions);

    /**
     * 批量删除项目执行记录
     *
     * @param ids 需要删除的项目执行记录主键集合
     * @return 结果
     */
    public int deleteFundProjectExecutionsByIds(String[] ids);

    /**
     * 删除项目执行记录信息
     *
     * @param id 项目执行记录主键
     * @return 结果
     */
    public int deleteFundProjectExecutionsById(String id);

    int submitFundProjectExecutions(FundProjectExecutions fundProjectExecutions);
}
