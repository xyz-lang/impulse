package me.notzorba.impulse.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Subcommand
import me.notzorba.impulse.Impulse
import me.notzorba.impulse.util.Chat
import me.notzorba.impulse.util.Config
import org.bukkit.entity.Player

@CommandAlias("impulse")
@CommandPermission("impulse.reload")
object ReloadCommand : BaseCommand() {

    @Subcommand("reload")
    fun reload(sender: Player) {
        Config.loadConfig(Impulse.instance)
        Impulse.instance.saveConfig()
        sender.sendMessage(Chat.format(Impulse.instance.config.getString("reload-message")!!))
    }
}