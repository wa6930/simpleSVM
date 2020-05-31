package com.example.secondhandmarket.controller;

import com.example.secondhandmarket.domain.Commodity;
import com.example.secondhandmarket.service.CommodityService;
import com.example.secondhandmarket.util.NumHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/CommodiyController")
public class CommodiyController {
    @Autowired
    private CommodityService commodityService;

    /* 获取所有商品信息 */
    @RequestMapping(value = "/allCommodity")
    public List<Commodity> getAllCommodity(){
        return commodityService.findAll();
    }

    /* 获取用户购买的商品 */
    @RequestMapping(value = "/personCommodity")
    public List<Commodity> personalCommodity(@RequestParam(value = "buyername") String buyername){
        System.out.println(buyername);
        return commodityService.findAllByPerson(buyername);
    }

    /* 根据商品名查找商品 */
    @RequestMapping(value = "/getCommodity")
    public Commodity getACommodity(@RequestParam(value = "comname") String name){
        return commodityService.findByName(name);
    }

    /* 判断商品是否存在，true为不存在 */
    public boolean commodityNotExist(String name){
        Commodity commodity = getACommodity(name);
        if(commodity == null){
            return true;
        }
        return false;
    }

    /* 用户添加商品 */
    @RequestMapping(value = "/addCommodity")
    public boolean addCommodity(@RequestParam(value = "comname") String comName,
                                  @RequestParam(value = "price") String price){
        System.out.println(comName + " " + price);
        if(NumHelper.isNumber(price)) {
            if(commodityNotExist(comName)) {
                double n_price = Double.parseDouble(price);
                Commodity commodity = commodityService.addCommodity(comName, n_price);
                if (commodity == null) {
                    return false;
                } else {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /* 用户购买商品 */
    @RequestMapping(value = "/buyCommodity")
    public boolean buyCommodity(@RequestParam(value = "comname") String comName,
                                @RequestParam(value = "buyername") String buyername){
        System.out.println(comName + " " + buyername);
        if(!isSelled(comName)){
            commodityService.buyCommodity(comName, buyername);
            return true;
        }
        return false;
    }

    /* 查询商品是否卖出 */
    @RequestMapping(value = "/searchSell")
    public boolean searchSelled(@RequestParam(value = "comname") String comName){
        if(isSelled(comName)){
            return true;
        }
        return false;
    }

    /* 判断商品是否卖出 */
    public boolean isSelled(String comName){
        if(commodityService.findByName(comName).getSell() == 1){
            return true;
        }
        return false;
    }

    /* 查询已卖出的商品 */
    @RequestMapping(value = "/selled")
    public List<Commodity> searchSelledCommodity(){
        return commodityService.findSelledCommodity();
    }

    /* 查询未卖出的商品 */
    @RequestMapping(value = "/noselled")
    public List<Commodity> searchNoSelledCommodity(){
        return commodityService.findNoSelledCommodity();
    }
}
