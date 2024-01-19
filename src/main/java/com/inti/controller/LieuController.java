package com.inti.controller;

import com.inti.model.Lieu;
import com.inti.service.ILieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/lieu")
public class LieuController {
    @Autowired
    private ILieuService lieuService;

    @GetMapping("/getAllLieu")
    public String getAllLieu(Model model){
        List<Lieu> listeLieu = lieuService.getAllLieu();
        model.addAttribute("listeLieu", listeLieu);

        return "listeLieu";
    }

    @GetMapping("/createFormulaireLieu")
    public String getFormulaireLieu(){
        return "formulaireLieu";
    }

    @PostMapping("/saveLieu")
    public String saveLieu(@ModelAttribute("lieu") Lieu lieu){
        lieuService.saveLieu(lieu);
        return "redirect:getAllLieu";
    }
}
