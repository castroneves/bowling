package net.heinke.cbingutter.tests;

import junit.framework.Assert;
import net.heinke.cbingutter.game.player.Player;
import net.heinke.cbingutter.game.scoreboard.Validator;

import org.junit.Test;

public class TestValidator {

	@Test
	public void testNegativeScore(){
		Player a = new Player("Tim");
		boolean result = Validator.validateScore("-1", a);
		Assert.assertTrue(!result);
	}
	
	@Test
	public void testRandomString(){
		Player a = new Player("Tim");
		boolean result = Validator.validateScore("bazinga", a);
		Assert.assertTrue(!result);
	}
	@Test
	public void testTooManyPins(){
		Player a = new Player("Tim");
		boolean result = Validator.validateScore("11", a);
		Assert.assertTrue(!result);
	}
	@Test
	public void testNotEnoughRemainingPins() throws Exception{
		Player a = new Player("Tim");
		a.playShot(4);
		boolean result = Validator.validateScore("7", a);
		Assert.assertTrue(!result);
	}
	
	@Test
	public void testStrikeSecondShot() throws Exception{
		Player a = new Player("Tim");
		a.playShot(4);
		boolean result = Validator.validateScore("X", a);
		Assert.assertTrue(!result);
	}
	@Test
	public void testSpareFirstShot() throws Exception{
		Player a = new Player("Tim");
		boolean result = Validator.validateScore("/", a);
		Assert.assertTrue(!result);
	}
}
