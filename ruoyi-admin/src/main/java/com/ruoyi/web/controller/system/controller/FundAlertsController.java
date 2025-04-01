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
import com.ruoyi.web.controller.system.domain.FundAlerts;
import com.ruoyi.web.controller.system.service.IFundAlertsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统预警提醒Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/alerts")
public class FundAlertsController extends BaseController
{
    @Autowired
    private IFundAlertsService fundAlertsService;

    /**
     * 查询系统预警提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundAlerts fundAlerts)
    {
        startPage();
        List<FundAlerts> list = fundAlertsService.selectFundAlertsList(fundAlerts);
        return getDataTable(list);
    }

    /**
     * 导出系统预警提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:export')")
    @Log(title = "系统预警提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundAlerts fundAlerts)
    {
        List<FundAlerts> list = fundAlertsService.selectFundAlertsList(fundAlerts);
        ExcelUtil<FundAlerts> util = new ExcelUtil<FundAlerts>(FundAlerts.class);
        util.exportExcel(response, list, "系统预警提醒数据");
    }

    /**
     * 获取系统预警提醒详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundAlertsService.selectFundAlertsById(id));
    }

    /**
     * 新增系统预警提醒
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:add')")
    @Log(title = "系统预警提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundAlerts fundAlerts)
    {
        return toAjax(fundAlertsService.insertFundAlerts(fundAlerts));
    }

    /**
     * 修改系统预警提醒
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:edit')")
    @Log(title = "系统预警提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundAlerts fundAlerts)
    {
        return toAjax(fundAlertsService.updateFundAlerts(fundAlerts));
    }

    /**
     * 删除系统预警提醒
     */
    @PreAuthorize("@ss.hasPermi('system:alerts:remove')")
    @Log(title = "系统预警提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundAlertsService.deleteFundAlertsByIds(ids));
    }
}
