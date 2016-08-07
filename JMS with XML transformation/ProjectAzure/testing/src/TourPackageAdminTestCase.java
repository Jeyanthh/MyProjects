import static org.junit.Assert.*;

import org.junit.Test;

import com.projectazure.dao.TourPackageAdminDao;
import com.projectazure.hibernate.beans.TourPackage;


public class TourPackageAdminTestCase {

	@Test
	public void testAddPackage() {
		//fail("Not yet implemented");
		TourPackageAdminDao dao=new TourPackageAdminDao();
		 assertTrue(dao.addPackage(new TourPackage("kodaikanal-cool","2D/3N", "Kodaikanal", 2000)));
	}

	@Test
	public void testRetrieveTourPackage() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUpdatePackage() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdatePackage() {
		//fail("Not yet implemented");
	}

}
