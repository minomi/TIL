/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */
public class Book {
    @StringValueInjection("자바 입문")
    private String title;

    @StringValueInjection("1234-1234-1234")
    private String isbn;

    @StringValueInjection("용문사")
    private String publisher;

    @StringValueInjection("30000")
    private Integer price;

    String getTitle() {
        return title;
    }

    String getIsbn() {
        return isbn;
    }

    String getPublisher() {
        return publisher;
    }

    Integer getPrice() {
        return price;
    }
}
