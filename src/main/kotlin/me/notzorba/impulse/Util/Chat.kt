package me.notzorba.impulse.util

import org.bukkit.ChatColor
import java.util.regex.Matcher
import java.util.regex.Pattern

object Chat {

    @JvmStatic
    fun format(message: String): String {
        val HEX_PATTERN: Pattern = Pattern.compile("&#(\\w{5}[0-9a-f])")
        val matcher: Matcher = HEX_PATTERN.matcher(message)
        val buffer = StringBuffer()
        while (matcher.find()) {
            try {
                matcher.appendReplacement(
                    buffer,
                    net.md_5.bungee.api.ChatColor.of("#" + matcher.group(1)).toString()
                )
            } catch (e: NoSuchMethodError) {
                return message
            }
        }
        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString())
    }
}