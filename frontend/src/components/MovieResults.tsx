import React from 'react';
import { type Movie, type MovieRecommendationsResponse } from '../types/Movie';
import MovieCard from './MovieCard';
import '../styles/MovieResults.css';

interface Props {
  singleMovie: Movie | null;
  movieCollection: MovieRecommendationsResponse | null;
  loading: boolean;
}

const MovieResults: React.FC<Props> = ({ singleMovie, movieCollection, loading }) => {
  if (loading) {
    return (
      <div className="loading-container">
        <div className="loading-spinner">
          <div className="spinner-ring"></div>
          <div className="spinner-ring"></div>
          <div className="spinner-ring"></div>
        </div>
        <p className="loading-text">🎬 Encontrando os melhores filmes para você...</p>
      </div>
    );
  }

  if (!singleMovie && !movieCollection) {
    return null;
  }

  return (
    <div className="movie-results">
      {singleMovie && (
        <div className="single-movie-result">
          <h2 className="result-title">🎲 Sua Recomendação Surpresa</h2>
          <div className="single-movie-container">
            <MovieCard movie={singleMovie} featured={true} />
          </div>
        </div>
      )}

      {movieCollection && (
        <div className="movie-collection-result">
          <div className="collection-header">
            <h2 className="result-title">🍿 Sua Coleção Personalizada</h2>
            <div className="collection-stats">
              <span className="stats-item">
                📊 {movieCollection.total_results} filmes encontrados
              </span>
              <span className="stats-item">
                📄 Página {movieCollection.page} de {movieCollection.total_pages}
              </span>
            </div>
          </div>

          <div className="movie-grid">
            {movieCollection.results.map(movie => (
              <MovieCard key={movie.id} movie={movie} featured={false} />
            ))}
          </div>

          {movieCollection.results.length === 0 && (
            <div className="no-results">
              <div className="no-results-icon">🔍</div>
              <h3>Nenhum filme encontrado</h3>
              <p>Tente ajustar os filtros para encontrar mais opções</p>
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export default MovieResults;
