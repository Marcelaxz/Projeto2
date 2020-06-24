package br.mack.persistencia;

import br.mack.entidade.Tracer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TracerDAOMySQL implements TracerDAO{
    private final MySQLConnection mysql = new MySQLConnection();
    String createSQL = "INSERT INTO tracer VALUES (?, ?, ?)";
    private String updateSQL = "UPDATE tracer SET nome=?, percurso=?, diaCorrido=? WHERE id=?";
    String deleteSQL = "DELETE FROM tracer WHERE id=?";
    private String readSQL = "SELECT * FROM tracer";

    public TracerDAOMySQL(){

    }

    // C       R       E       A       T
    @Override
    public boolean create(Tracer tracer) {
        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setLong(1, tracer.getId());
            stm.setString(2, tracer.getNome());
            stm.setDouble(3, tracer.getPercurso());
            stm.setDate(4, new java.sql.Date(tracer.getDiaCorrido().getTime()));


            int registros = stm.executeUpdate();

            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    // D       E       L       E       T       E
    @Override
    public boolean delete(int opc) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setInt(1, opc);

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    // U        P       D       A       T       E
    @Override
    public boolean update(Tracer tracer) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1, tracer.getNome());
            stm.setDouble(2, tracer.getPercurso());
            stm.setDate(3, new java.sql.Date(tracer.getDiaCorrido().getTime()));

            int registros = stm.executeUpdate();

            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    // R        E       A       D
    @Override
    public void read() {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                Double percurso = rs.getDouble("percurso");
                Date diaCorrido = rs.getDate("diaCorrido");
                System.out.println("\nId: " + id + "\nNome: " + nome + "\nPercurso: " + percurso + "\nDiaCorrido: " + diaCorrido);
            }
            rs.close();
            conexao.close();

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
