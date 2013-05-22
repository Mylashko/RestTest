package com.mkyong.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Goods")
public class Goods {

    @Id
    @GeneratedValue

    private int goodsId;

    private String goodsname;
    private String goodsvendor;
    private String goodsunit;
    private String goodstype;
    private String goodscharacteristics;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsvendor() {
        return goodsvendor;
    }

    public void setGoodsvendor(String goodsvendor) {
        this.goodsvendor = goodsvendor;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getGoodscharacteristics() {
        return goodscharacteristics;
    }

    public void setGoodscharacteristics(String goodscharachteristics) {
        this.goodscharacteristics = goodscharachteristics;
    }
}

