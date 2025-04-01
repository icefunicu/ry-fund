package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundAlerts;

/**
 * 系统预警提醒Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundAlertsService
{
    /**
     * 查询系统预警提醒
     *
     * @param id 系统预警提醒主键
     * @return 系统预警提醒
     */
    public FundAlerts selectFundAlertsById(String id);

    /**
     * 查询系统预警提醒列表
     *
     * @param fundAlerts 系统预警提醒
     * @return 系统预警提醒集合
     */
    public List<FundAlerts> selectFundAlertsList(FundAlerts fundAlerts);

    /**
     * 新增系统预警提醒
     *
     * @param fundAlerts 系统预警提醒
     * @return 结果
     */
    public int insertFundAlerts(FundAlerts fundAlerts);

    /**
     * 修改系统预警提醒
     *
     * @param fundAlerts 系统预警提醒
     * @return 结果
     */
    public int updateFundAlerts(FundAlerts fundAlerts);

    /**
     * 批量删除系统预警提醒
     *
     * @param ids 需要删除的系统预警提醒主键集合
     * @return 结果
     */
    public int deleteFundAlertsByIds(String[] ids);

    /**
     * 删除系统预警提醒信息
     *
     * @param id 系统预警提醒主键
     * @return 结果
     */
    public int deleteFundAlertsById(String id);
}
