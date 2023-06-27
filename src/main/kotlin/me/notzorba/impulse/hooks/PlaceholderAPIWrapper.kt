package me.notzorba.impulse.hooks

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player


object PlaceholderAPIWrapper {

    fun isPresent(): Boolean {
        return Bukkit.getServer().pluginManager.getPlugin("PlaceholderAPI") != null
    }

    fun withPlaceholders(player: Player, input: String?): String {
        return PlaceholderAPI.setPlaceholders(player, input!!)
    }

    fun withPlaceholders(player: OfflinePlayer, input: String?): String {
        return PlaceholderAPI.setPlaceholders(player, input!!)
    }
}