package net.moriaritys.timeout.client.controller;

import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.DefaultPlaceManager;
import net.moriaritys.timeout.client.today.TodayPlace;

/**
 *
 */
public class TimeoutPlaceManager extends DefaultPlaceManager {
    @Inject
    TimeoutPlaceManager(EventBus eventBus, TodayPlace today) {
        super(eventBus, today);
    }

    /**
     * A fixed implementation of fireCurrentPlace() which checks if the history token is empty rather than just null.
     *
     * @return true if there was a current place and it was fired.
     */
    @Override
    public boolean fireCurrentPlace() {
        return History.getToken() != null && !History.getToken().isEmpty() && super.fireCurrentPlace();
    }
}
