package me.notzorba.impulse.tasks

import me.notzorba.impulse.Impulse
import me.notzorba.impulse.hooks.PlaceholderAPIWrapper
import me.notzorba.impulse.util.Chat
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.scheduler.BukkitRunnable

object AutoBroadcastTask : BukkitRunnable() {

    var i = 0

    val announcements: MutableList<String> = mutableListOf()

    fun load(config: FileConfiguration) {
        announcements.clear()

        for (i in 0 until config.getStringList("announcements").size) {
            announcements.add(config.getStringList("announcements")[i].replace("%nl%", "\n"))
        }

        runTaskTimer(Impulse.instance, 20L, config.getInt("interval").toLong() * 20)
    }

    override fun run() {
        val message = announcements[i]

        if (PlaceholderAPIWrapper.isPresent()) {
            Bukkit.getOnlinePlayers().forEach {
                it.sendMessage(PlaceholderAPIWrapper.withPlaceholders(it, Chat.format(message)))
            }
        } else {
            Bukkit.broadcastMessage(Chat.format(message))
        }

        if (i == announcements.size - 1) {
            i = 0
        } else {
            i++
        }
    }
}