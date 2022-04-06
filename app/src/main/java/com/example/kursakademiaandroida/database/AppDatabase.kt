package com.example.kursakademiaandroida.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class, CharacterCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
    abstract fun characterDao(): CharacterDao
}