package com.a.crid_simples_sqlite_room.BancoDeDados.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.a.crid_simples_sqlite_room.Model.modelUser


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: modelUser)

    @Update
    suspend fun updateUser(user: modelUser)

    @Delete
    suspend fun deleteUser(user: modelUser)

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    fun readAllData(): LiveData<List<modelUser>>

    @Query("SELECT * FROM user_table WHERE nome LIKE :query ORDER BY id DESC")
    fun PesquisareadAllData(query: String): LiveData<List<modelUser>>

}
