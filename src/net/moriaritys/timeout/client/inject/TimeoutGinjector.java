package net.moriaritys.timeout.client.inject;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import net.customware.gwt.dispatch.client.gin.AppEngineSecurityModule;
import net.customware.gwt.dispatch.client.gin.SecureDispatchModule;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;
import net.moriaritys.timeout.client.controller.TimeoutController;
import net.moriaritys.timeout.client.resources.TimeoutBundle;
import net.moriaritys.timeout.client.today.TodayPlace;

/**
 *
 */
@GinModules({TimeoutGinModule.class, SecureDispatchModule.class, AppEngineSecurityModule.class})
public interface TimeoutGinjector extends Ginjector {
    TimeoutBundle getResources();

    TimeoutController getController();

    PlaceManager getPlaceManager();

    TodayPlace getDefaultPlace();

    EventBus getEventBus();
}
