package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.util.TimerTask;

public final class e extends TimerTask
{

    private e(f f1)
    {
        a = f1;
    }

    public final void run()
    {
        j j1;
        if(f.a(a))
            (j1 = new j(a, null)).run();
        f.a(a);
    }

    public e(f f1, d d1)
    {
        this(f1);
    }

    private final f a;
}
