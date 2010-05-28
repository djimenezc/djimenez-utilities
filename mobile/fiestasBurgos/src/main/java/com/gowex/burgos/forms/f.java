package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.*;
import com.gowex.burgos.principal.Control;

public final class f extends Canvas
{
//    static class d
//    {
//    }

    private class e extends TimerTask
    {

        public final void run()
        {
            com.gowex.burgos.forms.j j1;

            if(f.a(a))
                (j1 = new com.gowex.burgos.forms.j(a, null)).run();
            f.a(a);
        }

        private final f a;

        private e()
        {
            a = f.this;
        }

//        public e(d d1)
//        {
//            this(f.this);
//        }
    }

    private class j extends Thread
    {

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

        private final f a;

        private j()
        {
            a = f.this;
        }

//        public j(d d1)
//        {
//            this(f.this);
//        }
    }


    public f(Control control, Display display, String s, int i, boolean flag, boolean flag1, int k)
    {
        a_java_util_Timer_fld = new Timer();
        a_boolean_fld = false;
        a_int_fld = 0;
        b_int_fld = 0;
        c = false;
        a_javax_microedition_lcdui_Image_fld = null;
        a_principal_Control_fld = control;
        a_javax_microedition_lcdui_Display_fld = display;
        a_int_fld = i;
        a_boolean_fld = flag;
        b_boolean_fld = flag1;
        b_int_fld = k;
        String s1 = null;
        if(getWidth() > 238)
            s1 = "/res/240/";
        else
        if(getWidth() > 174)
            s1 = "/res/176/";
        else
            s1 = "/res/128/";
        try
        {
            a_javax_microedition_lcdui_Image_fld = Image.createImage(s1 + s);
        }
        catch(Exception _ex)
        {
            return;
        }
        setFullScreenMode(true);
        c = true;
        a_javax_microedition_lcdui_Display_fld.setCurrent(this);
    }

    private void a()
    {
        a_java_util_Timer_fld.cancel();
        a_principal_Control_fld.actualizaEstado();
    }

    public final void keyPressed(int i)
    {
        if(b_boolean_fld)
            a();
    }

    public final void pointerPressed(int i, int k)
    {
        if(b_boolean_fld)
            a();
    }

    public final void paint(Graphics g)
    {
        if(c)
        {
            int i = (getWidth() - a_javax_microedition_lcdui_Image_fld.getWidth()) / 2;
            int k = (getHeight() - a_javax_microedition_lcdui_Image_fld.getHeight()) / 2;
            g.setColor(b_int_fld);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(a_javax_microedition_lcdui_Image_fld, i, k, 0);
            if(getHeight() > Control.pantallaAlto)
            {
                Control.pantallaAncho = getWidth();
                Control.pantallaAlto = getHeight();
            }
        }
    }

    public final void showNotify()
    {
        a_java_util_Timer_fld.schedule(new com.gowex.burgos.forms.e(this, null), a_int_fld);
    }

    public static boolean a(f f1)
    {
        return f1.a_boolean_fld;
    }
//TODO comentado
//    public static void a(f f1)
//    {
//        f1.a();
//    }

    private Control a_principal_Control_fld;
    private Display a_javax_microedition_lcdui_Display_fld;
    private Timer a_java_util_Timer_fld;
    private boolean a_boolean_fld;
    private int a_int_fld;
    private boolean b_boolean_fld;
    private int b_int_fld;
    private boolean c;
    private Image a_javax_microedition_lcdui_Image_fld;
}
