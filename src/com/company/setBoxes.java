package com.company;

import java.util.*;

class Box{
    double length, width, height, volume;
    Box(double length, double width, double height){
        this.length=length;
        this.width=width;
        this.height=height;

        this.volume = length*width*height;
    }
}
public class setBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Box> boxSet = new HashSet<>();
        Set<Double> volBox = new HashSet<>();
        System.out.print("No of boxes: ");
        int t=sc.nextInt();
        int i=1;
        while(t!=0){
            System.out.println("Box-"+i);
            System.out.print("Enter length of the box:");
            double length = sc.nextDouble();
            System.out.print("Enter width of the box:");
            double width = sc.nextDouble();
            System.out.print("Enter height of the box:");
            double height = sc.nextDouble();
            Box b1 = new Box(length,width,height);
            if(volBox.contains(b1.volume)){
                System.out.println("Same Volume so skipped ;)");
            }
            else{
                volBox.add(b1.volume);
                boxSet.add(b1);
            }
            i++;
            t--;
        }
        Box[] box = new Box[boxSet.size()];
        boxSet.toArray(box);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n","Length","Width","Height","Volume");
        System.out.printf("---------------------------------------------------------------------------------------------%n");
        for(Box b: box){
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n",b.length,b.width,b.height,b.volume);
        }

    }
}
