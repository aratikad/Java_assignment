package com.assignment_10.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment_10.model.Retailer;

@Repository
public interface RetailerRepositry_V2 extends JpaRepository<Retailer, Integer> {

    
    
}