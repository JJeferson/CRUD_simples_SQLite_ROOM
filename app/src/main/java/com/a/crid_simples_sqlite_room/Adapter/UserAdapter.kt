package com.a.crid_simples_sqlite_room.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.a.crid_simples_sqlite_room.MainActivity
import com.a.crid_simples_sqlite_room.Model.modelUser
import com.a.crid_simples_sqlite_room.R
import com.a.crid_simples_sqlite_room.ViewModel.UserViewModel
import com.a.crid_simples_sqlite_room.acessaComponentesFormulario

import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.linha_layout.view.*


class UserAdapter(private var viewMain:View,
                  private var context:Context,
                  mUserViewModel: UserViewModel): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var userList = emptyList<modelUser>()
    var mUserViewModel = mUserViewModel

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.linha_layout, parent, false))

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        var id =  currentItem.id
        holder.itemView.nomeID.text = currentItem.Nome
        holder.itemView.emailID.text = currentItem.Email
        holder.itemView.idadeID.text = currentItem.Idade.toString()



        holder.itemView.layout_da_LinhaID.setOnClickListener {view: View->
             var todos_Dados_DO_Item_Selecionado = modelUser(id,currentItem.Nome,currentItem.Email,currentItem.Idade)
              var id = id
              var nome  = currentItem.Nome
              var email = currentItem.Email
              var idade    = currentItem.Idade

              acessaComponentesFormulario(viewMain,context,mUserViewModel).editaForm(id,nome,email,idade)
             }


            holder.itemView.layout_da_LinhaID.setOnLongClickListener{
                var id = id
                acessaComponentesFormulario(viewMain,context,mUserViewModel).excluiForm(id)
                //sendo esse metodo onLongClickListner não posso esquecer desse true boolean no final
                true
            }





    }





    fun setData(user: List<modelUser>){
        this.userList = user
        notifyDataSetChanged()
    }
}
