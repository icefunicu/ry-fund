package com.ruoyi.web.controller.system.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.system.domain.FundProjectAcceptances;
import com.ruoyi.web.controller.system.domain.FundProjectExpenses;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.service.IFundProjectAcceptancesService;
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
    @Autowired
    private IFundProjectAcceptancesService fundProjectAcceptancesService;
    /**
     * 查询项目执行记录列表
     */

    @GetMapping("/list")
    public TableDataInfo list(FundProjectExecutions fundProjectExecutions)
    {
        startPage();
        List<FundProjectExecutions> list = fundProjectExecutionsService.selectFundProjectExecutionsList(fundProjectExecutions);
        List<FundProjectExecutions> newlist = new ArrayList<>();
        for(FundProjectExecutions fundProjectExecutions1 : list){

            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(fundProjectExecutions1.getProjectId());
//            if (!Objects.equals(fundProjects.getStatus(), "执行中")){
//                continue;
//            }
            fundProjects.setApplicantName(sysUserService.selectUserById((long) fundProjects.getApplicantId()).getNickName());
            // 将deadline从时间戳格式转换为 yyyy-MM-dd
            fundProjects.setDeadline(new java.sql.Date(fundProjects.getDeadline().getTime()));
            fundProjectExecutions1.setFundProjects(fundProjects);

            FundProjectExpenses fundProjectExpenses = new FundProjectExpenses();
            fundProjectExpenses.setProjectId(fundProjects.getId());
            List<FundProjectExpenses> fundProjectExpenses1 = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);
            BigDecimal usedFund = new BigDecimal(0);
            // 遍历
            for (FundProjectExpenses fundProjectExpenses2 : fundProjectExpenses1) {
                usedFund = usedFund.add(fundProjectExpenses2.getExpenseAmount());
            }
            fundProjects.setUsedFund(usedFund);
            // 计算已使用经费率

            fundProjects.setusedFundProgress(fundProjects.getUsedFund().divide(fundProjects.getBudget(), 2, BigDecimal.ROUND_FLOOR).multiply(new BigDecimal("100")));

            fundProjectExecutions1.setFundProjectExpenses(fundProjectExpenses1);
            newlist.add(fundProjectExecutions1);
        }
        return getDataTable(newlist);
    }

    /**
     * 查询项目验收记录列表
     */

    @GetMapping("/YSlist")
    public TableDataInfo YSlist(FundProjectExecutions fundProjectExecutions)
    {
        startPage();
        List<FundProjectExecutions> list = fundProjectExecutionsService.selectFundProjectExecutionsList(fundProjectExecutions);
        List<FundProjectExecutions> newlist = new ArrayList<>();
        for(FundProjectExecutions fundProjectExecutions1 : list){

            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(fundProjectExecutions1.getProjectId());
//            if (!Objects.equals(fundProjects.getStatus(), "执行中")){
//                continue;
//            }
            fundProjects.setApplicantName(sysUserService.selectUserById((long) fundProjects.getApplicantId()).getNickName());
            // 将deadline从时间戳格式转换为 yyyy-MM-dd
            fundProjects.setDeadline(new java.sql.Date(fundProjects.getDeadline().getTime()));
            if(!fundProjects.getStatus().equals("验收中")||!fundProjects.getStatus().equals("完成")){
                continue;
            }
            fundProjectExecutions1.setFundProjects(fundProjects);

            FundProjectExpenses fundProjectExpenses = new FundProjectExpenses();
            fundProjectExpenses.setProjectId(fundProjects.getId());
            List<FundProjectExpenses> fundProjectExpenses1 = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);
            BigDecimal usedFund = new BigDecimal(0);
            // 遍历
            for (FundProjectExpenses fundProjectExpenses2 : fundProjectExpenses1) {
                usedFund = usedFund.add(fundProjectExpenses2.getExpenseAmount());
            }
            fundProjects.setUsedFund(usedFund);
            // 计算已使用经费率

            fundProjects.setusedFundProgress(fundProjects.getUsedFund().divide(fundProjects.getBudget(), 2, BigDecimal.ROUND_FLOOR).multiply(new BigDecimal("100")));

            fundProjectExecutions1.setFundProjectExpenses(fundProjectExpenses1);
            newlist.add(fundProjectExecutions1);
        }
        return getDataTable(newlist);
    }
    /**
     * 导出项目执行记录列表
     */

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

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {

        FundProjects fundProjects = fundProjectsService.selectFundProjectsById(id);
        fundProjects.setApplicantName(sysUserService.selectUserById((long) fundProjects.getApplicantId()).getNickName());


        FundProjectExpenses fundProjectExpenses = new FundProjectExpenses();
        fundProjectExpenses.setProjectId(fundProjects.getId());
        List<FundProjectExpenses> fundProjectExpenses1 = fundProjectExpensesService.selectFundProjectExpensesList(fundProjectExpenses);
        fundProjects.setFundProjectExpensesList(fundProjectExpenses1);
        BigDecimal usedFund = new BigDecimal(0);
        // 遍历
        for (FundProjectExpenses fundProjectExpenses2 : fundProjectExpenses1) {
            usedFund = usedFund.add(fundProjectExpenses2.getExpenseAmount());
        }
        fundProjects.setUsedFund(usedFund);
        // 计算已使用经费率

        fundProjects.setusedFundProgress(fundProjects.getUsedFund().divide(fundProjects.getBudget(), 2, BigDecimal.ROUND_FLOOR).multiply(new BigDecimal("100")));


        return success(fundProjects);
    }




    /**
     * 新增项目执行记录
     */

    @Log(title = "项目执行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectExecutions fundProjectExecutions)
    {
        return toAjax(fundProjectExecutionsService.insertFundProjectExecutions(fundProjectExecutions));
    }

    /**
     * 修改项目执行记录
     */
    @Log(title = "项目执行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectExecutions fundProjectExecutions)
    {
        if(fundProjectExecutions.getProgress()==100L){
            fundProjectExecutions.setExecutionStatus("完成");
            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(fundProjectExecutions.getProjectId());
            fundProjects.setStatus("验收中");
            fundProjectsService.updateFundProjects(fundProjects);

            FundProjectAcceptances fundProjectAcceptances = new FundProjectAcceptances();
            fundProjectAcceptances.setProjectId(fundProjectExecutions.getProjectId());
            fundProjectAcceptances.setAcceptanceStatus("待验收");
            fundProjectAcceptancesService.insertFundProjectAcceptances(fundProjectAcceptances);
        }
        return toAjax(fundProjectExecutionsService.updateFundProjectExecutions(fundProjectExecutions));
    }

    /**
     * 删除项目执行记录
     */
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
