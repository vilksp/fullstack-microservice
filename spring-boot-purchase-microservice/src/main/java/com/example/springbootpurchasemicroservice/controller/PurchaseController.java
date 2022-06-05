package com.example.springbootpurchasemicroservice.controller;

import com.example.springbootpurchasemicroservice.model.Purchase;
import com.example.springbootpurchasemicroservice.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {


        return new ResponseEntity<>(purchaseService.createNewPurchase(purchase), HttpStatus.ACCEPTED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<List<Purchase>> getAllPurchasesByUserId(@PathVariable Long userId) {

        return new ResponseEntity<>(purchaseService.findAllPurchasesByUser(userId), HttpStatus.OK);
    }
}
