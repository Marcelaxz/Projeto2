package br.mack.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tracer implements Serializable {
    private long id;
    private String nome;
    private double percurso;
    private Date diaCorrido;
    private List<Result> results;

    public Tracer(){this.results = new ArrayList();
    }

    public Tracer(long id, String nome, double percurso, Date diaCorrido, List<Result> data){
        this.id = id;
        this.nome = nome;
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
        this.results = data;
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

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results == null ? new ArrayList() : results;
    }
}
