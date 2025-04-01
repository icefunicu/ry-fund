package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundAlertsMapper;
import com.ruoyi.web.controller.system.domain.FundAlerts;
import com.ruoyi.web.controller.system.service.IFundAlertsService;

/**
 * 系统预警提醒Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundAlertsServiceImpl implements IFundAlertsService
{
    @Autowired
    private FundAlertsMapper fundAlertsMapper;

    /**
     * 查询系统预警提醒
     *
     * @param id 系统预警提醒主键
     * @return 系统预警提醒
     */
    @Override
    public FundAlerts selectFundAlertsById(String id)
    {
        return fundAlertsMapper.selectFundAlertsById(id);
    }

    /**
     * 查询系统预警提醒列表
     *
     * @param fundAlerts 系统预警提醒
     * @return 系统预警提醒
     */
    @Override
    public List<FundAlerts> selectFundAlertsList(FundAlerts fundAlerts)
    {
        return fundAlertsMapper.selectFundAlertsList(fundAlerts);
    }

    /**
     * 新增系统预警提醒
     *
     * @param fundAlerts 系统预警提醒
     * @return 结果
     */
    @Override
    public int insertFundAlerts(FundAlerts fundAlerts)
    {
        return fundAlertsMapper.insertFundAlerts(fundAlerts);
    }

    /**
     * 修改系统预警提醒
     *
     * @param fundAlerts 系统预警提醒
     * @return 结果
     */
    @Override
    public int updateFundAlerts(FundAlerts fundAlerts)
    {
        return fundAlertsMapper.updateFundAlerts(fundAlerts);
    }

    /**
     * 批量删除系统预警提醒
     *
     * @param ids 需要删除的系统预警提醒主键
     * @return 结果
     */
    @Override
    public int deleteFundAlertsByIds(String[] ids)
    {
        return fundAlertsMapper.deleteFundAlertsByIds(ids);
    }

    /**
     * 删除系统预警提醒信息
     *
     * @param id 系统预警提醒主键
     * @return 结果
     */
    @Override
    public int deleteFundAlertsById(String id)
    {
        return fundAlertsMapper.deleteFundAlertsById(id);
    }
}
