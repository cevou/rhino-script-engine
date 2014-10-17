rhino-script-engine
===================

This is a copy of the RhinoScriptEngine which is embedded in Java 6/7.
There an old version of Rhino (1.7R3) is used. The code in this repository
uses the latest rhino version. This is only needed if you want to use the
latest version of Rhino in the context of a ScriptEngine in Java 6/7. In 
Java 8 Nashorn is used as default ScriptEngine for JavaScript.


Using
-----

Include the rhino-script-engine in your Maven POM.

```
<dependency>
  <groupId>de.christophkraemer</groupId>
  <artifactId>rhino-script-engine</artifactId>
  <version>1.0.1</version>
</dependency>
```

The ScriptEngine should be automatically found by the ScriptEngineFactory.

License
-------

This code is free software; you can redistribute it and/or modify it
under the terms of the GNU General Public License version 2 only, as
published by the Free Software Foundation.  Oracle designates this
particular file as subject to the "Classpath" exception as provided
by Oracle in the LICENSE file that accompanied this code.