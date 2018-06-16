package br.caelum.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MusicaId implements Serializable {

    private int duracaoSegundos;

    private String nome;

    public MusicaId() {
    }

    public MusicaId(int duracaoSegundos, String nome) {
        this.duracaoSegundos = duracaoSegundos;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicaId musicaId = (MusicaId) o;

        if (duracaoSegundos != musicaId.duracaoSegundos) return false;
        return nome.equals(musicaId.nome);
    }

    @Override
    public int hashCode() {
        int result = duracaoSegundos;
        result = 31 * result + nome.hashCode();
        return result;
    }
}
