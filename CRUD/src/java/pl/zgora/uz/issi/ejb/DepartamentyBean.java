package pl.zgora.uz.issi.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.zgora.uz.issi.entities.DepartamentyEntity;

@Stateless
public class DepartamentyBean {
    
    @PersistenceContext(name="CRUDPU")
    private EntityManager entityManager;
    
    public List<DepartamentyEntity> PobierzWszystkieDepartamenty() {
        Query query = entityManager.createNamedQuery("DepartamentyEntity.findAll");
        return query.getResultList();
    } 
    
    public DepartamentyEntity PobierzDepartament(int id) {
        return entityManager.find(DepartamentyEntity.class, id);
    }
    
    public void DodajDepartament(DepartamentyEntity departament) {
        entityManager.persist(departament);
    }
    
    public void EdytujDepartament(DepartamentyEntity departament) {
        entityManager.merge(departament);
    }
    
    public void UsunDepartament(int id) {
        DepartamentyEntity departament = entityManager.find(DepartamentyEntity.class, id);
        entityManager.remove(departament);
    }
}
