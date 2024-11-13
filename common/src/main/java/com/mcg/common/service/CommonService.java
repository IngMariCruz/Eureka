package com.mcg.common.service;

import java.util.Optional;

public interface CommonService<E> {
    public Iterable<E> findAll();
    public Optional<E> findById(Long id);
    public E save(E alumno);
    public void deletedById (Long id);
}
