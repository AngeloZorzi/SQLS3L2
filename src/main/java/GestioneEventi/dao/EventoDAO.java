package GestioneEventi.dao;

import GestioneEventi.model.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(evento);
            tx.commit();
            System.out.println("Evento salvato");
        }catch (Exception e){
            tx.rollback();
            System.out.println("Errore");
        }
    }
    public Evento getById(Long id) {
            return em.find(Evento.class, id);
    }
    public void delete(Long id){
        Evento evento = em.find(Evento.class, id);
        if (evento!=null){
            EntityTransaction tx = em.getTransaction();
            try {
            tx.begin();
            em.remove(evento);
            tx.commit();
                System.out.println("Evento eliminato con successo");
            }catch (Exception e){
                tx.rollback();
                System.out.println("Errore");
            }
        }else {
            System.out.println("Neesun evento trovato con id #"+ id);
        }
    }
}
