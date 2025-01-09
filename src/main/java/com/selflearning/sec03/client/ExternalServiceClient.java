package com.selflearning.sec03.client;

import com.selflearning.common.AbstarctHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstarctHttpClient {

    public Flux<String> getNames(){
        return this.httpClient.get()
                .uri("/demo02/name/stream")
                .responseContent()
                .asString();
    }

    public Flux<Integer> getPriceChanges(){
        return this.httpClient.get()
                .uri("/demo02/stock/stream")
                .responseContent().
                asString()
                .map(Integer::parseInt);

    }
}
