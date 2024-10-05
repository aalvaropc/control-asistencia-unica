package com.backpoc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backpoc.persistence.entity.QrGenerated;

@Repository
public interface QrGeneratedRepository extends JpaRepository<QrGenerated, Long> {

}
