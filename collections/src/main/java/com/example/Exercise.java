package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise {

    public static void main(String[] args) {

        // Input..
        String[] csvReport = {
                "Alice,Engineering,70000",
                "Bob,Marketing,60000",
                "Charlie,Engineering,80000",
                "David,Marketing,50000",
                "Eve,Engineering,90000"
        };
        Map<String, Double> csvReportSummary = new LinkedHashMap<>();
        for (String csvLine : csvReport) {
            String[] tokens = csvLine.split(",");
            String department = tokens[1];
            double salary = Double.parseDouble(tokens[2]);
            if (csvReportSummary.containsKey(department)) {
                csvReportSummary.put(department, csvReportSummary.get(department) + salary);
            } else {
                csvReportSummary.put(department, salary);
            }
        }
        System.out.println(csvReportSummary);
    }

}
