package com.xumak.metrics.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "person_resolution_service_metrics")
public class PersonResolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "individual_matches")
    private Integer individualMatches;

    @Column(name = "household_matches")
    private Integer householdMatches;

    @Column(name = "non_matches")
    private Integer nonMatches;

    @Column(name = "errors")
    private Integer errors;

    @Column(name = "endpoint")
    private String endpoint;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIndividualMatches() {
        return individualMatches;
    }

    public void setIndividualMatches(Integer individualMatches) {
        this.individualMatches = individualMatches;
    }

    public Integer getHouseholdMatches() {
        return householdMatches;
    }

    public void setHouseholdMatches(Integer householdMatches) {
        this.householdMatches = householdMatches;
    }

    public Integer getNonMatches() {
        return nonMatches;
    }

    public void setNonMatches(Integer nonMatches) {
        this.nonMatches = nonMatches;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonResolution that = (PersonResolution) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PersonResolutionService{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", individualMatches=" + individualMatches +
                ", householdMatches=" + householdMatches +
                ", nonMatches=" + nonMatches +
                ", errors=" + errors +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }
}
