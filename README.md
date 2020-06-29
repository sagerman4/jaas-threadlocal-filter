# jaas-threadlocal-filter
This is a test test test
A Java servlet filter that grabs the JAAS principal and puts it on a ThreadLocal variable.

##Why

So, you know how you're writing a Java app and you are floating around in some server-side Java and all of a sudden you think, "Damn.  I need the username! Where the hell am I going to get that? This is just a POJO! I'm going to have to make it an EJB or Spring component or wire in some kind of security context...ugh."

##No, you don't.

Just use this thing.  It grabs the user ID from JAAS and uses it to create a class instance local to the thread that you can access whenever you want, wherever you want.

##Filter Configuration

In your web.xml:

```
<filter>
  <filter-name>JaasThreadlocalFilter</filter-name>
  <filter-class>sharkmeat.auth.JaasLoginFilter</filter-class>
</filter>
<filter>
  <filter-name>JaasThreadlocalFilter</filter-name>
  <url-pattern>*</url-pattern>
</filter>
```

This is the basic configuration for any simple filter, but you can use filters all sorts of different ways.  I'm not going to document that stuff, though.  It's boring.

##Dependency Setup

If you are using Maven, just add this in your pom.xml:

```
<dependency>
  <groupId>com.github.sagerman4</groupId>
  <artifactId>jaas-threadlocal-filter</artifactId>
  <version>1.0</version>
</dependency>
```

If you are using Gradle, then add this little line to your build.gradle dependencies:

```
compile group: 'com.github.sagerman4', name: 'jaas-threadlocal-filter', version: '1.0'
```

##Usage

```
final String userId = AuthContext.getAuthState().getUserId();
```

Done.  Win.  Champions.
