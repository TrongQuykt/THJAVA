package Bai3_2;

class OngChua extends Ong {
    private static final int DIEM_MAU_TOI_THIEU = 40;

    @Override
    public boolean conSong() {
        return super.conSong() && getDiemMau() >= DIEM_MAU_TOI_THIEU;
    }
}