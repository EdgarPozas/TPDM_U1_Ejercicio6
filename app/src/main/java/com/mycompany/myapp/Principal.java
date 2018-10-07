package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;

public class Principal extends Activity
{
	private String nombrearchivo;
	private ListView lista;
	private EditText nombre;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		nombre=findViewById(R.id.principaltxt);
		lista=findViewById(R.id.lista);
		nombrearchivo=getIntent().getStringExtra("nombre");
		
		if(nombre!=null){
			nombre.setText(nombrearchivo);
		}
		lista.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> ad,View v,int i, long l){
				
				switch(i){
					case 0:
						if(nombre.getText().toString().isEmpty()){
							Toast.makeText(Principal.this,"Ingresa nombre",Toast.LENGTH_SHORT).show();
							return;
						}
						Intent intent1=new Intent(Principal.this,MainActivity.class);
						intent1.putExtra("nombre",nombre.getText().toString());
						startActivity(intent1);
						break;
					case 1:
						if(nombre.getText().toString().isEmpty()){
							Toast.makeText(Principal.this,"Ingresa nombre",Toast.LENGTH_SHORT).show();
							return;
						}
						Intent intent2=new Intent(Principal.this,Activity2.class);
						intent2.putExtra("nombre",nombre.getText().toString());
						startActivity(intent2);
						break;
					case 2:
						AlertDialog.Builder alerta=new AlertDialog.Builder(Principal.this);
						alerta.setView(getLayoutInflater().inflate(R.layout.main4,null));
						alerta.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface d,int i){
								d.dismiss();
							}
						});
						alerta.show();
						break;
					
				}
			}
		});
	}
	
}
