package com.example.ABTestAPI.dao;

import com.example.ABTestAPI.dbModel.GoalEntity;
import com.example.ABTestAPI.dbModel.VariantEntity;
import com.example.ABTestAPI.hibernate.HibernateConnector;
import com.example.ABTestAPI.model.Goal;
import com.example.ABTestAPI.model.Variant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diwakar on 6/6/17.
 */
public class VariantDao {
    Session session;

    public VariantDao() {
        session = HibernateConnector.getSession();
    }

    public List<Variant> getVariantsOfExperiment(int id)
    {
        List<Variant> toRet = new ArrayList<Variant>();
        Criteria c = session.createCriteria(VariantEntity.class);
        c.add(Restrictions.eq("experimentid", id));
        for(Object e:c.list())
        {
            toRet.add(new Variant((VariantEntity)e));
        }
        return toRet;
    }

    public void addVariant(Variant variant) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(VariantEntity.class.getName(), new VariantEntity(variant));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
        } finally {
            if (session.isOpen())
                session.close();
        }

    }

    public Variant incrementGoalCount(int id)
    {
        Variant toRet = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria c = session.createCriteria(VariantEntity.class);
            c.add(Restrictions.idEq(id));
            List<VariantEntity> lst = c.list();
            VariantEntity v = lst.get(0);
            v.setSuccessCount(v.getSuccessCount()+1);
            toRet = new Variant(v);
            session.saveOrUpdate(VariantEntity.class.getName(), v);
            tx.commit();
        } catch (Exception e) {
            System.out.println("sout");
            for (StackTraceElement el:e.getStackTrace())
                System.out.println(el);
            if (tx != null && tx.isActive())
                tx.rollback();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return toRet;
    }
}