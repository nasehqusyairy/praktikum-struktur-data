class Mahasiswa {

  private long nim;
  private String nama;
  private String asal;

  public Mahasiswa(long nim, String nama, String asal) {
    this.nim = nim;
    this.nama = nama;
    this.asal = asal;
  }

  public void displayMhs() {
    System.out.println("NIM: " + nim);
    System.out.println("Nama: " + nama);
    System.out.println("Asal: " + asal);
    System.out.println();
  }

  public long getNim() {
    return nim;
  }

  public String getNama() {
    return nama;
  }

}

public class DataArray {

  private Mahasiswa[] mhs;
  private int nElemen;

  public DataArray(int max) {
    mhs = new Mahasiswa[max];
    nElemen = 0;
  }

  public Mahasiswa find(long searchNim) {
    int i;
    for (i = 0; i < nElemen; i++) {
      if (mhs[i].getNim() == searchNim) {
        break;
      }
    }
    if (i == nElemen) {
      return null;
    } else {
      return mhs[i];
    }
  }

  public void insert(long nim, String nama, String asal) {
    mhs[nElemen] = new Mahasiswa(nim, nama, asal);
    nElemen++;
  }

  public boolean delete(long searchNim) {
    int i;
    for (i = 0; i < nElemen; i++) {
      if (mhs[i].getNim() == searchNim) {
        break;
      }
    }
    if (i == nElemen) {
      return false;
    } else {
      for (int j = i; j < nElemen; j++) {
        mhs[j] = mhs[j + 1];
      }
      nElemen--;
      return true;
    }
  }

  public void displayArray() {
    for (int i = 0; i < nElemen; i++) {
      mhs[i].displayMhs();
    }
  }

  public void bubbleSort() {
    int batas, i;
    for (batas = nElemen - 1; batas > 0; batas--) {
      for (i = 0; i < batas; i++) {
        if (mhs[i].getNim() > mhs[i + 1].getNim()) {
          swap(i, i + 1);
        }
      }
    }
  }

  public void swap(int one, int two) {
    Mahasiswa temp = mhs[one];
    mhs[one] = mhs[two];
    mhs[two] = temp;
  }

  public void selectionSort() {
    int awal, i, min;
    for (awal = 0; awal < nElemen - 1; awal++) {
      min = awal;
      for (i = awal + 1; i < nElemen; i++) {
        if (mhs[i].getNim() < mhs[min].getNim()) {
          min = i;
        }
      }
      swap(awal, min);
    }
  }

  public void insertionSortByName() {
    int i, curIn;
    for (curIn = 1; curIn < nElemen; curIn++) {
      Mahasiswa temp = mhs[curIn];
      i = curIn;
      while (i > 0 && mhs[i - 1].getNama().compareToIgnoreCase(temp.getNama()) > 0) {
        mhs[i] = mhs[i - 1];
        i--;
      }
      mhs[i] = temp;
    }
  }

  public void insertionSortByName(boolean isAscending) {
    if (isAscending) {
      insertionSortByName();
    } else {
      int i, curIn;
      for (curIn = 1; curIn < nElemen; curIn++) {
        Mahasiswa temp = mhs[curIn];
        i = curIn;
        while (i > 0 && mhs[i - 1].getNama().compareToIgnoreCase(temp.getNama()) < 0) {
          mhs[i] = mhs[i - 1];
          i--;
        }
        mhs[i] = temp;
      }
    }
  }

  public static void main(String[] args) {

  }
}
