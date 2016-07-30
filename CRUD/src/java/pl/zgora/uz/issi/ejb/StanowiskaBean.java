package pl.zgora.uz.issi.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.zgora.uz.issi.entities.StanowiskaEntity;

@Stateless
public class StanowiskaBean {
    
    @PersistenceContext(name="CRUDPU")
    private EntityManager entityManager;
    
    public List<StanowiskaEntity> PobierzWszystkieStanowiska() {
        Query query = entityManager.createNamedQuery("StanowiskaEntity.findAll");
        return query.getResultList();
    } 
    
    public StanowiskaEntity PobierzStanowisko(int id) {
        return entityManager.find(StanowiskaEntity.class, id);
    }
    
    public void DodajStanowisko(StanowiskaEntity stanowisko) {
        entityManager.persist(stanowisko);
    }
    
    public void EdytujStanowisko(StanowiskaEntity stanowisko) {
        entityManager.merge(stanowisko);
    }
    
    public void UsunStanowisko(int id) {
        StanowiskaEntity stanowisko = entityManager.find(StanowiskaEntity.class, id);
        entityManager.remove(stanowisko);
    }
}