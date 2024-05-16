package quarkusric;

import java.util.List;
import java.util.Optional;

public interface ITemperaturaService {

    void addTemperatura(Temperatura temp);

    List<Temperatura> obtenTemperaturas();  

    boolean isEmpty(); //me indica si la lista esta vacia

    //metodo que va devolverme para una ciudad que le pase como parametro suponiendo que exista, sino enviar un opcional vacio 
    Optional <Temperatura> sacarTemperatura(String ciudad);

    int maxima();
    
}
