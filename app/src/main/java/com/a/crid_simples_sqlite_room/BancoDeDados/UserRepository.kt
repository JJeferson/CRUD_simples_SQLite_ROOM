package com.a.crid_simples_sqlite_room.BancoDeDados

import androidx.lifecycle.LiveData
import com.a.crid_simples_sqlite_room.BancoDeDados.DAO.UserDao
import com.a.crid_simples_sqlite_room.Model.modelUser

class UserRepository(private val userDao: UserDao,private var Query:String) {

    val readAllData: LiveData<List<modelUser>> = userDao.readAllData()
    var QueryCompleta = "%"+Query+"%"
    val PesquisareadAllData: LiveData<List<modelUser>> = userDao.PesquisareadAllData(QueryCompleta)



    suspend fun addUser(user: modelUser){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: modelUser){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: modelUser){
        userDao.deleteUser(user)
    }


}