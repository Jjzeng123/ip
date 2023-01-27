/**
 * inspiration for creating a new task class was derived from a senior's advice when consulted for help
 * senior consulted was Jonathan, github.com/wutdequack/ip
 */

public class Task {
    public String name;
    public Task(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
