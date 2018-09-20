package com.seckillhigh.vo;

import com.seckillhigh.entity.Goods;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class MiaoshaGoodsVo extends Goods implements Serializable {

    private double miaoshaPrice;
    private int stockCount;
    private Date startDate;
    private Date endDate;

    public double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
