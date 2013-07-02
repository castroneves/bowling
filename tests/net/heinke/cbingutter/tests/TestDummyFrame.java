package net.heinke.cbingutter.tests;

import junit.framework.Assert;
import net.heinke.cbingutter.game.exception.AvailiblePinsException;
import net.heinke.cbingutter.game.exception.NegativeScoreException;
import net.heinke.cbingutter.game.frame.SpareBonusDummyFrame;

import org.junit.Test;

public class TestDummyFrame {

	
		
		@Test(expected = AvailiblePinsException.class)
		public void testNotEnoughPins() throws Exception{
			SpareBonusDummyFrame f = new SpareBonusDummyFrame();
			f.playShot(11);
		}
		
		@Test(expected = NegativeScoreException.class)
		public void testNegativeScore() throws Exception{
			SpareBonusDummyFrame f = new SpareBonusDummyFrame();
			f.playShot(-5);
		}
		
		@Test
		public void testStrike() throws Exception{
			SpareBonusDummyFrame f = new SpareBonusDummyFrame();
			f.playShot(10);
			Assert.assertTrue(f.isStrike());
			Assert.assertTrue(f.isSpareOrStrike());
			Assert.assertTrue(!f.isSpare());
			Assert.assertEquals(f.pinsRemaining(), 0);
			Assert.assertTrue(f.isCompleted());
			Assert.assertEquals(f.getShotsTaken(), 1);
		}

		@Test
		public void testSingleShot() throws Exception{
			SpareBonusDummyFrame f = new SpareBonusDummyFrame();
			f.playShot(4);
			Assert.assertTrue(!f.isStrike());
			Assert.assertTrue(!f.isSpareOrStrike());
			Assert.assertTrue(!f.isSpare());
			Assert.assertEquals(f.pinsRemaining(), 6);
			Assert.assertTrue(f.isCompleted());
			Assert.assertEquals(f.getShotsTaken(), 1);
		}
		
		
	

}
