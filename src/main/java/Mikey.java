import java.util.Scanner;
import java.util.ArrayList;

public class Mikey {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public static void newTask(String taskName) {
        Task newTask = new Task(taskName);
        tasks.add(newTask);
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
        /** welcome message with union jack flag
         */

        System.out.println();
        System.out.println("Ello bruv, me name's Mikey!");
        System.out.println("How can ah help ya bruv?");
        System.out.println();

        Scanner inputText = new Scanner(System.in);

        while(true) {
            String userInput = inputText.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Cheerio mate! I'll be seein ya soon, innit?");
                break;
            }
            else if (userInput.equalsIgnoreCase("list")){
                System.out.println("Aight bruv here's ya list of stuff you gotta do");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).getName());
                }

            }
            else {
                System.out.println("gotcha mate, added \"" + userInput + "\" to your list");
                newTask(userInput);
            }

        }


    }
}
