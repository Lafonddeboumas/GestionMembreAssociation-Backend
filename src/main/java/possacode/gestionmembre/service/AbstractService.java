package possacode.gestionmembre.service;

import java.util.List;

public interface AbstractService <T>{

    T save(T t);

    T update(T t);

    T findById(Integer id);

    List<T> findAll();

    void delete(Integer id);
}
