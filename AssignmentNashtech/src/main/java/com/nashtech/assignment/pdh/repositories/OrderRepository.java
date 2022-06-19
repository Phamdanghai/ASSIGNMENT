package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
