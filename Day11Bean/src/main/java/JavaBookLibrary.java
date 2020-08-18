import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class JavaBookLibrary implements BookLibrary{

    private List<Book> books;

    public JavaBookLibrary(){

        books = Arrays.asList(new Book("book1",3.0),new Book("book2",5.0));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
