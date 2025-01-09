package com.selflearning.sec02;

import com.selflearning.common.Util;
import com.selflearning.sec02.client.ExtrenalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExtrenalServiceClient();
        for(int i = 0; i < 100; i++){
            client.getProductName(i).subscribe(Util.subscriber());
        }


        Util.sleepSeconds(2);
    }
}
