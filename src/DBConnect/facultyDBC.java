/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnect;

import java.sql.*;

/**
 *
 * @author HP
 */


public class facultyDBC{
	public static void main(String arg[])throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		System.out.println("connect");
		
		try{
			Connection con=DriverManager.getConnection("jdbc:ucanaccess://E:\\6.Database\\usindh.accdb");
			
			String query="select fac_id,fac_name,remarks from faculty";
			System.out.println(query);
			
			Statement st=con.createStatement();
			ResultSet result=st.executeQuery(query);
			
			while(result.next()){
				String facId=result.getString("fac_id");
				String facName=result.getString("fac_name");
				String remarks=result.getString("remarks");
				System.out.println("Fac_Id:"+facId);
				System.out.println("Fac_Name:"+facName);
				System.out.println("remarks:"+remarks);
				System.out.println("*******************");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Close Connection");
	}
}






