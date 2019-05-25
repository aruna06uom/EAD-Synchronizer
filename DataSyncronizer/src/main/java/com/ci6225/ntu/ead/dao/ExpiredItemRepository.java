package com.ci6225.ntu.ead.dao;

import org.springframework.data.repository.CrudRepository;

import com.ci6225.ntu.ead.model.ExpiredItem;

public interface ExpiredItemRepository extends CrudRepository<ExpiredItem,Long> {

}
