package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReader {
    public static void main(String[] args) {
        // Path to our CSV file
        String csvFile = "sample.csv";

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()  // Treat first row as header
                    .withIgnoreHeaderCase()     // Ignore header case
                    .withTrim())) {             // Trim whitespace

            // Read and print each record
            for (CSVRecord record : csvParser) {
                // Get values by column name
                String name = record.get("Name");
                String age = record.get("Age");
                String city = record.get("City");

                // Print the record
                System.out.println("Name: " + name + ", Age: " + age + ", City: " + city);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
} 



