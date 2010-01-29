package net.moriaritys.timeout.server.service;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import net.moriaritys.timeout.client.service.LoginService;
import net.moriaritys.timeout.shared.data.LoginInfo;

/**
 *
 */
public class DefaultLoginService extends RemoteServiceServlet implements LoginService {
    @Override
    public LoginInfo login(final String redirectUri) {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        LoginInfo info = new LoginInfo();

        if (user != null) {
            info.setNickname(user.getNickname());
            info.setEmailAddress(user.getEmail());
            info.setLoggedIn(true);
            info.setUrl(userService.createLogoutURL(redirectUri));
        } else {
            info.setUrl(userService.createLoginURL(redirectUri));
        }

        return info;
    }
}
