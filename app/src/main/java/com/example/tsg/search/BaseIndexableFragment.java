package com.example.tsg.search;

import android.content.Context;
import android.util.Log;

import com.example.tsg.common.BaseSearchablePolicyPreferenceFragment;

import java.util.List;

public abstract class BaseIndexableFragment {
    private static final String TAG = "BaseIndexableFragment";
    protected String fragmentName;

    public BaseIndexableFragment(
            Class<? extends BaseSearchablePolicyPreferenceFragment> fragmentClass) {
        this.fragmentName = fragmentClass.getName();
    }

    public boolean isAvailable(Context context) {
        try {
            Class<BaseSearchablePolicyPreferenceFragment> clazz =
                    (Class<BaseSearchablePolicyPreferenceFragment>)
                            Class.forName(this.fragmentName);
            BaseSearchablePolicyPreferenceFragment fragment = clazz.newInstance();
            return fragment.isAvailable(context);
        } catch (ClassNotFoundException | java.lang.InstantiationException | IllegalStateException
                | IllegalAccessException e) {
            Log.e(TAG, "isAvailable error", e);
        }
        return false;
    }

    public abstract List<PreferenceIndex> index(Context context);
}
