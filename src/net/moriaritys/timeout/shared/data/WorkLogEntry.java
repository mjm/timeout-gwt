package net.moriaritys.timeout.shared.data;

import org.datanucleus.jpa.annotations.Extension;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
public class WorkLogEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Extension(key = "gae.encoded-pk", value = "true")
    private String key;

    @ManyToOne(optional = false)
    private WorkLog log;

    @Basic(optional = false)
    private Date startTime;
    private Date endTime;

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public WorkLog getLog() {
        return log;
    }

    public void setLog(final WorkLog log) {
        this.log = log;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTimeElapsed() {
        if (startTime == null) {
            return null;
        }

        long start = startTime.getTime();
        Date end = endTime == null ? new Date() : endTime;
        return (int) ((end.getTime() - start) / 1000);
    }

    public boolean isRunning() {
        return startTime != null && endTime == null;
    }
}
