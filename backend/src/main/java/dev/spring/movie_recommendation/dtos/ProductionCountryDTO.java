package dev.spring.movie_recommendation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductionCountryDTO(
        @JsonProperty("iso_3166_1")
        String iso31661,
        String name
) {
}
