package com.wrw.RestaurantRatingFetcher.controller;

import com.wrw.RestaurantRatingFetcher.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    private RestaurantService restaurantService;
    private Environment environment;

    @Autowired
    public RestaurantController(RestaurantService restaurantService, Environment environment) {
        this.restaurantService = restaurantService;
        this.environment = environment;
    }

    @GetMapping("restaurant/{restaurantName}")
    public Mono<String>getMovieByTitle(@PathVariable String restaurantName){
//        String apiKey = environment.getProperty("app.api.key");
        System.out.println(restaurantName);
        return restaurantService.searchMovieByTitle(restaurantName);
    }
}
