package dev.shuuyu.constants

import com.kotlindiscord.kord.extensions.utils.env
import com.kotlindiscord.kord.extensions.utils.envOrNull

object Config {
    val ENV = env("TOKEN")
    val BOT_OWNER = env("BOT_OWNER")
    val YOUTUBE_ENVIRONMENT_KEY = env("YOUTUBE_API_KEY")
    val SPOTIFY_CLIENT_ID = envOrNull("SPOTIFY_CLIENT_ID")
    val SPOTIFY_CLIENT_SECRET = envOrNull("SPOTIFY_CLIENT_SECRET")

    // Honestly I would've gone for a more smart choice but this is during startup so who the hell cares lol
    val MONGODB_LINK = envOrNull("MONGO_URI") ?: "mongodb://localhost:27017"

    /*
    THE CLIENT MUST EITHER RUN IN PRODUCTION OR TEST. OTHERWISE, THE BOT MIGHT NOT BOOT.
    However, it isn't included yet. So that's kinda cool.
     */
    val ENVIRONMENT = env("ENVIRONMENT")
}