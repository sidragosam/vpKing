package com.example.vpking.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VizipipaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vp: VizipipaSave)

    @Query("SELECT * from vp_table WHERE id = :key")
    fun getVizipipaWithID(key: Long): LiveData<VizipipaSave>

    @Query("SELECT * FROM vp_table ORDER BY id DESC")
    fun getAllVizipipa(): LiveData<List<VizipipaSave>>

}