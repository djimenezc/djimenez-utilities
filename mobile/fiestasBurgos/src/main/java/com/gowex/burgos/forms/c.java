package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import javax.microedition.lcdui.*;
import com.gowex.burgos.principal.Control;

public final class c extends Canvas
    implements Runnable
{
    //TODO añadido campo
    int b = 0;

    public c(Control control)
    {
        n_int_fld = 0;
        o_int_fld = 0;
        b_boolean_fld = false;
        a_int_fld = 0;
        p_int_fld = 25;
        a_boolean_fld = true;
        s_int_fld = 10;
        a_javax_microedition_lcdui_Image_fld = null;
        t_int_fld = 9;
        u = 4;
        b_int_fld = 0;
        c_boolean_fld = false;
        d_boolean_fld = false;
        w = 0;
        x = 1;
        C = 4;
        D = 2;
        E = 5;
        F = 0;
        G = 0;
        H = 0;
        I = 0;
        b_javax_microedition_lcdui_Image_fld = null;
        P = 4;
        c_javax_microedition_lcdui_Image_fld = null;
        d_javax_microedition_lcdui_Image_fld = null;
        e_javax_microedition_lcdui_Image_fld = null;
        f_javax_microedition_lcdui_Image_fld = null;
        g_javax_microedition_lcdui_Image_fld = null;
        h_javax_microedition_lcdui_Image_fld = null;
        i_javax_microedition_lcdui_Image_fld = null;
        j_javax_microedition_lcdui_Image_fld = null;
        k_javax_microedition_lcdui_Image_fld = null;
        l_javax_microedition_lcdui_Image_fld = null;
        m_javax_microedition_lcdui_Image_fld = null;
        n_javax_microedition_lcdui_Image_fld = null;
        o_javax_microedition_lcdui_Image_fld = null;
        e_boolean_fld = true;
        q_javax_microedition_lcdui_Image_fld = null;
        r_javax_microedition_lcdui_Image_fld = null;
        s_javax_microedition_lcdui_Image_fld = null;
        t_javax_microedition_lcdui_Image_fld = null;
        V = 0;
        W = 13;
        f_boolean_fld = false;
        X = 6;
        a_javax_microedition_lcdui_Font_fld = Font.getFont(0, 0, 8);
        a_l_fld = null;
        d_int_fld = 8;
        e_int_fld = 8;
        f_int_fld = 0;
        g_int_fld = 0;
        h_int_fld = 0xdf081a;
        i_int_fld = 0xffffff;
        j_int_fld = 0;
        k_int_fld = 0xdf081a;
        l_int_fld = 0;
        m_int_fld = 0xdf081a;
        a_principal_Control_static_fld = control;
        setFullScreenMode(true);
        a_l_fld = new l();
        a();
        y = -(R / 2);
        z = -(Q / 2);
        aa = a_javax_microedition_lcdui_Font_fld.getHeight();
        Y = aa / 4;
        if(aa % 4 != 0)
            Y = Y + aa % 4;
        Z = aa / 2 + aa;
        q_int_fld = getHeight() - Z;
        r_int_fld = getWidth();
        N = (r_int_fld * K) / (R + r_int_fld / 2);
        O = (q_int_fld * J) / (Q + q_int_fld / 2);
        L = K / 2 - N / 2;
        M = J / 2 - O / 2;
    }

    private void a()
    {
        a_javax_microedition_lcdui_Image_fld = a("/res/iconos/cargando.png");
        a_javax_microedition_lcdui_Image_array2d_fld = new Image[t_int_fld][u];
        if(e_boolean_fld)
        {
            p_javax_microedition_lcdui_Image_fld = a("/res/mapa/patron.png");
            S = p_javax_microedition_lcdui_Image_fld.getWidth();
            T = p_javax_microedition_lcdui_Image_fld.getHeight();
            R = p_javax_microedition_lcdui_Image_fld.getWidth() * t_int_fld;
            Q = p_javax_microedition_lcdui_Image_fld.getHeight() * u;
        }
        q_javax_microedition_lcdui_Image_fld = a("/res/iconos/cruz.png");
        c_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_arriba.png");
        d_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_arriba_gris.png");
        e_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_arriba_no.png");
        f_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_abajo.png");
        g_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_abajo_gris.png");
        h_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_abajo_no.png");
        l_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_derecha.png");
        m_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_derecha_gris.png");
        n_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_derecha_no.png");
        i_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_izquierda.png");
        j_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_izquierda_gris.png");
        k_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_izquierda_no.png");
        o_javax_microedition_lcdui_Image_fld = a("/res/iconos/central_resaltado.png");
        r_javax_microedition_lcdui_Image_fld = a("/res/iconos/opcion_gris.png");
        s_javax_microedition_lcdui_Image_fld = a("/res/iconos/opcion_amarillo0.png");
        t_javax_microedition_lcdui_Image_fld = a("/res/iconos/opcion_amarillo1.png");
        U = r_javax_microedition_lcdui_Image_fld.getHeight();
        if(getWidth() > 239)
            b_javax_microedition_lcdui_Image_fld = a("/res/240/minimapa.png");
        else
        if(getWidth() > 175)
            b_javax_microedition_lcdui_Image_fld = a("/res/176/minimapa.png");
        else
        if(getWidth() > 127)
            b_javax_microedition_lcdui_Image_fld = a("/res/128/minimapa.png");
        K = b_javax_microedition_lcdui_Image_fld.getWidth();
        J = b_javax_microedition_lcdui_Image_fld.getHeight();
    }

    public final void run()
    {
        do
        {
            if(!a_boolean_fld)
                break;
            switch(a_int_fld)
            {
            case -1: 
                a_long_fld = System.currentTimeMillis();
                if(b_boolean_fld)
                    a(n_int_fld);
                b();
                break;

            case 0: // '\0'
                a_long_fld = System.currentTimeMillis();
                f();
                e();
                g();
                h();
                if(b_boolean_fld)
                    a(n_int_fld);
                d();
                b();
                break;

            case 2: // '\002'
                a_long_fld = System.currentTimeMillis();
                c();
                e();
                g();
                d();
                b();
                break;
            }
        } while(true);
    }

    private void b()
    {
        repaint();
        serviceRepaints();
        b_long_fld = System.currentTimeMillis();
        int i1;
        if((i1 = (int)(b_long_fld - a_long_fld)) < p_int_fld)
            try
            {
                Thread.sleep(p_int_fld - i1);
                return;
            }
            catch(InterruptedException _ex) { }
    }

    private void c()
    {
        if(y > H)
        {
            F = F - D;
            if(F <= -(E * 2))
                F = -(E * 2);
        }
        if(y < H)
        {
            F = F + D;
            if(F >= E * 2)
                F = E * 2;
        }
        if(z > I)
        {
            G = G - D;
            if(G <= -(E * 2))
                G = -(E * 2);
        }
        if(z < I)
        {
            G = G + D;
            if(G >= E * 2)
                G = E * 2;
        }
    }

    public final void keyPressed(int i1)
    {
        b(n_int_fld);
        switch(a_int_fld)
        {
        case -1: 
            n_int_fld = i1;
            b_boolean_fld = true;
            return;

        case 0: // '\0'
            n_int_fld = i1;
            b_boolean_fld = true;
            return;

        case 2: // '\002'
            b_boolean_fld = false;
            a(i1);
            // fall through

        case 1: // '\001'
        default:
            return;
        }
    }

    public final void keyReleased(int i1)
    {
        if(i1 == n_int_fld)
        {
            o_int_fld = 0;
            b_boolean_fld = false;
        }
    }

    private void d()
    {
        for(int i1 = 0; i1 < t_int_fld; i1++)
        {
            for(int k1 = 0; k1 < u; k1++)
                if(-y - r_int_fld / 2 - S > i1 * S && -y + r_int_fld / 2 < i1 * S && -z - q_int_fld / 2 - T > k1 * T && -z + q_int_fld / 2 < k1 * T)
                    a_javax_microedition_lcdui_Image_array2d_fld[i1][k1] = null;

        }

        for(int j1 = 0; j1 < t_int_fld; j1++)
        {
            for(int l1 = 0; l1 < u; l1++)
                if(-y - r_int_fld / 2 - S < j1 * S && -y + r_int_fld / 2 > j1 * S && -z - q_int_fld / 2 - T < l1 * T && -z + q_int_fld / 2 > l1 * T)
                {
                    if(a_javax_microedition_lcdui_Image_array2d_fld[j1][l1] == null)
                    {
                        c_boolean_fld = true;
                        repaint();
                        serviceRepaints();
                        a_javax_microedition_lcdui_Image_array2d_fld[j1][l1] = a("/res/mapa/" + j1 + l1 + ".png");
                    }
                } else
                {
                    a_javax_microedition_lcdui_Image_array2d_fld[j1][l1] = null;
                }

        }

        c_boolean_fld = false;
    }

    public final void pointerPressed(int i1, int j1)
    {
        switch(a_int_fld)
        {
        case 1: // '\001'
        default:
            break;

        case -1: 
            if(i1 < getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
            {
                y = -((R * (L + N / 2)) / K);
                z = -((Q * (M + O / 2)) / J);
                b_boolean_fld = false;
                a_int_fld = 0;
                break;
            }
            if(i1 > getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
            {
                b_boolean_fld = false;
                a_int_fld = 2;
            }
            break;

        case 0: // '\0'
            if(i1 < getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
            {
                H = y;
                I = z;
                a_int_fld = 2;
                x = 1;
                break;
            }
            if(i1 > getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
                a_principal_Control_static_fld.miInterfaz.b();
            break;

        case 2: // '\002'
            if(i1 < getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
            {
                if(x == 3)
                {
                    a_int_fld = -1;
                    break;
                }
                if(x == 2)
                {
                    H = -(a_l_fld.c[c_int_fld].a_int_fld + W / 2);
                    I = -(a_l_fld.c[c_int_fld].b + W / 2);
                    f_boolean_fld = true;
                }
                break;
            }
            if(i1 > getWidth() / 2 && j1 > getHeight() - a_javax_microedition_lcdui_Font_fld.getHeight())
            {
                a_int_fld = 0;
                break;
            }
            if(j1 > q_int_fld - U * 1 && j1 < q_int_fld - U * 0)
                x = 3;
            else
            if(j1 > q_int_fld - U * 2 && j1 < q_int_fld - U * 1)
                x = 2;
            else
            if(j1 > q_int_fld - U * 3 && j1 < q_int_fld - U * 2 && b_int_fld != 0)
                x = 1;
            if(x == 3)
            {
                a_int_fld = -1;
                break;
            }
            if(x == 2)
            {
                H = -a_l_fld.c[c_int_fld].a_int_fld - W / 2;
                I = -a_l_fld.c[c_int_fld].b - W / 2;
                f_boolean_fld = true;
            }
            break;
        }
        repaint();
    }

    private void a(int i1)
    {
        int j1 = getGameAction(i1);
        switch(a_int_fld)
        {
        case 1: // '\001'
        default:
            break;

        case -1: 
            switch(j1)
            {
            case 1: // '\001'
                M = M - P;
                o_int_fld = 1;
                break;

            case 6: // '\006'
                M = M + P;
                o_int_fld = 3;
                break;

            case 5: // '\005'
                L = L + P;
                o_int_fld = 2;
                break;

            case 2: // '\002'
                L = L - P;
                o_int_fld = 4;
                break;

            case 8: // '\b'
                y = -((R * (L + N / 2)) / K);
                z = -((Q * (M + O / 2)) / J);
                b_boolean_fld = false;
                a_int_fld = 0;
                break;
            }
            if(i1 == Control.LeftSoftKey || i1 == 49)
            {
                y = -((R * (L + N / 2)) / K);
                z = -((Q * (M + O / 2)) / J);
                b_boolean_fld = false;
                a_int_fld = 0;
            }
            if(i1 == Control.RightSoftKey || i1 == 51)
            {
                b_boolean_fld = false;
                a_int_fld = 2;
            }
            if(L < 0)
                L = 0;
            if(L > K - N)
                L = K - N;
            if(M < 0)
                M = 0;
            if(M > J - O)
            {
                M = J - O;
                return;
            }
            break;

        case 0: // '\0'
            switch(j1)
            {
            case 1: // '\001'
                G = G + D;
                if(G >= E)
                    G = E;
                o_int_fld = 1;
                break;

            case 6: // '\006'
                G = G - D;
                if(G <= -1 * E)
                    G = -1 * E;
                o_int_fld = 3;
                break;

            case 2: // '\002'
                F = F + D;
                if(F >= E)
                    F = E;
                o_int_fld = 4;
                break;

            case 5: // '\005'
                F = F - D;
                if(F <= -1 * E)
                    F = -1 * E;
                o_int_fld = 2;
                break;

            case 8: // '\b'
                b_boolean_fld = false;
                break;
            }
            if(i1 == Control.LeftSoftKey || i1 == 49)
            {
                H = y;
                I = z;
                a_int_fld = 2;
                if(!f_boolean_fld);
                x = 1;
            }
            if(i1 == Control.RightSoftKey || i1 == 51)
            {
                a_principal_Control_static_fld.miInterfaz.a();
                b_boolean_fld = false;
                n_int_fld = 0;
                o_int_fld = 0;
                c_boolean_fld = true;
                return;
            }
            break;

        case 2: // '\002'
            switch(j1)
            {
            case 1: // '\001'
                if(x == 3 && b_int_fld == 0)
                    x = x - 2;
                else
                if(x > 1)
                    x--;
                else
                if(x > 1)
                    x--;
                break;

            case 6: // '\006'
                if(x == 1 && b_int_fld == 0)
                    x = x + 2;
                else
                if(x < 3)
                {
                    x++;
                    H = -a_l_fld.c[c_int_fld].a_int_fld - W / 2;
                    I = -a_l_fld.c[c_int_fld].b - W / 2;
                    f_boolean_fld = true;
                }
                break;

            case 2: // '\002'
                if(x == 1)
                {
                    if(b_int_fld == 0)
                        b_int_fld = a_l_fld.a_java_lang_String_array1d_fld.length - 1;
                    else
                        b_int_fld--;
                    a_l_fld.a(b_int_fld);
                    c_int_fld = 0;
                    if(b_int_fld == 0)
                        f_boolean_fld = true;
                    else
                        h();
                } else
                if(x == 2)
                {
                    if(b_int_fld != 0)
                    {
                        c_int_fld--;
                        if(c_int_fld < 0)
                            c_int_fld = a_l_fld.c.length - 1;
                        f_boolean_fld = true;
                        H = -(a_l_fld.c[c_int_fld].a_int_fld + W / 2);
                        I = -(a_l_fld.c[c_int_fld].b + W / 2);
                        if(b_int_fld != 12);
                    }
                } else
                if(x != 3);
                break;

            case 5: // '\005'
                if(x == 1)
                {
                    if(b_int_fld == a_l_fld.a_java_lang_String_array1d_fld.length - 1)
                        b_int_fld = 0;
                    else
                        b_int_fld++;
                    a_l_fld.a(b_int_fld);
                    c_int_fld = 0;
                    if(b_int_fld == 0)
                        f_boolean_fld = true;
                    else
                        h();
                } else
                if(x == 2)
                {
                    if(b_int_fld != 0)
                    {
                        c_int_fld++;
                        if(c_int_fld > a_l_fld.c.length - 1)
                            c_int_fld = 0;
                        f_boolean_fld = true;
                        H = -a_l_fld.c[c_int_fld].a_int_fld - W / 2;
                        I = -a_l_fld.c[c_int_fld].b - W / 2;
                        if(b_int_fld != 12);
                    }
                } else
                if(x == 3)
                    c_int_fld = 0;
                break;

            case 8: // '\b'
                if(x == 3)
                    a_int_fld = -1;
                else
                if(x == 2)
                {
                    H = -a_l_fld.c[c_int_fld].a_int_fld - W / 2;
                    I = -a_l_fld.c[c_int_fld].b - W / 2;
                    f_boolean_fld = true;
                }
                break;
            }
            if(i1 == Control.LeftSoftKey || i1 == 49)
            {
                if(x == 3)
                {
                    a_int_fld = -1;
                    return;
                }
                if(x == 2 && b_int_fld == 1)
                {
                    H = -(a_l_fld.c[c_int_fld].a_int_fld + W / 2);
                    I = -(a_l_fld.c[c_int_fld].b + W / 2);
                    f_boolean_fld = true;
                    return;
                }
                break;
            }
            if(i1 == Control.RightSoftKey || i1 == 51)
                a_int_fld = 0;
            break;
        }
    }

    private void e()
    {
        if(F > 0)
            F--;
        else
        if(F < 0)
            F++;
        if(G > 0)
            G--;
        else
        if(G < 0)
            G++;
        y = y + F + A;
        z = z + G + B;
    }

    private void f()
    {
        if(b_int_fld != 0)
        {
            int i1 = a_l_fld.c.length;
            for(int k1 = 0; k1 < i1; k1++)
            {
                if(b_int_fld != a_l_fld.c[k1].c)
                    continue;
                if(y <= -(a_l_fld.c[k1].a_int_fld - C * 2) && z <= -(a_l_fld.c[k1].b - C * 2) && y >= -1 * (a_l_fld.c[k1].a_int_fld + W + C) && z >= -1 * (a_l_fld.c[k1].b + W + C))
                {
                    if(y != -(a_l_fld.c[k1].a_int_fld + W / 2))
                    {
                        if(y < -(a_l_fld.c[k1].a_int_fld + W / 2))
                            A = 1;
                        else
                            A = -1;
                    } else
                    {
                        A = 0;
                    }
                    if(z != -1 * (a_l_fld.c[k1].b + W / 2))
                    {
                        if(z < -1 * (a_l_fld.c[k1].b + W / 2))
                        {
                            B = 1;
                            return;
                        } else
                        {
                            B = -1;
                            return;
                        }
                    } else
                    {
                        B = 0;
                        return;
                    }
                }
                A = 0;
                B = 0;
            }

        }
        int j1 = a_l_fld.b.length;
        for(int l1 = 0; l1 < j1; l1++)
        {
            if(y <= -(a_l_fld.b[l1].a_int_fld - C * 2) && z <= -(a_l_fld.b[l1].b - C * 2) && y >= -1 * (a_l_fld.b[l1].a_int_fld + W + C) && z >= -1 * (a_l_fld.b[l1].b + W + C))
            {
                if(y != -(a_l_fld.b[l1].a_int_fld + W / 2))
                {
                    if(y < -(a_l_fld.b[l1].a_int_fld + W / 2))
                        A = 1;
                    else
                        A = -1;
                } else
                {
                    A = 0;
                }
                if(z != -1 * (a_l_fld.b[l1].b + W / 2))
                {
                    if(z < -1 * (a_l_fld.b[l1].b + W / 2))
                    {
                        B = 1;
                        return;
                    } else
                    {
                        B = -1;
                        return;
                    }
                } else
                {
                    B = 0;
                    return;
                }
            }
            A = 0;
            B = 0;
        }

    }

    private void g()
    {
        if(y >= -1)
            y = 0;
        if(z >= -1)
            z = 0;
        if(y <= -1 * (R + 1))
            y = -1 * R;
        if(z <= -1 * (Q + 1))
            z = -1 * Q;
    }

    private void h()
    {
        if(b_int_fld != 0 && a_int_fld != 2)
        {
            f_boolean_fld = false;
            c_int_fld = 0;
            int i1 = a_l_fld.c.length;
            for(int k1 = 0; k1 < i1; k1++)
                if(b_int_fld == a_l_fld.c[k1].c && y <= -a_l_fld.c[k1].a_int_fld && z <= -a_l_fld.c[k1].b && y >= -1 * (a_l_fld.c[k1].a_int_fld + W) && z >= -1 * (a_l_fld.c[k1].b + W))
                {
                    f_boolean_fld = true;
                    c_int_fld = k1;
                    return;
                }

        }
        d_boolean_fld = false;
        int j1 = a_l_fld.b.length;
        for(int l1 = 0; l1 < j1; l1++)
            if(y <= -a_l_fld.b[l1].a_int_fld && z <= -a_l_fld.b[l1].b && y >= -1 * (a_l_fld.b[l1].a_int_fld + W) && z >= -1 * (a_l_fld.b[l1].b + W))
            {
                v = l1;
                d_boolean_fld = true;
                return;
            }

    }

    private void i()
    {
        if(R > r_int_fld - X)
            try
            {
                int i1 = ((r_int_fld - X) * (r_int_fld - X)) / ((R + r_int_fld) - X);
                int j1;
                int k1 = ((j1 = ((-y * 10000) / ((R + r_int_fld) - X)) * (r_int_fld - X)) - i1 / 2) / 10000;
                a(a_javax_microedition_lcdui_Graphics_fld, i_int_fld, i_int_fld, 0, q_int_fld - X, r_int_fld, q_int_fld, 0);
                a(a_javax_microedition_lcdui_Graphics_fld, h_int_fld, h_int_fld, k1, q_int_fld - X, i1 + k1, q_int_fld, 0);
                a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
                a_javax_microedition_lcdui_Graphics_fld.drawRect(0, q_int_fld - X, r_int_fld - X, q_int_fld);
            }
            catch(Exception _ex) { }
        if(Q > q_int_fld - X)
            try
            {
                int i2 = ((q_int_fld - X) * (q_int_fld - X)) / ((Q + q_int_fld) - X);
                int l1;
                int j2 = ((l1 = ((-z * 10000) / ((Q + q_int_fld) - X)) * (q_int_fld - X)) - i2 / 2) / 10000;
                a(a_javax_microedition_lcdui_Graphics_fld, i_int_fld, i_int_fld, r_int_fld - X, 0, r_int_fld, q_int_fld, 1);
                a(a_javax_microedition_lcdui_Graphics_fld, h_int_fld, h_int_fld, r_int_fld - X, j2, r_int_fld, i2 + j2, 1);
                a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
                a_javax_microedition_lcdui_Graphics_fld.drawRect(r_int_fld - X, 0, r_int_fld, q_int_fld - X);
            }
            catch(Exception _ex) { }
        a_javax_microedition_lcdui_Graphics_fld.setColor(125, 125, 125);
        a_javax_microedition_lcdui_Graphics_fld.fillRect(r_int_fld - X, q_int_fld - X, X, X);
        a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
        a_javax_microedition_lcdui_Graphics_fld.drawRect(r_int_fld - X, q_int_fld - X, r_int_fld, q_int_fld);
    }

    private void j()
    {
        if(b_int_fld != 0)
        {
            int i1 = a_l_fld.c.length;
            for(int k1 = 0; k1 < i1; k1++)
            {
                if(b_int_fld != a_l_fld.c[k1].c)
                    continue;
                switch(a_int_fld)
                {
                case -1: 
                    a(a_l_fld.c[k1].a_int_fld, a_l_fld.c[k1].b, 0xff0000);
                    break;

                default:
                    if(-y - r_int_fld / 2 - W < a_l_fld.c[k1].a_int_fld && -y + r_int_fld / 2 > a_l_fld.c[k1].a_int_fld && -z - q_int_fld / 2 - W < a_l_fld.c[k1].b && -z + q_int_fld / 2 > a_l_fld.c[k1].b)
                        a(a_l_fld.c[k1].a_int_fld, a_l_fld.c[k1].b, 0);
                    break;
                }
            }

        }
        int j1 = a_l_fld.b.length;
        int l1 = 0;
        do
        {
            if(l1 >= j1)
                break;
            switch(a_int_fld)
            {
            case -1: 
                a(a_l_fld.b[l1].a_int_fld, a_l_fld.b[l1].b, 0xfe6501);
                break;
            }
            l1++;
        } while(true);
    }

    private void a(int i1, int j1, int k1)
    {
        switch(a_int_fld)
        {
        case -1: 
            a_javax_microedition_lcdui_Graphics_fld.setColor(k1);
            a_javax_microedition_lcdui_Graphics_fld.fillRect((i1 * K) / R, (j1 * J) / Q + (q_int_fld / 2 - J / 2), 3, 3);
            return;
        }
        Image image = a_l_fld.a_javax_microedition_lcdui_Image_array1d_fld[b_int_fld];
        a_javax_microedition_lcdui_Graphics_fld.drawImage(image, r_int_fld / 2 - (-y - i1), q_int_fld / 2 - (-z - j1), 20);
    }

    private void k()
    {
        if(f_boolean_fld)
        {
            if(b_int_fld == 1)
            {
                a_javax_microedition_lcdui_Graphics_fld.setFont(a_javax_microedition_lcdui_Font_fld);
                a(a_javax_microedition_lcdui_Graphics_fld, j_int_fld, k_int_fld, s_int_fld, s_int_fld, r_int_fld - s_int_fld, s_int_fld + (aa + Y) * 2, 0);
                a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
                a_javax_microedition_lcdui_Graphics_fld.drawRect(s_int_fld, s_int_fld, r_int_fld - s_int_fld * 2, (aa + Y) * 2);
                a_javax_microedition_lcdui_Graphics_fld.setColor(255, 255, 255);
                String s1 = a(a_l_fld.a_java_lang_String_array1d_fld[b_int_fld], r_int_fld - s_int_fld * 2, "...");
                String s5 = a(a_l_fld.c[c_int_fld].a_java_lang_String_fld, r_int_fld - s_int_fld * 2, "...");
                a_javax_microedition_lcdui_Graphics_fld.drawString(s1, s_int_fld + Y, s_int_fld + Y, 20);
                a_javax_microedition_lcdui_Graphics_fld.drawString(s5, s_int_fld + Y, s_int_fld + Y + aa, 20);
                return;
            }
            if(b_int_fld == 2)
            {
                a_javax_microedition_lcdui_Graphics_fld.setFont(a_javax_microedition_lcdui_Font_fld);
                a(a_javax_microedition_lcdui_Graphics_fld, j_int_fld, k_int_fld, s_int_fld, s_int_fld, r_int_fld - s_int_fld, s_int_fld + (aa + Y), 0);
                a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
                a_javax_microedition_lcdui_Graphics_fld.drawRect(s_int_fld, s_int_fld, r_int_fld - s_int_fld * 2, aa + Y);
                a_javax_microedition_lcdui_Graphics_fld.setColor(255, 255, 255);
                String s2 = a(a_l_fld.c[c_int_fld].a_java_lang_String_fld, r_int_fld - s_int_fld * 2, "...");
                a_javax_microedition_lcdui_Graphics_fld.drawString(s2, s_int_fld + Y, s_int_fld + Y, 20);
                return;
            }
            if(b_int_fld != 0)
            {
                a_javax_microedition_lcdui_Graphics_fld.setFont(a_javax_microedition_lcdui_Font_fld);
                a(a_javax_microedition_lcdui_Graphics_fld, j_int_fld, k_int_fld, s_int_fld, s_int_fld, r_int_fld - s_int_fld, s_int_fld + (aa + Y) * 2, 0);
                a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
                a_javax_microedition_lcdui_Graphics_fld.drawRect(s_int_fld, s_int_fld, r_int_fld - s_int_fld * 2, (aa + Y) * 2);
                a_javax_microedition_lcdui_Graphics_fld.setColor(255, 255, 255);
                String s3 = a(a_l_fld.a_java_lang_String_array1d_fld[b_int_fld], r_int_fld - s_int_fld * 2, "...");
                String s6 = a(a_l_fld.c[c_int_fld].a_java_lang_String_fld, r_int_fld - s_int_fld * 2, "...");
                a_javax_microedition_lcdui_Graphics_fld.drawString(s3, s_int_fld + Y, s_int_fld + Y, 20);
                a_javax_microedition_lcdui_Graphics_fld.drawString(s6, s_int_fld + Y, s_int_fld + Y + aa, 20);
                return;
            }
        } else
        if(d_boolean_fld)
        {
            a_javax_microedition_lcdui_Graphics_fld.setFont(a_javax_microedition_lcdui_Font_fld);
            a(a_javax_microedition_lcdui_Graphics_fld, j_int_fld, k_int_fld, s_int_fld, s_int_fld, r_int_fld - s_int_fld, s_int_fld + (aa + Y), 0);
            a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
            a_javax_microedition_lcdui_Graphics_fld.drawRect(s_int_fld, s_int_fld, r_int_fld - s_int_fld * 2, aa + Y);
            a_javax_microedition_lcdui_Graphics_fld.setColor(255, 255, 255);
            String s4 = a(a_l_fld.b[v].a_java_lang_String_fld, r_int_fld - s_int_fld * 2, "...");
            a_javax_microedition_lcdui_Graphics_fld.drawString(s4, s_int_fld + Y, s_int_fld + Y, 20);
        }
    }

    private String a(String s1, int i1, String s2)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j1 = 0;
        int k1 = s1.length();
        int l1 = 3;
        int i2 = s2.length();
        for(int j2 = 0; j2 < i2; j2++)
            l1 += a_javax_microedition_lcdui_Font_fld.charWidth(s2.charAt(j2));

        for(int k2 = 0; k2 < k1; k2++)
            if((j1 += a_javax_microedition_lcdui_Font_fld.charWidth(s1.charAt(k2))) + l1 < i1)
                stringbuffer.append(s1.charAt(k2));

        if(j1 + l1 >= i1)
            stringbuffer.append(s2);
        return stringbuffer.toString();
    }

    private int keyCode(String s1)
    {
        int i1 = 0;
        int j1 = s1.length();
        for(int k1 = 0; k1 < j1; k1++)
            i1 += a_javax_microedition_lcdui_Font_fld.charWidth(s1.charAt(k1));

        return i1;
    }

    private void l()
    {
label0:
        {
            a(a_javax_microedition_lcdui_Graphics_fld, l_int_fld, m_int_fld, 0, q_int_fld, r_int_fld, q_int_fld + Z, 0);
            a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
            a_javax_microedition_lcdui_Graphics_fld.drawLine(0, q_int_fld, r_int_fld, q_int_fld);
            a_javax_microedition_lcdui_Graphics_fld.setColor(255, 255, 255);
            switch(a_int_fld)
            {
            case 1: // '\001'
            default:
                break label0;

            case -1: 
                a_javax_microedition_lcdui_Graphics_fld.drawString("Zoom + [1]", 3, getHeight() - 2, 36);
                break;

            case 0: // '\0'
                a_javax_microedition_lcdui_Graphics_fld.drawString("Menu [1]", 3, getHeight() - 2, 36);
                break;

            case 2: // '\002'
                if(x == 2 && b_int_fld != 0)
                    a_javax_microedition_lcdui_Graphics_fld.drawString("Ir [1]", 3, getHeight() - 2, 36);
                if(x == 3)
                    a_javax_microedition_lcdui_Graphics_fld.drawString("Abrir [1]", 3, getHeight() - 2, 36);
                break;
            }
            a_javax_microedition_lcdui_Graphics_fld.drawString("Atr\341s [3]", getWidth() - 3, getHeight() - 2, 40);
        }
        int i1 = r_int_fld / 2;
        int j1 = q_int_fld + Y;
        if(f_boolean_fld)
            if(V == 5)
            {
                V = 0;
            } else
            {
                V++;
                a_javax_microedition_lcdui_Graphics_fld.drawImage(o_javax_microedition_lcdui_Image_fld, i1, j1, 17);
            }
        if(-z != 0)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(d_javax_microedition_lcdui_Image_fld, i1, j1, 17);
        if(-y != R && a_int_fld != 4)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(m_javax_microedition_lcdui_Image_fld, i1, j1, 17);
        if(-z != Q)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(g_javax_microedition_lcdui_Image_fld, i1, j1, 17);
        if(-y != 0 && a_int_fld != 4)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(j_javax_microedition_lcdui_Image_fld, i1, j1, 17);
        switch(o_int_fld)
        {
        case 1: // '\001'
            if(-z != 0)
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(c_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            } else
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(e_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            }

        case 2: // '\002'
            if(-y != R)
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(l_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            } else
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(n_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            }

        case 3: // '\003'
            if(-z != Q)
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(f_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            } else
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(h_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            }

        case 4: // '\004'
            if(-y != 0)
            {
                a_javax_microedition_lcdui_Graphics_fld.drawImage(i_javax_microedition_lcdui_Image_fld, i1, j1, 17);
                return;
            }
            a_javax_microedition_lcdui_Graphics_fld.drawImage(k_javax_microedition_lcdui_Image_fld, i1, j1, 17);
            break;
        }
    }

    private void m()
    {
        a_javax_microedition_lcdui_Graphics_fld.setColor(0, 0, 0);
        Image image = r_javax_microedition_lcdui_Image_fld;
        Image image1 = r_javax_microedition_lcdui_Image_fld;
        Image image2 = r_javax_microedition_lcdui_Image_fld;
        Image image3 = t_javax_microedition_lcdui_Image_fld;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        switch(x)
        {
        case 1: // '\001'
            image = s_javax_microedition_lcdui_Image_fld;
            i1 = 0xffffff;
            j1 = 0;
            k1 = 0;
            break;

        case 2: // '\002'
            image1 = s_javax_microedition_lcdui_Image_fld;
            i1 = 0;
            j1 = 0xffffff;
            k1 = 0;
            break;

        case 3: // '\003'
            image2 = s_javax_microedition_lcdui_Image_fld;
            i1 = 0;
            j1 = 0;
            k1 = 0xffffff;
            break;
        }
        a_javax_microedition_lcdui_Graphics_fld.setFont(a_javax_microedition_lcdui_Font_fld);
        a_javax_microedition_lcdui_Graphics_fld.setColor(k1);
        a_javax_microedition_lcdui_Graphics_fld.drawImage(image2, 0, q_int_fld - U * 0, 36);
        a_javax_microedition_lcdui_Graphics_fld.drawString("Zoom -", 8, q_int_fld - U * 0 - 1, 36);

        String s1;
        
        if(b_int_fld == 0)
        {
            s1 = "\253 x \273";
            f_int_fld = keyCode(s1);
            a_javax_microedition_lcdui_Graphics_fld.setColor(200, 200, 200);
        } else
        {
            s1 = "\253 " + a_l_fld.c[c_int_fld].a_java_lang_String_fld + " \273 ";
            f_int_fld = keyCode(s1);
            a_javax_microedition_lcdui_Graphics_fld.setColor(j1);
        }
        a_javax_microedition_lcdui_Graphics_fld.drawImage(image1, 0, q_int_fld - U * 1, 36);
        if(f_int_fld + 8 > getWidth())
        {
            if(x == 2)
            {
                if(d_int_fld + f_int_fld > 8)
                    d_int_fld = d_int_fld - 1;
                else
                    d_int_fld = 8;
                s1 = " " + s1 + s1;
            } else
            {
                d_int_fld = 8;
                s1 = a(s1, getWidth() - 8, "... \273");
            }
        } else
        {
            d_int_fld = 8;
        }
        a_javax_microedition_lcdui_Graphics_fld.drawString(s1, d_int_fld, q_int_fld - U * 1 - 1, 36);
        if(x == 2)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(image3, 0, q_int_fld - U * 1, 36);
        a_javax_microedition_lcdui_Graphics_fld.setColor(i1);
        a_javax_microedition_lcdui_Graphics_fld.drawImage(image, 0, q_int_fld - U * 2, 36);
        s1 = " \253 " + a_l_fld.a_java_lang_String_array1d_fld[b_int_fld] + " \273 ";

//        int intValue = Integer.valueOf(s1).intValue();
       //TODO         g_int_fld = a(s1);
        g_int_fld = 2;

        if(g_int_fld + 8 > getWidth())
        {
            if(x == 1)
            {
                if(e_int_fld + g_int_fld > 8)
                    e_int_fld = e_int_fld - 1;
                else
                    e_int_fld = 8;
                s1 = " " + s1 + s1;
            } else
            {
                e_int_fld = 8;
                s1 = a(s1, getWidth() - 8, "...  \273");
            }
        } else
        {
            e_int_fld = 8;
        }
        a_javax_microedition_lcdui_Graphics_fld.drawString(s1, e_int_fld, q_int_fld - U * 2 - 1, 36);
        if(x == 1)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(image3, 0, q_int_fld - U * 2, 36);
    }

    private void n()
    {
        a_javax_microedition_lcdui_Graphics_fld.setColor(255, 0, 0);
        a_javax_microedition_lcdui_Graphics_fld.drawRect(L + (r_int_fld / 2 - K / 2), M + (q_int_fld / 2 - J / 2), O, O);
    }

    private void o()
    {
        if(e_boolean_fld)
        {
            for(int i1 = 0; i1 < t_int_fld; i1++)
            {
                for(int j1 = 0; j1 < u; j1++)
                    try
                    {
                        if(-y - r_int_fld / 2 - S >= i1 * S || -y + r_int_fld / 2 + S <= i1 * S || -z - q_int_fld / 2 - T >= j1 * T || -z + q_int_fld / 2 + T <= j1 * T)
                            continue;
                        if(a_javax_microedition_lcdui_Image_array2d_fld[i1][j1] != null)
                            a_javax_microedition_lcdui_Graphics_fld.drawImage(a_javax_microedition_lcdui_Image_array2d_fld[i1][j1], y + r_int_fld / 2 + i1 * S, z + q_int_fld / 2 + j1 * T, 0);
                        else
                            a_javax_microedition_lcdui_Graphics_fld.drawImage(p_javax_microedition_lcdui_Image_fld, y + r_int_fld / 2 + i1 * S, z + q_int_fld / 2 + j1 * T, 0);
                    }
                    catch(Exception _ex) { }

            }

        }
        a_javax_microedition_lcdui_Graphics_fld.setColor(0);
        a_javax_microedition_lcdui_Graphics_fld.drawRect(r_int_fld / 2 - -y, q_int_fld / 2 - -z, R, Q);
    }

    private void p()
    {
        if(c_boolean_fld)
            a_javax_microedition_lcdui_Graphics_fld.drawImage(a_javax_microedition_lcdui_Image_fld, r_int_fld / 2, q_int_fld / 2, 3);
    }

    public final void paint(Graphics g1)
    {
        a_javax_microedition_lcdui_Graphics_fld = g1;
        q_int_fld = getHeight() - Z;
        r_int_fld = getWidth();
        g1.setFont(a_javax_microedition_lcdui_Font_fld);
        switch(a_int_fld)
        {
        case -1: 
            N = (r_int_fld * K) / (R + r_int_fld / 2);
            O = (q_int_fld * J) / (Q + q_int_fld / 2);
            b(255, 255, 255);
            g1.drawImage(b_javax_microedition_lcdui_Image_fld, r_int_fld / 2, q_int_fld / 2, 3);
            l();
            if(w > -1 && w < 11)
                w++;
            else
            if(w > 10 && w < 60)
            {
                j();
                w++;
            } else
            if(w == 60)
                w = 0;
            n();
            return;

        case 0: // '\0'
            b(255, 255, 255);
            o();
            if(w > -1 && w < 11)
                w++;
            else
            if(w > 10 && w < 60)
            {
                j();
                w++;
            } else
            if(w == 60)
                w = 0;
            i();
            g1.drawImage(q_javax_microedition_lcdui_Image_fld, r_int_fld / 2, q_int_fld / 2, 3);
            l();
            k();
            p();
            return;

        case 2: // '\002'
            b(255, 255, 255);
            o();
            if(w > -1 && w < 11)
                w++;
            else
            if(w > 10 && w < 60)
            {
                j();
                w++;
            } else
            if(w == 60)
                w = 0;
            g1.drawImage(q_javax_microedition_lcdui_Image_fld, r_int_fld / 2, q_int_fld / 2, 3);
            l();
            m();
            k();
            p();
            return;

        case 3: // '\003'
            b(255, 255, 255);
            o();
            l();
            k();
            // fall through

        case 1: // '\001'
        default:
            return;
        }
    }

    private static void a(Graphics g1, int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = i1 >> 16 & 0xff;
        int i3 = i1 >> 8 & 0xff;
        int j3 = i1 >> 0 & 0xff;
        int k3 = j1 >> 16 & 0xff;
        int l3 = j1 >> 8 & 0xff;
        int i4 = j1 >> 0 & 0xff;
        try
        {
            int j4;
            int k4;
            int l4;
            if(k2 == 0)
            {
                j4 = j2 - l1;
                k4 = l1;
                l4 = j2;
            } else
            {
                j4 = i2 - k1;
                k4 = k1;
                l4 = i2;
            }
            if(j4 == 0)
                j4 = 1;
            int i5 = 0;
            int j5 = 0;
            int k5 = 0;
            if(l2 != k3)
                i5 = (k3 * 10 - l2 * 10) / j4;
            if(i3 != l3)
                j5 = (l3 * 10 - i3 * 10) / j4;
            if(j3 != i4)
                k5 = (i4 * 10 - j3 * 10) / j4;
            int l5 = l2 * 10;
            int i6 = i3 * 10;
            int j6 = j3 * 10;
            for(int k6 = k4; k6 <= l4; k6++)
            {
                g1.setColor(l5 / 10, i6 / 10, j6 / 10);
                if(k2 == 0)
                    g1.drawLine(k1, k6, i2, k6);
                else
                    g1.drawLine(k6, l1, k6, j2);
                l5 += i5;
                i6 += j5;
                j6 += k5;
                if(l5 >= 2550)
                    l5 = 2550;
                if(i6 >= 2550)
                    i6 = 2550;
                if(j6 >= 2550)
                    j6 = 2550;
            }

            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private void b(int i1, int j1, int k1)
    {
        a_javax_microedition_lcdui_Graphics_fld.setColor(i1, j1, k1);
        a_javax_microedition_lcdui_Graphics_fld.fillRect(0, 0, r_int_fld, q_int_fld);
    }

    private static Image a(String s1)
    {
        Image image = null;
        try
        {
            image = Image.createImage(s1);
        }
        catch(Exception _ex) { }
        return image;
    }

    private void b(int i1)
    {
        if(Control.LeftSoftKey == 0)
            try
            {
                if(getKeyName(i1).toUpperCase().indexOf("SOFT") >= 0 && (getKeyName(i1).indexOf("1") >= 0 || getKeyName(i1).toUpperCase().indexOf("L") >= 0))
                    Control.LeftSoftKey = i1;
            }
            catch(Exception _ex) { }
        if(Control.RightSoftKey == 0)
            try
            {
                if(getKeyName(i1).toUpperCase().indexOf("SOFT") >= 0 && (getKeyName(i1).indexOf("2") >= 0 || getKeyName(i1).toUpperCase().indexOf("R") >= 0))
                    Control.RightSoftKey = i1;
            }
            catch(Exception _ex) { }
        if(Control.LeftSoftKey == 0 && (i1 == -6 || i1 == -202 || i1 == -21 || i1 == 57345 || i1 == 21 || i1 == 105))
            Control.LeftSoftKey = i1;
        if(Control.RightSoftKey == 0 && (i1 == -7 || i1 == -203 || i1 == -22 || i1 == 57346 || i1 == 22 || i1 == 106))
            Control.RightSoftKey = i1;
    }

    private static Control a_principal_Control_static_fld;
    private Graphics a_javax_microedition_lcdui_Graphics_fld;
    private int n_int_fld;
    private int o_int_fld;
    private boolean b_boolean_fld;
    public int a_int_fld;
    private int p_int_fld;
    public boolean a_boolean_fld;
    private int q_int_fld;
    private int r_int_fld;
    private int s_int_fld;
    private Image a_javax_microedition_lcdui_Image_fld;
    private int t_int_fld;
    private int u;
    public long a_long_fld;
    public long b_long_fld;
    public int b_int_fld;
    private boolean c_boolean_fld;
    private int v;
    private boolean d_boolean_fld;
    private int w;
    private int x;
    private int y;
    private int z;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Image b_javax_microedition_lcdui_Image_fld;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private Image c_javax_microedition_lcdui_Image_fld;
    private Image d_javax_microedition_lcdui_Image_fld;
    private Image e_javax_microedition_lcdui_Image_fld;
    private Image f_javax_microedition_lcdui_Image_fld;
    private Image g_javax_microedition_lcdui_Image_fld;
    private Image h_javax_microedition_lcdui_Image_fld;
    private Image i_javax_microedition_lcdui_Image_fld;
    private Image j_javax_microedition_lcdui_Image_fld;
    private Image k_javax_microedition_lcdui_Image_fld;
    private Image l_javax_microedition_lcdui_Image_fld;
    private Image m_javax_microedition_lcdui_Image_fld;
    private Image n_javax_microedition_lcdui_Image_fld;
    private Image o_javax_microedition_lcdui_Image_fld;
    private boolean e_boolean_fld;
    private Image a_javax_microedition_lcdui_Image_array2d_fld[][];
    private Image p_javax_microedition_lcdui_Image_fld;
    private int Q;
    private int R;
    private int S;
    private int T;
    private Image q_javax_microedition_lcdui_Image_fld;
    private Image r_javax_microedition_lcdui_Image_fld;
    private Image s_javax_microedition_lcdui_Image_fld;
    private Image t_javax_microedition_lcdui_Image_fld;
    private int U;
    private int V;
    public int c_int_fld;
    private int W;
    private boolean f_boolean_fld;
    private int X;
    private int Y;
    private int Z;
    private Font a_javax_microedition_lcdui_Font_fld;
    private int aa;
    public l a_l_fld;
    public int d_int_fld;
    public int e_int_fld;
    public int f_int_fld;
    public int g_int_fld;
    public int h_int_fld;
    public int i_int_fld;
    public int j_int_fld;
    public int k_int_fld;
    public int l_int_fld;
    public int m_int_fld;
}
