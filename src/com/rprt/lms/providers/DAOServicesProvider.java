package com.rprt.lms.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.rprt.lms.DAOInterface.DAOService;
import com.rprt.lms.exceptions.ServiceNotFoundException;

public class DAOServicesProvider {
		public static DAOService getDAOServices() throws ServiceNotFoundException{
			try {
				FileInputStream src = new FileInputStream(new File("C://Users//admin//workspace//LoanManagementSystem//Resources//lms.properties"));
				Properties p = new Properties();
				p.load(src);
				String bankreposervicesimpl = p.getProperty("bankreposervicesimpl");
				@SuppressWarnings("rawtypes")
				Class c = Class.forName(bankreposervicesimpl);
				return (DAOService) c.newInstance();
			} catch (FileNotFoundException e) {
				throw new ServiceNotFoundException("Bank service not found",e);
			} catch (ClassNotFoundException e) {
				throw new ServiceNotFoundException("Bank service not found",e);
			} catch (InstantiationException e) {
				throw new ServiceNotFoundException("Bank service not found",e);
			} catch (IllegalAccessException e) {
				throw new ServiceNotFoundException("Bank service not found",e);
			} catch (IOException e) {
				throw new ServiceNotFoundException("Bank service not found",e);
			}
	}
}
