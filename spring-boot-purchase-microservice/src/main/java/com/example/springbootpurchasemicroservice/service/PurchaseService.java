package com.example.springbootpurchasemicroservice.service;

import com.example.springbootpurchasemicroservice.model.Purchase;
import com.example.springbootpurchasemicroservice.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;


    public Purchase createNewPurchase(Purchase purchase){
        purchase.setPurchaseTime(LocalDateTime.now());

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> findAllPurchasesByUser(Long userId){

        return purchaseRepository.findAllByUserId(userId);
    }
}
