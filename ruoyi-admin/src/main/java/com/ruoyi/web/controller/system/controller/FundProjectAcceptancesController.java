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
import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;
import com.ruoyi.web.controller.system.service.IFundProjectAcceptancesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目验收记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/acceptances")
public class FundProjectAcceptancesController extends BaseController
{
    @Autowired
    private IFundProjectAcceptancesService fundProjectAcceptancesService;

    /**
     * 查询项目验收记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectAcceptances fundProjectAcceptances)
    {
        startPage();
        List<FundProjectAcceptances> list = fundProjectAcceptancesService.selectFundProjectAcceptancesList(fundProjectAcceptances);
        return getDataTable(list);
    }

    /**
     * 导出项目验收记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:export')")
    @Log(title = "项目验收记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectAcceptances fundProjectAcceptances)
    {
        List<FundProjectAcceptances> list = fundProjectAcceptancesService.selectFundProjectAcceptancesList(fundProjectAcceptances);
        ExcelUtil<FundProjectAcceptances> util = new ExcelUtil<FundProjectAcceptances>(FundProjectAcceptances.class);
        util.exportExcel(response, list, "项目验收记录数据");
    }

    /**
     * 获取项目验收记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectAcceptancesService.selectFundProjectAcceptancesById(id));
    }

    /**
     * 新增项目验收记录
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:add')")
    @Log(title = "项目验收记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectAcceptances fundProjectAcceptances)
    {
        return toAjax(fundProjectAcceptancesService.insertFundProjectAcceptances(fundProjectAcceptances));
    }

    /**
     * 修改项目验收记录
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:edit')")
    @Log(title = "项目验收记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectAcceptances fundProjectAcceptances)
    {
        return toAjax(fundProjectAcceptancesService.updateFundProjectAcceptances(fundProjectAcceptances));
    }

    /**
     * 删除项目验收记录
     */
    @PreAuthorize("@ss.hasPermi('system:acceptances:remove')")
    @Log(title = "项目验收记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectAcceptancesService.deleteFundProjectAcceptancesByIds(ids));
    }
}
