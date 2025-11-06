package dev.spring.movie_recommendation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpokenLanguageDTO(
        @JsonProperty("english_name")
        String englishName,
        String iso6391,
        String name
) {
}
