import java.util.Arrays;

class HighArray { // class HighArray
    private int[] arr; // deklarasi properti array bersifat private arr brtipe integer
    private int nElemen; // deklarasi properti nElmen bersifat private bertipe integer

    public HighArray(int max) { // method construct dari class HighArray dengn parameter max bertipe integer
        arr = new int[max]; // inisialisasi poperti arr dengan nilai berupa array integer dengan ukuran
                            // sesuai parameter max
        nElemen = 0; // inisialiasi properti nElemen dengan nilai 0
    }

    public void insert(int value) { // method public yang tidak mengembalika nilai bernama insert dengan parameter
                                    // value bertipe integer
        arr[nElemen] = value; // array arr dengan index sesuai nilai properti nElemen diisikan nilai sesuai
                              // dengan parameter value
        nElemen++; // nilai properti nElemen bertambah 1
    }

    public void insert(int value, boolean isOrdered) {
        if (!isOrdered) {
            insert(value);
        } else {
            insert(value);
            Arrays.sort(arr, 0, nElemen);
        }
    }

    public int getNElement() {
        return nElemen;
    }

    public boolean find(int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return true;

            if (arr[mid] > x)
                return find(l, mid - 1, x);

            return find(mid + 1, r, x);
        }

        return false;
    }

    public boolean find(int key) { // method public yang mngembalikan nilai boolean bernama find dengan parameter
                                   // key bertipe integer
        int i; // deklarasi variabel i bertipe integer
        for (i = 0; i < nElemen; i++) { // looping dengan for() dengan batas pengulangan hingga i < nElemen
            if (arr[i] == key) { // apabila nilai array arr berindex i sama dengan parameter key,...
                break; // apabila kondisi benar, maka loopin akan berhenti
            }
        }
        if (i == nElemen) { // apabila nilai i sama dengan nilai nElemen,...
            return false; // apabila kondis benar, maka kembalikan nilai false
        } else {
            return true; // apabila kondis salah, maka kembalikan nilai true
        }
    }

    public boolean delete(int value) { // method public yang mngembalikan nilai boolean bernama delete dengan parameter
                                       // value bertipe integer
        int i; // deklarasi variabel i bertipe integer
        for (i = 0; i < nElemen; i++) { // looping dengan for() dengan batas pengulangan hingga i < nElemen
            if (value == arr[i]) { // apabila nilai value sama dengan nilai arr dengan index i,...
                break; // apabila kondisi benar, maka looping akan berhenti
            }
        }
        if (i == nElemen) { // apabila nilai i sama dengan nilai nElemen,...
            return false; // apabila kondisi benar, maka kembalikan nilai false
        } else {
            for (int j = i; j < nElemen; j++) { // apabila kondisi salah, maka mulai looping dengan for() dengan batas
                                                // pengulangan j < nElemen
                arr[j] = arr[j + 1]; // ganti nilai arr pada index dengan nilai dari arr dengan index j+1
            }
            nElemen--; // nilai nElemen berkurang 1
            return true; // kembalikan nilai true
        }
    }

    public void display() { // method public yang tidak mengembalika nilai bernama display
        for (int i = 0; i < nElemen; i++) { // looping dengan for() dengan batas pengulangan hingga i < nElemen
            System.out.print(arr[i] + " "); // tampilkan nilai arr dengan index i kemudian berikan spasi tanpa
                                            // meninggalkan baris
        }
        System.out.println(""); // tampilkan baris kosong
    }

    public int size() {
        return nElemen;
    }

    // Praktikum 2
    public void bubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) { // perulangan mundur
            for (i = 0; i < batas; i++) { // perulangan maju

                // bandingkan nilai array di index saat ini dengan setelahnya
                if (arr[i] > arr[i + 1]) {

                    // jika lebih besar, tukar posisi
                    swap(i, i + 1);
                }
                display();
            }
        }
    }

    public void bubbleSort(boolean isAscending) {
        if (isAscending) {
            bubbleSort();
        } else {
            int batas, i;
            for (batas = nElemen - 1; batas > 0; batas--) {
                for (i = 0; i < batas; i++) {
                    if (arr[i] < arr[i + 1]) { // operator perbandingan akan mempengaruhi urutan jika diubah
                        swap(i, i + 1);
                    }
                    display();
                }
            }
        }
    }

    public void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public void selectionSort() {
        int awal, i, min;
        // perulangan
        for (awal = 0; awal < nElemen - 1; awal++) {
            // tandai index awalan
            min = awal;
            // perulangan dimulai dari index berikutnya
            for (i = awal + 1; i < nElemen; i++) {
                // cari nilai terkecil
                if (arr[i] < arr[min]) {
                    // ganti index
                    min = i;
                }
            }
            // tukar nilai terkecil ke index yang sedang melakukan perbandingan
            swap(awal, min);
            display();
        }
    }

    public void insertionSort() {
        int i, curIn;
        // perulangan
        for (curIn = 1; curIn < nElemen; curIn++) {
            // tampung nilai saat ini ke dalam variabel sementara
            int temp = arr[curIn];
            i = curIn;

            // perulangan (kanan ke kiri) untuk membandingkan nilai sebelumnya
            System.out.println("tahap" + curIn);
            while (i > 0 && arr[i - 1] >= temp) {

                // jika ditemukan nilai lebih besar, ganti nilainya
                arr[i] = arr[i - 1];
                display();
                i--;
            }

            // posisi nilai yang tadinya lebih besar diisi dengan nilai yang membandingkan
            arr[i] = temp;
            display();
        }
    }

}

public class HighArrayApp { // public class HighArrayApp (class utama)
    public static void main(String[] args) { // main method
        int maxSize = 100; // inisialisasi variabel maxsize dengn nilai integer 100
        HighArray arr; // deklarasi variabel arr yang mereferensikan class HighArray
        arr = new HighArray(maxSize); // pembentukan objek arr dengan memasukkan maxsize sebagai parameter
        arr.insert(70); // jalankan method insert() dengan parameter suatu angka
        arr.insert(80); // jalankan method insert() dengan parameter suatu angka
        arr.insert(75); // jalankan method insert() dengan parameter suatu angka
        arr.insert(55); // jalankan method insert() dengan parameter suatu angka
        arr.insert(85); // jalankan method insert() dengan parameter suatu angka
        arr.insert(25); // jalankan method insert() dengan parameter suatu angka
        arr.insert(30); // jalankan method insert() dengan parameter suatu angka
        arr.insert(00); // jalankan method insert() dengan parameter suatu angka
        arr.insert(90); // jalankan method insert() dengan parameter suatu angka
        arr.insert(40); // jalankan method insert() dengan parameter suatu angka
        arr.display(); // jalankan method display()
        int key = 25; // inisialisasi variabel key dengn nilai integer 25
        if (arr.find(key)) { // pengkondisian dengan method find() dengan parameter variabel key
            System.out.println(key + " ditemukan"); // tampilkan nilai key dan tulisan ' ditemukan!'
        } else { // apabila kondisi salah, maka...
            System.out.println(key + " tidak ditemukan"); // tampilkan nilai key dan tulisan ' ditemukan!'
        }
        arr.delete(00); // jalankan method delete() dengan parameter suatu angka
        arr.delete(80); // jalankan method delete() dengan parameter suatu angka
        arr.delete(55); // jalankan method delete() dengan parameter suatu angka
        arr.display(); // jalankan method display()
        System.out.println(arr.size());
        arr.insert(10, true);
        arr.display();
        System.out.println("binarySearch:");
        if (arr.find(0, arr.getNElement(), key)) { // pengkondisian dengan method find() dengan parameter variabel key
            System.out.println(key + " ditemukan"); // tampilkan nilai key dan tulisan ' ditemukan!'
        } else { // apabila kondisi salah, maka...
            System.out.println(key + " tidak ditemukan"); // tampilkan nilai key dan tulisan ' ditemukan!'
        }
    }

}
