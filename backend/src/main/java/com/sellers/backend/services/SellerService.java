package com.sellers.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sellers.backend.dto.seller.SellerRequest;
import com.sellers.backend.dto.seller.SellerResponse;
import com.sellers.backend.models.Seller;
import com.sellers.backend.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

public class SellerService {
  @Autowired
  private SellerRepository sellerRepository;

  public List<SellerResponse> getAll() {
    return sellerRepository.findAll()
        .stream()
        .map(seller -> seller.toDTO())
        .collect(Collectors.toList());
  }

  public SellerResponse getById(long id) {
    Seller seller = sellerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    return seller.toDTO();
  }

  public SellerResponse save(SellerRequest sellerRequest) {
    Seller newSeller = sellerRepository.save(sellerRequest.toEntity());
    return newSeller.toDTO();
  }

  public void deleteById(long id) {
    try {
      sellerRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new EntityNotFoundException("Seller not found");
    }
  }

  public SellerResponse update(long id, SellerRequest sellerRequest) {
    try {
      Seller seller = sellerRepository.getReferenceById(id);

      seller.setName(sellerRequest.getName());
      seller.setSalary(sellerRequest.getSalary());
      seller.setBonus(sellerRequest.getBonus());
      seller.setGender(sellerRequest.getGender());

      return seller.toDTO();
    } catch (EmptyResultDataAccessException e) {
      throw new EntityNotFoundException("Seller not found");
    }
  }
}
