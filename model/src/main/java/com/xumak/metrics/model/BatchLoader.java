package com.xumak.metrics.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "batch_loader_metrics")
@Getter
@Setter
public class BatchLoader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date timestamp;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileCreated;

    @Column(name = "file_picked_up")
    @Temporal(TemporalType.TIMESTAMP)
    private Date filePickedUp;

    @Column(name = "file_processed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileProcessed;

    @Column(name = "number_of_records")
    private Integer numberOfRecords;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchLoader that = (BatchLoader) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "BatchLoader{" +
                "id=" + getId() +
                ", timestamp=" + getTimestamp() +
                ", fileName='" + getFileName() + '\'' +
                ", fileCreated=" + getFileCreated() +
                ", filePickedUp=" + getFilePickedUp() +
                ", file_processed=" + getFileProcessed() +
                ", numberOfRecords=" + getNumberOfRecords() +
                '}';
    }

}
