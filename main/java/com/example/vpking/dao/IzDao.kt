package com.example.vpking.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IzDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vp: IzData)

    @Query("SELECT * from iz_table WHERE id = :key")
    fun getResultWithId(key: Long): LiveData<IzData>

    @Query("SELECT * FROM iz_table ORDER BY id DESC")
    fun getAllResults(): LiveData<List<IzData>>
}


