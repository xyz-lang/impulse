package me.notzorba.impulse

import co.aikar.commands.PaperCommandManager
import me.notzorba.impulse.tasks.AutoBroadcastTask
import org.bukkit.plugin.java.JavaPlugin

class Impulse : JavaPlugin() {

    companion object {
        lateinit var instance: Impulse
    }

    override fun onEnable() {
        this.saveDefaultConfig()
        instance = this

        val commandManager = PaperCommandManager(this)

        AutoBroadcastTask.load(config)
    }
}