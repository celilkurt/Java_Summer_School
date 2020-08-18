public class BookReader {

    private JavaBookLibrary instance;

    public BookReader(JavaBookLibrary javaBookLibrary){
        instance = javaBookLibrary;
    }

    public JavaBookLibrary getInstance() {
        return instance;
    }
}
