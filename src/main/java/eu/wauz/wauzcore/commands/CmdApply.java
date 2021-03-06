package eu.wauz.wauzcore.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;

import eu.wauz.wauzcore.commands.execution.WauzCommand;
import eu.wauz.wauzcore.commands.execution.WauzCommandExecutor;
import eu.wauz.wauzcore.players.WauzPlayerGuild;

/**
 * A command, that can be executed by a player with fitting permissions.</br>
 * - Description: <b>Apply for a Guild</b></br>
 * - Usage: <b>/apply [guildName]</b></br>
 * - Permission: <b>wauz.normal</b>
 * 
 * @author Wauzmons
 * 
 * @see WauzCommand
 * @see WauzCommandExecutor
 */
public class CmdApply implements WauzCommand {

	/**
	 * @return The id of the command.
	 */
	@Override
	public String getCommandId() {
		return "apply";
	}

	/**
	 * Executes the command for given sender with arguments.
	 * 
	 * @param sender The sender of the command.
	 * @param args The arguments of the command.
	 * 
	 * @return If the command had correct syntax.
	 */
	@Override
	public boolean executeCommand(CommandSender sender, String[] args) {
		return WauzPlayerGuild.applyForGuild((Player) sender, StringUtils.join(args, " "));
	}

}
