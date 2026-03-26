package nicolagraziani;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolagraziani.dao.EventDAO;
import nicolagraziani.dao.PersonDAO;
import nicolagraziani.entities.AthleticsCompetition;
import nicolagraziani.entities.Concert;
import nicolagraziani.entities.FootballMatch;
import nicolagraziani.entities.Person;
import nicolagraziani.enums.ConcertGenre;
import nicolagraziani.enums.EventType;
import nicolagraziani.enums.Gender;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        PersonDAO pd = new PersonDAO(em);

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

        Person p1 = new Person("Luca", "Rossi", "luca.rossi@gmail.com", LocalDate.of(1995, 3, 12), Gender.MALE);
        Person p2 = new Person("Marco", "Bianchi", "marco.bianchi@gmail.com", LocalDate.of(1990, 7, 25), Gender.MALE);
        Person p3 = new Person("Giulia", "Verdi", "giulia.verdi@gmail.com", LocalDate.of(1998, 11, 3), Gender.FEMALE);
        Person p4 = new Person("Sara", "Neri", "sara.neri@gmail.com", LocalDate.of(2000, 1, 19), Gender.FEMALE);
        Person p5 = new Person("Andrea", "Gallo", "andrea.gallo@gmail.com", LocalDate.of(1987, 5, 30), Gender.MALE);
        Person p6 = new Person("Francesca", "Costa", "francesca.costa@gmail.com", LocalDate.of(1993, 9, 14), Gender.FEMALE);
        Person p7 = new Person("Davide", "Romano", "davide.romano@gmail.com", LocalDate.of(1996, 2, 8), Gender.MALE);
        Person p8 = new Person("Elena", "Greco", "elena.greco@gmail.com", LocalDate.of(1999, 6, 21), Gender.FEMALE);
        Person p9 = new Person("Matteo", "Ferrari", "matteo.ferrari@gmail.com", LocalDate.of(1992, 12, 5), Gender.MALE);
        Person p10 = new Person("Chiara", "Conti", "chiara.conti@gmail.com", LocalDate.of(2001, 4, 17), Gender.FEMALE);

        List<Person> atleti1 = Arrays.asList(p1, p2, p3);
        List<Person> atleti2 = Arrays.asList(p2, p4, p5);
        List<Person> atleti3 = Arrays.asList(p1, p5, p6);
        List<Person> atleti4 = Arrays.asList(p7, p8, p9);
        List<Person> atleti5 = Arrays.asList(p1, p2, p10);

        AthleticsCompetition ac1 = new AthleticsCompetition(
                "100m Sprint",
                LocalDate.of(2025, 6, 1),
                "Gara veloce",
                EventType.PUBBLICO,
                100,
                atleti1,
                p1   // vincitore
        );

        AthleticsCompetition ac2 = new AthleticsCompetition(
                "Salto in lungo",
                LocalDate.of(2025, 6, 2),
                "Gara tecnica",
                EventType.PUBBLICO,
                80,
                atleti2,
                p2   // vincitore
        );

        AthleticsCompetition ac3 = new AthleticsCompetition(
                "Maratona",
                LocalDate.of(2025, 6, 3),
                "Gara lunga",
                EventType.PRIVATO,
                200,
                atleti3,
                p1   // vincitore di nuovo (IMPORTANTE)
        );

        AthleticsCompetition ac4 = new AthleticsCompetition(
                "Staffetta",
                LocalDate.of(2025, 6, 4),
                "Gara a squadre",
                EventType.PUBBLICO,
                120,
                atleti4,
                p8
        );

        AthleticsCompetition ac5 = new AthleticsCompetition(
                "200m Sprint",
                LocalDate.of(2025, 6, 5),
                "Gara veloce",
                EventType.PUBBLICO,
                100,
                atleti5,
                p10
        );

        ed.save(ac1);
        ed.save(ac2);
        ed.save(ac3);
        ed.save(ac4);
        ed.save(ac5);

//        ESERCIZIO 1
        System.out.println("-------------Selezione in base ai concerti in streaming-------------");
        List<Concert> streamingConcert = ed.getConcertInStreaming(false);
        streamingConcert.forEach(System.out::println);
        System.out.println("----------------Selezione in base al genere-----------------");
        List<Concert> streamingConcert2 = ed.getConcertByGenre(ConcertGenre.ROCK);
        streamingConcert2.forEach(System.out::println);


//        ESERCIZIO 2
        System.out.println("---------------Partite vinte in trasferta------------");
        List<FootballMatch> awayWin = ed.getAwayGamesWon();
        awayWin.forEach(System.out::println);
        System.out.println("----------------Partite vinte in casa-------------");
        List<FootballMatch> homeWin = ed.getHomeGamesWon();
        homeWin.forEach(System.out::println);

//      EXTRAS
        System.out.println("----------------Partite pareggiate-------------");
        List<FootballMatch> drawnMatch = ed.getDrawnGames();
        drawnMatch.forEach(System.out::println);


        em.close();
        emf.close();
    }
}
