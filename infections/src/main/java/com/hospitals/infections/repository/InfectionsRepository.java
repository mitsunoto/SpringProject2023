package com.hospitals.infections.repository;

import com.hospitals.infections.model.Infections;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfectionsRepository extends CrudRepository<Infections, String> {
    public List<Infections> findByHospitalName(String hospitalName);
    public Infections findByHospitalNameAndPatientsNumber(String hospitalName, String patientsNumber);
    public Infections findByHospitalNameAndId(String hospitalName, int id);
}
