package com.example.clinic.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EntityManager<T> extends FacadeEntityManager<T> {

    @Override
    public ResponseEntity<T> EntityOnCreated(T t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }

    @Override
    public ResponseEntity<T> EntityOnOK(T t) {
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    public ResponseEntity<List<T>> EntityOnList(List<T> t){
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }
}
