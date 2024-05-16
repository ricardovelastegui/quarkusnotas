package quarkusric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperaturaService implements ITemperaturaService{

    private List<Temperatura> valores = new ArrayList<>();

    //metodo publico 
    @Override
    public void addTemperatura(Temperatura temp){
        valores.add(temp);
    }

    //metodo que me devuelva la lista de temperaturas
    @Override
    public List<Temperatura> obtenTemperaturas(){
        return Collections.unmodifiableList(valores);
    }
    
    @Override
    public int maxima(){
        return valores.stream().mapToInt(Temperatura::getMaxima).max().getAsInt();
    }

    @Override
    public boolean isEmpty(){
        return valores.isEmpty();
    }

    @Override
    public Optional<Temperatura> sacarTemperatura(String ciudad){
        //indica que habrá una ciudad t que será igual ala ciudad que me pasan como parametro 
        return valores.stream().filter( t -> t.getCiudad().equals(ciudad)).findAny();
    }
}
