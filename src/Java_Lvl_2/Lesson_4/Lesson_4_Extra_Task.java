package com.company;

public class Lesson_4_Extra_Task {
    static final String string = "118 2.05\n" +
            "106 1.77\n" +
            "87 1.83\n" +
            "45 1.12\n" +
            "70 1.87\n" +
            "54 1.57\n" +
            "105 1.76\n" +
            "50 1.96\n" +
            "114 1.76\n" +
            "72 2.45\n" +
            "53 2.10\n" +
            "66 2.25\n" +
            "54 1.50\n" +
            "95 1.62\n" +
            "86 1.72\n" +
            "62 1.57\n" +
            "65 2.24\n" +
            "72 1.43\n" +
            "93 2.01\n" +
            "109 3.01\n" +
            "106 2.97\n" +
            "77 1.69\n" +
            "114 2.09\n" +
            "98 1.72\n" +
            "85 2.46\n" +
            "113 1.94\n" +
            "53 1.77\n" +
            "106 2.30";

    public static void main(String[] args) {
        String parse[] = string.split("\\n");

        for (int i = 0; i < parse.length ; i++) {
            String value[] = parse[i].split(" ");
            int weight = Integer.parseInt(value[0]);
            double growth = Double.parseDouble(value[1]);
            double BMI = weight / (growth * growth);
            String format = String.format("%.2f", BMI); // sout((int)BMI) вывести значение без дробной части
            System.out.print(format);
            if (BMI < 18.5)   System.out.println(" Underweight");
            else if (18.5 <= BMI && BMI < 25)   System.out.println(" Normal weight");
            else if (25 <= BMI && BMI < 30)   System.out.println(" Overweight");
            else if (BMI >= 30)   System.out.println(" Obesity");
       }
    }
}

