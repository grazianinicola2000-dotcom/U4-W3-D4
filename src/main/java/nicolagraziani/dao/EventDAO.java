package nicolagraziani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import nicolagraziani.entities.*;
import nicolagraziani.enums.ConcertGenre;
import nicolagraziani.exceptions.EventNotFoundException;

import java.util.List;
import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event newEvento) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(newEvento);
        transaction.commit();
        System.out.println("l'Evento " + newEvento.getTitle() + " è stato salvato con successo!");
    }

    public Event getById(String eventId) {
        Event searched = em.find(Event.class, UUID.fromString(eventId));
        if (searched == null) throw new EventNotFoundException(UUID.fromString(eventId));
        return searched;
    }

    public void delete(String eventId) {
        Event searched = this.getById(eventId);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(searched);
        transaction.commit();
        System.out.println("L'evento " + searched.getTitle() + " è stato eliminato con successo");
    }

    public List<Concert> getConcertInStreaming(boolean streaming) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.streaming = :streaming", Concert.class)
                .setParameter("streaming", streaming);
        return query.getResultList();
    }

    public List<Concert> getConcertByGenre(ConcertGenre genre) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class)
                .setParameter("genre", genre);
        return query.getResultList();
    }

    public List<FootballMatch> getHomeGamesWon() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getHomeGamesWon", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getAwayGamesWon() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getAwayGamesWon", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getDrawnGames() {
        TypedQuery<FootballMatch> query = em.createNamedQuery("getDrawnGames", FootballMatch.class);
        return query.getResultList();
    }

    public List<AthleticsCompetition> getAthleticsCompetitionByWinner(Person p) {
        TypedQuery<AthleticsCompetition> query = em.createQuery("SELECT ac FROM AthleticsCompetition ac WHERE ac.winner = :p", AthleticsCompetition.class)
                .setParameter("p", p);
        return query.getResultList();
    }
}