package com.selflearning.sec03;

import com.selflearning.common.Util;
import com.selflearning.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames().subscribe(Util.subscriber("Sub2"));

        client.getNames().subscribe(Util.subscriber("Sub1"));
        Util.sleepSeconds(6);
    }
}
