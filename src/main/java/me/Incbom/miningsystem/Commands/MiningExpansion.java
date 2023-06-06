package me.Incbom.miningsystem.Commands;

import javax.swing.text.TabExpander;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MiningExpansion implements CommandExecutor, TabCompleter {
    private Main plugin;
    public MiningExpansion(Main plugin) {
        this.plugin = plugin;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if(command.getName().equalsIgnoreCase("mining-expansion") && args.length == 0){
            sender.sendMessage("§7§m------------------------------------");
            sender.sendMessage("§a§lMining Expansion");
            sender.sendMessage("§7§lVersion: §a§l1.0.0");
            sender.sendMessage("§7§lAuthor: §a§lIncbom");
            sender.sendMessage("§7§lDescription: §a§lA plugin that gives you items when you mine a block.");
            sender.sendMessage("§7§lCommands:");
            sender.sendMessage("§7§l/mining-expansion reload §a§l- Reloads the config.");
            sender.sendMessage("§7§m------------------------------------");
            return true;
        }else if(command.getName().equalsIgnoreCase("mining-expansion") && args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.saveConfig();
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Mining Expansion configuration reloaded!");
        } 
        return false;
    }
}
