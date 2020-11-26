package com.insure.quote.utils;
public class AgentDBQueries {
	 public static final String USER_EXISTS_IN_ACCOUNT = "select username from accounts where username = ?"; 
	 public static final String ACCOUNT_CREATION = "insert into accounts values(accountnumber.next,?,?,?,?,?,?,?)"; 
	 public static final  String VALIDATE_ACCOUNT_QUERY ="select * from accounts where username = ?";	 
	 public static final  String GET_LOB_NAME = "select bus_seg_id from business_segment where bus_seg_name = ?";		
	 public static final  String VALIDATE_ACCOUNT = "select * from accounts where accountnumber = ?";
	 public static final  String GET_BUS_SEG_ID = "select lineofbusiness from accounts where accountnumber = ?";
	 public static final  String GET_POLICY_QUESTIONS = "select * from policy_questions where bus_seg_id = ?";
	 public static final  String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? between pre_ans_weightage_min and pre_ans_weightage_max";
	 public static final  String CREATE_POLICY = "insert into policy values(policynumber.nextval, ?, ?)"; 
	 public static final String GET_POLICY_NUMBER = "select max(policynumber) from policy";
	 public static final  String ADD_POLICY_DETAILS = "insert into policydetails values(?,?,?)";
	 public static final  String GET_POLICIES = "select * from policy where accountnumber= ?";
	 public static final  String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
	 public static final  String GET_BUS_SEG_NAME = "select bus_seg_name from business_segment where bus_seg_id = ?";
	 public static final  String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
	 public static final  String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
	 public static final  String GET_ACCOUNT_NUMBER="select accountnumber from accounts where username=?";
	

}
