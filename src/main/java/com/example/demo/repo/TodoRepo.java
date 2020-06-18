package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Todo;

public interface TodoRepo extends MongoRepository<Todo, Integer> {

}
