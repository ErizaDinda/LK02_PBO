package LK;

import java.util.Scanner;

class Kendaraan {
    String platNomor;
    int jumlahPenumpang;
    Penumpang penumpang;
    Driver driver;
    String merk; 

    Kendaraan(String platNomor, int jumlahPenumpang, String merk, String namaDriver) {
        this.platNomor = platNomor;
        this.jumlahPenumpang = jumlahPenumpang;
        this.merk = merk; 
        penumpang = new Penumpang();
        driver = new Driver(namaDriver); 
        System.out.println("Halo saya " + this.driver.nama + " " + this.platNomor);
    }

    public void maju(){
        System.out.println(this.merk + " " + this.platNomor +" Maju");
    }

    public void mundur(){
        System.out.println(this.merk + " " + this.platNomor+ " Mundur");
    }

    public void belok(){
        System.out.println(this.merk + " " + this.platNomor+ " Belok");
    }

    public void berhenti(){
        System.out.println(this.merk + " " + this.platNomor+ " Berhenti");
    }

    void penumpangNaik(int naik) {
        if (jumlahPenumpang + naik > 30) {
            System.out.println("Penumpang melebihi kapasitas maksimum!");
        } else {
            jumlahPenumpang += naik;
            System.out.println("Penumpang ditambahkan");
        }
    }

    void penumpangTurun(int turun) {
        if (jumlahPenumpang - turun < 0) {
            throw new IllegalArgumentException("Jumlah penumpang tidak bisa kurang dari 0!");
        }
        jumlahPenumpang -= turun;
    }

    void infoPenumpang() {
        System.out.println("Jumlah penumpang: " + jumlahPenumpang);
    }

    void kapasitas() {
        System.out.println("Kapasitas kendaraan:30");
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Info jumlah penumpang");
            System.out.println("2. Kapasitas jumlah penumpang");
            System.out.println("3. Penumpang naik");
            System.out.println("4. Penumpang turun");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    infoPenumpang();
                    break;
                case 2:
                    kapasitas();
                    break;
                case 3:
                    System.out.print("Jumlah penumpang yang naik: ");
                    int naik = scanner.nextInt();
                    penumpangNaik(naik);
                    break;
                case 4:
                    System.out.print("Jumlah penumpang yang turun: ");
                    int turun = scanner.nextInt();
                    penumpangTurun(turun);
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 5);
        scanner.close();
    }
}

class Bus extends Kendaraan {
    String tipeBus;

    Bus(String platNomor, int jumlahPenumpang, String tipeBus, String namaDriver) {
        super(platNomor, jumlahPenumpang, "Bus", namaDriver);
        this.tipeBus = tipeBus;
    }

    void kapasitas() {
        System.out.println("Kapasitas Bus: 30");
    }

    void penumpangNaik(int naik) {
        if (jumlahPenumpang + naik > 30) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("Penumpang melebihi kapasitas!");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tolak semua penumpang");
            System.out.println("2. Terima sebagian penumpang");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            int sisa = 30 - jumlahPenumpang;
            switch (choice) {
                case 1:
                    System.out.println("Semua penumpang ditolak");
                    jumlahPenumpang = 30-sisa;
                    break;
                case 2:
                    System.out.println("Menerima sebagian penumpang");
                    System.out.println("Hanya " + sisa + " penumpang yang diterima");
                    jumlahPenumpang += sisa;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, penumpang ditolak");
                    jumlahPenumpang = 0;
            }
        } else {
            jumlahPenumpang += naik;
        }
    }
}

class Truk extends Kendaraan {
    int TipeTruk;

    Truk(String platNomor, int jumlahPenumpang, String namaDriver) {
        super(platNomor, jumlahPenumpang, "Truk", namaDriver);
        this.TipeTruk = TipeTruk;
    }

    void kapasitas() {
        System.out.println("Kapasitas Truk: 30");
    }

    void penumpangNaik(int naik) {
        if (jumlahPenumpang + naik > 30) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            System.out.println("Penumpang melebihi kapasitas!");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tolak semua penumpang");
            System.out.println("2. Terima sebagian penumpang");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            int sisa = 30 - jumlahPenumpang;
            switch (choice) {
                case 1:
                    System.out.println("Semua penumpang ditolak");
                    jumlahPenumpang = 30-sisa;
                    break;
                case 2:
                    System.out.println("Menerima sebagian penumpang");
                    System.out.println("Hanya " + sisa + " penumpang yang diterima");
                    jumlahPenumpang += sisa;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, penumpang ditolak");
                    jumlahPenumpang = 0;
            }
        } else {
            jumlahPenumpang += naik;
        }
    }
}

class Penumpang {
    String nama;
}

class Driver {
    String nama;

    Driver(String nama) {
        this.nama = nama;
    }
}

public class LK2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean menuShown = false;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Bus");
            System.out.println("2. Truk");
            System.out.println("3. Keluar");
            System.out.print("Pilih kendaraan: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Bus bus = new Bus("B 9496 KPA", 0, "AC", "Prawito Driver Bus Nopol");
                    bus.menu();
                    menuShown = true;
                    break;
                case 2:
                    Truk truk = new Truk("N 9395 UG", 0, "Boman Driver Truk Nopol");
                    truk.menu();
                    menuShown = true;
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 3 && !menuShown);
        scanner.close();
    }
}