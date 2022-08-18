package org.marnunez;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-17
 */
@Slf4j
public class ExecutionUtils {
	/**
	 * Will allow user to see the action performed in screen for a period of time prior to continue.
	 */
	public static void waitSec() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new RuntimeException("Error while waiting",e);
		}
	}
}