package com.ws.service;

import com.ws.model.Countries;

import java.util.List;

public interface ICountriesService {
    List<Countries> findAll();
    Countries save(Countries country);
}
