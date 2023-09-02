import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook g1;
	private GradeBook g2;
	private GradeBook g3;

	@BeforeEach
	void setUp() throws Exception
	{
		g1 = new GradeBook(5);
		g2 = new GradeBook(4);
		g3 = new GradeBook(7);
		
		g1.addScore(1);
		g1.addScore(2);
		g1.addScore(3);
		g1.addScore(0);
		
		g2.addScore(2);
		g2.addScore(6);
		g2.addScore(7);
		g2.addScore(8);
		
		g3.addScore(6);
		g3.addScore(7);
		g3.addScore(8);
		g3.addScore(9);
		
		
	}

	@AfterEach
	void tearDown() throws Exception
	{
		g1 = null;
		g2 = null;
		g3 = null;
		
	}

	@Test
	void testAddScore() 
	{
		assertTrue(g1.addScore(10));
		assertFalse(g2.addScore(13));
		assertEquals(true, g3.addScore(8));	
	}

	@Test
	void testSum()
	{
		 // assertTrue(g1.sum());
		//assertFalse(g2.sum(13));
		assertEquals(23, g2.sum());
		assertTrue((g1.sum()) == 6);
		assertFalse(g3.sum() != 30);
		
		
	}

	@Test
	void testMinimum() 
	{
		assertEquals(2, g2.minimum());
		assertFalse(g1.minimum() != 0);
		assertTrue(g3.minimum() == 6);


	}

	@Test
	void testFinalScore() 
	{
		assertEquals(6.0, g1.finalScore());
		assertTrue(g2.finalScore() == 21 );
		assertFalse(g3.finalScore() != 24);

	}
	

}
