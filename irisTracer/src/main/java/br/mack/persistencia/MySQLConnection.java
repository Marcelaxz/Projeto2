package br.mack.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    String url = "jdbc:mysql://dorime.mooo.com:3306/ElGoog";
    String usuario = "root";
    String senha = "123";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection(url, usuario, senha);
        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
