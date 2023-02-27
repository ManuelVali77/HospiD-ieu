package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.Monitoring;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Integer> {

}
