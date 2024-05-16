package quarkusric;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

//anotacion que indica que esta clase tiene que estar conectada a una pagina de nuestro servidor

@Path("/saludar")
public class EcoResource {

    @GET
    //http://localhost:8080/saludar?mensaje=confirma madrid campeon
    public String saludar(@QueryParam("mensaje") String mensaje){
        return Optional.ofNullable(mensaje)
        .map(n -> " > " + n)
        .orElse("no sé que decirte");
        // if(mensaje == null){
        //     return "no sé que decirte";
        // } else {
        //     return " > " + mensaje;
        // }
    }

    //codificar parametro en el proprio path, quiero que el parametro me venga en la url 
    //es como mas dinamico, lo modifico en el url 
    @GET
    @Path("/{nombre}")
    public String saludo(@PathParam("nombre")  String nombre){
        return "hola, " + nombre;
    }

    @GET
    @Path("/{nombre}/mayusculas")
    public String gritar(@PathParam("nombre")  String nombre){
        return "hola!!!, " + nombre.toUpperCase();
    } //esto reacciona asi en la url: localhost:8080/saludar/pepe/mayusculas
    
}
