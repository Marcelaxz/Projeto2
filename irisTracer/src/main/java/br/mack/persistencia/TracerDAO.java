package br.mack.persistencia;
import br.mack.entidade.Tracer;

public interface TracerDAO {
    boolean create(Tracer tracer);
    boolean delete(int opc);
    boolean update(Tracer tracer);
    void read();
}

