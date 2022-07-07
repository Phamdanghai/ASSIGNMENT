package com.nashtech.assignment.pdh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.OrderDetail;
import com.nashtech.assignment.pdh.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	@Query("SELECT od.details FROM Orders od where od.orId= :orId")
	public List<OrderDetail> findAllyIdOrder(Long orId);
	
//	public Orders findByIdOrder(Long id);
	public List<Orders> findAll();
}
