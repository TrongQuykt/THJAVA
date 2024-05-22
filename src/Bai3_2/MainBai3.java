package Bai3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainBai3
{
    private static final int SO_LUONG_ONG_CHUA = 40;
    private static final int SO_LUONG_ONG_THO = 40;
    private static final int SO_LUONG_ONG_DUC = 40;

    private List<Ong> danhSachOng = new ArrayList<>();
    // Khởi tạo danh sách đàn ong
    public MainBai3() {
        khoiTaoDanhSachOng();
    }
    // Phương thức khởi tạo danh sách đàn ong
    private void khoiTaoDanhSachOng() {
        for (int i = 0; i < SO_LUONG_ONG_CHUA; i++) {
            danhSachOng.add(new OngChua());
        }
        for (int i = 0; i < SO_LUONG_ONG_THO; i++) {
            danhSachOng.add(new OngTho());
        }
        for (int i = 0; i < SO_LUONG_ONG_DUC; i++) {
            danhSachOng.add(new OngDuc());
        }
    }

    // Phương thức tấn công đàn ong
    public void tanCongDanOng() {
        Random random = new Random();
        int soLuongOngConSong = 0;

        System.out.println("Danh sách đàn ong sau mỗi lần tấn công:");

        for (Ong ong : danhSachOng) {
            if (ong.conSong()) {
                soLuongOngConSong++;
                int matDiemMau = random.nextInt(81); // Giảm ngẫu nhiên từ 0 đến 80
                ong.truDiemMau(matDiemMau);
                System.out.println("Ong: " + ong.getClass().getSimpleName() + " - Trạng thái: " +
                        (ong.conSong() ? "Sống" : "Chết") + " - Điểm máu: " + ong.getDiemMau());
            }
        }
        System.out.println("Số lượng ong còn sống sau tấn công: " + soLuongOngConSong);
    }
    public static void main(String[] args) {
        MainBai3 game = new MainBai3();
        int luotTanCong = 1;

        while (true) {
            System.out.println("----- Lượt tấn công thứ " + luotTanCong + " -----");
            game.tanCongDanOng();
            luotTanCong++;

            // Kiểm tra xem còn ong nào sống không, nếu không thì kết thúc trò chơi
            boolean conOngSong = false;
            for (Ong ong : game.danhSachOng)
            {
                if (ong.conSong()) {
                    conOngSong = true;
                    break;
                }
            }
            if (!conOngSong) {
                System.out.println("Tất cả ong đã chết!");
                break;
            }

            // Tạm dừng để người chơi có thể theo dõi kết quả từng lượt tấn công
            System.out.println("Nhấn Enter để tiếp tục tấn công...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
