/**
 * inspiration for creating a new task class was derived from a senior's advice when consulted for help
 * senior consulted was Jonathan, github.com/wutdequack/ip
 * task class further improved with notes from course website https://nus-cs2113-ay2223s2.github.io/website/schedule/
 * week3/project.html
 */

public class Task {
    public String name;
    protected String description;
    protected boolean isDone;

    public Task(String name) {
        setName(name);
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void taskDone() {
        this.isDone = true;
    }
}
