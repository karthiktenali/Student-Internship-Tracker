
import java.util.ArrayList;
import java.util.Scanner;

class Internship {
    int id;
    String company, role, date, status;
    String duration, learning;

    Internship(int id, String company, String role, String date) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.date = date;
        this.status = "Applied";
        this.duration = "Not completed";
        this.learning = "Not available";
    }

    void display() {
        System.out.println("\nID: " + id);
        System.out.println("Company: " + company);
        System.out.println("Role: " + role);
        System.out.println("Application Date: " + date);
        System.out.println("Status: " + status);
        System.out.println("Duration: " + duration);
        System.out.println("Learning: " + learning);
        System.out.println("---------------------------");
    
}

public class StudentInternshipTracker {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Internship> list = new ArrayList<>();
    static int nextId = 1;

    static void addInternship() {

        System.out.print("Enter Company Name: ");
        String company = sc.nextLine();

        System.out.print("Enter Role: ");
        String role = sc.nextLine();

        System.out.print("Enter Application Date: ");
        String date = sc.nextLine();

        Internship obj = new Internship(
            nextId++, company, role, date
        );

        list.add(obj);

        System.out.println("Internship Added Successfully!");
    }

    static void viewInternships() {

        if (list.isEmpty()) {
            System.out.println("No Internship Records Found!");
            return;
        }

        for (Internship obj : list) {
            obj.display();
        }
    }
    static void updateInternship() {

        System.out.print("Enter Internship ID to Update: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Internship obj : list) {

            if (obj.id == id) {

                System.out.print("Enter New Company Name: ");
                obj.company = sc.nextLine();

                System.out.print("Enter New Role: ");
                obj.role = sc.nextLine();

                System.out.print("Enter New Application Date: ");
                obj.date = sc.nextLine();

                System.out.println("Select Status:");
                System.out.println("1. Applied");
                System.out.println("2. Selected");
                System.out.println("3. Rejected");
                System.out.println("4. Completed");

                System.out.print("Enter Choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        obj.status = "Applied";
                        break;

                    case 2:
                        obj.status = "Selected";
                        break;

                    case 3:
                        obj.status = "Rejected";
                        break;

                    case 4:
                        obj.status = "Completed";

                        System.out.print("Enter Duration: ");
                        obj.duration = sc.nextLine();

                        System.out.print("Enter Learning Description: ");
                        obj.learning = sc.nextLine();
                        break;

                    default:
                        System.out.println("Invalid Status!");
                        return;
                }

                System.out.println("Internship Updated Successfully!");
                return;
            }
        }

        System.out.println("Internship ID Not Found!");
    }

    static void deleteInternship() {

        System.out.print("Enter Internship ID to Delete: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Internship obj : list) {

            if (obj.id == id) {
                list.remove(obj);
                System.out.println("Internship Deleted Successfully!");
                return;
            }
        }

        System.out.println("Internship ID Not Found!");
    }


    static void searchInternship() {

        System.out.print("Enter Company Name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Internship obj : list) {

            if (obj.company.toLowerCase().contains(name.toLowerCase())) {
                obj.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Matching Records Found!");
        }
    }


    static void filterInternship() {

        System.out.println("Enter Status:");
        System.out.println("Applied / Selected / Rejected / Completed");

        String status = sc.nextLine();

        boolean found = false;

        for (Internship obj : list) {

            if (obj.status.equalsIgnoreCase(status)) {
                obj.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Records Found!");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT INTERNSHIP TRACKER =====");
            System.out.println("1. Add Internship");
            System.out.println("2. View Internships");
            System.out.println("3. Update Internship");
            System.out.println("4. Delete Internship");
            System.out.println("5. Search by Company");
            System.out.println("6. Filter by Status");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addInternship();
                    break;

                case 2:
                    viewInternships();
                    break;

                case 3:
                    updateInternship();
                    break;

                case 4:
                    deleteInternship();
                    break;

                case 5:
                    searchInternship();
                    break;

                case 6:
                    filterInternship();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
}