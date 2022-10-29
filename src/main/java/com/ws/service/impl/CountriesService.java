package com.ws.service.impl;

import com.ws.model.Countries;
import com.ws.service.ICountriesService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CountriesService implements ICountriesService {
    @Override
    public List<Countries> findAll() {
        return Countries.listAll();
    }

    @Override
    public Countries save(Countries country) {
        country.persist();
        return country;
    }
}
