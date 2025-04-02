package com.ruoyi.web.controller.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.web.controller.system.domain.FundProjectReviews;
import com.ruoyi.web.controller.system.service.IFundProjectReviewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目评审记录Controller
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/reviews")
public class FundProjectReviewsController extends BaseController
{
    @Autowired
    private IFundProjectReviewsService fundProjectReviewsService;
    @Autowired
    private IFundProjectsService fundProjectsService;
    @Autowired
    private ISysUserService sysUserService;
    /**
     * 查询项目评审记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:list')")
    @GetMapping("/list")
    public TableDataInfo list(FundProjectReviews fundProjectReviews)
    {
        startPage();
        List<FundProjectReviews> list = fundProjectReviewsService.selectFundProjectReviewsList(fundProjectReviews);
        for(FundProjectReviews reviews : list) {
            FundProjects fundProjects = fundProjectsService.selectFundProjectsById(reviews.getProjectId());
            fundProjects.setApplicantName(sysUserService.selectUserById((long) fundProjects.getApplicantId()).getUserName());
            reviews.setFundProjects(fundProjects);
        }
        return getDataTable(list);
    }

    /**
     * 导出项目评审记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:export')")
    @Log(title = "项目评审记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FundProjectReviews fundProjectReviews)
    {
        List<FundProjectReviews> list = fundProjectReviewsService.selectFundProjectReviewsList(fundProjectReviews);
        ExcelUtil<FundProjectReviews> util = new ExcelUtil<FundProjectReviews>(FundProjectReviews.class);
        util.exportExcel(response, list, "项目评审记录数据");
    }

    /**
     * 获取项目评审记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(fundProjectReviewsService.selectFundProjectReviewsById(id));
    }

    /**
     * 新增项目评审记录
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:add')")
    @Log(title = "项目评审记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FundProjectReviews fundProjectReviews)
    {
        return toAjax(fundProjectReviewsService.insertFundProjectReviews(fundProjectReviews));
    }

    /**
     * 修改项目评审记录
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:edit')")
    @Log(title = "项目评审记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FundProjectReviews fundProjectReviews)
    {
        return toAjax(fundProjectReviewsService.updateFundProjectReviews(fundProjectReviews));
    }

    /**
     * 删除项目评审记录
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:remove')")
    @Log(title = "项目评审记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(fundProjectReviewsService.deleteFundProjectReviewsByIds(ids));
    }

    /**
     * 评审通过
     * */
    @PostMapping("/pass")
    public AjaxResult pass(@RequestBody FundProjectReviews fundProjectReviews) {
    	return toAjax(fundProjectReviewsService.pass(fundProjectReviews));
    }
}
