import java.util.List;
import java.util.ArrayList;

public class Tower {
    private static List<Flyable> observers = new ArrayList<Flyable>();
    public static Path file = Paths.get("simulations.txt");

    Tower() {
        
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> clonedObservers = observers.clone();
        for (int j = 0; j < clonedObservers.size(); j++) {
            clonedObservers.get(j).updateConditions();
        }

        // int listLength = observers.size();
        // for (int i = 0; i < listLength; i++) {
        //     observer.updateConditions();
        //     i -= (listLength-- - observers.size());
        // }
    }
}
