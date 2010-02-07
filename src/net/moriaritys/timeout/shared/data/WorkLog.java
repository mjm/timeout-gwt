package net.moriaritys.timeout.shared.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
public class WorkLog implements Serializable {
    public static final Integer DEFAULT_GOAL = 8 * 60 * 60;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    // Using a string because we want to represent a day and not worry about time zones
    @Basic(optional = false)
    private String day;
    @Basic(optional = false)
    private Integer goal;
    @Basic(optional = false)
    private String userId;

    @OneToMany(mappedBy = "log", fetch = FetchType.EAGER)
    private List<WorkLogEntry> entries;

    public Long getKey() {
        return key;
    }

    public void setKey(final Long key) {
        this.key = key;
    }

    public String getDay() {
        return day;
    }

    public void setDay(final String day) {
        this.day = day;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(final Integer goal) {
        this.goal = goal;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String user) {
        this.userId = user;
    }

    public List<WorkLogEntry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<WorkLogEntry>();
        }
        return entries;
    }

    public void setEntries(final List<WorkLogEntry> entries) {
        this.entries = entries;
    }

    public Integer getTimeLeft() {
        Integer elapsed = getTimeElapsed();

        if (goal == null) {
            return null;
        }

        return goal - elapsed;
    }

    public Integer getTimeElapsed() {
        int totalElapsed = 0;
        for (final WorkLogEntry entry : getEntries()) {
            Integer elapsed = entry.getTimeElapsed();
            if (elapsed != null) {
                totalElapsed += elapsed;
            }
        }
        return totalElapsed;
    }

    public Date getEstimatedEndTime() {
        long now = new Date().getTime();
        Integer left = getTimeLeft();

        if (left == null) {
            return null;
        }

        long end = now + (left * 1000);
        return new Date(end);
    }
}
