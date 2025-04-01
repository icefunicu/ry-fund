package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;

/**
 * 项目执行信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectExecutionsMapper
{
    /**
     * 查询项目执行信息
     *
     * @param id 项目执行信息主键
     * @return 项目执行信息
     */
    public FundProjectExecutions selectFundProjectExecutionsById(Long id);

    /**
     * 查询项目执行信息列表
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 项目执行信息集合
     */
    public List<FundProjectExecutions> selectFundProjectExecutionsList(FundProjectExecutions fundProjectExecutions);

    /**
     * 新增项目执行信息
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 结果
     */
    public int insertFundProjectExecutions(FundProjectExecutions fundProjectExecutions);

    /**
     * 修改项目执行信息
     *
     * @param fundProjectExecutions 项目执行信息
     * @return 结果
     */
    public int updateFundProjectExecutions(FundProjectExecutions fundProjectExecutions);

    /**
     * 删除项目执行信息
     *
     * @param id 项目执行信息主键
     * @return 结果
     */
    public int deleteFundProjectExecutionsById(Long id);

    /**
     * 批量删除项目执行信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectExecutionsByIds(Long[] ids);
}
