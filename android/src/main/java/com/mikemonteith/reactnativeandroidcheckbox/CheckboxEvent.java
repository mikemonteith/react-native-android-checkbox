package com.mikemonteith.reactnativeandroidcheckbox;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class CheckboxEvent extends Event<CheckboxEvent> {

    public static final String EVENT_NAME = "topChange";

    private final boolean mIsChecked;

    public CheckboxEvent(int viewId, long timestampMs, boolean isChecked) {
        super(viewId, timestampMs);
        mIsChecked = isChecked;
    }

    public boolean getIsChecked() {
        return mIsChecked;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public short getCoalescingKey() {
        // All switch events for a given view can be coalesced.
        return 0;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("target", getViewTag());
        eventData.putBoolean("value", getIsChecked());
        return eventData;
    }
}
