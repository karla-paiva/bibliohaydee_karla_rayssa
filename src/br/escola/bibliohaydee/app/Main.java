package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

public class Main {
    static void main() {
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("brasileiro");
        autor.setAnoNascimento(1990);

        Autor outroAutor = new Autor();
        outroAutor.setNome("Ricardo Vasconcelos");
        outroAutor.setNacionalidade("brasileiro");
        outroAutor.setAnoNascimento(1840);

        Livro livro = new Livro("Dom Casmurro", "123456789", autor, 2000, "Ação");
        Livro livro2 = new Livro("Dom Casmurro", "123456789", outroAutor, 2000, "Ação");

        IO.println(livro);
        IO.println(livro2);
    }

    }

