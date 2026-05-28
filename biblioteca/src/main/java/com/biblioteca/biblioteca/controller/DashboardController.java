package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired private CategoriaRepository categoriaRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();

        List<String> nomesCategorias = new ArrayList<>();
        List<Integer> quantidadeLivros = new ArrayList<>();

        for (Categoria cat : categorias) {
            nomesCategorias.add(cat.getNome());
            quantidadeLivros.add(cat.getLivros() != null ? cat.getLivros().size() : 0);
        }

        model.addAttribute("nomesCategorias", nomesCategorias);
        model.addAttribute("quantidadeLivros", quantidadeLivros);

        return "dashboard";
    }
}