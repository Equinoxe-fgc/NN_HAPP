package com.diana.nn_happ;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.immersion.uhl.Device;
import com.immersion.uhl.IVTBuffer;
import com.immersion.uhl.Launcher;

public class Act_parejas extends Activity {
	
	
  	public boolean entrada[]= new boolean [20]; // Coordinadores de selecci�n de posiciones de iconos
	public String cont_icono[] = new String [20]; //contenido icono
	public String cont_icono_y[] = new String [20];
	public boolean acierto_icono[]= new boolean[20];
	public boolean error_icono[]= new boolean[20];
	public int contador_aciertos = 0;
	public boolean correcto = false;
	public boolean no_voz = true;
	public boolean no_seleccion = false;
	
	public int indice_icono=0;
	public int indice_icono_fallo;
	
	public boolean dedo_seleccion = false;
	
	
	public MotionEvent evento;
	
		
    
	
	public int fase =0;  // Marcador de estado de fase
	
	 
	 private  Launcher launcher;
	 
	 public int estado_tb = 0;
	 public String icono, memoria_icono = "";
	 
	 
	 public boolean mensaje_tb = true;
	 
	 public int selecciones =0;
	 public boolean tipo_seleccion = true;
	 public boolean fase_activa = false;

	   
		
	 /*
	  * CARGA DE LOS FICHEROS H�PTICOS
	  */
	 
	   Device device;
	   IVTBuffer ivtBuffer1 = new IVTBuffer(facebook.ivt);
	   IVTBuffer ivtBuffer2 = new IVTBuffer(twitter.ivt);
	   IVTBuffer ivtBuffer3 = new IVTBuffer(linkedin.ivt);
	   IVTBuffer ivtBuffer4 = new IVTBuffer(guasapp.ivt);
	   IVTBuffer ivtBuffer5 = new IVTBuffer(phone.ivt);
	   IVTBuffer ivtBuffer6 = new IVTBuffer(esemese.ivt);
	   IVTBuffer ivtBuffer7 = new IVTBuffer(email.ivt);
	   IVTBuffer ivtBuffer8 = new IVTBuffer(line.ivt);
	   IVTBuffer ivtBuffer9 = new IVTBuffer(googleplus.ivt);
	   IVTBuffer ivtBuffer10 = new IVTBuffer(wifi.ivt);
	   IVTBuffer ivtBuffer11 = new IVTBuffer(update.ivt);
	   IVTBuffer ivtBuffer12 = new IVTBuffer(tolk.ivt);
	   IVTBuffer ivtBuffer13 = new IVTBuffer(bateria.ivt);
	   IVTBuffer ivtBuffer14 = new IVTBuffer(calendario.ivt);
	   IVTBuffer ivtBuffer15 = new IVTBuffer(reloj.ivt);
	   IVTBuffer ivtBuffer16 = new IVTBuffer(camara.ivt);
	   
	   
	   
	   
	   
	   
	   
	   
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_parejas);
		
		 
		
		 if (Util.MF == Util.ModoFunc.SHORT ){  // VERSI�N CORTA
			 loadfase(2);
			 fase =2;
		 }else{loadfase(0);   // VERSI�N COMPLETA
		        fase=0;}
		 
		 
		 Util.ApplicationName = "NN_HAPP";
		 
		 if (!Util.MostrarTiempo){    // MOSTRAR TEMPORIZADOR SI PROCEDE
			 TextView tiempo =  (TextView) findViewById(R.id.textView2);
			 tiempo.setTextColor(0); 
		 }
		 
		 
		
		 
		 try{ device = Device.newDevice(getApplicationContext());  // COMPONENTE H�PTICO
			
			} catch(Exception e){}
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_parejas, menu);
		return true;
	}
	
	/*
	*****************************************************************
	   SELECCIONAR IMAGEN (img) SOBRE OBJETO CONTENEDOR DE PANTALLA (i) 
	******************************************************************/
	
	public void  visible_icono( int indice, int img){  // indice de icono, contenido de icono
		try{ 
		  if (indice == 0){
		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
	       dibujo.setImageResource(img);}
		  if (indice == 1){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
		       dibujo.setImageResource(img);}
		  if (indice == 2){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
		       dibujo.setImageResource(img);}
		  if (indice == 3){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
		       dibujo.setImageResource(img);}
		  if (indice == 4){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
		       dibujo.setImageResource(img);}
		  if (indice == 5){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
		       dibujo.setImageResource(img);}
		  if (indice == 6){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
		       dibujo.setImageResource(img);}
		  if (indice == 7){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
		       dibujo.setImageResource(img);}
		
		  if (indice == 8){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
		       dibujo.setImageResource(img);}			
			  if (indice == 9){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
			       dibujo.setImageResource(img);}
			  if (indice == 10){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
			       dibujo.setImageResource(img);}
			  if (indice == 11){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
			       dibujo.setImageResource(img);}
			  if (indice == 12){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
			       dibujo.setImageResource(img);}
			  if (indice == 13){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
			       dibujo.setImageResource(img);}
			  if (indice == 14){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
			       dibujo.setImageResource(img);}
			  if (indice == 15){
				   ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
			       dibujo.setImageResource(img);}
			
			 
        }catch (Exception e) 
        	{Toast.makeText(this, "falla  VISIBLE_ICONO",
                    Toast.LENGTH_SHORT).show();}
	
	
	
	
	}

	/*
	 *********************************
	   SELECCI�N DE RECURSO DE IMAGEN 
	***********************************/
	public int imagen ( String img){
		int entero=0;
		
		if (!Util.InfoVisual)
		{ 
			if (img.indexOf("_y") == -1){
			entero = R.drawable.def_int;}else{ entero = R.drawable.def_int_y;}
			
		}else{
		try{ 
		
		
	
 	     if (img == "facebook")
			entero= R.drawable.facebook;
 	     if (img== "facebook_y")
 	    	 entero=R.drawable.facebook_y;
		 if (img=="twitter")
			 entero = R.drawable.twitter;
		 if (img=="twitter_y")
			 entero = R.drawable.twitter_y;
		 
		 if (img=="linkedin")
			 entero =R.drawable.linkedin;
		 if (img=="linkedin_y")
			 entero =R.drawable.linkedin_y;
		 if (img=="wasapp")
			 entero =R.drawable.wasapp;
		 if (img=="wasapp_y")
			 entero =R.drawable.wasapp_y;
		 if (img=="phone")
			 entero =R.drawable.phone;
		 if (img=="phone_y")
			 entero =R.drawable.phone_y;
		 if (img=="sms")
			 entero =R.drawable.sms;
		 if (img=="sms_y")
			 entero =R.drawable.sms_y;
		 if (img=="email")
			 entero = R.drawable.email;
		 if (img=="email_y")
			 entero = R.drawable.email_y;
		 if (img=="line")
			 entero =R.drawable.line;
		 if (img=="line_y")
			 entero =R.drawable.line_y;
		 if (img=="googleplus_y")
			 entero = R.drawable.googleplus_y;
		 if (img=="googleplus")
			 entero = R.drawable.googleplus;
		 if (img=="wifi")
			 entero= R.drawable.wifi;
		 if (img=="wifi_y")
			 entero= R.drawable.wifi_y;
		 if (img=="update")
			 entero= R.drawable.update;
		 if (img=="update_y")
			 entero= R.drawable.update_y;
		 if (img=="talk")
			 entero= R.drawable.talk;
		 if (img=="talk_y")
			 entero= R.drawable.talk_y;
		 if (img=="bateria")
			 entero=R.drawable.bateria;
		 if (img=="bateria_y")
			 entero=R.drawable.bateria_y;
		 if (img=="calendario")
			 entero=R.drawable.calendario;
		 if (img=="calendario_y")
			 entero=R.drawable.calendario_y;
		 if (img=="reloj")
			 entero= R.drawable.reloj; 
		 if (img=="reloj_y")
			 entero= R.drawable.reloj_y; 
		 if (img=="camara")
			 entero= R.drawable.camara;
		 
		 if (img=="camara_y")
			 entero= R.drawable.camara_y;
		 
		 if (img=="def")
			 entero= R.drawable.def;
		 
		 if (img == "deficon")
			 entero = R.drawable.deficon;
		 
		 if (img == "def_haptic_icon_disabled")
			 entero = R.drawable.def_haptic_icon_disabled;
		 
		 if (img == "def_haptic_icon_disabled_y")
			 entero = R.drawable.def_haptic_icon_disabled_y;
		 
		 if (img == "def_haptic_icon")
			 entero = R.drawable.def_haptic_icon;
		 
		 if (img == "def_haptic_icon_y")
			 entero = R.drawable.def_haptic_icon_y;
		 
		 
		 if (img == "def_int")
				entero= R.drawable.def_int;
		 
		 if (img == "def_int_y")
				entero= R.drawable.def_int_y;
		 if (img == "def_error")
				entero= R.drawable.def_error; 
		
		 
		}catch (Exception e) 
    	{Toast.makeText(this, "falla  IMAGEN",
                Toast.LENGTH_SHORT).show();}
		}
		 return entero;
		
	}
	
	/* 
	  Inicializaci�n de la pantalla de test seg�n la fase de la prueba que se quiera usar:
	 
	     - PRIMER REFUERZO DEL APRENDIZAJE
	     - SEGUNDO REFUEZO DEL APRENDIZAJE
	     - PRIMER TEST
	     - SEGUNDO TEST
	     
	 */
	
	public void loadfase( int estado_fase){
		
		TextView texto =  (TextView) findViewById(R.id.textView1);
		TextView texto1 =  (TextView) findViewById(R.id.textView2);
		texto1.setText("0:00");
		
		switch (estado_fase)
		{
		
		case 0:
			
			
			texto.setText("PRIMER REFUERZO     DEL APRENDIZAJE");
	        cont_icono[0]= "facebook";
	        cont_icono[1]="twitter";
	        cont_icono[2]= "linkedin";
	        cont_icono[3]="wasapp";
	        cont_icono[4]="phone";
	        cont_icono[5]="sms";
	        cont_icono[6]="email";
	        cont_icono[7]="line";
	        cont_icono[14]="twitter";
	        cont_icono[11]="wasapp";
	        cont_icono[9]="sms";
	        cont_icono[8]="facebook";
	        cont_icono[10]="email";
	        cont_icono[12]="line";
	        cont_icono[13]="linkedin";
	        cont_icono[15]="phone";
	        
	        cont_icono_y[14]="twitter_y";
	        cont_icono_y[11]="wasapp_y";
	        cont_icono_y[9]="sms_y";
	        cont_icono_y[8]="facebook_y";
	        cont_icono_y[10]="email_y";
	        cont_icono_y[12]="line_y";
	        cont_icono_y[13]="linkedin_y";
	        cont_icono_y[15]="phone_y";
	        
	        icono = "";
            memoria_icono="";
            
	        fase_activa = false; // Iniciar temporizador pantalla
	         Util.Cr.Iniciar();
	        contador_aciertos =0;
	        
            int i=0;
			
              estado_tb = 0 ;
             
			while( i < 16){
			  acierto_icono[i]=false;
			  error_icono[i]=false;
			  if (i<8)
			  { 
			  visible_icono(i,imagen("def_haptic_icon_disabled"));}else
			  {/*visible_icono(i,imagen("def_int"));*/
				  if (fase<2)
				  {
					  visible_icono(i,imagen("def_int"));
				  }else{ visible_icono(i,imagen(cont_icono[i]));}
			  }
			  
			  i++;
			}
	        
			if (Util.InfoAuditiva)
			Util.PlaySound("primerref");
		  
		   break;
		   
		case 1:
			
			
			texto.setText("SEGUNDO REFUERZO DEL APRENDIZAJE");
			
			estado_tb = 0;
			
	        cont_icono[0]= "googleplus";
	        cont_icono[1]="wifi";
	        cont_icono[2]= "update";
	        cont_icono[3]="talk";
	        cont_icono[4]="bateria";
	        cont_icono[5]="calendario";
	        cont_icono[6]="reloj";
	        cont_icono[7]="camara";
	        cont_icono[10]="update";
	        cont_icono[14]="wifi";
	        cont_icono[15]="reloj";
	        cont_icono[8]="camara";
	        cont_icono[9]="bateria";
	        cont_icono[11]="calendario";
	        cont_icono[12]="googleplus";
	        cont_icono[13]="talk";
	        
	        cont_icono_y[10]="update_y";
	        cont_icono_y[14]="wifi_y";
	        cont_icono_y[15]="reloj_y";
	        cont_icono_y[8]="camara_y";
	        cont_icono_y[9]="bateria_y";
	        cont_icono_y[11]="calendario_y";
	        cont_icono_y[12]="googleplus_y";
	        cont_icono_y[13]="talk_y";
	        
	        icono = "";
            memoria_icono="";
	        
	        Util.Cr.Iniciar();
	        
	        fase_activa = false; // Iniciar temporizador pantalla
	     /*   Util.Cr_p.Iniciar();*/
	        contador_aciertos=0;
	        
              i=0;
			
              while( i < 16){
    			  acierto_icono[i]=false;
    			  error_icono[i]=false;
    			  if (i<8)
    			  {
    			  visible_icono(i,imagen("def_haptic_icon_disabled"));}else
    			  {    if (fase<2)
				     {
					  visible_icono(i,imagen("def_int"));
				  }else{ visible_icono(i,imagen(cont_icono[i]));}}
    			  
    			  i++;
    			}
              
              if (Util.InfoAuditiva)
      			Util.PlaySound("segundoref");
			
			break;
		case 2:
			
			texto.setText("PRIMER TEST");
	        cont_icono[0]= "facebook";
	        cont_icono[1]="twitter";
	        cont_icono[2]= "linkedin";
	        cont_icono[3]="wasapp";
	        cont_icono[4]="phone";
	        cont_icono[5]="sms";
	        cont_icono[6]="email";
	        cont_icono[7]="line";
	        cont_icono[8]="twitter";
	        cont_icono[9]="wasapp";
	        cont_icono[10]="sms";
	        cont_icono[11]="facebook";
	        cont_icono[12]="email";
	        cont_icono[13]="line";
	        cont_icono[14]="linkedin";
	        cont_icono[15]="phone";
	        estado_tb = 0;
	       
	        cont_icono_y[8]="twitter_y";
	        cont_icono_y[9]="wasapp_y";
	        cont_icono_y[10]="sms_y";
	        cont_icono_y[11]="facebook_y";
	        cont_icono_y[12]="email_y";
	        cont_icono_y[13]="line_y";
	        cont_icono_y[14]="linkedin_y";
	        cont_icono_y[15]="phone_y";
	        
	        icono = "";
            memoria_icono="";
            
	        Util.Cr.Iniciar();
	       
	        fase_activa = false; // Iniciar temporizador pantalla
	      /*  Util.Cr_p.Iniciar();*/
	        contador_aciertos =0;
	        
             i=0;
			
             while( i < 16){
   			  acierto_icono[i]=false;
   			error_icono[i]=false;
   			  if (i<8)
   			  {
   			  visible_icono(i,imagen("def_haptic_icon_disabled"));}else
   			  {   
   				  visible_icono(i,imagen(cont_icono[i]));}
   			  
   			  i++;
   			}
			
             if (Util.InfoAuditiva)
       			Util.PlaySound("primertest");
			
			break;
		case 3:
			
			
			texto.setText("SEGUNDO TEST");
			
			cont_icono[0]= "googleplus";
	        cont_icono[1]="wifi";
	        cont_icono[2]= "update";
	        cont_icono[3]="talk";
	        cont_icono[4]="bateria";
	        cont_icono[5]="calendario";
	        cont_icono[6]="reloj";
	        cont_icono[7]="camara";
	        cont_icono[8]="update";
	        cont_icono[9]="wifi";
	        cont_icono[10]="reloj";
	        cont_icono[11]="camara";
	        cont_icono[12]="bateria";
	        cont_icono[13]="calendario";
	        cont_icono[14]="googleplus";
	        cont_icono[15]="talk";
	        estado_tb = 0;
	      
	        cont_icono_y[8]="update_y";
	        cont_icono_y[9]="wifi_y";
	        cont_icono_y[10]="reloj_y";
	        cont_icono_y[11]="camara_y";
	        cont_icono_y[12]="bateria_y";
	        cont_icono_y[13]="calendario_y";
	        cont_icono_y[14]="googleplus_y";
	        cont_icono_y[15]="talk_y";
	        
	        icono = "";
            memoria_icono="";
	        
	        Util.Cr.Iniciar();
	        estado_tb = 0 ;
	        fase_activa = false; // Iniciar temporizador pantalla
	        Util.Cr_p.Iniciar();
	        contador_aciertos=0;
	        
            i=0;
			
            while( i < 16){
     			  acierto_icono[i]=false;
     			 error_icono[i]=false;
     			  if (i<8)
     			  {
     			  visible_icono(i,imagen("def_haptic_icon_disabled"));}else
     			  {visible_icono(i,imagen(cont_icono[i]));}
     			  
     			  i++;
     			}
            if (Util.InfoAuditiva)
       			Util.PlaySound("segundotest");
			
			break;
			
			
		
		}
		
		
		
	}
	
	
	
	
	/*
	  FUNCI�N DE GESTI�N DE PULSACIONES TACTILES SOBRE LA PANTALLA. EMULACI�N DEL PROGRAMA DE APOYO
	  A PERSONAL CON DISCAPACIDAD VISUAL TALKBACK.
	*/
	
	
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
    	
		try{ 


	/*	TextView salida = (TextView) findViewById(R.id.TextViewSalida);*/
		
		 
/*
		salida.append(evento.toString() );
		try
		  {Thread.sleep(1500);}
		catch (Exception e) 
   		{};
   		
   		salida.clearComposingText(); */
                     
		
    	try{
        	launcher = new Launcher(this);
        }catch(RuntimeException re){}
		
		
		String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL","ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP","ACTION_HOVER_MOVE" };

		int accion = event.getAction();

		int codigoAccion = accion & MotionEvent.ACTION_MASK;
		
		

	/*	salida.append(acciones[codigoAccion]);

		for (int i = 0; i < evento.getPointerCount(); i++) {

		salida.append(" puntero: "  + evento.getPointerId(i) + 
		" x:" + evento.getX(i) + " y:" + evento.getY(i));

		}

		salida.append("\n");*/
		
		
	   //Doble click
		
		if(acciones[codigoAccion].equals("ACTION_POINTER_DOWN"))
			
		{
			 if (estado_tb ==3)
		    	 if(Util.Cr.Update()/100 <2){
		  	    	 estado_tb = 4;
		  	    	 Util.Cr.Detener();
		  	    	 Util.Cr.Iniciar();
		  	    	adpulsacioncontinua(); // hilo
		    	    }else {estado_tb = 1;
		    	           Util.Cr.Detener();
				  	    	 }
			
			  
	     if (estado_tb==1){
	    	 estado_tb = 2;
	    	 Util.Cr.Detener();
	    	 Util.Cr.Iniciar();
	    	 
	     }
	    
		}
	    
		
       if(acciones[codigoAccion].equals("ACTION_POINTER_UP"))
			
		{
    	   
			
    	   if (estado_tb==2){
    		   
    	    if(Util.Cr.Update()/100 <2){
  	    	 estado_tb = 3;
  	    	 Util.Cr.Detener();
  	    	 Util.Cr.Iniciar();
    	    }else {estado_tb = 1;
    	          /* Util.Cr.Detener();*/
		  	    	}
    	   }
  	     if (estado_tb ==4 )
  	     {
  	    	 if(Util.Cr.Update()/100 <2){   // seleccion
  	  	    	
  	    		comparador(); 
  	    		
  	    		int i=0;
  				
  	            while( i < 8){
  	            	
  	            	 if (acierto_icono[i])
  	            	 {  visible_icono(i,imagen(cont_icono[i]));
  	            	 }else { if (cont_icono[i] == memoria_icono){
  	            		visible_icono(i,imagen("def_haptic_icon"));
  	            	    }else{ visible_icono(i,imagen("def_haptic_icon_disabled")); }
  	            	 }
  	            	 
  	            	
  	     			 if ( !error_icono[i] && i < 8)
  	     			 {
  	     				 
  	     			   }else{ visible_icono(i,imagen("def_error"));}
  	     			  
  	     			  i++;
  	     			}
  	                    // mostrar los aciertos 
  	    		
  	    		estado_tb =1;  // mod doble click
  	            }else{}
		
	 	  }
  	     
  	   
		}
       
       // Fin doble Click
       
		
		/*salida.clearComposingText();*/
		if(acciones[codigoAccion].equals("ACTION_DOWN"))
			
		{
			
			int i=0;
			
			while( i < 16){
			  entrada[i]=true;
			  i++;
			}
			 
		
			
			if ((estado_tb == 1 || estado_tb == 3 ) && event.getPointerCount() == 1)
			{
				 if (estado_tb ==3)
			    	 if(Util.Cr.Update()/100 <2){
			  	    	 estado_tb = 4;
			  	    	 Util.Cr.Detener();
			  	    	 Util.Cr.Iniciar();
			  	    	 adpulsacioncontinua(); // hilo
			    	    }else {estado_tb = 1;
			    	           Util.Cr.Detener();
					  	    	 }
				
				  
		     if (estado_tb==1){
		    	 estado_tb = 2;
		    	 Util.Cr.Detener();
		    	 Util.Cr.Iniciar();
		    	 
		     }
		     
		    
			}
			
			
		}
		
    if(acciones[codigoAccion].equals("ACTION_UP"))
			
		{
    	if ((estado_tb == 2 || estado_tb == 4 ) && event.getPointerCount() == 1 )
    	{
    	if (estado_tb==2){
 		   
    	    if(Util.Cr.Update()/100 <2){
  	    	 estado_tb = 3;
  	    	 Util.Cr.Detener();
  	    	 Util.Cr.Iniciar();
    	    }else {estado_tb = 1;
    	           Util.Cr.Detener();
		  	    	}
    	   }
  	    
    	if (estado_tb ==4)
  	     {
  	    	 if(Util.Cr.Update()/100 <2){   // seleccion
  	  	    	
  	    		comparador(); 
  	    		
  	    		
                int i=0;
  				
  	            while( i < 8){
  	            	
  	            	 if (acierto_icono[i])
  	            	 {  visible_icono(i,imagen(cont_icono[i]));
  	            	 }else { if (cont_icono[i] == memoria_icono){
  	            		visible_icono(i,imagen("def_haptic_icon"));
  	            	    }else{ visible_icono(i,imagen("def_haptic_icon_disabled")); }
  	            	 }
  	            	 
  	            	
  	     			 if ( !error_icono[i] && i < 8)
  	     			 {
  	     				 
  	     			   }else{ visible_icono(i,imagen("def_error"));}
  	     			  
  	     			  i++;
  	     			}
  	                    // mostrar los aciertos 
  	    		
  	    		estado_tb = 1;  //modificacion doble click
  	            }else{}
		
	 	  }
    	}   	
    	
    	
			  mensaje_tb = false;
		
		}
		
      
		
		if ((acciones[codigoAccion].equals("ACTION_MOVE") || acciones[codigoAccion].equals("ACTION_DOWN")) && event.getPointerCount() == 1 ){
			
			
			
			
			
			
			if (estado_tb <1){
				{
			if (!no_seleccion){
		  seleccionar_icono(event);
			estado_tb = 1;
			}
				}
			
			/*Util.Cr.Iniciar();*/
			}
		
			
			if(Util.Cr.Update()/100 >2 && estado_tb<3)
			{
				if (!no_seleccion){
			 seleccionar_icono(event);
			 estado_tb = 1;
				}
				/*seleccion();*/
			}		
				
		if(Util.Cr.Update()/100 > 3)
				 {estado_tb = 1;
				 } 
				
			 
			 
		/*	if (estado_tb == 1 &&  Util.Cr.Update()/100 >3)   // esperar por si hubiera antes doble click
			{*/
				
			/*}*/
       	 
			return false;

			}
			
		     
		/*	if (estado_tb ==1 && mensaje_tb) {
				
	 			if (Util.Cr.Update()/1000 > 0.75)
	 			{   Util.PlaySound("bateria");
	 				Util.Cr.Iniciar();
	 				mensaje_tb = false;
	 			} else { }
	 				
			} */

			
			
			}catch (Exception e) 
	    	{Toast.makeText(this, "falla  touch",
	                Toast.LENGTH_SHORT).show();}
			return false;
			
		}
		
		
	/* 
	  CASACI�N DE SELECCIONES DE GRUPO SUPERIOR DE ICONOS CON EL GRUPO INFERIOR.	
	 */
	
		public void comparador(){
			if(!fase_activa){
	    			fase_activa = true;
	    			temporizador();
	    			
	    			
	    			if (fase == 0)
	    			{
	    			Util.LogWrLn();
	    			Util.Log("COMIENZA PRIMERA FASE DE REFUERZO");
	    			Util.LogWrLn();

	    			Util.Log_Excel_nl();
	    			Util.Log_Excel("COMIENZA PRIMERA FASE DE REFUERZO");
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel_nl();
	    			
	    			 
	    		 }
	    			if (fase == 1)
	    			{
	    			Util.LogWrLn();
	    			Util.Log("COMIENZA SEGUNDA FASE DE REFUERZO");
	    			Util.LogWrLn();
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel("COMIENZA SEGUNDA FASE DE REFUERZO");
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel_nl();
	    			 
	    		 }
	    			
	    			if (fase == 2)
	    			{
	    			Util.LogWrLn();
	    			Util.Log("COMIENZA PRIMER TEST");
	    			Util.LogWrLn();
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel("COMIENZA PRIMER TEST");
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel_nl();
	    			 
	    		 }
	    			if (fase == 3)
	    			{
	    			Util.LogWrLn();
	    			Util.Log("COMIENZA SEGUNDO TEST");
	    			Util.LogWrLn();
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel("COMIENZA SEGUNDO TEST");
	    			Util.Log_Excel_nl();
	    			Util.Log_Excel_nl();
	    			 
	    		 }
	    			
			}
	    			
	    		 
	    		 estado_tb = 5;
	  	    	
	  	    	
	  	    	
	  	        estado_tb = 1;
		   
	  	    /*	vibraciones_iconos();*/
	  	    	
	  	    	selecciones++;
	  	    	 
	  	    	 
	  	    	
	  	    	 mensaje_tb = false;
	  	    	
	  	    	 /*Util.Cr.Iniciar();*/
	  	    	
	  	    	if (selecciones>2)
	  	    	{
	  	    		selecciones=0;
	  	    		memoria_icono="";
	  	    		
	  	    	}
	    	   
	  	    	if (selecciones == 1)
	  	    	{
	  	    		if (tipo_seleccion)
	  	    		{ memoria_icono = icono;
	  	    	      int i =0;
		    	 
   	          while( i < 16){
   			   if(cont_icono[i]== icono && i<8){
   			   visible_icono(i,imagen("def_haptic_icon_y"));  // hacevisible icono
   			   vibraciones_iconos(icono);
   			   } 
   			   i++;
   			}
   	                Util.Log("   Click en primer  icono: " + icono + " (" + Util.Cr_p.GetStr() + ")" );
   		            Util.Log_Excel(icono + ";" + Util.Cr_p.GetStr() +";" );
   	           
   	          }else{ selecciones = 0 ;
	  	    		          memoria_icono = "";
	  	    		        /* cambio de selecci�n */}
	  	    	}
	  	    	
	  	    	int k =0, kk= 0;
	  	    	
	  	    	while (kk < 16)
	  	    	{
	  	    		if (icono == cont_icono[kk] && kk > 7)
	  	    		{
	  	    			k= kk;
	  	    		}
	  	    		kk++;
	  	    	}
	  	    	
	  	    	
	  	    	
	  	    	if (selecciones ==  2  && !acierto_icono[k] )
	  	    	{  if (!tipo_seleccion )
	  	    	      {
	  	    		     if (memoria_icono == icono){
	  	    		    	 /*correcto*/
	  	    		    	try{ /*Util.PlaySound("correcto");*/ 
	  	    		    		
	  	    		    		 no_seleccion = true;
	  	    		    		 int i =8;
			                        while (i < 16)
			                         {
			                           if 	 (cont_icono[i]== memoria_icono)
			                           indice_icono = i;
			                          
			                           i++;
			                         }
			                        
			                        correcto = false;
		  	    		    		Util.Cr_n.Iniciar();
		  	    		    		no_voz = false;
		  	    		    		nombrar();//hilo
	  	    		    		
	  	    		    		correcto(); 
	  	    		    		
     		               }catch (Exception e) 
     		               	{}
	  	    		    	
	  	    		    	
	  	    		    	Util.Log("   Click en segundo icono: " + icono  + " (" + Util.Cr_p.GetStr() + ") Correcto!!!" );
	        				Util.Log_Excel(icono + ";" + Util.Cr_p.GetStr() +";" + "correcto" );
	        				Util.Log_Excel_nl();
	        				
	  	    		    	 contador_aciertos++;
	  	    		    	 
	  	    	              int i =0;
	  	    		    	 
	  	    	          while( i < 16){
	  	    			   if(cont_icono[i]== memoria_icono){
	  	    			   acierto_icono[i]= true;
	  	    			   
	  	    			   if (i>7){
	  	    				   if (fase <2 ){  visible_icono(i,imagen(cont_icono[i]));  // hacevisible icono
		  	    			   vibraciones_iconos(icono);}else{
	  	    			   visible_icono(i,imagen("deficon"));  // hacevisible icono
	  	    			   vibraciones_iconos(icono);
	  	    				   }
	  	    			   }
	  	    			   } 
	  	    			   i++;
	  	    			}
	  	    		    	 
	  	    		    	 
	  	    		    	 if (contador_aciertos == 8) //final fase
	  	    		    	 {
	  	    		    	    
	  	    		    		
	  	    		    		fase_activa = false; 
	  	    		    		
	  	    		    	    
	  	    		    		if (fase < 3)
	  	    		    	    {	
	  	    		    		/*fase++;*/
	  	    		    	   
	  	    		    	    contador_aciertos = 0;
	  	    		    	    }
	  	    		    	    	
	  	    		    		final_fase();
	  	    				 
	  	    		    	 }
	  	    		    	
	  	    		    	 
	  	    		     }else {/* incorrecto*/
	  	    		    	 
	  	    		     try{ /*Util.PlaySound("incorrecto");*/ 
	  	    		                                               no_seleccion = true;
	  	    		    	                                        if (fase < 2){}else { contador_aciertos++;}
	  	    		                                               
												  	    		   correcto = true;
											                        int i =0; 
											                        
											                        
											                        
											                        while (i < 16)
											                         {
											                           if 	 (cont_icono[i]== memoria_icono)
											                           {
											                        	   if (i<8)
											                        	   {
											                              indice_icono = i;
											                           
											                        	   }
											                        	   
											                        	   
											                           }
											                           
											                           if 	 (cont_icono[i]== icono)
											                           {
											                        	   if (i>7)
											                        	   {
											                              indice_icono_fallo = i;
											                           
											                        	   }
											                        	   
											                        	   
											                           }
											                           
											                           
											                           if 	 ((fase > 1) && cont_icono[i]== memoria_icono && i<8)
											                           {error_icono[i] = true;}
											                        	   
											                           
											                           i++;
											                         }
											                     /*  Util.Cr_c.Iniciar();
											                         mostrar_figura();*/   // cambio 26 06 2013
											                        
	  	    		                                            
	  	    		                                             Util.Cr_n.Iniciar();
										                         no_voz = false;
										                               
										                        nombrar();// hilo poner o no  
										                         
										                        incorrecto();// hilo*/
										                         
										                         
										                         
										                         
										                         if (contador_aciertos == 8) //final fase
										  	    		    	 {
										  	    		    	    
										  	    		    		
										  	    		    		fase_activa = false; 
										  	    		    		
										  	    		    	    
										  	    		    		if (fase < 3)
										  	    		    	    {	
										  	    		    		/*fase++;*/
										  	    		    	   
										  	    		    	    contador_aciertos = 0;
										  	    		    	    }
										  	    		    	    	
										  	    		    		final_fase();
										  	    				 
										  	    		    	 }
	      		               }catch (Exception e) 
	      		               	{}
	  	    		     
	  	    		    	     
	  	    		   Util.Log("   Click en segundo icono: " + icono  + " (" + Util.Cr_p.GetStr() + ") Incorrecto!!!" );
       				   Util.Log_Excel(icono + ";" + Util.Cr_p.GetStr() +";" + "incorrecto" );
       			  	   Util.Log_Excel_nl();
	  	    		    	      
	  	    		    	  int  i =0;   
	  	    		    	  while( i < 16){
	  	    		    		  
	  	    		    		   if (!error_icono[i])
	  	    		    		   {
	  	    		    		   if(acierto_icono[i]== false &&  i < 8){
	  	    		    			 visible_icono(i,imagen("def_haptic_icon_disabled"));
	  	    		    		   }
	  	    		    		   }else{visible_icono(i,imagen("def_error")); }
	  	    		    		   
	  	    		    		   
	  	    		    		  
	   	  	    			       if(cont_icono[i]== icono &&  i > 7 && i<16){
	   	  	    			  
	   	  	    			        visible_icono(i,imagen("def_haptic_icon"));  // hace  visible icono
	   	  	    			        vibraciones_iconos(icono);
	   	  	    			        
	   	  	    			        if (true)/*if (fase>1)*/{
	   	  	    			        visible_icono(i,imagen(cont_icono[i]));
	   	  	    			        }else {visible_icono(i,imagen("deficon"));}
	   	  	    			        } 
	   	  	    			   i++;
	   	  	    			   }
	   	  	    			  
	  	    		    	     
	  	    		    	     
	  	    		           
	  	    		     
	  	    		    	 }
	  	    		     
	  	    		  selecciones = 0;
	  	    	      memoria_icono = "";
	  	    		    
	  	    		      
	  	    	      }else{  selecciones = 1 ;
                         memoria_icono = icono; 
                        /* vibraciones_iconos(icono);//cambio de primera selecci�n/*/
                         int i =0;
        		    	 
   	    	          while( i < 16){
   	    	        	 
   	    	           if(!(cont_icono[i].equals(icono)) && i<8)
   	    	           {visible_icono(i,imagen("def_haptic_icon_disabled"));
   	    	        		   
   	    	           }
   	    	        	  
   	    			   if(cont_icono[i]== icono && i<8){
   	    			   visible_icono(i,imagen("def_haptic_icon_y"));  // hacevisible icono
   	    			   vibraciones_iconos(icono);
   	    			   } 
   	    			   
   	    			   
   	    			   i++;
   	    			}
                         
                         
	  	    	      }
	  	    	
	  	    	    
	  	    	}else{ if (acierto_icono[k])
	  	    	        {
	  	    		      selecciones= 1;
	  	    	                          }}// cambio de paso cuando ha seleccionado icono acertado en segunda seleccion
	  	    	 
	    	 
			
		}
		
		
		/*
		 SELECCI�N DE ICONO SOBRE LA PANTALLA COMPLETA
		 */
	
		public void seleccionar_icono(MotionEvent event){
			
			/*if (icon.Name.equals("facebook"))*/
        	if ((event.getX() < 175)  && (event.getY() < 400) && (event.getY() > 150) && entrada[0])
        	/*	if ((pixelX < 200)  && (pixelY < 300) && entrada_internet)*/
        	if (!error_icono[0])     
        	{
        		
        		 tipo_seleccion = true;
        		 seleccion_tb(0);
        		 
        		 if (false) /*(fase<2)*/{
        		 if (!acierto_icono[0]){
        		 if (!(memoria_icono == cont_icono[0])){
        		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
          	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
        		 }}
		        }else{ if (!error_icono[0] || fase <2 ){ 
		        	 if (!acierto_icono[0]){
	        		 if (!(memoria_icono == cont_icono[0])){
	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
	              	     
	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
	              	     dibujo.setImageResource(imagen(cont_icono[0])); }
		        	
		        } else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
         	     dibujo.setImageResource(imagen("def_error")); }}
        	         /*try{	 
        	    		 launcher.stop();
        	    		 mediaplayer.start();
        	    		 launcher.play(50);
        	    		
		        		}catch (Exception e) 
		           		{} */
        		    
          	     
          	     
          	        
        		     icono = cont_icono[0];
        		     
        	    
        	    	 
        	    
      				 mensaje_tb = true;
        	    	 
      				 entrada[0]= false;
      				 
        	     
        	     } else { launcher.stop();
        	              launcher.play(30);
        	              entrada[0]= false;
        	              icono = "error";
        	     }
        		
        		
        		 
        	 if    (!((event.getX() < 175)  && (event.getY() < 400) && (event.getY() > 150)) )
        	/*	if(!((pixelX < 200)  && (pixelY < 300)))*/
        	 {
        		
        		 if (false) /*(fase<2)*/{
        		 if (!acierto_icono[0]){
        		 if ( !(memoria_icono  == cont_icono[0])){	 
        	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
       	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
        		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
          	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
          	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
            	      dibujo.setImageResource(R.drawable.def_haptic_icon);
          	    	  
          	      }
        		 }else{if (!error_icono[0] || fase < 2){
        			 if (!acierto_icono[0]){
            		 if ( !(memoria_icono  == cont_icono[0])){	 
                   	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
                  	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                   		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
                     	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                     	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
                       	      dibujo.setImageResource(imagen(cont_icono[0]));
                     	    	  
                     	      }
                   		 	 
        		 }else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView1);
          	     dibujo.setImageResource(imagen("def_error")); }}
        		 
        		
        		 
        		    	 entrada[0] = true; 
        		    	 
        	 }
        			
          /*  if (icon.Name.equals("twitter"))*/
        	
        	if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() < 400) && (event.getY() > 150) && entrada[1] )
        	/*	if ((pixelX> 200)  && (pixelX <400) && (pixelY< 300) && entrada_facebook)*/
        		
        		if (!error_icono[1])
        	     {
        		 
        		 tipo_seleccion = true;
        		 seleccion_tb(1);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[1]){
            		 if (!(memoria_icono == cont_icono[1])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
              	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
            		 }}
    		        }else{if (!error_icono[1] || fase <2 ){  
    		        	 if (!acierto_icono[1]){
    	        		 if (!(memoria_icono == cont_icono[1])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	              	     
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
    	              	     dibujo.setImageResource(imagen(cont_icono[1])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
            	     dibujo.setImageResource(imagen("def_error")); }}
        		   
        	    	/*try{launcher.stop();
        	    	    mediaplayer.start();
        	    		 launcher.play(30);
        	    		
		        		
		        		}catch (Exception e) 
		           		{}*/
        		 
        	    	 icono = cont_icono[1];
        	    	 
        	    	 
        	    	 entrada[1] = false;
	 	        	    } else { launcher.stop();
      	               launcher.play(30);
      	               entrada[1]= false;
  	                   icono = "error";
	 	        	    	 
	 	        	    }
        	
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() < 400) && (event.getY() > 150)) )
        	/*	if (!((pixelX> 200)  && (pixelX <400) && (pixelY< 300)))*/
        	 {  
        		 
        		 if (false) /*(fase<2)*/{
        		 if (!acierto_icono[1]){
        		 if ( !(memoria_icono  == cont_icono[1])){	 
        	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
       	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
        		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
          	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
          	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
            	      dibujo.setImageResource(R.drawable.def_haptic_icon);
          	    	  
          	      }
        		 }else{if (!error_icono[1] || fase < 2){
        			 if (!acierto_icono[1]){
            		 if ( !(memoria_icono  == cont_icono[1])){	 
                   	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
                  	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                   		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
                     	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                     	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
                       	      dibujo.setImageResource(imagen(cont_icono[1]));
                     	    	  
                     	      }
                   			 
        		 }else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView2);
          	     dibujo.setImageResource(imagen("def_error")); }}
        		 
        		 
        	 
        	 
		    	 entrada[1] = true; }
        	 
        	 
       	/* if (icon.Name.equals("linkedin")) */
        	if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() < 400) && (event.getY() > 150) && entrada[2])
       /* 	if ((pixelX > 400)  && (pixelX <600) && (pixelY< 300) && entrada_twitter)*/
    	     if (!error_icono[2]) 
        	{
        		tipo_seleccion = true;
        		seleccion_tb(2);
        		 if (false) /*(fase<2)*/{
           		 if (!acierto_icono[2]){
           		 if (!(memoria_icono == cont_icono[2])){
           		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
             	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
           		 }}
   		        }else{if (!error_icono[2] || fase <2 ){  
   		        	 if (!acierto_icono[2]){
   	        		 if (!(memoria_icono == cont_icono[2])){
   	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
   	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
   	                
   	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
   	              	     dibujo.setImageResource(imagen(cont_icono[2])); }
   		        	
   		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
       	     dibujo.setImageResource(imagen("def_error")); }}
        		/*try{launcher.stop();
        		    mediaplayer.start(); 
    	    		launcher.play(91);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[2];
    	    	
    	    
    	    	 entrada[2] = false;
        	 
    	     }else { launcher.stop();
             launcher.play(30);
             entrada[2]= false;
             icono = "error";}
        	
        	if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() < 400) &&(event.getY() > 150)) )
        	/*	 if (!((pixelX > 400)  && (pixelX <600) && (pixelY< 300)))*/
        	{   
        	
        		
        		if (false) /*(fase<2)*/{
       		 if (!acierto_icono[2]){
       		 if ( !(memoria_icono  == cont_icono[2])){	 
       	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
      	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
       		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
         	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
         	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
           	      dibujo.setImageResource(R.drawable.def_haptic_icon);
         	    	  
         	      }
       		 }else{ if (!error_icono[2] || fase < 2){
       			  if (!acierto_icono[2]){
           		 if ( !(memoria_icono  == cont_icono[2])){	 
                  	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
                 	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                  		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
                    	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                    	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
                      	      dibujo.setImageResource(imagen(cont_icono[2]));
                    	    	  
                    	      }
       		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView3);
       	     dibujo.setImageResource(imagen("def_error")); }}
       		 
        	
        	
		    	 entrada[2] = true; }
        	
        	 
    	    	 
      /*  if (icon.Name.equals("wasapp")) */
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() < 400) && (event.getY() > 150) && entrada[3])
		    		
             if (!error_icono[3])		 
        	 {
        		 tipo_seleccion = true;
        		 seleccion_tb(3);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[3]){
            		 if (!(memoria_icono == cont_icono[3])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
            		 }}
    		        }else{if (!error_icono[3] || fase <2 ){   
    		        	 if (!acierto_icono[3]){
    	        		 if (!(memoria_icono == cont_icono[3])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	              	   
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
    	              	     dibujo.setImageResource(imagen(cont_icono[3])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
        		/* try{launcher.stop();
        		      mediaplayer.start();
    	    		 launcher.play(40);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[3];
    	    	 
    	    	
    	    	
    	    	 entrada[3] = false;
    	    	 
 	        	    }  	     else { launcher.stop();
  	              launcher.play(30);
  	            entrada[3]= false;
  	             icono = "error";}
        	 
        		
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() < 400) && (event.getY() > 150)) )
        	 {
        		  
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[3]){
            		 if ( !(memoria_icono  == cont_icono[3])){	 
            	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
           	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
            		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
              	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
              	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
                	      dibujo.setImageResource(R.drawable.def_haptic_icon);
              	    	  
              	      }
            		 }else{if (!error_icono[3] || fase < 2){
            			 if (!acierto_icono[3]){
                		 if ( !(memoria_icono  == cont_icono[3])){	 
                       	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
                      	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                       		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
                         	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                         	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
                           	      dibujo.setImageResource(imagen(cont_icono[3]));
                         	    	  
                         	      }
            			 
            		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView4);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
            		 
        		 
        		 entrada[3] = true; }
        	 
        	 /*if (icon.Name.equals("phone"))*/
        	 if ((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 400 ) && (event.getY() < 700) && entrada[4] )
			
             if (!error_icono[4]) 		 
    	     {
        		 tipo_seleccion = true;
        		 seleccion_tb(4);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[4]){
            		 if (!(memoria_icono == cont_icono[4])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
              	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
            		 }}
    		        }else{ if (!error_icono[4] || fase <2 ){  
    		        	if (!acierto_icono[4]){
    	        		 if (!(memoria_icono == cont_icono[4])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
    	              	     dibujo.setImageResource(imagen(cont_icono[4])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
        		/* try{launcher.stop();
        			 launcher.play(35);
        			 mediaplayer.start();
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[4];
    	    	
    	    	
    	    	 entrada[4] = false;
    	    
 	        	    }else { launcher.stop();
  	              launcher.play(30);
  	            entrada[4]= false;
  	             icono = "error";}
        	 
        	 if    (!((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 400 ) && (event.getY() < 700) ) )
        	 {  if (false) /*(fase<2)*/{
        		 if (!acierto_icono[4]){
        		 if ( !(memoria_icono  == cont_icono[4])){	 
        	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
       	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
        		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
          	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
          	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
            	      dibujo.setImageResource(R.drawable.def_haptic_icon);
          	    	  
          	      }
        		 }else{if (!error_icono[4] || fase <2 ){  
        			 if (!acierto_icono[4]){
            		 if ( !(memoria_icono  == cont_icono[4])){	 
                   	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
                  	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                   		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
                     	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                     	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
                       	      dibujo.setImageResource(imagen(cont_icono[4]));
                     	    	  
                     	      }
                   		 
        		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView5);
	       	     dibujo.setImageResource(imagen("def_error")); }}
        		 
        	 
        		 entrada[4] = true; }
        	 
        	/* if (icon.Name.equals("sms"))*/
        	 if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 400 ) && (event.getY() < 700) && entrada[5] )
			
        		  if (!error_icono[5])
    	     {
        		 tipo_seleccion = true;
        		 seleccion_tb(5);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[5]){
            		 if (!(memoria_icono == cont_icono[5])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
              	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
            		 }}
    		        }else{ if (!error_icono[5] || fase <2 ){  
    		        	if (!acierto_icono[5]){
    	        		 if (!(memoria_icono == cont_icono[5])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
    	              	     dibujo.setImageResource(imagen(cont_icono[5])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
        		 
    	    	/*try{launcher.stop();
    	    	    mediaplayer.start();
    	    		launcher.play(77);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[5];
    	    	
    	    	
    	    	 entrada[5] = false;
    	    
 	        	    }else { launcher.stop();
  	              launcher.play(30);
  	            entrada[5]= false;
  	             icono = "error";}
        	 
        	 
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 400 ) && (event.getY() < 700))) 
        	 {	 entrada[5] = true; 
        	 
        	 if (false) /*(fase<2)*/{
        		 if (!acierto_icono[5]){
        		 if ( !(memoria_icono  == cont_icono[5])){	 
        	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
       	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
        		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
          	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
          	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
            	      dibujo.setImageResource(R.drawable.def_haptic_icon);
          	    	  
          	      }
        		 }else{if (!error_icono[5] || fase <2 ){
        			 if (!acierto_icono[5]){
            		 if ( !(memoria_icono  == cont_icono[5])){	 
                   	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
                  	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                   		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
                     	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                     	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
                       	      dibujo.setImageResource(imagen(cont_icono[5]));
                     	    	  
                     	      }
                   		 
        		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView6);
	       	     dibujo.setImageResource(imagen("def_error")); }}
        		 
        	 
        	 }
        	 
        	 
        	 /* if (icon.Name.equals("email"))*/
        	 if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 400 ) && (event.getY() < 700)  && entrada[6])
				  
        	 if (!error_icono[6])	 
    	     {
        		 tipo_seleccion = true;
        		 seleccion_tb(6);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[6]){
            		 if (!(memoria_icono == cont_icono[6])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
              	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
            		 }}
    		        }else{ if (!error_icono[6] || fase <2 ){  
    		        	if (!acierto_icono[6]){
    	        		 if (!(memoria_icono == cont_icono[6])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
    	              	     dibujo.setImageResource(imagen(cont_icono[6])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
        		
    	    	/* try{launcher.stop();
    	    	 mediaplayer.start();
    	    		 launcher.play(67);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[6];
    	    	
    	    	
    	    	 entrada[6] = false;
    	    
 	        	    } else { launcher.stop();
  	              launcher.play(30);
  	            entrada[6]= false;
  	             icono = "error";}
        	 
        	 if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 400 ) && (event.getY() < 700)) )
        	 {  
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[6]){
            		 if ( !(memoria_icono  == cont_icono[6])){	 
            	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
           	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
            		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
              	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
              	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
                	      dibujo.setImageResource(R.drawable.def_haptic_icon);
              	    	  
              	      }
            		 }else{if (!error_icono[6] || fase <2 ){  
            			 if (!acierto_icono[6]){
                		 if ( !(memoria_icono  == cont_icono[6])){	 
                       	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
                      	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                       		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
                         	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                         	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
                           	      dibujo.setImageResource(imagen(cont_icono[6]));
                         	    	  
                         	      }
                       		 
            		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView7);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
            		 
        	 
        	 
        		 entrada[6] = true; }
        	 
        	 /* if (icon.Name.equals("line"))*/
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 400 ) && (event.getY() < 700)  && entrada[7])
				  
        		 if (!error_icono[7])
    	     {
        		 tipo_seleccion = true;
        		 seleccion_tb(7);
        		 if (false) /*(fase<2)*/{
            		 if (!acierto_icono[7]){
            		 if (!(memoria_icono == cont_icono[7])){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
              	     dibujo.setImageResource(R.drawable.def_haptic_icon_disabled_y);
            		 }}
    		        }else{ if (!error_icono[7] || fase <2 ){  
    		        	if (!acierto_icono[7]){
    	        		 if (!(memoria_icono == cont_icono[7])){
    	            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
    	              	     dibujo.setImageResource(imagen("def_haptic_icon_disabled_y"));
    	            		 }}else{ ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
    	              	     dibujo.setImageResource(imagen(cont_icono[7])); }
    		        	
    		        }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
    	       	     dibujo.setImageResource(imagen("def_error")); }}
        		/* try{launcher.stop();
        		    mediaplayer.start();
    	    		 launcher.play(76);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[7];
    	    	 
    	    	
    	    	 entrada[7] = false;
    	    
 	        	    }else { launcher.stop();
  	              launcher.play(30);
  	            entrada[7]= false;
  	             icono = "error";}
        	 
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 400 ) && (event.getY() < 700)) )
		    	 
        	 {	 if (false) /*(fase<2)*/{
        		 if (!acierto_icono[7]){
        		 if ( !(memoria_icono  == cont_icono[7])){	 
        	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
       	      dibujo.setImageResource(R.drawable.def_haptic_icon_disabled);}
        		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
          	      dibujo.setImageResource(R.drawable.def_haptic_icon);}}else{
          	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
            	      dibujo.setImageResource(R.drawable.def_haptic_icon);
          	    	  
          	      }
        		 }else{if (!error_icono[7] || fase <2 ){  
        			 if (!acierto_icono[7]){
            		 if ( !(memoria_icono  == cont_icono[7])){	 
                   	  ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
                  	      dibujo.setImageResource(imagen("def_haptic_icon_disabled"));}
                   		 else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
                     	      dibujo.setImageResource(imagen("def_haptic_icon"));}}else{
                     	    	ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
                       	      dibujo.setImageResource(imagen(cont_icono[7]));
                     	    	  
                     	      }
        			 
        		 }else{ImageView dibujo =  (ImageView) findViewById(R.id.imageView8);
	       	     dibujo.setImageResource(imagen("def_error")); }}
        		 
        	 
        	 	entrada[7]= true; }
        	 
        	 
        	 //*****************************************************************
        	 
        	 
        	 
        	 /*if (icon.Name.equals("googleplus"))*/
        		if ((event.getX() < 175)   && (event.getY() > 700) && (event.getY() < 1000) && entrada[8])
        	     {
        			tipo_seleccion = false;
        			seleccion_tb(8);
        			 if (fase<2){
                 		if (!acierto_icono[8]){
                 			ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
                      	   dibujo.setImageResource(R.drawable.def_int_y);}
                 		}else{
                 			if (!acierto_icono[8]){
                 			ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
         				dibujo.setImageResource(imagen(cont_icono_y[8]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
         				dibujo.setImageResource(imagen("deficon"));  }
                 		}
        			/*try{
        	    		 launcher.stop();
        	    		 mediaplayer.start();
        	    		 launcher.play(50);
        	    		
		        		
		        		}catch (Exception e) 
		           		{}*/
        			 
        	    	 icono = cont_icono[8];
        	    	
        	    	
        	    	 entrada[8] = false;
        	    	
	 	        	    }
        		
        		
        		 
        		   if    (!((event.getX() < 175)  && (event.getY() > 700) && (event.getY() < 1000)) )
        		   { 
        			   if (fase<2){
            			   if (!acierto_icono[8]){
                      		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
                         	   dibujo.setImageResource(R.drawable.def_int);}else{
                      		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
                          	   dibujo.setImageResource(imagen(cont_icono[8]));
                         	   }
                         	   
                      		   
                      	   }else{ if(!acierto_icono[8]){
                      		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
                      	       dibujo.setImageResource(imagen(cont_icono[8]));}else {
                      	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView9);
            				                            dibujo.setImageResource(imagen("deficon"));}
                      	   }
            	      
            	      
        		    	 entrada[8] = true; }
        		    
        			
          /*  if (icon.Name.equals("wifi"))*/
        	
        	if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 700) && (event.getY() < 1000) && entrada[9])
        	     {
        		tipo_seleccion = false;
        		seleccion_tb(9);
        		 if (fase<2){
             		if (!acierto_icono[9]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
                  	   dibujo.setImageResource(R.drawable.def_int_y);}
             		}else{
             			if (!acierto_icono[9]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
     				dibujo.setImageResource(imagen(cont_icono_y[9]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
     				dibujo.setImageResource(imagen("deficon"));  }
             		}
        		
        		/* try{  launcher.stop();
        		      mediaplayer.start();
        	    	  launcher.play(30);
		        		
		        		}catch (Exception e) 
		           		{}*/
        		 	
        	    	 icono = cont_icono[9];
        	    	 
        	    	 
        	    	 entrada[9] = false;
	 	        	    }
        	
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 700) && (event.getY() < 1000)) )
		    	 {entrada[9] = true;
		    	 
		    	 if (fase<2){
      			   if (!acierto_icono[9]){
                		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
                   	   dibujo.setImageResource(R.drawable.def_int);}else{
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
                    	   dibujo.setImageResource(imagen(cont_icono[9]));
                   	   }
                   	   
                		   
                	   }else{ if(!acierto_icono[9]){
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
                	       dibujo.setImageResource(imagen(cont_icono[9]));}else {
                	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView10);
      				                            dibujo.setImageResource(imagen("deficon"));}
                	   }
          	      
		    	 }
        	 
       	/* if (icon.Name.equals("update")) */
        	if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 700) && (event.getY() < 1000) && entrada[10])
    		        
    	     {  tipo_seleccion = false;
        		seleccion_tb(10);
        		 if (fase<2){
             		if (!acierto_icono[10]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
                  	   dibujo.setImageResource(R.drawable.def_int_y);}
             		}else{
             			if (!acierto_icono[10]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
     				dibujo.setImageResource(imagen(cont_icono_y[10]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
     				dibujo.setImageResource(imagen("deficon"));  }
             		}
        		/*try{launcher.stop();
        	    	mediaplayer.start();
    	    	    launcher.play(91);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[10];
    	    	
    	    	
    	    	 entrada[10] = false;
        	 
    	     }
        	
        	 if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 700) && (event.getY() < 1000)) )
        	 {   
        		 if (fase<2){
      			   if (!acierto_icono[10]){
                		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
                   	   dibujo.setImageResource(R.drawable.def_int);}else{
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
                    	   dibujo.setImageResource(imagen(cont_icono[10]));
                   	   }
                   	   
                		   
                	   }else{ if(!acierto_icono[10]){
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
                	       dibujo.setImageResource(imagen(cont_icono[10]));}else {
                	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView11);
      				                            dibujo.setImageResource(imagen("deficon"));}
                	   }
        	
      	         
      	         
        		 entrada[10] = true; }
        	
        	 
    	    	 
      /*  if (icon.Name.equals("talk")) */
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 700) && (event.getY() < 1000) && entrada[11])
		    		
    	     {
        		 tipo_seleccion = false;
        		 seleccion_tb(11);
        		 if (fase<2){
             		if (!acierto_icono[11]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
                  	   dibujo.setImageResource(R.drawable.def_int_y);}
             		}else{
             			if (!acierto_icono[11]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
     				dibujo.setImageResource(imagen(cont_icono_y[11]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
     				dibujo.setImageResource(imagen("deficon"));  }
             		}
        		
        		/* try{launcher.stop();
        		     mediaplayer.start();
    	    		 launcher.play(40);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[11];
    	   
    	    	 
    	    	 entrada[11] = false;
    	    	 
 	        	    }  	     
        		
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 700) && (event.getY() < 1000)) )
        	 { 
        		 if (fase<2){
        			   if (!acierto_icono[11]){
                  		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
                     	   dibujo.setImageResource(R.drawable.def_int);}else{
                  		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
                      	   dibujo.setImageResource(imagen(cont_icono[11]));
                     	   }
                     	   
                  		   
                  	   }else{ if(!acierto_icono[11]){
                  		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
                  	       dibujo.setImageResource(imagen(cont_icono[11]));}else {
                  	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView12);
        				                            dibujo.setImageResource(imagen("deficon"));}
                  	   }
                	      
        		 entrada[11] = true; }
        	
        	  /*if (icon.Name.equals("bateria"))*/
        	 if ((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 1000 )  && entrada[12])
				  
    	     {	tipo_seleccion = false;
        		seleccion_tb(12);
        		 
        		 if (fase<2){
             		if (!acierto_icono[12]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
                  	   dibujo.setImageResource(R.drawable.def_int_y);}
             		}else{
             			if (!acierto_icono[12]){
             			ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
     				dibujo.setImageResource(imagen(cont_icono_y[12]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
     				dibujo.setImageResource(imagen("deficon"));  }
             		}
        		
    	    	/* try{launcher.stop();
    	    	     mediaplayer.start();
    	    		 launcher.play(22);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[12];
    	    	 
    	    	
    	    	 entrada[12] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 0)  && (event.getX() <175) &&  (event.getY() > 1000 ) ) )
        	 { entrada[12]= true; 
        	 
        	 
        	 if (fase<2){
  			    if (!acierto_icono[12]){
            		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
               	   dibujo.setImageResource(R.drawable.def_int);}else{
            		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
                	   dibujo.setImageResource(imagen(cont_icono[12]));
               	   }
               	   
            		   
            	   }else{ if(!acierto_icono[12]){
            		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
            	       dibujo.setImageResource(imagen(cont_icono[12]));}else {
            	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView13);
  				                            dibujo.setImageResource(imagen("deficon"));}
            	   }
            	      
        	 }
        	 
        	/* if (icon.Name.equals("calendario"))*/
        	 if ((event.getX() > 175)  && (event.getX() <350) &&  (event.getY() > 1000 )  && entrada[13])
				  
    	     {
        		 tipo_seleccion = false;
        		 seleccion_tb(13);
        		 if (fase<2){
              		if (!acierto_icono[13]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
                   	   dibujo.setImageResource(R.drawable.def_int_y);}
              		}else{
              			if (!acierto_icono[13]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
      				dibujo.setImageResource(imagen(cont_icono_y[13]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
      				dibujo.setImageResource(imagen("deficon"));  }
              		}
        		/* try{launcher.stop();
        		     mediaplayer.start();
    	    	 	 launcher.play(53);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[13];
    	    	 
    	    	
    	    	 entrada[13] = false;
    	    
 	        	    }
        	 
        	 
        	 if    (!((event.getX() > 175)  && (event.getX() <350) &&  (event.getY() > 1000 ))) 
        	 {
        		 if (fase<2){
      			   if (!acierto_icono[13]){
                		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
                   	   dibujo.setImageResource(R.drawable.def_int);}else{
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
                    	   dibujo.setImageResource(imagen(cont_icono[13]));
                   	   }
                   	   
                		   
                	   }else{ if(!acierto_icono[13]){
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
                	       dibujo.setImageResource(imagen(cont_icono[13]));}else {
                	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView14);
      				                            dibujo.setImageResource(imagen("deficon"));}
                	   }
                	      
        		 
        		entrada[13] = true;} 
        	 
        	 
        	 /* if (icon.Name.equals("reloj"))*/
        	 if ((event.getX() > 350)  && (event.getX() <525) &&  (event.getY() > 1000 )  && entrada[14])
				  
    	     {
        		 tipo_seleccion = false;
        		 seleccion_tb(14);
        		 if (fase<2){
              		if (!acierto_icono[14]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
                   	   dibujo.setImageResource(R.drawable.def_int_y);}
              		}else{
              			if (!acierto_icono[14]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
      				dibujo.setImageResource(imagen(cont_icono_y[14]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
      				dibujo.setImageResource(imagen("deficon"));  }
              		}
        		 
        		/* try{launcher.stop();
        	     	 mediaplayer.start();
    	    		.play(47);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
        		 
    	    	 icono = cont_icono[14];
    	    	
    	    	
    	    	 entrada[14] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 350)  && (event.getX() <525) &&  (event.getY() > 1000 )) )
        	 { 
        		 if (fase<2){
      			   if (!acierto_icono[14]){
                		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
                   	   dibujo.setImageResource(R.drawable.def_int);}else{
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
                    	   dibujo.setImageResource(imagen(cont_icono[14]));
                   	   }
                   	   
                		   
                	   }else{ if(!acierto_icono[14]){
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
                	       dibujo.setImageResource(imagen(cont_icono[14]));}else {
                	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView15);
      				                            dibujo.setImageResource(imagen("deficon"));}
                	   }
      	         
      	         
      	         
		    	 entrada[14] = true; }
        	 
        	 /* if (icon.Name.equals("instagram"))*/
        	 if ((event.getX() > 525)  && (event.getX() <700) &&  (event.getY() > 1000 )  && entrada[15])
    	     {
        		 tipo_seleccion = false;
        		 seleccion_tb(15);
        		 if (fase<2){
              		if (!acierto_icono[15]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
                   	   dibujo.setImageResource(R.drawable.def_int_y);}
              		}else{
              			if (!acierto_icono[15]){
              			ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
      				dibujo.setImageResource(imagen(cont_icono_y[15]));}else {ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
      				dibujo.setImageResource(imagen("deficon"));  }
              		}
        		 
    	    	 icono = cont_icono[15];
    	    	 
    	    	
    	    	 entrada[15] = false;
    	    
 	        	    }
        		 
        	 
        	 if    (!((event.getX() > 525)  && (event.getX() <700) &&(event.getY() > 1000 )) )
        	 {
        		 
        		 entrada[15] = true; 
		    	
		    	 
		    	 
        		 if (fase<2){
      			   if (!acierto_icono[15]){
                		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
                   	   dibujo.setImageResource(R.drawable.def_int);}else{
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
                    	   dibujo.setImageResource(imagen(cont_icono[15]));
                   	   }
                   	   
                		   
                	   }else{ if(!acierto_icono[15]){
                		   ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
                	       dibujo.setImageResource(imagen(cont_icono[15]));}else {
                	    	                        ImageView dibujo =  (ImageView) findViewById(R.id.imageView16);
      				                            dibujo.setImageResource(imagen("deficon"));}
                	   }
                	      
      	       
        	 }
        	 
        	 
        	 if (event.getY()<150)
        	 {
        		 icono = " ";
        	 }
        	  
        	 return;
		}
        	 
		
		/*
		 MOSTRAR MENSAJES
		 */
		
		 public void mensaje_pantalla( String texto){
		  		
			 if (Util.MostrarMensajes)
			 {
		   	  Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
			 }  
		 		
		 	}
		 
		 
		 /*
		  ACCIONES SOBRE EL OBJETO SELECCIONADO SOBRE LA PANTALLA COMPLETA
		  */
		 
		 public void seleccion_tb(int indice)
		 
		 {  try{
			 estado_tb = 1;
			Util.Cr_h.Iniciar();
			 mensaje_tb = true;
			 
		/*if ( !(icono == cont_icono[indice])){*/
				 if (acierto_icono[indice]){
					 
					 if (indice <8){   if (Util.InfoAuditiva){
					                   Util.PlaySound(cont_icono[indice]); 
					 }
						
						 
					 } else {
						     if (fase<2){if (Util.InfoAuditiva){
						             	 Util.PlaySound(cont_icono[indice]); }
						     }else{   if (Util.InfoAuditiva){
						              Util.PlaySound("golpe_b");}
						     }
				           }
				 }else {if (indice <8){if (Util.InfoAuditiva){
					                    Util.PlaySound("golpe");}
					 
				 } else {if (fase<2)  { if (Util.InfoAuditiva){
					                    Util.PlaySound("golpe_b");}
					  
				                }else{
					     Util.Cr_n.Iniciar();
					     
				         if (Util.InfoAuditiva){
					     Util.PlaySound(cont_icono[indice]);}
				 }
			           }}
				 
				 
			if (Util.VibrarOnClick)	 
			{
			launcher.stop();	 
    		launcher.play(3);
			}
	/*	} */
			 
			 hilador();
			 
			 
		 }catch (Exception e) 
    		{Toast.makeText(this, "faLLA SELECCION",
                    Toast.LENGTH_SHORT).show();}
			
			 
		 }
			
		
		 /*
		  SELECCI�N DE VIBRACI�N 
		  */
		 
		 public void vibraciones_iconos(String haptico)
		 {
			 
			
			 
			int codigo_vibra =3 ;
			String sonido = "";
			
		
	  if (Util.DiferIconosHapt){
			 
			 if (haptico == "facebook")
			 { try{
				 device.playIVTEffect(ivtBuffer1,facebook.Palmas);
             }
          catch(Exception e){}
			   }
			     
			 if (haptico== "twitter")
			 { try{
				 device.playIVTEffect(ivtBuffer2,twitter.Timeline);
             }
          catch(Exception e){}
			
			     }
				 
			 if (haptico == "linkedin")
			 { try{
				 device.playIVTEffect(ivtBuffer3,linkedin.Pitido);
             }
          catch(Exception e){}
			     }
			    
				 
			 if (haptico == "wasapp")
			 { try{
				 device.playIVTEffect(ivtBuffer4,guasapp.Rafaga);
             }
          catch(Exception e){}
			
			 }
			 if (haptico == "phone")
			 { try{
				 device.playIVTEffect(ivtBuffer5,phone.Phone);
             }
          catch(Exception e){}
			}
			 if (haptico == "sms")
			 { try{
				 device.playIVTEffect(ivtBuffer6,esemese.Palmas);
             }
          catch(Exception e){}
			 }
			 if (haptico == "email"){
				 try{
					 device.playIVTEffect(ivtBuffer7,email.Alarma);
                 }
              catch(Exception e){}
		       	 
		       	 }
			 if (haptico == "line")
				 try{
					 device.playIVTEffect(ivtBuffer8,line.Morse);
                 }
              catch(Exception e){}
			 if (haptico == "googleplus")
				 try{
					 device.playIVTEffect(ivtBuffer9,googleplus.Tambor);
                 }
              catch(Exception e){}
			 if (haptico == "wifi")
				 try{
					 device.playIVTEffect(ivtBuffer10,wifi.Latido);
                 }
              catch(Exception e){}
			 if (haptico == "update")
				 try{
					 device.playIVTEffect(ivtBuffer11,update.Brian);
                 }
              catch(Exception e){}
			 if (haptico == "talk")
				 try{
					 device.playIVTEffect(ivtBuffer12,tolk.Puerta);
                 }
              catch(Exception e){}
			 if (haptico == "bateria")
				 try{
					 device.playIVTEffect(ivtBuffer13,bateria.Decrescendo);
                 }
              catch(Exception e){}
			 if (haptico == "calendario")
				 try{
					 device.playIVTEffect(ivtBuffer14,calendario.Balon);
                 }
              catch(Exception e){}
			 if (haptico == "reloj")
				 try{
					 device.playIVTEffect(ivtBuffer15,reloj.Lascuatro);
                 }
              catch(Exception e){}
			 if (haptico == "camara")
				 try{
					 device.playIVTEffect(ivtBuffer16,camara.Crescendo);
                 }
              catch(Exception e){}
			 
	  }else{ 
			
			 
				 
				 try{launcher.stop(); 
	          	  /*mediaplayer.start();*/
				 launcher.play(codigo_vibra); 
    		
    	   	}catch (Exception e) 
       		{Toast.makeText(this, "faLLA VIBRACION",
                    Toast.LENGTH_SHORT).show();}
	  }
		 }
		
	
	/*
	 CONTROL SOBRE LOS BOTONES EXTERIORES DEL DISPOSITIVO:
	 
	     - VOLUMENES: UP - DOWN
	     - MEN�
	     - BACK
	     
	 */
		 
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
	 
			switch(keyCode){
				case KeyEvent.KEYCODE_CAMERA:
					Toast.makeText(this, "Obturador presionado",
	                                                        Toast.LENGTH_SHORT).show();
					return true;
				case KeyEvent.KEYCODE_VOLUME_UP:
				/*	Toast.makeText(this, "Boton de Volumen Up presionado",
	                                                        Toast.LENGTH_SHORT).show();*/
					if (fase<3){
					loadfase( fase + 1);
					fase++;
					}
					
					return true;
				case KeyEvent.KEYCODE_VOLUME_DOWN:
					/*Toast.makeText(this, "Boton de Volumen Down presionado",
	                                                        Toast.LENGTH_SHORT).show();*/
					if (fase==0){
					finish();}else{ fase--;
						           loadfase (fase);
					               
					}
					
					return true;
					
				case KeyEvent.KEYCODE_BACK:
					/*Toast.makeText(this, "Boton de Volumen Down presionado",
	                                                        Toast.LENGTH_SHORT).show();*/
					
					finish();
					
					
					return true;
					
			}
			return super.onKeyDown(keyCode, event);
		}
	 
	 
	 
	 /*
	  *************************************************************************************************
	                                                 HILOS
	  *************************************************************************************************
	  */
	 
	 /*
	  EMULACION TALKBACK
	  */
	 public void hilador(){
		  
		 Thread cronometro = new Thread(){
		        public void run(){
		                try{
		                        while(Util.Cr_h.Update()/1000 < 5){
		                        Thread.sleep(50);
		                        }
		                        
		                        if (estado_tb ==1 && mensaje_tb)
		                        {
		                        	handler.post(proceso);
		                        	/*Util.Cr.Iniciar();*/
		             				mensaje_tb = false;
		                        }
		                }
		                catch(Exception e){
		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
		                        b.show();
		                }
		        }
		    };
		   cronometro.start(); }
	 
	 Handler handler = new Handler();
	   
	    Runnable proceso = new Runnable(){
	                public void run() {
	                        try{
	                               Util.PlaySound("pulsar");
	                           }
	                        catch(Exception e){                    
	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	                            b.show();     }
	                }};

	           
	                public void adpulsacioncontinua(){
	          		  
	           		 Thread cronometro = new Thread(){
	           		        public void run(){
	           		                try{
	           		                        while(Util.Cr.Update()/100 < 2.7){
	           		                        Thread.sleep(50);
	           		                        }
	           		                        
	           		                        if (estado_tb ==4 )
	           		                        {
	           		                        	handler_ad.post(proceso_ad);
	           		                        	/*Util.Cr.Iniciar();*/
	           		             				mensaje_tb = false;
	           		                        }
	           		                }
	           		                catch(Exception e){
	           		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           		                        b.show();
	           		                }
	           		        }
	           		    };
	           		   cronometro.start(); }
	           	 
	           	 Handler handler_ad = new Handler();
	           	   
	           	    Runnable proceso_ad = new Runnable(){
	           	                public void run() {
	           	                        try{   
	           	                               Util.PlaySound("pulsacion_continua");
	           	                               estado_tb =1;
	           	                              
	           	                           }
	           	                        catch(Exception e){                    
	           	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           	                            b.show();     }
	           	                }};

	                
	     /*
	      TEMPORIZADOR DE ESQUINA INFERIOR IZQUIERDA      	                
	      */
	     public void temporizador(){
	          		  
	           		 Thread cronometro = new Thread(){
	           		        public void run(){
	           		                try{    Util.Cr_p.Iniciar();
	           		                        while(fase_activa){
	           		                        Thread.sleep(500);
	           		                      
	           		                        	handler_tiempo.post(proceso_tiempo);
	           		                        	
	           		                        }
	           		                }
	           		                catch(Exception e){
	           		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           		                        b.show();
	           		                }
	           		        }
	           		    };
	           		   cronometro.start(); }
	           	 
	           	 Handler handler_tiempo = new Handler();
	           	   
	           	    Runnable proceso_tiempo = new Runnable(){
	           	                public void run() {
	           	                        try{ 
	           	                        	TextView tiempo =  (TextView) findViewById(R.id.textView2);
	           	                        	if (Util.MostrarTiempo){
	           	                        	  Util.Cr_p.Update();
	           	                              tiempo.setText(Util.Cr_p.GetStr());
	           	                           }else{ tiempo.setTextColor(0); }
	           	                        }
	           	                        catch(Exception e){                    
	           	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           	                            b.show();     }
	           	                }};

	               
	           	                
	           	             public void seleccion(){
	           	    		  
	           	     		 Thread cronometro = new Thread(){
	           	     		        public void run(){
	           	     		                try{
	           	     		                seleccionar_icono(evento);
	           	     		                        
	           	     		                        	handler_seleccion.post(proceso_seleccion);
	           	     		                        	/*Util.Cr.Iniciar();*/
	           	     		             				mensaje_tb = false;
	           	     		             				estado_tb= 1;
	           	     		                        
	           	     		                }
	           	     		                catch(Exception e){
	           	     		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           	     		                        b.show();
	           	     		                }
	           	     		        }
	           	     		    };
	           	     		   cronometro.start(); }
	           	     	 
	           	     	 Handler handler_seleccion = new Handler();
	           	     	   
	           	     	    Runnable proceso_seleccion = new Runnable(){
	           	     	                public void run() {
	           	     	                        try{
                                                       

	           	     	                           }
	           	     	                        catch(Exception e){                    
	           	     	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	           	     	                            b.show();     }
	           	     	                }};

	           	     	   /*
	           	     	    COORDINACI�N DE SONIDO CORRECTO
	           	     	    */
	           	     	                
	           	     	                
	           	     	            public void correcto(){
	      	           	    		  
	       	           	     		 Thread cronometro = new Thread(){
	       	           	     		        public void run(){
	       	           	     		                try{
	       	           	     		                           while(Util.Cr_n.Update()/1000 < 1){
		     		                                                Thread.sleep(50);}
	       	           	     		                        
	       	           	     		                        	handler_seleccion.post(proceso_correcto);
	       	           	     		                        	
	       	           	     		                        
	       	           	     		                }
	       	           	     		                catch(Exception e){
	       	           	     		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	       	           	     		                        b.show();
	       	           	     		                }
	       	           	     		        }
	       	           	     		    };
	       	           	     		   cronometro.start(); }
	       	           	     	 
	       	           	     	 Handler handler_correcto = new Handler();
	       	           	     	   
	       	           	     	    Runnable proceso_correcto = new Runnable(){
	       	           	     	                public void run() {
	       	           	     	                        try{
	       	           	     	                        	      
	                                                              Util.PlaySound("correcto");
	                                                              no_seleccion = true;
	                                                              Util.Cr_es.Iniciar();
	                                                              espera(); //hilo
	                                                              
	                                                              
	                                                               correcto = true;
	                                                               Util.Cr_c.Iniciar();
	                                                               correcto =true;
	                                                              /* mostrar_figura();*/ 
	                                                             
	                                                             
	       	           	     	                        	   

	       	           	     	                           }
	       	           	     	                        catch(Exception e){                    
	       	           	     	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	       	           	     	                            b.show();     }
	       	           	     	                }};
	                
	       	           	     	                
	       	           	     	                
	       	           	     	                /*
	       	           	     	                 COORDINACI�N DE SONIDO INCORRECTO
	       	           	     	                 */
	       	           	     	                
	       	           	     	         public void incorrecto(){
	   	      	           	    		  
	    	       	           	     		 Thread cronometro = new Thread(){
	    	       	           	     		        public void run(){
	    	       	           	     		                try{
	    	       	           	     		                           while(Util.Cr_n.Update()/1000 < 1){
	    		     		                                           Thread.sleep(50);
	    	       	           	     		                    }
	    	       	           	     		                        
	    	       	           	     		                        	handler_seleccion.post(proceso_incorrecto);
	    	       	           	     		                        	
	    	       	           	     		                        
	    	       	           	     		                }
	    	       	           	     		                catch(Exception e){
	    	       	           	     		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    	       	           	     		                        b.show();
	    	       	           	     		                }
	    	       	           	     		        }
	    	       	           	     		    };
	    	       	           	     		   cronometro.start(); }
	    	       	           	     	 
	    	       	           	     	 Handler handler_incorrecto = new Handler();
	    	       	           	     	   
	    	       	           	     	    Runnable proceso_incorrecto = new Runnable(){
	    	       	           	     	                public void run() {
	    	       	           	     	                        try{
	    	       	           	     	                        	     
	    	                                                              Util.PlaySound("incorrecto");
	    	                                                              
	    	                                                              no_seleccion = true;
	    	                                                              Util.Cr_es.Iniciar();
	    	                                                              espera(); //hilo
	    	                                                              
	    	                                                              if (fase<2){
	    	                                                              visible_icono(indice_icono,imagen("def_haptic_icon_disabled")); 
	    	                                                                int i  =8;
	    	                                                                while ( i<16)
	    	                                                                {    
	    	                                                                	if (icono == cont_icono[i])
	    	                                                                	{
	    	                                                                	 visible_icono(i,imagen("def_int"));}
	    	                                                                	i++;
	    	                                                                }
	    	                                                               
	    	                                                                	// aparicion
	    	                                                              }else { visible_icono(indice_icono,imagen("def_error"));  // aparicion
		    	                                                             }
	    	                                                         
	    	                                                              
	    	                                                              /*    Util.Sleep(1300);
	    	                                                              
	    	                                                              correcto = false;
	    	                                                              
	    	                                                              int  i =0;
		    				    		           		                  while (i<16)
		    				    		           		    			 {
		    				    		           		    				 /* if (cont_icono[i]== memoria_icono && i<8)
		    				    		           		    				  {  visible_icono(i,imagen("def_error"));}
		    				    		           		                	  
		    				    		           		                	  if (cont_icono[i]== memoria_icono && i<8){
		    				    		           		    				    visible_icono(i,imagen("def_haptic_icon_disabled"));
		    				    		           		    				  /*  indice_icono = i;
		    				    		           		    				  /* Util.Cr_c.Iniciar();
		    				    		           		    				    correcto = false;
		    				    		           		    				    mostrar_figura();
		    				    		           		    				    
		    				    		           		    			     /*   Util.PlaySound(cont_icono[i]);
		    				    		           		    			        Util.Sleep(1000);
		    				    		           		    				   
		    				    		           		    				    
		    	                                                               
		    				    		           		    				 }
		    				    		           		    				 i++;
		    				    		           		    			 }*/
	    	                                                              
	    	       	           	     	                                
	    	       	           	     	                           }
	    	       	           	     	                        catch(Exception e){                    
	    	       	           	     	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    	       	           	     	                            b.show();     }
	    	       	           	     	                }};
	    	                
	    	       	           	     	                
	    	       	           	     	                /*
	    	       	           	     	                 COORDINACI�N DE VOZ FINAL FASE
	    	       	           	     	                 */
	    	       	           	     	                
	    	       	           	     	         public void final_fase(){
	    		   	      	           	    		  
	    	    	       	           	     		 Thread cronometro = new Thread(){
	    	    	       	           	     		        public void run(){
	    	    	       	           	     		                try{
	    	    	       	           	     		               
	    	    	       	           	     		                            while (Util.Cr_n.Update()/1000 < 3 )
	    	    	       	           	     		                            {
	    	    	       	           	     		                            	Thread.sleep(50);
	    	    	       	           	     		                            }
	    	    	       	           	     		                        	handler_seleccion.post(proceso_fase);
	    	    	       	           	     		                        	
	    	    	       	           	     		                        
	    	    	       	           	     		                }
	    	    	       	           	     		                catch(Exception e){
	    	    	       	           	     		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    	    	       	           	     		                        b.show();
	    	    	       	           	     		                }
	    	    	       	           	     		        }
	    	    	       	           	     		    };
	    	    	       	           	     		   cronometro.start(); }
	    	    	       	           	     	 
	    	    	       	           	     	 Handler handler_fase = new Handler();
	    	    	       	           	     	   
	    	    	       	           	     	    Runnable proceso_fase = new Runnable(){
	    	    	       	           	     	                public void run() {
	    	    	       	           	     	                        try{
	    	    	       	           	     	                        	      if ((fase+1 < 3) || (fase+1 == 3 && contador_aciertos == 0)){
	    	    	       	           	     	                        	    
	    	    	                                                              Util.PlaySound("fasefinnuevafase"); // vozcambio
	    	    	                                                              if (Util.MostrarMensajes)
	    	    	       	           	     	                        	      { mensaje_pantalla("FASE TERMINADA");
	    	    	       	           	     	                        	        Util.Sleep(2000);
	    	    	       	           	     	                        	        mensaje_pantalla("NUEVA FASE");
	    	    	       	           	     	                        	        loadfase(fase+1);}
	    	    	       	           	     	                        	      }else{
	    	    	       	           	     	                        	    
	    	    	       	           	     	                                         
	    	    	       	           	     	                        	    	     Util.PlaySound("fasefinprueba");
	    	    	       	           	     	                        	              if (Util.MostrarMensajes)
	    	    	       	           	     	                        	             mensaje_pantalla("FASE TERMINADA");}
	    	    	       	           	     	                        	      
	    	    	       	           	     	                        	      if (fase< 3)
	    	    	       	           	     	                        	      {
	    	    	       	           	     	                        	      fase++;
	    	    	       	           	     	                        	      }
	    	    	       	           	     	                        	      

	    	    	       	           	     	                           }
	    	    	       	           	     	                        catch(Exception e){                    
	    	    	       	           	     	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    	    	       	           	     	                            b.show();     }
	    	    	       	           	     	                }};
	    	    	                
	    	    	       	           	     	                
	    	    	       	           	     	         public void mostrar_figura(){
	    			    			   		          		  
	    			    		    		           		 Thread cronometro = new Thread(){
	    			    		    		           		        public void run(){
	    			    		    		           		                try{   
	    			    		    		           		                	
	    			    		    		           		                	
	    			    		    		           		                         /* while(Util.Cr_c.Update()/1000 < 2){
	    			    		    		     		                                  Thread.sleep(50);
	    			    		    		     		                              }*/
	    			    		    		           		                      
	    			    		    		           		                        	handler_figura.post(proceso_figura);
	    			    		    		           		                        	
	    			    		    		           		    			
	    			    		    		           		                }
	    			    		    		           		                catch(Exception e){
	    			    		    		           		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    			    		    		           		                        b.show();
	    			    		    		           		                }
	    			    		    		           		        }
	    			    		    		           		    };
	    			    		    		           		   cronometro.start(); }
	    			    		    		           	 
	    			    		    		           	 Handler handler_figura = new Handler();
	    			    		    		           	   
	    			    		    		           	    Runnable proceso_figura = new Runnable(){
	    			    		    		           	                public void run() {
	    			    		    		           	                        try{ 
	    			    		    		           	                        	
	    			    		    		           	                        	
	    			    		    		           	                        	visible_icono(indice_icono,imagen(cont_icono[indice_icono]));
	    			    		    		           	                        	
	    			    		    		           	                        	
	    			    		    		           	                        /*	 if (false) /*(fase<2)
	    			    		    		           	                        	{
	    			    		    		           	                        	if (correcto){
	    			    		    		           	        		    		    visible_icono(indice_icono,imagen(cont_icono[indice_icono]));
	    			    		    		           	        		    		    
	    			    				    		           		          	 }else{
	    			    		    		           	                             	visible_icono(indice_icono,imagen ("deficon"));
	    			    		    		           	                           }}
	    			    		    		           	                            else{ if (correcto){
	    			    				    		           		          	    	int i = 0;
	    			    				    		           		          	    	while(i < 8)
	    			    				    		           		          	    	{
	    			    				    		           		          	    		
	    			    				    		           		          	    		if (!error_icono[i])
	    			    				    		           		          	    			{
	    			    				    		           		          	    		if (cont_icono[indice_icono] == cont_icono[i])
	    			    				    		           		          	    				{
	    			    				    		           		          	    	        	visible_icono(i,imagen(cont_icono[i]));
	    			    				    		           		          	    				}
	    			    				    		           		          	    			}else{
	    			    				    		           		          	    			   visible_icono(i,imagen("def_error"));
	    			    				    		           		          	    			}
	    			    				    		           		          	    		i++;
	    			    				    		           		          	    	}
	    			    		    		           	                             	visible_icono(indice_icono,imagen ("deficon"));
	    			    		    		           	                        	   
	    			    		    		           	                        	   
	    			    		    		           	                        	
	    			    		    		           	                        	
	    			    		    		           	                        }
	    			    		    		           	                        }*/
	    			    		    		           	                        }
	    			    		    		           	                        catch(Exception e){                    
	    			    		    		           	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    			    		    		           	                            b.show();     }
	    			    		    		           	                }};

	    			    		    		           	             public void nombrar(){
	    		    			    			   		          		  
	    		    			    		    		           		 Thread cronometro = new Thread(){
	    		    			    		    		           		        public void run(){
	    		    			    		    		           		                try{   
	    		    			    		    		           		                	
	    		    			   
	    		    			    		    		           		                      /*   while(Util.Cr_n.Update()/1000 < 0.8){
	    		    			    		    		     		                                  Thread.sleep(50);*
	    		    			    		    		     		                              }*/
	    		    			    		    		           		                      
	    		    			    		    		           		                        	handler_nombrar.post(proceso_nombrar);
	    		    			    		    		           		                        	
	    		    			    		    		           		    			
	    		    			    		    		           		                }
	    		    			    		    		           		                catch(Exception e){
	    		    			    		    		           		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    		    			    		    		           		                        b.show();
	    		    			    		    		           		                }
	    		    			    		    		           		        }
	    		    			    		    		           		    };
	    		    			    		    		           		   cronometro.start(); }
	    		    			    		    		           	 
	    		    			    		    		           	 Handler handler_nombrar = new Handler();
	    		    			    		    		           	   
	    		    			    		    		           	    Runnable proceso_nombrar = new Runnable(){
	    		    			    		    		           	                public void run() {
	    		    			    		    		           	                	
	    		    			    		    		           	                	if (fase<2 && correcto){ if (Util.InfoAuditiva) {
	    		    			    		    		           	                		
		    		    			    		    		           	                     Util.PlaySound(cont_icono[indice_icono_fallo]);} }else{
	    		    			    		    		           	                	if (Util.InfoAuditiva) {
	    		    			    		    		           	                     Util.PlaySound(cont_icono[indice_icono]);}
	    		    			    		    		           	                	}
	    		    			    		    		           	                
	    		    			    		    		           	                }};
	    		    			    		    		           	                
	    		    			    		    		           	                
	    		    			    		    		           	                
	    		    			    		    		           	                
	    		    			    		    		           	             public void espera(){
	    		    				    		   	      	           	    		  
	    		    				    	    	       	           	     		 Thread cronometro = new Thread(){
	    		    				    	    	       	           	     		        public void run(){
	    		    				    	    	       	           	     		                try{
	    		    				    	    	       	           	     		               
	    		    				    	    	       	           	     		                            while (Util.Cr_es.Update()/1000 < 1 )
	    		    				    	    	       	           	     		                            {
	    		    				    	    	       	           	     		                            	Thread.sleep(50);
	    		    				    	    	       	           	     		                            }
	    		    				    	    	       	           	     		                        	handler_espera.post(proceso_espera);
	    		    				    	    	       	           	     		                        	
	    		    				    	    	       	           	     		                        
	    		    				    	    	       	           	     		                }
	    		    				    	    	       	           	     		                catch(Exception e){
	    		    				    	    	       	           	     		                        Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    		    				    	    	       	           	     		                        b.show();
	    		    				    	    	       	           	     		                }
	    		    				    	    	       	           	     		        }
	    		    				    	    	       	           	     		    };
	    		    				    	    	       	           	     		   cronometro.start(); }
	    		    				    	    	       	           	     	 
	    		    				    	    	       	           	     	 Handler handler_espera = new Handler();
	    		    				    	    	       	           	     	   
	    		    				    	    	       	           	     	    Runnable proceso_espera = new Runnable(){
	    		    				    	    	       	           	     	                public void run() {
	    		    				    	    	       	           	     	                        try{
	    		    				    	    	       	           	     	                        	      no_seleccion = false;
	    		    				    	    	       	           	     	                        	      

	    		    				    	    	       	           	     	                           }
	    		    				    	    	       	           	     	                        catch(Exception e){                    
	    		    				    	    	       	           	     	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
	    		    				    	    	       	           	     	                            b.show();     }
	    		    				    	    	       	           	     	                }};
	    		    				    	    	                
    			    		    		                
}
