package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.City;
import com.srt.bookmyshow_naga.repos.CityRepository;
import com.srt.bookmyshow_naga.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findCityById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public List<City> addAllCities(List<City> cities) {
        return cityRepository.saveAll(cities);
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }
}
