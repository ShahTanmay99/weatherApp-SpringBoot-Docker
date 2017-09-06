package spring.boot.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.Entity.WeatherDetails;
import spring.boot.Repository.WeatherRepository;
import spring.boot.exception.NotFoundException;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public WeatherDetails post(WeatherDetails weather) {
        return repository.save(weather);
    }
    public WeatherDetails findByCity(String city) {
        return repository.findByCity(city)
                .orElseThrow(() -> new NotFoundException("Weather of city " + city + " does not exist"));
    }

//    public int findbyCity(String city, String property) {
//        return repository.findbyCity(city, property);
//    }
/*
    public List<String> findAllCities() {
        return repository.findDistinctCity();
    }*/
}
