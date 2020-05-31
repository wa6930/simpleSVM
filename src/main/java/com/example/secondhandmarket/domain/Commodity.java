package com.example.secondhandmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/* 商品类 */
@Data
@Getter
@Setter
@Entity
@Table(name = "commodity")
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comname")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "buyername")
    private String buyerName;

    @Column(name = "sell")
    private int sell;

}
