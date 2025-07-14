// Arquivo: Biblioteca.java

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Representa uma biblioteca que gerencia uma coleção de livros.
 * Utiliza um HashMap para armazenamento otimizado pelo ISBN.
 */
public class Biblioteca {

    private String nome;
    private final Map<String, Livro> acervo;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.acervo = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    /**
     * Adiciona um livro ao acervo da biblioteca.
     * Se um livro com o mesmo ISBN já existir, ele será substituído.
     * @param livro O livro a ser adicionado.
     */
    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            acervo.put(livro.getIsbn(), livro);
            System.out.println("INFO: Livro '" + livro.getTitulo() + "' adicionado ao acervo.");
        }
    }

    /**
     * Remove um livro do acervo usando seu ISBN.
     * @param isbn O ISBN do livro a ser removido.
     * @return true se o livro foi encontrado e removido, false caso contrário.
     */
    public boolean removerLivro(String isbn) {
        Livro livroRemovido = acervo.remove(isbn);
        if (livroRemovido != null) {
            System.out.println("INFO: Livro '" + livroRemovido.getTitulo() + "' removido do acervo.");
            return true;
        }
        System.out.println("AVISO: Nenhum livro encontrado com o ISBN '" + isbn + "' para remoção.");
        return false;
    }

    /**
     * Busca um livro no acervo pelo seu ISBN.
     * @param isbn O ISBN do livro a ser buscado.
     * @return um Optional contendo o livro se encontrado, ou um Optional vazio caso contrário.
     */
    public Optional<Livro> buscarLivroPorIsbn(String isbn) {
        return Optional.ofNullable(acervo.get(isbn));
    }

    /**
     * Retorna uma coleção com todos os livros do acervo.
     * @return Uma coleção de livros.
     */
    public Collection<Livro> listarTodosOsLivros() {
        return acervo.values();
    }
}