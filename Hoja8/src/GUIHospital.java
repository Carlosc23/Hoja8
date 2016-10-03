import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author Carlos Calderon ,15219
 * @author Rafael Leon, 13361
 * @version 2.0 , 1 de octubre de 2016
 * Clase GUIHospital. Se encarga de dar la interfaz grafica, para desplegar a los pacientes.
 */
public class GUIHospital extends JFrame {
	/*Atributos*/
	private JPanel contentPane;
	private JTextField textField;
	private JButton  btnDesplegar,btnNewButton ;
	private Manejadora manejadora;
	private JLabel lblNewLabel,lblNewLabel_1,lblPacientesEnOrden;
	private JTextArea textArea;
	private GroupLayout gl_contentPane;
	private JScrollPane scrollPane;
	  public static final String[] opciones = { "VectorHeap", "JFC" };
	/**
	 * Launch the application.
	 * @param args argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIHospital frame = new GUIHospital();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Constructor. Incializa componentes graficos e instancia la clase manejadora.
	 */
	public GUIHospital() {
		manejadora = new Manejadora();
		initialize();
	}
	
	/**
	 * Crear el frame
	 */
	private void initialize(){
		//Inicializar panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Inicializar labels
		lblNewLabel = new JLabel("Registro de Emergencias UVG");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNewLabel_1 = new JLabel("Ingrese directorio de  fichas del paciente:");
		lblPacientesEnOrden = new JLabel("Pacientes registrados/ Pacientes en orden de prioridad");
		
		//Inicializar textfield
		textField = new JTextField();
		textField.setColumns(10);
		
		//Inicizliar textArea
		textArea = new JTextArea();		

		//Inicializar botones 
		btnDesplegar = new JButton("Desplegar");
		btnNewButton = new JButton("Reiniciar");
		
		//Inicializar Scrollpanel
		scrollPane = new JScrollPane();
		
		// Agregar listeners
		 btnDesplegar.addActionListener(new ManejadorEventos());
		 btnNewButton.addActionListener(new ManejadorEventos());
		
		 //Inicializar layout y agregar componentes en sus respectivas posiciones
		 gl_contentPane = new GroupLayout(contentPane);
		 gl_contentPane.setHorizontalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(205)
		 					.addComponent(lblNewLabel))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(73)
		 					.addComponent(lblNewLabel_1)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(45)
		 					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
		 						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 						.addComponent(btnDesplegar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		 				.addGroup(gl_contentPane.createSequentialGroup()
		 					.addGap(36)
		 					.addComponent(lblPacientesEnOrden)))
		 			.addContainerGap())
		 );
		 gl_contentPane.setVerticalGroup(
		 	gl_contentPane.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_contentPane.createSequentialGroup()
		 			.addGap(23)
		 			.addComponent(lblNewLabel)
		 			.addGap(43)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(lblNewLabel_1)
		 				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		 			.addGap(18)
		 			.addComponent(lblPacientesEnOrden)
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		 				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(btnDesplegar))
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(btnNewButton)
		 			.addContainerGap(34, Short.MAX_VALUE))
		 );
		
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
	//Inner class para manejar eventos
		private class ManejadorEventos implements ActionListener {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				/*Boton de reinicio*/
				if (e.getSource() == btnNewButton) {
					textField.setEditable(true);
					textArea.setText("");
					textField.setText("");
				}
				/* Boton para desplegar resultados*/
				if (e.getSource() == btnDesplegar) {
					String contenido=manejadora.leerContenido(textField.getText());
					if (contenido!=null){
						JFrame frame = new JFrame("Input ");
						 String imp = (String) JOptionPane.showInputDialog(frame, 
							        "Escoga la implementacion que desea utilizar",
							        "Implementacion",
							        JOptionPane.QUESTION_MESSAGE, 
							        null, 
							        opciones, 
							        opciones[0]);
							    // favoritePizza will be null if the user clicks Cancel
							    //System.out.printf("Favorite pizza is %s.\n", imp);
							    if (imp!=null){
							    	if (imp.equals("VectorHeap")){
								    	textArea.append("--Pacientes en orden de registro-- \n");
										textArea.append(contenido);
										manejadora.asignacion(textField.getText());
										textArea.append("--Pacientes en orden de prioridad que deben ser atendidos-- \n");
										//C:\Users\Carlos\Desktop\nombres.txt"
										textArea.append(manejadora.desplegar());
										textField.setEditable(false);
								    }
								    else if (imp.equals("JFC")){
								    	textArea.append("--Pacientes en orden de registro-- \n");
								    	textArea.append(contenido);
								    	manejadora.asignacion2(textField.getText());
								    	textArea.append("--Pacientes en orden de prioridad que deben ser atendidos-- \n");
										//C:\Users\Carlos\Desktop\nombres.txt"
										textArea.append(manejadora.desplegar2());
										textField.setEditable(false);
								    }
							    }
							    else{
							    	
							    }
					}
					
				}
			}
		}
}
