package com.example.vpking.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "vp_table")
data class VizipipaSave (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name="nev")
    var nev: String = "",

    @ColumnInfo(name="isChecked")
    var isChecked: Boolean = false
)
