package br.mack.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    String url="jdbc:mysql://162.241.2.243:3306/ipbuta68_mackenzie";
    String user = "ipbuta68_mack";
    String password = "mackenzie";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);

        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
