package com.ruoyi.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.system.domain.FundProjectNotifications;
import com.ruoyi.web.controller.system.service.IFundProjectNotificationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目通知提醒Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/notifications")
public class FundProjectNotificationsController extends BaseController
{
    @Autowired
    private IFundProjectNotificationsService fundProjectNotificationsService;

    /**
     * 查询项目通知提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectNotifications fundProjectNotifications)
    {
        startPage();
        List<FundProjectNotifications> list = fundProjectNotificationsService.selectFundProjectNotificationsList(fundProjectNotifications);
        return getDataTable(list);
    }

    /**
     * 导出项目通知提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:export')")
    @Log(title = "项目通知提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectNotifications fundProjectNotifications)
    {
        List<FundProjectNotifications> list = fundProjectNotificationsService.selectFundProjectNotificationsList(fundProjectNotifications);
        ExcelUtil<FundProjectNotifications> util = new ExcelUtil<FundProjectNotifications>(FundProjectNotifications.class);
        util.exportExcel(response, list, "项目通知提醒数据");
    }

    /**
     * 获取项目通知提醒详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fundProjectNotificationsService.selectFundProjectNotificationsById(id));
    }

    /**
     * 新增项目通知提醒
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:add')")
    @Log(title = "项目通知提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectNotifications fundProjectNotifications)
    {
        return toAjax(fundProjectNotificationsService.insertFundProjectNotifications(fundProjectNotifications));
    }

    /**
     * 修改项目通知提醒
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:edit')")
    @Log(title = "项目通知提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectNotifications fundProjectNotifications)
    {
        return toAjax(fundProjectNotificationsService.updateFundProjectNotifications(fundProjectNotifications));
    }

    /**
     * 删除项目通知提醒
     */
    @PreAuthorize("@ss.hasPermi('system:notifications:remove')")
    @Log(title = "项目通知提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fundProjectNotificationsService.deleteFundProjectNotificationsByIds(ids));
    }
}
