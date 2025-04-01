package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectApplications;

/**
 * 项目申请信息Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectApplicationsService
{
    /**
     * 查询项目申请信息
     *
     * @param id 项目申请信息主键
     * @return 项目申请信息
     */
    public FundProjectApplications selectFundProjectApplicationsById(Long id);

    /**
     * 查询项目申请信息列表
     *
     * @param fundProjectApplications 项目申请信息
     * @return 项目申请信息集合
     */
    public List<FundProjectApplications> selectFundProjectApplicationsList(FundProjectApplications fundProjectApplications);

    /**
     * 新增项目申请信息
     *
     * @param fundProjectApplications 项目申请信息
     * @return 结果
     */
    public int insertFundProjectApplications(FundProjectApplications fundProjectApplications);

    /**
     * 修改项目申请信息
     *
     * @param fundProjectApplications 项目申请信息
     * @return 结果
     */
    public int updateFundProjectApplications(FundProjectApplications fundProjectApplications);

    /**
     * 批量删除项目申请信息
     *
     * @param ids 需要删除的项目申请信息主键集合
     * @return 结果
     */
    public int deleteFundProjectApplicationsByIds(Long[] ids);

    /**
     * 删除项目申请信息信息
     *
     * @param id 项目申请信息主键
     * @return 结果
     */
    public int deleteFundProjectApplicationsById(Long id);
}
