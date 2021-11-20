package com.example.vpking.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [IzData::class], version = 6, exportSchema = false)
abstract class IzDatabase : RoomDatabase() {
}