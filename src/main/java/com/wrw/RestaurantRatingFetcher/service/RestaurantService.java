package com.wrw.RestaurantRatingFetcher.service;

import reactor.core.publisher.Mono;

public interface RestaurantService {

    public Mono<String> searchMovieByTitle(String title);
}
