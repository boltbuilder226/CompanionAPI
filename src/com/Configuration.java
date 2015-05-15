package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	
	/**
	 * Create a config from the given inputstream and file. Creates file if it does not exist
	 * @param stream InputStream to write to file if it does not exist
	 * @param file File object for configuration
	 * @return
	 */
	public FileConfiguration createConfig(InputStream stream, File file) {

		if (!file.exists()) {

			file.getParentFile().mkdirs();
			copy(stream, file);

		}
		return YamlConfiguration.loadConfiguration(file);

	}

	/**
	 * Create a config based on a resource file contained in the plugin
	 * @param plugin Main class of plugin possessing the resource file
	 * @param resource String filename of resource inside the plugin
	 * @param file File object for configuration
	 * @return
	 */
	public FileConfiguration createConfig(JavaPlugin plugin, String resource,
			File file) {

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			copy(plugin.getResource(resource), file);
		}
		return YamlConfiguration.loadConfiguration(file);

	}
	
	/**
	 * Create FileConfiguration from the given file
	 * @param file File to load from config
	 * @return
	 * @throws FileNotFoundException If file does not exist
	 * @throws InvalidConfigurationException If there is an invalid configuration
	 */
	public FileConfiguration createConfig(File file) throws FileNotFoundException, InvalidConfigurationException {
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		return YamlConfiguration.loadConfiguration(file);
	}

	private void copy(InputStream in, File file) {

		try {

			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {

				out.write(buf, 0, len);

			}
			out.close();
			in.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
