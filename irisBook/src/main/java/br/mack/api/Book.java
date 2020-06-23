package br.mack.api;

import java.util.Date;

public class Book {
    private long id;
    private int qtd;
    private Date week;

    public Book() { }

    public Book(long id, int qtd, Date week) {
        this.id = id;
        this.qtd = qtd;
        this.week = week;
    }

    public Book(int qtd, Date week) {
        this.qtd = qtd;
        this.week = week;
    }

    public long getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }

    public Date getWeek() {
        return week;
    }

}
