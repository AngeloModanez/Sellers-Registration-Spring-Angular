package com.sellers.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellers.backend.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
