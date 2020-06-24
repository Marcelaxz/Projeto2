package br.mack.api;

import java.io.Serializable;
import java.util.Date;

public class Tracer implements Serializable {
    private long id;
    private String nome;
    private double percurso;
    private Date diaCorrido;

    public Tracer(){}

    public Tracer(long id, String nome, double percurso, Date diaCorrido){
        this.id = id;
        this.nome = nome;
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
    }

    public Tracer(String nome, double percurso, Date diaCorrido){
        this.nome = nome;
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){ this.id = id; }

    public String getNome(){ return nome; }

    public void setNome(String nome){ this.nome = nome; }

    public double getPercurso(){
        return percurso;
    }

    public void setPercurso(double percurso){ this.percurso = percurso; }

    public Date getDiaCorrido(){
        return diaCorrido;
    }

    public void setDiaCorrido(Date diaCorrido){this.diaCorrido = diaCorrido; }

}
