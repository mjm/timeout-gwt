package net.moriaritys.timeout.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class LoginInfo implements IsSerializable {
    private boolean loggedIn;
    private String url;
    private String emailAddress;
    private String nickname;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(final boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
}
