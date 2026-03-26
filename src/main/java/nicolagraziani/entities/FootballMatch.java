package nicolagraziani.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import nicolagraziani.enums.EventType;

import java.time.LocalDate;

@Entity
@Table(name = "football_match")
@NamedQuery(name = "getHomeGamesWon", query = "SELECT fm FROM FootballMatch fm WHERE fm.homeTeam = fm.winningTeam")
@NamedQuery(name = "getAwayGamesWon", query = "SELECT fm FROM FootballMatch fm WHERE fm.awayTeam = fm.winningTeam")
@NamedQuery(name = "getDrawnGames", query = "SELECT fm FROM FootballMatch fm WHERE fm.winningTeam IS null")
public class FootballMatch extends Event {
    @Column(name = "home_team")
    private String homeTeam;

    @Column(name = "away_team")
    private String awayTeam;

    @Column(name = "winning_team")
    private String winningTeam;

    @Column(name = "gol_home_team")
    private int golHomeTeam;

    @Column(name = "gol_away_team")
    private int golAwayTeam;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate eventDate, String description, EventType type, int maxParticipants, String homeTeam, String awayTeam, String winningTeam, int golHomeTeam, int golAwayTeam) {
        super(title, eventDate, description, type, maxParticipants);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winningTeam = winningTeam;
        this.golHomeTeam = golHomeTeam;
        this.golAwayTeam = golAwayTeam;
    }


    @Override
    public String toString() {
        return super.toString() +
                "FootballMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", golHomeTeam=" + golHomeTeam +
                ", golAwayTeam=" + golAwayTeam +
                '}';
    }
}
