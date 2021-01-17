package com.example.tsg.search;

import android.content.Context;

import com.example.tsg.policy.UserRestriction;
import com.example.tsg.policy.UserRestrictionsDisplayFragment;

import java.util.ArrayList;
import java.util.List;

public class UserRestrictionIndexableFragment extends BaseIndexableFragment {
    public UserRestrictionIndexableFragment() {
        super(UserRestrictionsDisplayFragment.class);
    }

    @Override
    public List<PreferenceIndex> index(Context context) {
        List<PreferenceIndex> preferenceIndices = new ArrayList<>();
        for (UserRestriction userRestriction : UserRestriction.ALL_USER_RESTRICTIONS) {
            preferenceIndices.add(new PreferenceIndex(
                    userRestriction.key,
                    context.getString(userRestriction.titleResId),
                    fragmentName));
        }
        return preferenceIndices;
    }
}
