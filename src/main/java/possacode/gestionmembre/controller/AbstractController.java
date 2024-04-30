package possacode.gestionmembre.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AbstractController <T>{

    public T save( T t);
    public T findById(Integer id);
    public List<T> findAll();
    public void deleteById(Integer id);
}
