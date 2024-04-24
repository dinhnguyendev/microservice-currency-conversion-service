package com.dinhnguyendev.microservice.currencyconversionservice.controller;


import com.dinhnguyendev.microservice.currencyconversionservice.dto.response.CurrencyConversionResponse;
import com.dinhnguyendev.microservice.currencyconversionservice.feign.CurrencyExchangeFeign;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {


    @Autowired
    private CurrencyExchangeFeign currencyExchangeFeign;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse calculateCurrencyConversion(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity
            ){

//        Map<String,String> parameters =new HashMap<>();
//        parameters.put("from",from);
//        parameters.put("to",to);
//        ResponseEntity<CurrencyConversionResponse> result = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
//                CurrencyConversionResponse.class, parameters
//                );
        CurrencyConversionResponse response =this.currencyExchangeFeign.retrieve(from,to);
        return response;
    }
}
