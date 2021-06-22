package com.example.account.entity;

import java.util.List;

public class WeeklyCostBean {

    /**
     * totalAmount : -179
     * detailAmount : [0,0,0,0,0,0,-179]
     * displayDetailDTOList : [{"name":"测试","imageUrl":"test_url","amount":-179,"percent":1}]
     */

    private double totalAmount;
    private List<Double> detailAmount;
    private List<DisplayDetailDTOListBean> displayDetailDTOList;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Double> getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(List<Double> detailAmount) {
        this.detailAmount = detailAmount;
    }

    public List<DisplayDetailDTOListBean> getDisplayDetailDTOList() {
        return displayDetailDTOList;
    }

    public void setDisplayDetailDTOList(List<DisplayDetailDTOListBean> displayDetailDTOList) {
        this.displayDetailDTOList = displayDetailDTOList;
    }

    public static class DisplayDetailDTOListBean {
        /**
         * name : 测试
         * imageUrl : test_url
         * amount : -179
         * percent : 1
         */

        private String name;
        private String imageUrl;
        private double amount;
        private double percent;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }
    }
}
