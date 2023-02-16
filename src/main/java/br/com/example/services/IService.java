package br.com.example.services;

import java.util.List;

public interface IService<T> {

    T findById(Long id);
    List<T> findAll();
    T save(T t);
    void update(T t);
    void delete(Long id);

}
