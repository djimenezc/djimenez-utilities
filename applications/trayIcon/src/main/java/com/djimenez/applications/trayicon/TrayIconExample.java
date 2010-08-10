package com.djimenez.applications.trayicon;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase EjemploTrayIcon.java Autor Wilfredo Vargas Almendras Fecha 03/08/2007
 * Hora 05:32:28 PM
 */

public class TrayIconExample extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = -1408193503680004331L;

  public static void main(final String[] args) {

    final TrayIconExample ventana = new TrayIconExample();

  }

  private JPanel panel;

  private JButton boton;

  public TrayIconExample() {

    propiedades();

    construirComponentes();

    propiedadesComponentes();

    anadirTrayIcon();

    setVisible(true);

  }

  private void anadirTrayIcon() {

    // Referencia al tray icon, este se construira con un popup

    TrayIcon trayIcon;

    // Verificamos si el TryIcon se soporta en el sistema

    if (SystemTray.isSupported()) {

      // Recuperamos la barra de trays del sistema

      final SystemTray tray = SystemTray.getSystemTray();

      // COnstruimos una ImageIcon para la imágen del Tray

      final ImageIcon imagen = new ImageIcon("animacion.gif");

      /*
       * Definicion de algunas clases que manejen los eventos de los items en el
       * Tray
       */

      final ActionListener eventoSalir = new ActionListener() {

        public void actionPerformed(final ActionEvent e) {

          System.exit(0);

        }

      };

      final ActionListener eventoAcercaDe = new ActionListener() {

        public void actionPerformed(final ActionEvent e) {

          JOptionPane.showMessageDialog(TrayIconExample.this,
            "Wilfredo Vargas Almemdras \n" +

            "® Agosto 2007 \n" +

            "Cochabamba - Bolivia");

        }

      };

      // El popup para desplegar en el TryIcon

      final PopupMenu popup = new PopupMenu();

      // Construimos los items del popup

      final MenuItem mi1 = new MenuItem("Bandeja de entrada");

      final MenuItem mi2 = new MenuItem("Revisar correo");

      final Menu mi3 = new Menu("Carreras");

      final MenuItem mi4 = new MenuItem("Salir");

      final MenuItem mi5 = new MenuItem("Acerca de...");

      // Construimos objetos para seleccionar alguna opcion

      final CheckboxMenuItem check1 =
        new CheckboxMenuItem("Ingenieria de sistemas", true);

      final CheckboxMenuItem check2 =
        new CheckboxMenuItem("Licenciatura en Informática");

      final CheckboxMenuItem check3 =
        new CheckboxMenuItem("Ingenieria Electronica");

      // Añadirmos los check's al menu 3

      mi3.add(check1);

      mi3.add(check2);

      mi3.add(check3);

      // Añadimos los items al popup

      popup.add(mi1);

      popup.add(mi2);

      popup.addSeparator();

      popup.add(mi3);

      popup.add(mi4);

      popup.addSeparator();

      popup.add(mi5);

      // Agragamos los eventos

      mi4.addActionListener(eventoSalir);

      mi5.addActionListener(eventoAcercaDe);

      // Construimos el TrayIcon con la imagen y el popup previamente definidos

      trayIcon = new TrayIcon(imagen.getImage(), "Ejemplo Tray Icon", popup);

      trayIcon.setImageAutoSize(true);

      try {

        tray.add(trayIcon);

      }
      catch (final AWTException e) {

        System.err.println("El TrayIcon no puede añadirse");

      }

    }

  }

  private void construirComponentes() {

    panel = new JPanel();

    boton = new JButton("Hazme click ...");

  }

  private void propiedades() {

    setSize(200, 70);

    setTitle("Ejemplo Icon Tray");

    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }

  private void propiedadesComponentes() {

    panel.setBackground(Color.BLACK);

    add(panel);

    panel.add(boton);

  }

}
