package com.rprt.lms.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.rprt.lms.exceptions.ServiceNotFoundException;

public class DBUtil {
	public static Connection getConnection() throws ServiceNotFoundException{
		try {
			FileInputStream src = new FileInputStream(new File("C://Users//admin//workspace//LoanManagementSystem//Resources//lms.properties"));
			Properties p = new Properties();
			p.load(src);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
			
		} catch (FileNotFoundException e) {
			throw new ServiceNotFoundException("Bank service not found",e);
		} catch (ClassNotFoundException e) {
			throw new ServiceNotFoundException("Bank service not found",e);
		} catch (IOException e) {
			throw new ServiceNotFoundException("Bank service not found",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
