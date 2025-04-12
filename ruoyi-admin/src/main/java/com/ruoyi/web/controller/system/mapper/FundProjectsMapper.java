package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjects;

/**
 * 项目基本信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectsMapper
{
    /**
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    public FundProjects selectFundProjectsById(String id);
    List<FundProjects> selectAlertsList();

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
     * 删除项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 结果
     */
    public int deleteFundProjectsById(String id);

    /**
     * 批量删除项目基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectsByIds(String[] ids);
}
