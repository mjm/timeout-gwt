package net.moriaritys.timeout.client.inject;

import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.moriaritys.timeout.client.controller.TimeoutController;

/**
 *
 */
public class TimeoutGinModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(TimeoutController.class);
    }
}
