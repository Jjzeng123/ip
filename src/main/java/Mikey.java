import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Mikey {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Returns a new Task of the "To Do" type and adds it to the "tasks" arraylist.
     *
     *
     * @param taskName the description of the task
     * @param completion the completion status of the task
     * @return a new task of the "To Do" type
     */
    public static Task newTodo(String taskName, int completion) {
        Task newTask = null;
        newTask = new Todo(taskName);
        if(completion == 1) {
            newTask.isDone = true;
        } else {
            newTask.isDone = false;
        }
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Returns a new Task of the "Deadline" type and adds it to the "tasks" arraylist.
     *
     * @param taskName the description of the task
     * @param dateDue the date the task is due
     * @param completion the completion status of the task
     * @return a new task of the "Deadline" type
     */
    public static Task newDeadline(String taskName, String dateDue, int completion) {
        Task newTask = null;
        newTask = new Deadline(taskName, dateDue);
        if(completion == 1) {
            newTask.isDone = true;
        } else {
            newTask.isDone = false;
        }
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Returns a new task of the "Event" type and adds it to the "tasks" arraylist
     *
     * @param taskName the description of the task
     * @param timeOfEvent the start and end times of the task
     * @param completion the completion status of the task
     * @return a new task of the "Event" type
     */
    public static Task newEvent(String taskName, String timeOfEvent, int completion) {
        Task newTask = null;
        newTask = new Event(taskName, timeOfEvent);
        if(completion == 1) {
            newTask.isDone = true;
        } else {
            newTask.isDone = false;
        }
        tasks.add(newTask);
        return newTask;
    }

    /**
     * Prints out a formatted version of the task with its type, completion status, description and date (if any)
     *
     * @param taskNumber the number of the task in the list
     */
    public static void printTask(int taskNumber) {
        System.out.println("[" + tasks.get(taskNumber).getTaskType() + "]" + "["
                + tasks.get(taskNumber).getStatusIcon() + "] " +  tasks.get(taskNumber).getName() + " "
                    + tasks.get(taskNumber).getDate());
    }

    /**
     * Prints out a series of messages confirming to the user that their task has been added
     */
    public static void addTaskMessage() {
        System.out.println("Now yous got " + tasks.size() + " thing(s) ta do in ya list");
        System.out.println("Anythin else ya need me ta help ya with?");
        System.out.println();
    }

    /**
     * Deletes a task from the "tasks" arraylist
     *
     * @param taskNumber the number of the task in the list
     */
    public static void deleteTask(int taskNumber) {
        System.out.println("I've gotcha mate, removed [" + tasks.get(taskNumber).getTaskType() + "]" + "["
            + tasks.get(taskNumber).getStatusIcon() + "]" + tasks.get(taskNumber).getName() + " "
                + tasks.get(taskNumber).getDate());
        tasks.remove(taskNumber);
    }

    /**
     * Saves the data in the "tasks" arraylist to a text file in a certain format, and throws an IO exception
     * if the save fails, then creates the file manually and tries again.
     *
     * @throws java.io.IOException if the home directory and file cannot be found
     */
    public static void saveToFile() throws java.io.IOException {
        StringJoiner taskFormatter = new StringJoiner(System.lineSeparator());
        for (Task t: tasks) {
            taskFormatter.add(t.taskStringFormat());
        }
        while (true) {
            try {
                FileWriter listWrite = new FileWriter("./data/Mikey.txt");
                listWrite.write(taskFormatter.toString());
                listWrite.close();
                break;
            } catch (FileNotFoundException e) {
                fileNotFound(taskFormatter.toString());
            }
        }
    }

    /**
     * Reads data from a text file and converts it into data to create new tasks to add to the "tasks" arraylist,
     * throws an exception if the file is not found and creates the file
     *
     * @throws java.io.IOException if the home directory and the file cannot be found
     */
    public static void readFromFile() throws java.io.IOException{
        try {
            File readingFile = new File("./data/Mikey.txt");
            Scanner fileScan = new Scanner(readingFile);
            while(fileScan.hasNextLine()) {
                String taskLine = fileScan.nextLine();
                String[] taskDetails = taskLine.split(" \\|\\ ", 0);
                String taskType = taskDetails[0];
                String taskCompletion = taskDetails[1];
                String taskDescription = taskDetails[2];
                if(taskType.equalsIgnoreCase("T")) {
                    try {
                        newTodo(taskDescription, Integer.parseInt(taskCompletion));
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Oi mate, I can't create an empty task yea?");
                        System.out.println();
                    }
                } else if (taskType.equalsIgnoreCase("D")) {
                    try {
                        String[] taskDateTemp = taskDetails[3].split("\\(by ", 0);
                        String taskDate = taskDateTemp[1].substring(0);
                        taskDate = taskDate.replace(")", "");
                        newDeadline(taskDescription, taskDate, Integer.parseInt(taskCompletion));
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Oi mate, I can't create an empty task yea?");
                        System.out.println();
                    }
                } else if (taskType.equalsIgnoreCase("E")) {
                    try {
                        String[] taskDateTemp = taskDetails[3].split("\\(");
                        String taskDate = taskDateTemp[0].substring(0);
                        newEvent(taskDescription, taskDate, Integer.parseInt(taskCompletion));
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Oi mate, I can't create an empty task yea?");
                        System.out.println();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            fileNotFound("");
        }

    }

    /**
     * Handler for the FileNotFoundException in the saveToFile and readFromFile methods, creates a new directory
     * and text file
     *
     * @param taskFormatter the formatted string of details of a task to be written to the file, set to empty when a new
     *                      blank file is created
     */
    public static void fileNotFound(String taskFormatter) {
        System.out.println("Ooh deary me bruv, I reckon that file don't exists yet, I'm gonna go ahead and make one");
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

    /**
     * Method to find a task based on a keyword in a search term and prints out a list of tasks containing that keyword
     *
     * @param searchTerm the keyword to search for within the list of tasks
     */
    public static void findTasks(String searchTerm) {
        String keyword = searchTerm;
        System.out.println("Here ya go bruv, that's everythin that contains that search term:");
        int counter = 0;
        for(int i = 0; i < tasks.size(); i++) {
            String temp = tasks.get(i).getName();
            if (temp.contains(keyword)) {
                counter++;
                System.out.print(counter + ". ");
                printTask(i);
            }
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        System.out.println("Its yobbo-in time innit bruv\n");


        System.out.println();
        System.out.println("Ello bruv, me name's Mikey!");
        System.out.println("How can ah help ya bruv?");
        System.out.println();
        readFromFile();

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
                            + tasks.get(i).getStatusIcon() + "] " +  tasks.get(i).getName() + " "
                                + tasks.get(i).getDate());
                }
                System.out.println();
            } else if (keyword.equalsIgnoreCase("mark")) {
                try {
                    int taskNumber = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    tasks.get(taskNumber).isDone = true;
                    System.out.println("Well done bruv, you finished this: ");
                    printTask(taskNumber);
                    System.out.println();
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
                    System.out.println();
                    saveToFile();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't unmark an imaginary task now innit?");
                    System.out.println();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Bloody 'ell buddy, I can't unmark an imaginary task now innit?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("todo")) {
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 5;
                    String taskName = userInput.substring(start);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    newTodo(taskName, 0);
                    printTask((tasks.size() - 1));
                    System.out.println();
                    addTaskMessage();
                    saveToFile();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("deadline")) {
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 9;
                    int startOfBy = userInput.indexOf("/by");
                    String taskName = userInput.substring(start, startOfBy - 1);
                    String dateTime = userInput.substring(startOfBy + 4);
                    newDeadline(taskName, dateTime, 0);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    printTask((tasks.size() -1));
                    System.out.println();
                    addTaskMessage();
                    saveToFile();
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Oi mate, I can't create an empty task yea?");
                    System.out.println();
                }
            } else if (keyword.equalsIgnoreCase("event")) {
                int start = 0;
                try {
                    start = userInput.indexOf(keyword) + 6;
                    int startOfFrom = userInput.indexOf("/from");
                    String taskName = userInput.substring(start, startOfFrom - 1);
                    String timeOfEvent = userInput.substring(startOfFrom);
                    timeOfEvent = timeOfEvent.replace("from", "from:");
                    timeOfEvent = timeOfEvent.replace("to", "to:");
                    newEvent(taskName, timeOfEvent, 0);
                    System.out.println("Gotcha mate, added this task to your list: ");
                    printTask((tasks.size() -1));
                    System.out.println();
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
            } else if (keyword.equalsIgnoreCase("find")) {
                int start = userInput.indexOf(keyword) + 5;
                String searchTerm = userInput.substring(start);
                findTasks(searchTerm);
                System.out.println();
            } else {
                System.out.println("Crikey bruv, yous 'avin a laugh? I don know what that means!");
                System.out.println();

            }
        }
    }
}
