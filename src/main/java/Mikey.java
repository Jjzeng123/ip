import java.util.ArrayList;

import mikeyparts.Storage;
import mikeyparts.TaskList;
import mikeyparts.UI;
import mikeyparts.Parser;

public class Mikey {

    private UI ui = new UI();
    private Storage storage = new Storage();
    private TaskList tasklist = new TaskList();
    private Parser parser = new Parser();

    public void run() throws java.io.IOException {
        ui.welcomeMessage();
        storage.readFromFile();
        while (true) {
            parser.parseCommand();
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        new Mikey().run();
    }
}
