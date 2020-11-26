package com.insure.quote.utils;
public class InsuredDbQueries {
public static final String ACCOUNT_CREATION = "insert into Accounts values(accountnumber.nextval,?,?,?,?,?,?,?)";	
public static final String VALIDATE_ACCOUNT_QUERY ="select * from Accounts where username = ?";
public static final String GET_INSURED_POLICY = "select * from Policy where Accountnumber = ? ";
public static final String GET_LOB_NAME = "select bus_seg_id from Business_Segment where bus_seg_name = ?";
public static final String USER_EXISTS = "select * from UserRole where username = ?";
public static final String GET_ACCOUNT_NUMBER = "select accountnumber from Accounts where username = ? ";
}
