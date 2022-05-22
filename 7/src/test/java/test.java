import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    FileProcessor fileProcessor = new FileProcessor();

    @Test //ЗАДАНИЕ 1
    public void test1() throws IOException {
        String nameFileInt = "FileInt.txt";
        int[] arrInt = {25,9000,-183};
        int[] arrInt2 = new int[arrInt.length];

        fileProcessor.method_1_writer(arrInt, nameFileInt);  //записываем arrInt в "FileInt.txt"
        fileProcessor.method_1_reader(arrInt2, nameFileInt); //записываем массив из "FileInt.txt" в arrInt2

        assertArrayEquals(arrInt, arrInt2);
    }

    @Test //ЗАДАНИЕ 2
    public void test2() {
        String nameFileInt2 = "FileInt2.txt";
        int[] arrInt = {25,9000,3};
        int[] arrInt2 = new int[arrInt.length];
        fileProcessor.method_2_writer(arrInt, nameFileInt2);  //записываем arrInt в "FileInt2.txt"
        fileProcessor.method_2_reader(arrInt2, nameFileInt2); //записываем массив из "FileInt2.txt" в arrChar2
        assertArrayEquals(arrInt, arrInt2);
    }

    @Test //ЗАДАНИЕ 3
    public void test3() throws IOException {
        String nameFileInt = "FileInt.txt";
        int[] arrInt = {25,9000,-183,50};
        int[] arrInt2 = new int[3];
        int[] arrInt3 = new int[2];

        fileProcessor.method_1_writer(arrInt, nameFileInt);  //записываем arrInt в "FileInt.txt"
        fileProcessor.method_3(arrInt2, nameFileInt, 4); //записываем массив из "FileInt.txt" в arrInt2 с 9000
        fileProcessor.method_3(arrInt3, nameFileInt, 8); //записываем массив из "FileInt.txt" в arrInt2 с -183

        assertArrayEquals(arrInt2, new int[]{9000,-183,50});
        assertArrayEquals(arrInt3, new int[]{-183,50});
    }

    @Test //ЗАДАНИЕ 4
    public void test4() {
        String path = "C:/Users/Lenovo/IdeaProjects/2 семестр/7";
        String filter0 = ".txt";
        FileProcessor fileProcessor = new FileProcessor();
        List<File> listTXT =  fileProcessor.method_4(path, filter0);
        assertEquals(listTXT.get(0).getName(), "fileHouse.txt");
        assertEquals(listTXT.get(1).getName(),"fileInt.txt");
        assertEquals(listTXT.get(2).getName(),"FileInt2.txt");
        assertEquals(listTXT.get(3).getName(),"Letter.txt");

        String filter1 = ".xml";
        List<File> listXML =  fileProcessor.method_4(path, filter1);
        assertEquals(listXML.get(0).getName(), "pom.xml");

        String filter2 = ".bin";
        List<File> listBIN =  fileProcessor.method_4(path, filter2);
        assertEquals(listBIN.get(0).getName(), "integers.bin");
    }

    @Test //ЗАДАНИЕ 6
    public void test6() throws IOException, ClassNotFoundException {
        HouseService houseService = new HouseService();

        Person person1 = new Person("Иванов", "Иван", "Иваныч",
                new int[] {1971,1,1});
        Person person2 = new Person("Петров", "Петр", "Петрович",
                new int[] {1972,2,2});
        Person person3 = new Person("Петрова", "Мария", "Степановна",
                new int[] {1973,3,3});
        Person person4 = new Person("Лукина", "Валерия", "Сергеевна",
                new int[] {1974,4,4});


        // В квартире 1 живет person1.
        // В квартире 23 живут person2 и person3.
        // В квартире 4 живет person4.
        //
        List<Person> list1 = new ArrayList<>();
        list1.add(person1);
        Flat flat1 = new Flat(1, 37.2, list1);


        List<Person> list23 = new ArrayList<>();
        list23.add(person2);
        list23.add(person3);
        Flat flat23 = new Flat(23, 50.8, list23);

        List<Person> list4 = new ArrayList<>();
        list4.add(person4);
        Flat flat4 = new Flat(1, 37.2, list4);


        //flats - список квартир в доме
        List<Flat> flats = new ArrayList<>();
        flats.add(flat1);
        flats.add(flat23);
        flats.add(flat4);


        //дом
        House house = new House("22:22:7777777:4444", "221b, Baker street", flats,
                new Person("Главный", "По", "Дому",
                        new int[] {1976,12,25}));

        String fileHouseName = "fileHouse.txt";
        File fileHouse = new File(fileHouseName);
        FileOutputStream outputStreamHouse = new FileOutputStream(fileHouse);

        //сереализируем в "fileHouse.txt"
        houseService.serialization(house, outputStreamHouse);

        //десериализируем в новый дом newHouse
        FileInputStream inputStreamHouse = new FileInputStream(fileHouse);
        //ObjectInputStream objectInputStream = new ObjectInputStream(inputStreamHouse);
        House newHouse = houseService.deserialization(inputStreamHouse);

        assertEquals(house, newHouse);
    }

    @Test //ЗАДАНИЕ 8
    public void test8() throws IOException {
        HouseService houseService = new HouseService();

        Person person1 = new Person("Иванов", "Иван", "Иваныч",
                new int[] {1971,1,1});
        Person person2 = new Person("Петров", "Петр", "Петрович",
                new int[] {1972,2,2});
        Person person3 = new Person("Петрова", "Мария", "Степановна",
                new int[] {1973,3,3});
        Person person4 = new Person("Лукина", "Валерия", "Сергеевна",
                new int[] {1974,4,4});


        // В квартире 1 живет person1.
        // В квартире 23 живут person2 и person3.
        // В квартире 4 живет person4.
        //
        List<Person> list1 = new ArrayList<>();
        list1.add(person1);
        Flat flat1 = new Flat(1, 37.2, list1);


        List<Person> list23 = new ArrayList<>();
        list23.add(person2);
        list23.add(person3);
        Flat flat23 = new Flat(23, 50.8, list23);

        List<Person> list4 = new ArrayList<>();
        list4.add(person4);
        Flat flat4 = new Flat(1, 37.2, list4);


        //flats - список квартир в доме
        List<Flat> flats = new ArrayList<>();
        flats.add(flat1);
        flats.add(flat23);
        flats.add(flat4);


        //дом
        House house = new House("22:22:7777777:4444", "221b, Baker street", flats,
                new Person("Главный", "По", "Дому",
                        new int[] {1976,12,25}));

        //сереализируем в строку
        String str = houseService.serializationStringJackson(house);

        //десериализируем в новый дом newHouse
        House newHouse1 = houseService.deserializationStringJackson(str);

        assertEquals(house, newHouse1);
    }
}
