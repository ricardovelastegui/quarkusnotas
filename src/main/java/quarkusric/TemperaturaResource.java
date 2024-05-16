package quarkusric;



import java.util.List;
import java.util.NoSuchElementException;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/temperaturas")
public class TemperaturaResource {

    private TemperaturaService temperaturaService;

    @Inject
    public TemperaturaResource(TemperaturaService temperaturaService) {
        this.temperaturaService = temperaturaService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura nueva(Temperatura temp ){
        temperaturaService.addTemperatura(temp);
        return temp;
    }
      

    @GET
    //transfoma a arrays de JSON, jackson convierte a json 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list() {
        //devuelve una copia de solo lectura 
        return temperaturaService.obtenTemperaturas();
        
        
    }

    @GET
    @jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
    @Path("/una")
    public Temperatura medicion() {
        return new Temperatura("Las Vegas", 25, 36);
    }

    //tratar la respuesta de manera local 
    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima(){
        if( temperaturaService.isEmpty() ){
            //tipo de error es el 404
            return Response.status(404).entity("no hay temperaturas").build();

        }else{
            int tempmax = temperaturaService.maxima();
            //codifica con atajo con estado 200, y el valor de la temperatura maxima
            return Response.ok(Integer.toString(tempmax))
            .header("x-hola", "buenos dias")
            .build();
        }
    }

    //o ir a lo bruto
    @GET
    @Path("/{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    //esa ciudad va a entrar como parametro 
    public Temperatura sacar(@PathParam("ciudad")  String ciudad){
        //sacar del servicio temperarura, la termperatura para esa ciudad
        return temperaturaService.sacarTemperatura(ciudad)
                         .orElseThrow(() -> new NoSuchElementException("no hay registro para la ciudad" + 
                          ciudad, null));
        
    }

}
