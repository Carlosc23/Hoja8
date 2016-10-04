import java.io.BufferedReader;
import java.util.PriorityQueue;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * @author Carlos Calderon, 15219
 * @author Rafael Leon,13361
 * @version 3.0
 * Clase Manejadora. Se encarga de los procesos que debe llevar a cabo el 
 * registro para funcionar.
 */
public class Manejadora {
	/*Atributos */
	private VectorHeap<Paciente> cola;
	private Paciente paciente;
	private ArrayList<String> array;
	private PriorityQueue<Paciente> cola2;
	/**
	 * Recorre un fichero para guardarlo en un string. Si el directorio de fichero es incorrecto,
	 * devuelve null, y una advertencia
	 * @param archivo	fichero .txt para ser leido
	 * @return	texto almacenado en el fichero
	 */
	String leerContenido(String archivo) {
		String texto = "", temp = "", bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				temp += bfRead+"\n";
			}
			texto = temp;
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
			int con = JOptionPane.showConfirmDialog(null,
					"Desea tratar de nuevo", null, JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Presione el boton reiniciar");
				return null;
			} else if (con == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Gracias por usar el programa");
				System.exit(0);
			}
		}
		return texto;
	}
	
	
	/**
	 * Recorre un fichero para guardarlo en un array de Strings. Cada linea esta una casilla
	 * del array. Si el directorio de fichero es incorrecto, devuelve null, y una advertencia.
	 * @param archivo	fichero .txt para ser leido
	 * @return	array de Strings con el texto linea por linea
	 */
	ArrayList<String> leerContenido2(String archivo) {
		String bfRead;
		this.array = new ArrayList<String>();
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				this.array.add(bfRead);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
			int con = JOptionPane.showConfirmDialog(null,
					"Desea tratar de nuevo", null, JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Presione el boton reiniciar");
			} else if (con ==JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Gracias por usar el programa");
				System.exit(0);
			}
		}
		return this.array;
	}
	
	/**
	 * Asigna a cada paciente a un objeto tipo paciente. Para luego cada objeto
	 * ser guardad en una cola de prioridad (clase VectorHeap).
	 * @param archivo	fichero .txt para ser leido
	 */
	void asignacion(String archivo){
		int largo,conta=0;
		String[] parts;
		largo= leerContenido2(archivo).size();
		cola = new VectorHeap<Paciente>();
		while(largo>0){
			parts = array.get(conta).split(",");
			paciente = new Paciente(parts[0],parts[1],parts[2]);
			cola.add(paciente);
			largo--;
			conta++;
		}
	}
	/**
	 * Asigna a cada paciente a un objeto tipo paciente. Para luego cada objeto
	 * ser guardad en una cola de prioridad con JFC.
	 * @param archivo	fichero .txt para ser leido
	 */
	void asignacion2(String archivo){
		int largo,conta=0;
		String[] parts;
		largo= leerContenido2(archivo).size();
		cola2 = new PriorityQueue<Paciente>();
		while(largo>0){
			parts = array.get(conta).split(",");
			paciente = new Paciente(parts[0],parts[1],parts[2]);
			cola2.add(paciente);
			largo--;
			conta++;
		}
	}
	/**
	 *  Devuelve en una cadena todos los pacientes registrados en orden de prioridad con VectorHeap.
	 * @return	pacientes, el String con los pacientes registrados
	 */
	String desplegar(){
		String pacientes = "";
		while(cola.isEmpty()==false){
			paciente=cola.remove();
			pacientes+=paciente.toString()+"\n";
		}
		return pacientes;
	}
	/**
	 *  Devuelve en una cadena todos los pacientes registrados en orden de prioridad usando el JFC.
	 * @return	pacientes, el String con los pacientes registrados
	 */
	String desplegar2(){
		String pacientes = "";
		while(cola2.isEmpty()==false){
			paciente=cola2.poll();
			pacientes+=paciente.toString()+"\n";
		}
		return pacientes;
	}
	
}
