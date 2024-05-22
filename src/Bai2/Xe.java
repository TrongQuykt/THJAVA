package Bai2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Xe {
    private LocalDate ngaySx;
    private String bienSo;

    public Xe(LocalDate ngaySx, String bienSo) {
        this.ngaySx = ngaySx;
        this.bienSo = bienSo;
    }

    public LocalDate getNgaySx() {
        return ngaySx;
    }

    public void setNgaySx(LocalDate ngaySx) {
        this.ngaySx = ngaySx;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "ngaySx=" + ngaySx +
                ", bienSo='" + bienSo + '\'' +
                '}';
    }

    public abstract int getPhiDangKiem();
    public abstract int getThoiHanDangKiem();
    public int getSoLanDangKiemDenHienTai() {
        LocalDate currentDate = LocalDate.now();
        int soLan = 0;
        LocalDate ngayDangKiemKeTiep = getNgaySx().plusMonths(getThoiHanDangKiem());
        while (ngayDangKiemKeTiep.isBefore(currentDate)) {
            soLan++;
            ngayDangKiemKeTiep = ngayDangKiemKeTiep.plusMonths(getThoiHanDangKiem());
        }
        return soLan;
    }
    public LocalDate getNgayDangKiemTiepTheo() {
        LocalDate currentDate = LocalDate.now();
        LocalDate ngayDangKiemKeTiep = getNgaySx().plusMonths(getThoiHanDangKiem());
        while (ngayDangKiemKeTiep.isBefore(currentDate)) {
            ngayDangKiemKeTiep = ngayDangKiemKeTiep.plusMonths(getThoiHanDangKiem());
        }
        return ngayDangKiemKeTiep;
    }
    public int tinhTongTienDangKiem() {
        return getSoLanDangKiemDenHienTai() * getPhiDangKiem();
    }
}

