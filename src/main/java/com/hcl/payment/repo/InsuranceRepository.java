package com.hcl.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.payment.entity.InsuranceEntity;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {

}
