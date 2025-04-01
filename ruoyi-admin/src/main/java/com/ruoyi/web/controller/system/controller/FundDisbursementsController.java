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
import com.ruoyi.web.controller.system.domain.FundDisbursements;
import com.ruoyi.web.controller.system.service.IFundDisbursementsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目经费拨付记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/disbursements")
public class FundDisbursementsController extends BaseController
{
    @Autowired
    private IFundDisbursementsService fundDisbursementsService;

    /**
     * 查询项目经费拨付记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundDisbursements fundDisbursements)
    {
        startPage();
        List<FundDisbursements> list = fundDisbursementsService.selectFundDisbursementsList(fundDisbursements);
        return getDataTable(list);
    }

    /**
     * 导出项目经费拨付记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:export')")
    @Log(title = "项目经费拨付记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundDisbursements fundDisbursements)
    {
        List<FundDisbursements> list = fundDisbursementsService.selectFundDisbursementsList(fundDisbursements);
        ExcelUtil<FundDisbursements> util = new ExcelUtil<FundDisbursements>(FundDisbursements.class);
        util.exportExcel(response, list, "项目经费拨付记录数据");
    }

    /**
     * 获取项目经费拨付记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundDisbursementsService.selectFundDisbursementsById(id));
    }

    /**
     * 新增项目经费拨付记录
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:add')")
    @Log(title = "项目经费拨付记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundDisbursements fundDisbursements)
    {
        return toAjax(fundDisbursementsService.insertFundDisbursements(fundDisbursements));
    }

    /**
     * 修改项目经费拨付记录
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:edit')")
    @Log(title = "项目经费拨付记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundDisbursements fundDisbursements)
    {
        return toAjax(fundDisbursementsService.updateFundDisbursements(fundDisbursements));
    }

    /**
     * 删除项目经费拨付记录
     */
    @PreAuthorize("@ss.hasPermi('system:disbursements:remove')")
    @Log(title = "项目经费拨付记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundDisbursementsService.deleteFundDisbursementsByIds(ids));
    }
}
