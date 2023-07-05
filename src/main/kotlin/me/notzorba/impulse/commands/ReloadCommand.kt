package me.notzorba.impulse.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Subcommand
import me.notzorba.impulse.Impulse
import me.notzorba.impulse.tasks.AutoBroadcastTask
import me.notzorba.impulse.util.Chat
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

@CommandAlias("impulse")
@CommandPermission("impulse.reload")
object ReloadCommand : BaseCommand() {
    @Subcommand("reload")
    fun reload(sender: Player) {
        Impulse.instance.reloadConfig()
        AutoBroadcastTask.load(Impulse.instance.config)
        sender.sendMessage(Chat.format(Impulse.instance.config.getString("reload-message")!!))
    }
}