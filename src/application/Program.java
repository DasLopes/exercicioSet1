package application;

import java.io.*;
import java.time.Instant;
import java.util.*;

import entities.LogEntry;
public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        Set<LogEntry> set = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));

                line = br.readLine();
            }
            System.out.println("Total users: " + set.size());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
