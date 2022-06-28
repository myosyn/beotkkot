package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Skip : Extension() {
    override val name: String = "skip"

    override suspend fun setup() {
        publicSlashCommand {
            name = "skip"
            description = "Skips the specified amount of songs in the queue."

            check {

            }
        }
    }

    inner class SkipArguments : Arguments() {
        val skipAmount by defaultingInt {
            name = "skipAmount"
            description = "Skips the specified amount of songs."
            defaultValue = 1
        }
    }
}