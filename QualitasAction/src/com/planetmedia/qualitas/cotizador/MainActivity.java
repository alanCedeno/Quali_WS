package com.planetmedia.qualitas.cotizador;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	ArrayList<Integer> imagenes = new ArrayList<Integer>();
	
	ArrayList<String> marcas = new ArrayList<String>();
	ArrayList<String> versiones = new ArrayList<String>();
	ArrayList<String> anos = new ArrayList<String>();
	ArrayList<String> tipos = new ArrayList<String>();

	
	Spinner spMarca;
	Spinner spVersion;
	Spinner spAno;
	Spinner spTipo;
	
	ImageView logoMarca;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// EXAMPLE SPINNER
		llenarSpinners();
		
		logoMarca= (ImageView)findViewById(R.id.imgLogo);
		
		spMarca=(Spinner)findViewById(R.id.spMarca);
		spVersion=(Spinner)findViewById(R.id.spVersion);
		spAno=(Spinner)findViewById(R.id.spAno);
		spTipo=(Spinner)findViewById(R.id.spTipo);
		
		
		
        ArrayAdapter<String> adMarcas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, marcas);      
        ArrayAdapter<String> adVersiones = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, versiones);      
        ArrayAdapter<String> adAno = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, anos);      
        ArrayAdapter<String> adTipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipos);      
       
        spMarca.setAdapter(adMarcas);
        spVersion.setAdapter(adVersiones);
        spAno.setAdapter(adAno);
        spTipo.setAdapter(adTipo);
        
        
        spMarca.setOnItemSelectedListener(new OnItemSelectedListener() {         
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
        //Toast.makeText(parentView.getContext(), "Has seleccionado " + parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            	logoMarca.setImageResource(imagenes.get(position));
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {            	
            }
        });  
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu:
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	
	private void llenarSpinners() {
		
		
		marcas.add("ACURA");
		marcas.add("ALFA ROMEO");
		marcas.add("AUDI");
		
		versiones.add("VERSION1");
		versiones.add("VERSION2");
		versiones.add("VERSION3");
		versiones.add("VERSION4");

		
		anos.add("1990");
		anos.add("1991");
		anos.add("1992");
		anos.add("1993");
		
		tipos.add("TIPO1");
		tipos.add("TIPO2");
		tipos.add("TIPO3");
		tipos.add("TIPO4");
		tipos.add("TIPO5");

		
		
		imagenes.add(R.drawable.acura);
		imagenes.add(R.drawable.alfaromeo);
		imagenes.add(R.drawable.audi);
				
	}
	
	
	
}