import React, { useState } from 'react';
import { type MovieFilters, type RecommendationType, type Movie, type MovieRecommendationsResponse } from '../types/Movie';
import { MovieService } from '../services/movieService';
import RecommendationTypeSelector from './RecommendationTypeSelector';
import FilterSection from './FilterSection';
import MovieResults from './MovieResults';
import '../styles/MovieRecommendationForm.css';

const MovieRecommendationForm: React.FC = () => {
  const [filters, setFilters] = useState<MovieFilters>({});
  const [recommendationType, setRecommendationType] = useState<RecommendationType>('collection');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [singleMovie, setSingleMovie] = useState<Movie | null>(null);
  const [movieCollection, setMovieCollection] = useState<MovieRecommendationsResponse | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setSingleMovie(null);
    setMovieCollection(null);

    try {
      if (recommendationType === 'single') {
        const movie = await MovieService.getRandomRecommendation(filters);
        setSingleMovie(movie);
      } else {
        const collection = await MovieService.getRecommendations(filters);
        setMovieCollection(collection);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Erro ao buscar recomendações');
    } finally {
      setLoading(false);
    }
  };

  const handleReset = () => {
    setFilters({});
    setRecommendationType('collection');
    setSingleMovie(null);
    setMovieCollection(null);
    setError(null);
  };

  return (
    <div className="recommendation-form-container">
      <form onSubmit={handleSubmit} className="recommendation-form">
        <div className="form-header">
          <h2 className="form-title">🎬 Encontre Seu Próximo Filme</h2>
          <p className="form-subtitle">
            Personalize sua busca com os filtros abaixo ou deixe em branco para descobrir algo novo
          </p>
        </div>

        <RecommendationTypeSelector
          selectedType={recommendationType}
          onTypeChange={setRecommendationType}
        />

        <FilterSection
          filters={filters}
          onFiltersChange={setFilters}
        />

        <div className="form-actions">
          <button type="submit" className="btn btn-primary" disabled={loading}>
            {loading ? (
              <>
                <span className="spinner"></span>
                Buscando...
              </>
            ) : (
              <>
                🎯 {recommendationType === 'single' ? 'Encontrar Um Filme' : 'Ver Coleção'}
              </>
            )}
          </button>

          <button type="button" onClick={handleReset} className="btn btn-secondary">
            🔄 Limpar Filtros
          </button>
        </div>
      </form>

      {error && <div className="error">{error}</div>}

      <MovieResults
        singleMovie={singleMovie}
        movieCollection={movieCollection}
        loading={loading}
      />
    </div>
  );
};

export default MovieRecommendationForm;
