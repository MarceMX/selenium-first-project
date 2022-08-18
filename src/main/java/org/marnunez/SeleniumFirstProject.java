package org.marnunez;

import lombok.extern.slf4j.Slf4j;

/**
 * Main Class of the project.
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-17
 */
@Slf4j
public class SeleniumFirstProject {
	
	//region My Methods
	
	
	/**
	 * Main method of the application.
	 * This is the method that will launch the main process and run the provided application.
	 * This is a special method of the language used to launch the main thread;
	 * <a href='https://www.oracle.com/java/technologies/jpl1-building-applications.html#class'> more information</a>.
	 *
	 * @param args {@link String} Arguments provided by the caller of the application (Often omitted)
	 * @author HP
	 * @since 2022/08/17
	 */
	public static void main(String[] args) {
		String logID = "::main(args[]): ";
		log.trace("{}Start", logID);
		try {
//			new InteractionsWithButtons().execute();
//			new InteractionsWithButtonsUsingActions().execute();
//			new InteractionsWithSelect().dropDownSelect();
			new InteractWithAlerts().clickAlerts();
			
			
			log.trace("{}Finish", logID);
			
		} catch (Exception e) {
			throw new RuntimeException("Impossible to launch application ", e);
		}
	}
	
	
	//endregion
}