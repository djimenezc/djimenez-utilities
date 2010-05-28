package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;
import javax.microedition.lcdui.*;
import com.gowex.burgos.principal.Control;

public final class g
    implements CommandListener
{

    public g(Control control, Display display)
    {
        i = 0;
        a_c_fld = null;
        k = 0;
        a_principal_Control_fld = control;
        a_javax_microedition_lcdui_Display_fld = display;
        a_i_fld = new i();
        a_a_fld = new a();
        a_c_fld = new c(a_principal_Control_fld);
        a_c_fld.b = 1;
        a_c_fld.a_l_fld.a(1);
        a_javax_microedition_lcdui_Command_fld = new Command("Salir", 7, 0);
        b_javax_microedition_lcdui_Command_fld = new Command("Abrir", 1, 0);
        c_javax_microedition_lcdui_Command_fld = new Command("Atr\341s", 2, 0);
        b();
    }

    private void f()
    {
        a_c_fld.a_boolean_fld = true;
        Thread thread;
        (thread = new Thread(a_c_fld)).setPriority(1);
        thread.start();
        a_javax_microedition_lcdui_Display_fld.setCurrent(a_c_fld);
    }

    public final void a()
    {
        a_c_fld.a_boolean_fld = false;
        b();
    }

    public final void b()
    {
        String as[] = {
            "Bienvenidos", "Programa", "Callejero", "Destacados", "Ayuda"
        };
        Image image = a("/res/iconos/bienvenidosICO.png");
        Image image1 = a("/res/iconos/programaICO.png");
        Image image2 = a("/res/iconos/callejeroICO.png");
        Image image3 = a("/res/iconos/concursosICO.png");
        Image image4 = a("/res/iconos/ayudaICO.png");
        Image aimage[] = {
            image, image1, image2, image3, image4
        };
        List list;
        (list = new List("San Pedro y San Pablo 2009", 3, as, aimage)).setSelectedIndex(a_int_static_fld, true);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.addCommand(a_javax_microedition_lcdui_Command_fld);
        i = 0;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void g()
    {
        a_javax_microedition_lcdui_Form_fld.addCommand(c_javax_microedition_lcdui_Command_fld);
        a_javax_microedition_lcdui_Form_fld.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(a_javax_microedition_lcdui_Form_fld);
    }

    private void h()
    {
        a_javax_microedition_lcdui_Form_fld = a_i_fld.a();
        i = 1;
        g();
    }

    public final void c()
    {
        String as[] = {
            "Junio", "Julio"
        };
        Image image = a("/res/iconos/programaICO.png");
        Image image1 = a("/res/iconos/programaICO.png");
        Image aimage[] = {
            image, image1
        };
        List list;
        (list = new List("Programa", 3, as, aimage)).setSelectedIndex(d, true);
        Ticker ticker = new Ticker("Seleccione una mes...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 2;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void i()
    {
        i = 3;
        a_javax_microedition_lcdui_Display_fld.setCurrent(b.a(this));
    }

    private void j()
    {
        i = 4;
        a_javax_microedition_lcdui_Display_fld.setCurrent(com.gowex.burgos.forms.h.a(this));
    }

    private void k()
    {
        String as[] = {
            "Ma\361ana", "Tarde", "Noche"
        };
        Image image = a("/res/iconos/mananaICO.png");
        Image image1 = a("/res/iconos/tardeICO.png");
        Image image2 = a("/res/iconos/nocheICO.png");
        Image aimage[] = {
            image, image1, image2
        };
        int i1 = 0;
        if(d == 0)
            i1 = j;
        else
        if(d == 1)
            i1 = k;
        List list;
        (list = new List("D\355a " + i1, 3, as, aimage)).setSelectedIndex(c_int_static_fld, true);
        Ticker ticker = new Ticker("Seleccione una franja horaria...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 5;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    public final void d()
    {
        k();
    }

    public final void e()
    {
        switch(k)
        {
        case 5: // '\005'
            a_javax_microedition_lcdui_Form_fld = a_i_fld.C();
            i = 7;
            g();
            return;

        case 9: // '\t'
            a_javax_microedition_lcdui_Form_fld = a_i_fld.D();
            i = 7;
            g();
            return;
        }
        k();
    }

    private void l()
    {
        String as[] = {
            "Para los peques", "Calles de fiesta", "Conciertos y Plazas con M\372sica", "Toros", "Fuegos Artificiales", "Noches de humor con San Miguel", "Teatro principal", "Ferias y exposiciones", "Feria de Tapas"
        };
        Image image = a("/res/iconos/previosICO.png");
        Image image1 = a("/res/iconos/previosICO.png");
        Image image2 = a("/res/iconos/previosICO.png");
        Image image3 = a("/res/iconos/previosICO.png");
        Image image4 = a("/res/iconos/previosICO.png");
        Image image5 = a("/res/iconos/previosICO.png");
        Image image6 = a("/res/iconos/previosICO.png");
        Image image7 = a("/res/iconos/previosICO.png");
        Image image8 = a("/res/iconos/previosICO.png");
        Image aimage[] = {
            image, image1, image2, image3, image4, image5, image6, image7, image8
        };
        List list;
        (list = new List("Destacados", 3, as, aimage)).setSelectedIndex(e, true);
        Ticker ticker = new Ticker("Seleccione un tipo de evento para m\341s informaci\363n...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 11;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void m()
    {
        String as[] = {
            "Circo", "Teatro Familiar", "Teatro de Paso"
        };
        Image image = a("/res/iconos/previosICO.png");
        Image image1 = a("/res/iconos/previosICO.png");
        Image image2 = a("/res/iconos/previosICO.png");
        Image aimage[] = {
            image, image1, image2
        };
        List list;
        (list = new List("Calles de Fiesta", 3, as, aimage)).setSelectedIndex(f, true);
        Ticker ticker = new Ticker("Seleccione un tipo de evento para m\341s informaci\363n...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 13;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void n()
    {
        String as[] = {
            "Informacion", "Plaza de Espa\361a", "Plaza de la Libertad", "Plaza de Roma", "Plaza Mayor", "Plaza de Alonso Mart\355nez", "Plaza de Santo Domingo de Guzm\341n", "Calle del General Santocildes", "Frente a su establecimiento"
        };
        Image image = a("/res/iconos/previosICO.png");
        Image aimage[] = {
            image, image, image, image, image, image, image, image, image
        };
        List list;
        (list = new List("V Feria de Tapas", 3, as, aimage)).setSelectedIndex(h, true);
        Ticker ticker = new Ticker("Seleccione una zona para ver los bares...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 17;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void o()
    {
        String as[] = {
            "Grandes Conciertos", "Parque Virgen del Manzano", "Llana de Afuera", "Plazas con M\372sica", "Espacios de Baile"
        };
        Image image = a("/res/iconos/previosICO.png");
        Image image1 = a("/res/iconos/previosICO.png");
        Image image2 = a("/res/iconos/previosICO.png");
        Image image3 = a("/res/iconos/previosICO.png");
        Image image4 = a("/res/iconos/previosICO.png");
        Image aimage[] = {
            image, image1, image2, image3, image4
        };
        List list;
        (list = new List("Conciertos y Plazas con M\372sica", 3, as, aimage)).setSelectedIndex(g, true);
        Ticker ticker = new Ticker("Seleccione un tipo de evento para m\341s informaci\363n...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 15;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    private void p()
    {
        String as[] = {
            "Instrucciones", "Obtener la aplicacion", "Bluetooth", "Acerca de..."
        };
        Image image = a("/res/iconos/infoICO.png");
        Image image1 = a("/res/iconos/previosICO.png");
        Image image2 = a("/res/iconos/bluetoothICO.png");
        Image image3 = a("/res/iconos/bienvenidosICO.png");
        Image aimage[] = {
            image, image1, image2, image3
        };
        List list;
        (list = new List("Ayuda", 3, as, aimage)).setSelectedIndex(b_int_static_fld, true);
        Ticker ticker = new Ticker("Seleccione un tema de ayuda...");
        list.addCommand(c_javax_microedition_lcdui_Command_fld);
        list.addCommand(b_javax_microedition_lcdui_Command_fld);
        list.setTicker(ticker);
        i = 9;
        list.setCommandListener(this);
        a_javax_microedition_lcdui_Display_fld.setCurrent(list);
    }

    public final void commandAction(Command command, Displayable displayable)
    {
        if(i == 0)
        {
            if(command == a_javax_microedition_lcdui_Command_fld)
            {
                a_principal_Control_fld.actualizaEstado();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list;
                a_int_static_fld = (list = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(a_int_static_fld)
                {
                case 0: // '\0'
                    h();
                    break;

                case 1: // '\001'
                    c();
                    break;

                case 2: // '\002'
                    f();
                    break;

                case 3: // '\003'
                    l();
                    break;

                case 4: // '\004'
                    p();
                    // fall through

                default:
                    return;
                }
            }
        } else
        if(i == 1)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                b();
                return;
            }
        } else
        if(i == 2)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                d = 0;
                b();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list1;
                d = (list1 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(d)
                {
                case 0: // '\0'
                    i();
                    break;

                case 1: // '\001'
                    j();
                    // fall through

                default:
                    return;
                }
            }
        } else
        if(i == 6)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                k();
                return;
            }
        } else
        if(i == 7)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                switch(k)
                {
                case 5: // '\005'
                case 9: // '\t'
                    j();
                    return;
                }
                k();
                return;
            }
        } else
        if(i == 5)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                c_int_static_fld = 0;
                if(d == 0)
                {
                    i();
                    return;
                }
                if(d == 1)
                {
                    j();
                    return;
                }
            } else
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list2;
                c_int_static_fld = (list2 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(c_int_static_fld)
                {
                case 0: // '\0'
                    if(d == 0)
                        switch(j)
                        {
                        case 26: // '\032'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.b();
                            break;

                        case 27: // '\033'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.e();
                            break;

                        case 28: // '\034'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.h();
                            break;

                        case 29: // '\035'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.k();
                            break;

                        case 30: // '\036'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.n();
                            break;
                        }
                    else
                    if(d == 1)
                        switch(k)
                        {
                        case 1: // '\001'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.q();
                            break;

                        case 2: // '\002'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.t();
                            break;

                        case 3: // '\003'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.w();
                            break;

                        case 4: // '\004'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.z();
                            break;
                        }
                    break;

                case 1: // '\001'
                    if(d == 0)
                        switch(j)
                        {
                        case 26: // '\032'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.c();
                            break;

                        case 27: // '\033'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.f();
                            break;

                        case 28: // '\034'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.i();
                            break;

                        case 29: // '\035'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.l();
                            break;

                        case 30: // '\036'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.o();
                            break;
                        }
                    else
                    if(d == 1)
                        switch(k)
                        {
                        case 1: // '\001'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.r();
                            break;

                        case 2: // '\002'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.u();
                            break;

                        case 3: // '\003'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.x();
                            break;

                        case 4: // '\004'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.A();
                            break;
                        }
                    break;

                case 2: // '\002'
                    if(d == 0)
                        switch(j)
                        {
                        case 26: // '\032'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.d();
                            break;

                        case 27: // '\033'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.g();
                            break;

                        case 28: // '\034'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.j();
                            break;

                        case 29: // '\035'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.m();
                            break;

                        case 30: // '\036'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.p();
                            break;
                        }
                    else
                    if(d == 1)
                        switch(k)
                        {
                        case 1: // '\001'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.s();
                            break;

                        case 2: // '\002'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.v();
                            break;

                        case 3: // '\003'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.y();
                            break;

                        case 4: // '\004'
                            a_javax_microedition_lcdui_Form_fld = a_i_fld.B();
                            break;
                        }
                    break;
                }
                if(d == 0)
                    i = 6;
                else
                    i = 7;
                g();
                return;
            }
        } else
        if(i == 9)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                b_int_static_fld = 0;
                b();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list3;
                b_int_static_fld = (list3 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(b_int_static_fld)
                {
                case 0: // '\0'
                    a_javax_microedition_lcdui_Form_fld = a_i_fld.E();
                    break;

                case 1: // '\001'
                    a_javax_microedition_lcdui_Form_fld = a_i_fld.F();
                    break;

                case 2: // '\002'
                    a_javax_microedition_lcdui_Form_fld = a_i_fld.G();
                    break;

                case 3: // '\003'
                    a_javax_microedition_lcdui_Form_fld = a_i_fld.H();
                    break;
                }
                i = 10;
                g();
                return;
            }
        } else
        if(i == 11)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                e = 0;
                b();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list4;
                e = (list4 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                i = 12;
                switch(e)
                {
                case 0: // '\0'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.a();
                    g();
                    break;

                case 1: // '\001'
                    m();
                    break;

                case 2: // '\002'
                    o();
                    break;

                case 3: // '\003'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.j();
                    g();
                    break;

                case 4: // '\004'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.k();
                    g();
                    break;

                case 5: // '\005'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.l();
                    g();
                    break;

                case 6: // '\006'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.m();
                    g();
                    break;

                case 7: // '\007'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.n();
                    g();
                    break;

                case 8: // '\b'
                    n();
                    // fall through

                default:
                    return;
                }
            }
        } else
        if(i == 12)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                l();
                return;
            }
            if(command != b_javax_microedition_lcdui_Command_fld && command.getCommandType() == 1)
                return;
        } else
        if(i == 13)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                f = 0;
                l();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list5;
                f = (list5 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(f)
                {
                case 0: // '\0'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.b();
                    break;

                case 1: // '\001'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.d();
                    break;

                case 2: // '\002'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.c();
                    break;
                }
                i = 14;
                g();
                return;
            }
        } else
        if(i == 14)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                m();
                return;
            }
        } else
        if(i == 17)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                h = 0;
                l();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list6;
                h = (list6 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(h)
                {
                case 0: // '\0'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.o();
                    break;

                case 1: // '\001'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.p();
                    break;

                case 2: // '\002'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.q();
                    break;

                case 3: // '\003'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.r();
                    break;

                case 4: // '\004'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.s();
                    break;

                case 5: // '\005'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.t();
                    break;

                case 6: // '\006'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.u();
                    break;

                case 7: // '\007'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.v();
                    break;

                case 8: // '\b'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.w();
                    break;
                }
                i = 18;
                g();
                return;
            }
        } else
        if(i == 18)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                n();
                return;
            }
        } else
        if(i == 15)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                g = 0;
                l();
                return;
            }
            if(command == b_javax_microedition_lcdui_Command_fld || command.getCommandType() == 1)
            {
                List list7;
                g = (list7 = (List)a_javax_microedition_lcdui_Display_fld.getCurrent()).getSelectedIndex();
                switch(g)
                {
                case 0: // '\0'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.e();
                    break;

                case 1: // '\001'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.f();
                    break;

                case 2: // '\002'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.g();
                    break;

                case 3: // '\003'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.h();
                    break;

                case 4: // '\004'
                    a_javax_microedition_lcdui_Form_fld = a_a_fld.i();
                    break;
                }
                i = 16;
                g();
                return;
            }
        } else
        if(i == 16)
        {
            if(command == c_javax_microedition_lcdui_Command_fld)
            {
                o();
                return;
            }
        } else
        if(i == 10 && command == c_javax_microedition_lcdui_Command_fld)
            p();
    }

    private static Image a(String s)
    {
        Image image = null;
        try {
            image = Image.createImage(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
          
        return image;
    }

    public Control a_principal_Control_fld;
    public Display a_javax_microedition_lcdui_Display_fld;
    public Command a_javax_microedition_lcdui_Command_fld;
    public Command b_javax_microedition_lcdui_Command_fld;
    public Command c_javax_microedition_lcdui_Command_fld;
    public static int a_int_static_fld;
    public static int b_int_static_fld;
    public static int c_int_static_fld;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h = 0;
    public int i;
    public Form a_javax_microedition_lcdui_Form_fld;
    public i a_i_fld;
    public a a_a_fld;
    public c a_c_fld;
    public int j;
    public int k;

}
