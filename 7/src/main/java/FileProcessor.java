import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*ИСПРАВИТЬ!!!
* 1) в 1 задании ломается если вводить какие то большие числа.
* 2) во 2 задании нужны массивы типа char
* 3) в 9 файле исправить ВСЕ. интерфейс только для последнего метода.
* p.s. 6 и 8 файлы СДАНЫ!!!
* */


public class FileProcessor {
    /*1. Записать массив целых чисел в двоичный поток. Прочитать массив целых чисел из
     *   двоичного потока. Предполагается, что до чтения массив уже создан, нужно прочитать n
     *   чисел, где n — длина массива. */

    //метод записывает массив arr в двоичный поток
    public void method_1_writer(int[] arr, String fileName) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i : arr) {
                outputStream.writeInt(i);
            }
        }
    }

    //метод читает массив в arr из двоичного потока
    void method_1_reader(int[] arr, String fileName) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            for (int i = 0; i <= arr.length; i++) {
                arr[i] = inputStream.readInt();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /*2. Аналогично, используя символьные потоки. В потоке числа должны разделяться
     *   пробелами.*/

    //метод записывает массив arr в символьный поток writer
    void method_2_writer(int[] array, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (int i : array) {
                String s = Integer.toString(i);
                writer.write(s);
                writer.write(" ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //метод читает в массив arr из символьного потока reader
    void method_2_reader(int[] arr, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] split = reader.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //3. Используя класс RandomAccessFile, прочитайте массив целых чисел, начиная с заданной позиции.
    void method_3(int[] arr, String fileName, int index) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(fileName), "r");
        randomAccessFile.seek(index);

        for (int i=0; i < arr.length; i++) {
            arr[i] = randomAccessFile.readInt();
            //System.out.println(arr[i]);
        }
    }

    /*4. Используя класс File, получите список всех файлов с заданным расширением(filter) в заданном
     *   каталоге (поиск в подкаталогах выполнять не надо).*/
    List<File> method_4(String path, String filter) {
        File dir = new File(path); //path указывает на директорию
        List<File> lst = new ArrayList<>();
        for (File f : dir.listFiles()) {
            if ((f.isFile()) && (f.getName().endsWith(filter)))
                lst.add(f);
        }
        return lst;
    }
}