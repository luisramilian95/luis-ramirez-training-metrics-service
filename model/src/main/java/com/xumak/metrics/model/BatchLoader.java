package com.xumak.metrics.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "batch_loader_metrics")
public class BatchLoader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
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
    private Date file_processed;

    @Column(name = "number_of_records")
    private Integer numberOfRecords;


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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileCreated() {
        return fileCreated;
    }

    public void setFileCreated(Date fileCreated) {
        this.fileCreated = fileCreated;
    }

    public Date getFilePickedUp() {
        return filePickedUp;
    }

    public void setFilePickedUp(Date filePickedUp) {
        this.filePickedUp = filePickedUp;
    }

    public Date getFile_processed() {
        return file_processed;
    }

    public void setFile_processed(Date file_processed) {
        this.file_processed = file_processed;
    }

    public Integer getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(Integer numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchLoader that = (BatchLoader) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BatchLoader{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", fileName='" + fileName + '\'' +
                ", fileCreated=" + fileCreated +
                ", filePickedUp=" + filePickedUp +
                ", file_processed=" + file_processed +
                ", numberOfRecords=" + numberOfRecords +
                '}';
    }
}
