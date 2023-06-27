package me.notzorba.impulse.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import me.notzorba.impulse.Impulse
import me.notzorba.impulse.hooks.PlaceholderAPIWrapper
import me.notzorba.impulse.tasks.AutoBroadcastTask
import me.notzorba.impulse.util.Chat
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object ForceBroadcast : BaseCommand() {

    @CommandAlias("forcebroadcast")
    @CommandPermission("impulse.forcebroadcast")
    fun forceBroadcast(sender: Player) {
        val message = AutoBroadcastTask.announcements[AutoBroadcastTask.i]

        if (PlaceholderAPIWrapper.isPresent()) {
            Bukkit.getOnlinePlayers().forEach {
                it.sendMessage(PlaceholderAPIWrapper.withPlaceholders(it, Chat.format(message)))
            }
        } else {
            Bukkit.broadcastMessage(Chat.format(message))
        }
        if (AutoBroadcastTask.i == AutoBroadcastTask.announcements.size - 1) {
            AutoBroadcastTask.i = 0
        } else {
            AutoBroadcastTask.i++
        }
    }
}