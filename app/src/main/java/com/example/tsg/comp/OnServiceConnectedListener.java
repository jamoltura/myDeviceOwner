package com.example.tsg.comp;

import android.os.RemoteException;
import androidx.annotation.UiThread;

public interface OnServiceConnectedListener<T> {
    @UiThread
    void onServiceConnected(T service) throws RemoteException;
}
