package com.example.ABTestAPI.dao;

import com.example.ABTestAPI.dbModel.ExperimentEntity;
import com.example.ABTestAPI.dbModel.GoalEntity;
import com.example.ABTestAPI.hibernate.HibernateConnector;
import com.example.ABTestAPI.model.Experiment;
import com.example.ABTestAPI.model.Goal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Created by diwakar on 6/6/17.
 */
public class ExperimentDao {

    Session session;

    public ExperimentDao()
    {
        session = HibernateConnector.getSession();
    }

    public void addExperiment(Experiment experiment)
    {
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            session.saveOrUpdate(ExperimentEntity.class.getName(), new ExperimentEntity(experiment));
            tx.commit();
        } catch (Exception e)
        {
            if (tx != null && tx.isActive())
                tx.rollback();
        } finally {
            if (session.isOpen())
                session.close();
        }
    }

    public Experiment getExperiment(int id)
    {
        Criteria c = session.createCriteria(ExperimentEntity.class);
        c.add(Restrictions.idEq(id));
        ExperimentEntity toRet = (ExperimentEntity) c.list().get(0);
        return new Experiment(toRet);
    }
}
