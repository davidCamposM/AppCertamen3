package com.example.appcertamen3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText titulo, cuerpo, notaAEliminar;
    ListView listView;
    ArrayList<String> itemsNotas;
    ArrayAdapter<String> adapter;
    //Array de notas
    ArrayList<Nota> notas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.txtTitulo);
        cuerpo = findViewById(R.id.txtCuerpo);
        listView = findViewById(R.id.listVieww);

        //Implementamos las listas
        itemsNotas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemsNotas);
        listView.setAdapter(adapter);

        visualizarDatos();
    }

    public void crearNota(View view){
        String txtTitulo = titulo.getText().toString();
        String txtCuerpo = cuerpo.getText().toString();

        if(!txtTitulo.isEmpty() && !txtCuerpo.isEmpty()){
            Nota nota1 = new Nota(txtTitulo,txtCuerpo);
            notas.add(nota1);
            Toast.makeText(this, "Nota agregada con éxito!", Toast.LENGTH_SHORT).show();
            visualizarDatos();
        } else {
            Toast.makeText(this, "Favor, no dejar campos vacíos, intente de nuevo!", Toast.LENGTH_SHORT).show();
        }
    }

    public void visualizarDatos(){
        itemsNotas.clear();

        for(int i = 0; i < notas.size(); i++){
            Nota nota = notas.get(i);

            String info = "Titulo: " + nota.getTitulo() + "\n" + "Cuerpo: " + nota.getCuerpo();
            itemsNotas.add(info);
        }
        //Notificamos al adapter de los cambios hechos en la lista
        adapter.notifyDataSetChanged();
    }


}