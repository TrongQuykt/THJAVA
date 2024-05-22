import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    // Thêm dữ liệu mẫu vào danh sách
    public static void main(String[] args)
    {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, 25L, "Trọng Qúy", "Lập trình"));
        books.add(new Book(2, 18L, "Harper Lee", "To Kill a Mockingbird"));
        books.add(new Book(3, 20L, "F. Scott Fitzgerald", "The Great Gatsby"));
        books.add(new Book(4, 15L, "Nguyễn Văn A", "Lập trình Java cơ bản"));
        books.add(new Book(5, 30L, "Robert C. Martin", "Clean Code"));
        var scanner = new Scanner(System.in);
        var msg = """
        Chương trình quản lý sách
        1. Thêm 1 cuốn sách
        2. Xoá 1 cuốn sách
        3. Sửa đổi thông tin 1 cuốn sách
        4. Xuất danh sách tất cả các cuốn sách
        5. Tìm kiếm sách "Lập trình"
        6. Lấy sách tối đa theo giá
        7. Tìm kiếm sách theo tên tác giả
        8. Tìm kiếm sách theo tên sách
        0. Thoát
        Chọn chức năng:""";
        int choice;
        do {
            System.out.print(msg);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                {
                    var book = new Book();
                    book.input();
                    books.add(book);
                }
                case 2 ->
                {
                    System.out.print("Nhập mã sách cần xoá: ");
                    var id = Integer.parseInt(scanner.nextLine());
                    books.stream()
                            .filter(book -> book.getId() == id)
                            .findFirst()

                            .ifPresent(books::remove);

                    System.out.println("Đã xoá sách có mã " + id);
                }
                case 3 ->
                {
                    System.out.print("Nhập mã sách: ");
                    var id = scanner.nextInt();
                    scanner.nextLine();
                    books.stream()
                            .filter(book -> book.getId() == id)
                            .findFirst()

                            .ifPresent(Book::input);

                    System.out.println("Đã thay đổi thông tin sách!");
                }
                case 4 ->
                {
                    System.out.println("Thông tin tất cả cuốn sách: ");
                    books.forEach(System.out::println);
                }
                case 5 ->
                {
                    System.out.println("Thông tin các sách có chứa \"Lập trình\": ");
                    books.stream()
                            .filter(book -> book.getTitle().contains("Lập trình"))
                            .forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhập giá tối đa: ");
                    var maxPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Các sách có giá nhỏ hơn hoặc bằng " + maxPrice + ": ");
                    books.stream()
                            .filter(book -> book.getPrice() <= maxPrice)
                            .forEach(Book::output);
                }
                case 7 -> {
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    var authorName = scanner.nextLine();
                    System.out.println("Các sách của tác giả \"" + authorName + "\": ");
                    books.stream()
                            .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                            .forEach(Book::output);
                }
                case 8 -> {
                    System.out.print("Nhập tên sách cần tìm: ");
                    var bookTitle = scanner.nextLine();
                    System.out.println("Các sách có tên \"" + bookTitle + "\": ");
                    books.stream()
                            .filter(book -> book.getTitle().equalsIgnoreCase(bookTitle))
                            .forEach(Book::output);
                }
                case 0 -> System.out.println("Đã thoát");
                default -> throw new IllegalStateException();
            }
        } while (choice != 0);
    }
}