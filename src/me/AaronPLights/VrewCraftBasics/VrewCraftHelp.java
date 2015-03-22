package me.AaronPLights.VrewCraftBasics;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class VrewCraftHelp extends JavaPlugin {
    public VrewCraftHelp() {
    }

    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.getLogger().info(pdfFile.getName() + "Version " + pdfFile.getVersion() + " has been ENABLED!");
        if(!(new File(this.getDataFolder(), "config.yml")).exists()) {
            this.getConfig().options().copyDefaults(true);
        }

        this.saveConfig();
    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.getLogger().info(pdfFile.getName() + " has been DISABLED!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        List list = this.getConfig().getStringList("Rows");
        Iterator var7 = list.iterator();

        while(var7.hasNext()) {
            String playerlist = (String)var7.next();
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("help")){
                    player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', playerlist));
                }

                if (cmd.getName().equalsIgnoreCase("?")) {
                    player.sendRawMessage(ChatColor.translateAlternateColorCodes('&', playerlist));
                }

            }
        }
        Player player = (Player) sender;
        if (commandLabel.equalsIgnoreCase("forums")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Our forums can be found at this link: http://vrewcraft.com/forums");
        }

        if (commandLabel.equalsIgnoreCase("forum")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Our forums can be found at this link: http://vrewcraft.com/forums");
        }

        if (commandLabel.equalsIgnoreCase("donate")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Our store can be found at this link: http://store.vrewcraft.com");
        }

        if (commandLabel.equalsIgnoreCase("store")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Our store can be found at this link: http://store.vrewcraft.com");
        }

        if (commandLabel.equalsIgnoreCase("vote")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Vote for our server at this link: http://vote.vrewcraft.com");
        }

        if (commandLabel.equalsIgnoreCase("voting")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GRAY + "Vote for our server at this link: http://vote.vrewcraft.com");
        }

        if (commandLabel.equalsIgnoreCase("VCBasics")) {
            player.sendMessage(ChatColor.BLUE + "[VREWCRAFT] " + ChatColor.GOLD + "VrewCraftBasics v1.6");
            player.sendMessage(ChatColor.BLUE + "Created by " + ChatColor.GOLD + "Blazing_Lights and JottyT");
        }

        return false;

    }

}
