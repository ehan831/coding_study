package jfreechart;

import java.sql.*;
import java.util.*;

public class Database {

	String URL = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
	String USER ="scott";
	String PASS = "tiger";

	public ArrayList<ArrayList> getData() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			
			//***************************************************************
			String sql = "SELECT TO_CHAR(HIREDATE, 'MM') hire_month, COUNT(*) count  " +
					"FROM emp  " +
					"GROUP BY TO_CHAR(HIREDATE, 'MM')  " +
					"ORDER BY hire_month";
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();

			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getString("hire_month"));				//****************
				temp.add( rset.getInt("count"));		//****************
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
