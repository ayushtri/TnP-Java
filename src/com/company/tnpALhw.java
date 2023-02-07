package com.company;

import java.util.*;

public class tnpALhw {
    public static void quiz(String Name, String Enrollment){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<Character> selected = new ArrayList<>();
        int marks = 0;
        questions.add("Q1. What is the colour of Apples? \n a.Red\n b.Yellow\n c.Green\n d.Orange");
        questions.add("Q2. What is the colour of Mango? \n a.Yellow\n b.Red\n c.Green\n d.Orange");
        questions.add("Q3. What is the colour of Orange? \n a.Pink\n b.Red\n c.Orange\n d.Blue");
        questions.add("Q4. What is the colour of Banana? \n a.Blue\n b.Red\n c.Green\n d.Yellow");
        questions.add("Q5. What is the colour of Lychee? \n a.Pink\n b.Red\n c.Orange\n d.Blue");
        for(String str : questions){
            System.out.println(str);
            System.out.print("Enter correct option: ");
            char opt = sc.next().charAt(0);
            selected.add(opt);
        }
        ArrayList<Character> answers = new ArrayList<>(List.of('a','a','c','d','a'));
        for(int i=0;i<answers.size();i++){
            if(answers.get(i)==selected.get(i)) marks++;
        }
        System.out.println("Your Answers: "+selected);
        System.out.println("Correct Answers: "+answers);
        result(Name,Enrollment,marks);
    }
    public static void result(String Name, String Enrollment, int marks){
        System.out.println("Your Result");
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("| %-20s | %-20s | %-8s | %-20s |%n","Name","Enrollment","Marks","Percentage");
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("| %-20s | %-20s | %-8s | %-20s |%n",Name,Enrollment,marks,(marks*100)/5 + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Name, Enrollment;
        System.out.println("\nQUIZ APP");
        System.out.println("\n1.Start");
        System.out.println("2.Exit");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.print("Enter Name: ");
                sc.nextLine();
                Name = sc.nextLine();
                System.out.print("Enter Enrollment: ");
                Enrollment = sc.nextLine();
                System.out.print("Are you ready for quiz? (y/n): ");
                char ready = sc.next().charAt(0);
                switch(ready){
                    case 'y':
                        quiz(Name, Enrollment);
                        break;
                    case 'n':
                        System.out.println("Please comeback when ready :'(");
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                }

                break;
            case 2:
                System.out.println("Bye");
                break;
            default :
                System.out.println("Please enter a valid choice");
        }
    }
}
