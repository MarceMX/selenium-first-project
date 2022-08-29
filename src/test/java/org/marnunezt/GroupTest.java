package org.marnunezt;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * TODO: Complete class documentation
 *
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
 * @since 2022-Aug-29
 */
@Slf4j
public class GroupTest {
	
	/**
	 * Class Constructor. No Requirement Reference
	 *
	 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
	 * @since 2022-Aug-29
	 */
	@Test (groups = {"smoke"})
	public void A() {
			System.out.println("A Test done...");
	}
	@Test (groups = {"regression"})
	public void B() {
		System.out.println("B Test done...");
	}
	@Test (groups = {"smoke"})
	public void C() {
		System.out.println("C Test done...");
	}
	@Test (groups = {"smoke", "regression"})
	public void D() {
		System.out.println("D Test done...");
	}
	@Test (groups = {"smoke","functional", "regression"})
	public void E() {
		System.out.println("E Test done...");
	}
	@Test (groups = {"smoke"})
	public void F() {
		System.out.println("F Test done...");
	}
	@Test (groups = {"functional"})
	public void G() {
		System.out.println("G Test done...");
	}
}