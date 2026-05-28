package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.AutorRepository;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired private LivroRepository livroRepository;
    @Autowired private AutorRepository autorRepository;
    @Autowired private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listar(@RequestParam(value = "categoriaId", required = false) Long categoriaId, Model model) {
        if (categoriaId != null) {
            model.addAttribute("livros", livroRepository.findByCategoriaId(categoriaId));
        } else {
            model.addAttribute("livros", livroRepository.findAll());
        }
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "lista-livros";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "form-livro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido"));
        model.addAttribute("livro", livro);
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "form-livro";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}