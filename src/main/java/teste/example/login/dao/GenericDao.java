package teste.example.login.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    void create(T newInstance);

    List<T> findAll();
    
    T update(T transientObject);

    void delete(T persistentObject);
    
}