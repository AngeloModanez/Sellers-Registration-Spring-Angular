package com.sellers.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sellers.backend.dto.seller.SellerRequest;
import com.sellers.backend.dto.seller.SellerResponse;
import com.sellers.backend.services.SellerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {
  @Autowired
  SellerService sellerService;

  @GetMapping
  public ResponseEntity<List<SellerResponse>> getSellers() {
    return ResponseEntity.ok(sellerService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<SellerResponse> getSeller(@PathVariable long id) {
    SellerResponse sellerResponse = sellerService.getById(id);
    return ResponseEntity.ok(sellerResponse);
  }

  @PostMapping
  public ResponseEntity<SellerResponse> saveSeller(@Valid @RequestBody SellerRequest sellerRequest) {
    SellerResponse sellerResponse = sellerService.save(sellerRequest);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(sellerResponse.getId())
        .toUri();

    return ResponseEntity.created(location).body(sellerResponse);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteSeller(@PathVariable long id) {
    sellerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Void> putSeller(@PathVariable long id, @Valid @RequestBody SellerRequest sellerRequest) {
    sellerService.update(id, sellerRequest);
    return ResponseEntity.ok().build();
  }
}
