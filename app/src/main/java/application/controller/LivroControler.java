package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import application.repository.LivroRepository;

import application.repository.GeneroRepository;

@Controller
@RequestMapping("/livros")
public class LivroControler {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model ui){
        ui.addAttribute("livros", livroRepo.findAll());
        return "/livros/list";
    }

    @RequestMapping("/insert")
    public String insert(Model ui){
        ui.addAttribute("genero", generoRepo.findAll());
        return "/livros/insert";
    }
    
}
