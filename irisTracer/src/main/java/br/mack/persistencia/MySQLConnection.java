package br.mack.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
  /*  String url="jdbc:mysql://162.241.2.243:3306/ipbuta68_mackenzie";
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
*/
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
