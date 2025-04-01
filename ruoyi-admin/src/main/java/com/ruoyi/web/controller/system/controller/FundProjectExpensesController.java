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
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;
import com.ruoyi.web.controller.system.service.IFundProjectExpensesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目费用记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/expenses")
public class FundProjectExpensesController extends BaseController
{
    @Autowired
    private IFundProjectExpensesService fundProjectExpensesService;

    /**
     * 查询项目费用记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectExpenses fundProjectExpenses)
    {
        startPage();
        List<FundProjectExpenses> list = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);
        return getDataTable(list);
    }

    /**
     * 导出项目费用记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:export')")
    @Log(title = "项目费用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectExpenses fundProjectExpenses)
    {
        List<FundProjectExpenses> list = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);
        ExcelUtil<FundProjectExpenses> util = new ExcelUtil<FundProjectExpenses>(FundProjectExpenses.class);
        util.exportExcel(response, list, "项目费用记录数据");
    }

    /**
     * 获取项目费用记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectExpensesService.selectFundProjectExpensesById(id));
    }

    /**
     * 新增项目费用记录
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:add')")
    @Log(title = "项目费用记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectExpenses fundProjectExpenses)
    {
        return toAjax(fundProjectExpensesService.insertFundProjectExpenses(fundProjectExpenses));
    }

    /**
     * 修改项目费用记录
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:edit')")
    @Log(title = "项目费用记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectExpenses fundProjectExpenses)
    {
        return toAjax(fundProjectExpensesService.updateFundProjectExpenses(fundProjectExpenses));
    }

    /**
     * 删除项目费用记录
     */
    @PreAuthorize("@ss.hasPermi('system:expenses:remove')")
    @Log(title = "项目费用记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectExpensesService.deleteFundProjectExpensesByIds(ids));
    }
}
