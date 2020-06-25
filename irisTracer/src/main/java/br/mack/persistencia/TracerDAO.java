package br.mack.persistencia;
import br.mack.api.Result;
import br.mack.api.Tracer;

import java.util.List;


public interface TracerDAO {
    boolean create(Tracer tracer);
    boolean delete(int opc);
    boolean update(Tracer tracer);
    List<Tracer> read ();
    List<Result> result();

}

