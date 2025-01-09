package com.selflearning.sec02.client;

import com.selflearning.common.AbstarctHttpClient;
import reactor.core.publisher.Mono;

public class ExtrenalServiceClient extends AbstarctHttpClient {

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();
    }
}
