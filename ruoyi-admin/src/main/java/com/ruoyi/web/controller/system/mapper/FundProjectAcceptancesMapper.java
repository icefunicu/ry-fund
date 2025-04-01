package com.ruoyi.web.controller.system.mapper;

import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;

import java.util.List;

/**
 * 项目验收信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectAcceptancesMapper
{
    /**
     * 查询项目验收信息
     *
     * @param id 项目验收信息主键
     * @return 项目验收信息
     */
    public FundProjectAcceptances selectFundProjectAcceptancesById(Long id);

    /**
     * 查询项目验收信息列表
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 项目验收信息集合
     */
    public List<FundProjectAcceptances> selectFundProjectAcceptancesList(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 新增项目验收信息
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 结果
     */
    public int insertFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 修改项目验收信息
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 结果
     */
    public int updateFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 删除项目验收信息
     *
     * @param id 项目验收信息主键
     * @return 结果
     */
    public int deleteFundProjectAcceptancesById(Long id);

    /**
     * 批量删除项目验收信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectAcceptancesByIds(Long[] ids);
}
