package com.maryanto.dimas.training.bni.service;

import com.maryanto.dimas.training.bni.model.Kota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WilayahApiService {

    @Autowired
    private RestTemplate restTemplate;

    private String host;
    private String port;
    private String contextPath;

    public WilayahApiService(
            @Value("${server.wilayah-api.host}") String host,
            @Value("${server.wilayah-api.port}") String port,
            @Value("${server.wilayah-api.context-path}") String contextPath) {
        this.host = host;
        this.port = port;
        this.contextPath = contextPath;
    }

    public Optional<Kota> findKotaById(String id) {
        String url = new StringBuilder("http://").append(host).append(":")
                .append(port).append(contextPath)
                .append("api/kota/v1/").append(id).toString();
        Kota kota = this.restTemplate.getForObject(url, Kota.class);
        if (kota != null) return Optional.ofNullable(kota);
        else return Optional.empty();
    }
}
