package nicolagraziani;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolagraziani.dao.EventDAO;
import nicolagraziani.entities.Concert;
import nicolagraziani.entities.FootballMatch;
import nicolagraziani.enums.ConcertGenre;
import nicolagraziani.enums.EventType;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);

        Concert c1 = new Concert("Rock Night", LocalDate.of(2025, 6, 10), "Serata rock", EventType.PUBBLICO, 5000, ConcertGenre.ROCK, true);
        Concert c2 = new Concert("Pop Festival", LocalDate.of(2025, 7, 5), "Festival pop estivo", EventType.PUBBLICO, 8000, ConcertGenre.POP, false);
        Concert c3 = new Concert("Classic Evening", LocalDate.of(2025, 5, 20), "Musica classica dal vivo", EventType.PRIVATO, 300, ConcertGenre.CLASSICO, true);
        Concert c4 = new Concert("Rock Legends", LocalDate.of(2025, 8, 15), "Grandi successi rock", EventType.PUBBLICO, 10000, ConcertGenre.ROCK, false);
        Concert c5 = new Concert("Pop Stars Live", LocalDate.of(2025, 9, 1), "Artisti pop internazionali", EventType.PUBBLICO, 7000, ConcertGenre.POP, true);
        Concert c6 = new Concert("Mozart Tribute", LocalDate.of(2025, 4, 12), "Omaggio a Mozart", EventType.PRIVATO, 200, ConcertGenre.CLASSICO, false);
        Concert c7 = new Concert("Rock Underground", LocalDate.of(2025, 10, 3), "Band emergenti rock", EventType.PUBBLICO, 1500, ConcertGenre.ROCK, true);
        Concert c8 = new Concert("Pop Night Party", LocalDate.of(2025, 11, 22), "Serata pop dance", EventType.PRIVATO, 1000, ConcertGenre.POP, false);
        Concert c9 = new Concert("Symphony Live", LocalDate.of(2025, 12, 18), "Grande orchestra", EventType.PUBBLICO, 1200, ConcertGenre.CLASSICO, true);
        Concert c10 = new Concert("Rock vs Pop", LocalDate.of(2025, 6, 30), "Sfida musicale", EventType.PUBBLICO, 6000, ConcertGenre.ROCK, false);

        FootballMatch fm1 = new FootballMatch("Match 1", LocalDate.of(2025, 6, 1), "Campionato", EventType.PUBBLICO, 50000, "Inter", "Milan", "Milan", 0, 2);
        FootballMatch fm2 = new FootballMatch("Match 2", LocalDate.of(2025, 6, 2), "Campionato", EventType.PUBBLICO, 50000, "Roma", "Lazio", "Lazio", 1, 2);
        FootballMatch fm3 = new FootballMatch("Match 3", LocalDate.of(2025, 6, 3), "Campionato", EventType.PUBBLICO, 40000, "Juventus", "Napoli", null, 1, 1);
        FootballMatch fm4 = new FootballMatch("Match 4", LocalDate.of(2025, 6, 4), "Campionato", EventType.PUBBLICO, 45000, "Atalanta", "Fiorentina", "Fiorentina", 3, 0);
        FootballMatch fm5 = new FootballMatch("Match 5", LocalDate.of(2025, 6, 5), "Campionato", EventType.PRIVATO, 30000, "Bologna", "Torino", "Bologna", 2, 1);
        FootballMatch fm6 = new FootballMatch("Match 6", LocalDate.of(2025, 6, 6), "Campionato", EventType.PUBBLICO, 60000, "Inter", "Roma", "Roma", 0, 3);
        FootballMatch fm7 = new FootballMatch("Match 7", LocalDate.of(2025, 6, 7), "Campionato", EventType.PUBBLICO, 55000, "Milan", "Napoli", "Milan", 2, 0);
        FootballMatch fm8 = new FootballMatch("Match 8", LocalDate.of(2025, 6, 8), "Campionato", EventType.PUBBLICO, 35000, "Lazio", "Juventus", null, 0, 0);
        FootballMatch fm9 = new FootballMatch("Match 9", LocalDate.of(2025, 6, 9), "Campionato", EventType.PRIVATO, 20000, "Fiorentina", "Bologna", "Fiorentina", 1, 0);
        FootballMatch fm10 = new FootballMatch("Match 10", LocalDate.of(2025, 6, 10), "Campionato", EventType.PUBBLICO, 70000, "Torino", "Atalanta", "Atalanta", 3, 4);

//        ESERCIZIO 1
        System.out.println("-------------Selezione in base ai concerti in streaming-------------");
        List<Concert> streamingConcert = ed.getConcertInStreaming(false);
        streamingConcert.forEach(System.out::println);
        System.out.println("----------------Selezione in base al genere-----------------");
        List<Concert> streamingConcert2 = ed.getConcertByGenre(ConcertGenre.ROCK);
        streamingConcert2.forEach(System.out::println);


//        ESERCIZIO 2
        System.out.println("---------------Partite vinte in trasferta------------");
        List<FootballMatch> fmTest = ed.getAwayGamesWon();
        fmTest.forEach(System.out::println);
        System.out.println("----------------Partite vinte in casa-------------");
        List<FootballMatch> fmTest1 = ed.getHomeGamesWon();
        fmTest1.forEach(System.out::println);


        em.close();
        emf.close();
    }
}
