import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private int number;
    private double area;
    private List<Person> tenants;

    public Flat(int number, double area, List<Person> tenants) {
        this.number = number;
        this.area = area;
        this.tenants = tenants;
    }

    public Flat() {
        this.number = 0;
        this.area = 0;
        this.tenants = null;
    }

    public int getNumber() {
        return number;
    }
    public double getArea() {
        return area;
    }
    public List<Person> getTenants() {
        return tenants;
    }

    @Override
    public String toString() {
        return "\n   Flat{" +
                "number=" + number +
                ", area=" + area +
                ", tenants=" + tenants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat flat)) return false;
        return getNumber() == flat.getNumber() && Double.compare(flat.getArea(), getArea()) == 0 && Objects.equals(getTenants(), flat.getTenants());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getArea(), getTenants());
    }
}
