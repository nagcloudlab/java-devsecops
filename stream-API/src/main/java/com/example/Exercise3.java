package com.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public class Exercise3 {
    public static void main(String[] args) throws FileNotFoundException, IOException {


        // way-1: Imperative style
        File file = new File("/Users/nag/java-devsecops/stream-library/report.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        Map<String, Double> departmentSalaryMap = new java.util.HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] token = line.split(",");
            String department = token[1];
            double salary = Double.parseDouble(token[2]);
            if (departmentSalaryMap.containsKey(department)) {
                double currentSalary = departmentSalaryMap.get(department);
                departmentSalaryMap.put(department, currentSalary + salary);
            } else {
                departmentSalaryMap.put(department, salary);
            }
        }
        bufferedReader.close();

        System.out.println("Imperative style department salary map: " + departmentSalaryMap);

        // way-2: Functional style
        Stream<String> stream = Files.lines(Path.of("/Users/nag/java-devsecops/stream-library/report.csv"));

        Map<String, Double> departmentSalaryMapFunctional = stream
                //.skip(1) // Skip header line
                .map(csvLine -> csvLine.split(","))
                .collect(java.util.stream.Collectors.groupingBy(
                        tokens -> tokens[1],
                        java.util.stream.Collectors.summingDouble(tokens -> Double.parseDouble(tokens[2]))
                ));
        stream.close();
        System.out.println("Functional style department salary map: " + departmentSalaryMapFunctional);


    }
}
