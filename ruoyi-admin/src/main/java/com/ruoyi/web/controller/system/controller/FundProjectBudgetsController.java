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
import com.ruoyi.web.controller.system.domain.FundProjectBudgets;
import com.ruoyi.web.controller.system.service.IFundProjectBudgetsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目经费预算记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/budgets")
public class FundProjectBudgetsController extends BaseController
{
    @Autowired
    private IFundProjectBudgetsService fundProjectBudgetsService;

    /**
     * 查询项目经费预算记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectBudgets fundProjectBudgets)
    {
        startPage();
        List<FundProjectBudgets> list = fundProjectBudgetsService.selectFundProjectBudgetsList(fundProjectBudgets);
        return getDataTable(list);
    }

    /**
     * 导出项目经费预算记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:export')")
    @Log(title = "项目经费预算记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectBudgets fundProjectBudgets)
    {
        List<FundProjectBudgets> list = fundProjectBudgetsService.selectFundProjectBudgetsList(fundProjectBudgets);
        ExcelUtil<FundProjectBudgets> util = new ExcelUtil<FundProjectBudgets>(FundProjectBudgets.class);
        util.exportExcel(response, list, "项目经费预算记录数据");
    }

    /**
     * 获取项目经费预算记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fundProjectBudgetsService.selectFundProjectBudgetsById(id));
    }

    /**
     * 新增项目经费预算记录
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:add')")
    @Log(title = "项目经费预算记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectBudgets fundProjectBudgets)
    {
        return toAjax(fundProjectBudgetsService.insertFundProjectBudgets(fundProjectBudgets));
    }

    /**
     * 修改项目经费预算记录
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:edit')")
    @Log(title = "项目经费预算记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectBudgets fundProjectBudgets)
    {
        return toAjax(fundProjectBudgetsService.updateFundProjectBudgets(fundProjectBudgets));
    }

    /**
     * 删除项目经费预算记录
     */
    @PreAuthorize("@ss.hasPermi('system:budgets:remove')")
    @Log(title = "项目经费预算记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fundProjectBudgetsService.deleteFundProjectBudgetsByIds(ids));
    }
}
