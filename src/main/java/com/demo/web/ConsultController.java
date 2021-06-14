package com.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.repo.ConsultRepo;
import com.demo.entities.consultation;


@Controller
public class ConsultController {
    @Autowired
    private ConsultRepo ConsultRepo;

    @GetMapping(path = "/ListeConsult")
    public String ListeConsult(
            Model model,Long id,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5")int size){
        Page<consultation> ConsultPage = ConsultRepo.findById(id,PageRequest.of(page,size));
        model.addAttribute("Consult",ConsultPage.getContent());
        model.addAttribute("pages",new int[ConsultPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        return "ListeConsult";
    }
}