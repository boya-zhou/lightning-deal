package com.seckillhigh.vo;

import com.seckillhigh.entity.Goods;

import java.time.LocalDateTime;

public class GoodsVo extends Goods {

    private double miaoshPrice;
    private int stockCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public double getMiaoshPrice() {
        return miaoshPrice;
    }

    public void setMiaoshPrice(double miaoshPrice) {
        this.miaoshPrice = miaoshPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
