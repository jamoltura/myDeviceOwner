package com.example.tsg.comp;

import android.os.IBinder;

public interface ServiceInterfaceConverter<T> {
    T convert(IBinder iBinder);
}
