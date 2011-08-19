/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.BAL;

import Matrimony.DAL.Castes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author TuyenDN
 */
public class CastesBAL {

    private EntityManager em;

    public CastesBAL() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Insert Caste into database
    public int Insert(Castes pCaste) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pCaste);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update changed the Caste into the database
    public int Update(Castes pCaste) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCaste != null) {
                em.merge(pCaste);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return 1;
    }

    //Set Caste disable
    public int Delete(Castes pCaste) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCaste != null) {
                pCaste.setStatus(false);
                em.merge(pCaste);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    public Castes getCaste(Castes pCaste) throws Exception {
        Castes cty = null;
        try {
            cty = em.createNamedQuery("Castes.findByCasteID", Castes.class).setParameter("CasteID", pCaste.getCasteID()).getSingleResult();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return cty;
    }

    //Get list Castes for Administrator
    public List<Castes> getAllCastes() throws Exception {
        List<Castes> list;
        try {
            list = em.createNamedQuery("Castes.findAll", Castes.class).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }

    //Get list Castes for Client by Status
    public List<Castes> getAllCastesByStatus() throws Exception {
        List<Castes> list;
        try {
            list = em.createNamedQuery("Castes.findByStatus", Castes.class).setParameter("status", true).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }
}
