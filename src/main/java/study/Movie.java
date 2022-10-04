package study;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name="MOVIE")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Entity 는 반드시 식별자를 가져야한다.
    @Column(name="MOVIE_ID")//매핑
    private Long movieId;
    @Column(name = "NAME")
    private String movieName;

    @Transient
    private int raking;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
