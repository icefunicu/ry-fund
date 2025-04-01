package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundDisbursementsMapper;
import com.ruoyi.web.controller.system.domain.FundDisbursements;
import com.ruoyi.web.controller.system.service.IFundDisbursementsService;

/**
 * 项目经费拨付记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundDisbursementsServiceImpl implements IFundDisbursementsService
{
    @Autowired
    private FundDisbursementsMapper fundDisbursementsMapper;

    /**
     * 查询项目经费拨付记录
     *
     * @param id 项目经费拨付记录主键
     * @return 项目经费拨付记录
     */
    @Override
    public FundDisbursements selectFundDisbursementsById(String id)
    {
        return fundDisbursementsMapper.selectFundDisbursementsById(id);
    }

    /**
     * 查询项目经费拨付记录列表
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 项目经费拨付记录
     */
    @Override
    public List<FundDisbursements> selectFundDisbursementsList(FundDisbursements fundDisbursements)
    {
        return fundDisbursementsMapper.selectFundDisbursementsList(fundDisbursements);
    }

    /**
     * 新增项目经费拨付记录
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 结果
     */
    @Override
    public int insertFundDisbursements(FundDisbursements fundDisbursements)
    {
        return fundDisbursementsMapper.insertFundDisbursements(fundDisbursements);
    }

    /**
     * 修改项目经费拨付记录
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 结果
     */
    @Override
    public int updateFundDisbursements(FundDisbursements fundDisbursements)
    {
        return fundDisbursementsMapper.updateFundDisbursements(fundDisbursements);
    }

    /**
     * 批量删除项目经费拨付记录
     *
     * @param ids 需要删除的项目经费拨付记录主键
     * @return 结果
     */
    @Override
    public int deleteFundDisbursementsByIds(String[] ids)
    {
        return fundDisbursementsMapper.deleteFundDisbursementsByIds(ids);
    }

    /**
     * 删除项目经费拨付记录信息
     *
     * @param id 项目经费拨付记录主键
     * @return 结果
     */
    @Override
    public int deleteFundDisbursementsById(String id)
    {
        return fundDisbursementsMapper.deleteFundDisbursementsById(id);
    }
}
