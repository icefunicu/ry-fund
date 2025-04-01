package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;

/**
 * 项目验收记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectAcceptancesMapper
{
    /**
     * 查询项目验收记录
     *
     * @param id 项目验收记录主键
     * @return 项目验收记录
     */
    public FundProjectAcceptances selectFundProjectAcceptancesById(String id);

    /**
     * 查询项目验收记录列表
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 项目验收记录集合
     */
    public List<FundProjectAcceptances> selectFundProjectAcceptancesList(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 新增项目验收记录
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 结果
     */
    public int insertFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 修改项目验收记录
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 结果
     */
    public int updateFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances);

    /**
     * 删除项目验收记录
     *
     * @param id 项目验收记录主键
     * @return 结果
     */
    public int deleteFundProjectAcceptancesById(String id);

    /**
     * 批量删除项目验收记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectAcceptancesByIds(String[] ids);
}
