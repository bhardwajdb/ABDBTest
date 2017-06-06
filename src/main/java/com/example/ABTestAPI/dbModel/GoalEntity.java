package com.example.ABTestAPI.dbModel;

import com.example.ABTestAPI.model.Goal;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by diwakar on 5/6/17.
 */
@Entity
@Table(name = "GOAL", schema = "", catalog = "abtestdb")
public class GoalEntity {
    private Integer id;
    private String name;
    private String event;
    private String htmlclassname;

    private static AtomicInteger ctr = new AtomicInteger();

    public GoalEntity(){}

    public GoalEntity(Goal goal) {
        this.name = goal.getName();
        this.event = goal.getEvent();
        this.htmlclassname = goal.getHtmlClassName();
        this.id = ctr.incrementAndGet();
        goal.setId(this.id);
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "EVENT")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "HTMLCLASSNAME")
    public String getHtmlclassname() {
        return htmlclassname;
    }

    public void setHtmlclassname(String htmlclassname) {
        this.htmlclassname = htmlclassname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoalEntity that = (GoalEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (htmlclassname != null ? !htmlclassname.equals(that.htmlclassname) : that.htmlclassname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (htmlclassname != null ? htmlclassname.hashCode() : 0);
        return result;
    }
}
