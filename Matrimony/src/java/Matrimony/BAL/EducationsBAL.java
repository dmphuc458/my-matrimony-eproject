/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.BAL;

import Matrimony.DAL.Educations;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author TuyenDN
 */
public class EducationsBAL {
    
    private EntityManager em;

    public EducationsBAL() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Insert Education into database
    public int Insert(Educations pEducation) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pEducation);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update changed the city into the database
    public int Update(Educations pEducation) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pEducation != null) {
                em.merge(pEducation);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return 1;
    }

    //Set City disable
    public int Delete(Educations pEducation) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pEducation != null) {
                pEducation.setStatus(false);
                em.merge(pEducation);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    public Educations getEducation(Educations pEducation) throws Exception {
        Educations Education = null;
        try {
            Education = em.createNamedQuery("Educations.findByEducationID", Educations.class).setParameter("EducationID", pEducation.getEducationID()).getSingleResult();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return Education;
    }

    //Get list cities for Administrator
    public List<Educations> getAllEducations() throws Exception {
        List<Educations> list;
        try {
            list = em.createNamedQuery("Educations.findAll", Educations.class).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }

    //Get list cities for Client by Status
    public List<Educations> getAllEducationsByStatus() throws Exception {
        List<Educations> list;
        try {
            list = em.createNamedQuery("Educations.findByStatus", Educations.class).setParameter("status", true).getResultList();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return list;
    }
    
}
