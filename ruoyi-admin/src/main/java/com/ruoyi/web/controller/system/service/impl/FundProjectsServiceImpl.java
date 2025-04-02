package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectsMapper;
import com.ruoyi.web.controller.system.domain.FundProjects;
import com.ruoyi.web.controller.system.service.IFundProjectsService;

/**
 * 项目基本信息Service业务层处理
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
     * 查询项目基本信息
     *
     * @param id 项目基本信息主键
     * @return 项目基本信息
     */
    @Override
    public FundProjects selectFundProjectsById(String id)
    {
        return fundProjectsMapper.selectFundProjectsById(id);
    }

    /**
     * 查询项目基本信息列表
     *
     * @param fundProjects 项目基本信息
     * @return 项目基本信息
     */
    @Override
    public List<FundProjects> selectFundProjectsList(FundProjects fundProjects)
    {
        return fundProjectsMapper.selectFundProjectsList(fundProjects);
    }

    /**
     * 新增项目基本信息
     *
     * @param fundProjects 项目基本信息
     * @return 结果
     */
    @Override
    public int insertFundProjects(FundProjects fundProjects)
    {
        return fundProjectsMapper.insertFundProjects(fundProjects);
    }

    /**
     * 修改项目基本信息
     *
     * @param fundProjects 项目基本信息
     * @return 结果
     */
    @Override
    public int updateFundProjects(FundProjects fundProjects)
    {
        return fundProjectsMapper.updateFundProjects(fundProjects);
    }

    /**
     * 批量删除项目基本信息
     *
     * @param ids 需要删除的项目基本信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectsByIds(String[] ids)
    {
        return fundProjectsMapper.deleteFundProjectsByIds(ids);
    }

    /**
     * 删除项目基本信息信息
     *
     * @param id 项目基本信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectsById(String id)
    {
        return fundProjectsMapper.deleteFundProjectsById(id);
    }
    /**
     * 提交审核
     * */
    @Override
    public int submitFundProjects(FundProjects fundProjects)
    {
        fundProjects = fundProjectsMapper.selectFundProjectsById(fundProjects.getId());
        fundProjects.setStatus("评审中");
        return fundProjectsMapper.updateFundProjects(fundProjects);
    }
}
