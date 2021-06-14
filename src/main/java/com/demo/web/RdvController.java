package com.demo.web;

import com.demo.entities.rdv;
import com.demo.repo.RdvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RdvController {
    @Autowired
    private RdvRepo rdvRepo;

    @GetMapping(path = "/ListeRdv")
    public String ListeRdv(
            Model model,Long id,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5")int size){
        Page<rdv> rdvPage = rdvRepo.findById(id,PageRequest.of(page,size));
        model.addAttribute("rdv",rdvPage.getContent());
        model.addAttribute("pages",new int[rdvPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        return "ListeRdv";
    }

}
