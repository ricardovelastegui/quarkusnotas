package quarkusric;

import java.util.List;

import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
// import net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Direct;

@Path("/books")
@Transactional //anotacion transaccional significa modificará la base de datos
public class BookResource {

    @Inject
    private BookRepository repo;

    @GET
    public List<Book> index(@QueryParam("q") String query ){

        if(query== null){
            return repo.listAll(Sort.by("pubDate", Sort.Direction.Descending ));
        } else{
            String filter = "%" + query + "%";
            Sort crit = Sort.by("pubDate", Sort.Direction.Ascending);
            return repo.list("titulo ILIKE ?1 or description like ?2", crit, filter, filter);
        }

        //return repo.list("genre", "tragicomedia");  FILTRO, trae libros que sean parte de ese genero

        // return repo.listAll();
        // return Book.listAll();
        
    }

    @POST
    public Book insert(Book insertedBook){
        //comprobamos que el id es nulo o sea que no existe
        // assert insertedBook.getId() == null;
        repo.persist(insertedBook);
        // assert insertedBook.getId() != null;
        return insertedBook;
        // insertedBook.persist();
        // return insertedBook;
    }

    @GET
    @Path("{id}")
    public Book retrieve(@PathParam("id") Long id){
        var book = repo.findById(id);
        if(book != null ){
            return book;
        } else{
            throw new RuntimeException("Book not found con ese id");
        }

    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") Long id){
        if (repo.deleteById(id)){
            return "Book deleted";
        } else{
            return "no se ha podido borrar";
        }

    }

    @PUT
    @Path("{id}")
    public Book update(@PathParam("id") Long id, Book book){
        var updatebook = repo.findById(id);
        if ( updatebook != null  ){
            updatebook.setTitulo(book.getTitulo());
            updatebook.setNumPage(book.getNumPage());
            updatebook.setPubDate(book.getPubDate());
            updatebook.setDescription(book.getDescription());
            updatebook.setGenre(book.getGenre());
            repo.persist(updatebook);
            return updatebook;
        } else{
            throw new RuntimeException("Book not found con ese id");
        }
    }
    
}
