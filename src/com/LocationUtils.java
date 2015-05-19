package com;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
 
public class LocationUtils {
 
   public static String getStringFromBlock(char separator, Block block) {
      StringBuilder builder = new StringBuilder();
      Location location = block.getLocation();
 
      builder.append(location.getWorld().getName()).append(separator);
      builder.append(location.getBlockX()).append(separator);
      builder.append(location.getBlockY()).append(separator);
      builder.append(location.getBlockZ());
 
      return builder.toString();
   }
 
   public static String getStringFromLocation(char separator, Location location) {
      StringBuilder builder = new StringBuilder();
 
      builder.append(location.getWorld().getName()).append(separator);
      builder.append(round(location.getX())).append(separator);
      builder.append(round(location.getY())).append(separator);
      builder.append(round(location.getZ())).append(separator);
      builder.append(round(location.getYaw())).append(separator);
      builder.append(round(location.getPitch()));
 
      return builder.toString();
   }
 
   public static Location getLocationFromString(char separator, String string) {
      String[] split = string.split(String.valueOf(separator));
 
      World world = Bukkit.getWorld(split[0]);
      double x = Double.parseDouble(split[1]);
      double y = Double.parseDouble(split[2]);
      double z = Double.parseDouble(split[3]);
      float yaw = 0.0f;
      float pitch = 0.0f;
      if (split.length == 6) {
         yaw = Float.parseFloat(split[4]);
         pitch = Float.parseFloat(split[5]);
      }
      return new Location(world, x, y, z, yaw, pitch);
   }
 
   private static double round(double d) {
      return Math.ceil(d);
   }
 
}