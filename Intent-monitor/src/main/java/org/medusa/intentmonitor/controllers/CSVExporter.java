package org.medusa.intentmonitor.controllers;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void writeToCSV(List<CSVItem> items, String filePath) {
        boolean fileExists = new File(filePath).exists(); // Check if file exists

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) { // Append mode enabled
            // Write header only if the file is newly created
            if (!fileExists) {
                String[] header = {"Index", "Description", "Destination Package", "Destination Class", "Is Exported", "Bundle String"};
                writer.writeNext(header);
            }

            // Append each CSVItem as a row
            for (CSVItem item : items) {
                String[] row = {
                    String.valueOf(item.getIndex()).replaceAll("\\r?\\n", ""),
                    item.getDescription().replaceAll("\\r?\\n", ""),
                    item.getDestinationPackage().replaceAll("\\r?\\n", ""),
                    item.getDestinationClass().replaceAll("\\r?\\n", ""),
                    String.valueOf(item.getExported()).replaceAll("\\r?\\n", ""),
                    item.getBundleString().replaceAll("\\r?\\n", "")
                };
                writer.writeNext(row);
            }

            System.out.println("Data appended to CSV file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
