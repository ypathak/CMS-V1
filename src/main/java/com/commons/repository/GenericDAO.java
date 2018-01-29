package com.commons.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;

@SuppressWarnings("deprecation")
public interface GenericDAO<T, ID extends Serializable> {

	public void save(T entity);

	public void merge(T entity);

	public void delete(T entity);

	public List<T> findMany(Query<T> query);

	public T findOne(Query<?> query);

	public List<T> findAll(Class<T> clazz);

	public T findByID(Class<T> clazz, BigDecimal id);

}
