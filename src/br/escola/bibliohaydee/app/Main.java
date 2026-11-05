package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        carregarAcervoTeste(autores, livros);

        System.out.println("=========== BIBLIOTECA HAYDEÉ ===========");
        listarAcervo(livros);

        int opcao;

        do {
            System.out.println("\n=========== MENU PRINCIPAL ===========");
            System.out.println("1 - Pesquisar por título");
            System.out.println("2 - Pesquisar por autor");
            System.out.println("3 - Gerar relatório do acervo");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        pesquisarPorTitulo(livros);
                        break;

                    case 2:
                        pesquisarPorAutor(livros);
                        break;

                    case 3:
                        gerarRelatorioAcervo(livros);
                        break;

                    case 0:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                opcao = -1;
                System.out.println("Digite uma opção válida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void carregarAcervoTeste(
            ArrayList<Autor> autores,
            ArrayList<Livro> livros) {

        Autor machado = new Autor(
                "Machado de Assis", "brasileira", 1839);
        autores.add(machado);

        Autor graciliano = new Autor(
                "Graciliano Ramos", "brasileira", 1892);
        autores.add(graciliano);

        Autor aluisio = new Autor(
                "Aluísio Azevedo", "brasileira", 1857);
        autores.add(aluisio);

        Autor jorge = new Autor(
                "Jorge Amado", "brasileira", 1912);
        autores.add(jorge);

        livros.add(new Livro(
                "Dom Casmurro",
                "9788525406958",
                machado,
                1899,
                "Romance"
        ));

        livros.add(new Livro(
                "Memórias Póstumas de Brás Cubas",
                "9788525406959",
                machado,
                1881,
                "Romance"
        ));

        livros.add(new Livro(
                "Quincas Borba",
                "9788525406960",
                machado,
                1891,
                "Romance"
        ));

        livros.add(new Livro(
                "Vidas Secas",
                "9788579028497",
                graciliano,
                1938,
                "Romance"
        ));

        livros.add(new Livro(
                "O Cortiço",
                "9788535910668",
                aluisio,
                1890,
                "Romance"
        ));

        livros.add(new Livro(
                "Capitães da Areia",
                "9788535911696",
                jorge,
                1937,
                "Romance"
        ));
    }

    private static void listarAcervo(ArrayList<Livro> livros) {

        System.out.println("\n=========== ACERVO ===========");

        if (livros.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println("\n" + livro);
        }
    }

    private static void pesquisarPorTitulo(ArrayList<Livro> livros) {

        System.out.println("\n=========== PESQUISAR POR TÍTULO ===========");

        System.out.print("Digite parte do título: ");
        String termo = scanner.nextLine();

        if (termo == null || termo.isBlank()) {
            System.out.println("O termo de pesquisa não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase(Locale.ROOT);

        boolean encontrou = false;

        for (Livro livro : livros) {

            String titulo = livro.getTitulo()
                    .trim()
                    .toLowerCase(Locale.ROOT);

            if (titulo.contains(termo)) {

                System.out.println("\n" + livro);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private static void pesquisarPorAutor(ArrayList<Livro> livros) {

        System.out.println("\n=========== PESQUISAR POR AUTOR ===========");

        System.out.print("Digite o nome ou sobrenome do autor: ");
        String termo = scanner.nextLine();

        if (termo == null || termo.isBlank()) {
            System.out.println("O nome do autor não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase(Locale.ROOT);

        boolean encontrou = false;

        for (Livro livro : livros) {

            String nomeAutor = livro.getAutor()
                    .getNome()
                    .trim()
                    .toLowerCase(Locale.ROOT);

            boolean nomeCompleto = nomeAutor.equals(termo);

            boolean encontrouParte = false;

            String[] partesNome = nomeAutor.split("\\s+");

            for (String parte : partesNome) {

                if (parte.equals(termo)) {
                    encontrouParte = true;
                    break;
                }
            }

            if (nomeCompleto || encontrouParte) {

                System.out.println("\n" + livro);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum autor encontrado.");
        }
    }


    private static void gerarRelatorioAcervo(ArrayList<Livro> livros) {

        StringBuilder relatorio = new StringBuilder();

        relatorio.append("\n=========== RELATÓRIO DO ACERVO ===========\n");

        if (livros.isEmpty()) {

            relatorio.append("Não há livros cadastrados.\n");

        } else {

            int numero = 1;

            for (Livro livro : livros) {

                relatorio.append("\nLivro ").append(numero).append("\n");

                relatorio.append("Título: ")
                        .append(livro.getTitulo()).append("\n");

                relatorio.append("Autor: ")
                        .append(livro.getAutor().getNome()).append("\n");

                relatorio.append("Disponibilidade: ")
                        .append(livro.isDisponibilidade()
                                ? "Disponível" : "Emprestado")
                        .append("\n");

                numero++;
            }

            relatorio.append("\nTotal de livros: ")
                    .append(livros.size())
                    .append("\n");
        }

        System.out.println(relatorio.toString());
    }
}
