package com.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        this.kafkaService.updateLocation(
                "(" + (Math.round(Math.random() * 100)) + "," + ((Math.round(Math.random() * 100))) + ")");
        String k1 = "message";
        String v1 = "Location Updated";
        return new ResponseEntity<>(Map.of(k1, v1), HttpStatus.OK);
    }
}
