package com.diana.nn_happ;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import uma.diana.nn_happ.R;



/** Asociado al control que muestra el mensaje para entrar en la ventana de configuraci�n */


public class Act_main extends Activity {
	
	
	
	/** Timer que permitir� mostrar la portada de la aplicaci�n durante <RetardoPortada> ms*/
	private Timer TimerRetardoPortada;
	
	/** N�mero de ms que se mantendr� la imagen de portada */
	private int PeriodoRetardoPortada = 50;
	
	/** Contiene el n�mero de Ciclos del TimerRetardoPortada que se espera antes realizar la pr�xima acci�n */
	private final int NumCiclosRetardoPortada = 30;
	
	/** Cuenta el n�mero de ciclos del TimerRetardoPortada que se han producido */
	private int ContCliclosRetardoPortada = 0;
	
	/** Contiene la imagen de portada */
	private ImageView imgPortada = null;
	
	/** Indica a la rutina de atenci�n al timer si debe abrir la 
	 * primera Activity o cerrar la aplicaci�n */
	private boolean salirProgramado = false;
	
	/** Asociado al control que muestra el mensaje para entrar en la ventana de configuraci�n */
	private TextView tvConfig;
	
	/** Valdr� true desde que se muestra la ventana de configuraci�n hasta que se sale de ella */
	private boolean EnConfig = false;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_main);
	    	Util.AM = getAssets();
	    	
	    	// Cargamos la configuraci�n de la aplicaci�n y la asignamos a Utilidades.Conf
			Util.LoadConf( this );
	     	Util.ConfigToLog();
		
		    tvConfig = (TextView)findViewById( R.id.tvConfig );
	        
	        AsociaImgClickListener( tvConfig );
	        AsociaImgClickListener( findViewById( R.id.imgMain )  );
	        
			ProgramarTimer();		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_act_main, menu);
		return true;
	}

	/** Programa el Timer para que se ejecute la tarea que tiene asociada */
	private void ProgramarTimer()
	{
		if( TimerRetardoPortada != null )  // Evita errores -> No se deben crear y ejecutar varios timers simult�neamente sobre
			return;           // la misma instancia y las mismas funciones.
		
		ContCliclosRetardoPortada = 0;
		
		// Para programar una llamada a TimerMethod:
		TimerRetardoPortada = new Timer();
		TimerRetardoPortada.schedule(new TimerTask() {			
			@Override
			public void run() {
				TimerMethod();
			}
		}, 0, PeriodoRetardoPortada);
	}
    
	private void TimerMethod()
	{
		// Esta funci�n se ejecuta en un thread que no es el que se usa para actualizar la interfaz.
		// Para que exista sincronizaci�n con el thread que actualiza la interfaz:
		this.runOnUiThread(Timer_Tick);
	}
	
	/** Este objeto define la funci�n run que permitir� realizar cambios en la interfaz al ser
	 * llamado desde TimerMethod de modo que la tarea se ejectue en el thread que actualiza la interfaz.*/
	private Runnable Timer_Tick = new Runnable()
	{
		public void run() 
		{
			if( EnConfig || TimerRetardoPortada == null )
				return;
			
			if( salirProgramado )
			{
				if( ContCliclosRetardoPortada++ < NumCiclosRetardoPortada )
					return;
				
				finish();
			}
			else
			{
				String cad = "";
				
				for(int c=1; c < NumCiclosRetardoPortada - ContCliclosRetardoPortada; c++ )
				{
					cad = cad + ".";
				}

				tvConfig.setText( "Pulsar para configurar" + cad );
				
				if( ContCliclosRetardoPortada++ < NumCiclosRetardoPortada )
					return;
				
			    TimerRetardoPortada.cancel();
			    TimerRetardoPortada = null;
			    
			    IniciarSigAct();
			}
		}
	};
	
	
	/** Crea y muestra la siguiente Activity de acuerdo a la configuraci�n actual */
	private void IniciarSigAct()
	{
		if( Util.MF == Util.ModoFunc.DIY )
		{
			Util.Log("���������������� Fase de Configuraci�n de Iconos ");
			
		/*	Intent intent = new Intent( getApplicationContext(), ActConfIcons.class);
			startActivity(intent);*/
		}
		else
		{
			Util.Log("���������������� Fase de Aprendizaje ");
			
			finish();
			Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	public void AsociaImgClickListener( View view )
	{
		view.setOnClickListener( new OnClickListener() {
	        @Override			
			public void onClick(View v) {
	        	
	        	if( salirProgramado )
	        		return;
	        	
	        	Util.Log("���������������� Ventana de Configuraci�n General");
				
				EnConfig = true;
				
				// Detenemos el Timer:
				if( TimerRetardoPortada != null )
				{
				    TimerRetardoPortada.cancel();
				    TimerRetardoPortada = null;
				}
				
				Util.uhl_PlayClick();
				
				finish();
				Intent intent = new Intent( getApplicationContext(), Act_config.class);
				startActivity( intent );			
			} 
		} );
	}
	
	/** Cuando se vuelve a mostrar la ventana asumimos que la aplicaci�n debe cerrarse. */
	@Override
	protected void onRestart() {
		super.onRestart();
		
		if( EnConfig )
		{
			EnConfig = false;
			
			Util.ConfigToLog();
			
		    IniciarSigAct();
		}
		else
		{
			Util.uhl_Stop();
			Util.StopSound( );
			Util.LoadImg( imgPortada, "happ" ,"fin");
			Util.PlaySound( "gracias" );
	/*		mensaje_pantalla("Gracias por su colaboracion.");*/
                    
			salirProgramado = true;
			tvConfig.setText( "" );
			Util.Log( "          ... cerrando aplicaci�n " );
			ProgramarTimer();
		}
	}
}
