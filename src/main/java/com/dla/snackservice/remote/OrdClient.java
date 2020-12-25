package com.dla.snackservice.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrdClient {

    @Value ("${food-joint.order.get-api}")
    String baseUrl;

    @Autowired
    RestTemplate restTemplate;

}
