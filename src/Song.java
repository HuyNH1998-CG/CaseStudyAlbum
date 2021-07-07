import java.io.Serializable;

public class Song implements Serializable {
    private String name;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Song: " +
                name;
    }
}
