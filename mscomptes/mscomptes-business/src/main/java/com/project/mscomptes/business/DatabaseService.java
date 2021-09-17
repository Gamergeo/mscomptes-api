package com.project.mscomptes.business;

import java.util.List;

public interface DatabaseService<T> {
	
    public void saveOrUpdate(T type);
    
    public T findById(Integer id);

    public void delete(T type);

    public List<T> findAll();
	
    public void delete(Integer id);
}