package com.nashtech.assignment.pdh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.OrderDetail;
import com.nashtech.assignment.pdh.services.IOrderDetailService;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
//	@Query("SELECT od FROM orderdetail od where orId= :orId")
//	List<IOrderDetailService> findAllyIdOrder(@Param("orId") Long idOrder);
}
