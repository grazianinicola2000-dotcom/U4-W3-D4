package nicolagraziani.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import nicolagraziani.enums.ConcertGenre;
import nicolagraziani.enums.EventType;

import java.time.LocalDate;

@Entity
public class Concert extends Event {
    @Enumerated(EnumType.STRING)
    private ConcertGenre genre;

    @Column(name = "in_streaming")
    private boolean streaming;

    public Concert() {
    }

    public Concert(String title, LocalDate eventDate, String description, EventType type, int maxParticipants, ConcertGenre genre, boolean streaming) {
        super(title, eventDate, description, type, maxParticipants);
        this.genre = genre;
        this.streaming = streaming;
    }

    public ConcertGenre getGenre() {
        return genre;
    }

    public boolean isStreaming() {
        return streaming;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Concert{" +
                "genre=" + genre +
                ", streaming=" + streaming +
                '}';
    }
}
