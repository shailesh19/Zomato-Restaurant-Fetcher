package com.wrw.RestaurantRatingFetcher.service;

import com.wrw.RestaurantRatingFetcher.domain.ZomatoAPIResponse;
import reactor.core.publisher.Mono;

public interface RestaurantService {

    public Mono<ZomatoAPIResponse> searchRestaurantByTitle(String title);
}
