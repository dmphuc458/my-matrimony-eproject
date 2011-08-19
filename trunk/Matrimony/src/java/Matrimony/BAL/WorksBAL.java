/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.BAL;

import Matrimony.DAL.Works;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author TuyenDN
 */
public class WorksBAL {
    
    private EntityManager em;

    public WorksBAL() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Insert Work into database
    public int Insert(Works pWork) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pWork);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update changed the city into the database
    public int Update(Works pWork) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pWork != null) {
                em.merge(pWork);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return 1;
    }

    //Set City disable
    public int Delete(Works pWork) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pWork != null) {
                pWork.setStatus(false);
                em.merge(pWork);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    public Works getWork(Works pWork) throws Exception {
        Works Work = null;
        try {
            Work = em.createNamedQuery("Works.findByWorkID", Works.class).setParameter("WorkID", pWork.getWorkID()).getSingleResult();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return Work;
    }

    //Get list cities for Administrator
    public List<Works> getAllWorks() throws Exception {
        List<Works> list;
        try {
            list = em.createNamedQuery("Works.findAll", Works.class).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }

    //Get list cities for Client by Status
    public List<Works> getAllWorksByStatus() throws Exception {
        List<Works> list;
        try {
            list = em.createNamedQuery("Works.findByStatus", Works.class).setParameter("status", true).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }
}
