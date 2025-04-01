package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectApplicationsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectApplications;
import com.ruoyi.web.controller.system.service.IFundProjectApplicationsService;

/**
 * 项目申请信息Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectApplicationsServiceImpl implements IFundProjectApplicationsService
{
    @Autowired
    private FundProjectApplicationsMapper fundProjectApplicationsMapper;

    /**
     * 查询项目申请信息
     *
     * @param id 项目申请信息主键
     * @return 项目申请信息
     */
    @Override
    public FundProjectApplications selectFundProjectApplicationsById(Long id)
    {
        return fundProjectApplicationsMapper.selectFundProjectApplicationsById(id);
    }

    /**
     * 查询项目申请信息列表
     *
     * @param fundProjectApplications 项目申请信息
     * @return 项目申请信息
     */
    @Override
    public List<FundProjectApplications> selectFundProjectApplicationsList(FundProjectApplications fundProjectApplications)
    {
        return fundProjectApplicationsMapper.selectFundProjectApplicationsList(fundProjectApplications);
    }

    /**
     * 新增项目申请信息
     *
     * @param fundProjectApplications 项目申请信息
     * @return 结果
     */
    @Override
    public int insertFundProjectApplications(FundProjectApplications fundProjectApplications)
    {
        return fundProjectApplicationsMapper.insertFundProjectApplications(fundProjectApplications);
    }

    /**
     * 修改项目申请信息
     *
     * @param fundProjectApplications 项目申请信息
     * @return 结果
     */
    @Override
    public int updateFundProjectApplications(FundProjectApplications fundProjectApplications)
    {
        return fundProjectApplicationsMapper.updateFundProjectApplications(fundProjectApplications);
    }

    /**
     * 批量删除项目申请信息
     *
     * @param ids 需要删除的项目申请信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectApplicationsByIds(Long[] ids)
    {
        return fundProjectApplicationsMapper.deleteFundProjectApplicationsByIds(ids);
    }

    /**
     * 删除项目申请信息信息
     *
     * @param id 项目申请信息主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectApplicationsById(Long id)
    {
        return fundProjectApplicationsMapper.deleteFundProjectApplicationsById(id);
    }
}
