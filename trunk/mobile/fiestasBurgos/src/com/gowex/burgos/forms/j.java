package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import com.gowex.burgos.principal.Control;

public final class j extends Thread
{

    private j(f f1)
    {
        a = f1;
    }

    public final void run()
    {
        try
        {
            Class.forName("com.siemens.mp.lcdui.Image");
            Control.LeftSoftKey = -1;
            Control.RightSoftKey = -4;
            return;
        }
        catch(ClassNotFoundException _ex) { }
        try
        {
            Class.forName("com.motorola.phonebook.PhoneBookRecord");
            if(a.getKeyName(-21).toUpperCase().indexOf("SOFT") >= 0)
            {
                Control.LeftSoftKey = -21;
                Control.RightSoftKey = -22;
            } else
            {
                Control.LeftSoftKey = 21;
                Control.RightSoftKey = 22;
                return;
            }
        }
        catch(ClassNotFoundException _ex)
        {
            boolean flag = false;
            try
            {
                if(a.getKeyName(21).toUpperCase().indexOf("SOFT") >= 0 || a.getKeyName(21).toUpperCase().indexOf("SELECC") >= 0)
                {
                    Control.LeftSoftKey = 21;
                    Control.RightSoftKey = 22;
                    flag = true;
                }
            }
            catch(Exception _ex2) { }
            try
            {
                if(a.getKeyName(-6).toUpperCase().indexOf("SOFT") >= 0 || a.getKeyName(-6).toUpperCase().indexOf("SELECC") >= 0)
                {
                    Control.LeftSoftKey = -6;
                    Control.RightSoftKey = -7;
                    flag = true;
                }
            }
            catch(Exception _ex2) { }
            if(!flag)
            {
                for(int i = -127; i < 127; i++)
                    try
                    {
                        if(a.getKeyName(i).toUpperCase().indexOf("SOFT") < 0)
                            continue;
                        if(a.getKeyName(i).indexOf("1") >= 0 || a.getKeyName(i).toUpperCase().indexOf("L") >= 0)
                            Control.LeftSoftKey = i;
                        if(a.getKeyName(i).indexOf("2") >= 0 || a.getKeyName(i).toUpperCase().indexOf("R") >= 0)
                            Control.RightSoftKey = i;
                    }
                    catch(Exception _ex2) { }

            }
        }
    }

    public j(f f1, d d1)
    {
        this(f1);
    }

    private final f a;
}
