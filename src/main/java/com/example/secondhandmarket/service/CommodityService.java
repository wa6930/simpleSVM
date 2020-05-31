package com.example.secondhandmarket.service;

import com.example.secondhandmarket.domain.Commodity;

import java.util.List;

public interface CommodityService {

    /* 获取所有商品 */
    public List<Commodity> findAll();

    /* 获取用户所有商品 */
    public List<Commodity> findAllByPerson(String buyerName);

    /* 通过商品名获得商品信息 */
    public Commodity findByName(String name);

    /* 用户购买商品 */
    public Commodity buyCommodity(String comName, String buyerName);

    /* 查询已卖出的商品 */
    public List<Commodity> findSelledCommodity();

    /* 查询未卖出的商品 */
    public List<Commodity> findNoSelledCommodity();

    /* 添加商品 */
    public Commodity addCommodity(String comName, double price);
}
