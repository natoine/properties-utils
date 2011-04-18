/*
 * Copyright 2010 Antoine Seilles (Natoine)
 *   This file is part of properties-utils.

    model-annotation is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    model-annotation is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with model-annotation.  If not, see <http://www.gnu.org/licenses/>.

 */
package fr.natoine.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PropertiesUtils 
{

	public static Properties loadDefault( String _file_path)
	{
		// create and load default properties
		Properties defaultProps = new Properties();
		FileInputStream in;
		try 
		{
			in = new FileInputStream(_file_path);
			defaultProps.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("[PropertiesUtils.loadDefault] no properties file to load for default properties");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[PropertiesUtils.loadDefault] pb with file to load for default properties");
			e.printStackTrace();
		}
		// create application properties with default
		return new Properties(defaultProps);
	}
	
	public static Properties loadLastState(Properties applicationProps , String _file_path)
	{
		FileInputStream in;
		// now load properties from last invocation
		try {
			in = new FileInputStream(_file_path);
			applicationProps.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("[PropertiesUtils.loadLastState] no properties file to load since last use of the app");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[PropertiesUtils.loadLastState] pb with file to load for properties since last use of the app");
			e.printStackTrace();
		}
		return applicationProps ;
	}
	
	public static void store(Properties applicationProps , String _file_path, String comments)
	{
		File output_file = new File(_file_path);
		OutputStream _out;
		try 
		{
			_out = new FileOutputStream(output_file);
			applicationProps.store(_out , comments);
		}
		catch (FileNotFoundException e) {
			System.out.println("[PropertiesUtils.store] unable to store cause the file : " + _file_path + "doesn't exist...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[PropertiesUtils.store] unable to store cause IO pb manipulating the file : " + _file_path );
			e.printStackTrace();
		}
	}
}
