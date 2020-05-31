package com.example.secondhandmarket.dao;

import com.example.secondhandmarket.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    /* 获取所有名字为 name 的商品 */
    public Commodity findByName(String name);

    /* 获取所有 已/未 卖出的商品 */
    public List<Commodity> findBySellEquals(int selled);

    /* 获取用户购买的商品 */
    public List<Commodity> findByBuyerName(String buyerName);

}
