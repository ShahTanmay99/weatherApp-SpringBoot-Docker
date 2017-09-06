package spring.boot.Service;


import spring.boot.Entity.WeatherDetails;

import java.util.List;

public interface WeatherService {
    public WeatherDetails post(WeatherDetails weather);
    public WeatherDetails findByCity(String city);
  //  public int findByCity(String city, String property);
   // public List<String> findAllCities();
}
