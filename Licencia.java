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
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia /* Nombre de la clase */ 
extends JFrame /* heredamos nuestra clase JFrame con ayuda de la palabra extends */
implements ActionListener, /* implementamos la clase ActionListener que nos ayuda a escuchar los eventos de los botones */
ChangeListener { /* implementamos la clase ChangeListener que nos ayuda a escuchar los eventos que se originen dentro del JCheckBox */

/* Componentes que se van a utilizar en el programa */
  private JLabel etiqueta1, etiqueta2;
  private JCheckBox casilla1;
  private JButton boton1, boton2;
  private JScrollPane scrollpane1;
  private JTextArea textarea1;
  String nombre2 = ""; /* Esta variable nos va a ayudar a alojar el contenido que tiene la variable nombre2 en la clase Bienvenida */

/* Constructor */
public Licencia() { /* Modificador de acceso seguido del nombre de nuestra clase */
  setLayout(null); /* Método */
  setDefaultCloseOperation(EXIT_ON_CLOSE); /* Con esta línea de código se logrará que nuestros programas no
                                              queden en segundo plano y cada vez que el usuario logre cerrar 
                                              cualquier interfaz, en ese momento el proceso morirá */
  setTitle("Licencia de uso"); /* Método que hace colocar el título en la parte superior de la interfaz */
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
Bienvenida ventanaBienvenida = new Bienvenida(); /* Objeto del tipo de la clase que recupera el valor de una variable que está en otra clase y después de que declaramos una variable de tipo público en la clase 
                                                    donde queremos tener acceso y otra variable desde la clase que nosotros queremos utilizar para recuperar ese valor es importante 
                                                    crear un objeto indicando a que clase queremos ir a visitar para pedirle el valor de esa variable */
nombre2 = ventanaBienvenida.nombre1; /* Recupera el valor de una variable que se llama nombre1 y lo vas a alojar dentro de la variable que se llama nombre2 */

  etiqueta1 = new JLabel ("TERMINOS Y CONDICIONES"); /* Objeto de tipo JLabel */
  etiqueta1.setBounds(215, 5, 200, 30); /* Método que da dimensiones y coordenadas */
  etiqueta1.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a etiqueta1 */
  etiqueta1.setForeground(new Color(0, 0, 0)); /* Método que usa rgb y pone etiqueta1 de color negro */
  add(etiqueta1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiqueta1 */

  textarea1 = new JTextArea(); /* Objeto de tipo JTextArea */
  textarea1.setEditable(false); /* Método que le dice al programa que el usuario no puede editar ningún texto dentro de textarea1 */
  textarea1.setFont(new Font("Andale Mono", 0, 9)); /* Método que da tipografía, fuente y tamaño a textarea1 */
  textarea1.setText("\n\n          TERMINOS Y CONDICIONES" +
                    "\n\n          A. PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE LA GEEKEPEDIA." +
                    "\n          B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS." +
                    "\n          C. LA GEEKEPEDIA NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (LA GEEKEPEDIA Y EL AUTOR MARIO), NO SE RESPONSABILIZAN DEL USO QUE USTED" +
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." +
                    "\n\n          PARA MAYOR INFORMACION SOBRE NEUSTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" +
                    "\n          NEW AGE CONSTRUCTION"); /* Método que va a contener texto dentro de textarea1 */
  scrollpane1 = new JScrollPane(textarea1); /* Objeto de tipo JScrollPane que va a contener textarea1 */
  scrollpane1.setBounds(10, 40, 575, 200); /* Método que da dimensiones y coordenadas */
  add(scrollpane1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a scrollpane1 */

  casilla1 = new JCheckBox("Yo " + nombre2 + " Acepto"); /* Objeto de tipo JCheckBox */
/* Aparece el valor de la variable nombre2 donde se había recuperado nombre1, gracias a que se concatenaron dos elementos */
  casilla1.setBounds(10, 250, 300, 30); /* Método que da dimensiones y coordenadas */
  casilla1.addChangeListener(this); /* Evento que se le va a agregar a casilla1 gracias a la clase ChangeListener */
  add(casilla1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a casilla1 */

  boton1 = new JButton("Continuar"); /* Objeto de tipo JButton con la leyenda Continuar */
  boton1.setBounds(10, 290, 100, 30); /* Método que da dimensiones y coordenadas */
  boton1.addActionListener(this); /* Evento que se le va a agregar a boton1 gracias a la clase ActionListener */
  boton1.setEnabled(false); /* Método que le dice al programa que boton1 este inactivo */
  add(boton1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a boton1 */

  boton2 = new JButton("No Acepto"); /* Objeto de tipo JButton con la leyenda No Acepto */
  boton2.setBounds(120, 290, 100, 30); /* Método que da dimensiones y coordenadas */
  boton2.addActionListener(this); /* Evento que se le va a agregar a boton2 gracias a la clase ActionListener */
  boton2.setEnabled(true); /* Método que le dice al programa que boton2 este activo */
  add(boton2); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a boton2 */

/* Objeto de tipo ImageIcon que guarda la imágen que se llama imagen */
  ImageIcon imagen = new ImageIcon("images/coca-cola.png");
/* Objeto de tipo JLabel que contiene la imágen que se llama imagen */
  etiqueta2 = new JLabel(imagen);
  etiqueta2.setBounds(315, 135, 300, 300); /* Método que da dimensiones y coordenadas */
  add(etiqueta2); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiqueta2 */
 } /* Salida del Constructor */

 public void stateChanged(ChangeEvent evento1) { /* Función que le dice al programa donde van a ir los eventos, es decir controlar los eventos de nuestro componente JCheckBox */
/* El JCheckBox se va a encargar de habilitar o deshabilitar los botones dependienco cuál sea la condición */
  if(casilla1.isSelected() == true) { /* Estructura condicional que le dice al programa que si el componente JCheckBox que se llama casilla1 
                                         está seleccionado y es verdad, entonces va a ejecutar las siguientes líneas de código */
     boton1.setEnabled(true); /* Método que le dice al programa que boton2 este activo */
     boton2.setEnabled(false); /* Método que le dice al programa que boton2 este inactivo */
  } else {
     boton1.setEnabled(false); /* Método que le dice al programa que boton2 este inactivo */
     boton2.setEnabled(true); /* Método que le dice al programa que boton2 este activo */
  }
 }

 public void actionPerformed(ActionEvent evento1) { /* Función que le dice al programa que se agregará un evento */
/* Recupera los eventos y validar que se haya originado el evento en boton1 o en boton2 gracias al método .getSource() */
   if(evento1.getSource() == boton1) { /* Estructura condicional anidada que le dice al programa que debe de verificar que el evento se haya originado en boton1, de lo contrario que verifique que el evento se haya originado en boton2 */
/* Enlaza a la interfaz Principal */
/* Dimensiones y coordenadas de la interfaz Principal, es decir el marco que encierra todos los componentes */
       Principal ventanaPrincipal = new Principal(); /* Creación del objeto del tipo de la clase */
       ventanaPrincipal.setBounds(0, 0, 640, 535); /* Método que da dimensiones y coordenadas */
       ventanaPrincipal.setVisible(true); /* Método que le dice al programa que la interfaz será visible al usuario */
       ventanaPrincipal.setResizable(false); /* Método que le dice al programa que el usuario no modifique las dimensiones de la interfaz */
       ventanaPrincipal.setLocationRelativeTo(null); /* Método que le dice al programa que cuando se inicie la interfaz que se muestre al centro de la pantalla */
       this.setVisible(false); /* Método que le dice al programa que la interfaz Licencia no será visible al usuario */
   } else if(evento1.getSource() == boton2) {
/* Enlaza a la interfaz Bienvenida */
/* Dimensiones y coordenadas de la interfaz, es decir el marco que encierra todos los componentes */
       Bienvenida ventanabienvenida = new Bienvenida();
       ventanabienvenida.setBounds(0, 0, 350, 450);
       ventanabienvenida.setVisible(true);
       ventanabienvenida.setResizable(false);
       ventanabienvenida.setLocationRelativeTo(null);
       this.setVisible(false); /* Método que le dice al programa que la interfaz Licencia no será visible al usuario */
   }
 }
 public static void main(String args[]) { /* Método main */
/* Dimensiones y coordenadas de la interfaz, es decir el marco que encierra todos los componentes */
   Licencia ventanalicencia = new Licencia(); /* Creación del objeto del tipo de la clase */
   ventanalicencia.setBounds(0, 0, 600, 360); /* Método que da dimensiones y coordenadas */
   ventanalicencia.setVisible(true); /* Método que le dice al programa que la interfaz será visible al usuario */
   ventanalicencia.setResizable(false); /* Método que le dice al programa que el usuario no modifique las dimensiones de la interfaz */
   ventanalicencia.setLocationRelativeTo(null); /* Método que le dice al programa que cuando se inicie la interfaz que se muestre al centro de la pantalla */
 }
}