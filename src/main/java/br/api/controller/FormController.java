package br.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.api.model.Address;

@Controller
public class FormController {
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("address", new Address());
        return "form";
    }

    @RequestMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
