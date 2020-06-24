package br.mack.api;

import java.io.Serializable;

public class Result implements Serializable {
    String date;
    Long value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
