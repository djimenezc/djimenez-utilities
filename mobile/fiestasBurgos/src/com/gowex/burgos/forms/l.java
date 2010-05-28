package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import javax.microedition.lcdui.Image;

public final class l
{

    public l()
    {
        a_javax_microedition_lcdui_Image_array1d_fld = new Image[a_java_lang_String_array1d_fld.length];
        a_javax_microedition_lcdui_Image_array1d_fld[0] = a("/res/puntos/imagenpunto1.png");
        a_javax_microedition_lcdui_Image_array1d_fld[1] = a("/res/puntos/imagenpunto1.png");
        a_javax_microedition_lcdui_Image_array1d_fld[2] = a("/res/puntos/imagenpunto2.png");
        a();
        a(0);
        b();
    }

    private void a()
    {
        a_k_array1d_fld = (new k[] {
            new k(93, 890, 1, "1. Paseo del Empecinado", 0, 0), new k(8, 820, 1, "2. Parque de la Isla ", 0, 1), new k(50, 710, 1, "3. Teatro Clunia", 0, 2), new k(50, 480, 1, "4. Cerro de San Miguel", 0, 3), new k(180, 630, 1, "5. Calle Valent\355n Palencia", 0, 4), new k(205, 660, 1, "6. Llana de Afuera", 0, 5), new k(190, 710, 1, "7. Catedral", 0, 6), new k(205, 715, 1, "8. Plaza del Rey San Fernando", 0, 7), new k(230, 730, 1, "9. Paseo del Espol\363n, frente Arco de Santa Mar\355a", 0, 8), new k(235, 755, 1, "10. Puente de Santa Mar\355a", 0, 9), 
            new k(300, 710, 1, "11. Paseo del Espol\363n, Templete", 0, 10), new k(275, 710, 1, "12. Paseo del Espol\363n", 0, 11), new k(270, 690, 1, "13. Ayuntamiento de Burgos", 0, 12), new k(225, 692, 1, "14. Calle La Paloma", 0, 13), new k(280, 675, 1, "15. Plaza Mayor", 0, 14), new k(330, 660, 1, "16. Plaza Santo Domingo de Guzm\341n", 0, 15), new k(333, 700, 1, "17. Teatro Principal", 0, 16), new k(345, 696, 1, "18. Teatro Principal, Sal\363n Rojo", 0, 17), new k(366, 720, 1, "19. Puente de San Pablo", 0, 18), new k(366, 655, 1, "20. Plaza de la Libertad", 0, 19), 
            new k(360, 575, 1, "21. Calle Santocildes", 0, 20), new k(325, 560, 1, "22. Plaza Alonso Mart\355nez", 0, 21), new k(300, 520, 1, "23. Parque del Doctor Vara", 0, 22), new k(340, 400, 1, "24. Plaza de los Vadillos", 0, 23), new k(420, 535, 1, "25. Plaza Espa\361a", 0, 24), new k(460, 595, 1, "26. Calle San Lesmes", 0, 25), new k(500, 585, 1, "27. Monasterio de San Juan", 0, 26), new k(550, 470, 1, "28. Plaza Virgen del Manzano", 0, 27), new k(590, 240, 1, "29. Parque de Lord Baden Powell", 0, 28), new k(630, 570, 1, "30. Paseo de Regino Sainz de la Maza", 0, 29), 
            new k(800, 625, 1, "31. Parque de la Quinta", 0, 30), new k(800, 160, 1, "32. Confluencia de las Calles Francisco de Vitoria y Eloy Garc\355a de Quevedo", 0, 31), new k(990, 290, 1, "33. Aparcamiento del Centro Comercial Camino de la Plata", 0, 32), new k(1140, 370, 1, "34. Ciudad Deportiva Militar", 0, 33), new k(1070, 525, 1, "35. Plaza de Toros", 0, 34), new k(1292, 488, 1, "36. Polideportivo El Plant\355o", 0, 35), new k(1330, 440, 1, "37. Bolera El Plant\355o, Calle Villafranca", 0, 36), new k(1360, 307, 1, "38. Parque F\351lix Rodr\355guez de la Fuente", 0, 37), new k(1415, 190, 1, "40. Plaza de Roma", 0, 38), new k(1242, 124, 1, "41. Polideportivo Lavaderos", 0, 39), 
            new k(1266, 18, 1, "42. Parque de los Poetas", 0, 40), new k(1570, 370, 1, "43. Campa del Silo", 0, 41), new k(415, 550, 2, "Plaza de Espa\361a", 1, 0), new k(340, 590, 2, "Santocildes", 1, 1), new k(390, 670, 2, "Plaza de la Libertad", 1, 2), new k(275, 575, 2, "Plaza Alonso Martinez", 1, 3), new k(320, 685, 2, "Plaza Santo Domingo de Guzman", 1, 4), new k(280, 690, 2, "Plaza Mayor", 1, 5), new k(225, 692, 2, "La Paloma", 1, 6), new k(1410, 210, 2, "Plaza de Roma", 1, 7)
        });
    }

    public final void a(int i)
    {
        int j = 0;
        int i1 = a_k_array1d_fld.length;
        for(int j1 = 0; j1 < i1; j1++)
            if(a_k_array1d_fld[j1].c == i)
                j++;

        c = new k[j];
        int k1 = 0;
        for(int l1 = 0; l1 < i1; l1++)
            if(a_k_array1d_fld[l1].c == i)
            {
                c[k1] = a_k_array1d_fld[l1];
                k1++;
            }

    }

    private void b()
    {
        b = new k[0];
    }

    private static Image a(String s)
    {
        Image image = null;
        try
        {
            image = Image.createImage(s);
        }
        catch(Exception _ex) { }
        return image;
    }

    public k a_k_array1d_fld[];
    public k b[];
    public k c[];
    public String a_java_lang_String_array1d_fld[] = {
        "Selecc. tipo", "Puntos de inter\351s", "V Feria de Tapas"
    };
    public Image a_javax_microedition_lcdui_Image_array1d_fld[];
}
