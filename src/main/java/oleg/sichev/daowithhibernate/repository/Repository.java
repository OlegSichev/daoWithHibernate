package oleg.sichev.daowithhibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import oleg.sichev.daowithhibernate.entity.Persons;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city){
        var query = entityManager.createQuery("select p from Persons p where lower(p.cityOfLiving) = " +
                "lower(:city)", Persons.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
