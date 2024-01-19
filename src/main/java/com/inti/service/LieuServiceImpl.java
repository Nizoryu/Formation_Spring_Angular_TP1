package com.inti.service;

import com.inti.model.Lieu;
import com.inti.repository.ILieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LieuServiceImpl implements ILieuService{

    @Autowired
    ILieuRepository lieuRepository;

    @Override
    public List<Lieu> getAllLieu() {
        return lieuRepository.findAll();
    }

    @Override
    public Lieu saveLieu(Lieu lieu) {
        if (lieu != null){
            return lieuRepository.save(lieu);
        }
        return null;
    }

    @Override
    public Lieu getLieu(Long id) {
        if (id != null){
            return lieuRepository.getReferenceById(id);
        }
        return null;
    }

    @Override
    public boolean updateLieu(Lieu lieu) {
        if(lieu != null){
            lieuRepository.save(lieu);
            return true;
        }
        return false;
    }

    @Override
    public void deleteLieu(Long id) {
        if(id != null){
            lieuRepository.deleteById(id);
        }
    }
}
