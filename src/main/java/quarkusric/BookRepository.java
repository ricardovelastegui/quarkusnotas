package quarkusric;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped  //tratarlo como un inyectable para poder meterlo en nuestro recurso
public class BookRepository implements PanacheRepository<Book> {
    
}
