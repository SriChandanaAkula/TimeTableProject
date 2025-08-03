import java.util.*;

class TimeTableEntry {
    String day;
    String subject;
    String startTime;
    String endTime;

    TimeTableEntry(String day, String subject, String startTime, String endTime){
        this.day = day;
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void display() {
        System.out.println(day + " | " + subject + " | " + startTime + " - " + endTime);
    }
}

public class TimeTableManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<TimeTableEntry> entries = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== TIME TABLE MENU =====");
            System.out.println("1. Add Entry");
            System.out.println("2. View Time Table");
            System.out.println("3. Search by Day");
            System.out.println("4. Delete Entry");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1: addEntry(); break;
                case 2: viewTimeTable(); break;
                case 3: searchByDay(); break;
                case 4: deleteEntry(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void addEntry() {
        System.out.print("Enter Day: ");
        String day = sc.nextLine();
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter Start Time (e.g. 10:00 AM): ");
        String startTime = sc.nextLine();
        System.out.print("Enter End Time (e.g. 11:00 AM): ");
        String endTime = sc.nextLine();

        entries.add(new TimeTableEntry(day, subject, startTime, endTime));
        System.out.println("Entry added successfully!");
    }

    public static void viewTimeTable() {
        if (entries.isEmpty()) {
            System.out.println("No entries available.");
            return;
        }
        System.out.println("\n--- Your Time Table ---");
        for (TimeTableEntry entry : entries) {
            entry.display();
        }
    }

    public static void searchByDay() {
        System.out.print("Enter Day to Search: ");
        String searchDay = sc.nextLine();
        boolean found = false;

        for (TimeTableEntry entry : entries) {
            if (entry.day.equalsIgnoreCase(searchDay)) {
                entry.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No entries found for that day.");
        }
    }

    public static void deleteEntry() {
        System.out.print("Enter Day to Delete: ");
        String day = sc.nextLine();
        System.out.print("Enter Subject to Delete: ");
        String subject = sc.nextLine();

        boolean removed = entries.removeIf(e ->
            e.day.equalsIgnoreCase(day) && e.subject.equalsIgnoreCase(subject));

        if (removed) {
            System.out.println("Entry deleted.");
        } else {
            System.out.println("No matching entry found.");
        }
    }
}
