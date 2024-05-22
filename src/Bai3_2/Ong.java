package Bai3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Ong {
    private int diemMau;

    public Ong() {
        this.diemMau = 100; // Khởi tạo điểm máu cho mỗi con ong là 100
    }

    public int getDiemMau() {
        return diemMau;
    }

    public void truDiemMau(int amount) {
        diemMau -= amount;
    }

    public boolean conSong() {
        return diemMau > 0;
    }
}
