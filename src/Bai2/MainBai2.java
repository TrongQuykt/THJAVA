package Bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainBai2 {
    private static List<Xe> listXe = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu vào danh sách xe
        listXe.add(new XeOto(LocalDate.of(2020, 1, 10), "30A-12345", 5, true));
        listXe.add(new XeOto(LocalDate.of(2021, 5, 15), "30B-54321", 7, false));
        listXe.add(new XeTai(LocalDate.of(2019, 8, 20), "29C-67890", 10));
        listXe.add(new XeTai(LocalDate.of(2022, 11, 25), "29D-09876", 15));
        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. Thêm xe ô tô.");
            System.out.println("2. Thêm xe tải.");
            System.out.println("3. Xuất danh sách hiển thị thông tin tất cả các xe.");
            System.out.println("4. Lưu thông tin xe ra file.");
            System.out.println("5. Tìm xe ô tô có số chỗ ngồi nhiều nhất (nếu có).");
            System.out.println("6. Sắp xếp danh sách xe tải theo trọng tải tăng dần.");
            System.out.println("7. Xuất danh sách các biển số xe đẹp.");
            System.out.println("8. Tính số tiền đăng kiểm định kỳ của từng xe đến thời điểm hiện tại.");
            System.out.println("9. Tính thời gian đăng kiểm định kỳ của từng xe sắp tới.");
            System.out.println("10. Tính tổng số tiền đã đăng kiểm.");
            System.out.println("0. Thoát.");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addXeOto();
                    break;
                case 2:
                    addXeTai();
                    break;
                case 3:
                    System.out.println("Danh sách thông tin xe");
                    showAllXe();
                    break;
                case 4:
                    saveXeToFile();
                    break;
                case 5:
                    findXeOtoMaxGhe();
                    break;
                case 6:
                    sortXeTaiByTrongTai();
                    break;
                case 7:
                    findBienSoDep();
                    break;
                case 8:
                    tinhSoTienDangKiem();
                    break;
                case 9:
                    tinhThoiGianDangKiemTiepTheo();
                    break;
                case 10:
                    tinhTongSoTienDangKiem();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addXeOto() {
        System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): ");
        LocalDate ngaySx = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập biển số: ");
        String bienSo = scanner.nextLine();
        System.out.print("Nhập số ghế: ");
        int soGhe = scanner.nextInt();
        System.out.print("Có đăng ký kinh doanh vận tải không (true/false): ");
        boolean kinhDoanh = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        listXe.add(new XeOto(ngaySx, bienSo, soGhe, kinhDoanh));
        System.out.println("Thêm xe ô tô thành công.");
    }

    private static void addXeTai() {
        System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): ");
        LocalDate ngaySx = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập biển số: ");
        String bienSo = scanner.nextLine();
        System.out.print("Nhập trọng tải: ");
        int trongTai = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        listXe.add(new XeTai(ngaySx, bienSo, trongTai));
        System.out.println("Thêm xe tải thành công.");
    }

    private static void showAllXe() {
        listXe.forEach(System.out::println);
    }

    private static void saveXeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("xe.txt"))) {
            for (Xe xe : listXe) {
                writer.write(xe.toString());
                writer.newLine();
            }
            System.out.println("Lưu thông tin xe ra file thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu thông tin xe: " + e.getMessage());
        }
    }

    private static void findXeOtoMaxGhe() {
        listXe.stream()
                .filter(XeOto.class::isInstance)
                .map(xe -> (XeOto) xe)
                .max(Comparator.comparingInt(XeOto::getSoGhe))
                .ifPresentOrElse(
                        xe -> System.out.println("Xe ô tô có nhiều ghế nhất: " + xe),
                        () -> System.out.println("Không có xe ô tô nào"));
    }

    private static void sortXeTaiByTrongTai() {
        listXe.stream()
                .filter(XeTai.class::isInstance)
                .map(xe -> (XeTai) xe)
                .sorted(Comparator.comparingInt(XeTai::getTrongTai))
                .forEach(XeTai::output);
    }

    private static void findBienSoDep() {
        listXe.stream()
                .filter(xe -> {
                    String bienSo = xe.getBienSo();
                    if (bienSo.matches(".*\\d{4}.*")) {
                        String last5 = bienSo.replaceAll(".*[^\\d](\\d{5})$", "$1");
                        return last5.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                                .values().stream()
                                .anyMatch(count -> count >= 4);
                    }
                    return false;
                })
                .forEach(System.out::println);
    }


    private static void tinhSoTienDangKiem() {
        listXe.forEach(xe -> {
            System.out.println(xe + " - Số tiền đăng kiểm định kỳ: " + xe.tinhTongTienDangKiem() + "₫");
        });
    }

    private static void tinhThoiGianDangKiemTiepTheo() {
        listXe.forEach(xe -> {
            System.out.println(xe + " - Thời gian đăng kiểm tiếp theo: " + xe.getNgayDangKiemTiepTheo());
        });
    }

    private static void tinhTongSoTienDangKiem() {
        int total = listXe.stream().mapToInt(Xe::tinhTongTienDangKiem).sum();
        System.out.println("Tổng số tiền đã đăng kiểm: " + total + "₫");
    }
}
