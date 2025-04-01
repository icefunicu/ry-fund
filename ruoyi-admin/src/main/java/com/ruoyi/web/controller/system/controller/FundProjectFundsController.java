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
import com.ruoyi.web.controller.system.domain.FundProjectFunds;
import com.ruoyi.web.controller.system.service.IFundProjectFundsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目经费支出记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/funds")
public class FundProjectFundsController extends BaseController
{
    @Autowired
    private IFundProjectFundsService fundProjectFundsService;

    /**
     * 查询项目经费支出记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:funds:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectFunds fundProjectFunds)
    {
        startPage();
        List<FundProjectFunds> list = fundProjectFundsService.selectFundProjectFundsList(fundProjectFunds);
        return getDataTable(list);
    }

    /**
     * 导出项目经费支出记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:funds:export')")
    @Log(title = "项目经费支出记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectFunds fundProjectFunds)
    {
        List<FundProjectFunds> list = fundProjectFundsService.selectFundProjectFundsList(fundProjectFunds);
        ExcelUtil<FundProjectFunds> util = new ExcelUtil<FundProjectFunds>(FundProjectFunds.class);
        util.exportExcel(response, list, "项目经费支出记录数据");
    }

    /**
     * 获取项目经费支出记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:funds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fundProjectFundsService.selectFundProjectFundsById(id));
    }

    /**
     * 新增项目经费支出记录
     */
    @PreAuthorize("@ss.hasPermi('system:funds:add')")
    @Log(title = "项目经费支出记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectFunds fundProjectFunds)
    {
        return toAjax(fundProjectFundsService.insertFundProjectFunds(fundProjectFunds));
    }

    /**
     * 修改项目经费支出记录
     */
    @PreAuthorize("@ss.hasPermi('system:funds:edit')")
    @Log(title = "项目经费支出记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectFunds fundProjectFunds)
    {
        return toAjax(fundProjectFundsService.updateFundProjectFunds(fundProjectFunds));
    }

    /**
     * 删除项目经费支出记录
     */
    @PreAuthorize("@ss.hasPermi('system:funds:remove')")
    @Log(title = "项目经费支出记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fundProjectFundsService.deleteFundProjectFundsByIds(ids));
    }
}
