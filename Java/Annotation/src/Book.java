/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */
public class Book {
    @StringValueInjection("자바 입문")
    String title;

    @StringValueInjection("1234-1234-1234")
    String isbn;

    @StringValueInjection("용문사")
    String publisher;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }
}
