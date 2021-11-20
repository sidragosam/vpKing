package com.example.vpking.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "iz_table")
data class IzData (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,

    @ColumnInfo(name="nev")
    val nev: String,

    @ColumnInfo(name="isChecked")
    var isChecked: Boolean = false,

    @ColumnInfo(name="suly")
    val suly: Int = 0
)