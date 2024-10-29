package javacax;
import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getsurname().compareTo(h2.getsurname());
    }
}