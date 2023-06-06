package me.Incbom.miningsystem.Events;

public class BlockBreak implements Listener {
    private Main plugin;
    public BlockBreak(Main plugin) {
        this.plugin = plugin;
    }

    private double rngNumber() {
        return Math.random();
    }
    ConfigurationSection section = plugin.getConfig().getConfigurationSection("items");

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(section != null) {
            for (String key : section.getKeys(false)){
                double chance = section.getDouble("items." + key + ".chance");
                String command = section.getString("items." + key + ".command");
                String name = section.getString("items." + key + ".name");
                if(rngNumber() > chance) {
                    player.sendMessage("You got " + name + "(Chance: " + chance * 100 + ")");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName() .replaceAll("&", "§")));
                }
            }
        }
    }
}