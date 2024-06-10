package com.dyplom.travel.services;

import com.dyplom.travel.models.BaseEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BasePersistenceService<T extends BaseEntity> {
    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getExistent(long id) {
        return getRepository().findById(id).orElse(null);
    }

    @Transactional
    public T update(T entity) {
        return getRepository().save(entity);
    }

    @Transactional
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Transactional
    public void delete(long id) {
        getRepository().deleteById(id);
    }

    protected abstract JpaRepository<T, Long> getRepository();
}
