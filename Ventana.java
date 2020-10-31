import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		super("Monedero");
		//Variable para leer el dinero inicial del monedero
		int dineroinicial;
		String sCad;
		do{
            sCad=JOptionPane.showInputDialog(null,"¿Cuanto es el dinero incial del monedero?","Monedero",JOptionPane.QUESTION_MESSAGE);
            dineroinicial=Integer.parseInt(sCad);
            if(dineroinicial<0) 
                JOptionPane.showMessageDialog(null,"Error, no puedes ingresar numeros negativos","", JOptionPane.WARNING_MESSAGE);
        }while(dineroinicial<0);
		Monedero monedero = new Monedero(dineroinicial);//creacion del monedero
		//Creacion de la ventala
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Presentacion del programa y opciones
		JLabel lblNewLabel = new JLabel("Programa que gestiona la cantidad de dinero \n que una persona dispone en un monedero");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(22, 11, 443, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFQue desea hacer?");
		lblNewLabel_1.setBounds(188, 46, 192, 24);
		contentPane.add(lblNewLabel_1);
		
		//boton 1
		JButton btnOpcion1 = new JButton("Opcion 1");
		btnOpcion1.addActionListener(new ActionListener() {
			//Funcion del boton
			public void actionPerformed(ActionEvent arg0) {
				//Declaracion de variables
				int entrada;
				String sCad;
				//Se lee y valida que el numero sea positivo
				do{
                    sCad=JOptionPane.showInputDialog(null,"¿Cuanto dinero desea ingresar?","Monedero",JOptionPane.QUESTION_MESSAGE);
                    entrada=Integer.parseInt(sCad);
                    if(entrada<0)
                        JOptionPane.showMessageDialog(null,"Error, no puedes ingresar numeros negativos","", JOptionPane.WARNING_MESSAGE);
                 }while(entrada<0);
				//Se añade y se mestra mensaje de exito
                 monedero.meterDinero(entrada);
                 JOptionPane.showMessageDialog(null,"Dinero añadido con exito","",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnOpcion1.setBounds(102, 77, 93, 23);
		contentPane.add(btnOpcion1);
		
		//Boton 2
		JButton btnOpcion2 = new JButton("Opcion 2");
		btnOpcion2.addActionListener(new ActionListener() {
			//Accion del boton 2
			public void actionPerformed(ActionEvent e) {
				String sCad;
				int salida,band;
				//Se lee y valida que el numero no sea negativo
				do {
					do{
                    sCad=JOptionPane.showInputDialog(null,"¿Cuanto dinero desea sacar?","Monedero",JOptionPane.QUESTION_MESSAGE);
                    salida=Integer.parseInt(sCad);
                    if(salida<0)
                        JOptionPane.showMessageDialog(null,"Error, no puedes ingresar numeros negativos","", JOptionPane.WARNING_MESSAGE);
					}while(salida<0);
					//Bandera nos ayuda a repetir en caso de que el numero fuera negativo
					band=monedero.sacarDinero(salida);
				}while (band==1);
			}
		});
		btnOpcion2.setBounds(102, 126, 93, 23);
		contentPane.add(btnOpcion2);
		
		//Boton 3
		JButton btnOpcion3 = new JButton("Opcion 3");
		btnOpcion3.addActionListener(new ActionListener() {
			//Accion del boton 3
			public void actionPerformed(ActionEvent arg0) {
				//Se muestra un mensaje con el dinero total
				JOptionPane.showMessageDialog(null,"El dinero en el monedero es: "+monedero.consultarDinero(),"Monedero",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnOpcion3.setBounds(102, 173, 93, 23);
		contentPane.add(btnOpcion3);
		
		//Boton salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			//Accion del boton salir
			public void actionPerformed(ActionEvent arg0) {
				//Se muestra un mensaje de racias y se cierra el programa
				JOptionPane.showMessageDialog(null,"Gracias por usar el programa, hasta luego ;)","", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		btnSalir.setBounds(404, 256, 75, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_2 = new JLabel("Meter dinero");
		lblNewLabel_2.setBounds(205, 81, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sacar dinero");
		lblNewLabel_3.setBounds(205, 130, 127, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Consultar dinero disponible");
		lblNewLabel_4.setBounds(205, 177, 218, 14);
		contentPane.add(lblNewLabel_4);
	}
}
