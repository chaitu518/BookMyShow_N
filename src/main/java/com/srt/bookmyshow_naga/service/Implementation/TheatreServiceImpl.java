package com.srt.bookmyshow_naga.service.Implementation;

import com.srt.bookmyshow_naga.model.Theatre;
import com.srt.bookmyshow_naga.repos.CityRepository;
import com.srt.bookmyshow_naga.repos.TheatreRepository;
import com.srt.bookmyshow_naga.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    public TheatreServiceImpl(TheatreRepository theatreRepository, CityRepository cityRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }
    @Override
    public List<Theatre> getTheatresByCityId(int city_Id) {
        return theatreRepository.findBycityId(city_Id);
    }

    @Override
    public List<Theatre> addAllCityTheatres(int city_Id,List<Theatre> theatres) {
        for (Theatre theatre : theatres) {
            cityRepository.findById(city_Id).ifPresent(theatre::setCity);
        }
        return theatreRepository.saveAll(theatres);
    }

}
