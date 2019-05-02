package de.haeherfeder.DeDePlEngine.all;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class FileHandlerLoader {

  public static List<IFileHandler> loadFileHandlers(File plugDir) throws IOException {

    File[] plugJars =plugDir.listFiles(new JARFileFilter());
    ClassLoader cl = new URLClassLoader(FileHandlerLoader.fileArrayToURLArray(plugJars));
    List<Class<IFileHandler>> plugClasses = FileHandlerLoader.extractClassesFromJARs(plugJars, cl);
    return FileHandlerLoader.createIFileHandlerObjects(plugClasses);
  }

  private static URL[] fileArrayToURLArray(File[] files) throws MalformedURLException {

    URL[] urls = new URL[files.length];
    for (int i = 0; i < files.length; i++) {
      urls[i] = files[i].toURI().toURL();
    }
    return urls;
  }

  private static List<Class<IFileHandler>> extractClassesFromJARs(File[] jars, ClassLoader cl) throws IOException {

    List<Class<IFileHandler>> classes = new ArrayList<Class<IFileHandler>>();
    for (File jar : jars) {
      classes.addAll(FileHandlerLoader.extractClassesFromJAR(jar, cl));
    }
    return classes;
  }

  @SuppressWarnings("unchecked")
  private static List<Class<IFileHandler>> extractClassesFromJAR(File jar, ClassLoader cl) throws IOException {

    List<Class<IFileHandler>> classes = new ArrayList<Class<IFileHandler>>();
    JarInputStream jaris = new JarInputStream(new FileInputStream(jar));
    JarEntry ent = null;
    while ((ent = jaris.getNextJarEntry()) != null) {
      if (ent.getName().toLowerCase().endsWith(".class")) {
        try {
          Class<?> cls = cl.loadClass(ent.getName().substring(0, ent.getName().length() - 6).replace('/', '.'));
          if (FileHandlerLoader.isIFileHandlerClass(cls)) {
            classes.add((Class<IFileHandler>)cls);
          }
        }
        catch (ClassNotFoundException e) {
          System.err.println("Can't load Class " + ent.getName());
          e.printStackTrace();
        }
      }
    }
    jaris.close();
    return classes;
  }

  private static boolean isIFileHandlerClass(Class<?> cls) {

    for (Class<?> i : cls.getInterfaces()) {
      if (i.equals(IFileHandler.class)) {
        return true;
      }
    }
    return false;
  }

  private static List<IFileHandler> createIFileHandlerObjects(List<Class<IFileHandler>> IFileHandlers) {

    List<IFileHandler> plugs = new ArrayList<IFileHandler>(IFileHandlers.size());
    for (Class<IFileHandler> plug : IFileHandlers) {
      try {
        plugs.add(plug.newInstance());
      }
      catch (InstantiationException e) {
        System.err.println("Can't instantiate plugin: " + plug.getName());
        e.printStackTrace();
      }
      catch (IllegalAccessException e) {
        System.err.println("IllegalAccess for plugin: " + plug.getName());
        e.printStackTrace();
      }
    }
    return plugs;
  }
}