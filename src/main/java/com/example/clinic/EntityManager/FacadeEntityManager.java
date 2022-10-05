package com.example.clinic.EntityManager;

import org.springframework.http.ResponseEntity;

abstract class FacadeEntityManager<T> {

    public abstract ResponseEntity<T> EntityOnCreated(T t);

    public abstract ResponseEntity<T> EntityOnOK(T t);

}
