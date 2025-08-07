
//*****Student Management System using ArrayList*****//

import java.util.*;

public class Project1 {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in); // Moved scanner outside loop

        while (true) {
            System.out.println("\n===== Student Management System ===== \n");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details (each record)");
            System.out.println("3. Display entire list");
            System.out.println("4. Search by name");
            System.out.println("5. Exit \n");
            System.out.print("Enter your choice: ");


            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine()); // Handle non-int input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Reg No: ");
                int reg = Integer.parseInt(sc.nextLine());

                // Prevent duplicate Reg No
                boolean exists = false;
                for (Student s : list) {
                    if (s.stuReg == reg) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("A student with this Reg No already exists!");
                    continue;
                }

                System.out.print("Department Name: \n");
                String dept = sc.nextLine();

                list.add(new Student(name, reg, dept));
                System.out.println("Student added successfully!");

            	
            } else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("No student records found.");
                } else {
                    System.out.println("-------------------------------------------------");
                    System.out.printf("%-20s %-10s %-15s%n", "Name", "Reg No", "Department");
                    System.out.println("-------------------------------------------------");
                    for (Student data : list) {
                        System.out.printf("%-20s %-10d %-15s%n", data.stuName, data.stuReg, data.stuDept);
                    }
                    System.out.println("-------------------------------------------------");
                }
            }

//       		 } else if (choice == 2) {
//                if (list.isEmpty()) {
//                    System.out.println("No student records found.");
//                } else {
//                	System.out.println("-------------------------------------");
//                    for (Student data : list) {
//                        System.out.println(data);
//                    }
//                    System.out.print("-------------------------------------\n");
//                }
//        }
            else if (choice == 3) {
                System.out.println(list.isEmpty() ? "List is empty!" : list);

            } else if (choice == 4) {
                System.out.print("Enter name to search: ");
                String nsearch = sc.nextLine();
                boolean found = false;

                for (Student s : list) {
                	
                	if (s.stuName.equalsIgnoreCase(nsearch)) {
                	    System.out.println("-------------------------------------------------");
                	    System.out.printf("%-20s %-10s %-15s%n", "Name", "Reg No", "Department");
                	    System.out.println("-------------------------------------------------");
                	    System.out.printf("%-20s %-10d %-15s%n", s.stuName, s.stuReg, s.stuDept);
                	    System.out.println("-------------------------------------------------");
                	    found = true;
                	    break;
                	}

                	
//                    if (s.stuName.equalsIgnoreCase(nsearch)) {
//                        System.out.println("Student found: " + s);
//                        found = true;
//                        break; // Exit loop after finding
//                    }
                }

                if (!found) {
                    System.out.println("No student found with the name: " + nsearch);
                }

            } else if (choice == 5) {
                System.out.println("Exiting... Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}

class Student {
    String stuName;
    int stuReg;
    String stuDept;

    Student(String stuName, int stuReg, String stuDept) {
        this.stuName = stuName;
        this.stuReg = stuReg;
        this.stuDept = stuDept;
    }

    @Override
    public String toString() {
        return "Name: " + stuName + " | Reg No: " + stuReg + " | Dept: " + stuDept;
    }
    
}
