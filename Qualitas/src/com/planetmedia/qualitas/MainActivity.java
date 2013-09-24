package com.planetmedia.qualitas;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	ArrayList<String> marcas = new ArrayList<String>();
	ArrayList<Integer> imagenes = new ArrayList<Integer>();
	Spinner spMarca;
	Spinner spVersion;
	Spinner spAno;
	ImageView logoMarca;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		logoMarca= (ImageView)findViewById(R.id.ivLogoMarca);
		spVersion=(Spinner)findViewById(R.id.spVersion);
						
		llenarSpinners();
				
		spMarca = (Spinner) findViewById(R.id.spMarca);
        ArrayAdapter<String> adMarcas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, marcas);      
        spMarca.setAdapter(adMarcas);        
        spMarca.setOnItemSelectedListener(new OnItemSelectedListener() {         
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
//            	Toast.makeText(parentView.getContext(), "Has seleccionado " + parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            	logoMarca.setImageResource(imagenes.get(position));
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {            	
            }
        });  
        spVersion.setAdapter(adMarcas);
    }

	private void llenarSpinners() {
		marcas.add("ACURA");
		marcas.add("ALFA ROMEO");
		marcas.add("AUDI");		
		imagenes.add(R.drawable.acura);
		imagenes.add(R.drawable.alfaromeo);
		imagenes.add(R.drawable.audi);
				
	}
}