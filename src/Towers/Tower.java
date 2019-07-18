package src.Towers;

import java.util.ArrayList;
import java.util.List;
import src.Concomitants.Logger;
import src.Aircraft.Flyable;

public class Tower {
    private static List<Flyable> observers;
    public Logger log;

    public Tower() {
        log = new Logger("simulation.txt");
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> clonedObservers = new ArrayList<Flyable>(observers);

        for (int j = 0; j < clonedObservers.size(); j++) {
            clonedObservers.get(j).updateConditions();
        }
    }
}
