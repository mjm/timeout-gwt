package net.moriaritys.timeout.shared.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
public class WorkLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    private Date day;
    private String userId;

    public Long getKey() {
        return key;
    }

    public void setKey(final Long key) {
        this.key = key;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(final Date day) {
        this.day = day;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String user) {
        this.userId = user;
    }
}
