package com.tema1.data;

import java.util.List;
import java.util.Map;

public interface IData<T> {

    public List<T> findAll();
    public Map<Integer, T> findAllWithIds();


}
