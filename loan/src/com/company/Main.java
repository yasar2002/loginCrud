package com.company;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String filePath = "/home/yasar-zstk264/IdeaProjects/loan/src/log4j.properties";
            PropertyConfigurator.configure(filePath);
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            String name = scan.nextLine();
            if (name.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }
            System.out.print("Please enter your mobile number: ");
            String num = scan.nextLine();
            int number;
            if (num.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            } else {
                number = Integer.valueOf(num);
            }
            System.out.print("Please enter your age: ");
            String agechk = scan.nextLine();
            int age = 0;
            if (agechk.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            } else {
                age = Integer.valueOf(agechk);
            }
            if (age < 18) {
                throw new LoggerException("Your are not Eligible to aplly loans");
            }
            System.out.print("Type of Loan(Personal Loan/Home Loan/Car Loan) : ");
            String type = scan.nextLine();
            if (type.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }
            System.out.print("What's your Occupation : ");
            String occ = scan.nextLine();
            if (occ.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }

            System.out.print("Which place are you working : ");
            String place = scan.nextLine();
            if (place.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }
            System.out.print("Do you have any Id Proof? [Yes/No] : ");
            String option = scan.nextLine().toLowerCase();
            if (option.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }
            System.out.println("What proof document you are going to submit(in numbers):\n1)Passport\n2)Driving License\n3)Voter's Id\n4)Aadhar Card\n5)None");
            String prf = scan.nextLine();
            int proof;
            if (prf.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            } else {
                proof = Integer.valueOf(prf);
            }
            if ((proof < 1 || proof > 4) || option.charAt(0) == 'n') {
                throw new LoggerException("You did'nt provided any documents");
            }
            System.out.print("What is your monthly salary : ");
            String amt = scan.nextLine();
            int salaryamount;
            if (amt.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            } else {
                salaryamount = Integer.parseInt(amt);
            }
            System.out.print("Do you have salary certificate?[Y|N] : ");
            scan.nextLine();
            String opt = scan.nextLine().toLowerCase();
            if (opt.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }
            System.out.print("Enter the loan amount : ");
            int amount;
            String amnt = scan.nextLine();
            if (amnt.isEmpty()) {
                throw new LoggerException("You have not entered any value, Please enter the value");
            }else{
                amount = Integer.parseInt(amnt);
            }
            if (amount < 25000) {
                throw new LoggerException("Sorry, loan amount is very less");
            } else if (amount > 100000 && salaryamount < 5000) {
                throw new LoggerException("Sorry, you may not be eligible for this loan amount");
            } else if (amount > 1000000) {
                throw new LoggerException("Loan for this amount is not possible if we don’t have surety or Guarantee");
            }
            System.out.println("You are eligible for loan");
            System.out.println("Thanks for Using :) ");

        } catch (LoggerException le) {
            System.out.println("Eror Occured");
        }
    }
}

class LoggerException extends Exception {
    final static Logger logger = Logger.getLogger(LoggerException.class);

    LoggerException(String str) {
        logger.log(Level.ERROR, str);
    }
}

