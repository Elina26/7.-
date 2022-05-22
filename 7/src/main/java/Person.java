import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Person implements Serializable {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final int[] date;

    public Person(String surname, String name, String patronymic, int[] date) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.date = new int[]{date[0], date[1], date[2]};
    }

    public Person() {
        this.surname = null;
        this.name = null;
        this.patronymic = null;
        this.date = new int[]{0, 0, 0};
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public int[] getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "\n      Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date[YY.MM.DD]=" + date[0]+"."+date[1]+"."+date[2]+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getName(), person.getName()) && Objects.equals(getPatronymic(), person.getPatronymic()) && Arrays.equals(getDate(), person.getDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getSurname(), getName(), getPatronymic());
        result = 31 * result + Arrays.hashCode(getDate());
        return result;
    }
}
