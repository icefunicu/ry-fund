package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundDisbursements;

/**
 * 项目经费拨付记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundDisbursementsService
{
    /**
     * 查询项目经费拨付记录
     *
     * @param id 项目经费拨付记录主键
     * @return 项目经费拨付记录
     */
    public FundDisbursements selectFundDisbursementsById(String id);

    /**
     * 查询项目经费拨付记录列表
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 项目经费拨付记录集合
     */
    public List<FundDisbursements> selectFundDisbursementsList(FundDisbursements fundDisbursements);

    /**
     * 新增项目经费拨付记录
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 结果
     */
    public int insertFundDisbursements(FundDisbursements fundDisbursements);

    /**
     * 修改项目经费拨付记录
     *
     * @param fundDisbursements 项目经费拨付记录
     * @return 结果
     */
    public int updateFundDisbursements(FundDisbursements fundDisbursements);

    /**
     * 批量删除项目经费拨付记录
     *
     * @param ids 需要删除的项目经费拨付记录主键集合
     * @return 结果
     */
    public int deleteFundDisbursementsByIds(String[] ids);

    /**
     * 删除项目经费拨付记录信息
     *
     * @param id 项目经费拨付记录主键
     * @return 结果
     */
    public int deleteFundDisbursementsById(String id);
}
