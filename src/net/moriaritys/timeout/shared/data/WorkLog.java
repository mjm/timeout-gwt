package net.moriaritys.timeout.shared.data;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

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
    private Key key;

    private Date day;
    private User user;

    public Key getKey() {
        return key;
    }

    public void setKey(final Key key) {
        this.key = key;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(final Date day) {
        this.day = day;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
