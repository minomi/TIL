import React, { Component } from 'react';
import './App.css';
import Movie from './Movie';

class App extends Component {
  state = {};

  componentDidMount() {
    this._fetchMovie();
  }

  _fetchMovie = async () => {
    const movies = await this._callMovieApi();
    this.setState({ movies })
  };

  _callMovieApi = () => {
    return fetch('https://yts.am/api/v2/list_movies.json?sort_by=download_count')
        .then((resp) => resp.json())
        .then((resp) => resp.data.movies);
  };

  _renderMovies = () => {
    return this.state.movies.map((movie)=> {
      return <Movie title = {movie.title}
                    poster = {movie.medium_cover_image}
                    genres = {movie.genres}
                    rating = {movie.rating}
                    synopsis = {movie.synopsis}
                    key = {movie.id}/>
    })
  };

  render() {
    const { movies } = this.state;
    return (
      <div className={movies ? "App" : "App--loading"}>
        {movies ? this._renderMovies() : 'Loading...'}
      </div>
    );
  }
}

export default App;
