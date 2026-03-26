package nicolagraziani.entities;


import jakarta.persistence.*;
import nicolagraziani.enums.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "athletics_competition")
public class AthleticsCompetition extends Event {
    @ManyToMany
    @JoinTable(
            name = "competition_athletes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> athletes;

    @ManyToOne
    @JoinColumn(name = "winner_person_id")
    private Person winner;

    public AthleticsCompetition() {
    }

    public AthleticsCompetition(String title, LocalDate eventDate, String description, EventType type, int maxParticipants, List<Person> athletes, Person winner) {
        super(title, eventDate, description, type, maxParticipants);
        this.athletes = athletes;
        this.winner = winner;
    }
}
