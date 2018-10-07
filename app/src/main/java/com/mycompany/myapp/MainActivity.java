package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity 
{
	private EditText valores;
	private String nombre;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		valores=findViewById(R.id.valores);
		nombre=getIntent().getStringExtra("nombre");
    }
	
	public void cambiar(View v){
		if(valores.getText().toString().isEmpty()){
			Toast.makeText(this,"ingresa datos",Toast.LENGTH_SHORT).show();
			return;
		}
		String[] datos=valores.getText().toString().split(",");
		
		for(String s: datos){
			try{
				Integer.parseInt(s);
			}catch(Exception ex){
				Toast.makeText(this,"solo enteros",Toast.LENGTH_SHORT).show();
				return;
			}
		}
		
		try{
			OutputStreamWriter ou=new OutputStreamWriter(openFileOutput(nombre,Context.MODE_PRIVATE));
			ou.write(valores.getText().toString());
			ou.close();
			Toast.makeText(MainActivity.this,"Datos guardados",Toast.LENGTH_SHORT).show();
		}catch(Exception ex){
			Toast.makeText(MainActivity.this,"Error al guardar",Toast.LENGTH_SHORT).show();
			ex.printStackTrace();
		}
		finish();
	}
}
