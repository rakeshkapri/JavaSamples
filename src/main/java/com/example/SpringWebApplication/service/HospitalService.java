package com.example.SpringWebApplication.service;

import com.example.SpringWebApplication.model.Hospital;
import com.example.SpringWebApplication.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;


    public List<Hospital> getAllHospitals(){
        Iterable<Hospital> itr = hospitalRepository.findAll();
        List<Hospital> hospitalList = new ArrayList<>();
        itr.forEach(hospital -> {hospitalList.add(hospital);});
        return hospitalList;
    }

    public Hospital getHospital(int id){
        return hospitalRepository.findById(id).orElse(null);
    }

    public void addHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public void updateHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public void deleteHospital(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }
}
