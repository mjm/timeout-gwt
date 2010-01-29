package net.moriaritys.timeout.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import net.moriaritys.timeout.shared.data.LoginInfo;

/**
 *
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
    LoginInfo login(String redirectUri);
}
