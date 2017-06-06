package com.example.ABTestAPI.dao;

import com.example.ABTestAPI.dbModel.GoalEntity;
import com.example.ABTestAPI.dbModel.VariantEntity;
import com.example.ABTestAPI.hibernate.HibernateConnector;
import com.example.ABTestAPI.model.Experiment;
import com.example.ABTestAPI.model.Goal;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Created by diwakar on 6/6/17.
 */
public class GoalDao {

    Session session;

    public GoalDao()
    {
        session = HibernateConnector.getSession();
    }

    public Goal getGoalByExperiment(Experiment ex)
    {
        Criteria c = session.createCriteria(GoalEntity.class);
        c.add(Restrictions.idEq(ex.getGoalId()));
        GoalEntity toRet = (GoalEntity) c.list().get(0);
        return new Goal(toRet);
    }

    public void addGoal(Goal goal)
    {
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            session.saveOrUpdate(GoalEntity.class.getName(), new GoalEntity(goal));
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

}
