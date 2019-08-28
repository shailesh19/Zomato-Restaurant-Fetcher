package com.wrw.RestaurantRatingFetcher.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
        import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final String OMDB_MIME_TYPE = "application/json";
    private static final String OMDB_API_BASE_URL = "https://developers.zomato.com/api/v2.1";
    private static final String USER_AGENT = "Spring 5 WebClient";
//    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final WebClient webClient;

    public RestaurantServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(OMDB_API_BASE_URL)
                .defaultHeader("user-key", "022860ef904b791bbeecc090fb45cc0a")
                .defaultHeader("Accept", "application/json")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, OMDB_MIME_TYPE)
//                .defaultHeader(HttpHeaders.USER_AGENT, USER_AGENT)
                .build();
    }

    @Override
    public Mono<String> searchMovieByTitle(String title) {

        return webClient.get()
                .uri("/search?q="+title)
                .retrieve()
                .bodyToMono(String.class);
    }
}
