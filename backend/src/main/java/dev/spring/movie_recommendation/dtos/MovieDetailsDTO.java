package dev.spring.movie_recommendation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record MovieDetailsDTO(
        @JsonProperty("backdrop_path")
        String backdropPath,
        @JsonProperty("belongs_to_collection")
        BelongsToCollectionDTO belongsToCollection,
        Long budget,
        List<GenreDTO> genres,
        String homepage,
        @JsonProperty("origin_country")
        List<String> originCountry,
        @JsonProperty("original_language")
        String originalLanguage,
        @JsonProperty("original_title")
        String originalTitle,
        String overview,
        Double popularity,
        @JsonProperty("poster_path")
        String posterPath,
        @JsonProperty("production_companies")
        List<ProductionCompanyDTO> productionCompanies,
        @JsonProperty("production_countries")
        List<ProductionCountryDTO> productionCountries,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        Long revenue,
        Integer runtime,
        @JsonProperty("spoken_languages")
        List<SpokenLanguageDTO> spokenLanguages,
        String status,
        String tagline,
        String title,
        @JsonProperty("vote_average")
        Double voteAverage,
        @JsonProperty("vote_count")
        Long voteCount
) {
}
