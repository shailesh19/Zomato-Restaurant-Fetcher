package com.wrw.RestaurantRatingFetcher.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.wrw.RestaurantRatingFetcher.domain.ZomatoAPIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
        import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final String ZOMATO_MIME_TYPE = "application/json";
    private static final String ZOMATO_API_BASE_URL = "https://developers.zomato.com/api/v2.1";
    private static final String USER_AGENT = "Spring 5 WebClient";

    private static final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final WebClient webClient;

    public RestaurantServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(ZOMATO_API_BASE_URL)
                .defaultHeader("user-key", "022860ef904b791bbeecc090fb45cc0a")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    @Override
    public Mono<ZomatoAPIResponse> searchRestaurantByTitle(String title) {

        return webClient.get()
                .uri("/search?q="+title)
                .retrieve()
                .bodyToMono(ZomatoAPIResponse.class);
    }
}
