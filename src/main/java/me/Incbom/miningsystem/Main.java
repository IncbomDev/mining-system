package me.Incbom.miningsystem;

import org.bukkit.plugin.java.JavaPlugin;

import me.Incbom.miningsystem.Events.BlockBreak;
import me.Incbom.miningsystem.utils.Logger;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
      BlockBreak blockBreakListener = new BlockBreak(this);
      getServer().getPluginManager().registerEvents(blockBreakListener, this);
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      Logger.log(Logger.LogLevel.SUCCESS, "Loading Mining Expansion...");
      Logger.log(Logger.LogLevel.SUCCESS, "Loaded!");
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
    }   

    @Override
    public void onDisable() {
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      Logger.log(Logger.LogLevel.SUCCESS, "Unloading Mining Expansion...");
      Logger.log(Logger.LogLevel.SUCCESS, "Unloaded!");
      Logger.log(Logger.LogLevel.OUTLINE, "------------------------------------");
      this.saveConfig();
      }
    }