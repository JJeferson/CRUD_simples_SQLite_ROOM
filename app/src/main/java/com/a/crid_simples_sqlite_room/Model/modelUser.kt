package com.a.crid_simples_sqlite_room.Model

 import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class modelUser(

    @PrimaryKey(autoGenerate = true)
    val id:    Int,
    val Nome:  String,
    val Email: String,
    val Idade: Int
)