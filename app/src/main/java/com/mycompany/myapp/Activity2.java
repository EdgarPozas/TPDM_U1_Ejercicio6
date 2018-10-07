package com.mycompany.myapp;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.io.*;

public class Activity2 extends Activity
{
	private String[] datos;
	private EditText ind;
	private TextView txt;
	private boolean listo;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		
		try{
			InputStreamReader in=new InputStreamReader(openFileInput(getIntent().getStringExtra("nombre")));
			BufferedReader bufin=new BufferedReader(in);
			datos=bufin.readLine().split(",");
			in.close();
			listo=true;
		}catch(Exception ex){
			listo=false;
			Toast.makeText(this,"Error en ruta",Toast.LENGTH_SHORT).show();
			ex.printStackTrace();
			return;
		}
		
		//datos=getIntent().getStringExtra("datos").split(",");
		ind=findViewById(R.id.selec);
		txt=findViewById(R.id.txt);
		
	}
	public void mostrar(View v){
		if(!listo){
			Toast.makeText(this,"Error en ruta",Toast.LENGTH_SHORT).show();
			return;
		}	
		
		if(ind.getText().toString().isEmpty()){
			Toast.makeText(this,"Ingresa indice",Toast.LENGTH_SHORT).show();
			return;
		}
		
		int in=Integer.parseInt(ind.getText().toString());
		
		if(in>=datos.length){
			AlertDialog.Builder alerta =new AlertDialog.Builder(this);
			alerta.setTitle("TPDM").setMessage("Indice fuera de rango");
			alerta.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog,int i){
						dialog.dismiss();
					}
				});
			alerta.show();
			return;
		}
		
		txt.setText("Posición "+in+" : "+datos[in]);
		
	}
}
