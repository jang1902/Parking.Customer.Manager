package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.infrastructure.store.repository.BaseRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@NoArgsConstructor
public abstract class BaseJPAAdapter<T, ID, R extends BaseRepository<T, ID>> {
    @Autowired(required = false)
    protected R repository;

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public List<T> findAll(Specification<T> specification) {
        return this.repository.findAll((Sort) specification);
    }

    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public List<T> findAll(Sort sort) {
        return this.repository.findAll(sort);
    }

    public T get(ID id) {
        return this.repository.findById(id).orElse((T) null);
    }

    public T save(T entity) {
        return this.repository.save(entity);
    }

    public List<T> saveAll(List<T> entity) {
        return this.repository.saveAll(entity);
    }

    public T saveAndFlush(T entity) {
        return this.repository.saveAndFlush(entity);
    }

    public List<T> saveAllAndFlush(List<T> entity) {
        List<T> temp = this.repository.saveAll(entity);
        this.repository.flush();
        return temp;
    }

    public T update(T entity) {
        return this.repository.save(entity);
    }

    public void delete(ID id) {
        this.repository.deleteById(id);
    }

}
