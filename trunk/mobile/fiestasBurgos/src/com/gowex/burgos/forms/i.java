package com.gowex.burgos.forms;

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;
import javax.microedition.lcdui.*;
import com.gowex.burgos.principal.Control;

public final class i
{

    public i()
    {
        a_javax_microedition_lcdui_ImageItem_fld = null;
        b = null;
        a_java_lang_String_fld = "/res/" + Control.pantallaAncho + "/";
    }

    public final Form a()
    {
        Form form = new Form("Bienvenidos");
        b = new ImageItem("Bienvenidos\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Saludo del Alcalde:\n", "Cuando los heraldos anuncian ya la voz del pregonero que nos dar\341 noticia del comienzo de los Sampedros-2009, los burgaleses nos despedimos por unos d\355as de la calma y el silencio para romper, tras el estallido del cohete anunciador, en una suerte de algarab\355a que llena todos los rincones de nuestra geograf\355a urbana.\n \n");
        StringItem stringitem1 = new StringItem("", "De improviso irrumpir\341n en nuestras calles las agrupaciones de fajas y blusas de las pe\361as y casas regionales, que han estado preparando su puesta en escena durante todo el a\361o, para derrochar alegr\355a y buen humor entre sus convecinos y entre los que, procedentes de otros lugares, llegan a Burgos a compartir una semana para la que el Ayuntamiento se ha empleado a fondo con una programaci\363n pensada para animar y distraer a personas de toda edad.\n \n");
        StringItem stringitem2 = new StringItem("", "Nuestras fiestas son tambi\351n momento para el reencuentro con cuantos paisanos residen fuera de Burgos y aprovechan estos d\355as para visitarnos y convivir con amigos y familiares. Para todos ellos la ciudad se viste de luces, se ci\361e sus mejores galas y se proclama abierta, generosa y fraternal en se\361al de afecto y bienvenida.\n \n");
        StringItem stringitem3 = new StringItem("", "Cuando este bullicio inunda las calles es un buen momento para integrarnos en torno a nuestro devenir y las se\361as de identidad que nos son comunes, enorgulleci\351ndonos de una trayectoria hist\363rica \372nica que resulta clave para entender el futuro m\341s pr\363ximo. Si los burgaleses unidos fueron capaces de afrontar empresas formidables en el pasado, nadie debe dudar de que sus descendientes sabr\341n estar a la altura en toda circunstancia y ante cualquier reto. Tan solo es precisa la uni\363n,el acuerdo y unas relaciones sociales basadas en el di\341logo, la comprensi\363n y el respeto.\n \n");
        StringItem stringitem4 = new StringItem("", "Viene todo ello a prop\363sito de uno de los objetivos m\341s ambiciosos que nos hemos planteado en los \372ltimos a\361os. La consecuci\363n para Burgos de la Capitalidad Cultural Europea en el a\361o 2016. Con este objeto, muchos burgaleses han iniciado ya el camino en una empresa com\372n que puede significar un fuerte impulso para nuestra proyecci\363n exterior. En este empe\361o debemos participar todos, cada cual en la medida que le sea posible, para presentar un proyecto mod\351lico y ejemplar.\n \n");
        StringItem stringitem5 = new StringItem("", "Al ir viviendo este a\361o los diferentes actos de este programa de fiestas debemos demostrar que estamos preparados para recibir esa importante nominaci\363n.\n \n");
        StringItem stringitem6 = new StringItem("", "\241Felices Sampedros a todos! \241Viva Burgos!.\n \n");
        StringItem stringitem7 = new StringItem("", "Juan Carlos Aparicio P\351rez, Alcalde de Burgos.\n \n");
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

    public final Form b()
    {
        Form form = new Form("Viernes 26, ma\361ana");
        b = new ImageItem("Viernes 26, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("10:00\n", "Deporte. Campeonato de Espa\361a de trampol\355n y sincronismo. Polideportivo Talamillo. Organiza: Club Gimnasia Burgos.\n \n");
        StringItem stringitem1 = new StringItem("11:00\n", "Deporte. Concurso h\355pico nacional. Pruebas 1 y 2. Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e.\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form c()
    {
        Form form = new Form("Viernes 26, tarde");
        b = new ImageItem("Viernes 26, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("16:00\n", "Deporte. Concurso h\355pico nacional. Pruebas 3 y 4. Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e. Patrocinan: Azor\355n e Inmobiliaria Mel\363n.\n \n");
        StringItem stringitem1 = new StringItem("17:00\n", "Deporte. Torneo de baloncesto \u201C3x3 disfruta del basket\u201D. parque de Lord Baden Powell.\n \n");
        StringItem stringitem2 = new StringItem("19:00\n", "Ferias. Apertura oficial de la feria de atracciones. Confluencia de las call es Francisco de Vitoria y Eloy Ga rc\355a de Quevedo.\n \n");
        StringItem stringitem3 = new StringItem("20:00\n", "M\372sica . Concierto de inauguraci\363n de las fiestas. Banda Ciudad de Burgos. Plaza Mayor.\n \n");
        StringItem stringitem4 = new StringItem("20:30\n", "Teatro de paso. Turukutup\341 (\301lava). \u201CRezicletas\u201D, concierto itinerante. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem5 = new StringItem("20:30\n", "Teatro de paso. Cie. Les hommes poissons (Francia). \u201CProtecci\363n de proximidad de las plantas\u201D. Paseo del Espol\363n, itinerante.\n \n");
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

    public final Form d()
    {
        Form form = new Form("Viernes 26, noche");
        b = new ImageItem("Viernes 26, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:00\n", "Ferias. Apertura oficial de la feria de tapas.\n \n");
        StringItem stringitem1 = new StringItem("21:00\n", "Inauguraci\363n de fiestas. Preg\363n, proclamaci\363n de reinas e interpretaci\363n del himno a Burgos, a cargo de la Federaci\363n de corales y la Banda ciudad de Burgos. Bailes de gigantones, gigantillos y danzantes. Plaza Mayor.\n \n");
        StringItem stringitem2 = new StringItem("21:30\n", "Plazas con m\372sica . Diego Galaz y Carlos Beceiro. \u201CBailes vespertinos\u201D. Paseo del Espol\363n, templete.\n \n");
        StringItem stringitem3 = new StringItem("21:30\n", "Plazas con m\372sica . Gladis Mercado y sus Charros. M\351jico en estado puro. Mariachi. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem4 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 1\252 sesi\363n. Pirotecnia Caballer Fx & Service, de Valencia. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem5 = new StringItem("00:00\n", "Plazas con m\372sica . V Muestra Espiral Sonora de m\372sica electr\363nica. Goiko, Domi & Supraelokuen. Hip hop. Llana de Afuera.\n \n");
        StringItem stringitem6 = new StringItem("00:15\n", "Concierto. Carlos Baute. Aparca miento del centro comercial Camino de la Plata.\n \n");
        StringItem stringitem7 = new StringItem("01:00\n", "plazas con m\372sica . V Muestra Espiral Sonora de m\372sica electr\363nica. 01:00 h. Adenocrom. Rock electr\363nico. 02:00 h. Homeless. Dub-step. Llana de Afuera.\n \n");
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

    public final Form e()
    {
        Form form = new Form("S\341bado 27, ma\361ana");
        b = new ImageItem("S\341bado 27, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("09:00\n", "Deporte. I Congreso nacional de artes marciales. Polideportivo de San Amaro. Organiza: Club \311lite.\n \n");
        StringItem stringitem1 = new StringItem("10:00\n", "Deporte. Campeonato Espa\361a de trampol\355n y sincronismo. Polideportivo Talamillo. Organiza: Club Gimnasia Burgos.\n \n");
        StringItem stringitem2 = new StringItem("10:00\n", "Canto de las auroras. Plaza de Santiago. Organiza: Hogar Navarro de Burgos.\n \n");
        StringItem stringitem3 = new StringItem("10:00\n", "Deporte. Concurso individual de bolo-palma. Bolera El Plant\355o, calle Villafranca . Organiza: Centro Regional Monta\361\351s.\n \n");
        StringItem stringitem4 = new StringItem("10:00\n", "Deporte. Concurso pasabolo tabl\363n la cascajera. Complejo Boleras (Pistas del Silo). Organiza: Club de Bolera Pasabolo.\n \n");
        StringItem stringitem5 = new StringItem("11:00\n", "Canto de las auroras. Plaza de Vadillos. Organiza: Hogar Navarro de Burgos.\n \n");
        StringItem stringitem6 = new StringItem("11:00\n", "Deporte. Concurso h\355pico nacional. Pruebas 5 y 6. Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e.\n \n");
        StringItem stringitem7 = new StringItem("11:00\n", "I Concurso de cohetes propulsados por aire y agua. Una manera pr\341ctica y divertida de descubrir las aplicaciones pr\341cticas de leyes de la f\355sica. Cerro de San Miguel. Organiza: Asociaci\363n Astron\363mica de Burgos. Colabora: Aula de Medio Ambiente de Caja de Burgos.\n \n");
        StringItem stringitem8 = new StringItem("11:00\n", "Exposici\363n itinerante. 100 a\361os de Caja C\355rculo. Juegos: De 11:00 a 12:30 y de 13:00 a 14:00 h. De 17:30 a 19:00 y de 19:30 a 21:00 h. Fot\363grafo de \351poca: De 11:00 a 12:30 y de 13:00 a 14:00 h. De 17:30 a 19:00 y de 19:30 a 21:00 h. T\355teres: 12:30 y 18:30 h. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Organiza: Caja C\355rculo.\n \n");
        StringItem stringitem9 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de Sa n Agust\355n. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem10 = new StringItem("11:30\n", "Canto de las auroras. Plaza del Rey Sa n Fernando. Organiza: Hogar Navarro de Burgos.\n \n");
        StringItem stringitem11 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. Inauguraci\363n. Juegos, circo, talleres, cuentos. Todo un parque de diversiones con Mero el Jardinero, la Cigarra Macarra y su amiga la abeja Zum Zum. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem12 = new StringItem("12:00\n", "Canto de las auroras. Plaza Mayor. Organiza: Hogar Navarro de Burgos.\n \n");
        StringItem stringitem13 = new StringItem("12:00\n", "Pasacalles de danzantes, 28 gigantillos y gigantones. Paseo del Espol\363n.\n \n");
        StringItem stringitem14 = new StringItem("13:30\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
        StringItem stringitem15 = new StringItem("14:00\n", "Interpretaci\363n popular del Himno a Burgos. A cargo de la Federaci\363n de corales y la Banda ciudad de Burgos. Paseo del Espol\363n, frente al Arco de Santa Mar\355a.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form f()
    {
        Form form = new Form("S\341bado 27, tarde");
        b = new ImageItem("S\341bado 27, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("16:00\n", "Deporte. Concurso h\355pico nacional. Pruebas 7 y 8. Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e. Patrocinan: Joyer\355a Perodri y Fausto Motor.\n \n");
        StringItem stringitem1 = new StringItem("17:00\n", "Deporte. Interclubes de halterofilia fiestas de San Pedro. Polideportivo El Plant\355o. Organiza: Club de Halterofilia Sol y Luz.\n \n");
        StringItem stringitem2 = new StringItem("17:00\n", "Deporte. XXV Trofeo de automodelismo San Pedro y San Pablo. Paseo de Regino Sainz de la Maza. Organiza: Club de Modelismo Castilla.\n \n");
        StringItem stringitem3 = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de Sa n Agust\355n. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem4 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem5 = new StringItem("18:00\n", "Deporte. VIII Exhibici\363n de lucha grecorromana y libre ol\355mpica. Polideportivo San Pedro y San Felices. Organiza: Asociaci\363n Burgalesa de Luchas Ol\355mpicas.\n \n");
        StringItem stringitem6 = new StringItem("18:30\n", "Feria Taurina. El bombero torero. Fuera de abono. Plaza de Toros.\n \n");
        StringItem stringitem7 = new StringItem("19:00\n", "Teatro de paso. Cie. Les hommes poissons (Francia). \u201CProtecci\363n de proximidad de las plantas\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem8 = new StringItem("19:30\n", "Teatro de paso. Teatro Salitre (Vizcaya). \u201COn egin mon amour\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Calles de fiesta. Las Pituister (Burgos). \u201CVamos que nos vamos\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Teatro. Producciones Faraute. \u201CLa cena de los generales\u201D, de Jos\351 Luis Alonso de Santos. Direcci\363n: Miguel Narros. Con Sancho Gracia. Teatro Principal. Tarifa A-5. Red de Teatros de Castilla y Le\363n.\n \n");
        StringItem stringitem11 = new StringItem("20:00\n", "Teatro de paso. Cie. Les hommes poissons (Francia). \u201CProtecci\363n de proximidad de las plantas\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Circo. Movimiento armario (Uruguay). \u201CFalsa escuadra\u201D. Plaza Mayor.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form g()
    {
        Form form = new Form("S\341bado 27, noche");
        b = new ImageItem("S\341bado 27, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("22:00\n", "Plazas con m\372sica. Adrenalina 33. Uno de los grupos m\341s j\363venes y prometedores del panorama musical burgal\351s que aunan rock, pop y punk. Llana de Afuera.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "Plazas con m\372sica . Sundayers. Pura fusi\363n: reggae, rock, jazz, funk, latin\u2026 Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem2 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 2\252 sesi\363n. Pirotecnia Vulcano, de Madrid. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem3 = new StringItem("00:00\n", "Plazas con m\372sica . Triplet. Desde Portugal llega un rock contempor\341neo con dosis de punk mel\363dico y metal. Llana de Afuera.\n \n");
        StringItem stringitem4 = new StringItem("00:15\n", "Concierto. El Sue\361o de Morfeo. Aparca miento del centro comercial Camino de la Plata.\n \n");
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

    public final Form h()
    {
        Form form = new Form("Domingo 28, ma\361ana");
        b = new ImageItem("Domingo 28, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("08:00\n", "Deporte. XXVI Concurso exposici\363n monogr\341fico del perro perdiguero. Prueba de belleza. Trofeo Manuel Izquierdo y Trofeo especial Camada. Paseo del Empecinado. Organiza: Club Espa\361ol de Amigos del Perro Perdiguero de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("09:00\n", "Deporte. Campeonato de Castilla y Le\363n de motocross. Circuito municipal de San Isidro. Organiza: Real Motoclub Burgal\351s.\n \n");
        StringItem stringitem2 = new StringItem("10:00\n", "Deporte. Campeonato Espa\361a trampol\355n y sincronismo. Polideportivo Talamillo. Organiza: Club Gimnasia Burgos.\n \n");
        StringItem stringitem3 = new StringItem("10:00\n", "Deporte. XI Trofeo Alfoz de Burgos de tiro con arco. Campo de rugby san Amaro. Organiza: Club Arco Cid.\n \n");
        StringItem stringitem4 = new StringItem("11:00\n", "Exposici\363n itinerante. 100 a\361os de Caja C\355rculo. Juegos: De 11:00 a 12:30 y de 13:00 a 14:00 h. Fot\363grafo de \351poca: De 11:00 a 12:30 y de 13:00 a 14:00 h. De 17:30 a 20:00 h. T\355teres: 12:30 y 18:30 h. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Organiza: Caja C\355rculo.\n \n");
        StringItem stringitem5 = new StringItem("11:00\n", "Deporte. Concurso h\355pico nacional. Caballos j\363venes. Pruebas 9 y 10. Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e.\n \n");
        StringItem stringitem6 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de los Poetas. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem7 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. All\355 te esperan Mero y sus amigos para pasartelo en grande. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem8 = new StringItem("12:00\n", "Cabalgata. Con la participaci\363n de gigantillos, danzantes, casas regionales, pe\361as, asociaciones culturales, carrozas, grupos folcl\363ricos y grupos de animaci\363n. Recorrido: Avda. de Eladio Perlado, calle Vitoria y plaza de Mio Cid.\n \n");
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

    public final Form i()
    {
        Form form = new Form("Domingo 28, tarde");
        b = new ImageItem("Domingo 28, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("16:00\n", "Deporte. Concurso h\355pico nacional. Puebas 11 y 12 (gran premio). Ciudad deportiva militar. Entrada libre. Organiza: Ciudad Deportiva Militar General Yag\374e. Patrocina: Ayuntamiento de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de los Poetas. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem2 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem3 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (1\252 de abono). Toros de Cuadri para Juan Jos\351 Padilla, Salvador Cort\351s y Luis Bolivar. Plaza de Toros.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Teatro de paso. Tiritirantes (Burgos). \u201CEscuela de vuelo\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem5 = new StringItem("20:00\n", "Teatro Familiar. Insomnio Teatro (Burgos). \u201CAta-pu\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem6 = new StringItem("20:00\n", "Teatro. Producciones Faraute. \u201CLa cena de los generales\u201D, de Jos\351 Luis Alonso de Santos. Direcci\363n: Miguel Narros. Con Sancho Gracia. Teatro Principal. Tarifa A-5. Red de Teatros de Castilla y Le\363n.\n \n");
        StringItem stringitem7 = new StringItem("20:15\n", "Teatro de paso. El Sidral (L\351rida). \u201CLos farsantes\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem8 = new StringItem("20:30\n", "Circo. Tr\355o Zindare (Francia). \u201CLa vuelta\u201D. Plaza Mayor.\n \n");
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

    public final Form j()
    {
        Form form = new Form("Domingo 28, noche");
        b = new ImageItem("Domingo 28, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("22:00\n", "Plazas con m\372sica . Mares. La juventud y frescura del panorama pop-rock nacional. Llana de Afuera.\n \n");
        StringItem stringitem1 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 3\252 sesi\363n. Pirotecnia Zaragozana, de Zaragoza. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem2 = new StringItem("00:00\n", "Plazas con m\372sica. Mistweaver. Deathmetal, ganador de la 2\252 Semana m\372sica joven en Burgos. Llana de Afuera.\n \n");
        StringItem stringitem3 = new StringItem("00:00\n", "Plazas con m\372sica. The Soulutions. \u201CClassic soul band\u201D. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem4 = new StringItem("00:15\n", "Concierto. Loquillo. Aparca miento del centro comercial Camino de la Plata.\n \n");
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

    public final Form k()
    {
        Form form = new Form("Lunes 29, Ma\361ana");
        b = new ImageItem("Lunes 29, Ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("09:00\n", "Ferias. Feria regional de ganados de San Pedro y San Pablo. Hasta las 14:00 horas. Recinto ferial de La Milanera.\n \n");
        StringItem stringitem1 = new StringItem("10:00\n", "Deporte. Tirada fiestas de San Pedro y San Pablo. Campo municipal de tiro El Cerro. Organiza: Federaci\363n Castellano-Leonesa de Tiro Ol\355mpico.\n \n");
        StringItem stringitem2 = new StringItem("10:30\n", "Solemne misa pontifical. con la intervenci\363n del Orfe\363n Burgal\351s. Santa Iglesia Catedral.\n \n");
        StringItem stringitem3 = new StringItem("11:00\n", "Exposici\363n itinerante. 100 a\361os de Caja C\355rculo. Juegos: De 11:00 a 12:30 y de 13:00 a 14:00 h. De 17:30 a 19:00 y de 19:30 a 21:00 h. Fot\363grafo de \351poca: De 11:00 a 12:30 y de 13:00 a 14:00 h. De 17:30 a 19:00 y de 19:30 a 21:00 h. T\355teres: 12:30 y 18:30 h. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Organiza: Caja C\355rculo.\n \n");
        StringItem stringitem4 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de la Isla. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem5 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. Pinta, juega, corre, rie y salta con la Cigarra Macarra. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem6 = new StringItem("12:00\n", "Traslado en andas de Santa Mar\355a la Mayor. Desde la Catedral hasta la plaza del Rey Sa n Fernando.\n \n");
        StringItem stringitem7 = new StringItem("12:00\n", "Ofrenda de flores a Santa Mar\355a la Mayor. Tradicional comitiva popular. Interviene la Schola Cantorum. Sal ida desde la calle de San Lesmes hacia la plaza del Rey San Fernando.\n \n");
        StringItem stringitem8 = new StringItem("13:00\n", "Pensado para los peques. La plaza de la magia. Kayto (Madrid). Plaza de la Libertad.\n \n");
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

    public final Form l()
    {
        Form form = new Form("Lunes 29, tarde");
        b = new ImageItem("Lunes 29, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan Ocio y Tiempo Libre. Juegos infantiles en tu barrio. Parque de la Isla. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (2\252 de abono). Toros de Zalduendo para Enrique Ponce, Miguel \301ngel Perera y Morenito de Aranda. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Fernando Arribas (Valladolid) y Miguel \301ngel Gea (Madrid). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Pensado para los peques. La Plaza de la magia. Kayto (Madrid). Plaza de la Libertad.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Semana m\341gica . Close up con San Miguel. Fernando Arribas (Valladolid) y Miguel \301ngel Gea (Madrid). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem6 = new StringItem("19:30\n", "Circo. Happy Stars (Francia). \u201CFlying brothers\u201D. Plaza Mayor.\n \n");
        StringItem stringitem7 = new StringItem("20:00\n", "Espect\341culo de magia. Anthony Blake. \u201CM\341s cerca\u201D. Teatro Principal. Tarifa A-5.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Teatro de paso. Miguelillo (Salamanca). \u201CD\363nde estar\341 mi carrum\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Teatro Familiar. Ronco Teatro (Burgos). \u201CLa cabriola de la dragona\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Fernando Arribas (Valladolid) y Miguel \301ngel Gea (Madrid). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem11 = new StringItem("20:15\n", "Teatro de paso. Cie. d\264ailleurs (Francia). \u201CLos alquimistas\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Fernando Arribas (Valladolid) y Miguel \301ngel Gea (Madrid). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form m()
    {
        Form form = new Form("Lunes 29, noche");
        b = new ImageItem("Lunes 29, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:00\n", "Teatro de paso. Miguelillo (Salamanca). \u201CD\363nde estar\341 mi carrum\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem1 = new StringItem("21:15\n", "Circo. Happy Stars (Francia). \u201CFlying brothers\u201D. Plaza Mayor.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "1\252 Noche de humor con San Miguel. Fernando Arribas. Magia de autor. caf\351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem3 = new StringItem("22:00\n", "Plazas con m\372sica . El Ment\363n de Fogarty. Pop mel\363dico y contundente, un sonido genuino, con toques retro. Llana de Afuera.\n \n");
        StringItem stringitem4 = new StringItem("22:30\n", "Concierto. Raphael. Aparca miento del centro comercial Camino de la Plata. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem5 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 4\252 sesi\363n. Pirotecnia Toste, de Islas Canarias. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem6 = new StringItem("00:00\n", "Plazas con m\372sica . La Familia Funkster. Funky en estado puro. Plaza de la Virgen del Manzano.\n \n");
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

    public final Form n()
    {
        Form form = new Form("Martes 30, ma\361ana");
        b = new ImageItem("Martes 30, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("11:00\n", "Soli Juegos Caja de Burgos. Un viaje, en busca de la solidaridad a trav\351s de juegos tradicionales de los 5 continentes. Hasta las 13:00 horas. Paseo del Espol\363n. Organiza: Foro Solidario de Caja de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem2 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. Cuentacuentos, alfarer\355a, camas de bolas, peces de colores y la caseta de Mero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem3 = new StringItem("12:00\n", "Pasacalles de danzantes, gigantillos y gigantones. Calles del centro hist\363rico.\n \n");
        StringItem stringitem4 = new StringItem("13:00\n", "Pensado para los peques. La Plaza de la magia. Carlos Adriano (Argentina). Plaza de la Libertad.\n \n");
        StringItem stringitem5 = new StringItem("13:00\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
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

    public final Form o()
    {
        Form form = new Form("Martes 30, tarde");
        b = new ImageItem("Martes 30, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (3\252 de abono). Toros de M\252 Jos\351 Barral para Manuel D\355az \u201CEl Cordob\351s\u201D, Francisco Rivera y \u201CEl Fandi\u201D. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Carlini (Valladolid) y I\361aki Zabaleta (Argentina). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Teatro de paso. Cie. d\u2019ailleurs (Francia). \u201CUn hombre y una mujer\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Pensado para los peques. La plaza de la magia. Carlos Adriano (Argentina). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("19:30\n", "Semana m\341gica . Close up con San Miguel. Carlini (Valladolid) e I\361aki Zabaleta (Argentina). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem7 = new StringItem("20:00\n", "Bailes de siempre. Orquesta banda del Arlanz\363n. Paseo de Regino Sainz de la Maza.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Espect\341culo de magia. Anthony Blake. \u201CM\341s cerca\u201D. Teatro Principal. Tarifa A-5.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Teatro Familiar. Los Kikolas (Burgos). \u201CDr. Ficante\u201D. Paseo del Espol\363n, Cuatro Reyes.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Carlini (Valladolid) e I\361aki Zabaleta (Argentina). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem11 = new StringItem("20:15\n", "Teatro de paso. Vagalume Teatro (Granada). \u201CA cuadros\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Plazas con m\372sica. Mariano Mangas. Concierto flamenco. Calle Valent\355n Palencia (junto al CAB).\n \n");
        StringItem stringitem13 = new StringItem("20:30\n", "Circo. Mumusic Circus (Barcelona). \u201CMerci bien\u201D. Plaza Mayor.\n \n");
        StringItem stringitem14 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Carlini (Valladolid) e I\361aki Zabaleta (Argentina). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form p()
    {
        Form form = new Form("Martes 30, noche");
        b = new ImageItem("Martes 30, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:00\n", "Teatro de paso. Cie. d\u2019ailleurs (Francia). \u201CUn hombre y una mujer\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "2\252 Noche de humor con San Miguel. Alba Sarraute. \u201CMirando a Yucali\u201D. Cabaret. caf\351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "Plazas con m\372sica . Sangre de Tango Show. Pasi\363n argentina. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem3 = new StringItem("23:30\n", "Fuegos artificiales. Exhibici\363n de fuegos artificiales. Pirotecnia Pablo, de Asturias. campa del silo.\n \n");
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

    public final Form q()
    {
        Form form = new Form("Mi\351rcoles 1, ma\361ana");
        b = new ImageItem("Mi\351rcoles 1, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("11:00\n", "Dibuja la vida que te rodea. Concurso infantil de dibujo y pintura. Cuatro categor\355as: de 6 a 13 a\361os. Inscripciones de 11.00 a 12.30 h. Parque del Dr. F\351lix Rodr\355guez de la Fuente. Organiza: Aula de Medio Ambiente Caja de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("11:00\n", "Los juegos de Hilario el Solidario. Taller de pintura. Hasta las 13.00 h. Dirigido a ni\361os entre 4 y 10 a\361os. Paseo del Espol\363n. Organiza: Amycos ONG para la Cooperaci\363n Solidaria.\n \n");
        StringItem stringitem2 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de la Luz (Barrio de Vista Alegre). Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem3 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. Animales gigantes, \341rboles de colores, una casa encantada. \241La magia de los cuentos! Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem4 = new StringItem("12:00\n", "Pasacalles de danzantes, gigantillos y gigantones. Calles del centro hist\363rico.\n \n");
        StringItem stringitem5 = new StringItem("13:00\n", "Pensado para los peques. La plaza de la magia. Diego Calavia (La Rioja). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("13:00\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
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

    public final Form r()
    {
        Form form = new Form("Mi\351rcoles 1, tarde");
        b = new ImageItem("Mi\351rcoles 1, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de la Luz (Barrio de Vista Alegre). Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (4\252 de abono). Toros de Gerardo Ortega para El Cid, Sebasti\341n Castella y Miguel \301ngel Perera. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Truquini (Burgos) y Woody Arag\363n (Toledo). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Pensado para los peques. La Plaza de la magia. Diego Calavia (La Rioja). Plaza de la Libertad.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Semana m\341gica . Close up con San Miguel. Truquini (Burgos) y Woody Aragon (Toledo). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem6 = new StringItem("20:00\n", "Bailes de siempre. Mila y Tarlat\341n. Paseo de Regino Sainz de la Maza.\n \n");
        StringItem stringitem7 = new StringItem("20:00\n", "Teatro Familiar. El Gran Rufus(Valladolid). \u201CNo hay tiempo que perder\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Truquini (Burgos) y Woody Arag\363n (Toledo). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem9 = new StringItem("20:15\n", "Teatro de paso. Cia. de teatro El Carromato (C\341diz). \u201CBufonadas\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem10 = new StringItem("20:30\n", "Circo. Circo Delirio (Argentina-Uruguay-Brasil). \u201CCabaret de Mercosur\u201D. Plaza Mayor.\n \n");
        StringItem stringitem11 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Truquini (Burgos) y Woody Arag\363n (Toledo). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Plazas con m\372sica . Los Gatos Bizcos. M\372sica afroamericana con estilo propio: blues, swing, jazz, rock & roll. Calle Valent\355n Palencia (junto al CAB).\n \n");
        StringItem stringitem13 = new StringItem("20:45\n", "Teatro de paso. Teatro Primigenio (C\363rdoba). \u201CMisi\363n primitiva\u201D. Paseo del Espol\363n, itinerante.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form s()
    {
        Form form = new Form("Mi\351rcoles 1, noche");
        b = new ImageItem("Mi\351rcoles 1, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("22:00\n", "3\252 Noche de humor con San Miguel. Luciano Federico. \u201CHumor al dente\u201D. Mon\363logo muy gestual. caf \351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "Conciertos. Noche de rock joven: Cronometrobud\372 + Honoris Causa + Ka\363tico. Aparca miento del centro comercial Camino de la Plata.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "Plazas con m\372sica . Septeto Deboson. Sones cubanos. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem3 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 5\272 sesi\363n. Pirotecnia Reiriz de Asturias. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
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

    public final Form t()
    {
        Form form = new Form("Jueves 2, ma\361ana");
        b = new ImageItem("Jueves 2, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("11:00\n", "Dibuja la vida que te rodea. Concurso infantil de dibujo y pintura. Cuatro categor\355as hasta 13 a\361os. Inscripciones de 11:00 a 12:30 h. Puente de Santa Mar\355a - Paseo del Espol\363n. Organiza: Aula de Medio Ambiente Caja de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("11:00\n", "Los juegos de Hilario el Solidario. Juegos cooperativos y cuentacuentos. Dirigido a ni\361os entre 4 y 10 a\361os. Hasta las 13.00 h. Paseo del Espol\363n. Organiza: Amycos ONG para la Cooperaci\363n Solidaria.\n \n");
        StringItem stringitem2 = new StringItem("11:30\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de la Quinta, bajo la autov\355a. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem3 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. El circo magn\355fico es ideal para aprender malabares. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem4 = new StringItem("12:00\n", "Pasacalles de danzantes, gigantillos y gigantones. Calles del centro hist\363rico.\n \n");
        StringItem stringitem5 = new StringItem("13:00\n", "Pensado para los peques. La plaza de la magia. Lossar (Burgos). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("13:00\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
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

    public final Form u()
    {
        Form form = new Form("Jueves 2, tarde");
        b = new ImageItem("Jueves 2, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("18:00\n", "Pensado para los peques. A jugar a la calle. Alojan ocio y tiempo libre. Juegos infantiles en tu barrio. Parque de la Quinta, bajo la autov\355a. Patrocina: Fundaci\363n Eroski.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (5\252 de abono). Toros de Ba\361uelos para Juli\341n L\363pez \u201CEl Juli\u201D, Jos\351 Mari Manzanares y Cayetano. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Quique (Valladolid) y Romondi (Valladolid). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Circo. Fundaci\363n Chiminigagua (Colombia). \u201CRituales de lo primitivo a lo moderno\u201D. Plaza Mayor.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Pensado para los peques. La Plaza de la magia. Lossar (Burgos). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("19:30\n", "Semana m\341gica . Close up con San Miguel. Quique (Valladolid) y Romondi (Valladolid). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem7 = new StringItem("20:00\n", "Bailes de siempre. Mila y Tarlat\341n. Paseo de Regino Sainz de la Maza.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Teatro Familiar. Circoactivo (Madrid). \u201CAire\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Quique (Valladolid) y Romondi (Valladolid). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Zona Fitness. Con Jessica y Jos\351 Exp\363sito, creadores del m\351todo y concepto Batuka. Dos horas de mezcla de salud, diversi\363n, baile, deporte, m\372sica, ritmo y energ\355a para toda la familia, con ejercicios para todas las edades. Plaza de la Virgen del Manzano. Organiza y patrocina: Cope Burgos.\n \n");
        StringItem stringitem11 = new StringItem("20:15\n", "Teatro de paso. Cia. de teatro El Carromato (C\341diz). \u201CEl carrom\341giko\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Conciertos. Festival Indie: Entertainiment + El Columpio Asesino + Vinodelf\355n + Sidonie. Aparca miento del centro comercial Camino de la Plata.\n \n");
        StringItem stringitem13 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Quique (Valladolid) y Romondi (Valladolid). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem14 = new StringItem("20:30\n", "Plazas con m\372sica . Tuco y los Definitivos. Un cl\341sico incombustible del rock burgal\351s. Calle Valent\355n Palencia (junto al CAB).\n \n");
        StringItem stringitem15 = new StringItem("20:45\n", "Teatro de paso. Teatro Primigenio (C\363rdoba). \u201CMisi\363n primitiva\u201D. Paseo del Espol\363n, itinerante.\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form v()
    {
        Form form = new Form("Jueves 2, noche");
        b = new ImageItem("Jueves 2, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:00\n", "Circo. Fundaci\363n Chiminigagua (Colombia). \u201CRituales de lo primitivo a lo moderno\u201D. Plaza Mayor.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "4\252 Noche de humor con San Miguel. Teatro Indigesto. \u201CIndigesti\363n desclowntrolada\u201D. caf\351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "Plazas con m\372sica . Entrev\355as. Rock cl\341sico-blues. Llana de Afuera.\n \n");
        StringItem stringitem3 = new StringItem("23:00\n", "Plazas con m\372sica . Natural Way. Rock-metal-progressive. Llana de Afuera.\n \n");
        StringItem stringitem4 = new StringItem("23:30\n", "Fuegos artificiales. Exhibici\363n de fuegos artificiales. Pirotecnia Turis, de Valencia. campa del silo.\n \n");
        StringItem stringitem5 = new StringItem("00:00\n", "Plazas con m\372sica . Mr. Mach\355n. Hard rock. Llana de Afuera.\n \n");
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
        Form form = new Form("Viernes 3, ma\361ana");
        b = new ImageItem("Viernes 3, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("11:00\n", "Soli Juegos Caja deBurgos. Un viaje, en busca de la solidaridad a trav\351s de juegos tradicionales de los 5 continentes. Hasta las 13:00 horas. Plaza de santiago. Organiza: Foro Solidario de Caja de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. En los talleres de la tierra har\341s cosas con tus propias manos. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("12:00\n", "Pasacalles de danzantes, gigantillos y gigantones. Calles del centro hist\363rico.\n \n");
        StringItem stringitem3 = new StringItem("13:00\n", "Pensado para los peques. La plaza de la magia. Struc (Barcelona). Plaza de la Libertad.\n \n");
        StringItem stringitem4 = new StringItem("13:00\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
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

    public final Form x()
    {
        Form form = new Form("Viernes 3, tarde");
        b = new ImageItem("Viernes 3, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("18:00\n", "IV Festival cultural de capoeira en Burgos. Cursillo de iniciaci\363n. Polideportivo de Lava deros. Entrada gratuita. Organiza: Asociaci\363n S.C. de Capoeira de Burgos.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (6\252 de abono). Toros de los Recitales para El Fundi, Jos\351 Ignacio Ramos y Antonio Ferrera. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Mariano Calvo (Burgos) y Alejandro Furnadjiev (Bulgaria). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem4 = new StringItem("19:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Pensado para los peques. La plaza de la magia. Struc (Barcelona). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("19:30\n", "Miguel. Mariano Calvo (Burgos) y Alejandro Furnadjiev (Bulgaria). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem7 = new StringItem("20:00\n", "Zarzuela. Compa\361\355a L\355rica Barbieri. \u201CLa alegr\355a de la huerta\u201D. Director: Pedro Luis Domingo. M\372sica: Federico Chueca. Libreto: Enrique Garc\355a \301lvarez y Antonio Paso. Teatro Principal. Tarifa A-4.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Bailes de siempre. Orquesta Banda del Arlanz\363n. Paseo de Regino Sainz de la Maza.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Teatro Familiar. La Sonrisa (Burgos). \u201CDesaguisados\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Mariano Calvo (Burgos) y Alejandro Furnadjiev (Bulgaria). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem11 = new StringItem("20:15\n", "Teatro de paso. Festuc Teatre (L\351rida). \u201CMoon space, lun\341ticos!\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem13 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Mariano Calvo (Burgos) y Alejandro Furnadjiev (Bulgaria). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem14 = new StringItem("20:30\n", "Circo. Vaiv\351n Circo-Danza (Granada). \u201CLa felicidad en un dos por dos\u201D. Plaza Mayor.\n \n");
        StringItem stringitem15 = new StringItem("20:30\n", "Plazas con m\372sica . Morgan Club. Versiones de todas las \351pocas de la mano de Dar\355a Ras. Calle Valent\355n Palencia (junto al CAB).\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form y()
    {
        Form form = new Form("Viernes 3, noche");
        b = new ImageItem("Viernes 3, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "5\252 Noche de humor con San Miguel. La Serda. \u201CEl delirio\u201D. Teatro de risa y absurdo. caf\351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "Plazas con m\372sica . XII Festival Burgos en vivo. Ondulador McMurray. Rock & Blues. Llana de Afuera.\n \n");
        StringItem stringitem3 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 6\252 sesi\363n. Pirotecnia Fireworks Colonnelli, de Italia. Entre los puentes de San Pablo y STA. Mar\355a.\n \n");
        StringItem stringitem4 = new StringItem("00:00\n", "Plazas con m\372sica . Triquel. Folk rock celta, que atrae a los que quieren bailar, re\355r, cantar y, en una palabra, disfrutar. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem5 = new StringItem("00:00\n", "Plazas con m\372sica . XII Festival Burgos en vivo. Supernautas. M\372sica alternativa-indie-rock. Llana de Afuera.\n \n");
        StringItem stringitem6 = new StringItem("00:15\n", "Concierto. Nena Daconte. Aparca miento del centro comercial Camino de la Plata.\n \n");
        StringItem stringitem7 = new StringItem("01:15\n", "Plazas con m\372sica . XII Festival Burgos en vivo. Doble Malta. Rock grunge. Llana de Afuera.\n \n");
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

    public final Form z()
    {
        Form form = new Form("S\341bado 4, ma\361ana");
        b = new ImageItem("S\341bado 4, ma\361ana\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("09:00\n", "Deporte. II Trofeo nacional ciudad de Burgos. Entrenamientos de 9:00 a 10:30 h. Competici\363n de 11:00 a 14:00 y 16:00 a 20:00 h. Pista de patinaje de El Plant\355o. Organiza: Club Arlanz\363n de Patinaje Art\355stico.\n \n");
        StringItem stringitem1 = new StringItem("10:00\n", "IV Festival cultural de capoeira en Burgos. Cursillo de iniciaci\363n. Polideportivo de Lava deros. Entrada gratuita. Organiza: Asociaci\363n S. C. de Capoeira de Burgos.\n \n");
        StringItem stringitem2 = new StringItem("10:00\n", "Deporte. VII Torneo internacional de f\372tbol sala en Burgos. Polideportivo de san Amaro. Organiza: Agrupaci\363n Deportiva de Sordos de Burgos.\n \n");
        StringItem stringitem3 = new StringItem("11:30\n", "Pensado para los peques. El Parque de Mero el Jardinero. Te dar\341n ganas de pescar peces de colores. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem4 = new StringItem("12:00\n", "Pasacalles de danzantes, gigantillos y gigantones. Calles del centro hist\363rico.\n \n");
        StringItem stringitem5 = new StringItem("13:00\n", "Pensado para los peques. La plaza de la magia. Zaki (Vizcaya). Plaza de la Libertad.\n \n");
        StringItem stringitem6 = new StringItem("13:00\n", "Tradicional baile de danzantes, gigantillos y gigantones. Plaza Mayor.\n \n");
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

    public final Form A()
    {
        Form form = new Form("S\341bado 4, tarde");
        b = new ImageItem("S\341bado 4, tarde\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("17:00\n", "Deporte. XXV Trofeo de automodelismo Burgos. Circuito de automodelismo de Fuentes Blancas. Organiza: Club de Modelismo Castilla.\n \n");
        StringItem stringitem1 = new StringItem("18:00\n", "Pensado para los peques. El Parque de Mero el Jardinero. Gran Fiesta de clausura. Parque del Dr. Vara. Patrocina: Caja C\355rculo.\n \n");
        StringItem stringitem2 = new StringItem("18:30\n", "Feria Taurina. Gran corrida de toros (fuera de abono). Toros de Ben\355tez Cubero para Ferm\355n Bohorquez, Hermoso de Mendoza y Diego Ventura. Plaza de Toros.\n \n");
        StringItem stringitem3 = new StringItem("19:00\n", "IV Festival cultural de capoeira en Burgos. Espect\341culo para todos los p\372blicos. Teatro Clunia. Se invita a los asistentes a llevar 1 kg de alimentos no perecederos destinados al Banco de Alimentos de Burgos. Organiza: Asociaci\363n S. C. de Capoeira de Burgos.\n \n");
        StringItem stringitem4 = new StringItem("19:00\n", "Semana m\341gica . Close up con San Miguel. Dani Daortiz (M\341laga) y Manuel Llaser (Argentina). caf \351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem5 = new StringItem("19:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem6 = new StringItem("19:30\n", "Pensado para los peques. La plaza de la magia. Zaki (Vizcaya). Plaza de la Libertad.\n \n");
        StringItem stringitem7 = new StringItem("19:30\n", "Semana m\341gica . Close up con San Miguel. Dani Daortiz (M\341laga) y Manuel Llaser (Argentina). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem8 = new StringItem("20:00\n", "Zarzuela. Compa\361\355a L\355rica Barbieri. \u201CLa alegr\355a de la huerta\u201D. Director: Pedro Luis Domingo. M\372sica: Federico Chueca. Libreto: Enrique Garc\355a \301lvarez y Antonio Paso. Teatro Principal. Tarifa A-5.\n \n");
        StringItem stringitem9 = new StringItem("20:00\n", "Teatro Familiar. En La Lona (Argentina-Espa\361a). \u201CMomento ridiccoli\u201D. Paseo del Espol\363n, cuatro reyes.\n \n");
        StringItem stringitem10 = new StringItem("20:00\n", "Semana m\341gica . Close up con San Miguel. Dani Daortiz (M\341laga) y Manuel Llaser (Argentina).caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem11 = new StringItem("20:15\n", "Teatro de paso. Scura Splats (Castell\363n). \u201CMacroscopi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem12 = new StringItem("20:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem13 = new StringItem("20:30\n", "Circo. C\355a. Rolabola (M\341laga). \u201CPl\341zidos domingos\u201D. Plaza Mayor.\n \n");
        StringItem stringitem14 = new StringItem("20:30\n", "Semana m\341gica . Close up con San Miguel. Dani Daortiz (Malaga) y Manuel Llaser (Argentina). caf\351 teatro Monasterio de San Juan. Entrada gratuita.\n \n");
        StringItem stringitem15 = new StringItem("20:30\n", "Plazas con m\372sica . El Esp\355ritu de L\372gubre. Mundo rural reimpulsado, folk ficticio. Calle Valent\355n Palencia (junto al CAB).\n \n");
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
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form B()
    {
        Form form = new Form("S\341bado 4, noche");
        b = new ImageItem("S\341bado 4, noche\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("21:30\n", "Teatro de paso. C\355a. La Tal (Barcelona). \u201CIndian taxi\u201D. Paseo del Espol\363n, itinerante.\n \n");
        StringItem stringitem1 = new StringItem("22:00\n", "6\252 Noche de humor con San Miguel. Riki L\363pez. \u201CBuenrollitina\u201D. M\372sica de autor. caf\351 teatro Monasterio de San Juan. Tarifa: 7 \u20AC.\n \n");
        StringItem stringitem2 = new StringItem("22:00\n", "Plazas con m\372sica . XII Festival Burgos en vivo. Misplace. Hardcore con toques de punk, rock y metal. Llana de Afuera.\n \n");
        StringItem stringitem3 = new StringItem("23:30\n", "Fuegos artificiales. IV Muestra internacional de fuegos artificiales. 7\252 sesi\363n. First Class Pyro-Events, de Alemania. Entre los puentes de San Pablo y Santa Mar\355a.\n \n");
        StringItem stringitem4 = new StringItem("00:00\n", "Plazas con m\372sica . El Puchero del Hortelano. Desde Granada funk, pop, rock y flamenco. Plaza de la Virgen del Manzano.\n \n");
        StringItem stringitem5 = new StringItem("00:00\n", "Plazas con m\372sica . XII Festival Burgos en vivo. Gemma. Cantautora-pop. Llana de Afuera.\n \n");
        StringItem stringitem6 = new StringItem("00:15\n", "Conciertos. Los Chichos. Aparca miento del centro comercial Camino de la Plata.\n \n");
        StringItem stringitem7 = new StringItem("01:15\n", "Plazas con m\372sica . XII Festival Burgos en Vivo. Sexma. Heavy metal-metal-grunge. Llana de Afuera.\n \n");
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

    public final Form C()
    {
        Form form = new Form("Domingo 5, D\355a de las Pe\361as y del Burgal\351s Ausente");
        b = new ImageItem("Domingo 5, D\355a de las Pe\361as y del Burgal\351s Ausente\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("11:00\n", "Acogida a los burgaleses ausentes. Con presencia de autoridades, reinas y representantes de pe\361as. Tradicional baile de los gigantillos y danzantes. Parque de Fuentes Blancas.\n \n");
        StringItem stringitem1 = new StringItem("12:00\n", "IV Festival cultural de capoeira en Burgos. Clase y espect\341culo para todos los p\372blicos. Paseo del Espol\363n, cuatro reyes. Organiza: Asociaci\363n S. C. de Capoeira de Burgos.\n \n");
        StringItem stringitem2 = new StringItem("12:00\n", "Misa de campa\361a ante la imagen de la Virgen del \301lamo. Acompa\361a Estampas Burgalesas. Parque de Fuentes Blancas.\n \n");
        StringItem stringitem3 = new StringItem("14:00\n", "Concurso del Buen Yantar. Plato obligatorio: Solomillo de cerdo al gusto de cada pe\361a. Parque de Fuentes Blancas.\n \n");
        StringItem stringitem4 = new StringItem("19:00\n", "Baile de tarde. Mila y Tarlat\341n. Parque de Fuentes Blancas.\n \n");
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

    public final Form D()
    {
        Form form = new Form("Jueves 9");
        b = new ImageItem("Jueves 9\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem;
        (stringitem = new StringItem("20:00\n", "Entrega de premios a los ganadores de los concursos de las Fiestas. Teatro Principal. Sal\363n Rojo. Entrada con invitaci\363n.\n \n")).setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form E()
    {
        Form form = new Form("Instrucciones");
        b = new ImageItem("Instrucciones\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem;
        (stringitem = new StringItem("Desplazamiento:\n", "Puede usar el JoyStick (o bot\363n central) del tel\351fono para desplazarse arriba y abajo por los men\372s y los mapas interactivos.\n \n")).setLayout(1);
        StringItem stringitem1;
        (stringitem1 = new StringItem("Selecci\363n:\n", "Para entrar en cualquier men\372 pulse el bot\363n central del JoyStick o el comando \"Abrir\" del men\372.\n \n")).setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form F()
    {
        Form form = new Form("Obtener la aplicaci\363n");
        b = new ImageItem("Obtener la aplicaci\363n\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem;
        (stringitem = new StringItem("V\355a Bluetooth:\n", "Puede descargar gratuitamente esta aplicaci\363n desde La Plaza Mayor, Plaza de Santo Domingo Guzm\341n, Plaza de Espa\361a, Teatro Principal y Plaza de Roma.\n \n")).setLayout(1);
        StringItem stringitem1;
        (stringitem1 = new StringItem("V\355a Web:\n", "Desde http://www.aytoburgos.es, descargando la aplicaci\363n a su PC y desde ah\355 a su m\363vil, v\355a Bluetooth o Cable.\n \n")).setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form G()
    {
        Form form = new Form("Bluetooth");
        b = new ImageItem("Configuraci\363n Bluetooth\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem;
        (stringitem = new StringItem("Configuraci\363n:\n", "Para que otro tel\351fono pueda recibir la aplicaci\363n desde un emisor, el sistema Bluetooth del terminal debe estar activado y en modo visible (normalmente en Opciones, configuraci\363n, conectividad...)\n \n")).setLayout(1);
        StringItem stringitem1;
        (stringitem1 = new StringItem("Vinculaci\363n:\n", "No es necesario vincular o asociar su tel\351fono con el emisor. Autom\341ticamente recibir\341 un mensaje de descarga. Ac\351ptelo. \n \nSi el tel\351fono pide alg\372n c\363digo use 0000.\n \n")).setLayout(1);
        StringItem stringitem2;
        (stringitem2 = new StringItem("Ejecuci\363n:\n", "Seg\372n el modelo de tel\351fono la aplicaci\363n se iniciar\341 tras la descarga. De no ser as\355 podr\341 encontrarla normalmente en: Aplicaciones, Juegos, Multimedia, Archivos, Mis Cosas, etc.\n \n")).setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
        form.append(stringitem2);
        form.append(a_javax_microedition_lcdui_ImageItem_fld);
        return form;
    }

    public final Form H()
    {
        Form form = new Form("Acerca de...");
        b = new ImageItem("Acerca de...\n \n", null, 2563, "...");
        a_javax_microedition_lcdui_ImageItem_fld = new ImageItem("", a(a_java_lang_String_fld + "banner.png"), 515, "... ...");
        StringItem stringitem = new StringItem("Distribuido por:\n", "Ambar Telecomunicaciones SL. Centro de negocio en Burgos, C/ Alfareros, 43, 09001 Burgos (Castilla Le\363n). Tlf: 947 26 74 84\n \n");
        StringItem stringitem1 = new StringItem("Desarrollado por:\n", "Esidea Grupo Tecnol\363gico. Av. de Madrid 32-34 bajo, Logro\361o, 26007 (La Rioja). Tlf.:941 20 34 24\n \n");
        stringitem.setLayout(1);
        stringitem1.setLayout(1);
        form.append(b);
        form.append(stringitem);
        form.append(stringitem1);
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
    private String a_java_lang_String_fld;
}
