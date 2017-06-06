package com.example.ABTestAPI.dbModel;

import com.example.ABTestAPI.model.Variant;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by diwakar on 5/6/17.
 */
@Entity
@Table(name = "VARIANT", schema = "", catalog = "abtestdb")
public class VariantEntity {
    private Integer id;
    private String name;
    private Integer percentage;
    private String cssattributevalue;
    private Integer experimentid;
    private Integer successCount;

    private static AtomicInteger ctr = new AtomicInteger();

    public VariantEntity(){}

    public VariantEntity(Variant variant)
    {
        this.id = ctr.incrementAndGet();
        this.name = variant.getName();
        this.percentage = variant.getPercentage();
        this.cssattributevalue = variant.getCssAttributeValue();
        this.experimentid = variant.getExperimentId();
        this.successCount = 0;
        variant.setSuccessCount(this.successCount);
        variant.setId(this.id);
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
    @Column(name = "PERCENTAGE")
    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "CSSATTRIBUTEVALUE")
    public String getCssattributevalue() {
        return cssattributevalue;
    }

    public void setCssattributevalue(String cssattributevalue) {
        this.cssattributevalue = cssattributevalue;
    }

    @Basic
    @Column(name = "SUCCESSCOUNT")
    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    @Basic
    @Column(name = "EXPERIMENTID")
    public Integer getExperimentid() {
        return experimentid;
    }

    public void setExperimentid(Integer experimentid) {
        this.experimentid = experimentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VariantEntity that = (VariantEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        if (cssattributevalue != null ? !cssattributevalue.equals(that.cssattributevalue) : that.cssattributevalue != null)
            return false;
        if (experimentid != null ? !experimentid.equals(that.experimentid) : that.experimentid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (cssattributevalue != null ? cssattributevalue.hashCode() : 0);
        result = 31 * result + (experimentid != null ? experimentid.hashCode() : 0);
        return result;
    }
}
