package com.crescendo.repository;

import com.crescendo.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<BusinessEntity, Integer> {
    BusinessEntity findBusinessById(Integer id);
}
