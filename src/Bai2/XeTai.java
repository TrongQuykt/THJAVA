package Bai2;
import java.time.LocalDate;
import java.time.Period;

public class XeTai extends Xe {
    private int trongTai;

    public XeTai(LocalDate ngaySx, String bienSo, int trongTai) {
        super(ngaySx, bienSo);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                "ngaySx=" + getNgaySx() +
                ", bienSo='" + getBienSo() + '\'' +
                ", trongTai=" + trongTai +
                '}';
    }

    @Override
    public int getPhiDangKiem() {
        if (trongTai > 20) {
            return 560000;
        } else if (trongTai >= 7) {
            return 350000;
        } else {
            return 320000;
        }
    }

    @Override
    public int getThoiHanDangKiem() {
        int years = Period.between(getNgaySx(), LocalDate.now()).getYears();
        if (years <= 20) {
            return 6; // 6 tháng
        } else {
            return 3; // 3 tháng
        }
    }

    // Thêm phương thức output
    public void output() {
        System.out.println(this.toString());
    }
}
