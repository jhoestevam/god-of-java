package br.caelum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CodigoUnico implements Serializable {

    @Id
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataResgistro;

    private String codigoUnicoHash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataResgistro() {
        return dataResgistro;
    }

    public void setDataResgistro(Date dataResgistro) {
        this.dataResgistro = dataResgistro;
    }

    public String getCodigoUnicoHash() {
        return codigoUnicoHash;
    }

    public void setCodigoUnicoHash(String codigoUnicoHash) {
        this.codigoUnicoHash = codigoUnicoHash;
    }
}
