/**
 * Copyright 2015 Ibrahim Chaehoi
 * 
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.christophkraemer.rhino.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Assert;
import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

/**
 * Unit test for JS Native function
 * 
 * @author Ibrahim Chaehoi
 */
public class JSNativeFunctionTest {

	private String testScript = "var FRUITS = 'apple orange banana';\n"
			+ "var COLORS = 'red green yellow';\n"
			+ "var RESERVED_WORDS = FRUITS + ' ' + COLORS;\n"
			+" (function(){\n"
			+ "var words = RESERVED_WORDS.split(' ');\n"
			+ "return words.length})()";
	
	@Test
	public void testScriptWithGlobalNativeRhinoObject() throws ScriptException{
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine scriptEngine = manager.getEngineByName("mozilla.rhino");
		Object result = scriptEngine.eval(testScript);
		
		Assert.assertEquals(6, ((Number)result).intValue());
	}
	
	@Test
	public void testWithStdRhinoScriptWithGlobalNativeRhinoObject() throws ScriptException{
		
		Context context = Context.enter();
		context.setOptimizationLevel(-1);
		ScriptableObject scope = context.initStandardObjects();
		Object result = null;
		try {
			Context ctx = Context.getCurrentContext();
			result = ctx.evaluateString(scope, testScript, "test", 0,
					null);
		} finally {
			if (Context.getCurrentContext() != null) {
				Context.exit();
			}
		}
		
		Assert.assertEquals(6, ((Number)result).intValue());
	}
}
