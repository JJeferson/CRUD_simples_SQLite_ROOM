package com.a.crid_simples_sqlite_room.BancoDeDados

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.crid_simples_sqlite_room.Adapter.UserAdapter
import com.a.crid_simples_sqlite_room.Model.modelUser
import com.a.crid_simples_sqlite_room.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alertdialogform.view.*

class CRUD_Functions(private var view: View,
                     private var context: Context,
                     mUserViewModel: UserViewModel){


    var mUserViewModel = mUserViewModel

    fun limpaCampos(view: View){
        view.posicaoID.setText("")
        view.nomeID_EditText.setText("")
        view.idadeID_EditText.setText("")
        view.emailID_EditText.setText("")
    }//final do limpa campos
    //---------------------------------------------------------------//
    fun insert (nome:String, email:String, idade:String) {

        //pega os campos
        var pegaNome  = nome
        var pegaEmail = email
        var pegaIdade = Integer.parseInt(idade)

        val user = modelUser(
            0,
            pegaNome,
            pegaEmail,
            pegaIdade
        )
        // Add Data to Database
        mUserViewModel.addUser(user)
    }//final do insert

    //---------------------------------------------------------------//
    fun update (posicaoID:String,nome:String, email:String, idade:String){

        //segundo botao não implementei nada.
        var pegaPosicao  =  Integer.parseInt(posicaoID)
        var pegaNome  = nome
        var pegaEmail = email
        var pegaIdade    = Integer.parseInt(idade)

        val updatedUser = modelUser(pegaPosicao,pegaNome,pegaEmail,pegaIdade)
        // Update Current User
        mUserViewModel.updateUser(updatedUser)

    }
    //---------------------------------------------------------------//
    fun delete (posicaoID: Int){

        var pegaPosicao  =  posicaoID
        val updatedUser = modelUser(pegaPosicao,"","",0)
        // Update Current User
        mUserViewModel.deleteUser(updatedUser)

    }




}