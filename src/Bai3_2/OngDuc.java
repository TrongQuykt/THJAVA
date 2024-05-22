package Bai3_2;

class OngDuc extends Ong {
    private static final int DIEM_MAU_TOI_THIEU = 70;

    @Override
    public boolean conSong() {
        return super.conSong() && getDiemMau() >= DIEM_MAU_TOI_THIEU;
    }
}