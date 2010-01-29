package net.moriaritys.timeout.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import net.moriaritys.timeout.shared.data.LoginInfo;

public interface LoginServiceAsync {
    void login(String redirectUri, final AsyncCallback<LoginInfo> async);
}
