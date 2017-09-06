package spring.boot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.boot.Entity.WeatherDetails;
import spring.boot.Service.WeatherService;


import java.util.List;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "http://mocker.egen.io")
@Api(tags = "weather")
public class WeatherController {

    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }
/*
    @RequestMapping(method = RequestMethod.GET, value = "/cities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "List All Cities", notes = "Returns List of all cities")
    public List<String> findAll() {
        return service.findAllCities();
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Latest Weather of City", notes = "Returns Latest Weather of particular City")
    public WeatherDetails findOne(@PathVariable("city") String city) {
        return service.findByCity(city);
    }
/*
    @RequestMapping(method = RequestMethod.GET, value = "/{city}/{property}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Weather property", notes = "Returns respective property of City")
    public int findOne(@PathVariable("city") String city, @PathVariable("property") String property) {
        return service.findbyCity(city, property);
    }*/

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Post Weather", notes = "Posts new Weather Update")
    public WeatherDetails create(@RequestBody WeatherDetails weather) {
        return service.post(weather);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp) {
//        return service.update(empId, emp);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    public void delete(@PathVariable("id") String empId) {
//        service.delete(empId);
//    }

}
