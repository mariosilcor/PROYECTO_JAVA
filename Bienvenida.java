/* PROYECTO FINAL - JAVA CON BLOC DE NOTAS
La empresa Coca-Cola Company requiere de un programa con interfaz gráfica de usuario,
el cual debe realizar el cálculo de los días de vacaciones a los que tiene derecho un trabajador,
dependiendo de su puesto y antigüedad en la empresa, para lo cual, 
la empresa ha proporcionado los siguientes requerimientos:

DISEÑO Y FUNCIONALIDAD
El programa deberá contener distintas interfaces, para navegar entre ellas, las cuales son las siguientes:

1. Interfaz de bienvenida:

A) La Pantalla principal y de arranque, deberá contener:
* Logotipo y colores de marca.
* Imagen representativa en el icono de la aplicación.
* Un campo de texto donde el usuario deberá introducir su nombre.
* Un botón que permita pasar a la siguiente pantalla.
* Al pie de la interfaz deberá contener la leyenda 2020 The Coca-Cola Company.

B) Funcionalidad de esta interfaz:
* Capturar el nombre del usuario.
* No permitir avanzar a la siguiente interfaz si el usuario no ha escrito su nombre.
* Si el usuario escribió su nombre, permitir avanzar a la siguiente interfaz.

2. Interfaz de Términos y Condiciones:

A) La Pantalla de términos y condiciones, deberá contener:
* Logotipo de la marca.
* Imagen representativa en el icono de la aplicación.
* Un campo donde se puedan leer los términos y condiciones.
* Implementar una forma en que el usuario pueda aceptar los términos y condiciones.
* Botón de continuar.
* Botón de No aceptar.

B) Funcionalidad de esta interfaz:
* El nombre del usuario que aceptará o no, los términos y condiciones debe aparecer en alguna parte de la interfaz, 
pues con eso se confirma que es el mismo usuario quien acepta los términos y condiciones.
* El botón de "Continuar" deberá estar deshabilitado mientras el usuario no acepte lo términos y condiciones, 
mientras que al mismo tiempo el botón de "No Aceptar" deberá estar habilitado.
* El botón "No Aceptar", se deberá deshabilitar cuando el usuario acepte los términos y condiciones,
al mismo tiempo que el botón de "Continuar" se deberá habilitar.
* El botón "Continuar" debe enviar a la siguiente pantalla, 
mientras que el botón "No Aceptar" deberá regresarnos a la pantalla de Bienvenida. 

3. Pantalla principal:

A) La Pantalla Principal, deberá contener:
* Logotipo de la marca.
* Imagen representativa en el icono de la aplicación.
* Menú superior con distintas funcionalidades (a consideración del desarrollador).
* Campos de texto para nombre, apellidos y resultado del cálculo de las vacaciones del trabajador.
* Al pie de la interfaz deberá contener la leyenda 2020 The Coca-Cola Company.

B) Funcionalidad de esta interfaz:
* En alguna parte de la interfaz se debe mostrar el nombre del usuario quien acepto los términos y condiciones.
* Se debe de dar la libertad al usuario de poder realizar acciones de personalización a la interfaz gráfica.
* Debe haber una opción para poder regresar a la pantalla de Bienvenida.
* Implementar una manera de realizar el cálculo de los días de vacaciones con los datos solicitados del trabajador.
* Agregar los datos del desarrollador de manera que no interfieran con la visibilidad del usuario al momento de utilizar el programa. */

/* Tabulador de días a los que un trabajador tiene derecho: */

/* Trabajadores de atención al cliente:
* Con 1 año de servicio, reciben 6 días de vacaciones.
* Con 2 a 6 años de servicio, reciben 14 días de vacaciones.
* A partir de 7 años de servicio, reciben 20 días de vacaciones.

Trabajadores de Logística:
* Con 1 año de servicio, reciben 7 días de vacaciones.
* Con 2 a 6 años de servicio, reciben 15 días de vacaciones.
* A partir de 7 años de servicio, reciben 22 días de vacaciones.

Gerentes:
* Con 1 año de servicio, reciben 10 años de vacaciones.
* Con 2 a 6 años de servicio, reciben 20 días de vacaciones.
* A partir de 7 años de servicio, reciben 30 días de vacaciones. */

/* Librerías de Java */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida /* Nombre de la clase */ 
extends JFrame /* heredamos nuestra clase JFrame con ayuda de la palabra extends */
implements ActionListener { /* implementamos la clase ActionListener porque se va a crear un evento desde un botón */

/* Componentes que se van a utilizar en el programa */
  private JTextField teclado1; /* La función que tiene el JTextField en este programa es capturar el nombre del usuario */
  private JLabel texto1, texto2, texto3, texto4;
  private JButton boton1;
  public static String nombre1 = ""; /* Esta línea de código lo que hace es declarar una variable y todo lo que contenga esta variable va a poder ser utilizada por cualquier otra interfaz gráfica */
/* Modificador de acceso: Son los que permiten o le dicen al programa quién tiene acceso a las variables o componentes y quién no */
/* En los componentes al tener un modificador de acceso de tipo privado quiere decir que nadie más a excepción de la clase Bienvenida puede hacer uso de estos componentes */
/* En los componentes al tener un modificador de acceso público estamos indicando que pueden venir otras clases, en este caso la clase de términos y condiciones y hacer uso de la variable que estamos declarando */
/* static indica un atributo de clase, un atributo de clase es una característica propia de la clase */
/* String, tipo de dato que nos permite declarar una variable que aloje texto */

/* Constructor */
public Bienvenida() { /* Modificador de acceso seguido del nombre de nuestra clase */
  setLayout(null); /* Método */
  setDefaultCloseOperation(EXIT_ON_CLOSE); /* Con esta línea de código se logrará que nuestros programas no
                                              queden en segundo plano y cada vez que el usuario logre cerrar 
                                              cualquier interfaz, en ese momento el proceso morirá */
  setTitle("Bienvenido"); /* Método que hace colocar el título en la parte superior de la interfaz */
  getContentPane().setBackground(new Color(255, 0, 0)); /* Método que usa rgb y pone el fondo de la interfaz de color rojo */
/* Método que pone una imágen al icono de la interfaz gráfica 
.getImage Método que le dice al programa que va a obtener una imágen de la siguiente ruta: images/icon.png
images/icon.png Ruta donde el programa va a localizar la imágen que queremos colocar en el icono
images/ Carpeta que va a buscar el programa, una vez que ya la encontro, el programa va a entrar
icon.png Nombre junto con la extensión de la imágen
.getResource Método que le dice al programa que va a cargar la imágen 
getClass Nombre de la clase donde el programa mostrará la imagen 
new ImageIcon Objeto de tipo ImageIcon
setIconImage Le dice al programa que va a colocar esa imágen en el icono de la interfaz */
setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

/* Objeto de tipo ImageIcon que guarda la imágen que se llama imagen */
  ImageIcon imagen = new ImageIcon("images/logo-coca.png");
/* Objeto de tipo JLabel que contiene la imágen que se llama imagen */
  texto1 = new JLabel(imagen);
  texto1.setBounds(25, 15, 300, 150); /* Método que da dimensiones y coordenadas */
  add(texto1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a texto1 */

  texto2 = new JLabel("Sistema de Control Vacacional"); /* Objeto de tipo JLabel */
  texto2.setBounds(35, 135, 300, 30); /* Método que da dimensiones y coordenadas */
  texto2.setFont(new Font("Andale Mono", 3, 18)); /* Método que le da tipografía, fuente y tamaño a texto2 */
  texto2.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone texto2 de color blanco */
  add(texto2); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a texto2 */

  texto3 = new JLabel("Ingrese su nombre:"); /* Objeto de tipo JLabel */
  texto3.setBounds(45, 212, 200, 30); /* Método que da dimensiones y coordenadas */
  texto3.setFont(new Font("Andale Mono", 1, 12)); /* Método que le da tipografía, fuente y tamaño a texto3 */
  texto3.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone texto3 de color blanco */
  add(texto3); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a texto3 */

  texto4 = new JLabel("2020 The Coca-Cola Company"); /* Objeto de tipo JLabel */
  texto4.setBounds(85, 375, 300, 30); /* Método que da dimensiones y coordenadas */
  texto4.setFont(new Font("Andale Mono", 1, 12)); /* Método que le da tipografía, fuente y tamaño a texto4 */
  texto4.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone texto4 de color blanco */
  add(texto4); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a texto4 */

  teclado1 = new JTextField(); /* Componente de tipo JTextField */
  teclado1.setBounds(45, 240, 255, 25); /* Método que da dimensiones y coordenadas */
  teclado1.setBackground(new Color(224, 224, 224)); /* Método que cambia el color de fondo de teclado1 */
  teclado1.setFont(new Font("Andale Mono", 1, 14)); /* Método que le da tipografía, fuente y tamaño a teclado1 */
  teclado1.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone teclado1 de color rojo */
  add(teclado1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a teclado1 */

  boton1 = new JButton("Ingresar"); /* Componente de tipo JButton */
  boton1.setBounds(125, 280, 100, 30); /* Método que da dimensiones y coordenadas */
  boton1.setBackground(new Color(224, 224, 224)); /* Método que cambia el color de fondo del botón boton1 */
  boton1.setFont(new Font("Andale Mono", 1, 14)); /* Método que le da tipografía, fuente y tamaño a boton1 */
  boton1.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone boton1 de color rojo */
  boton1.addActionListener(this); /* Evento que se le va agregar a boton1 */
  add(boton1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a boton1 */  
 } /* Salida del Constructor */

 public void actionPerformed(ActionEvent evento1) { /* Función que le dice al programa que se agregará un evento */
  if(evento1.getSource() == boton1) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en boton1 */ 
    /* Recuperar el texto que está dentro del JTextField y alojarlo dentro de la variable nombre */
   nombre1 = teclado1.getText().trim(); /* Método .getText(), recupera el texto que esté dentro de un componente */
/* Método .trim(), permite en caso dado de que el usuario ingrese espacios antes del texto y después del texto, el método .trim(), lo que hace es borrar los espacios y después una vez que borro los espacios guardarlos dentro de la variable */
   if(nombre1.equals("")) { /* Estructura condicional que tiene que verificar si el usuario escribió o no escribió texto */
/* Método .equals(), verifica lo que está dentro de la variable nombre1 y si se da cuenta de que no hay texto, entonces enviará un mensaje */
        JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre."); /* Si se cumple la condición se enviará un mensaje  a través del
                                                                             método JOptionPane.showMessageDialog, es decir le indica al programa que el
                                                                             usuario debe ingresar su nombre y la única manera de que la instrucción se cumpla es si 
                                                                             todas las variables o alguna de ellas esta en blanco*/
   } else {
/* Dimensiones y coordenadas de la interfaz, es decir el marco que encierra todos los componentes */
     Licencia ventanalicencia = new Licencia(); /* Creación del objeto del tipo de la clase */
     ventanalicencia.setBounds(0, 0, 600, 360); /* Método que da dimensiones y coordenadas */
     ventanalicencia.setVisible(true); /* Método que le dice al programa que la interfaz será visible al usuario */
     ventanalicencia.setResizable(false); /* Método que le dice al programa que el usuario no modifique las dimensiones de la interfaz */
     ventanalicencia.setLocationRelativeTo(null); /* Método que le dice al programa que cuando se inicie la interfaz que se muestre al centro de la pantalla */
     this.setVisible(false); /* Método que le dice al programa que la interfaz Bienvenida no será visible al usuario */
   }
  }
 }
 public static void main(String args[]) { /* Método main */
/* Dimensiones y coordenadas de la interfaz, es decir el marco que encierra todos los componentes */
   Bienvenida ventanabienvenida = new Bienvenida();
   ventanabienvenida.setBounds(0, 0, 350, 450);
   ventanabienvenida.setVisible(true);
   ventanabienvenida.setResizable(false);
   ventanabienvenida.setLocationRelativeTo(null);
 }
}