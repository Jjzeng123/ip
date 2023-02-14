import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Mikey {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public static Task newTodo(String taskName) {
        Task newTask = null;
        newTask = new Todo(taskName);
        tasks.add(newTask);
        return newTask;
    }

    public static Task newDeadline(String taskName, String dateDue) {
        Task newTask = null;
        newTask = new Deadline(taskName, dateDue);
        tasks.add(newTask);
        return newTask;
    }

    public static Task newEvent(String taskName, String timeOfEvent) {
        Task newTask = null;
        newTask = new Event(taskName, timeOfEvent);
        tasks.add(newTask);
        return newTask;
    }
    public static void printTask(int taskNumber) {
        System.out.println("[" + tasks.get(taskNumber).getTaskType() + "]" + "["
                + tasks.get(taskNumber).getStatusIcon() + "] " +  tasks.get(taskNumber).getName()
                    + " " + tasks.get(taskNumber).getDate());
        System.out.println();
    }

    public static void addTaskMessage() {
        System.out.println("Now yous got " + tasks.size() + " thing(s) ta do in ya list");
        System.out.println("Anythin else ya need me ta help ya with?");
        System.out.println();
    }

    public static void deleteTask(int taskNumber) {
        System.out.println("I've gotcha mate, removed [" + tasks.get(taskNumber).getTaskType() + "]" + "["
            + tasks.get(taskNumber).getStatusIcon() + "]" + tasks.get(taskNumber).getName() + " "
                + tasks.get(taskNumber).getDate());
        tasks.remove(taskNumber);
    }

    public static void saveToFile() throws java.io.IOException {
        StringJoiner taskFormatter = new StringJoiner(System.lineSeparator());
        for (Task t: tasks) {
            taskFormatter.add(t.taskStringFormat());
        }
        int count = 0;
        int maxTries = 1;
        while (true) {
            try {
                FileWriter listWrite = new FileWriter("./data/Mikey.txt");
                listWrite.write(taskFormatter.toString());
                listWrite.close();
                break;
            } catch (FileNotFoundException e){
                System.out.println("File not found, creating new file");
                fileNotFound(taskFormatter.toString());
            }
        }
    }

    public static void fileNotFound(String taskFormatter) {
        try {
            File newFile = new File("./data/Mikey.txt");
            newFile.getParentFile().mkdirs();
            FileWriter listWrite = new FileWriter("./data/Mikey.txt");
            listWrite.write(taskFormatter.toString());
            listWrite.close();
        } catch (IOException e) {
            System.out.println("Oopsie mate, I can't create a new file");
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        String logo = "⣿⣟⠛⠛⠛⢿⣿⣿⣿⣿⠛⢻⣿⣿⣿⣿⣿⣿⠛⠛⣿⣿⣿⣿⡿⢛⣿⣿⡿⣿ \n"
+ "⣿⣿⣷⣄⠀⠀⠙⢿⣿⣿⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⣿⣿⠟⢋⣴⣿⡿⠋⠀⣿\n"
+ "⣿⣌⠻⣿⣷⣄⠀⠀⠈⠻⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠟⢁⣴⣿⡿⠋⠀⠀⣠⣿\n"
+ "⣿⣿⣷⣌⠻⣿⣷⣄⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⣴⣿⡿⠋⠀⠀⣠⣾⣿⣿\n"
+ "⣿⣿⣿⣿⣦⡈⠻⣿⣷⡄⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⡿⠋⠀⠀⢀⣴⣿⣿⣿⣿\n"
+ "⣿⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣸⣿⣿⣿⣿⣿⣿⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿\n"
+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"
+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"
+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"
+ "⣿⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⢹⣿⣿⣿⣿⣿⣿⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⣿\n"
+ "⣿⣿⣿⣿⠟⠁⠀⠀⣠⣶⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠘⢿⣿⣦⡈⠻⣿⣿⣿⣿\n"
+ "⣿⣿⡿⠋⠀⠀⣠⣾⣿⠟⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠙⢿⣿⣦⡙⢿⣿⣿\n"
+ "⣿⠋⠀⠀⣠⣾⣿⠟⢁⣴⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⣦⡀⠀⠀⠙⢿⣿⣦⡙⣿\n"
+ "⣿⠀⣠⣾⣿⠟⣡⣾⣿⣿⠀⢸⣿⣿⣿⣿⣿⣿⠀⠀⣿⣿⣷⣄⠀⠀⠙⢿⣿⣿\n"
+ "⣿⣾⣿⣿⣥⣾⣿⣿⣿⣿⣤⣼⣿⣿⣿⣿⣿⣿⣤⣤⣿⣿⣿⣿⣷⣤⣤⣤⣽⣿\n";
        System.out.println("Its yobbo-in time innit bruv\n" + logo);
        //welcome message with union jack flag


        System.out.println();
        System.out.println("Ello bruv, me name's Mikey!");
        System.out.println("How can ah help ya bruv?");
        System.out.println();

        Scanner inputText = new Scanner(System.in);

        while(true) {
            String userInput = inputText.nextLine();
            String keyword = null;
            keyword = userInput.split(" ", 0)[0];
            if (keyword.equalsIgnoreCase("bye")) {
                System.out.println("Cheerio mate! I'll be seein ya soon, innit? o7");
                System.out.println();
                break;
            } else if (keyword.equalsIgnoreCase("list")){
                System.out.println("Aight bruv here's ya list of stuff yous gotta do");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + "[" + tasks.get(i).getTaskType() + "]" + "["
                            + tasks.get(i).getStatusIcon() + "] " +  tasks.get(i).getName() + tasks.get(i).getDate());
                }
                System.out.println();
            } else if (keyword.equalsIgnoreCase("mark")) {
                try {
                    int taskNumber = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    tasks.get(taskNumber).isDone = true;
                    System.out.println("Well done bruv, you finished this: ");
                    printTask(taskNumber);
                    saveToFile();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't mark an imaginary task now innit?");
                    System.out.println();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't mark an imaginary task now innit?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("unmark")){
                try {
                    int taskNumber = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    tasks.get(taskNumber).isDone = false;
                    System.out.println("Aye good Sir/Ma'am, I've marked that uncompleted: ");
                    printTask(taskNumber);
                    saveToFile();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't unmark an imaginary task now innit?");
                    System.out.println();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't unmark an imaginary task now innit?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("todo")) {
                //todo new task
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 5;
                    String taskName = userInput.substring(start);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    newTodo(taskName);
                    printTask((tasks.size() - 1));
                    addTaskMessage();
                    saveToFile();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("deadline")) {
                //deadline new task
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 9;
                    int startOfBy = userInput.indexOf("/by");
                    String taskName = userInput.substring(start, startOfBy - 1);
                    String dateTime = userInput.substring(startOfBy + 4);
                    newDeadline(taskName, dateTime);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    printTask((tasks.size() -1));
                    addTaskMessage();
                    saveToFile();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("event")) {
                //event new task
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 6;
                    int startOfFrom = userInput.indexOf("/from");
                    String taskName = userInput.substring(start, startOfFrom);
                    String timeOfEvent = userInput.substring(startOfFrom);
                    timeOfEvent = timeOfEvent.replace("from", "from:");
                    timeOfEvent = timeOfEvent.replace("to", "to:");
                    newEvent(taskName, timeOfEvent);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    printTask((tasks.size() -1));
                    addTaskMessage();
                    saveToFile();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("delete")) {
                try {
                    int taskNumber = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    deleteTask(taskNumber);
                    addTaskMessage();
                    saveToFile();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("C'mon bruv, I can't deletes an imaginary task now, can I?");
                    System.out.println();
                }
            } else {
                System.out.println("Crikey bruv, yous 'avin a laugh? I don know what that means!");
                System.out.println();

            }
        }
    }
}
