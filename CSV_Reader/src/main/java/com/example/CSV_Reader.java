package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSV_Reader {
    public static void main(String[] args) {

        try {


        //// CSV file path 
            String csvFile = "Sample.csv";

                
                //read and parse the csv file 
            Reader reader = new FileReader(csvFile);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                    .withFirstRecordAsHeader()
                                    .withIgnoreHeaderCase()
                                    .withTrim());

                    
        //assign the  values to the variables 
            for (CSVRecord record : csvParser){

                String name = record.get("Name");
                String age = record.get("Age");
                String city = record.get( "City");
                
                //print the values
                System.out.println("Name: "+ name +", Age: "+ age + ", City: " + city);

            }
        

        //close the parser and reader 

        csvParser.close();
        Reader.close();

        //handle the errors  CSV file path 




        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error Reading CSV File: " + e.getMessage());
        }
          
    
    }
}