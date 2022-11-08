package com.company;

import java.sql.*;
import java.util.Scanner;

public class program1JDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //git check
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String path = "jdbc:mysql://localhost:3306/tnpjava";
            String Username = "root";
            String password = "12345";
            Connection con = DriverManager.getConnection(path, Username, password);
            Statement st = con.createStatement();
            boolean askAgain = true;
            while(askAgain){
                System.out.println("\nMenu: ");
                System.out.println("1.Insert a Product");
                System.out.println("2.View Products");
                System.out.println("3.Update a Product");
                System.out.println("4.Delete a Product");
                System.out.println("5.exit");
                System.out.print("\n Choose an option: ");
                int choice = sc.nextInt();
                switch(choice){
                    case 1: //insert a product
                        System.out.print("Enter product name: ");
                        String pname = sc.next();
                        System.out.print("Enter product quantity: ");
                        String quantity = sc.next();
                        System.out.print("Enter product Price per quantity(in Rs): ");
                        String price = sc.next();
                        String ins_query="insert into product(PName,Quantity,Price) values('"+pname+"',"+quantity+","+price+")";
                        int ir = st.executeUpdate(ins_query);
                        if(ir>0) System.out.println("Product added successfully");
                        else System.out.println("Error in adding product");
                        break;
                    case 2: //view products
                        System.out.println("\tPID\t\tPName\t\t\tQuantity\t\tPrice per quantity(int Rs)");
                        System.out.println("--------------------------------------------------------------------------");
                        String sel_query = "Select * from product";
                        ResultSet rs = st.executeQuery(sel_query);
                        while(rs.next()){
                            String sel_pid = rs.getString("PID");
                            String sel_pname = rs.getString("PName");
                            String sel_quantity = rs.getString("Quantity");
                            String sel_price = rs.getString("Price");
                            System.out.println("\t"+sel_pid+"\t\t"+sel_pname+"\t\t\t\t"+sel_quantity+"\t\t\t\t"+sel_price);
                        }
                        break;
                    case 3: //update a product
                        System.out.print("Enter PID of product to update: ");
                        int pid1 = sc.nextInt();
                        System.out.println("What do you want to update?");
                        System.out.println("1.PName");
                        System.out.println("2.Price");
                        System.out.println("3.Quantity");
                        int choose = sc.nextInt();
                        String updateQuery=" ";
                        switch (choose){
                            case 1:
                                System.out.print("Enter new PName: ");
                                String newPName = sc.next();
                                updateQuery = "update product set PName='"+newPName+"' where PID="+pid1;
                                int ur1 = st.executeUpdate(updateQuery);
                                if(ur1>0) System.out.println("Product updated successfully");
                                else System.out.println("Error in updating product");
                                break;
                            case 2:
                                System.out.print("Enter new Price: ");
                                int newPrice = sc.nextInt();
                                updateQuery = "update product set Price="+newPrice+" where PID="+pid1;
                                int ur2 = st.executeUpdate(updateQuery);
                                if(ur2>0) System.out.println("Product updated successfully");
                                else System.out.println("Error in updating product");
                                break;
                            case 3:
                                System.out.print("Enter new Quantity: ");
                                int newQuantity = sc.nextInt();
                                updateQuery = "update product set Quantity="+newQuantity+" where PID="+pid1;
                                int ur3 = st.executeUpdate(updateQuery);
                                if(ur3>0) System.out.println("Product updated successfully");
                                else System.out.println("Error in updating product");
                                break;
                            default:
                                System.out.println("Please enter a valid choice");
                                break;
                        }

                        break;
                    case 4: //delete a product
                        System.out.print("Enter pid of product to delete: ");
                        int pid = sc.nextInt();
                        String del_query="delete from product where PID="+pid;
                        int dr = st.executeUpdate(del_query);
                        if(dr>0) System.out.println("Product deleted successfully");
                        else System.out.println("Error in deleting product");
                        break;
                    case 5: //exit
                        askAgain = false;
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                        break;
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
