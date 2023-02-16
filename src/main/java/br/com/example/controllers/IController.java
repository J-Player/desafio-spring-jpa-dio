package br.com.example.controllers;

import java.util.List;

public interface IController<T, DTO> {

    T findById(Long id);
    List<T> findAll();
    T save(DTO dto);
    void update(DTO dto, Long id);
    void delete(Long id);

}
