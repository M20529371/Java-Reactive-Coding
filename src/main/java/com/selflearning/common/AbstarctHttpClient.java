package com.selflearning.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;



public abstract class AbstarctHttpClient {

    private static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    public AbstarctHttpClient(){
        // the below line creates only one thread for our requests and the 1 st parameter says the name of the thread
        // the second parameter says the number of threads being used for the requests and
        // the third parameter says whether the thread is a daemon thread or not,
        // true indicates that it is a daemon thread and false indicates it is not.
        var loopResources = LoopResources.create("vins",2, true);
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL);
    }
}
