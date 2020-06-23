package br.mack.resources;

import br.mack.api.Book;
import br.mack.api.Book.db.BookDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
       BookDao bookDao;

        public BookResource(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @GET
        public Response getBooks() {
            List<Book> allProducts = bookDao.getAllBooks();
            return Response.ok(allProducts).build();
        }

        @POST
        public Response createBook(Book book) {
            if (book == null) {
                throw new BadRequestException("Book data missing");
            }
            long id = bookDao.insert(book);
            book = bookDao.findById(id);

            if (book == null) {
                throw new WebApplicationException("Problem creating product");
            }

            return Response.ok(book).build();
        }

        @GET
        @Path("/{id}")
        public Response getBook(@PathParam("id") int id) {
            Book book = bookDao.findById(id);

            if (book == null)
                throw new WebApplicationException("product does not exist", Response.Status.NOT_FOUND);

            return Response.ok(book).build();
        }

        @DELETE
        @Path("/{id}")
        public Response deleteProduct(@PathParam("id") long id){
            bookDao.delete(id);
            return Response.ok().build();
        }
}
