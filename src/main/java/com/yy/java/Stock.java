package com.yy.java;

/**
 * Created by cc on 2019/7/20.
 */
public class Stock {
    public static void main(String[] args) {
        int[] prices = new int[]{1,7,2,3,6,7,6,7};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
