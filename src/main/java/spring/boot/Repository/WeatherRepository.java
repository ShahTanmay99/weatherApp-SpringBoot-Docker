package spring.boot.Repository;


import org.springframework.data.repository.Repository;
import spring.boot.Entity.WeatherDetails;
import spring.boot.Entity.WindDetails;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends Repository<WeatherDetails, String> {
    public WeatherDetails save(WeatherDetails weather);
    public Optional<WeatherDetails> findByCity(String city);
  //  public int findbyCity(String city, String property);
   // public List<String> findDistinctCity();
}
