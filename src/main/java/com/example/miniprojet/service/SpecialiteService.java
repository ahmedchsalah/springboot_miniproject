package com.example.miniprojet.service;

import com.example.miniprojet.model.Etudiant;
import com.example.miniprojet.model.Specialite;
import com.example.miniprojet.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteService {
    @Autowired
    SpecialiteRepository specialiteRepository;
    public Specialite addSpecialite(Specialite specialite){
        return specialiteRepository.save(specialite);
    }

    public void deleteSpecialite(Long id){
        specialiteRepository.deleteById(id);
    }
    public Specialite getSpecialite(Long id){
        return specialiteRepository.findById(id).orElse(null);
    }
    @Transactional
    public Specialite updateSpecialite(Long id, Specialite upSpecialite) {
        Specialite specialite = specialiteRepository.findById(id).get();
        specialite.setNomSpec(upSpecialite.getNomSpec());
        specialite.setNbrPlaces(upSpecialite.getNbrPlaces());
        return specialiteRepository.save(specialite);
    }
    public List<Specialite> getAll(){
        return specialiteRepository.findAll();
    }
    public List<Specialite> getSpecialityByKeyword(String key){
        return specialiteRepository.searchSpecialite(key);
    }


}
