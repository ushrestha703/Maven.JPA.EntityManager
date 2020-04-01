package services;

import entities.Artist;
import entities.Cd;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Set;

public class CdService {

    EntityManager em = null;
    EntityTransaction etx = null;

    public CdService(EntityManager em) {

        this.em = em;
        this.etx = em.getTransaction();
    }

    public Cd create(String title, String description, Integer year, Set<Artist> artists){

        Cd cd = new Cd(title, description,year, artists);
        cd.setTitle(title);
        cd.setArtists(artists);
        cd.setDescription(description);
        cd.setYear(year);

        etx.begin();
        em.persist(cd);
        etx.commit();

        return cd;
    }

    public Cd create(Cd cd){

        etx.begin();
        em.persist(cd);
        etx.commit();
        return cd;
    }

    public Cd findById(Long id) {

        return em.find(Cd.class, id);
    }

    public List<Cd> findAll() {

        return em.createQuery("SELECT z FROM Cd z", Cd.class).getResultList();
    }

    public void update(Cd cd){
        List<Cd> cdList = findAll();
        if(cdList.contains(findById(cd.getId()))){
            etx.begin();
            em.merge(cd);
            etx.commit();
        }
    }

    public void delete(Long id){
        Cd cd = em.find(Cd.class, id);
        if(cd != null){
            etx.begin();
            em.remove(cd);
            etx.commit();
        }
    }

    public void delete(Cd cd){
        Cd cdToBeDeleted = em.merge(cd);
        etx.begin();
        em.remove(cdToBeDeleted);
        etx.commit();
    }
}
