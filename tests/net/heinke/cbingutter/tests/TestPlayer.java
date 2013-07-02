package net.heinke.cbingutter.tests;

import java.util.List;

import junit.framework.Assert;
import net.heinke.cbingutter.game.Constants;
import net.heinke.cbingutter.game.frame.Frame;
import net.heinke.cbingutter.game.player.Player;

import org.junit.Test;

public class TestPlayer {
	@Test
	public void testFinalFrameAllStrike() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(10);
		Assert.assertEquals(a.getRunningTotal(), 30);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalFrameStrikeSpare() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertEquals(a.getRunningTotal(), 20);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalFrameStrikePinsRemain() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(4);
		Assert.assertEquals(a.getRunningTotal(), 19);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalFrameStrikeStrikeNormal() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(10);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertEquals(a.getRunningTotal(), 25);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalFrameSpareStrike() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(10);
		Assert.assertEquals(a.getRunningTotal(), 20);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalFrameSpareNormal() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(5);
		Assert.assertEquals(a.getRunningTotal(), 15);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	@Test
	public void testFinalNormal() throws Exception{
		Player a = new Player("steve", 1);
		a.playShot(5);
		Assert.assertTrue(!a.hasConcludedTurn());
		a.playShot(4);
		Assert.assertEquals(a.getRunningTotal(), 9);
		Assert.assertTrue(a.hasConcludedTurn());
	}
	
	@Test
	public void testLookbackStrikeSpare() throws Exception{
		Player a = new Player("steve", 4);
		a.playShot(10);
		a.playShot(10);
		a.playShot(5);
		a.playShot(5);
		List<Frame> frames =  a.getFrames();
		Assert.assertEquals(frames.get(0).getAbsoluteScore(), 25);
		Assert.assertEquals(frames.get(1).getAbsoluteScore(), 20);
		Assert.assertEquals(frames.get(2).getAbsoluteScore(), Constants.DUMMY_ABS_SCORE);
	}
	@Test
	public void testLookbackSpareNormal() throws Exception{
		Player a = new Player("steve", 4);
		a.playShot(10);
		a.playShot(5);
		a.playShot(5);
		a.playShot(5);
		a.playShot(4);
		List<Frame> frames =  a.getFrames();
		Assert.assertEquals(frames.get(0).getAbsoluteScore(), 20);
		Assert.assertEquals(frames.get(1).getAbsoluteScore(), 15);
		Assert.assertEquals(frames.get(2).getAbsoluteScore(), 9);
	}
	
}
