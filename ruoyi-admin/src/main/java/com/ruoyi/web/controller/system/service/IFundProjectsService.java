package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjects;

/**
 * 项目基本信息Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectsService
{
    /**
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    public FundProjects selectFundProjectsById(String id);

    /**
     * 查询项目基本信息列表
     *
     * @param fundProjects 项目基本信息
     * @return 项目基本信息集合
     */
    public List<FundProjects> selectFundProjectsList(FundProjects fundProjects);

    /**
     * 新增项目基本信息
     *
     * @param fundProjects 项目基本信息
     * @return 结果
     */
    public int insertFundProjects(FundProjects fundProjects);

    /**
     * 修改项目基本信息
     *
     * @param fundProjects 项目基本信息
     * @return 结果
     */
    public int updateFundProjects(FundProjects fundProjects);

    /**
     * 批量删除项目基本信息
     *
     * @param ids 需要删除的项目基本信息主键集合
     * @return 结果
     */
    public int deleteFundProjectsByIds(String[] ids);

    /**
     * 删除项目基本信息信息
     *
     * @param id 项目基本信息主键
     * @return 结果
     */
    public int deleteFundProjectsById(String id);
    /*
    * 提交项目，进入审核状态
    * */
    int submitFundProjects(FundProjects fundProjects);
}
