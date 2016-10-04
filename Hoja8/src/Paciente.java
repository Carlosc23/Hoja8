
/**
 * @author Carlos Calderon, 15219
 * @author Rafael Leon , 13361
 * @version 3.0 , 3 de octubre de 2016.
 * Clase Paciente. Implementa la interfaz comparable. Simula un paciente para el registro de 
 * emergencias.
 *
 */
public class Paciente  implements Comparable<Paciente>{
	/* Atributos*/
	private String nombre;
	private String descripcion;
	private String codigo;
	
	/**
	 * Constructor 
	 * @param nombre	nombre del paciente
	 * @param descripcion	descripcion de enfermedad
	 * @param codigo		codigo de emergencia
	 */
	public Paciente(String nombre, String descripcion, String codigo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}


	/**
	 * @return	el nombre del paciente
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre	nombre del paciente para cambiarse en caso de error
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return	descripcion de enfermedad del paciente.
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion	descripcion del paciente para cambiarse en caso de error.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return	codigo de emergencia del paciente
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo	codigo del paciente para cambiarse en caso de error.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Paciente arg0) {
		return this.codigo.compareTo(arg0.codigo);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nombre+ ","+ descripcion+ "," +codigo;
	}
}
