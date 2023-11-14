/**
 * Elsa Tamara
 * Coding Challenge
 * Associate Developer - Expeditor
 */

package org.expeditor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.expeditor.Utility.sortByLastThenFirstName;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, RuntimeException {
        List<String[]> input = new ArrayList<String[]>();
        Map<Address, List<Person>> directory = new HashMap<>();

        // Reads input file
        try {
            FileReader fileReader = new FileReader("data/input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                input.add(line.replace("\"", "").replace(".", "").split(","));
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Input file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // Populate the directory hashmap<Address, Person>
        for (String[] line : input) {
            Address newAddress;
            Person newPerson;
            List<Person> people;
            if (line.length == 6) {
                newAddress = new Address(line[2], line[3], line[4]);
                newPerson = new Person(line[0], line[1], line[5], newAddress);
            } else {
                newAddress = new Address(line[2], line[3], line[4], line[5]);
                newPerson = new Person(line[0], line[1], line[6], newAddress);
            }

            if (directory.containsKey(newAddress)) {
                people = directory.get(newAddress);
            } else {
                people = new ArrayList<>();
            }
            people.add(newPerson);
            directory.put(newAddress, people);
        }

        // Prints out expected output
        System.out.println("Household directory\n");
        for (Address address : directory.keySet()) {
            List<Person> people = directory.get(address);
            System.out.println("Household: " + address.toString());
            System.out.println("Household Size: " + people.size());
            List<Person> overEighteen = people.stream().filter(person -> person.getAge() > 18)
                    .collect(Collectors.toList());
            overEighteen = sortByLastThenFirstName(overEighteen);
            System.out.println("Occupants over 18: ");
            for (Person p : overEighteen) {
                System.out.println(p.toString());
            }
            System.out.println("\n");
        }

        // Saves file to txt file
        String outputPath = "data/output.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write("Household directory\n");
            for (Address address : directory.keySet()) {
                List<Person> people = directory.get(address);
                writer.write("Household: " + address.toString() + "\n");
                writer.write("Household Size: " + people.size() + "\n");
                List<Person> overEighteen = people.stream().filter(person -> person.getAge() > 18)
                        .collect(Collectors.toList());
                overEighteen = sortByLastThenFirstName(overEighteen);
                writer.write("Occupants over 18: " + "\n");
                for (Person p : overEighteen) {
                    writer.write(p.toString() + "\n");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Input file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}