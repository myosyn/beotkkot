package dev.shuuyu.utils

import com.kotlindiscord.kord.extensions.commands.CommandContext
import dev.kord.rest.builder.message.EmbedBuilder
import dev.schlaubi.lavakord.audio.player.Track

suspend fun EmbedBuilder.addSongBuiler(commandContext: CommandContext, track: Track) {
    title = "Added Song"
    field {

    }
    field {

    }
}