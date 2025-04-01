package com.ruoyi.web.controller.system.mapper;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjects;

/**
 * 项目信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface FundProjectsMapper
{
    /**
     * 查询项目信息
     *
     * @param id 项目信息主键
     * @return 项目信息
     */
    public FundProjects selectFundProjectsById(Long id);

    /**
     * 查询项目信息列表
     *
     * @param fundProjects 项目信息
     * @return 项目信息集合
     */
    public List<FundProjects> selectFundProjectsList(FundProjects fundProjects);

    /**
     * 新增项目信息
     *
     * @param fundProjects 项目信息
     * @return 结果
     */
    public int insertFundProjects(FundProjects fundProjects);

    /**
     * 修改项目信息
     *
     * @param fundProjects 项目信息
     * @return 结果
     */
    public int updateFundProjects(FundProjects fundProjects);

    /**
     * 删除项目信息
     *
     * @param id 项目信息主键
     * @return 结果
     */
    public int deleteFundProjectsById(Long id);

    /**
     * 批量删除项目信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFundProjectsByIds(Long[] ids);
}
