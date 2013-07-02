package net.heinke.cbingutter.tests;

import junit.framework.Assert;
import net.heinke.cbingutter.game.exception.AvailiblePinsException;
import net.heinke.cbingutter.game.exception.NegativeScoreException;
import net.heinke.cbingutter.game.exception.TooManyShotsException;
import net.heinke.cbingutter.game.frame.RegularFrame;

import org.junit.Test;

public class TestFrame {

	
	@Test(expected = AvailiblePinsException.class)
	public void testNotEnoughPins() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(5);
		f.playShot(10);
	}
	
	@Test(expected = NegativeScoreException.class)
	public void testNegativeScore() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(-5);
	}
	
	@Test(expected = TooManyShotsException.class)
	public void testTooManyBowls() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(5);
		f.playShot(1);
		f.playShot(1);
	}
	
	@Test
	public void testStrike() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(10);
		Assert.assertTrue(f.isStrike());
		Assert.assertTrue(f.isSpareOrStrike());
		Assert.assertTrue(!f.isSpare());
		Assert.assertEquals(f.pinsRemaining(), 0);
		Assert.assertTrue(f.isCompleted());
		Assert.assertEquals(f.getShotsTaken(), 1);
	}
	
	@Test
	public void testSpare() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(6);
		f.playShot(4);
		Assert.assertTrue(!f.isStrike());
		Assert.assertTrue(f.isSpareOrStrike());
		Assert.assertTrue(f.isSpare());
		Assert.assertEquals(f.pinsRemaining(), 0);
		Assert.assertTrue(f.isCompleted());
		Assert.assertEquals(f.getShotsTaken(), 2);
	}
	
	@Test
	public void testNonStrikeOrSpare() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(4);
		f.playShot(2);
		Assert.assertTrue(!f.isStrike());
		Assert.assertTrue(!f.isSpareOrStrike());
		Assert.assertTrue(!f.isSpare());
		Assert.assertEquals(f.pinsRemaining(), 4);
		Assert.assertTrue(f.isCompleted());
		Assert.assertEquals(f.getShotsTaken(), 2);
	}
	
	@Test
	public void testSingleShot() throws Exception{
		RegularFrame f = new RegularFrame();
		f.playShot(4);
		Assert.assertTrue(!f.isStrike());
		Assert.assertTrue(!f.isSpareOrStrike());
		Assert.assertTrue(!f.isSpare());
		Assert.assertEquals(f.pinsRemaining(), 6);
		Assert.assertTrue(!f.isCompleted());
		Assert.assertEquals(f.getShotsTaken(), 1);
	}
	
	
}
