package net.moriaritys.timeout.client.today;

import com.google.inject.Inject;
import net.customware.gwt.presenter.client.place.BasicPresenterPlace;

/**
 *
 */
public class TodayPlace extends BasicPresenterPlace<TodayPresenter> {
    @Inject
    TodayPlace(final TodayPresenter presenter) {
        super(presenter);
    }

    @Override
    public String getName() {
        return "today";
    }
}
