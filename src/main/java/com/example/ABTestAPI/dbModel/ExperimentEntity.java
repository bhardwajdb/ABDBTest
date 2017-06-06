package com.example.ABTestAPI.dbModel;

import com.example.ABTestAPI.model.Experiment;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by diwakar on 5/6/17.
 */
@Entity
@Table(name = "EXPERIMENT", schema = "", catalog = "abtestdb")
public class ExperimentEntity {
    private Integer id;
    private String name;
    private String cssattributekey;
    private String htmlclassname;
    private Integer goalid;

    private static AtomicInteger ctr = new AtomicInteger();

    public ExperimentEntity(){}

    public ExperimentEntity(Experiment experiment)
    {
        this.id = ctr.incrementAndGet();
        this.name = experiment.getName();
        this.cssattributekey = experiment.getCssAttributeKey();
        this.htmlclassname = experiment.getHtmlClassName();
        this.goalid = experiment.getGoalId();
        experiment.setId(this.id);
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
    @Column(name = "CSSATTRIBUTEKEY")
    public String getCssattributekey() {
        return cssattributekey;
    }

    public void setCssattributekey(String cssattributekey) {
        this.cssattributekey = cssattributekey;
    }

    @Basic
    @Column(name = "HTMLCLASSNAME")
    public String getHtmlclassname() {
        return htmlclassname;
    }

    public void setHtmlclassname(String htmlclassname) {
        this.htmlclassname = htmlclassname;
    }

    @Basic
    @Column(name = "GOALID")
    public Integer getGoalid() {
        return goalid;
    }

    public void setGoalid(Integer goalid) {
        this.goalid = goalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperimentEntity that = (ExperimentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cssattributekey != null ? !cssattributekey.equals(that.cssattributekey) : that.cssattributekey != null)
            return false;
        if (htmlclassname != null ? !htmlclassname.equals(that.htmlclassname) : that.htmlclassname != null)
            return false;
        if (goalid != null ? !goalid.equals(that.goalid) : that.goalid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cssattributekey != null ? cssattributekey.hashCode() : 0);
        result = 31 * result + (htmlclassname != null ? htmlclassname.hashCode() : 0);
        result = 31 * result + (goalid != null ? goalid.hashCode() : 0);
        return result;
    }
}
