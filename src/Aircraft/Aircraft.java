package src.Aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private long nextId() {
        if (idCounter == 0L) {
            idCounter = 1;
        }
        return idCounter++;
    }
}
