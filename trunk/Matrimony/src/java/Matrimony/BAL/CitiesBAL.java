/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.BAL;

import Matrimony.DAL.Cities;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author TuyenDN
 */
public class CitiesBAL {

    private EntityManager em;

    public CitiesBAL() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Insert city into database
    public int Insert(Cities pCity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pCity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update changed the city into the database
    public int Update(Cities pCity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCity != null) {
                em.merge(pCity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return 1;
    }

    //Set City disable
    public int Delete(Cities pCity) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCity != null) {
                pCity.setStatus(false);
                em.merge(pCity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    public Cities getCity(Cities pCity) throws Exception {
        Cities cty = null;
        try {
            cty = em.createNamedQuery("Cities.findByCityID", Cities.class).setParameter("cityID", pCity.getCityID()).getSingleResult();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return cty;
    }

    //Get list cities for Administrator
    public List<Cities> getAllCities() throws Exception {
        List<Cities> list;
        try {
            list = em.createNamedQuery("Cities.findAll", Cities.class).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }

    //Get list cities for Client by Status
    public List<Cities> getAllCitiesByStatus() throws Exception {
        List<Cities> list;
        try {
            list = em.createNamedQuery("Cities.findByStatus", Cities.class).setParameter("status", true).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }
}
