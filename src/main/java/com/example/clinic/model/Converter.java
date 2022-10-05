package com.example.clinic.model;


public interface Converter<T, R> {
    R convert(T t);
}
