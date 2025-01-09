package com.selflearning.sec03;


import com.selflearning.common.Util;
import com.selflearning.sec03.assignment.StockPriceObserver;
import com.selflearning.sec03.client.ExternalServiceClient;

public class Lec12Assignment {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        var subscriber = new StockPriceObserver();
        client.getPriceChanges().subscribe(subscriber);

        Util.sleepSeconds(20);
    }
}
