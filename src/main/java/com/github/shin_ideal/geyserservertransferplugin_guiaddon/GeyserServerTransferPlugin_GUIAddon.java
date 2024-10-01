package com.github.shin_ideal.geyserservertransferplugin_guiaddon;

import com.github.shin_ideal.geyserservertransferplugin_guiaddon.CommandExecutors.BeTransferGUICommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class GeyserServerTransferPlugin_GUIAddon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommandExecutors();
        getLogger().info("enable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("disable");
    }

    private void registerCommandExecutors() {
        getCommand("betransfergui").setExecutor(new BeTransferGUICommandExecutor());
    }
}
