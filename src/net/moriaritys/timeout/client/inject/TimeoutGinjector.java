package net.moriaritys.timeout.client.inject;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import net.customware.gwt.dispatch.client.gin.AppEngineSecurityModule;
import net.customware.gwt.dispatch.client.gin.SecureDispatchModule;
import net.moriaritys.timeout.client.controller.TimeoutController;

/**
 *
 */
@GinModules({TimeoutGinModule.class, SecureDispatchModule.class, AppEngineSecurityModule.class})
public interface TimeoutGinjector extends Ginjector {
    TimeoutController getController();
}
