package com.mcg.common.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

    @Autowired
    private R dao;
    @Override
    @Transactional
    public Iterable<E> findAll(){
        return dao.findAll();
    }

    @Override
    @Transactional
    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return dao.save(entity);
    }

    @Override
    @Transactional
    public void deletedById(Long id) {
        dao.deleteById(id);
    }

}
