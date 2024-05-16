package quarkusric;

import java.util.NoSuchElementException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class NoSuchElementExceptionMapper implements ExceptionMapper<NoSuchElementException>{

    public static record NoSuchElementMessage(String message, String detail){

    }

    @Override                      //recibirá un exception
    //reponse es como un mapper
    public Response toResponse(NoSuchElementException e){
        var error = new NoSuchElementMessage(e.getMessage(), null);
        //lo que pongamos aqui será ejecutado se detecte una excepcion de tipo NoSuchElementException
        return Response.status(404).entity(error ).build();
    }   
    
}
