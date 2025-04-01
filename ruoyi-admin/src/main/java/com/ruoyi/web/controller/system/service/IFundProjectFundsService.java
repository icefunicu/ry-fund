package com.ruoyi.web.controller.system.service;

import java.util.List;
import com.ruoyi.web.controller.system.domain.FundProjectFunds;

/**
 * 项目经费支出记录Service接口
 *
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IFundProjectFundsService
{
    /**
     * 查询项目经费支出记录
     *
     * @param id 项目经费支出记录主键
     * @return 项目经费支出记录
     */
    public FundProjectFunds selectFundProjectFundsById(Long id);

    /**
     * 查询项目经费支出记录列表
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 项目经费支出记录集合
     */
    public List<FundProjectFunds> selectFundProjectFundsList(FundProjectFunds fundProjectFunds);

    /**
     * 新增项目经费支出记录
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 结果
     */
    public int insertFundProjectFunds(FundProjectFunds fundProjectFunds);

    /**
     * 修改项目经费支出记录
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 结果
     */
    public int updateFundProjectFunds(FundProjectFunds fundProjectFunds);

    /**
     * 批量删除项目经费支出记录
     *
     * @param ids 需要删除的项目经费支出记录主键集合
     * @return 结果
     */
    public int deleteFundProjectFundsByIds(Long[] ids);

    /**
     * 删除项目经费支出记录信息
     *
     * @param id 项目经费支出记录主键
     * @return 结果
     */
    public int deleteFundProjectFundsById(Long id);
}
