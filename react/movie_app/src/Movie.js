import React, {} from 'react';
import './Movie.css';

function Movie({title, poster, genres, synopsis}) {
    return (
        <div className="Movie">
            <div className="Movie__Column">
                <MoviePoster title={title} poster={poster}/>
            </div>
            <div className="Movie_Column">
                <h1>{title}</h1>
                <div className="Movie_Genres">
                    {genres.map((genre, idx) => <MovieGenre genre={genre} key={idx}/>)}
                </div>
                <div className="Movie__Synopsis">
                    {synopsis}
                </div>
            </div>
        </div>
    );
}

function MoviePoster({title, poster}) {
    return (
        <img src={poster} alt={title} className="Movie__Poster"/>
    )
}

function MovieGenre({genre}) {
    return (
        <span className={"Movie__Genre"}> {genre} </span>
    )
}

export default Movie;