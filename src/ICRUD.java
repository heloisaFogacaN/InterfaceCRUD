import java.util.ArrayList;

public interface ICRUD<ID extends Integer, T> {

    void create(T t);

    T readOne(ID id);

    ArrayList<T> readAll();

    void upDate(ID id);

    void delete(ID id);


}
