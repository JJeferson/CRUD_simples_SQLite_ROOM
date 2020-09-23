package com.a.crid_simples_sqlite_room

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.crid_simples_sqlite_room.Adapter.UserAdapter
import com.a.crid_simples_sqlite_room.BancoDeDados.CRUD_Functions
import com.a.crid_simples_sqlite_room.Model.modelUser
import com.a.crid_simples_sqlite_room.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

import kotlinx.android.synthetic.main.alertdialogform.view.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    private lateinit var mUserViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val view = window.decorView
        var view_AlertDialog =  LayoutInflater.from(this).
        inflate(R.layout.alertdialogform,view as ViewGroup,false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        lista()
        search()

        floatingActionButton.setOnClickListener { view ->
        acessaComponentesFormulario(view_AlertDialog,this,mUserViewModel).criaForm()
        }

    }//fim do Oncreate

    fun search(){
        searchViewID.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //adapter.filter.filter(newText)

                var query  = newText.toString()
                if(query.length == 0){
                    lista()
                }
                else {
                    pesquisa(query)
                }

                return true
            }

        })


    }


    fun pesquisa (query : String ){

        val view = window.decorView

        // Recyclerview
        val adapter = UserAdapter(view,this,mUserViewModel)
        recyclerViewID.adapter = adapter
        recyclerViewID.layoutManager = LinearLayoutManager(this)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.PesquisaQuery(query)
        mUserViewModel.PesquisareadAllData.observeForever(Observer { user ->
        adapter.setData(user)

        })


    }

    fun lista(){

        val view = window.decorView

        // Recyclerview
        val adapter = UserAdapter(view,this,mUserViewModel)
        recyclerViewID.adapter = adapter
        recyclerViewID.layoutManager = LinearLayoutManager(this)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observeForever(Observer { user ->
            adapter.setData(user)

        })



    }
}//fim da classe

