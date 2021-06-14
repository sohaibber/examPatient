package com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.repo.MedecinRepo;
import com.demo.entities.medecin;


@Controller
public class MedecinController {
    @Autowired
    private MedecinRepo MedecinRepo;

    @GetMapping(path = "/ListeMed")
    public String ListeMed(
            Model model,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5")int size,
            @RequestParam(name="motCle", defaultValue = "") String motCle){
        Page<medecin> medecinsPage = MedecinRepo.findByNomContains(motCle,PageRequest.of(page,size));
        model.addAttribute("medecins",medecinsPage.getContent());
        model.addAttribute("pages",new int[medecinsPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        model.addAttribute("motCle",motCle);
        return "Liste";
    }

    @GetMapping(path = "/Deletemedecin")
    public String Deletemedecin(Long id, String motCle, int page, int size){
        MedecinRepo.deleteById(id);
        System.out.println(id);
        return "redirect:/Liste?motCle="+motCle+"&page="+page+"&size="+size;
    }
    @GetMapping(path = "/Addmedecin")
    public String Addmedecin(Model model){
        model.addAttribute("medecin",new medecin());
        return "Addmedecin";
    }

    @PostMapping(path = "/validermedecin")
    public String validermedecin(medecin medecin){
        MedecinRepo.save(medecin);
        return "redirect:/Liste";
    }
    @GetMapping(path = "/Updatemedecin")
    public String Updatemedecin(Model model,Long id){
        medecin pt=MedecinRepo.findById(id).get();
        model.addAttribute("medecin",pt);
        return "Addmedecin";
    }


}
