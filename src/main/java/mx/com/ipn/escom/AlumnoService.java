package mx.com.ipn.escom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AlumnoService {
	private static Map<Integer,Alumno> alumnos=new HashMap<>();
	static {
		Alumno christian = new Alumno(2015301270,"Christian","Montiel","Sistemas","christian30394@hotmail.com");
		Alumno Mario = new Alumno(2015301272,"Mario","Montiel","Economia","mario30394@hotmail.com");
		alumnos.put(1,christian);
		alumnos.put(2, Mario);
	}
	
	
	/**
	 * Buenas practicas
	 * 
	 */
	
	/**
	 *
	 *este metodo nos regresara la lista de todos los clientes existentes en la
	 *base de datos
	 *
	 */
	@GET
	public List<Alumno> getAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/**
	 * metodo para guardar un alumno nuevo que recibe como parametro un alumno
	 * 
	 */
	@POST
	public void addAlumno(Alumno alumno) {
		alumnos.put(alumnos.size() + 1 ,alumno);
	}
	
	/**
	 * metodo para borrar
	 */
	@DELETE
	@Path("/{alumnoID}")
	public void deleteAlumno(@PathParam("alumnoID") int id) {
		alumnos.remove(id);
	}
}
