package com.ruoyi.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.service.IFundProjectsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目基本信息Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/projects")
public class FundProjectsController extends BaseController
{
    @Autowired
    private IFundProjectsService fundProjectsService;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询项目基本信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(FundProjects fundProjects)
    {
        startPage();
        List<FundProjects> list = fundProjectsService.selectFundProjectsList(fundProjects);
        for(FundProjects project : list){
            project.setApplicantName(sysUserService.selectUserById((long) project.getApplicantId()).getUserName());
        }
        return getDataTable(list);
    }

    /**
     * 导出项目基本信息列表
     */
    @Log(title = "项目基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjects fundProjects)
    {
        List<FundProjects> list = fundProjectsService.selectFundProjectsList(fundProjects);
        ExcelUtil<FundProjects> util = new ExcelUtil<FundProjects>(FundProjects.class);
        util.exportExcel(response, list, "项目基本信息数据");
    }

    /**
     * 获取项目基本信息详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectsService.selectFundProjectsById(id));
    }

    /**
     * 新增项目基本信息
     */
    @Log(title = "项目基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjects fundProjects)
    {
        int applicationId = Math.toIntExact(getUserId());
        fundProjects.setApplicantId(applicationId);
        return toAjax(fundProjectsService.insertFundProjects(fundProjects));
    }



    /**
     * 修改项目基本信息
     */
    @Log(title = "项目基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjects fundProjects)
    {
        return toAjax(fundProjectsService.updateFundProjects(fundProjects));
    }

    /**
     * 删除项目基本信息
     */
    @Log(title = "项目基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectsService.deleteFundProjectsByIds(ids));
    }

    /**
     * 提交接口
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody FundProjects fundProjects)
    {
        return toAjax(fundProjectsService.submitFundProjects(fundProjects));
    }
    /**
     *  项目验收通过接口，修改项目状态为完成
     * */
    @PostMapping("/acceptance")
    public AjaxResult acceptance(@RequestBody FundProjects fundProjects) {
        return toAjax(fundProjectsService.acceptance(fundProjects));
    }
    /**
     *  项目验收不通过接口，修改项目状态为驳回
     * */
    @PostMapping("/reject")
    public AjaxResult reject(@RequestBody FundProjects fundProjects) {
        return toAjax(fundProjectsService.reject(fundProjects));
    }
}
