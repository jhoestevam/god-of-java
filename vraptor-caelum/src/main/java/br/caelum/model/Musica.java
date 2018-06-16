package br.caelum.model;

import javax.persistence.*;

@Entity
public class Musica {

    @EmbeddedId
    private MusicaId id;

    private String nome;

    @Id
    @OneToOne
    @JoinColumn(name = "codigo_unico")
    private CodigoUnico codigoUnico;

    @Id
    @OneToOne
    @JoinColumn(name = "autor")
    private Pessoa autor;

    public Musica() {
    }

    public Musica(MusicaId id, String nome, CodigoUnico codigoUnico, Pessoa autor) {
        this.id = id;
        this.nome = nome;
        this.codigoUnico = codigoUnico;
        this.autor = autor;
    }

    public MusicaId getId() {
        return id;
    }

    public void setId(MusicaId id) {
        this.id = id;
    }

    public CodigoUnico getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(CodigoUnico codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
