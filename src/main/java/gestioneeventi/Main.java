package gestioneeventi;

import gestioneeventi.dao.EventoDAO;
import gestioneeventi.model.Evento;
import gestioneeventi.model.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EventoDAO dao = new EventoDAO(em);
        Evento nuovoEvento = new Evento("Mononoke",
                LocalDate.of(2025, 6, 15),
                "Cinema al parco",
                TipoEvento.PUBBLICO,
                75);

        dao.save(nuovoEvento);

        Evento recuperato = dao.getById(nuovoEvento.getId());
        System.out.println("Recuperato: " + recuperato);

//        dao.delete();

        em.close();
        emf.close();
    }
}
