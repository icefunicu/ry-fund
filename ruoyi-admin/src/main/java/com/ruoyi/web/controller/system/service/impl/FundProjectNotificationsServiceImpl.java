package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectNotificationsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectNotifications;
import com.ruoyi.web.controller.system.service.IFundProjectNotificationsService;

/**
 * 项目通知提醒Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectNotificationsServiceImpl implements IFundProjectNotificationsService
{
    @Autowired
    private FundProjectNotificationsMapper fundProjectNotificationsMapper;

    /**
     * 查询项目通知提醒
     *
     * @param id 项目通知提醒主键
     * @return 项目通知提醒
     */
    @Override
    public FundProjectNotifications selectFundProjectNotificationsById(Long id)
    {
        return fundProjectNotificationsMapper.selectFundProjectNotificationsById(id);
    }

    /**
     * 查询项目通知提醒列表
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 项目通知提醒
     */
    @Override
    public List<FundProjectNotifications> selectFundProjectNotificationsList(FundProjectNotifications fundProjectNotifications)
    {
        return fundProjectNotificationsMapper.selectFundProjectNotificationsList(fundProjectNotifications);
    }

    /**
     * 新增项目通知提醒
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 结果
     */
    @Override
    public int insertFundProjectNotifications(FundProjectNotifications fundProjectNotifications)
    {
        fundProjectNotifications.setCreateTime(DateUtils.getNowDate());
        return fundProjectNotificationsMapper.insertFundProjectNotifications(fundProjectNotifications);
    }

    /**
     * 修改项目通知提醒
     *
     * @param fundProjectNotifications 项目通知提醒
     * @return 结果
     */
    @Override
    public int updateFundProjectNotifications(FundProjectNotifications fundProjectNotifications)
    {
        return fundProjectNotificationsMapper.updateFundProjectNotifications(fundProjectNotifications);
    }

    /**
     * 批量删除项目通知提醒
     *
     * @param ids 需要删除的项目通知提醒主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectNotificationsByIds(Long[] ids)
    {
        return fundProjectNotificationsMapper.deleteFundProjectNotificationsByIds(ids);
    }

    /**
     * 删除项目通知提醒信息
     *
     * @param id 项目通知提醒主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectNotificationsById(Long id)
    {
        return fundProjectNotificationsMapper.deleteFundProjectNotificationsById(id);
    }
}
