package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {

}
