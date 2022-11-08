package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class program2JDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String path = "jdbc:mysql://localhost:3306/tnpjava";
            String Username = "root";
            String password = "12345";
            Connection con = DriverManager.getConnection(path, Username, password);
            Statement st = con.createStatement();
            boolean askAgain = true;
            while (askAgain){
                System.out.println("\nMenu: ");
                System.out.println("1.View Products");
                System.out.println("2.Sell a Product");
                System.out.println("3.exit");
                System.out.print("\n Choose an option: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1: //view products
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
                    case 2: //sell a product
                        System.out.print("Enter PID of the product to sell: ");
                        String pid = sc.next();
                        String sell_query = "Select * from product where PID="+pid;
                        ResultSet rs1 = st.executeQuery(sell_query);
                        String PName = " ";
                        int quan = 0;
                        int price = 0;
                        while(rs1.next()){
                            PName = rs1.getString("PName");
                            quan = rs1.getInt("Quantity");
                            price = rs1.getInt("Price");
                        }
                        System.out.println("Total Quantity of "+PName+" available is "+quan);
                        System.out.print("How many you want buy?: ");
                        int buy_quan= sc.nextInt();
                        if(buy_quan>quan || quan==0) System.out.println("Can't buy right now");
                        else{
                            System.out.println("Total price will be Rs."+buy_quan*price);
                            System.out.print("Enter 'y' to buy and 'n' to cancel: ");
                            char choose = sc.next().charAt(0);
                            switch (choose){
                                case 'y':
                                    int newQuantity = quan-buy_quan;
                                    String updateQuery = "update product set Quantity="+newQuantity+" where PID="+pid;
                                    int ur = st.executeUpdate(updateQuery);
                                    if(ur>0) System.out.println("Product bought successfully");
                                    else System.out.println("Error in buying product");
                                    break;
                                case 'n':
                                    System.out.println("Thanks for coming");
                                    break;
                            }
                        }
                        break;

                    case 3: //exit
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
