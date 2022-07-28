package com.xumak.metrics.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "person_resolution_service_metrics")
@Getter
@Setter
public class PersonResolution  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("current_timestamp")
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonResolution that = (PersonResolution) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "PersonResolutionService{" +
                "id=" + getId() +
                ", timestamp=" + getTimestamp() +
                ", individualMatches=" + getIndividualMatches() +
                ", householdMatches=" + getHouseholdMatches() +
                ", nonMatches=" + getNonMatches() +
                ", errors=" + getErrors() +
                ", endpoint='" + getEndpoint() + '\'' +
                '}';
    }
}
