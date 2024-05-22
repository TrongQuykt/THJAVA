package Bai2;
import java.time.LocalDate;
import java.time.Period;

public class XeOto extends Xe {
    private int soGhe;
    private boolean kinhDoanh;

    public XeOto(LocalDate ngaySx, String bienSo, int soGhe, boolean kinhDoanh) {
        super(ngaySx, bienSo);
        this.soGhe = soGhe;
        this.kinhDoanh = kinhDoanh;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public boolean isKinhDoanh() {
        return kinhDoanh;
    }

    public void setKinhDoanh(boolean kinhDoanh) {
        this.kinhDoanh = kinhDoanh;
    }

    @Override
    public String toString() {
        return "XeOto{" +
                "ngaySx=" + getNgaySx() +
                ", bienSo='" + getBienSo() + '\'' +
                ", soGhe=" + soGhe +
                ", kinhDoanh=" + kinhDoanh +
                '}';
    }

    @Override
    public int getPhiDangKiem() {
        if (soGhe <= 10) {
            return 240000;
        } else {
            return 320000;
        }
    }

    @Override
    public int getThoiHanDangKiem() {
        int years = Period.between(getNgaySx(), LocalDate.now()).getYears();
        if (years <= 7) {
            if (soGhe <= 9) {
                if (kinhDoanh) {
                    return 12; // 1 năm
                } else {
                    return 24; // 2 năm
                }
            } else {
                return 12; // 1 năm
            }
        } else {
            return 6; // 6 tháng
        }
    }
}
