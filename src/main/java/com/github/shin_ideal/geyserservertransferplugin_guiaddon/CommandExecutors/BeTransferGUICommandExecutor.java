package com.github.shin_ideal.geyserservertransferplugin_guiaddon.CommandExecutors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.UUID;

public class BeTransferGUICommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Player Only Command");
            return false;
        }
        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();
        FloodgatePlayer floodgatePlayer = FloodgateApi.getInstance().getPlayer(uuid);
        if (floodgatePlayer == null) {
            commandSender.sendMessage(ChatColor.RED + "Bedrock User Only Command");
            return false;
        }

        CustomForm simpleForm = CustomForm.builder().title("Server Transfer")
                .label("Input Server Address")
                .input("ip", "Address")
                .input("Port", "Port")
                .validResultHandler((response) -> {
                    String ip = response.asInput(1);
                    String port = response.asInput(2);
                    player.performCommand(String.format("betransfer %s %s", ip, port));
                })
                .build();
        floodgatePlayer.sendForm(simpleForm);

        return true;
    }
}
