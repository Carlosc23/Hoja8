import static org.junit.Assert.*;
import org.junit.Test;
import java.util.PriorityQueue;
/**
 * Clase para probar que los metodos implementados funcionen correctamente.
 * 	@author Carlos Calderon, 15219
 *  @author Rafael Leon,13361
 * @version 3.0 Octubre 3, 2016 
 */
public class PruebasHospital {
	/* Atributos */
	 private VectorHeap<Paciente> vec ;
	 private PriorityQueue<Paciente> vec2;
	 private Paciente paciente;
	
	/**
	 * Metodo para testear el add de VectorHeap.
	 * @throws Exception en caso de algun envio no valido. 
	 */
	@Test
	public void testAdd() {
		vec= new VectorHeap<Paciente>();
		vec2= new PriorityQueue<Paciente>();
		paciente = new Paciente("Luisa","Parto","A");
		vec.add(paciente);
		//paciente = new Paciente("Luisa","Parto","C");
		vec2.add(paciente);
		assertEquals(vec.getFirst(),vec2.peek());
		}
	
	/**
	 * Metodo para testear el remove de VectorHeap
	 * @throws Exception en caso de algun envio no valido. 
	 */
	@Test
	public void TestRemove() throws Exception{
		vec= new VectorHeap<Paciente>();
		vec2= new PriorityQueue<Paciente>();
		paciente = new Paciente("Luisa","Parto","A");
		vec.add(paciente);
		//paciente = new Paciente("Luisa","Parto","C");
		vec2.add(paciente);
		assertEquals(vec.remove(),vec2.poll());
	}
	}

