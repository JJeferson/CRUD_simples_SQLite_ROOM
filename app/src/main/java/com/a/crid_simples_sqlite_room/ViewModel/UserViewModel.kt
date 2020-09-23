package com.a.crid_simples_sqlite_room.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.a.crid_simples_sqlite_room.BancoDeDados.UserDatabase
import com.a.crid_simples_sqlite_room.BancoDeDados.UserRepository
import com.a.crid_simples_sqlite_room.Model.modelUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application), LifecycleOwner {
     /*
     ViewModel é aquele esquema para não perder os dados
     do array/Lista toda vez que a aplicação for destruida

     seja por tocar o telefone ou por mudar a orientação da tela.
     */
     var readAllData:LiveData<List<modelUser>>
     lateinit  var PesquisareadAllData : LiveData<List<modelUser>>
     val userDao = UserDatabase.getDatabase(application).userDao()


     private var repository:UserRepository


        init{
             repository = UserRepository(userDao,"")
             readAllData = repository.readAllData
        }//fim do init


    fun PesquisaQuery(query:String){
        //val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao, query)
        PesquisareadAllData = repository.PesquisareadAllData

        }



    fun addUser(user: modelUser){
        viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(user)
        }
    }

    fun updateUser(user: modelUser){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: modelUser){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}
