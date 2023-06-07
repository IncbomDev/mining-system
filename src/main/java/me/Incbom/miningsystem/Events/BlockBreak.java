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
                double chance = section.getDouble("items." + key + ".chance") / 100;
                String command = section.getString("items." + key + ".command");
                String name = section.getString("items." + key + ".name");
                String item = section.getString("items." + key + ".item");
                boolean sendMessage = section.getBoolean("items." + key + ".send-message");
                if(rngNumber() > chance) {
                    if(item == "NONE") {
                        return;
                    }else if(item != null){
                        player.getInventory().addItem(new ItemStack(Material.getMaterial(item)));
                    }
                    else if(item == null) {
                        return;
                    }
                    if(sendMessage == false) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName() .replaceAll("&", "§")));
                    }
                    if(sendMessage == true) {
                        String message = section.getString("items." + key + ".message");
                        player.sendMessage(message.replace("%item%", name .replaceAll("&", "§")));
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName() .replaceAll("&", "§")));
                    }
                    
                }
            }
        }
    }
}