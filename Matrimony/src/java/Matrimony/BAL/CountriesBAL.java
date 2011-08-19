/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.BAL;

import Matrimony.DAL.Countries;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author TuyenDN
 */
public class CountriesBAL {

    private EntityManager em;

    public CountriesBAL() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Insert Country into database
    public int Insert(Countries pCountry) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pCountry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update changed the city into the database
    public int Update(Countries pCountry) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCountry != null) {
                em.merge(pCountry);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return 1;
    }

    //Set City disable
    public int Delete(Countries pCountry) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCountry != null) {
                pCountry.setStatus(false);
                em.merge(pCountry);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    public Countries getCountry(Countries pCountry) throws Exception {
        Countries country = null;
        try {
            country = em.createNamedQuery("Countries.findByCountryID", Countries.class).setParameter("countryID", pCountry.getCountryID()).getSingleResult();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return country;
    }

    //Get list cities for Administrator
    public List<Countries> getAllCountries() throws Exception {
        List<Countries> list;
        try {
            list = em.createNamedQuery("Countries.findAll", Countries.class).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }

    //Get list cities for Client by Status
    public List<Countries> getAllCountriesByStatus() throws Exception {
        List<Countries> list;
        try {
            list = em.createNamedQuery("Countries.findByStatus", Countries.class).setParameter("status", true).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }
}
