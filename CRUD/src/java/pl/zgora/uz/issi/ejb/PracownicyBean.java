package pl.zgora.uz.issi.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.zgora.uz.issi.entities.GrupyEntity;
import pl.zgora.uz.issi.entities.PracownicyEntity;

@Stateless
public class PracownicyBean {

   @PersistenceContext(name="CRUDPU")
   private EntityManager entityManager;
   
   public List<PracownicyEntity> PobierzWszystkichPracownikow() {
        Query query = entityManager.createNamedQuery("PracownicyEntity.findAll");
        return query.getResultList();
    } 
    
    public PracownicyEntity PobierzPracownika(int id) {
        return entityManager.find(PracownicyEntity.class, id);
    }
    
    public void DodajPracownika(PracownicyEntity pracownik) {
        
        if (pracownik.getLogin() != null) {
            GrupyEntity grupa = new GrupyEntity();
            grupa.setLogin(pracownik.getLogin());
            grupa.setGrupa("zalogowany");
            entityManager.persist(grupa);
        }
        
        entityManager.persist(pracownik);
    }
    
    public void EdytujPracownika(PracownicyEntity pracownik) {
        entityManager.merge(pracownik);
    }
    
    public void UsunPracownika(int id) {
        PracownicyEntity pracownik = entityManager.find(PracownicyEntity.class, id);
        entityManager.remove(pracownik);
    }
    
    public boolean SprawdzLogin(String login) {
        Query query = entityManager.createNamedQuery("PracownicyEntity.findByLogin");
        query.setParameter("login", login);
        
        return query.getResultList().isEmpty();
    }
}
