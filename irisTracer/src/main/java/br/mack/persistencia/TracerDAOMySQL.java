package br.mack.persistencia;

import br.mack.api.Tracer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TracerDAOMySQL implements TracerDAO{
    private final MySQLConnection mysql = new MySQLConnection();
    String createSQL = "INSERT INTO Tracer VALUES (?, ?, ?, ?)";
    private String updateSQL = "UPDATE Tracer SET nome=?, percurso=?, diaCorrido=? WHERE id=?";
    String deleteSQL = "DELETE FROM Tracer WHERE id=?";
    private String readSQL = "SELECT * FROM Tracer";

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
            //stm.setDate(4, new java.sql.Date(tracer.getDiaCorrido().getDate()));
            stm.setDate(4, Date.valueOf(tracer.getDiaCorrido().toString()));


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
            //stm.setDate(3, new java.sql.Date(tracer.getDiaCorrido().getDate()));
            stm.setDate(3, Date.valueOf(tracer.getDiaCorrido().toString()));
            stm.setLong(4, tracer.getId());

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
    public List<Tracer> read(){
        Connection conexao = mysql.getConnection();
        List<Tracer> tracer = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tracer ttracer = new Tracer();
                ttracer.setId(rs.getLong("id"));
                ttracer.setNome(rs.getString("nome"));
                ttracer.setPercurso(rs.getDouble("percurso"));
                ttracer.setDiaCorrido(rs.getDate("diaCorrido"));
                tracer.add(ttracer);
            }

            return tracer;

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
        return tracer;
    }
}
