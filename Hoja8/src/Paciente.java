
/**
 * @author Carlos Calderon
 * @Version 1.0
 * 
 *
 */
public class Paciente  implements Comparable<String>{
	/* Atributos*/
	private String nombre;
	private String descripcion;
	private String codigo;
	
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param codigo
	 */
	public Paciente(String nombre, String descripcion, String codigo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}


	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
