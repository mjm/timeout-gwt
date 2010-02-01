package net.moriaritys.timeout.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import net.customware.gwt.presenter.client.place.PlaceManager;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.place.PlaceRequestEvent;
import net.moriaritys.timeout.client.controller.TimeoutController;
import net.moriaritys.timeout.client.inject.TimeoutGinjector;
import net.moriaritys.timeout.client.service.LoginService;
import net.moriaritys.timeout.client.service.LoginServiceAsync;
import net.moriaritys.timeout.client.today.TodayPlace;
import net.moriaritys.timeout.shared.data.LoginInfo;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Timeout implements EntryPoint {

    private TimeoutGinjector injector;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        injector = GWT.create(TimeoutGinjector.class);

        injector.getResources().css().ensureInjected();

        LoginServiceAsync login = GWT.create(LoginService.class);
        login.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
            @Override
            public void onFailure(final Throwable throwable) {

            }

            @Override
            public void onSuccess(final LoginInfo loginInfo) {
                if (loginInfo.isLoggedIn()) {
                    loadTimeout(loginInfo);
                } else {
                    loadLoginPage(loginInfo);
                }
            }
        });
    }

    private void loadTimeout(final LoginInfo loginInfo) {
        GWT.log("Loading appication...", null);

        TimeoutController controller = injector.getController();
        controller.go(RootLayoutPanel.get());

        PlaceManager placeManager = injector.getPlaceManager();
        if (!placeManager.fireCurrentPlace()) {
            TodayPlace place = injector.getDefaultPlace();
            PlaceRequest request = new PlaceRequest(place.getName());
            PlaceRequestEvent.fire(injector.getEventBus(), request);
        }
    }

    private void loadLoginPage(final LoginInfo loginInfo) {
        Window.Location.assign(loginInfo.getUrl());
    }
}
