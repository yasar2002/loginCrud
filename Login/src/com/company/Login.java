package com.company;


import java.sql.*;
import java.util.Scanner;

public class Login {
    static void Login(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Please enter your Mail or MobileNo: ");
        String email = sc.nextLine();
        System.out.print("Please enter your Password: ");
        String pass = sc.nextLine();
        PreparedStatement stmt = conn.prepareStatement("select * from CustomerDetails  where Email_id or Mobile_Number = ? and Password=?");
        stmt.setString(1, email);
        stmt.setString(2, pass);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            System.out.println("Your email or password is incorrect");
        } else {
            System.out.println("Hi " + rs.getString(2) + " You are LoggedIn successfully");
        }
    }

    public static void userData(Connection conn, Scanner sc) throws SQLException {

        PreparedStatement st = conn.prepareStatement("insert into CustomerDetails(Name,Email_id,Mobile_Number,Password) values(?,?,?,?)");
        System.out.print("Please enter the Name : ");
        st.setString(1, sc.nextLine());
        System.out.print("Please enter the EmailId : ");
        st.setString(2, sc.nextLine());
        System.out.print("Please enter the MobileNo : ");
        st.setString(3, sc.nextLine());
        System.out.print("Please enter the Password : ");
        st.setString(4, sc.nextLine());
        st.executeUpdate();
        System.out.println("Updated Successfully");
    }

    public static void fetchData(Connection con, Scanner scan) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from CustomerDetails  where Email_id = ?");
        System.out.print("Please enter your mail: ");
        stmt.setString(1, scan.nextLine());
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            System.out.println("Your Email Id is Not Valid \n Please Sign up");
        }
        while (rs.next()) {
            System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
        }
    }

    public static void UpdateData(Connection con, Scanner sc) throws SQLException {
        boolean flag = true;
        while (flag) {
            System.out.print("Which you want to update : \n 1)Name \n 2)Mail \n 3)MobileNo \n 4)Password");
            int opt = sc.nextInt();
            System.out.print("Enter your number : ");
            sc.nextLine();
            String num = sc.nextLine();
            switch (opt) {
                case 1:
                    PreparedStatement stmt = con.prepareStatement("update CustomerDetails set Name = ? where Mobile_Number = ?");
                    stmt.setString(2, num);
                    System.out.print("Enter the name : ");
                    stmt.setString(1, sc.nextLine());
                    int rs = stmt.executeUpdate();
                    if (rs == 0) {
                        System.out.println("Failed, Your input is wrong. Please try again");
                    } else {
                        System.out.println("Your name Updated Successfully");
                        System.out.println("Do you want to continue[Y/N]? : ");
                        String que = sc.nextLine();
                        if (que.charAt(0) == 'N' || que.charAt(0) == 'n') flag = false;
                    }
                    break;
                case 2:
                    PreparedStatement stmt1 = con.prepareStatement("update CustomerDetails set Email_id = ? where Mobile_Number = ?");
                    stmt1.setString(2, num);
                    System.out.print("Enter the Mail Id : ");
                    stmt1.setString(1, sc.nextLine());
                    int rs1 = stmt1.executeUpdate();
                    if (rs1 == 0) {
                        System.out.println("Failed, Your input is wrong. Please try again");
                    } else {
                        System.out.println("Your Mail Updated Successfully");
                        System.out.println("Do you want to continue[Y/N]? : ");
                        String que = sc.nextLine();
                        if (que.charAt(0) == 'N' || que.charAt(0) == 'n') flag = false;
                    }
                    break;
                case 3:
                    PreparedStatement stmt2 = con.prepareStatement("update CustomerDetails set Mobile_Number = ? where Mobile_Number = ?");
                    stmt2.setString(2, num);
                    System.out.print("Enter the Mobile Number : ");
                    stmt2.setString(1, sc.nextLine());
                    int rs2 = stmt2.executeUpdate();
                    if (rs2 == 0) {
                        System.out.println("Failed, Your input is wrong. Please try again");
                    } else {
                        System.out.println("Your Mobile Number Updated Successfully");
                        System.out.println("Do you want to continue[Y/N]? : ");
                        String que = sc.nextLine();
                        if (que.charAt(0) == 'N' || que.charAt(0) == 'n') flag = false;
                    }
                    break;
                case 4:
                    PreparedStatement stmt3 = con.prepareStatement("update CustomerDetails set Password = ? where Mobile_Number = ?");
                    stmt3.setString(2, num);

                    System.out.print("Enter the New Password : ");
                    String pass1 = sc.nextLine();
                    System.out.print("Confirm Password : ");
                    String pass2 = sc.nextLine();
                    if (pass1.equals(pass2)) {
                        stmt3.setString(1, pass1);
                        int rs3 = stmt3.executeUpdate();
                        if (rs3 == 0) {
                            System.out.println("Failed, Your number is wrong. Please try again");
                        } else {
                            System.out.println("Your Password Updated Successfully");
                            System.out.println("Do you want to continue[Y/N]? : ");
                            String que = sc.nextLine();
                            if (que.charAt(0) == 'N' || que.charAt(0) == 'n') flag = false;
                        }
                    } else {
                        System.out.println("Please enter the correct one");
                    }
                    break;
            }

        }
    }

    public static void deleteData(Connection con, Scanner scan) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("delete from CustomerDetails where Mobile_Number=?");
        System.out.print("Please enter your Mobile number you want to delete :");
        String number = scan.nextLine();
        stmt.setString(1, number);
        System.out.print("Are you sure you want to delete? [Y,N] ");
        String opt = scan.nextLine();
        if (opt.charAt(0) == 'Y' || opt.charAt(0) == 'y') {
            int rs = stmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Your Mobile number is invalid");
            } else {
                System.out.println("Your data is successfully deleted");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDetails", "root", "");
//          userData(conn,sc);
//          fetchData(conn,sc);
          Login(conn,sc);
//            deleteData(conn, sc);
//          UpdateData(conn,sc);
//          PreparedStatement ps = conn.prepareStatement("select * from CustomerDetails");
//          ResultSet rs = ps.executeQuery();
//          while(rs.next()){
//          System.out.println(rs.getString(1)+" "+rs.getString(1));
//          }

        } catch (SQLException | ClassNotFoundException SE) {
            System.out.println(SE);
        }
    }
}
