package dev.shuuyu.database

object Database {
    data class Database(
        val musicLog: String,
        val joinChannelLog: String,
        val leaveChannelLog: String,
    )
}

