package com.ruoyi.web.controller.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.system.mapper.FundProjectFundsMapper;
import com.ruoyi.web.controller.system.domain.FundProjectFunds;
import com.ruoyi.web.controller.system.service.IFundProjectFundsService;

/**
 * 项目经费支出记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class FundProjectFundsServiceImpl implements IFundProjectFundsService
{
    @Autowired
    private FundProjectFundsMapper fundProjectFundsMapper;

    /**
     * 查询项目经费支出记录
     *
     * @param id 项目经费支出记录主键
     * @return 项目经费支出记录
     */
    @Override
    public FundProjectFunds selectFundProjectFundsById(Long id)
    {
        return fundProjectFundsMapper.selectFundProjectFundsById(id);
    }

    /**
     * 查询项目经费支出记录列表
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 项目经费支出记录
     */
    @Override
    public List<FundProjectFunds> selectFundProjectFundsList(FundProjectFunds fundProjectFunds)
    {
        return fundProjectFundsMapper.selectFundProjectFundsList(fundProjectFunds);
    }

    /**
     * 新增项目经费支出记录
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 结果
     */
    @Override
    public int insertFundProjectFunds(FundProjectFunds fundProjectFunds)
    {
        return fundProjectFundsMapper.insertFundProjectFunds(fundProjectFunds);
    }

    /**
     * 修改项目经费支出记录
     *
     * @param fundProjectFunds 项目经费支出记录
     * @return 结果
     */
    @Override
    public int updateFundProjectFunds(FundProjectFunds fundProjectFunds)
    {
        return fundProjectFundsMapper.updateFundProjectFunds(fundProjectFunds);
    }

    /**
     * 批量删除项目经费支出记录
     *
     * @param ids 需要删除的项目经费支出记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectFundsByIds(Long[] ids)
    {
        return fundProjectFundsMapper.deleteFundProjectFundsByIds(ids);
    }

    /**
     * 删除项目经费支出记录信息
     *
     * @param id 项目经费支出记录主键
     * @return 结果
     */
    @Override
    public int deleteFundProjectFundsById(Long id)
    {
        return fundProjectFundsMapper.deleteFundProjectFundsById(id);
    }
}
