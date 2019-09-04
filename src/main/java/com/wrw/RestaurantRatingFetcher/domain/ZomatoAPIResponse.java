package com.wrw.RestaurantRatingFetcher.domain;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ZomatoAPIResponse {
    private RestaurantHolder[] restaurants;
}
