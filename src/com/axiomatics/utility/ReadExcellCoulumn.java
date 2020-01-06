package com.axiomatics.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadExcellCoulumn {
	
	//private static String excellSpreadsheet = "./Excell SpreadSheet/Customers List in SalesForce.xls";
	private static final String csvFile 	= "./Excell SpreadSheet/Customers List in SalesForce.csv";
	private static final String EMPTY 		= "\"\"";
	private static final String TARGET 		= "\"Target\"";
	private static final String PROSPECT 	= "\"Prospect\"";

	public static void main(String[] args) {
		ReadExcellCoulumn excell = new ReadExcellCoulumn();

		System.out.println("Testing - Read Excell Spreadsheet");
		
		excell.readExcell(csvFile);
		System.out.println("Testing - End");

	}
	
	public List<Account> readExcell(String csvfile)
	{		
        String line 		= "";
        String cvsSplitBy 	= ",";
        String typeAccount	= null;
        String nameAccount	= null;
        List<Account> accountList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {

            //while ((line = br.readLine()) != null) {
            while (!(line = br.readLine()).equalsIgnoreCase(""))
            {

                // use comma as separator
            	Account account = new Account();
                String[] field = line.split(cvsSplitBy);
                
                account.setTypeAccount(field[2]);
                typeAccount = field[2];
                
                account.setNameAccount(field[1]);
                nameAccount = field[1];
	
                switch(typeAccount){
                case EMPTY:
                case TARGET:
                case PROSPECT:
                	System.out.println("Account Name = " + nameAccount + " , Type = " + typeAccount );
                }
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return accountList;
	}

}
