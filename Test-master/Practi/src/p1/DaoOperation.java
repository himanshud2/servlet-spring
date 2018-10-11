package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoOperation {

	
	public boolean checkLogin(String username,String password){
		
		Connection con=ConnectionProvider.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Hospitallogin where hospital_username =? and hospital_password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			int result = ps.executeUpdate();
			
			if(result!=0){
				
				return true;
			}
			else{
				
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}//end checkLogin(){
	public ArrayList reterive(String username){
		ArrayList<Doctor> array=new ArrayList<Doctor>();
		
		Connection con=ConnectionProvider.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from HospitalSchedule where Name=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				 Doctor doctor=new Doctor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				 array.add(doctor);
			}
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
