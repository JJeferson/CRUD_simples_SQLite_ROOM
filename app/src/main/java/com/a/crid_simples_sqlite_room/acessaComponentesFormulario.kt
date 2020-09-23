package com.a.crid_simples_sqlite_room

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a.crid_simples_sqlite_room.BancoDeDados.CRUD_Functions
import com.a.crid_simples_sqlite_room.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.alertdialog_excluir.view.*
import kotlinx.android.synthetic.main.alertdialogform.view.*
import kotlinx.android.synthetic.main.alertdialogform.view.posicaoID


class acessaComponentesFormulario(private var view: View, private var context: Context,mUserViewModel: UserViewModel) {

    var mUserViewModel = mUserViewModel

     fun editaForm(ID:Int,
                   nome:String,
                   email:String,
                   idade:Int){

         var view_AlertDialog =  LayoutInflater.from(context).
         inflate(R.layout.alertdialogform,view as ViewGroup,false)

         view_AlertDialog.posicaoID.setText(ID.toString())
         view_AlertDialog.nomeID_EditText.setText(nome)
         view_AlertDialog.emailID_EditText.setText(email)
         view_AlertDialog.idadeID_EditText.setText(idade.toString())


         AlertDialog.Builder(context).
         setTitle("").
         setView(view_AlertDialog).
         setPositiveButton("Gravar",
             DialogInterface.OnClickListener { dialogInterface, i ->
                 var recebePosicao = view_AlertDialog.posicaoID.text.toString()
                 var recebeNome    = view_AlertDialog.nomeID_EditText.text.toString()
                 var recebeEmail   = view_AlertDialog.emailID_EditText.text.toString()
                 var recebeIdade   = view_AlertDialog.idadeID_EditText.text.toString()

                 CRUD_Functions(view_AlertDialog,context,mUserViewModel).update(recebePosicao,recebeNome,recebeEmail,recebeIdade)
                 CRUD_Functions(view_AlertDialog,context,mUserViewModel).limpaCampos(view_AlertDialog)


             }).
         setNegativeButton("Sair",null).
         show()


     }
     //--------------------------------------------------------------------------


    fun criaForm(){

        //aqui começa o Dialog

        var view_AlertDialog =  LayoutInflater.from(context).
        inflate(R.layout.alertdialogform,view as ViewGroup,false)
        //-----------------------------//

        AlertDialog.Builder(context).
        setTitle("").
        setView(view_AlertDialog).
        setPositiveButton("Gravar",
            DialogInterface.OnClickListener { dialogInterface, i ->
                var recebePosicao = view_AlertDialog.posicaoID.text.toString()
                var recebeNome    = view_AlertDialog.nomeID_EditText.text.toString()
                var recebeEmail   = view_AlertDialog.emailID_EditText.text.toString()
                var recebeIdade   = view_AlertDialog.idadeID_EditText.text.toString()
                CRUD_Functions(view_AlertDialog,context,mUserViewModel).insert(recebeNome,recebeEmail,recebeIdade)
                CRUD_Functions(view_AlertDialog,context,mUserViewModel).limpaCampos(view_AlertDialog)



            }).
        setNegativeButton("Sair",null).
        show()
    }
    //--------------------------------------------------------------------------
    fun excluiForm(ID:Int){

        var recebeID = ID

        var view_AlertDialogExcluir =  LayoutInflater.from(context).
        inflate(R.layout.alertdialog_excluir,view as ViewGroup,false)
        //-----------------------------//

        AlertDialog.Builder(context).
        setTitle("").
        setView(view_AlertDialogExcluir).
        setPositiveButton("Sim",
            DialogInterface.OnClickListener { dialogInterface, i ->
                CRUD_Functions(view_AlertDialogExcluir,context,mUserViewModel).delete(recebeID)

            }).
        setNegativeButton("Não",null).
        show()
    }
}