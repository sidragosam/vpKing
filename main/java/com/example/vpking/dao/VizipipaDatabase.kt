package com.example.vpking.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [VizipipaSave::class], version = 6, exportSchema = false)
abstract class VizipipaDatabase : RoomDatabase() {
    abstract val vizipipaDao: VizipipaDao

    companion object {

        @Volatile
        private var INSTANCE: VizipipaDatabase? = null

        fun getInstance(context: Context): VizipipaDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VizipipaDatabase::class.java,
                        "vp_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}