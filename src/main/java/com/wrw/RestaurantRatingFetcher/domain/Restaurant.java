package com.wrw.RestaurantRatingFetcher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private String name;
    private String url;
    private String thumb;
    private String[] highlights;
    private LocationHolder location;

}
