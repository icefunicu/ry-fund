package com.ruoyi.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.service.IFundProjectExpensesService;
import com.ruoyi.web.controller.system.service.IFundProjectsService;
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
import com.ruoyi.web.controller.system.domain.FundProjectExecutions;
import com.ruoyi.web.controller.system.service.IFundProjectExecutionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目执行记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/executions")
public class FundProjectExecutionsController extends BaseController
{
    @Autowired
    private IFundProjectExecutionsService fundProjectExecutionsService;
    @Autowired
    private IFundProjectsService fundProjectsService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IFundProjectExpensesService fundProjectExpensesService;
    /**
     * 查询项目执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:executions:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectExecutions fundProjectExecutions)
    {
        startPage();
        List<FundProjectExecutions> list = fundProjectExecutionsService.selectFundProjectExecutionsList(fundProjectExecutions);
        for(FundProjectExecutions fundProjectExecutions1 : list){
            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(fundProjectExecutions1.getProjectId());
            fundProjects.setApplicantName(sysUserService.selectUserById((long) fundProjects.getApplicantId()).getUserName());
            fundProjectExecutions1.setFundProjects(fundProjects);

            FundProjectExpenses fundProjectExpenses = new FundProjectExpenses();
            fundProjectExpenses.setProjectId(fundProjects.getId());
            List<FundProjectExpenses> fundProjectExpenses1 = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);

            fundProjectExecutions1.setFundProjectExpenses(fundProjectExpenses1);

        }
        return getDataTable(list);
    }

    /**
     * 导出项目执行记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:executions:export')")
    @Log(title = "项目执行记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectExecutions fundProjectExecutions)
    {
        List<FundProjectExecutions> list = fundProjectExecutionsService.selectFundProjectExecutionsList(fundProjectExecutions);
        ExcelUtil<FundProjectExecutions> util = new ExcelUtil<FundProjectExecutions>(FundProjectExecutions.class);
        util.exportExcel(response, list, "项目执行记录数据");
    }

    /**
     * 获取项目执行记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:executions:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectExecutionsService.selectFundProjectExecutionsById(id));
    }

    /**
     * 新增项目执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:executions:add')")
    @Log(title = "项目执行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectExecutions fundProjectExecutions)
    {
        return toAjax(fundProjectExecutionsService.insertFundProjectExecutions(fundProjectExecutions));
    }

    /**
     * 修改项目执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:executions:edit')")
    @Log(title = "项目执行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectExecutions fundProjectExecutions)
    {
        return toAjax(fundProjectExecutionsService.updateFundProjectExecutions(fundProjectExecutions));
    }

    /**
     * 删除项目执行记录
     */
    @PreAuthorize("@ss.hasPermi('system:executions:remove')")
    @Log(title = "项目执行记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectExecutionsService.deleteFundProjectExecutionsByIds(ids));
    }
    /**
     * 提交验收
     * */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody FundProjectExecutions fundProjectExecutions)
    {
        return toAjax(fundProjectExecutionsService.submitFundProjectExecutions(fundProjectExecutions));
    }
}
