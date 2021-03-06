package net.moriaritys.timeout.client.timer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Singleton;
import net.moriaritys.timeout.client.timer.TimerPresenter.Display;

/**
 *
 */
@Singleton
public class TimerView extends Composite implements Display {
    interface Binder extends UiBinder<FlowPanel, TimerView> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    Button startStopButton;

    @UiField
    Label startLabel;
    @UiField
    TextBox hoursNeededField;
    @UiField
    Label estimatedDepartureLabel;
    @UiField
    Label timeElapsedLabel;
    @UiField
    Label timeLeftLabel;

    TimerView() {
        FlowPanel panel = binder.createAndBindUi(this);

        hoursNeededField.setWidth("50px");

        initWidget(panel);
    }

    @Override
    public HasClickHandlers getStartStopButton() {
        return startStopButton;
    }

    @Override
    public HasText getStartLabel() {
        return startLabel;
    }

    @Override
    public HasValue<String> getHoursNeededField() {
        return hoursNeededField;
    }

    @Override
    public HasText getEstimatedDepartureLabel() {
        return estimatedDepartureLabel;
    }

    @Override
    public HasText getTimeElapsedLabel() {
        return timeElapsedLabel;
    }

    @Override
    public HasText getTimeLeftLabel() {
        return timeLeftLabel;
    }

    @Override
    public Widget asWidget() {
        return this;
    }
}