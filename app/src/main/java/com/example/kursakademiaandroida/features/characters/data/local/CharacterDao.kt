package com.example.kursakademiaandroida.features.characters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached) //vararg means that we can pass many objects of CharacterCached type

    @Query("SELECT * FROM CharacterCached")
    suspend fun getCharacters(): List<CharacterCached>
}