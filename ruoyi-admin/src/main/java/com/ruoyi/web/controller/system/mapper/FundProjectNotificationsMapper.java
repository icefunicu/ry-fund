package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectNotifications;

/**
 * 项目通知提醒Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectNotificationsMapper
{
    /**
     * 查询项目通知提醒
     *
     * @param id 项目通知提醒主键
     * @return 项目通知提醒
     */
    public FundProjectNotifications selectFundProjectNotificationsById(Long id);

    /**
     * 查询项目通知提醒列表
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 项目通知提醒集合
     */
    public List<FundProjectNotifications> selectFundProjectNotificationsList(FundProjectNotifications fundProjectNotifications);

    /**
     * 新增项目通知提醒
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 结果
     */
    public int insertFundProjectNotifications(FundProjectNotifications fundProjectNotifications);

    /**
     * 修改项目通知提醒
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 结果
     */
    public int updateFundProjectNotifications(FundProjectNotifications fundProjectNotifications);

    /**
     * 删除项目通知提醒
     *
     * @param id 项目通知提醒主键
     * @return 结果
     */
    public int deleteFundProjectNotificationsById(Long id);

    /**
     * 批量删除项目通知提醒
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectNotificationsByIds(Long[] ids);
}
