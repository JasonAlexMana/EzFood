package com.example.uts;

public class DataHolder {
    private static int airMineral = 0, jusApel = 0, jusMangga = 0, jusAlpukat = 0;

    public static int getAirMineral() {
        return airMineral;
    }

    public static void setAirMineral(int x) {
        airMineral = x;
    }

    public static int getJusApel() {
        return jusApel;
    }

    public static void setJusApel(int x) {
        jusApel = x;
    }

    public static int getJusMangga() {
        return jusMangga;
    }

    public static void setJusMangga(int x) {
        jusMangga = x;
    }

    public static int getJusAlpukat() {
        return jusAlpukat;
    }

    public static void setJusAlpukat(int x) {
        jusAlpukat = x;
    }

    public static int getTotal() {
        return (airMineral + jusAlpukat + jusApel + jusMangga) * 123;
    }
}
