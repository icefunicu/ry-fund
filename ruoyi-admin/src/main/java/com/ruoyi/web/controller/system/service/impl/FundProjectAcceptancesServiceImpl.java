package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectAcceptancesMapper;
import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;
import com.ruoyi.web.controller.system.service.IFundProjectAcceptancesService;

/**
 * 项目验收记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectAcceptancesServiceImpl implements IFundProjectAcceptancesService
{
    @Autowired
    private FundProjectAcceptancesMapper fundProjectAcceptancesMapper;

    /**
     * 查询项目验收记录
     *
     * @param id 项目验收记录主键
     * @return 项目验收记录
     */
    @Override
    public FundProjectAcceptances selectFundProjectAcceptancesById(String id)
    {
        return fundProjectAcceptancesMapper.selectFundProjectAcceptancesById(id);
    }

    /**
     * 查询项目验收记录列表
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 项目验收记录
     */
    @Override
    public List<FundProjectAcceptances> selectFundProjectAcceptancesList(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.selectFundProjectAcceptancesList(fundProjectAcceptances);
    }

    /**
     * 新增项目验收记录
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 结果
     */
    @Override
    public int insertFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.insertFundProjectAcceptances(fundProjectAcceptances);
    }

    /**
     * 修改项目验收记录
     *
     * @param fundProjectAcceptances 项目验收记录
     * @return 结果
     */
    @Override
    public int updateFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.updateFundProjectAcceptances(fundProjectAcceptances);
    }

    /**
     * 批量删除项目验收记录
     *
     * @param ids 需要删除的项目验收记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectAcceptancesByIds(String[] ids)
    {
        return fundProjectAcceptancesMapper.deleteFundProjectAcceptancesByIds(ids);
    }

    /**
     * 删除项目验收记录信息
     *
     * @param id 项目验收记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectAcceptancesById(String id)
    {
        return fundProjectAcceptancesMapper.deleteFundProjectAcceptancesById(id);
    }

    @Override
    public FundProjectAcceptances selectFundProjectAcceptancesByProjectId(String projectId) {
        return fundProjectAcceptancesMapper.selectFundProjectAcceptancesByProjectId(projectId);
    }
}
