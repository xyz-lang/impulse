package me.notzorba.impulse

import co.aikar.commands.PaperCommandManager
import me.notzorba.impulse.commands.ForceBroadcast
import me.notzorba.impulse.commands.ReloadCommand
import me.notzorba.impulse.tasks.AutoBroadcastTask
import me.notzorba.impulse.util.Config
import org.bukkit.plugin.java.JavaPlugin

class Impulse : JavaPlugin() {

    companion object {
        lateinit var instance: Impulse
    }

    override fun onEnable() {
        this.saveDefaultConfig()
        Config.loadConfig(this)
        instance = this

        val commandManager = PaperCommandManager(this)
        commandManager.registerCommand(ForceBroadcast)
        commandManager.registerCommand(ReloadCommand)
        AutoBroadcastTask.load(config)
    }
}