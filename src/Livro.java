// Arquivo: Livro.java

import java.util.Objects;

/**
 * Representa um livro com seus dados básicos.
 * O ISBN é utilizado como identificador único.
 */
public class Livro {

    private final String isbn; // Final, pois o ISBN de um livro não deve mudar
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("O ISBN não pode ser nulo ou vazio.");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // --- Getters ---
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // --- Setters (exceto para ISBN) ---
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * Retorna uma representação textual do livro.
     */
    @Override
    public String toString() {
        return "Livro {" +
                "ISBN='" + isbn + '\'' +
                ", Título='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Ano=" + anoPublicacao +
                '}';
    }

    /**
     * Dois livros são considerados iguais se tiverem o mesmo ISBN.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    /**
     * Gera um hash code baseado apenas no ISBN.
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}