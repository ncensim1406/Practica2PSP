
package practica2psp;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Practica2PSP extends JFrame
{
    //Creamos los clientes para añadirlos a una lista
    Cliente cliente1 = new Cliente("Rafael", "190", "20", "49");
    Cliente cliente2 = new Cliente("Marco", "255", "19", "80");
    Cliente cliente3 = new Cliente("Jose", "257", "34", "88");
    Cliente cliente4 = new Cliente("Manuel", "234", "56", "65");
    Cliente cliente5 = new Cliente("Alfredo", "112", "23", "74");
    Cliente cliente6 = new Cliente("Thegrefg", "223", "32", "100");
    Cliente cliente7 = new Cliente("Ibai", "455", "33", "99");
    
    List<Cliente> lista = new ArrayList<>(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5,cliente6,cliente7));

    int indice = -1;
    //Valores para los campos de texto
    private int numero = 0;
    private int doble = 0;

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField dobleField;
    private JTextField edadField;
    private JTextField puntosField;
    
    private JButton atrasButton;
    private JButton delanteButton;
    
    //Etiquetas para identificar los campos de texto del Alumno
    private JLabel numeroLabel = new JLabel("Nombre: ");
    private JLabel dobleLabel = new JLabel("Número: ");
    private JLabel edadLabel = new JLabel("Edad: ");
    private JLabel puntosLabel = new JLabel("Puntos: ");
    private JLabel clienteNumLabel = new JLabel("Cliente: "+ (indice+1));

    public Practica2PSP() {
        super("Practica 2");

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        dobleField = new JTextField(10);
        dobleField.setEditable(false);
        dobleField.setForeground(Color.red);
        
        //Field de la edad
        edadField = new JTextField(10);
        edadField.setEditable(false);
        edadField.setForeground(Color.blue);
        
        //Field de la edad
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.green);
        
        
        //Panel de botones
        atrasButton = new JButton("<--");
        atrasButton.setVisible(false);
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (indice>0) {
                    System.out.println("Usted ha retrocedido");
                    indice--;
                    actualizarCliente();
                    mostrarCliente(indice);
                    delanteButton.setVisible(true);
                    if(indice <=0){
                        atrasButton.setVisible(false);
                    }
                }
           
            }
        });
        
        delanteButton = new JButton("-->");
        delanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (indice<lista.size()-1) {
                    System.out.println("Usted ha avanzado");
                    indice++;
                    actualizarCliente();
                    mostrarCliente(indice);
                    if (indice!=0) {
                        atrasButton.setVisible(true);
                    }
                    
                    if(indice >= lista.size()-1){
                        delanteButton.setVisible(false);
                    }
                }
            }
        });
        //Dispone la geometria de las etiquetes del cliente
        JPanel clientePane = new JPanel();
        clientePane.setLayout(new GridLayout(0,1));
        clientePane.add(clienteNumLabel);
        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(dobleLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);
        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(dobleField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);
        //Panel botones
        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new GridLayout(1,0));
        botonesPane.add(atrasButton);
        botonesPane.add(delanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(clientePane,BorderLayout.NORTH);
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane,BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Practica2PSP app = new Practica2PSP();

                //Este WindowListener ya solo sirve para poner el foco.
                //(Para cerrar la ventana ya no hace falta: setDefaultCloseOperation.)
                app.addWindowListener(new WindowAdapter() {
                    //Pone el focus (foco de atencion)
                    public void windowActivated(WindowEvent e) {
                    }
                });
                app.pack();
                app.setVisible(true);
            }
        });
    }
    
    public void mostrarCliente(int indx){
        numeroField.setText(lista.get(indx).getNumero());
        dobleField.setText(lista.get(indx).getNombre());
        edadField.setText(lista.get(indx).getEdad());
        puntosField.setText(lista.get(indx).getPuntos());
    }
    
    public void actualizarCliente(){
        clienteNumLabel.setText("Cliente: "+ (indice+1));
    }

}
