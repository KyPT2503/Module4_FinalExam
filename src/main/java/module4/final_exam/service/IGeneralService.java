package module4.final_exam.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    E findById(Long id);

    void remove(E id);

    E update(E e);

    E add(E e);
}
