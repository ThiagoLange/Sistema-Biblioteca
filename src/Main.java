// Arquivo: Main.java

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // 1. Criar a biblioteca
        Biblioteca bibliotecaMunicipal = new Biblioteca("Biblioteca Pública de Joinville");
        System.out.println("Bem-vindo à " + bibliotecaMunicipal.getNome() + "!");
        System.out.println("----------------------------------------------------");

        // 2. Criar alguns livros
        Livro livro1 = new Livro("978-85-325-3078-3", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Livro livro2 = new Livro("978-85-7657-311-8", "O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", 1954);
        Livro livro3 = new Livro("978-85-94318-01-2", "O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979);
        Livro livro4 = new Livro("978-65-5560-478-4", "Duna", "Frank Herbert", 1965);

        // 3. Adicionar os livros à biblioteca
        bibliotecaMunicipal.adicionarLivro(livro1);
        bibliotecaMunicipal.adicionarLivro(livro2);
        bibliotecaMunicipal.adicionarLivro(livro3);
        bibliotecaMunicipal.adicionarLivro(livro4);

        System.out.println("\n----------------------------------------------------");

        // 4. Listar todos os livros no acervo
        System.out.println("Acervo completo da biblioteca:");
        if (bibliotecaMunicipal.listarTodosOsLivros().isEmpty()) {
            System.out.println("A biblioteca está vazia.");
        } else {
            for (Livro livro : bibliotecaMunicipal.listarTodosOsLivros()) {
                System.out.println("- " + livro);
            }
        }

        System.out.println("\n----------------------------------------------------");

        // 5. Buscar um livro específico pelo ISBN
        System.out.println("Buscando livro com ISBN '978-85-7657-311-8'...");
        Optional<Livro> livroEncontrado = bibliotecaMunicipal.buscarLivroPorIsbn("978-85-7657-311-8");

        // Usando ifPresentOrElse para tratar o Optional de forma elegante
        livroEncontrado.ifPresentOrElse(
                livro -> System.out.println("Livro encontrado: " + livro.getTitulo()),
                () -> System.out.println("Livro com este ISBN não foi encontrado.")
        );

        System.out.println("\nBuscando livro com ISBN '000-00-0000-00-0' (não existe)...");
        Optional<Livro> livroNaoEncontrado = bibliotecaMunicipal.buscarLivroPorIsbn("000-00-0000-00-0");
        livroNaoEncontrado.ifPresentOrElse(
                livro -> System.out.println("Livro encontrado: " + livro.getTitulo()),
                () -> System.out.println("Livro com este ISBN não foi encontrado.")
        );

        System.out.println("\n----------------------------------------------------");

        // 6. Remover um livro pelo ISBN
        System.out.println("Removendo o livro 'Duna' (ISBN: 978-65-5560-478-4)...");
        bibliotecaMunicipal.removerLivro("978-65-5560-478-4");

        System.out.println("\n----------------------------------------------------");

        // 7. Listar todos os livros novamente para ver o resultado
        System.out.println("Acervo atualizado da biblioteca:");
        for (Livro livro : bibliotecaMunicipal.listarTodosOsLivros()) {
            System.out.println("- " + livro);
        }
    }
}