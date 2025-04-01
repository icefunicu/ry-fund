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
import com.ruoyi.web.controller.system.domain.FundProjectApplications;
import com.ruoyi.web.controller.system.service.IFundProjectApplicationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目申请信息Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/applications")
public class FundProjectApplicationsController extends BaseController
{
    @Autowired
    private IFundProjectApplicationsService fundProjectApplicationsService;

    /**
     * 查询项目申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:applications:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectApplications fundProjectApplications)
    {
        startPage();
        List<FundProjectApplications> list = fundProjectApplicationsService.selectFundProjectApplicationsList(fundProjectApplications);
        return getDataTable(list);
    }

    /**
     * 导出项目申请信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:applications:export')")
    @Log(title = "项目申请信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectApplications fundProjectApplications)
    {
        List<FundProjectApplications> list = fundProjectApplicationsService.selectFundProjectApplicationsList(fundProjectApplications);
        ExcelUtil<FundProjectApplications> util = new ExcelUtil<FundProjectApplications>(FundProjectApplications.class);
        util.exportExcel(response, list, "项目申请信息数据");
    }

    /**
     * 获取项目申请信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:applications:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fundProjectApplicationsService.selectFundProjectApplicationsById(id));
    }

    /**
     * 新增项目申请信息
     */
    @PreAuthorize("@ss.hasPermi('system:applications:add')")
    @Log(title = "项目申请信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectApplications fundProjectApplications)
    {
        return toAjax(fundProjectApplicationsService.insertFundProjectApplications(fundProjectApplications));
    }

    /**
     * 修改项目申请信息
     */
    @PreAuthorize("@ss.hasPermi('system:applications:edit')")
    @Log(title = "项目申请信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectApplications fundProjectApplications)
    {
        return toAjax(fundProjectApplicationsService.updateFundProjectApplications(fundProjectApplications));
    }

    /**
     * 删除项目申请信息
     */
    @PreAuthorize("@ss.hasPermi('system:applications:remove')")
    @Log(title = "项目申请信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fundProjectApplicationsService.deleteFundProjectApplicationsByIds(ids));
    }
}
