package me.notzorba.impulse

import co.aikar.commands.PaperCommandManager
import me.notzorba.impulse.commands.ForceBroadcast
import me.notzorba.impulse.commands.ReloadCommand
import me.notzorba.impulse.tasks.AutoBroadcastTask
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

class Impulse : JavaPlugin() {
    companion object {
        lateinit var instance: Impulse
    }

    override fun onEnable() {
        this.saveDefaultConfig()
        instance = this

        val commandManager = PaperCommandManager(this)
        commandManager.registerCommand(ForceBroadcast)
        commandManager.registerCommand(ReloadCommand)
        AutoBroadcastTask.load(config)
    }
}