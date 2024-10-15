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

public class Principal /* Nombre de la clase */ 
extends JFrame /* heredamos nuestra clase JFrame con ayuda de la palabra extends */
implements ActionListener { /* implementamos la clase ActionListener que nos ayuda a escuchar los eventos de los botones */

/* Componentes que se van a utilizar en el programa */
  private JMenuBar menubarra1;
  private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
  private JMenuItem submenuCalculo, submenuRojo, submenuNegro, submenuMorado, submenuElCreador, submenuSalir, submenuNuevo;
  private JLabel etiquetaLogo, etiquetaBienvenido, etiquetaTitulo, etiquetaNombre, etiquetaAPaterno, etiquetaAMaterno,
                 etiquetaDepartamento, etiquetaAntiguedad, etiquetaResultado, etiquetaFooter;
  private JTextField tecladoNombreTrabajador, tecladoAPaternoTrabajador, tecladoAMaternoTrabajador;
  private JComboBox comboDepartamento, comboAntiguedad;
  private JScrollPane scrollpane1;
  private JTextArea textarea1;
  String nombre3 = ""; /* Esta variable nos va a ayudar a alojar el contenido que tiene la variable nombre3 en la clase Bienvenida */

/* Constructor */
public Principal() { /* Modificador de acceso seguido del nombre de nuestra clase */
  setLayout(null); /* Método */
  setDefaultCloseOperation(EXIT_ON_CLOSE); /* Con esta línea de código se logrará que nuestros programas no
                                              queden en segundo plano y cada vez que el usuario logre cerrar 
                                              cualquier interfaz, en ese momento el proceso morirá */
  setTitle("Pantalla Principal"); /* Método que hace colocar el título en la parte superior de la interfaz */
  getContentPane().setBackground(new Color(255, 0, 0)); /* Método que le dice al programa que el fondo de la interfaz gráfica debe ser de color rojo */
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
nombre3 = ventanaBienvenida.nombre1; /* Recupera el valor de una variable que se llama nombre1 y lo vas a alojar dentro de la variable que se llama nombre3 */

/* Creación de la barra de un menú principal donde se va a colocar cada uno de los menus */
  menubarra1 = new JMenuBar();
  menubarra1.setBackground(new Color(255, 0, 0));
  setJMenuBar(menubarra1);

  menuOpciones = new JMenu("Opciones"); /* Objeto de tipo JMenu */
  menuOpciones.setBackground(new Color(255, 0, 0)); /* Método que cambia el color de fondo de menuOpciones */
  menuOpciones.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a menuOpciones */
  menuOpciones.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone menuOpciones de color blanco */
  menubarra1.add(menuOpciones); /* Evento que se le va a agregar a menubarra1 desde menuOpciones */

  menuCalcular = new JMenu("Calcular"); /* Objeto de tipo JMenu */
  menuCalcular.setBackground(new Color(255, 0, 0)); /* Método que cambia el color de fondo de menuCalcular */
  menuCalcular.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a menuCalcular */
  menuCalcular.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone menuCalcular de color blanco */
  menubarra1.add(menuCalcular); /* Evento que se le va a agregar a menubarra1 desde menuCalcular */

  menuAcercaDe = new JMenu("Acerca de"); /* Objeto de tipo JMenu */
  menuAcercaDe.setBackground(new Color(255, 0, 0)); /* Método que cambia el color de fondo de menuAcercaDe */
  menuAcercaDe.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a menuAcercaDe */
  menuAcercaDe.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone menuAcercaDe de color blanco */
  menubarra1.add(menuAcercaDe); /* Evento que se le va a agregar a menubarra1 desde menuAcercaDe */

  menuColorFondo = new JMenu("Color de fondo"); /* Objeto de tipo JMenu */
  menuColorFondo.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a menuColorFondo */
  menuColorFondo.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone menuColorFondo de color rojo */
  menuOpciones.add(menuColorFondo); /* Evento que se le va a agregar a menuOpciones desde menuColorFondo */

  submenuCalculo = new JMenuItem("Vacaciones"); /* Objeto de tipo JMenuItem */
  submenuCalculo.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuCalculo */
  submenuCalculo.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuCalculo de color rojo */
  menuCalcular.add(submenuCalculo); /* Evento que se le va a agregar a menuCalcular desde submenuCalculo */
  submenuCalculo.addActionListener(this); /* Evento que se le va a agregar a submenuCalculo gracias a la clase ActionListener */

  submenuRojo = new JMenuItem("Rojo"); /* Objeto de tipo JMenuItem */
  submenuRojo.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuRojo */
  submenuRojo.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuRojo de color rojo */
  menuColorFondo.add(submenuRojo); /* Evento que se le va a agregar a menuColorFondo desde submenuRojo */
  submenuRojo.addActionListener(this); /* Evento que se le va a agregar a submenuRojo gracias a la clase ActionListener */

  submenuNegro = new JMenuItem("Negro"); /* Objeto de tipo JMenuItem */
  submenuNegro.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuNegro */
  submenuNegro.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuNegro de color rojo */
  menuColorFondo.add(submenuNegro); /* Evento que se le va a agregar a menuColorFondo desde submenuNegro */
  submenuNegro.addActionListener(this); /* Evento que se le va a agregar a submenuNegro gracias a la clase ActionListener */

  submenuMorado = new JMenuItem("Morado"); /* Objeto de tipo JMenuItem */
  submenuMorado.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuMorado */
  submenuMorado.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuMorado de color rojo */
  menuColorFondo.add(submenuMorado); /* Evento que se le va a agregar a menuColorFondo desde submenuMorado */
  submenuMorado.addActionListener(this); /* Evento que se le va a agregar a submenuMorado gracias a la clase ActionListener */

  submenuNuevo = new JMenuItem("Nuevo"); /* Objeto de tipo JMenuItem */
  submenuNuevo.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuNuevo */
  submenuNuevo.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone subMenuNuevo de color rojo */
  menuOpciones.add(submenuNuevo); /* Evento que se le va a agregar a menuAcercaDe desde submenuNuevo */
  submenuNuevo.addActionListener(this); /* Evento que se le va a agregar a submenuNuevo gracias a la clase ActionListener */

 submenuElCreador = new JMenuItem("El creador"); /* Objeto de tipo JMenuItem */
 submenuElCreador.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuElCreador */
 submenuElCreador.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuElCreador de color rojo */
 menuAcercaDe.add(submenuElCreador); /* Evento que se le va a agregar a menuAcercaDe desde submenuElCreador */
 submenuElCreador.addActionListener(this); /* Evento que se le va a agregar a submenuElCreador gracias a la clase ActionListener */

 submenuSalir = new JMenuItem("Salir"); /* Objeto de tipo JMenuItem */
 submenuSalir.setFont(new Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a submenuSalir */
 submenuSalir.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone submenuSalir de color rojo */
 menuOpciones.add(submenuSalir); /* Evento que se le va a agregar a menuOpciones desde submenuSalir */
 submenuSalir.addActionListener(this); /* Evento que se le va a agregar a submenuSalir gracias a la clase ActionListener */

/* Objeto de tipo ImageIcon que guarda la imágen que se llama imagen */
  ImageIcon imagen = new ImageIcon("images/logo-coca.png");
/* Objeto de tipo JLabel que contiene la imágen que se llama imagen */
  etiquetaLogo = new JLabel(imagen);
  etiquetaLogo.setBounds(5, 5, 250, 100); /* Método que da dimensiones y coordenadas */
  add(etiquetaLogo); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaLogo */

  etiquetaBienvenido = new JLabel("Bienvenido " + nombre3); /* Objeto de tipo JLabel */
/* Aparece el valor de la variable nombre3 donde se había recuperado nombre1, gracias a que se concateno la variable nombre3 */
  etiquetaBienvenido.setBounds(280, 30, 300, 50); /* Método que da dimensiones y coordenadas */
  etiquetaBienvenido.setFont(new Font("Andale Mono", 1, 32)); /* Método que da tipografía, fuente y tamaño a etiquetaBienvenido */
  etiquetaBienvenido.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaBienvenido de color blanco */
  add(etiquetaBienvenido); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaBienvenido */

  etiquetaTitulo = new JLabel("Datos del trabajador para el calculo de vacaciones"); /* Objeto de tipo JLabel */
  etiquetaTitulo.setBounds(45, 140, 900, 25); /* Método que da dimensiones y coordenadas */
  etiquetaTitulo.setFont(new Font("Andale Mono", 0, 24)); /* Método que da tipografía, fuente y tamaño a etiquetaTitulo */
  etiquetaTitulo.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaTitulo de color blanco */
  add(etiquetaTitulo); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaTitulo */

  etiquetaNombre = new JLabel("Nombre completo:"); /* Objeto de tipo JLabel */
  etiquetaNombre.setBounds(25, 188, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaNombre.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaNombre */
  etiquetaNombre.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaNombre de color blanco */
  add(etiquetaNombre); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaNombre */

  tecladoNombreTrabajador = new JTextField(); /* Objeto de tipo JTextField */
  tecladoNombreTrabajador.setBounds(25, 213, 150, 25); /* Método que da dimensiones y coordenadas */
  tecladoNombreTrabajador.setBackground(new java.awt.Color(224, 224, 224)); /* Método que cambia el color de fondo del campo tecladoNombreTrabajador */
  tecladoNombreTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a tecladoNombreTrabajador */
  tecladoNombreTrabajador.setForeground(new java.awt.Color(255, 0, 0)); /* Método que usa rgb y pone tecladoNombreTrabajador de color rojo */
  add(tecladoNombreTrabajador); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a tecladoNombreTrabajador */

  etiquetaAPaterno = new JLabel("Apellido Paterno:"); /* Objeto de tipo JLabel */
  etiquetaAPaterno.setBounds(25, 248, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaAPaterno.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaAPaterno */
  etiquetaAPaterno.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaAPaterno de color blanco */
  add(etiquetaAPaterno); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaAPaterno */

  tecladoAPaternoTrabajador = new JTextField(); /* Objeto de tipo JTextField */
  tecladoAPaternoTrabajador.setBounds(25, 273, 150, 25); /* Método que da dimensiones y coordenadas */
  tecladoAPaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224)); /* Método que cambia el color de fondo del campo tecladoAPaternoTrabajador */
  tecladoAPaternoTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a tecladoAPaternoTrabajador */
  tecladoAPaternoTrabajador.setForeground(new java.awt.Color(255, 0, 0)); /* Método que usa rgb y pone tecladoAPaternoTrabajador de color rojo */
  add(tecladoAPaternoTrabajador); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a tecladoAPaternoTrabajador */

  etiquetaAMaterno = new JLabel("Apellido Materno:"); /* Objeto de tipo JLabel */
  etiquetaAMaterno.setBounds(25, 308, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaAMaterno.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaAMaterno */
  etiquetaAMaterno.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaAMaterno de color blanco */
  add(etiquetaAMaterno); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaAMaterno */

  tecladoAMaternoTrabajador = new JTextField(); /* Objeto de tipo JTextField */
  tecladoAMaternoTrabajador.setBounds(25, 334, 150, 25); /* Método que da dimensiones y coordenadas */
  tecladoAMaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224)); /* Método que cambia el color de fondo del campo tecladoAMaternoTrabajador */
  tecladoAMaternoTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a tecladoAMaternoTrabajador */
  tecladoAMaternoTrabajador.setForeground(new java.awt.Color(255, 0, 0)); /* Método que usa rgb y pone tecladoAMaternoTrabajador de color rojo */
  add(tecladoAMaternoTrabajador); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a tecladoAMaternoTrabajador */

  etiquetaDepartamento = new JLabel("Selecciona el Departamento:"); /* Objeto de tipo JTextField */
  etiquetaDepartamento.setBounds(220, 188, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaDepartamento.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaDepartamento */
  etiquetaDepartamento.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaDepartamento de color blanco */
  add(etiquetaDepartamento); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaDepartamento */

  comboDepartamento = new JComboBox(); /* Objeto de tipo JComboBox */
  comboDepartamento.setBounds(220, 213, 220, 25); /* Método que da dimensiones y coordenadas */
  comboDepartamento.setBackground(new java.awt.Color(224, 224, 224)); /* Método que cambia el color de fondo del cuadro combinado comboDepartamento */
  comboDepartamento.setFont(new java.awt.Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a comboDepartamento */
  comboDepartamento.setForeground(new java.awt.Color(255, 0, 0)); /* Método que usa rgb y pone comboDepartamento de color rojo */
  add(comboDepartamento); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a comboDepartamento */
  comboDepartamento.addItem("");
  comboDepartamento.addItem("Atencion al Cliente");
  comboDepartamento.addItem("Departamento de Logistica");
  comboDepartamento.addItem("Departamento de Gerencia");

  etiquetaAntiguedad = new JLabel("Selecciona la antiguedad:"); /* Objeto de tipo JLabel */
  etiquetaAntiguedad.setBounds(220, 248, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaAntiguedad.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaAntiguedad */
  etiquetaAntiguedad.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaAntiguedad de color blanco */
  add(etiquetaAntiguedad); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaAntiguedad */

  comboAntiguedad = new JComboBox(); /* Objeto de tipo JComboBox */
  comboAntiguedad.setBounds(220, 273, 220, 25); /* Método que da dimensiones y coordenadas */
  comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224)); /* Método que cambia el color de fondo del cuadro combinado comboAntiguedad */
  comboAntiguedad.setFont(new java.awt.Font("Andale Mono", 1, 14)); /* Método que da tipografía, fuente y tamaño a comboAntiguedad */
  comboAntiguedad.setForeground(new java.awt.Color(255, 0, 0)); /* Método que usa rgb y pone comboAntiguedad de color rojo */
  add(comboAntiguedad); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a comboAntiguedad */
  comboAntiguedad.addItem("");
  comboAntiguedad.addItem("1 anio de servicio");
  comboAntiguedad.addItem("2 a 6 anios de servicio");
  comboAntiguedad.addItem("7 o mas anios de servicio");

  etiquetaResultado = new JLabel("Resultado del Calculo:"); /* Objeto de tipo JLabel */
  etiquetaResultado.setBounds(220, 307, 180, 25); /* Método que da dimensiones y coordenadas */
  etiquetaResultado.setFont(new Font("Andale Mono", 1, 12)); /* Método que da tipografía, fuente y tamaño a etiquetaResultado */
  etiquetaResultado.setForeground(new Color(255, 255, 255)); /* Método que usa rgb y pone etiquetaResultado de color blanco */
  add(etiquetaResultado); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaResultado */

  textarea1 = new JTextArea(); /* Objeto de tipo JTextArea */
  textarea1.setEditable(false); /* Método que le dice al programa que el usuario no puede editar ningún texto dentro de textarea1 */
  textarea1.setBackground(new Color(224, 224, 224)); /* Método que cambia el color de fondo del área de texto de textarea1 */
  textarea1.setFont(new Font("Andale Mono", 1, 11)); /* Método que da tipografía, fuente y tamañoa textarea1 */
  textarea1.setForeground(new Color(255, 0, 0)); /* Método que usa rgb y pone textarea1 de color rojo */
  textarea1.setText("\n   Aqui aparece el resultado del calculo de las vacaciones.");  /* Método que va a contener texto dentro de textarea1 */
  scrollpane1 = new JScrollPane(textarea1); /* Objeto de tipo JScrollPane que va a contener textarea1 */
  scrollpane1.setBounds(220, 333, 385, 90); /* Método que da dimensiones y coordenadas */
  add(scrollpane1); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a scrollpane1 */

  etiquetaFooter = new JLabel("2020 The Coca-Cola Company | Todos los derechos reservados"); /* Objeto de tipo JLabel */
  etiquetaFooter.setBounds(135, 445, 500, 30); /* Método que da dimensiones y coordenadas */
  etiquetaFooter.setFont(new java.awt.Font("Andale Mono", 1, 12));
  etiquetaFooter.setForeground(new java.awt.Color(255, 255, 255));
  add(etiquetaFooter); /* Método add que le dice al programa que todo lo anterior se tiene que agregar a etiquetaFooter */
 } /* Salida del Constructor */

/* Nota: Todos los objetos a los que le vamos a agregar eventos únicamente utilizan la clase ActionListener */
 public void actionPerformed(ActionEvent evento1) { /* Función que le dice al programa que se agregará un evento */
/* El objeto submenuCalculo permite es poder ejecutar toda la funcionalidad de la pestaña vacaciones */
     if (evento1.getSource() == submenuCalculo) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuCalculo
                                                     Para ello se van a declarar 5 variables de tipo String porque son 5 campos o 5 espacios en memoria que se necesitan alojar de manera temporal
                                                     Para los objetos de tipo JTextField tenemos que utilizar el método .getText() */
         String nombreTrabajador = tecladoNombreTrabajador.getText();
         String AP = tecladoAPaternoTrabajador.getText();
         String AM = tecladoAMaternoTrabajador.getText();
/* Para los objetos de tipo JComboBox tenemos que utilizar el método .getSelectedItem() y también el método .toString()
   El método .toString() nos permite convertir a String el dato que está dentro de nuestro JComboBox para posteriormente 
   así poderlo guardar dentro de las variables de tipo String */
         String Departamento = comboDepartamento.getSelectedItem().toString();
         String Antiguedad = comboAntiguedad.getSelectedItem().toString();

/* Posteriormente vamos a validar los campos para verificar que el usuario no deje ninguno en blanco, 
esto lo vamos a lograr con ayuda de una estructura condicional anidada */
         if(nombreTrabajador.equals("") || AP.equals("") || AM.equals("") ||
            Departamento.equals("") || Antiguedad.equals("")) { /* Estructura condicional que le dice al programa que verifique que la 
                                                                   variable nombreTrabajador no este en blanco, 
                                                                   recuerda que dos comillas juntas quiere decir un espacio totalmente vacío, 
                                                                   con ayuda del método .equals 
                                                                   se hace la comparación, seguido de esto se requiere el operador lógico || 
                                                                   porque también se tiene la posibilidad de verificar varias instrucciones dentro de una 
                                                                   misma estructura condicional*/
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos."); /* Si se cumple la condición se enviará un mensaje  a través del
                                                                                      método JOptionPane.showMessageDialog, 
                                                                                      es decir le indica al programa que el usuario debe llenar 
                                                                                      todos los campos y la única manera de que la instrucción 
                                                                                      se cumpla es si todas las variables o alguna de ellas esta en blanco*/
/* Creación de estructuras condicionales para validar cada situación en la que se puede encontrar un trabajador, es decir un trabajador puede estar en atención al cliente pero también puede tener
un año de servicio o dos años de servicio e incluso siete años de servicio para ello vamos a tener que crear una estructura condicional que determine en que departamento está el trabajador.
Si está en atención al cliente, el de partamento de logística o en el departamento de gerencia. Y por otra parte a cada una de estas estructuras condicionales hay que crearle tres estructuras 
condicionales dentro de ella que son los años de servicio que tiene este trabajador.

Estructura condicional que determine en qué departamento esta el trabajador y a cada una de estas tres estructuras condicionales se crearán 
tres estructuras condicionales dentro de ella que son los años de servicio que tiene el trabajador.*/
         } else { /* Si entra el else, quiere decir que no se cumplió la condición del if, por ende el usuario si lleno todos los campos */
	     if(Departamento.equals("Atencion al Cliente")) { /* Estructura condicional donde se va a comparar que el texto que esté dentro en la variable Departamento sea atención al cliente.
								 Esto si es posible porque la variable Departamento obtuvo este valor a través de un JComboBox que ya se obtuvo previamente con la ayuda del
								 método .GetSelectedItem(), entonces si el usuario selecciona Atención al Cliente se van a ejecutar las siguientes líneas de código: */

/* Escribimos 3 if anidados, si nos damos cuenta no hay ningún else y únicamente son 3 if anidados.
Ahora es aquí donde sirve el identado del código, pues sino tuviéramos el identado nosotros ya tendríamos un desastre dentro de nuestro código y muy seguramente nos causaría mucho problema entenderlo pero
gracias al identado podemos entender que las tres estructuras condicionales anidadas siguientes están dentro de otra estructura condicional. 

Lo que tenemos aquí únicamente es para validar si el trabajador tiene distintos años de servicio dentro de la empresa, tenemos lo que es 1 año de servicio, de 2 a 6 años de servicio y 7 o más años de
servicio, y dentro de cada estructura condicional si es que se cumple la condición tiene un mensaje diferente porque aquí lo que nos está diciendo, por ejemplo: el trabajador del nombre escrito por el
usuario en el teclado con apellido paterno y apellido materno quien labora en el nombre del Departamento con los años de Antigüedad pues recibe días de vacaciones.
Eso quiere decir que si el trabajador tiene un año de servicio y trabaja en atención al cliente únicamente va a recibir 6 días de vacaciones lo mismo pasa si tiene 2 a 6 años y 7 o más años. */    
                             if(Antiguedad.equals("1 anio de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 6 dias de vacaciones.");
			     }
                             if(Antiguedad.equals("2 a 6 anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 14 dias de vacaciones.");
			     }
			     if(Antiguedad.equals("7 o mas anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 20 dias de vacaciones.");
			     }
             }
/* Estructura condicional para el Departamento de Logística */
             if(Departamento.equals("Departamento de Logistica")) { /* Estructura condicional que nos va a permitir identificar si el usuario escribió o selecciono Departamento de Logística seguido de las
                                                                       estructuras condicionales anidadas que van a validar los años de servicio para todos los empleados del Departamento de Logística que
                                                                       de igual manera cada uno recibe días diferentes de vacaciones dependiendo de los años de servicio y departamento en el que labora. */

                             if(Antiguedad.equals("1 anio de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 7 dias de vacaciones.");
			     }
                             if(Antiguedad.equals("2 a 6 anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 15 dias de vacaciones.");
			     }
			     if(Antiguedad.equals("7 o mas anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 22 dias de vacaciones.");
			     }
         }
/* Estructura condicional para el Departamento de Gerencia donde hacemos exactamente lo mismo verificamos que el departamento sea gerencia y dependiendo de los años de servicio son los días de vacaciones
que se van a colocar dentro de nuestra variable textarea1. Sabemos que el método .setText es para colocar texto dentro de cualquier componente. */
         if(Departamento.equals("Departamento de Gerencia")) {
		         if(Antiguedad.equals("1 anio de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 10 dias de vacaciones.");
			     }
                             if(Antiguedad.equals("2 a 6 anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 20 dias de vacaciones.");
			     }
			     if(Antiguedad.equals("7 o mas anios de servicio")) {
				     textarea1.setText("\n    El trabajador " + nombreTrabajador + " " + AP + " " + AM +
						       "\n    quien labora en " + Departamento + " con " + Antiguedad +
         					       "\n    recibe 30 dias de vacaciones.");
			     }
                }
         }

     }
/* A partir de este punto ya se ha terminado la parte de cálculo. Ahora se va a empezar a programar los eventos para cada uno de los ítems(objetos) que nos hacen falta. 
   Creación del evento que nos va a permitir a nosotros poder cambiar el color de fondo de nuestra interfaz. 
   Colocamos nuestro rgb para el color rojo, el rgb para el color negro y el rgb para el color morado. */
     if (evento1.getSource() == submenuRojo) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuRojo */ 
         getContentPane().setBackground(new Color(255, 0, 0));
     }
     if (evento1.getSource() == submenuNegro) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuNegro */
         getContentPane().setBackground(new Color(0, 0, 0)); 
     }
     if (evento1.getSource() == submenuMorado) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuMorado */
         getContentPane().setBackground(new Color(51, 0, 51));
     }
/* Ahora se va a escribir el código para que limpie todos los campos de texto una vez que el usuario presione el menú ítem(objeto) nuevo. */
     if (evento1.getSource() == submenuNuevo) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuNuevo */
         tecladoNombreTrabajador.setText(""); /* Se tiene que colocar el método .setText hacia el componente JLabel, que se quiere limpiar y dentro de los paréntesis del método se colocarán dos comillas 
                                                 totalmente juntas. Recordemos que las comillas juntas significa que no se quiere que tenga ningún espacio, entonces lo que hará el programa es quitar 
                                                 cualquier texto que exista dentro del componente y dejar únicamente un espacio en blanco, lo va a borrar completamente */
         tecladoAPaternoTrabajador.setText("");
         tecladoAMaternoTrabajador.setText("");
         comboDepartamento.setSelectedIndex(0); /* En este caso con los JComboBox lo único que se quiere hacer en lugar de colocar comillas es colocar un cero y esto se hará con ayuda del 
                                                   método .setSelectedIndex, este es el método que nos ayuda a volver a restaurar en su valor original a nuestro componente JComboBox y entre paréntesis se
                                                   coloca un cero */
         comboAntiguedad.setSelectedIndex(0);
         textarea1.setText("\n   Aqui aparece el resultado del calculo de las vacaciones."); /* Finalmente tenemos el valor original de la variable textarea1 que es el texto que aparece por defecto, pues
                                                                                                aquí aparece el resultado del cálculo de las vacaciones. */
     }
/* Después agregamos dentro del menú items(objetos) salir todas las características de nuestra clase Bienvenida sin olvidar el método this.setVisible(false); Para que con esto se podrá esconder la 
   interfaz principal al momento de que se ejecute la interfaz Bienvenida. Recordemos que el menú ítem(objeto) Salir lo que hace es regresar a la interfaz de Bienvenida, entonces con esto  ya se habrá
   enlazado */
     if (evento1.getSource() == submenuSalir) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuSalir */
	 Bienvenida ventanabienvenida = new Bienvenida();
         ventanabienvenida.setBounds(0, 0, 350, 450);
         ventanabienvenida.setVisible(true);
         ventanabienvenida.setResizable(false);
         ventanabienvenida.setLocationRelativeTo(null);
         this.setVisible(false);
     }
/* Finalmente se pondrán los datos del desarrollador, esto se logra con la ayuda de un componente JOptionPane con el método .showMessageDialog, porque si te das cuenta al momento en que se dispara 
   el evento, lo que realmente nos está enviando es un mensaje en pantalla con lo cual logramos indicarle al usuario quién desarrollo este programa. */
     if (evento1.getSource() == submenuElCreador) { /* Estructura condicional que le dice al programa que recupere el evento que el usuario dispara en submenuElCreador */ 
         JOptionPane.showMessageDialog(null, "Desarrollado por la Geekepedia de Ernesto\n" +
                                             "       www.youtube.com/ErnestoPerezM");
     }
 }

/* Con esto se ha terminado de agregar todas las funcionalidades que nos requieren en esta interfaz gráfica */

 public static void main(String args[]) { /* Método main */
/* Dimensiones y coordenadas de la interfaz, es decir el marco que encierra todos los componentes */
   Principal ventanaPrincipal = new Principal(); /* Creación del objeto del tipo de la clase */
   ventanaPrincipal.setBounds(0, 0, 640, 535); /* Método que da dimensiones y coordenadas */
   ventanaPrincipal.setVisible(true); /* Método que le dice al programa que la interfaz será visible al usuario */
   ventanaPrincipal.setResizable(false); /* Método que le dice al programa que el usuario no modifique las dimensiones de la interfaz */
   ventanaPrincipal.setLocationRelativeTo(null); /* Método que le dice al programa que cuando se inicie la interfaz que se muestre al centro de la pantalla */
 }
}