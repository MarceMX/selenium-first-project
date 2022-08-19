package org.marnunez;

import com.sun.tools.javac.Main;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-19
 */
@Slf4j
public class ReadPropertiesFile {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-19
	 */
	public void readFile() {
		String logID = "#ReadPropertiesFile():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			Properties p = new Properties();
//			FileInputStream f = new FileInputStream("C:\\Users\\HP\\Documents\\GitHub\\selenium-first-project\\src\\main\\resources\\myTest.properties");
			InputStream f = Main.class.getClassLoader().getResourceAsStream("myTest.properties");
			
			p.load(f);
			System.out.println(p.propertyNames());
			System.out.println(p.getProperty("name"));
			System.out.println(p.getProperty("course"));
			System.out.println(p.getProperty("time"));
			System.out.println(p.getProperty("topic"));
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Impossible instantiate class ReadPropertiesFile due to an internal error.", e);
		}
	}
}