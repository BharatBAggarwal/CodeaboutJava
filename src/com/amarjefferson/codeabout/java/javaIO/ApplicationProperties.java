package com.amarjefferson.codeabout.java.javaIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * File Name: ApplicationProperties.java
 *
 * Package: com.amarjefferson.codeabout.java.fileIo
 * Class: ApplicationProperties
 *
 */
public class ApplicationProperties {
	private static final String SEPARATOR = "\\";

	String propsFile = "";
	InputStream propsStream = null;
	Properties props = new Properties();
	
	String dirProject = "";
	String dirBase = "";
	String dirImages = "";
	String dirInput = "";
	String dirOutput = "";

	/**
	 * @throws IOException 
	 * 
	 */
	public ApplicationProperties(String propertiesFile) throws IOException {
		this.propsFile = propertiesFile;
		this.readPropertiesFile();

		this.dirProject = System.getProperty("user.dir")+ SEPARATOR;
		this.dirBase = this.props.getProperty("dir.base") + SEPARATOR;
		this.dirImages = this.props.getProperty("dir.images") + SEPARATOR;
		this.dirInput = this.props.getProperty("dir.input") + SEPARATOR;
		this.dirOutput = this.props.getProperty("dir.output") + SEPARATOR;
	}

	public void readPropertiesFile() throws FileNotFoundException {
		this.propsStream = getClass().getClassLoader().getResourceAsStream(propsFile);
		if(this.propsStream != null) {
			try {
				this.props.load(this.propsStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new FileNotFoundException("File " + this.propsFile + "not found");
		}
	}

	public String getBaseDir() {
		return this.dirBase;
	}

	public String getImagesDir(boolean addProjectsDir) {
		if(addProjectsDir)
			return (this.dirProject + this.dirBase + this.dirImages);
		else
			return this.dirBase + this.dirImages;
	}
	
	public String getInputDir(boolean addProjectsDir) {
		if(addProjectsDir)
			return (this.dirProject + this.dirBase + this.dirInput);
		else
			return this.dirBase + this.dirInput;
}
	
	public String getOutputDir(boolean addProjectsDir) {
		if(addProjectsDir)
			return (this.dirProject + this.dirBase + this.dirOutput);
		else
			return this.dirBase + this.dirOutput;
	}

	public Set<Object> getKeys() {
		return this.props.keySet();
	}

	public boolean containsKey(String aKey) {
		return this.props.containsKey((Object)aKey);
	}

	public String getValue(String aKey) {
		return this.props.getProperty(aKey);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationProperties f = null;
		try {
			f = new ApplicationProperties("config.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.getBaseDir());
		System.out.println(f.getImagesDir(true));
		System.out.println(f.getOutputDir(true));
		System.out.println(f.getInputDir(true));
		System.out.println(f.getImagesDir(false));
		System.out.println(f.getOutputDir(false));
		System.out.println(f.getInputDir(false));
		System.out.println(f.containsKey("dir.base"));
		System.out.println(f.getKeys());
	}

}
