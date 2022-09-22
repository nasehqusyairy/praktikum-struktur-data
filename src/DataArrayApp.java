public class DataArrayApp {
  public static void main(String[] args) {
    int maxSize = 100;
    DataArray arr;
    arr = new DataArray(maxSize);
    arr = new DataArray(maxSize);
    arr.insert(16650200, "Jundi", "Malang");
    arr.insert(16650280, "Arina", "Malang");
    arr.insert(16650220, "Ismail", "Banyuwangi");
    arr.insert(16650210, "Ahmad", "Sidoarjo");
    arr.insert(16650230, "Sofi", "Semarang");
    arr.insert(16650250, "Rais", "Ambon");
    arr.insert(16650240, "Dinda", "Bandung");
    arr.insert(16650270, "Agung", "Madiun");
    arr.insert(16650260, "Helmi ", "Madura");

    // arr.displayArray();

    // long searchKey = 16650270;
    // Mahasiswa mhs = arr.find(searchKey);
    // if (mhs != null) {
    // System.out.print("\nketemu");
    // mhs.displayMhs();
    // } else {
    // System.out.println("Ga ketemu " + searchKey);
    // }

    // searchKey = 16650240;
    // System.out.println("\nhapus nim: " + searchKey);
    // arr.delete(searchKey);

    // arr.displayArray();

    // System.out.println("bubbleSort");
    // System.out.println("----------");
    // arr.bubbleSort();
    // arr.displayArray();

    // System.out.println("selectionSort");
    // System.out.println("-------------");
    // arr.selectionSort();
    // arr.displayArray();

    System.out.println("insertionSortByName");
    System.out.println("-------------");
    arr.insertionSortByName();
    arr.displayArray();
  }
}
