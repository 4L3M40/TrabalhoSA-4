package org.senai.dao;

import java.util.List;

public interface IDAO<T> {
    void inserir(T obj);
    void atualizar(T obj);
    void remover(int id);
    T buscarPorId(int id);
    List<T> listarTodos();
}
