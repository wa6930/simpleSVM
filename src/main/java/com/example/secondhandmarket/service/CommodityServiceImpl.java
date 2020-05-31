package com.example.secondhandmarket.service;

import com.example.secondhandmarket.dao.CommodityRepository;
import com.example.secondhandmarket.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService{

    @Autowired
    private CommodityRepository commodityRepository;

    /* 获取所有用商品 */
    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    /* 获取用户所有商品 */
    @Override
    public List<Commodity> findAllByPerson(String buyerName) {
        return commodityRepository.findByBuyerName(buyerName);
    }

    /* 通过商品名获得商品信息 */
    @Override
    public Commodity findByName(String name) {
        return commodityRepository.findByName(name);
    }

    /* 购买商品 */
    @Override
    public Commodity buyCommodity(String comName, String buyerName) {
        Commodity commodity = commodityRepository.findByName(comName);
        commodity.setBuyerName(buyerName);
        commodity.setSell(1);
        commodityRepository.save(commodity);
        return commodity;
    }

    /* 查询已卖出的商品 */
    @Override
    public List<Commodity> findSelledCommodity() {
        return commodityRepository.findBySellEquals(1);
    }

    /* 查询未卖出的商品 */
    @Override
    public List<Commodity> findNoSelledCommodity() {
        return commodityRepository.findBySellEquals(0);
    }

    /* 添加商品 */
    @Override
    public Commodity addCommodity(String comName, double price) {
        Commodity commodity = new Commodity();
        commodity.setName(comName);
        commodity.setPrice(price);
        commodity.setSell(0);
        commodityRepository.save(commodity);
        return commodity;
    }
}
