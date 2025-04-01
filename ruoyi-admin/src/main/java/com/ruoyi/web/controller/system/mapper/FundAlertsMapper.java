package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundAlerts;

/**
 * 系统预警提醒Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundAlertsMapper
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
     * 删除系统预警提醒
     *
     * @param id 系统预警提醒主键
     * @return 结果
     */
    public int deleteFundAlertsById(String id);

    /**
     * 批量删除系统预警提醒
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundAlertsByIds(String[] ids);
}
