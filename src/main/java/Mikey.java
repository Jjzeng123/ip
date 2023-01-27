import java.util.Scanner;
import java.util.ArrayList;

public class Mikey {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public static void newTask(String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
    }

    public static void printTask(int task_number) {
        System.out.println("[" + tasks.get(task_number).getStatusIcon() + "] " +  tasks.get(task_number).getName());
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
        /**
         * welcome message with union jack flag
         */

        System.out.println();
        System.out.println("Ello bruv, me name's Mikey!");
        System.out.println("How can ah help ya bruv?");
        System.out.println();

        Scanner inputText = new Scanner(System.in);

        while(true) {
            String userInput = inputText.nextLine();
            String keyword = userInput.split(" ")[0];
            if (keyword.equalsIgnoreCase("bye")) {
                System.out.println("Cheerio mate! I'll be seein ya soon, innit? o7");
                System.out.println();
                break;
            } else if (keyword.equalsIgnoreCase("list")){
                System.out.println("Aight bruv here's ya list of stuff yous gotta do");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + "[" + tasks.get(i).getStatusIcon() + "] "
                            +  tasks.get(i).getName());
                }
                System.out.println();
            } else if (keyword.equalsIgnoreCase("mark")) {
                int task_number = Integer.parseInt(userInput.split(" ")[1]) - 1;
                tasks.get(task_number).isDone = true;
                System.out.println("Well done bruv, you finished this: ");
                printTask(task_number);
            } else if (keyword.equalsIgnoreCase("unmark")){
                int task_number = Integer.parseInt(userInput.split(" ")[1]) - 1;
                tasks.get(task_number).isDone = false;
                System.out.println("Aye good Sir/Ma'am, I've marked that uncompleted: ");
                printTask(task_number);
            } else {
                System.out.println("Gotcha mate, added \"" + userInput + "\" to your list");
                newTask(userInput);
                System.out.println("Anythin else ya need me ta help ya with?");
                System.out.println();
            }
        }
    }
}
