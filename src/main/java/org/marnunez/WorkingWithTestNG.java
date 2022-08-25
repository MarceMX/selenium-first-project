package org.marnunez;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-23
 */
@Slf4j
public class WorkingWithTestNG {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-23
	 */
	public void firstTest() {
		String logID = "#WorkingWithTestNG():";
		log.trace("{} Start", logID);
		//checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
		try {
			
			System.out.println("First Test?...");
			
			log.trace("{} Finish.", logID);
		} catch (Exception e) {
			throw new RuntimeException("Impossible instantiate class WorkingWithTestNG due to an internal error.", e);
		}
	}
}