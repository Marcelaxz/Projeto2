package br.mack.dao;

import br.mack.api.Trends;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class TrendsDao {

    Trends dataBase;

    public TrendsDao() {
        this.dataBase = new Trends();

        System.out.println("TrendsDAO - Lendo dados do arquivo CSV");

        try (Scanner scanner = new Scanner(new File("./resources/multiTimeline.csv"));) {

            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] cols = line.split(",");
                Date week = null; // usado para testar se a linha começa com uma data

                try {
                    week = sdf.parse(cols[0]);
                } catch(Exception e) { /*Não é uma data*/ }

                // Lendo dados
                if (week != null) {
                    Results results = new Results();
                    results.setDate(cols[0]);
                    results.setValue(Double.parseDouble(cols[1]));
                    this.dataBase.getResults().add(results);

                    // Lendo cabecalho
                }  else if(cols.length > 0 && (cols[0].equals("Tempo") || cols[0].equals("Tempo"))) {
                    this.dataBase.setTerm(cols[1]);
                }
            }

            System.out.println("TrendsDAO - Leitura realizada");
        } catch (Exception ex) {
            this.dataBase = new Trends();
            ex.printStackTrace();
            System.out.println("TrendsDAO - Erro na leitura do CSV");
        }
    }
    public Trends getAllTrends() {
        return this.dataBase;
    }
}

