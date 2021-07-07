import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable {
    private List<Song> list = new ArrayList<>();
    private String name;
    private final String owner;
    @Serial
    private static final long serialVersionUID = 1;

    public Album(String name, String user) {
        this.name = name;
        this.owner = user;
    }

    public List<Song> getList() {
        return list;
    }

    public void setList(List<Song> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void addSong(String name) {
        this.list.add(new Song(name));
    }

    public void display() {
        System.out.println("Album: " + getName());
        for (Song song : list) {
            System.out.println(song);
        }
    }

    @Override
    public String toString() {
        return "Album" +
                " name: " + name +
                " owned by " + owner;
    }
}
