package com.simplon.hospidieuBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.hospidieuBack.model.Bed;
import com.simplon.hospidieuBack.model.Patient;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {

	Bed findBedsByPatient(Patient patient);
}
