package dev.spring.movie_recommendation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductionCompanyDTO(
        Long id,
        String name,
        @JsonProperty("logo_path")
        String logoPath,
        @JsonProperty("origin_country")
        String originCountry
) {
}
