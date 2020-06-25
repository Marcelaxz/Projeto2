package br.mack.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;


public class Tracer implements Serializable {
    private long id;
    private double percurso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")

    private String diaCorrido;

    public Tracer(){}

    public Tracer(long id, double percurso, String diaCorrido){
        this.id = id;
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
    }

    public Tracer(double percurso, String diaCorrido){
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){ this.id = id; }

    public double getPercurso(){
        return percurso;
    }

    public void setPercurso(double percurso){ this.percurso = percurso; }

    public String getDiaCorrido(){
        return diaCorrido;
    }

    public void setDiaCorrido(String date) {
        this.diaCorrido = date;
    }


}
