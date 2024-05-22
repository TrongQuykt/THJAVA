import java.util.Scanner;

public class Book
{
    private int id;

    private String title;
    private String author;
    private long price;
    public Book(int id, long price, String author, String title)
    {
        this.id = id;
        this.price = price;
        this.author = author;
        this.title = title;
    }

    public Book() {

    }

    public String getTitle()
    {
        return title;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên sách: ");
        title = sc.nextLine();
        System.out.print("Nhập tên tác giả: ");
        author = sc.nextLine();
        System.out.print("Nhập giá sách: ");
        price = sc.nextLong();
    }
    public void output() {
//        var msg = """
//        BOOK: id=%d, title=%s, author=%s, price=%d
//        """.formatted(id, title, author, price);
//                System.out.println(msg);
        System.out.println("Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + "}");
    }
}
