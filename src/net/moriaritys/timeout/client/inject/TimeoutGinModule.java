package net.moriaritys.timeout.client.inject;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;
import net.moriaritys.timeout.client.controller.TimeoutController;
import net.moriaritys.timeout.client.controller.TimeoutPlaceManager;
import net.moriaritys.timeout.client.root.RootPresenter;
import net.moriaritys.timeout.client.root.RootView;
import net.moriaritys.timeout.client.today.TodayPlace;
import net.moriaritys.timeout.client.today.TodayPresenter;
import net.moriaritys.timeout.client.today.TodayView;

/**
 *
 */
public class TimeoutGinModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(DefaultEventBus.class);
        bind(PlaceManager.class).to(TimeoutPlaceManager.class);

        bind(TodayPlace.class);

        bind(TimeoutController.class);

        bindPresenter(RootPresenter.class, RootPresenter.Display.class, RootView.class);
        bindPresenter(TodayPresenter.class, TodayPresenter.Display.class, TodayView.class);
    }
}
