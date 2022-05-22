import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private List<Flat> flats;
    private Person headOfTheHouse;

    public House(String cadastralNumber, String address, List<Flat> flats, Person headOfTheHouse) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.flats = flats;
        this.headOfTheHouse = headOfTheHouse;
    }

    public House() {
        this.cadastralNumber = null;
        this.address = null;
        this.flats = null;
        this.headOfTheHouse = null;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }
    public String getAddress() {
        return address;
    }
    public List<Flat> getFlats() {
        return flats;
    }
    public Person getHeadOfTheHouse() {
        return headOfTheHouse;
    }

    @Override
    public String toString() {
        return "\nHouse{" +
                "cadastralNumber='" + cadastralNumber + '\'' +
                ", address='" + address + '\'' +
                ", flats=" + flats +
                ", \nheadOfTheHouse=" + headOfTheHouse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Objects.equals(getCadastralNumber(), house.getCadastralNumber()) && Objects.equals(getAddress(), house.getAddress()) && Objects.equals(getFlats(), house.getFlats()) && Objects.equals(getHeadOfTheHouse(), house.getHeadOfTheHouse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCadastralNumber(), getAddress(), getFlats(), getHeadOfTheHouse());
    }
}
