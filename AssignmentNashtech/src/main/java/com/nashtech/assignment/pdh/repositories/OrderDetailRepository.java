package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
