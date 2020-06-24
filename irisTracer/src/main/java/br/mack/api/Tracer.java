package br.mack.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Tracer implements Serializable {
    private long id;
    private double percurso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")

    private Date diaCorrido;

    public Tracer(){}

    public Tracer(long id, double percurso, Date diaCorrido){
        this.id = id;
        this.percurso = percurso;
        this.diaCorrido = diaCorrido;
    }

    public Tracer(double percurso, Date diaCorrido){
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

    public Date getDiaCorrido(){
        return diaCorrido;
    }

    public void setDiaCorrido(Date diaCorrido){this.diaCorrido = diaCorrido; }

}
