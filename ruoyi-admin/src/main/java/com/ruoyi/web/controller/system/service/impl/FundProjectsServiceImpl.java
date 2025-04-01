package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectsMapper;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.service.IFundProjectsService;

/**
 * 项目信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectsServiceImpl implements IFundProjectsService
{
    @Autowired
    private FundProjectsMapper fundProjectsMapper;

    /**
     * 查询项目信息
     *
     * @param id 项目信息主键
     * @return 项目信息
     */
    @Override
    public FundProjects selectFundProjectsById(Long id)
    {
        return fundProjectsMapper.selectFundProjectsById(id);
    }

    /**
     * 查询项目信息列表
     *
     * @param fundProjects 项目信息
     * @return 项目信息
     */
    @Override
    public List<FundProjects> selectFundProjectsList(FundProjects fundProjects)
    {
        return fundProjectsMapper.selectFundProjectsList(fundProjects);
    }

    /**
     * 新增项目信息
     *
     * @param fundProjects 项目信息
     * @return 结果
     */
    @Override
    public int insertFundProjects(FundProjects fundProjects)
    {
        fundProjects.setCreateTime(DateUtils.getNowDate());
        return fundProjectsMapper.insertFundProjects(fundProjects);
    }

    /**
     * 修改项目信息
     *
     * @param fundProjects 项目信息
     * @return 结果
     */
    @Override
    public int updateFundProjects(FundProjects fundProjects)
    {
        fundProjects.setUpdateTime(DateUtils.getNowDate());
        return fundProjectsMapper.updateFundProjects(fundProjects);
    }

    /**
     * 批量删除项目信息
     *
     * @param ids 需要删除的项目信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectsByIds(Long[] ids)
    {
        return fundProjectsMapper.deleteFundProjectsByIds(ids);
    }

    /**
     * 删除项目信息信息
     *
     * @param id 项目信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectsById(Long id)
    {
        return fundProjectsMapper.deleteFundProjectsById(id);
    }
}
