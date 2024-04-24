package com.dinhnguyendev.microservice.currencyconversionservice.feign;

import com.dinhnguyendev.microservice.currencyconversionservice.dto.response.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "currency-exchange" ,url = "http://localhost:8000/currency-exchange/")
@FeignClient(value = "currency-exchange" )
public interface CurrencyExchangeFeign {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionResponse retrieve(@PathVariable String from, @PathVariable String to);

}
