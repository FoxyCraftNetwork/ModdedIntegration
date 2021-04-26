package it.uknowngino.moddedintegration.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import it.uknowngino.moddedintegration.commands.ModdedIntegrationCommand;
import it.uknowngino.moddedintegration.functions.ChatUtils;
import it.uknowngino.moddedintegration.functions.IntegrationUtils;

public class ModdedIntegration extends JavaPlugin {
	
	static ModdedIntegration plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		if(Bukkit.getPluginManager().isPluginEnabled("Essentials")) {
			
			IntegrationUtils.populateCSV();
			
		} else {
			
			System.out.println("ModdedIntegration � EssentialsX not found!");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
		
		registerCommands();
		
		System.out.println(ChatUtils.color("ModdedIntegration � Plugin &aenabled&r!"));

	}
	
	public void onDisable() {
		
		System.out.println(ChatUtils.color("ModdedIntegration � Plugin &cdisabled&r!"));
		
	}
	
	public static ModdedIntegration getInstance() {
		
		return plugin;
		
	}
	
	private void registerCommands() {
		
		getCommand("moddedintegration").setExecutor(new ModdedIntegrationCommand());
		
	}

}
