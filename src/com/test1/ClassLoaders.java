package com.test1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaders {
 
	public static void main(String[] args) {
		
		// String class is loaded by bootstrap loader which is parent of all class loaders in java,
		// which are Extension and Application or System class loader.
		// Bootstrap loader is responsible for loading all standard JDK classes from rt.jar which is present in jre/lib/ directory
		// Extension class loader delegates class loading request to its parent i.e. Bootstrap loader,
		// if unsuccessful loads classes from jre/lib/ext directory.
		// Extension class loader in JVM is implemented by sun.misc.Launcher$ExtClassLoader.
		System.out.println(String.class.getClassLoader());
		
		// Application class loader is child of Extension class loader 
		// which is responsible for loading application specific classes mentioned in classpath environment variable
		// Application class loader is implemented by sun.misc.Launcher$AppClassLoader
		System.out.println(ClassLoaders.class.getClassLoader());
		
		// Except Bootstrap class loader, which is implemented in native language mostly in C,
		// all Java class loaders are implemented using java.lang.ClassLoader.

		
		// Class is loaded by calling loadClass() method of java.lang.ClassLoader class which calls findClass()
		// method to locate bytecodes for corresponding class. If findClass() does not found the class than it 
		// throws java.lang.ClassNotFoundException and if it finds it calls defineClass() to convert bytecodes
		// into a .class instance which is returned to the caller.
		
		// According to visibility principle, Child ClassLoader can see class loaded by Parent ClassLoader
		// but vice-versa is not true. Which mean if class Abc is loaded by Application class loader than trying
		//to load class ABC explicitly using extension ClassLoader will throw java.lang.ClassNotFoundException.
		
		try {
			Class.forName("com.test1.ClassLoaders", true, ClassLoaders.class.getClassLoader().getParent());
		} catch (ClassNotFoundException c) {
			Logger.getLogger("com.test1").log(Level.SEVERE, "Hello", c);
		}
	}
}
