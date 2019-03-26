package com.diana.nn_happ;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import uma.diana.nn_happ.R;
import uma.diana.nn_happ.Util;

public class Act_config extends Activity {
	
	// Instancias que se asociar�n a los controles editables de this.
		private CheckBox cbMostrarTiempo   ;
		private CheckBox cbMostrarMensajes ;
		private CheckBox cbDiferIconosHapt ;
		private CheckBox cbInfoVisual      ;
		private CheckBox cbInfoAuditiva    ;
		private CheckBox cbVibrarOnClick   ;
		private RadioButton rbVerEstandar  ;
		private RadioButton rbVerShort     ;
		private RadioButton rbVerDIY       ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_config);

		cbMostrarTiempo   = (CheckBox)findViewById( R.id.cbConfMostrarTiempo   );
		cbMostrarMensajes = (CheckBox)findViewById( R.id.cbConfMostrarMsgs     );
		cbDiferIconosHapt = (CheckBox)findViewById( R.id.cbConfDiferIconosHapt );
		cbInfoVisual      = (CheckBox)findViewById( R.id.cbConfInfVisual       );
		cbInfoAuditiva    = (CheckBox)findViewById( R.id.cbConfInfAud          );
		cbVibrarOnClick   = (CheckBox)findViewById( R.id.cbConfVibrarOnClick   );		
		
		rbVerEstandar     = (RadioButton)findViewById( R.id.rbConfVerEstandar   );
		rbVerShort        = (RadioButton)findViewById( R.id.rbConfVerShort      );
		rbVerDIY          = (RadioButton)findViewById( R.id.rbConfVerDIY        );
		
		ActualizaControles();
		
		Util.DlgInfoInit( this, null );
		
		((Button)findViewById( R.id.btnCargarConfDef )).setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Util.uhl_PlayClick();
				Util.LoadConf_DefaultValues( (Activity) v.getContext() );
				ActualizaControles();
				
				Util.DlgInfoShow( "Configuraci�n", "Se ha cargado la configuraci�n por defecto." );				
				Util.Log("   Se ha cargado la configuraci�n por defecto." );
			}
		});
		
		AsociaImgClickListener( cbMostrarTiempo   );   
        AsociaImgClickListener( cbMostrarMensajes );
   		AsociaImgClickListener( cbDiferIconosHapt );
		AsociaImgClickListener( cbInfoVisual      );
	    AsociaImgClickListener( cbInfoAuditiva    );
	    AsociaImgClickListener( cbVibrarOnClick   );	    
	    AsociaImgClickListener( rbVerEstandar     );
	    AsociaImgClickListener( rbVerShort        );
	    AsociaImgClickListener( rbVerDIY          );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_act_config, menu);
	
		return true;
	}
	
	
	public void AsociaImgClickListener( View view )
	{
		view.setOnClickListener( new OnClickListener() {
			
	        @Override			
			public void onClick(View v) {
	        	
	        	if( v == cbVibrarOnClick )
	        		Util.VibrarOnClick = cbVibrarOnClick.isChecked();
	        	
	        	Util.uhl_PlayClick();
			} 
		} );
	}
	
	/** Aplica la configuraci�n actual a los controles de this */
	public void ActualizaControles()
	{
		cbMostrarTiempo   .setChecked( Util.MostrarTiempo );
		cbMostrarMensajes .setChecked( Util.MostrarMensajes );
		cbDiferIconosHapt .setChecked( Util.DiferIconosHapt );
		cbInfoVisual      .setChecked( Util.InfoVisual      );
		cbInfoAuditiva    .setChecked( Util.InfoAuditiva    );
		cbVibrarOnClick   .setChecked( Util.VibrarOnClick   );
		
		
		int modo = Util.ModoFuncToInt( Util.MF );
		rbVerEstandar.setChecked( modo == 0 );
		rbVerShort   .setChecked( modo == 1 );
		rbVerDIY     .setChecked( modo == 2 );		
	}	
	protected void onPause() {
	    super.onPause();
	    
		
	    
		Util.MostrarTiempo   = cbMostrarTiempo   .isChecked();
		Util.MostrarMensajes = cbMostrarMensajes .isChecked(); 
		Util.DiferIconosHapt = cbDiferIconosHapt .isChecked(); 
		Util.InfoVisual      = cbInfoVisual      .isChecked(); 
		Util.InfoAuditiva    = cbInfoAuditiva    .isChecked();
		Util.VibrarOnClick   = cbVibrarOnClick   .isChecked();
		
	    int modo = 0;
	  /*if      ( ((RadioButton)findViewById( R.id.rbConfVerEstandar )).isChecked() ) modo = 0;
	    else*/if( ((RadioButton)findViewById( R.id.rbConfVerShort    )).isChecked() ) modo = 1; 
	    else  if( ((RadioButton)findViewById( R.id.rbConfVerDIY      )).isChecked() ) modo = 2;

	    Util.MF = Util.IntToModoFunc( modo );
	    
	    Util.SaveConf( this );	    
	    Util.LoadConf( this );
	    
	}
	
 public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
	 
			switch(keyCode){
				case KeyEvent.KEYCODE_CAMERA:
					Toast.makeText(this, "Obturador presionado",
	                                                        Toast.LENGTH_SHORT).show();
					return true;
				case KeyEvent.KEYCODE_VOLUME_UP:
					/*Toast.makeText(this, "Boton de Volumen Up presionado",
	                                                        Toast.LENGTH_SHORT).show();*/
					
					
					
					return true;
				case KeyEvent.KEYCODE_BACK:
					/*Toast.makeText(this, "Boton de Volumen Down presionado",
	                                                        Toast.LENGTH_SHORT).show();*/
					
					
					
					
					
					finish();
					super.finish();
					
					
					
					
					Intent intent = new Intent( getApplicationContext(), MainActivity.class);
					startActivity( intent );	
					
					
					
					
					return true;
			}
			return super.onKeyDown(keyCode, event);
		}
	 
	
		

}
