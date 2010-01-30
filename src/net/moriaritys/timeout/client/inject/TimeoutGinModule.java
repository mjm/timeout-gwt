package net.moriaritys.timeout.client.inject;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.inject.Provider;
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

import java.util.Date;

/**
 *
 */
public class TimeoutGinModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(DefaultEventBus.class);
        bind(PlaceManager.class).to(TimeoutPlaceManager.class);

        bind(String.class).annotatedWith(CurrentDate.class).toProvider(CurrentDateProvider.class);

        bind(TodayPlace.class);

        bind(TimeoutController.class);

        bindPresenter(RootPresenter.class, RootPresenter.Display.class, RootView.class);
        bindPresenter(TodayPresenter.class, TodayPresenter.Display.class, TodayView.class);
    }

    static class CurrentDateProvider implements Provider<String> {
        @Override
        public String get() {
            DateTimeFormat format = DateTimeFormat.getFormat("yyyy-MM-dd");
            return format.format(new Date());
        }
    }
}
