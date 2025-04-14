package com.ruoyi.web.controller.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.system.domain.FundProjects;
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
    @Autowired
    private IFundProjectsService fundProjectsService;
    /**
     * 查询项目验收记录列表
     */

    @GetMapping("/list")
    public TableDataInfo list(FundProjectAcceptances fundProjectAcceptances)
    {
        startPage();
        List<FundProjectAcceptances> list = fundProjectAcceptancesService.selectFundProjectAcceptancesList(fundProjectAcceptances);
        return getDataTable(list);
    }

    @PostMapping("/listbyid")
    public AjaxResult listById(@RequestBody FundProjectAcceptances fundProjectAcceptances)
    {
        startPage();
        List<FundProjectAcceptances> list = fundProjectAcceptancesService.selectFundProjectAcceptancesList(fundProjectAcceptances);
        list.forEach(item -> {
            if (item.getReviewComments() != null) {
                item.setCommonList(Arrays.asList(item.getReviewComments().split("###")));
            }
        });
        if (list.isEmpty()){
            return AjaxResult.success(Collections.emptyList());
        }
        return AjaxResult.success(list.get(0));
    }

    /**
     * 导出项目验收记录列表
     */

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

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectAcceptancesService.selectFundProjectAcceptancesById(id));
    }

    /**
     * 新增项目验收记录
     */

    @Log(title = "项目验收记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectAcceptances fundProjectAcceptances)
    {
        return toAjax(fundProjectAcceptancesService.insertFundProjectAcceptances(fundProjectAcceptances));
    }
    /**
     * 驳回意见
     * */
    @PostMapping("/rejectOpinion")
    public AjaxResult rejectOpinion(@RequestBody FundProjectAcceptances fundProjectAcceptances){
        String projectId = fundProjectAcceptances.getProjectId();
        //判断数据库中是否有相关的项目验收记录，如果没有就新增，有就修改
        FundProjectAcceptances fundProjectAcceptances1 = fundProjectAcceptancesService.selectFundProjectAcceptancesByProjectId(projectId);
        if(fundProjectAcceptances1==null){
            fundProjectAcceptances.setAcceptanceStatus("未通过");
            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(projectId);
            fundProjects.setStatus("驳回");
            fundProjectsService.updateFundProjects(fundProjects);
            return toAjax(fundProjectAcceptancesService.insertFundProjectAcceptances(fundProjectAcceptances)) ;
        }else{
            StringBuilder sb = new StringBuilder();
            if (fundProjectAcceptances1.getReviewComments() == null){
                fundProjectAcceptances1.setReviewComments(fundProjectAcceptances.getReviewComments());
            }else {
                sb.append(fundProjectAcceptances1.getReviewComments()).append("###").append(fundProjectAcceptances.getReviewComments());
                fundProjectAcceptances1.setReviewComments(sb.toString());
            }
            fundProjectAcceptances1.setAcceptanceStatus("未通过");
            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(projectId);
            fundProjects.setStatus("驳回");
            fundProjectsService.updateFundProjects(fundProjects);
            return toAjax(fundProjectAcceptancesService.updateFundProjectAcceptances(fundProjectAcceptances1)) ;
        }
    }

    /**
     * 修改项目验收记录
     */

    @Log(title = "项目验收记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectAcceptances fundProjectAcceptances)
    {
        return toAjax(fundProjectAcceptancesService.updateFundProjectAcceptances(fundProjectAcceptances));
    }

    /**
     * 删除项目验收记录
     */

    @Log(title = "项目验收记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectAcceptancesService.deleteFundProjectAcceptancesByIds(ids));
    }

    /**
     * 验收通过
     * */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody FundProjectAcceptances fundProjectAcceptances){
        String projectId = fundProjectAcceptances.getProjectId();
        FundProjects fundProjects = fundProjectsService.selectFundProjectsById(projectId);
        fundProjects.setStatus("通过");
        fundProjects.setLevel(fundProjectAcceptances.getAcceptanceStatus());
        fundProjectsService.updateFundProjects(fundProjects);
        return toAjax(fundProjectAcceptancesService.updateFundProjectAcceptances(fundProjectAcceptances));
    }
    /**
     *
     * 验收不通过
    * */
    @PostMapping("/reject")
    public AjaxResult reject(@RequestBody FundProjectAcceptances fundProjectAcceptances){
        fundProjectAcceptances.setAcceptanceStatus("未通过");
        String projectId = fundProjectAcceptances.getProjectId();
        FundProjects fundProjects = fundProjectsService.selectFundProjectsById(projectId);
        fundProjects.setStatus("驳回");
        fundProjectsService.updateFundProjects(fundProjects);
        return toAjax(fundProjectAcceptancesService.updateFundProjectAcceptances(fundProjectAcceptances));
    }
}
