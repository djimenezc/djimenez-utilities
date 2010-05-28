// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package com.gowex.burgos.principal;

import com.gowex.burgos.forms.f;
import com.gowex.burgos.forms.g;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Control extends MIDlet
{

    public Control()
    {
        a_int_fld = -1;
    }

    public void startApp()
    {
        a_javax_microedition_lcdui_Display_fld = Display.getDisplay(this);
        actualizaEstado();
    }

    public void actualizaEstado()
    {
        a_int_fld++;
        switch(a_int_fld)
        {
        case 0: // '\0'
            a();
            return;

        case 1: // '\001'
            b();
            return;

        case 2: // '\002'
            c();
            return;

        case 3: // '\003'
            b();
            return;

        case 4: // '\004'
            d();
            break;
        }
    }

    private void a()
    {
        (new f(this, a_javax_microedition_lcdui_Display_fld, "portada0.png", 2000, true, false, 0xffffff)).setFullScreenMode(true);
    }

    private void b()
    {
        (new f(this, a_javax_microedition_lcdui_Display_fld, "portada1.png", 2500, false, false, 0xffffff)).setFullScreenMode(true);
    }

    private void c()
    {
        miInterfaz = new g(this, a_javax_microedition_lcdui_Display_fld);
    }

    private void d()
    {
        destroyApp(true);
        notifyDestroyed();
    }

    public void pauseApp()
    {
    }

    public void destroyApp(boolean flag)
    {
    }

    private Display a_javax_microedition_lcdui_Display_fld;
    public g miInterfaz;
    public static int LeftSoftKey = 0;
    public static int RightSoftKey = 0;
    public static int pantallaAncho = 0;
    public static int pantallaAlto = 0;
    private int a_int_fld;

}
