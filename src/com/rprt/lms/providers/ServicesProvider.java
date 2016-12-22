package com.rprt.lms.providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.services.LoanServices;

public class ServicesProvider {
		public static LoanServices getBankServices() throws ServiceNotFoundException{
			try {
				FileInputStream src = new FileInputStream("C://Users//admin//workspace//LoanManagementSystem//Resources//lms.properties");
				Properties p = new Properties();
				p.load(src);
				String bankservicesimpl = p.getProperty("bankservicesimpl");
				@SuppressWarnings("rawtypes")
				Class c = Class.forName(bankservicesimpl);
				return (LoanServices) c.newInstance();
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

