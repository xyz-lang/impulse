package me.notzorba.impulse.tasks

import me.notzorba.impulse.Impulse
import me.notzorba.impulse.hooks.PlaceholderAPIWrapper
import me.notzorba.impulse.util.Chat
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

object AutoBroadcastTask : BukkitRunnable() {

    var i = 0

    val announcements: MutableList<String> = mutableListOf()
    var task: BukkitTask? = null
    var taskID: Int = -1

    fun load(config: FileConfiguration) {
        announcements.clear()

        for (i in 0 until config.getStringList("announcements").size) {
            announcements.add(config.getStringList("announcements")[i].replace("%nl%", "\n"))
        }

        task?.cancel()

        task = object : BukkitRunnable() {
            var i = 0

            override fun run() {
                val message = announcements[i]

                Bukkit.broadcastMessage(Chat.format(message))

                if (i == announcements.size - 1) {
                    i = 0
                } else {
                    i++
                }
            }
        }.runTaskTimer(Impulse.instance, 20L, config.getInt("interval").toLong() * 20)
    }


    override fun run() {
        if (task?.isCancelled == true) {
            return
        }

        val message = announcements[i]

        Bukkit.broadcastMessage(Chat.format(message))

        if (i == announcements.size - 1) {
            i = 0
        } else {
            i++
        }
    }
}