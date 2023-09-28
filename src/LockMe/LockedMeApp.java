package LockMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LockedMeApp {
    private static final String BASE_DIRECTORY = "files/";

    public static void main(String[] args) {
        createBaseDirectoryIfNotExists();
        //Welcome Screen displaying Developer Name and Application Details
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Course-end Project 1");
        System.out.println("Virtual Key for Your Repositories");
        System.out.println("Welcome to LockedMe.com");
		System.out.println("Developed By 'Meluleki Terrence Ngcobo'");	
		System.out.println("");
		System.out.println("\n--------------------------------------------------------------");

        displayMainMenu();
    }
    
    // Creating the directory if it does not exist
    private static void createBaseDirectoryIfNotExists() {
        File directory = new File(BASE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    
    
    // The display main menu method is set to private
    private static void displayMainMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
        	// Welcome Screen Options
        	System.out.println("-------------------------------------------------");
        	System.out.println("\nExisting options in the aplication: ");
        	System.out.println("*Display Files in Ascending Order");
        	System.out.println("*Add, Delete and Search for a File");
        	System.out.println("*Close the Application");
        	
        	
        	// Displaying Menu Options
            System.out.println("\nMain Menu - Select your choice:");
            System.out.println("1. List all the Files");
            System.out.println("2. Add a File to a directory");
            System.out.println("3. Delete a File from a directory");
            System.out.println("4. Search for a File");
            System.out.println("5. Exit the Application");
            System.out.print("Enter your choice: ");
            
            // Accept User Input
            int choice = sc.nextInt();
            sc.nextLine();
            
            // Performing functions as per user input
            switch (choice) {
                case 1:
                    listFiles();
                    break;
                case 2:
                    addFile(sc);
                    break;
                case 3:
                    deleteFile(sc);
                    break;
                case 4:
                    searchFile(sc);
                    break;
                case 5:
                    sc.close();
                    System.out.println("Exiting LockedMe.com. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    
    // Listing the files in the directory
    private static void listFiles() {
        File directory = new File(BASE_DIRECTORY);
        File[] files = directory.listFiles();

        System.out.println("\nList of Files in the Directory:");
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
    
    // Adding Files to the directory
    private static void addFile(Scanner sc) {
        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter the file content: ");
        String content = sc.nextLine();

        try {
            FileWriter writer = new FileWriter(BASE_DIRECTORY + fileName);
            writer.write(content);
            writer.close();
            System.out.println("File '" + fileName + "' has been added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the file.");
        }
    }
    
    // Deleting a file in a directory
    private static void deleteFile(Scanner sc) {
        System.out.print("Enter the file name to delete: ");
        String fileName = sc.nextLine();
        File fileToDelete = new File(BASE_DIRECTORY + fileName);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("File '" + fileName + "' has been deleted.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }
    
    // Searching for a file in the directory
    private static void searchFile(Scanner sc) {
        System.out.print("Enter the file name to search: ");
        String searchFileName = sc.nextLine();
        File directory = new File(BASE_DIRECTORY);
        File[] files = directory.listFiles();
    
        boolean found = false;

        if (files != null) {
            for (File file : files) {
                if (file.getName().equalsIgnoreCase(searchFileName)) {
                    System.out.println("File found: " + file.getName());
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("File not found.");
        }
    }
}

