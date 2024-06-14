package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Jogo;
import application.repository.JogoRepository;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepo;

    @RequestMapping("/insert")
    public String insert() {
        return "jogos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo, @RequestParam("generoId") long generoId, @RequestParam("multiplayer") boolean multiplayer) {
        Jogo jogo = new Jogo();
        jogo.setTitulo(titulo);
        jogo.setGeneroId(generoId);
        jogo.setMultiplayer(multiplayer);

        jogoRepo.save(jogo);

        return "redirect:/jogos/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("jogos", jogoRepo.findAll());

        return "jogos/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model model) {
        Optional<Jogo> result = jogoRepo.findById(id);
        if (result.isPresent()) {
            model.addAttribute("jogo", result.get());
            return "jogos/update";
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("titulo") String titulo, @RequestParam("generoId") long generoId, @RequestParam("multiplayer") boolean multiplayer) {
        Optional<Jogo> result = jogoRepo.findById(id);
        if (result.isPresent()) {
            Jogo jogo = result.get();
            jogo.setTitulo(titulo);
            jogo.setGeneroId(generoId);
            jogo.setMultiplayer(multiplayer);

            jogoRepo.save(jogo);
        }
        return "redirect:/jogos/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model model) {
        Optional<Jogo> result = jogoRepo.findById(id);
        if (result.isPresent()) {
            model.addAttribute("jogo", result.get());
            return "jogos/delete";
        }

        return "redirect:/jogos/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        jogoRepo.deleteById(id);

        return "redirect:/jogos/list";
    }
}
