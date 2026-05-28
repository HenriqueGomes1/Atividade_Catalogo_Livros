package com.biblioteca.biblioteca;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.repository.AutorRepository;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDados {

    @Bean
    CommandLineRunner carregarDadosIniciais(AutorRepository autorRepo, CategoriaRepository catRepo) {
        return args -> {

            if (catRepo.count() == 0) {
                catRepo.save(new Categoria("Fantasia"));
                catRepo.save(new Categoria("Suspense"));
                catRepo.save(new Categoria("Romance"));
                catRepo.save(new Categoria("Mistério"));
                catRepo.save(new Categoria("Realismo"));
            }

            if (autorRepo.count() == 0) {
                Autor autor1 = new Autor(); autor1.setNome("J.K. Rowling");
                Autor autor2 = new Autor(); autor2.setNome("Stephen King");
                Autor autor3 = new Autor(); autor3.setNome("George R.R. Martin");
                Autor autor4 = new Autor(); autor4.setNome("Agatha Christie");
                Autor autor5 = new Autor(); autor5.setNome("Machado de Assis");
                Autor autor6 = new Autor(); autor6.setNome("J.R.R. Tolkien");
                Autor autor7 = new Autor(); autor7.setNome("Dan Brown");
                Autor autor8 = new Autor(); autor8.setNome("Clarice Lispector");
                Autor autor9 = new Autor(); autor9.setNome("Rick Riordan");
                Autor autor10 = new Autor(); autor10.setNome("Gabriel García Márquez");

                autorRepo.save(autor1);
                autorRepo.save(autor2);
                autorRepo.save(autor3);
                autorRepo.save(autor4);
                autorRepo.save(autor5);
                autorRepo.save(autor6);
                autorRepo.save(autor7);
                autorRepo.save(autor8);
                autorRepo.save(autor9);
                autorRepo.save(autor10);
            }
        };
    }
}