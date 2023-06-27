package me.notzorba.impulse.util

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File


object Config {

    fun loadConfig(plugin: Plugin) {
        val file = File(plugin.dataFolder.absolutePath + "/config.yml")
        val cfg: FileConfiguration = YamlConfiguration.loadConfiguration(file)
    }
}