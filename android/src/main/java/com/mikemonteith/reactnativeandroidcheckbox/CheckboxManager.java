package com.mikemonteith.reactnativeandroidcheckbox;

import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.content.ContextWrapper;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class CheckboxManager extends SimpleViewManager<CheckBoxView> {

    private static final String REACT_CLASS = "Checkbox";

    private static final CompoundButton.OnCheckedChangeListener checkedListener =
            new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ReactContext reactContext = (ReactContext) ((ContextWrapper) buttonView.getContext()).getBaseContext();
                    reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                            new CheckboxEvent(
                                    buttonView.getId(),
                                    isChecked));
                }

            };

    public String getName(){
        return REACT_CLASS;
    }

    @Override
    public CheckBoxView createViewInstance(ThemedReactContext context){
        final CheckBoxView checkbox = new CheckBoxView(context);

        checkbox.setOnCheckedChangeListener(checkedListener);

        return checkbox;
    }

    @ReactProp(name = "on")
        public void setOn(CheckBoxView checkbox, boolean on){
        /**
         * Temporarily remove the checkbox listener while setting the isChecked value.
         * Copied from ReactSwitchManager. See that class in react-native for reference.
         */
        checkbox.setOnCheckedChangeListener(null);
        checkbox.setOn(on);
        checkbox.setOnCheckedChangeListener(checkedListener);
    }

    @ReactProp(name = "disabled", defaultBoolean = false)
    public void setEnabled(CheckBoxView checkbox, boolean disabled) {
        checkbox.setEnabled(!disabled);
    }

    @ReactProp(name = "tintColor", customType = "Color")
    public void setTintColor(CheckBoxView checkbox, @Nullable Integer color) {
        if (color != null) {
            ColorStateList colorStateList = new ColorStateList(
                    new int[][]{
                            new int[]{},
                    },
                    new int[]{
                            color,
                    }
            );
            checkbox.setButtonTintList(colorStateList);
        } else {
            checkbox.setButtonTintList(null);
        }
    }
}
