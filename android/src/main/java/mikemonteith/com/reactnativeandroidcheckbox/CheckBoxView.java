package mikemonteith.com.reactnativeandroidcheckbox;

import android.content.Context;
import android.widget.CheckBox;

public class CheckBoxView extends CheckBox {

    private boolean mAllowChange;

    public CheckBoxView(Context context) {
        super(context);
        mAllowChange = true;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mAllowChange) {
            mAllowChange = false;
            super.setChecked(checked);
        }
    }

    void setOn(boolean on) {
        // If the switch has a different value than the value sent by JS, we must change it.
        if (isChecked() != on) {
            super.setChecked(on);
        }
        mAllowChange = true;
    }
}
