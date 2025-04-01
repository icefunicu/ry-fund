package com.ruoyi.web.controller.system.service.impl;

import java.util.List;

import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;
import com.ruoyi.web.controller.system.mapper.FundProjectAcceptancesMapper;
import com.ruoyi.web.controller.system.service.IFundProjectAcceptancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目验收信息Service业务层处理
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
     * 查询项目验收信息
     *
     * @param id 项目验收信息主键
     * @return 项目验收信息
     */
    @Override
    public FundProjectAcceptances selectFundProjectAcceptancesById(Long id)
    {
        return fundProjectAcceptancesMapper.selectFundProjectAcceptancesById(id);
    }

    /**
     * 查询项目验收信息列表
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 项目验收信息
     */
    @Override
    public List<FundProjectAcceptances> selectFundProjectAcceptancesList(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.selectFundProjectAcceptancesList(fundProjectAcceptances);
    }

    /**
     * 新增项目验收信息
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 结果
     */
    @Override
    public int insertFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.insertFundProjectAcceptances(fundProjectAcceptances);
    }

    /**
     * 修改项目验收信息
     *
     * @param fundProjectAcceptances 项目验收信息
     * @return 结果
     */
    @Override
    public int updateFundProjectAcceptances(FundProjectAcceptances fundProjectAcceptances)
    {
        return fundProjectAcceptancesMapper.updateFundProjectAcceptances(fundProjectAcceptances);
    }

    /**
     * 批量删除项目验收信息
     *
     * @param ids 需要删除的项目验收信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectAcceptancesByIds(Long[] ids)
    {
        return fundProjectAcceptancesMapper.deleteFundProjectAcceptancesByIds(ids);
    }

    /**
     * 删除项目验收信息信息
     *
     * @param id 项目验收信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectAcceptancesById(Long id)
    {
        return fundProjectAcceptancesMapper.deleteFundProjectAcceptancesById(id);
    }
}
