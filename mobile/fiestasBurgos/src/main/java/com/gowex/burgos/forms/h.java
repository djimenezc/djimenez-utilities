package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;
import javax.microedition.lcdui.*;

public final class h extends Canvas
    implements CommandListener
{

    public static h a(g g1)
    {
        if(a_h_static_fld == null)
            a_h_static_fld = new h(g1);
        return a_h_static_fld;
    }

    private h(g g1)
    {
        String s;
        h = 1;
        a_javax_microedition_lcdui_Command_fld = new Command("Atr\341s", 2, 1);
        b_javax_microedition_lcdui_Command_fld = new Command("Abrir", 1, 1);
        a_javax_microedition_lcdui_Font_fld = Font.getFont(32, 1, 8);
        a_g_fld = g1;
        if(getHeight() > getWidth())
        {
            a_int_fld = getWidth();
            b_int_fld = getWidth();
        } else
        {
            a_int_fld = getHeight();
            b_int_fld = getHeight();
        }
        c = (getHeight() - b_int_fld) / 2;
        e = b_int_fld / 7;
        d = (getWidth() - a_int_fld) / 2 - 3;
        f = d + 2 * e;
        g = c + 2 * e;
        s = "";
        if(getWidth() > 126)
            s = "/res/128/";
        if(getWidth() > 174)
            s = "/res/176/";
        if(getWidth() > 238)
            s = "/res/240/";
        try {
            a_javax_microedition_lcdui_Image_fld = Image.createImage(s + "fondo.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        addCommand(a_javax_microedition_lcdui_Command_fld);
        addCommand(b_javax_microedition_lcdui_Command_fld);
        setCommandListener(this);
        return;
    }

    public final void paint(Graphics g1)
    {
        g1.setColor(0);
        g1.fillRect(0, 0, getWidth(), getHeight());
        g1.drawImage(a_javax_microedition_lcdui_Image_fld, getWidth() / 2, getHeight() / 2, 3);
        g1.setFont(a_javax_microedition_lcdui_Font_fld);
        g1.setColor(0);
        g1.drawString("Julio de 2009", getWidth() / 2, (c + e) - 3, 65);
        g1.setColor(0xe2eaaf);
        g1.fillRect(f + 1, g + 2, e, e - 3);
        g1.setColor(0);
        g1.drawString("L", d + 1 * e, (c + 2 * e) - 5, 72);
        g1.drawString("M", d + 2 * e, (c + 2 * e) - 5, 72);
        g1.drawString("X", d + 3 * e, (c + 2 * e) - 5, 72);
        g1.drawString("J", d + 4 * e, (c + 2 * e) - 5, 72);
        g1.drawString("V", d + 5 * e, (c + 2 * e) - 5, 72);
        g1.setColor(0);
        g1.drawString("S", d + 6 * e, (c + 2 * e) - 5, 72);
        g1.drawString("D", d + 7 * e, (c + 2 * e) - 5, 72);
        g1.drawString("", d + 1 * e, (c + 3 * e) - 4, 72);
        g1.drawString("", d + 2 * e, (c + 3 * e) - 4, 72);
        g1.drawString("1", d + 3 * e, (c + 3 * e) - 4, 72);
        g1.drawString("2", d + 4 * e, (c + 3 * e) - 4, 72);
        g1.drawString("3", d + 5 * e, (c + 3 * e) - 4, 72);
        g1.drawString("4", d + 6 * e, (c + 3 * e) - 4, 72);
        g1.drawString("5", d + 7 * e, (c + 3 * e) - 4, 72);
        g1.setColor(0xffffff);
        g1.drawString("6", d + 1 * e, (c + 4 * e) - 4, 72);
        g1.drawString("7", d + 2 * e, (c + 4 * e) - 4, 72);
        g1.drawString("8", d + 3 * e, (c + 4 * e) - 4, 72);
        g1.setColor(0);
        g1.drawString("9", d + 4 * e, (c + 4 * e) - 4, 72);
        g1.setColor(0xffffff);
        g1.drawString("10", d + 5 * e, (c + 4 * e) - 4, 72);
        g1.drawString("11", d + 6 * e, (c + 4 * e) - 4, 72);
        g1.drawString("12", d + 7 * e, (c + 4 * e) - 4, 72);
        g1.drawString("13", d + 1 * e, (c + 5 * e) - 4, 72);
        g1.drawString("14", d + 2 * e, (c + 5 * e) - 4, 72);
        g1.drawString("15", d + 3 * e, (c + 5 * e) - 4, 72);
        g1.drawString("16", d + 4 * e, (c + 5 * e) - 4, 72);
        g1.drawString("17", d + 5 * e, (c + 5 * e) - 4, 72);
        g1.drawString("18", d + 6 * e, (c + 5 * e) - 4, 72);
        g1.drawString("19", d + 7 * e, (c + 5 * e) - 4, 72);
        g1.drawString("20", d + 1 * e, (c + 6 * e) - 4, 72);
        g1.drawString("21", d + 2 * e, (c + 6 * e) - 4, 72);
        g1.drawString("22", d + 3 * e, (c + 6 * e) - 4, 72);
        g1.drawString("23", d + 4 * e, (c + 6 * e) - 4, 72);
        g1.drawString("24", d + 5 * e, (c + 6 * e) - 4, 72);
        g1.drawString("25", d + 6 * e, (c + 6 * e) - 4, 72);
        g1.drawString("26", d + 7 * e, (c + 6 * e) - 4, 72);
        g1.drawString("27", d + 1 * e, (c + 7 * e) - 4, 72);
        g1.drawString("28", d + 2 * e, (c + 7 * e) - 4, 72);
        g1.drawString("29", d + 3 * e, (c + 7 * e) - 4, 72);
        g1.drawString("30", d + 4 * e, (c + 7 * e) - 4, 72);
        g1.drawString("31", d + 5 * e, (c + 7 * e) - 4, 72);
    }

    public final void keyPressed(int i)
    {
        hasRepeatEvents();
        a(getGameAction(i));
    }

    private void a(int i)
    {
        switch(i)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 7: // '\007'
        default:
            break;

        case 2: // '\002'
            if(h == 9)
            {
                h = 5;
                f = d + 6 * e;
                g = g - e;
                repaint();
                return;
            }
            if(h > 1)
            {
                h--;
                f = f - e;
                repaint();
                return;
            }
            break;

        case 5: // '\005'
            if(h == 5)
            {
                h = 9;
                f = d + 3 * e;
                g = g + e;
                repaint();
                return;
            }
            if(h < 5)
            {
                h++;
                f = f + e;
                repaint();
                return;
            }
            break;

        case 1: // '\001'
            if(h == 9)
            {
                h = 2;
                g = g - e;
                repaint();
                return;
            }
            break;

        case 6: // '\006'
            if(h == 2)
            {
                h = 9;
                g = g + e;
                repaint();
                return;
            }
            break;

        case 8: // '\b'
            a();
            break;
        }
    }

    public final void commandAction(Command command, Displayable displayable)
    {
        if(command == a_javax_microedition_lcdui_Command_fld)
        {
            a_g_fld.c();
            return;
        }
        if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            a();
    }

    private void a()
    {
        a_g_fld.k = h;
        a_g_fld.e();
    }

    private static h a_h_static_fld = null;
    private int a_int_fld;
    private int b_int_fld;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Image a_javax_microedition_lcdui_Image_fld;
    public Command a_javax_microedition_lcdui_Command_fld;
    public Command b_javax_microedition_lcdui_Command_fld;
    private Font a_javax_microedition_lcdui_Font_fld;
    private g a_g_fld;

}
