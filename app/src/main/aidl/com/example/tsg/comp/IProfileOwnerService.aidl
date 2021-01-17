package com.example.tsg.comp;

import android.content.res.AssetFileDescriptor;

import android.os.ParcelFileDescriptor;

interface IProfileOwnerService {
    oneway void setLauncherIconHidden(boolean hidden);
    boolean isLauncherIconHidden();
    boolean installCaCertificate(in AssetFileDescriptor afd);
}
