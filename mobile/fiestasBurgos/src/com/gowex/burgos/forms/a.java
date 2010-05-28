package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;
import javax.microedition.lcdui.*;
import com.gowex.burgos.principal.Control;

public final class a
{

    public a()
    {
        a_javax_microedition_lcdui_ImageItem_fld = null;
        b = null;
        a_javax_microedition_lcdui_Ticker_fld = null;
        a_java_lang_String_fld = "/res/" + Control.pantallaAncho + "/";
    }

    public final Form a()
    {
        Form form = new Form("Pensando para los peques");
        b = new ImageItem("Pensando para los peques\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("La plaza de la magia:\n", "Plaza de la Libertad, 13:00 horas y 19:30 horas. Lunes 29 de junio: Kayto (Madrid). Martes 30 de junio: Carlos Adriano (Argentina). Mi\351rcoles 1 de julio: Diego Calavia (La Rioja). Jueves 2 de julio: Lossar (Burgos). Viernes 3 de julio: Struc (Barcelona). S\341bado 4 de julio: Zaki (Vizcaya).\n \n");
        StringItem stringitem1 = new StringItem("A jugar a la calle:\n", "Juegos Infantiles en tu barrio, de 11:30 a 14:00 y de 18:00 a 20:00 h. S\341bado 27 de junio: Parque de San Agust\355n. Domingo 28 de junio: Parque de los Poetas. Lunes 29 de junio: Parque de la Isla. Martes 30 de junio: Parque del Dr. F\351lix Rodr\355guez de la Fuente. Mi\351rcoles 1 de julio: Parque de la Luz (Barrio de Vista Alegre). Jueves 2 de julio: Parque de la Quinta, bajo la autov\355a\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form b()
    {
        Form form = new Form("Circo");
        b = new ImageItem("Circo\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Lugar:\n", "Plaza Mayor.\n \n");
        StringItem stringitem1 = new StringItem("S\341bado 27 de junio\n", "20:30, Movimiento Armario (Uruguay), 'Falsa escuadra'.\n \n");
        StringItem stringitem2 = new StringItem("Domingo 28 de junio\n", "20:30, Tr\355o Zindare (Francia), 'La vuelta'.\n \n");
        StringItem stringitem3 = new StringItem("Lunes 29 de junio\n", "19:30 y 21:15, Happy Stars (Francia) 'Flying brothers'.\n \n");
        StringItem stringitem4 = new StringItem("Martes 30 de julio\n", "20:30, Mumusic Circus (Barcelona), 'Merci bien'.\n \n");
        StringItem stringitem5 = new StringItem("Mi\351rcoles 1 de julio\n", "20:30, Circo Delirio (Argentina-Uruguay-Brasil), 'Cabaret de mercosur'.\n \n");
        StringItem stringitem6 = new StringItem("Jueves 2 de julio\n", "19:30 y 21:00, Fundaci\363n Chiminigagua (Colombia), 'Rituales de lo primitivo a lo moderno'.\n \n");
        StringItem stringitem7 = new StringItem("Viernes 3 de julio\n", "20:30, Vaiv\351n Circo-Danza (Granada), 'La felicidad en un dos por dos'.\n \n");
        StringItem stringitem8 = new StringItem("S\341bado 4 de julio\n", "20:30, C\355a. Rolabola (M\341laga), 'Pl\341zidos domingos'.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form c()
    {
        Form form = new Form("Teatro de Paso");
        b = new ImageItem("Teatro de Paso\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Lugar\n", "Paseo del Espol\363n, itinerantes.\n \n");
        StringItem stringitem1 = new StringItem("Viernes 26 de junio\n", "20:30, Turukutup\341 (\301lava), 'Rezicletas, concierto itinerante'.\n \n");
        StringItem stringitem2 = new StringItem("Viernes 26 de junio\n", "20:30, Cie. Les Hommes Poissons (Francia), 'Protecci\363n de proximidad de las plantas'.\n \n");
        StringItem stringitem3 = new StringItem("S\341bado 27 de junio\n", "19:00 y 20:00, Cie. Les Hommes Poissons (Francia), 'Protecci\363n de proximidad de las plantas'.\n \n");
        StringItem stringitem4 = new StringItem("S\341bado 27 de junio\n", "19:30, Teatro Salitre (Vizcaya), 'On egin mon amour'.\n \n");
        StringItem stringitem5 = new StringItem("Domingo 28 de junio\n", "19:30, Tiritirantes (Burgos), 'Escuela de vuelo'.\n \n");
        StringItem stringitem6 = new StringItem("Domingo 28 de junio\n", "20:15, El Sidral (L\351rida), 'Los farsantes'.\n \n");
        StringItem stringitem7 = new StringItem("Lunes 29 de junio\n", "20:00 y 21:00, Miguelillo (Salamanca), 'D\363nde estar\341 mi carrum'.\n \n");
        StringItem stringitem8 = new StringItem("Lunes 29 de junio\n", "20:15, Cie. d\264ailleurs (Francia), 'Los alquimistas'.\n \n");
        StringItem stringitem9 = new StringItem("Martes 30 de junio\n", "19:30 y 21:00, Cie. d\264ailleurs (Francia), 'Un hombre y una mujer'.\n \n");
        StringItem stringitem10 = new StringItem("Martes 30 de junio\n", "20:15, Vagalume Teatro (Granada), 'A cuadros'.\n \n");
        StringItem stringitem11 = new StringItem("Mi\351rcoles 1 de julio\n", "20:15, C\355a. de Teatro El Carromato (C\341diz), 'Bufonadas'.\n \n");
        StringItem stringitem12 = new StringItem("Mi\351rcoles 1 de julio\n", "21:15 Teatro Primigenio (C\363rdoba), 'Misi\363n primitiva'.\n \n");
        StringItem stringitem13 = new StringItem("Jueves 2 de julio\n", "20:15 C\355a. de teatro El Carromato (C\341diz), 'El carrom\341giko'.\n \n");
        StringItem stringitem14 = new StringItem("Jueves 2 de julio\n", "21:15 Teatro Primigenio (C\363rdoba), 'Mision primitiva'.\n \n");
        StringItem stringitem15 = new StringItem("Viernes 3 de julio\n", "19:30, 20:30 y 21:30 C\355a. La Tal (Barcelona), 'Indian taxi'.\n \n");
        StringItem stringitem16 = new StringItem("Viernes 3 de julio\n", "20:15 Festuc Teatre (L\351rida) Moon space, 'Lun\341ticos'.\n \n");
        StringItem stringitem17 = new StringItem("S\341bado 4 de julio\n", "19:30, 20:30 y 21:30 C\355a. La Tal (Barcelona), 'Indian taxi'.\n \n");
        StringItem stringitem18 = new StringItem("S\341bado 4 de julio\n", "20:15 Scura Splats (Castell\363n), 'Macroscopi'.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        stringitem9.setLayout(1);
        stringitem10.setLayout(1);
        stringitem11.setLayout(1);
        stringitem12.setLayout(1);
        stringitem13.setLayout(1);
        stringitem14.setLayout(1);
        stringitem15.setLayout(1);
        stringitem16.setLayout(1);
        stringitem17.setLayout(1);
        stringitem18.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(stringitem9);
        form.append(stringitem10);
        form.append(stringitem11);
        form.append(stringitem12);
        form.append(stringitem13);
        form.append(stringitem14);
        form.append(stringitem15);
        form.append(stringitem16);
        form.append(stringitem17);
        form.append(stringitem18);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form d()
    {
        Form form = new Form("Teatro Familiar");
        b = new ImageItem("Teatro Familiar\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Lugar y Hora\n", "Paseo del Espol\363n, cuatro reyes, 20:00 h.\n \n");
        StringItem stringitem1 = new StringItem("S\341bado 27 de junio\n", "Las Pituister (Burgos), 'Vamos que nos vamos'.\n \n");
        StringItem stringitem2 = new StringItem("Domingo 28 de junio\n", "Insomnio Teatro (Burgos), 'Ata-pu'.\n \n");
        StringItem stringitem3 = new StringItem("Lunes 29 de junio\n", "Ronco Teatro (Burgos), 'La cabriola de la dragona'.\n \n");
        StringItem stringitem4 = new StringItem("Martes 30 de junio\n", "Los Kikolas (Burgos), 'Dr. Ficante'.\n \n");
        StringItem stringitem5 = new StringItem("Mi\351rcoles 1 de julio\n", "El Gran Rufus (Valladolid), 'No hay tiempo que perder'.\n \n");
        StringItem stringitem6 = new StringItem("Jueves 2 de julio\n", "Circoactivo (Madrid), 'Aire'.\n \n");
        StringItem stringitem7 = new StringItem("Viernes 3 de julio\n", "La Sonrisa (Burgos), 'Desaguisados'.\n \n");
        StringItem stringitem8 = new StringItem("S\341bado 4 de julio\n", "En la Lona (Argentina-Espa\361a), 'Momento ridiccoli'.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form e()
    {
        Form form = new Form("Aparcamiento del C.C. Camino de la Plata");
        b = new ImageItem("Aparcamiento del C.C. Camino de la Plata\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Viernes 26 de junio\n", "0:15, Carlos Baute.\n \n");
        StringItem stringitem1 = new StringItem("S\341bado 27 de junio\n", "0:15, El Sue\361o de Morfeo.\n \n");
        StringItem stringitem2 = new StringItem("Domingo 28 de junio\n", "0:15, Loquillo.\n \n");
        StringItem stringitem3 = new StringItem("Lunes 29 de junio\n", "22:30, Raphael.\n \n");
        StringItem stringitem4 = new StringItem("Mi\351rcoles 1 de julio\n", "22:00, Noche de Rock Joven: Cronometrobud\372 + Honoris Causa + Ka\363tico.\n \n");
        StringItem stringitem5 = new StringItem("Jueves 2 de julio\n", "20:30, Festival Indie: Entertainiment + El Columpio Asesino + Vinodelf\355n + Sidonie.\n \n");
        StringItem stringitem6 = new StringItem("Viernes 3 de julio\n", "0:15, Nena Daconte.\n \n");
        StringItem stringitem7 = new StringItem("S\341bado 4 de julio\n", "0:15, Los Chichos.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form f()
    {
        Form form = new Form("Parque Virgen del Manzano");
        b = new ImageItem("Parque Virgen del Manzano\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Viernes 26 de junio\n", "21:30, Gladis Mercado y sus Charros.\n \n");
        StringItem stringitem1 = new StringItem("S\341bado 27 de junio\n", "22:00, Sundayers.\n \n");
        StringItem stringitem2 = new StringItem("Domingo 28 de junio\n", "00:00, The Soulutions.\n \n");
        StringItem stringitem3 = new StringItem("Lunes 29 de junio\n", "00:00, La Familia Funkster.\n \n");
        StringItem stringitem4 = new StringItem("Martes 30 de junio\n", "22:00, Sangre de Tango Show.\n \n");
        StringItem stringitem5 = new StringItem("Mi\351rcoles 1 de julio\n", "22:00, Septeto Deboson.\n \n");
        StringItem stringitem6 = new StringItem("Jueves 2 de julio\n", "20:00, Zona Fitness - Hermanos Exp\363sito.\n \n");
        StringItem stringitem7 = new StringItem("Viernes 3 de julio\n", "00:00, Triquel.\n \n");
        StringItem stringitem8 = new StringItem("S\341bado 4 de julio\n", "00:00, El Puchero del Hortelano.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form g()
    {
        Form form = new Form("Llana de Afuera");
        b = new ImageItem("Llana de Afuera\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Viernes 26 de junio, V Muestra Espiral Sonora de M\372sica Electr\363nica\n", "00:00 - Goiko, Domi & Supraelokuen. 01:00 - Adenocrom. 02:00 - Homeless.\n \n");
        StringItem stringitem1 = new StringItem("S\341bado 27 de junio\n", "22:00 - Adrenalina 33. 00:00 - Triplet.\n \n");
        StringItem stringitem2 = new StringItem("Domingo 28 de junio\n", "22:00 - Mares. 00:00 - Mistweaver.\n \n");
        StringItem stringitem3 = new StringItem("Lunes 29 de junio\n", "22:00 - El Ment\363n de Fogarty.\n \n");
        StringItem stringitem4 = new StringItem("Jueves 2 de julio\n", "22:00 - Entrev\355as. 23:00 - Natural Way. 00:00 - Mr. Mach\355n.\n \n");
        StringItem stringitem5 = new StringItem("Viernes 3 de julio, XII Festival Burgos en Vivo\n", "22:00 - Ondulador McMurray. 00:00 - Supernautas. 01:15 - Doble Malta.\n \n");
        StringItem stringitem6 = new StringItem("S\341bado 4 de julio, XII Festival Burgos en Vivo\n", "22:00 - Misplace. 00:00 - Gemma. 01:15 - Sexma.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form h()
    {
        Form form = new Form("Calle Valent\355n Palencia");
        b = new ImageItem("Calle Valent\355n Palencia\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Lugar\n", "Calle Valent\355n Palencia (escalinata junto al CAB).\n \n");
        StringItem stringitem1 = new StringItem("Hora\n", "20:30 h.\n \n");
        StringItem stringitem2 = new StringItem("Martes 30 de junio\n", "Mariano Mangas.\n \n");
        StringItem stringitem3 = new StringItem("Mi\351rcoles 1 de julio\n", "Los Gatos Bizcos.\n \n");
        StringItem stringitem4 = new StringItem("Jueves 2 de julio\n", "Tuco y los Definitivos.\n \n");
        StringItem stringitem5 = new StringItem("Viernes 3 de julio\n", "Morgan Club.\n \n");
        StringItem stringitem6 = new StringItem("S\341bado 4 de julio\n", "El Esp\355ritu de L\372gubre.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form i()
    {
        Form form = new Form("Espacios de Baile");
        b = new ImageItem("Espacios de Baile\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("BAILES DE SIEMPRE\n", "Paseo de Regino Sainz de la Maza. 20:00 h: Martes 30 de junio, Orquesta Banda del Arlanz\363n. Mi\351rcoles 1 de julio, Mila y Tarlat\341n. Jueves 2 de julio, Mila y Tarlat\341n. Viernes 3 de julio, Orquesta Banda del Arlanz\363n.\n \n");
        StringItem stringitem1 = new StringItem("BAILES VESPERTINOS\n", "Templete del Espol\363n, 21:30 h: Viernes 26 de junio, Diego Galaz y Carlos Beceiro.\n \n");
        StringItem stringitem2 = new StringItem("BAILES DE TARDE\n", "Parque de Fuentes Blancas, 19:00 h: S\341bado 4 de julio, Mila y Tarlat\341n.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form j()
    {
        Form form = new Form("Toros");
        b = new ImageItem("Toros\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("S\301BADO 27 DE JUNIO, 18:30 h.:\n", "Fuera de abono. Espect\341culo c\363mico taurino. EL BOMBERO TORERO PRECIO: 10 \u20AC ADULTOS Y 5 \u20AC NI\321OS.\n \n");
        StringItem stringitem1 = new StringItem("DOMINGO 28 DE JUNIO, 18:30 h.:\n", "CORRIDA DE TOROS DE ABONO. 6 TOROS de Celestino Cuadri. JUAN JOS\311 PADILLA, LUIS BOL\315VAR, SALVADOR CORT\311S.\n \n");
        StringItem stringitem2 = new StringItem("LUNES 29 DE JUNIO, 18:30 h.:\n", "DE ABONO. 6 TOROS de Zalduendo. ENRIQUE PONCE, MIGUEL \301NGEL PERERA, MORENITO DE ARANDA.\n \n");
        StringItem stringitem3 = new StringItem("MARTES 30 DE JUNIO, 18:30 h.:\n", "CORRIDA DE TOROS DE ABONO. 6 TOROS de M\252 Jos\351 Barral. Manuel D\355az \u201CEL CORDOB\311S\u201D, Francisco RIVERA ORD\323\321EZ, David Fandilla \u201CEL FANDI\u201D.\n \n");
        StringItem stringitem4 = new StringItem("MI\311RCOLES 1 DE JULIO\n", "CORRIDA DE TOROS DE ABONO. 6 TOROS de Gerardo Ortega. Manuel Jes\372s \u201CEL CID\u201D, SEBASTI\301N CASTELLA, MIGUEL \301NGEL PERERA.\n \n");
        StringItem stringitem5 = new StringItem("JUEVES 2 DE JULIO\n", "CORRIDA DE TOROS DE ABONO. 6 TOROS de Antonio Ba\361uelos. Juli\341n L\363pez \u201CEL JULI\u201D, Jos\351 M\252 MANZANARES, CAYETANO.\n \n");
        StringItem stringitem6 = new StringItem("VIERNES 3 DE JULIO\n", "CORRIDA DE TOROS DE ABONO. 6 TOROS de Los Recitales. Jos\351 Pedro Prados \u201CEL FUNDI\u201D, JOS\311 IGNACIO RAMOS, ANTONIO FERRERA.\n \n");
        StringItem stringitem7 = new StringItem("S\301BADO 4 DE JULIO\n", "FUERA DE ABONO. 6 TOROS de Ben\355tez Cubero. FERM\315N BOH\323RQUEZ, HERMOSO DE MENDOZA, DIEGO VENTURA.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form k()
    {
        Form form = new Form("Fuegos Artificiales");
        b = new ImageItem("Fuegos Artificiales\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Lugar\n", "Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem1 = new StringItem("Hora\n", "23:30 h.\n \n");
        StringItem stringitem2 = new StringItem("1\252 sesi\363n, Viernes, 26 de junio\n", "Pirotecnia Caballer Fx & Service, de Valencia.\n \n");
        StringItem stringitem3 = new StringItem("2\252 sesi\363n, S\341bado, 27 de junio\n", "Pirotecnia Vulcano, de Madrid.\n \n");
        StringItem stringitem4 = new StringItem("3\252 sesi\363n, Domingo, 28 de junio\n", "Pirotecnia Zaragozana, de Zaragoza.\n \n");
        StringItem stringitem5 = new StringItem("4\252 sesi\363n, Lunes, 29 de junio\n", "Pirotecnia Toste, de Islas Canarias.\n \n");
        StringItem stringitem6 = new StringItem("5\252 sesi\363n, Mi\351rcoles, 1 de julio\n", "Pirotecnia Reiriz, de Asturias.\n \n");
        StringItem stringitem7 = new StringItem("6\252 sesi\363n, Viernes, 3 de julio\n", "Fireworks Colonnelli, de Italia.\n \n");
        StringItem stringitem8 = new StringItem("7\252 sesi\363n, S\341bado, 4 de julio\n", "First Class Pyro-Events, de Alemania.\n \n");
        StringItem stringitem9 = new StringItem("Exhibici\363n en Gamonal\n", "Campa del Silo, 23:30 h., 1\252 sesi\363n Lunes, 30 de junio Pirotecnia Pablo, de Asturias.\n \n");
        StringItem stringitem10 = new StringItem("Exhibici\363n en Gamonal\n", "Campa del Silo, 23:30 h., 2\252 sesi\363n Mi\351rcoles, 2 de julio Pirotecnia Turis, de Valencia.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        stringitem9.setLayout(1);
        stringitem10.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(stringitem9);
        form.append(stringitem10);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form l()
    {
        Form form = new Form("Noches de Humor con San Miguel");
        b = new ImageItem("Noches de Humor con San Miguel\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        a_javax_microedition_lcdui_Ticker_fld = new Ticker("Precio de la entrada 7\u20AC, donativo a favor de Payasos sin fronteras");
        StringItem stringitem = new StringItem("Lunes, 29 de junio 22:00 h\n", "Fernando Arribas \u201CLa hora m\341gica\u201D (Magia. Duraci\363n: 75 min.).\n \n");
        StringItem stringitem1 = new StringItem("Martes, 30 de junio 22:00 h.\n", "C\355a. Alba Sarraute \u201CMirando a Yukali\u201D (Cabaret y m\341s. Duraci\363n: 60 min.).\n \n");
        StringItem stringitem2 = new StringItem("Mi\351rcoles, 1 de julio 22:00 h.\n", "Luciano Federico \u201CHumor al dente\u201D (Mon\363logo muy gestual. Duraci\363n: 75 min.).\n \n");
        StringItem stringitem3 = new StringItem("Jueves, 2 de julio 22:00 h.\n", "Teatro Indigesto \u201CIndigestion desclowntrolada\u201D (Clown en equipo. Duraci\363n: 70 min.).\n \n");
        StringItem stringitem4 = new StringItem("Viernes, 3 de julio 22:00 h.\n", "La Serda \u201CEl Delirio\u201D (Teatro de risa y absurdo. Duraci\363n: 70 min.).\n \n");
        StringItem stringitem5 = new StringItem("S\341bado, 4 de julio 22:00 h.\n", "Riki L\363pez \u201CBuenrrollitina\u201D (M\372sica de autor. Duraci\363n: 90 min.).\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        form.setTicker(a_javax_microedition_lcdui_Ticker_fld);
        return form;
    }

    public final Form m()
    {
        Form form = new Form("Teatro");
        b = new ImageItem("Teatro\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        a_javax_microedition_lcdui_Ticker_fld = new Ticker("VENTA DE LOCALIDADES: Desde el lunes 25 de mayo de 2009");
        StringItem stringitem = new StringItem("S\341bado 27 y domingo 28 de junio, 20:00\n", "Producciones Faraute, Teatro, \u201CLa cena de los generales\u201D, de Jos\351 Luis Alonso de Santos. Direcci\363n: Miguel Narros. Con Sancho Gracia. Red de Teatros de Castilla y Le\363n..\n \n");
        StringItem stringitem1 = new StringItem("Lunes 29 y martes 30 de junio, 20:00\n", "Anthony Blake, Espect\341culo de magia, \u201CM\341s cerca\u201D.\n \n");
        StringItem stringitem2 = new StringItem("Viernes 3 y s\341bado 4 de julio, 20:00\n", "Compa\361\355a L\355rica Barbieri, Zarzuela, \u201CLa alegr\355a de la huerta\u201D. Director: Pedro Luis Domingo. M\372sica: Federico Chueca. Libreto: Enrique Garc\355a \301lvarez y Antonio Paso.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        form.setTicker(a_javax_microedition_lcdui_Ticker_fld);
        return form;
    }

    public final Form n()
    {
        Form form = new Form("Ferias y Eventos");
        b = new ImageItem("Ferias y Eventos\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Del 10 de jumio al 5 de julio\n", "Esculturas de Sergio Blanco. Sala de Exposiciones del Arco de Sa nta Mar\355a.\n \n");
        StringItem stringitem1 = new StringItem("Del 16 de junio al 12 de julio\n", "La tauromaquia. Grabados. Sala de exposiciones del Monasterio de Sa n Agust\355n.\n \n");
        StringItem stringitem2 = new StringItem("Hasta el 12 de julio\n", "100 a\361os jugando. Colecci\363n de juguetes Quiroga-Monte. Abierta Horario: Martes a domingo de 12:00 a 14:00 y de 18:00 a 21:00 h. Cerrado el 29 de Junio. Sala exposiciones C\355rculo Central. Plaza de Espa\361a n\272 3.\n \n");
        StringItem stringitem3 = new StringItem("Hasta el 26 de julio\n", "Salvador Dal\355. Veinte a\361os despu\351s. Visitas: Lunes a s\341bados de 12:00 a 14:00 y de 19:00 a 21:00 h. Domingos y festivos de 12:00 a 14:00 h. Del 1 al 4 de julio: de 12:00 a 14:00 h. Lunes 29 de junio: cerrado. Cultural Cord\363n \u2013 Sala de Exposiciones de la Casa del Cord\363n.\n \n");
        StringItem stringitem4 = new StringItem("Hasta el 26 de julio\n", "Siglo XXI en la Catedral de Burgos. Voces y signos. Javier P\351rez y Alberto Coraz\363n. Visitas: Lunes a domingo de 11:00 a 14:00 y de 17:00 a 21:00 h. Claustro baj o de la Catedral de Burgos.\n \n");
        StringItem stringitem5 = new StringItem("Hasta el 20 de septiembre\n", "Bridget Baker - Pamen Pereira \u201CThis is a Love Story\u201D - Isacio de la Fuente / Carmen Palomero / Santiago Polo - Gymkhana M\363vil, un proyecto de ANIMATU. Visitas: Martes a viernes de 12:00 a 14:00 y de 17:30 a 20:00 h. Viernes hasta las 21:00 h. S\341bados de 11:30 a 14:30 y 17:30 a 21:00 h. Domingos y festivos de 11:30 a 14:30 h. Del 30 de junio al 4 de julio de 12:00 a 14:00 h.\u201D. Centro de Arte Caja de Burgos. CAB.\n \n");
        StringItem stringitem6 = new StringItem("Del el 26 de junio al 6 de julio\n", "Feria de atracciones. Horario: de 17:30 a 3:30 h. laborables (4:00 h. festivos y v\355speras). D\355a del Ni\361o, 6 julio, de 17:30 a 1:00 h. todas las atracciones mec\341nicas a 1,50 \u20AC. Confluencia de las calles Francisco de Vitoria y Eloy Garc\355a de Quevedo.\n \n");
        StringItem stringitem7 = new StringItem("Del el 26 de junio al 5 de julio\n", "Mercadillo especial fiestas de San Pedro y San Pablo. Productos de confecci\363n, calzados, marroquiner\355a, bisuter\355a y artesan\355a en general. Horario: 11:00 a 3:00. Avenida de Castilla y Le\363n, junto a la Iglesia de Sa n Fernando.\n \n");
        StringItem stringitem8 = new StringItem("Lunes 29 de junio\n", "Feria regional de ganados de San Pedro y San Pablo. Desde las 9:00 a las 14:00. Recinto ferial de La Milanera.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form o()
    {
        Form form = new Form("V Feria de Tapas");
        b = new ImageItem("V Feria de Tapas\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Fecha\n", "Del 26 de Junio al 4 de Julio.\n \n");
        StringItem stringitem1 = new StringItem("Hora\n", "De 12:00 a 01:00 h.\n \n");
        StringItem stringitem2 = new StringItem("Precio\n", "Tapa del concurso + bebida: 2'20\u20AC.\n \n");
        StringItem stringitem3 = new StringItem("Grupos musicales\n", "Amenizar\341n la zona de tapas los siguientes grupos: Dixieman, La Chistera Negra, La Rustic Arlaz\363n Band, Septeto Deboson y Sax \341 fond.\n \n");
        StringItem stringitem4 = new StringItem("M\341s informaci\363n\n", "Puede ver las principales localizaciones de la feria de tapas desde el callejero de esta aplicacion.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form p()
    {
        Form form = new Form("Plaza de Espa\361a");
        b = new ImageItem("Plaza de Espa\361a\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Ca\361as y Tapas\n", "Brocheta del pueblo, Huevos rotos con setas.\n \n");
        StringItem stringitem1 = new StringItem("Braser\355a Ailanthus\n", "Salpic\363n con vinagre de sidra, Torrija de Mozzarela.\n \n");
        StringItem stringitem2 = new StringItem("Casa Regional de Salamanca\n", "Hornazo charro, Langostino ib\351rico.\n \n");
        StringItem stringitem3 = new StringItem("El Callej\363n\n", "Trigueros Ali-oli, Chuleta de cordero.\n \n");
        StringItem stringitem4 = new StringItem("Nuevo Alvi\n", "Hojaldre con crema de morcilla y piquillos, Brocheta de solomillo ib\351rico con verduritas.\n \n");
        StringItem stringitem5 = new StringItem("El B\372ho\n", "Capricho, B\372ho.\n \n");
        StringItem stringitem6 = new StringItem("La Abuela Buela\n", "Gazpacho de mel\363n con rulo de la huerta, Pimiento de cecina en salsa de tomate dulce.\n \n");
        StringItem stringitem7 = new StringItem("Caf\351 Que Thomas\n", "Fresquito de verano, Tosta de gamba al ali-oli gratinada al horno.\n \n");
        StringItem stringitem8 = new StringItem("San Arnaldus\n", "Crema de la huerta con frutos secos, Pincho a la gallega.\n \n");
        StringItem stringitem9 = new StringItem("El Vag\363n del Castillo\n", "Tosta de foie con reducci\363n de Pedro Ximenez, Teque\361o.\n \n");
        StringItem stringitem10 = new StringItem("Mes\363n Los Cantos\n", "Pastel de morcilla y manzana con salsa de foie al oporto, Derretido de chocolate con salsa de frutos rojos.\n \n");
        StringItem stringitem11 = new StringItem("Pasteler\355a Juarre\361o\n", "P-99, Hamburguesa dulce con \u201CKetchup y mostaza\u201D.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        stringitem9.setLayout(1);
        stringitem10.setLayout(1);
        stringitem11.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(stringitem9);
        form.append(stringitem10);
        form.append(stringitem11);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form q()
    {
        Form form = new Form("Plaza de la Libertad");
        b = new ImageItem("Plaza de la Libertad\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("La Abad\315a\n", "Bacalao confitado con salsa de naranja, Brocheta de solomillo ib\351rico.\n \n");
        StringItem stringitem1 = new StringItem("Cibercaf\351 Cabaret\n", "Capricho de huerta y mar, Sombrero del picador.\n \n");
        StringItem stringitem2 = new StringItem("El Polvorilla\n", "Canutillo, El mar.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form r()
    {
        Form form = new Form("Plaza de Roma");
        b = new ImageItem("Plaza de Roma\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Belle \351poque\n", "Tosta de cecina con queso Valde\363n.\n \n");
        StringItem stringitem1 = new StringItem("Jam\363n Jam\363n\n", "Qu\355mica, F\355sica.\n \n");
        StringItem stringitem2 = new StringItem("San Pablo\n", "Montadito de setas y cecina, Churrasco.\n \n");
        StringItem stringitem3 = new StringItem("Jard\355n Lib\351lula\n", "Tosta confitada con jam\363n de pato y frutas del bosque, Hojaldre de setas con jam\363n.\n \n");
        StringItem stringitem4 = new StringItem("Belladonna\n", "Chapata de cecina, Chopitos fritos.\n \n");
        StringItem stringitem5 = new StringItem("\321\n", "Tosta 3 colores, Brocheta de lomo y panceta.\n \n");
        StringItem stringitem6 = new StringItem("El Ambig\372\n", "Tosta encebollada, Solomillo con su escolta.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form s()
    {
        Form form = new Form("Plaza Mayor");
        b = new ImageItem("Plaza Mayor\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("El Kebap de Apu\n", "Nemo, Pincho Kebap de pollo y ternera.\n \n");
        StringItem stringitem1 = new StringItem("Pub Cool\n", "Tosta Cool, Medall\363n Cool.\n \n");
        StringItem stringitem2 = new StringItem("Bar Arandino\n", "Tumbona, Cacharrito volador.\n \n");
        StringItem stringitem3 = new StringItem("La Calabaza\n", "Pulpo de feria, Brocheta de cabecero, alcachofas y boletus.\n \n");
        StringItem stringitem4 = new StringItem("Mes\363n Los Herreros\n", "Tosta de jam\363n con crema de ajo, Pimiento relleno de cecina rebozado en harina de garbanzo con confitura de tomate.\n \n");
        StringItem stringitem5 = new StringItem("Froil\341n\n", "Coct\351l de tomate, bacalao y langostinos con aceite de albahaca, Tosta de solomillo iberico, escalibada de soja y guarnici\363n de lechuga.\n \n");
        StringItem stringitem6 = new StringItem("La Caba\361a Arandina\n", "Serranito, Vulcano.\n \n");
        StringItem stringitem7 = new StringItem("Rimbomb\355n\n", "Yogur sito, Cham champi.\n \n");
        StringItem stringitem8 = new StringItem("The Book\n", "Bacalao Ajorriero, Carrillera al vino tinto.\n \n");
        StringItem stringitem9 = new StringItem("Bar Trol\n", "Una caricia, Un besito.\n \n");
        StringItem stringitem10 = new StringItem("Taper\355a Royal\n", "Sardinilla fina sobre rueda de pl\341tano verde, rulo de cabra y tomate deshidratado con su vinagreta de coco y granada, Morcilla desestructurada con huevos rotos, crujientes de jam\363n y crema de tomate y albahaca.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        stringitem8.setLayout(1);
        stringitem9.setLayout(1);
        stringitem10.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(stringitem8);
        form.append(stringitem9);
        form.append(stringitem10);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form t()
    {
        Form form = new Form("Plaza de Alonso Mart\355nez");
        b = new ImageItem("Plaza de Alonso Mart\355nez\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Las Veguillas\n", "Barqueta de setas, Churrasco.\n \n");
        StringItem stringitem1 = new StringItem("Vinoteca Cord\363n\n", "Nido de mar, Pecadito de pollo.\n \n");
        StringItem stringitem2 = new StringItem("El Rinc\363n del Vino\n", "Alpargata de cecina con aceites arom\341ticos, Suprema empanada de bonito.\n \n");
        StringItem stringitem3 = new StringItem("Cervecer\355a Plaza Santiago\n", "Tosta de salm\363n, Solomillo de cerdo.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form u()
    {
        Form form = new Form("Plaza de Santo Domingo");
        b = new ImageItem("Plaza de Santo Domingo\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Bariloche\n", "Salpic\363n de pulpo, Pato a la ciruela.\n \n");
        StringItem stringitem1 = new StringItem("Twenty Huerto 20\n", "Cocktail, Choco.\n \n");
        StringItem stringitem2 = new StringItem("El que faltaba\n", "Reducci\363n de bals\341mico y arandanos sobre queso de cabra, Brocheta de marisco y pescado.\n \n");
        StringItem stringitem3 = new StringItem("Las Vegas\n", "Ensalada de brotes del bosque, pellizcos de jam\363n, gulas y aceite de hierbabuena, Queso de cabra con funda de bacon, pimientos y crujiente de fresas.\n \n");
        StringItem stringitem4 = new StringItem("Mes\363n del Cid\n", "Ensalada de bacalao, Caramelo de morcilla.\n \n");
        StringItem stringitem5 = new StringItem("La Revoltosa\n", "Pitos, Flautas.\n \n");
        StringItem stringitem6 = new StringItem("El Pecado\n", "Bomb\363n de foie, Delicias de langostinos.\n \n");
        StringItem stringitem7 = new StringItem("Oasis\n", "Crema dulce de queso, Crep de bacalao.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        stringitem6.setLayout(1);
        stringitem7.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(stringitem6);
        form.append(stringitem7);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form v()
    {
        Form form = new Form("Calle del General Santocildes");
        b = new ImageItem("Calle del General Santocildes\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Restaurante Abadius\n", "Canutillo de salm\363n, Croqueta atigrada.\n \n");
        StringItem stringitem1 = new StringItem("Cafeter\355a Elba\n", "Ensaladito, Elbito.\n \n");
        StringItem stringitem2 = new StringItem("Ojalata\n", "Tosta azul y verde con anchoas, Pincho moruno con verduras.\n \n");
        StringItem stringitem3 = new StringItem("Buddha\n", "Tosta de buey con muselina de ajo, Brocheta de chistorra.\n \n");
        StringItem stringitem4 = new StringItem("The Boss\n", "Gigantillo, Gigantilla.\n \n");
        StringItem stringitem5 = new StringItem("Blue Gallery\n", "Sopa de guisantes y naranja en texturas, Evoluci\363n San lesmes 2008.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        stringitem2.setLayout(1);
        stringitem3.setLayout(1);
        stringitem4.setLayout(1);
        stringitem5.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(stringitem3);
        form.append(stringitem4);
        form.append(stringitem5);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form w()
    {
        Form form = new Form("Frente a su establecimiento");
        b = new ImageItem("Frente a su establecimiento\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem;
        (stringitem = new StringItem("El 24 de la Paloma\n", "Esp\341rragos y pistacho, Langostino y su suquet.\n \n")).setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    private static Image a(String s1)
    {
        Image image = null;
        try {
            image = Image.createImage(s1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return image;
    }

    private ImageItem a_javax_microedition_lcdui_ImageItem_fld;
    private ImageItem b;
    private Ticker a_javax_microedition_lcdui_Ticker_fld;
    private String a_java_lang_String_fld;
}
