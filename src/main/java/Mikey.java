import java.util.Scanner;
import java.util.ArrayList;

public class Mikey {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public static Task newTodo(String taskName) {
        Task newTask = null;
//        if(taskName.equals(null)) {
//            throw new EmptyTaskException();
//        }
        newTask = new Todo(taskName);
        tasks.add(newTask);
        return newTask;
    }

    public static Task newDeadline(String taskName, String dateDue) {
        Task newTask = null;
//        if(taskName.equals(null) || dateDue.equals(null)) {
//            throw new EmptyTaskException();
//        }
        newTask = new Deadline(taskName, dateDue);
        tasks.add(newTask);
        return newTask;
    }

    public static Task newEvent(String taskName, String timeOfEvent) {
        Task newTask = null;
//        if(taskName.equals(null) || timeOfEvent.equals(null)) {
//            throw new EmptyTaskException();
//        }
        newTask = new Event(taskName, timeOfEvent);
        tasks.add(newTask);
        return newTask;
    }
    public static void printTask(int task_number) {
        System.out.println("[" + tasks.get(task_number).getTaskType() + "]" + "["
                + tasks.get(task_number).getStatusIcon() + "] " +  tasks.get(task_number).getName()
                    + " " + tasks.get(task_number).getDate());
        System.out.println();
    }

    public static void addTaskMessage() {
        System.out.println("Now yous got " + tasks.size() + " thing(s) ta do in ya list");
        System.out.println("Anythin else ya need me ta help ya with?");
        System.out.println();
    }

    public static void main(String[] args) {
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
                    int task_number = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    tasks.get(task_number).isDone = true;
                    System.out.println("Well done bruv, you finished this: ");
                    printTask(task_number);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't mark an imaginary task now innit?");
                    System.out.println();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't mark an imaginary task now innit?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("unmark")){
                try {
                    int task_number = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    tasks.get(task_number).isDone = false;
                    System.out.println("Aye good Sir/Ma'am, I've marked that uncompleted: ");
                    printTask(task_number);
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
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else {
                System.out.println("Crikey bruv, yous 'avin a laugh? I don know what that means!");
                System.out.println();

            }
        }
    }
}
