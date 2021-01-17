/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under theM License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.tsg.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.tsg.R;

import java.util.List;

/**
 * An array adapter which shows an application name and its icon in a spinner view.
 */
public class ResolveInfoSpinnerAdapter extends ArrayAdapter<ResolveInfo>
        implements SpinnerAdapter {

    private PackageManager mPackageManager;

    public ResolveInfoSpinnerAdapter(Context context, int resource, int textViewResourceId,
            List<ResolveInfo> objects) {
        super(context, resource, textViewResourceId, objects);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.app_row, parent, false);
        }
        ResolveInfo resolveInfo = getItem(position);
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.pkg_icon);
        iconImageView.setImageDrawable(resolveInfo.loadIcon(mPackageManager));
        TextView pkgNameTextView = (TextView) convertView.findViewById(R.id.pkg_name);
        pkgNameTextView.setText(resolveInfo.loadLabel(mPackageManager));
        return convertView;
    }
}

