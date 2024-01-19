package com.inti.service;

import com.inti.model.Lieu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILieuService {
    public List<Lieu> getAllLieu();
    public Lieu saveLieu(Lieu lieu);
    public Lieu getLieu(Long id);
    public boolean updateLieu(Lieu lieu);
    public void deleteLieu(Long id);
}
