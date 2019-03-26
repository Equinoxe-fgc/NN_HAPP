package com.diana.nn_happ;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.immersion.uhl.Device;
import com.immersion.uhl.IVTBuffer;
import com.immersion.uhl.Launcher;

public class MainActivity extends Activity {
	
	
	public boolean entrada[]= new boolean [20]; // Coordinadores de selecci�n de posiciones de iconos
	public String cont_icono[] = new String [20]; //contenido icono
	public String cont_icono_y[] = new String [20];
	public boolean acierto_icono[]= new boolean[20];
	public int contador_aciertos = 0;
	
	public boolean dedo_seleccion = false;
	
	
	public MotionEvent evento;
	
	
	
	
	 
	 private  Launcher launcher;
	 
	 public int estado_tb = 0;
	 public String icono = "";
	 
	 
	 public boolean mensaje_tb = true;
	 
	 
	 
	 
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
		setContentView(R.layout.activity_main);
		
		 Util.AM = getAssets();
		 
		 try{ device = Device.newDevice(getApplicationContext());
			
			} catch(Exception e){}
		 
		
			
			estado_tb = 0;
			
	        cont_icono[0]= "facebook";
	        cont_icono[1]= "twitter";
	        cont_icono[2]= "linkedin";
	        cont_icono[3]= "wasapp";
	        cont_icono[4]= "phone";
	        cont_icono[5]= "sms";
	        cont_icono[6]= "email";
	        cont_icono[7]= "line";
	        cont_icono[8]="googleplus";
	        cont_icono[9]="wifi";
	        cont_icono[10]="update";
	        cont_icono[11]="talk";
	        cont_icono[12]="bateria";
	        cont_icono[13]="calendario";
	        cont_icono[14]="reloj";
	        cont_icono[15]="camara";
	        
	        
	        cont_icono_y[0]= "facebook_y";
	        cont_icono_y[1]="twitter_y";
	        cont_icono_y[2]= "linkedin_y";
	        cont_icono_y[3]="wasapp_y";
	        cont_icono_y[4]="phone_y";
	        cont_icono_y[5]="sms_y";
	        cont_icono_y[6]="email_y";
	        cont_icono_y[7]="line_y";
	        cont_icono_y[8]="googleplus_y";
	        cont_icono_y[9]="wifi_y";
	        cont_icono_y[10]="update_y";
	        cont_icono_y[11]="talk_y";
	        cont_icono_y[12]="bateria_y";
	        cont_icono_y[13]="calendario_y";
	        cont_icono_y[14]="reloj_y";
	        cont_icono_y[15]="camara_y";
	        
	       estado_tb= 1;
           int i=0;
			
           while( i < 16){
 			 
        	  if (Util.InfoVisual) {
 			  visible_icono(i,imagen(cont_icono[i]));
 			 
	                }else{ visible_icono(i,imagen("def_int"));}
 			  entrada[i]=true;
 			  
 			  i++;
 			}
           
            if(Util.InfoAuditiva)
            Util.PlaySound("modoapren");
           
           
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void  visible_icono( int indice, int img){  // indice de icono, contenido de icono
		try{ 
		  if (indice == 0){
		   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView);
	       dibujo.setImageResource(img);}
		  if (indice == 1){
			   ImageView dibujo =  (ImageView) findViewById(R.id.imageView0);
		       dibujo.setImageResource(img);}
		  if (indice == 2){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView02);
		       dibujo.setImageResource(img);}
		  if (indice == 3){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView03);
		       dibujo.setImageResource(img);}
		  if (indice == 4){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView04);
		       dibujo.setImageResource(img);}
		  if (indice == 5){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView05);
		       dibujo.setImageResource(img);}
		  if (indice == 6){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView06);
		       dibujo.setImageResource(img);}
		  if (indice == 7){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView07);
		       dibujo.setImageResource(img);}
		
		  if (indice == 8){
			   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView08);
		       dibujo.setImageResource(img);}			
			  if (indice == 9){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView09);
			       dibujo.setImageResource(img);}
			  if (indice == 10){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView10);
			       dibujo.setImageResource(img);}
			  if (indice == 11){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView11);
			       dibujo.setImageResource(img);}
			  if (indice == 12){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView12);
			       dibujo.setImageResource(img);}
			  if (indice == 13){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView13);
			       dibujo.setImageResource(img);}
			  if (indice == 14){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView14);
			       dibujo.setImageResource(img);}
			  if (indice == 15){
				   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView15);
			       dibujo.setImageResource(img);}
			
			 
        }catch (Exception e) 
        	{Toast.makeText(this, "falla  VISIBLE_ICONO",
                    Toast.LENGTH_SHORT).show();}
	
	
	
	
	}
	
	public int imagen ( String img){
		int entero=0;
		try{ 
		
			 if (img == "camara")
					entero= R.drawable.camara;
			 if (img == "camara_y")
					entero= R.drawable.camara_y;
	
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
		 if (img=="instagram")
			 entero= R.drawable.instagram;
		 
		 if (img=="instagram_y")
			 entero= R.drawable.instagram_y;
		 
		 if (img=="def")
			 entero= R.drawable.def;
		 
		 if (img == "deficon")
			 entero = R.drawable.deficon;
		 
		 if (img == "def_haptic_icon_disabled")
			 entero = R.drawable.def_haptic_icon_disabled;
		 
		 if (img == "def_haptic_icon_y")
			 entero = R.drawable.def_haptic_icon_y;
		 
		 if (img == "def_int")
			 entero = R.drawable.def_int;
		 if (img == "def_int_y")
			 entero = R.drawable.def_int_y;
		 
			 
		
		 
		}catch (Exception e) 
    	{Toast.makeText(this, "falla  IMAGEN",
                Toast.LENGTH_SHORT).show();}
		
		 return entero;
		
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
    	
    	


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
		
		
		String acciones[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL","ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };

		int accion = event.getAction();

		int codigoAccion = accion & MotionEvent.ACTION_MASK;
		
		

	/*	salida.append(acciones[codigoAccion]);

		for (int i = 0; i < evento.getPointerCount(); i++) {

		salida.append(" puntero: "  + evento.getPointerId(i) + 
		" x:" + evento.getX(i) + " y:" + evento.getY(i));

		}

		salida.append("\n");*/
		
		
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
    	           /*Util.Cr.Detener();*/
		  	    	}
    	   }
  	     if (estado_tb ==4 )
  	     {
  	    	 if(Util.Cr.Update()/100 <2){   // seleccion
  	    		 
  	    		int  i =0;
 	    		 while (i<16){
 	    			 
 	    			 if ( !entrada[i]){
 	    				 vibraciones_iconos(cont_icono[i]);
 	    			 }
 	    			 i++;
 	    		 }
  	  	    	
 	    		mensaje_tb = false;
  	    		estado_tb =1; 
  	    		
  	    		
  	            }else{}
		
	 	  }
  	     
  	   
		}
       
       // Fin doble Click
       
		
		/*salida.clearComposingText();*/
		if(acciones[codigoAccion].equals("ACTION_DOWN"))
			
		{
			
			
			 
		
			
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
  	  	    	
  	    	
  	    		int  i =0;
  	    		 while (i<16){
  	    			 
  	    			 if ( !entrada[i]){
  	    				 vibraciones_iconos(cont_icono[i]);
  	    			 }
  	    			 i++;
  	    		 }
  	    		 
  	    		estado_tb = 1;
  	    		mensaje_tb = false;
  	            }else{}
		
	 	  }
    	}   	
    	
    	
			  mensaje_tb = false;
		
		}
		
      
		
		if ((acciones[codigoAccion].equals("ACTION_MOVE") || acciones[codigoAccion].equals("ACTION_DOWN")) && event.getPointerCount() == 1 ){
			
			
			
			
			
			
			if (estado_tb <1){
				{
			
			seleccion(event);
			estado_tb = 1;
				}
			
			/*Util.Cr.Iniciar();*/
			}
		
			
			if(Util.Cr.Update()/100 >2 && estado_tb<3)
			{
			 seleccion(event);
			 estado_tb = 1;
				
				/*seleccion();*/
			}		
				
			 if(Util.Cr.Update()/100 > 3)
				 {estado_tb = 1;
				 } 
				
			 
			
			
		 	 
			return false;

			}
			
		     
		/*	if (estado_tb ==1 && mensaje_tb) {
				
	 			if (Util.Cr.Update()/1000 > 0.75)
	 			{   Util.PlaySound("bateria");
	 				Util.Cr.Iniciar();
	 				mensaje_tb = false;
	 			} else { }
	 				
			} */

			return false;
			
		}
			
	public void seleccion( MotionEvent event )
	{
			/*if (icon.Name.equals("facebook"))*/
        	if ((event.getX() < 175)  && (event.getY() < 400) && (event.getY() > 150) && entrada[0])
        	/*	if ((pixelX < 200)  && (pixelY < 300) && entrada_internet)*/
        	     {
        		
        		
        		 seleccion_tb();
        		
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView);
          	     if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono_y[0]));}else{
        			 dibujo.setImageResource(imagen("def_int_y"));
        		 }
        		  
        	         /*try{	 
        	    		 launcher.stop();
        	    		 mediaplayer.start();
        	    		 launcher.play(50);
        	    		
		        		}catch (Exception e) 
		           		{} */
        		    
          	     
          	     
          	        
        		     icono = cont_icono[0];
        		     if (Util.InfoAuditiva)
        		     Util.PlaySound(icono);
        	    	
        	    	 Util.Cr.Iniciar();
      				 mensaje_tb = true;
        	    	 
      				entrada[0] = false;
	 	        	    }
        		
        		
        		 
        	 if    (!((event.getX() < 175)  && (event.getY() < 400)&& (event.getY() > 150)) )
        	/*	if(!((pixelX < 200)  && (pixelY < 300)))*/
        	 {
        	 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[0]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
       	                entrada[0]= true; 
        	 }
        			
          /*  if (icon.Name.equals("twitter"))*/
        	
        	if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() < 400) && (event.getY() > 150)&& entrada[1])
        	/*	if ((pixelX> 200)  && (pixelX <400) && (pixelY< 300) && entrada_facebook)*/
        		
        	     {
        		  
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.imageView0);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[1]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		   
        	    	/*try{launcher.stop();
        	    	    mediaplayer.start();
        	    		 launcher.play(30);
        	    		
		        		
		        		}catch (Exception e) 
		           		{}*/
        		 
        	    	 icono = cont_icono[1];
        	    	 if (Util.InfoAuditiva)
        	    	 Util.PlaySound(icono);
        	    
        	    	 entrada[1] = false;
	 	        	    }
        	
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() < 400)&&(event.getY() > 150)) )
        	/*	if (!((pixelX> 200)  && (pixelX <400) && (pixelY< 300)))*/
        	 {ImageView dibujo =  (ImageView) findViewById(R.id.imageView0);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[1]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
		    	 entrada[1] = true; }
        	 
        	 
       	/* if (icon.Name.equals("linkedin")) */
        	if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() < 400) && (event.getY() > 150) && entrada[2])
       /* 	if ((pixelX > 400)  && (pixelX <600) && (pixelY< 300) && entrada_twitter)*/
    	     {
        		
        		seleccion_tb();
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView02);
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono_y[2]));}else{
           			 dibujo.setImageResource(imagen("def_int_y"));
           		 }
        		/*try{launcher.stop();
        		    mediaplayer.start(); 
    	    		launcher.play(91);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[2];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound("linkedin");
    	    	 
    	    	 entrada[2] = false;
        	 
    	     }
        	
        	if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() < 400) && (event.getY() > 150)) )
        	/*	 if (!((pixelX > 400)  && (pixelX <600) && (pixelY< 300)))*/
        	{   icono  = "a";
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView02);
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono[2]));}else{
           			 dibujo.setImageResource(imagen("def_int"));
           		 }
            	   entrada[2]= true; }
        	
        	 
    	    	 
      /*  if (icon.Name.equals("wasapp")) */
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() < 400) && (event.getY() > 150) && entrada[3])
		    		
        	 {
        		 
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView03);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[3]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		/* try{launcher.stop();
        		      mediaplayer.start();
    	    		 launcher.play(40);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[3];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[3] = false;
    	    	 
 	        	    }  	     
        		
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() < 400) && (event.getY() > 150)) )
        	 {
        		 
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView03);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono[3]));}else{
            			 dibujo.setImageResource(imagen("def_int"));
            		 }
            	   entrada[3] = true; }
        	 
        	 /*if (icon.Name.equals("phone"))*/
        	 if ((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 400 ) && (event.getY() < 700)  && entrada[4])
				  
    	     {
        		 
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView04);
            	 
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[4]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		/* try{launcher.stop();
        			 launcher.play(35);
        			 mediaplayer.start();
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[4];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[4] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 400 ) && (event.getY() < 700) ) )
        	 { ImageView dibujo =  (ImageView) findViewById(R.id.ImageView04);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[4]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        		 entrada[4] = true; }
        	 
        	/* if (icon.Name.equals("sms"))*/
        	 if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 400 ) && (event.getY() < 700)  && entrada[5])
				  
    	     {
        		 
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView05);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[5]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
    	    	/*try{launcher.stop();
    	    	    mediaplayer.start();
    	    		launcher.play(77);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		
    	    	 icono = cont_icono[5];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[5] = false;
    	    
 	        	    }
        	 
        	 
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 400 ) && (event.getY() < 700))) 
        	 {	 entrada[5] = true; 
        	 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView05);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[5]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        	 }
        	 
        	 
        	 /* if (icon.Name.equals("email"))*/
        	 if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 400 ) && (event.getY() < 700)  &&  entrada[6])
				  
    	     {
        		
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView06);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[6]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		
    	    	/* try{launcher.stop();
    	    	 mediaplayer.start();
    	    		 launcher.play(67);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[6];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    
    	    	 entrada[6] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 400 ) && (event.getY() < 700)) )
        	 { ImageView dibujo =  (ImageView) findViewById(R.id.ImageView06);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[6]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        		 entrada[6] = true; }
        	 
        	 /* if (icon.Name.equals("line"))*/
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 400 ) && (event.getY() < 700)  && entrada[7])
				  
    	     {
        		 
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView07);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[7]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		/* try{launcher.stop();
        		    mediaplayer.start();
    	    		 launcher.play(76);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono_y[7];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound("line");
    	    	
    	    	 entrada[7] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 400 ) && (event.getY() < 700)) )
		    	 
        	 {	 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView07);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[7]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        	 	entrada[7] = true; }
        	 
        	 
        	 //*****************************************************************
        	 
        	 
        	 
        	 /*if (icon.Name.equals("googleplus"))*/
        		if ((event.getX() < 175)   && (event.getY() > 700) && (event.getY() < 1000) && entrada[8])
        	     {
        			
        			seleccion_tb();
        			ImageView dibujo =  (ImageView) findViewById(R.id.ImageView08);
        			if (Util.InfoVisual){
               		 dibujo.setImageResource(imagen(cont_icono_y[8]));}else{
               			 dibujo.setImageResource(imagen("def_int_y"));
               		 }
        			
        			
        			/*try{
        	    		 launcher.stop();
        	    		 mediaplayer.start();
        	    		 launcher.play(50);
        	    		
		        		
		        		}catch (Exception e) 
		           		{}*/
        			 
        	    	 icono = cont_icono[8];
        	    	 if (Util.InfoAuditiva)
        	    	 Util.PlaySound(icono);
        	    
        	    	 entrada[8]= false;
        	    	
	 	        	    }
        		
        		
        		 
        		   if    (!((event.getX() < 175)  && (event.getY() > 700) && (event.getY() < 1000)) )
        		   {ImageView dibujo =  (ImageView) findViewById(R.id.ImageView08);
        		   if (Util.InfoVisual){
              		 dibujo.setImageResource(imagen(cont_icono[8]));}else{
              			 dibujo.setImageResource(imagen("def_int"));
              		 }
        		    	 entrada[8]= true; }
        		    
        			
          /*  if (icon.Name.equals("wifi"))*/
        	
        	if ((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 700) && (event.getY() < 1000) && entrada[9])
        	     {
        		seleccion_tb();
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView09);
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono_y[9]));}else{
           			 dibujo.setImageResource(imagen("def_int_y"));
           		 }
        		/* try{  launcher.stop();
        		      mediaplayer.start();
        	    	  launcher.play(30);
		        		
		        		}catch (Exception e) 
		           		{}*/
        		 	
        	    	 icono = cont_icono[9];
        	    	 if (Util.InfoAuditiva)
        	    	 Util.PlaySound(icono);
        	    	 
        	    	 entrada[9] = false;
	 	        	    }
        	
        	 if    (!((event.getX() > 175)  && (event.getX() <350) && (event.getY() > 700) && (event.getY() < 1000)) )
		    	 {entrada[9]= true;
		    	   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView09);
		    	   if (Util.InfoVisual){
	            		 dibujo.setImageResource(imagen(cont_icono[9]));}else{
	            			 dibujo.setImageResource(imagen("def_int"));
	            		 }
		    	 }
        	 
       	/* if (icon.Name.equals("update")) */
        	if ((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 700) && (event.getY() < 1000) && entrada[10])
    		        
    	     {seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView10);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[10]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		/*try{launcher.stop();
        	    	mediaplayer.start();
    	    	    launcher.play(91);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[10];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	 
    	    	 entrada[10] = false;
        	 
    	     }
        	
        	 if    (!((event.getX() > 350)  && (event.getX() <525) && (event.getY() > 700) && (event.getY() < 1000)) )
        	 {   ImageView dibujo =  (ImageView) findViewById(R.id.ImageView10);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[10]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        		 entrada[10] = true; }
        	
        	 
    	    	 
      /*  if (icon.Name.equals("talk")) */
        	 if ((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 700) && (event.getY() < 1000) && entrada[11])
		    		
    	     {
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView11);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[11]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		
        		/* try{launcher.stop();
        		     mediaplayer.start();
    	    		 launcher.play(40);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[11];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[11] = false;
    	    	 
 	        	    }  	     
        		
        	 if    (!((event.getX() > 525)  && (event.getX() <700) && (event.getY() > 700) && (event.getY() < 1000)) )
        	 { ImageView dibujo =  (ImageView) findViewById(R.id.ImageView11);
        	 if (Util.InfoVisual){
        		 dibujo.setImageResource(imagen(cont_icono[11]));}else{
        			 dibujo.setImageResource(imagen("def_int"));
        		 }
        		 entrada[11]= true; }
        	
        	  /*if (icon.Name.equals("bateria"))*/
        	 if ((event.getX() > 0)  && (event.getX() <175) && (event.getY() > 1000 )  && entrada[12])
				  
    	     {seleccion_tb();
        		 
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView12);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[12]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
    	    	/* try{launcher.stop();
    	    	     mediaplayer.start();
    	    		 launcher.play(22);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[12];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[12] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 0)  && (event.getX() <175) &&  (event.getY() > 1000 ) ) )
        	 { entrada[12]= true; 
          	 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView12);
          	if (Util.InfoVisual){
       		 dibujo.setImageResource(imagen(cont_icono[12]));}else{
       			 dibujo.setImageResource(imagen("def_int"));
       		 }
        	 }
        	 
        	/* if (icon.Name.equals("calendario"))*/
        	 if ((event.getX() > 175)  && (event.getX() <350) &&  (event.getY() > 1000 )  && entrada[13])
				  
    	     {
        		 seleccion_tb();
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView13); 
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono_y[13]));}else{
           			 dibujo.setImageResource(imagen("def_int_y"));
           		 }
        		    
        		/* try{launcher.stop();
        		     mediaplayer.start();
    	    	 	 launcher.play(53);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
    	    	 icono = cont_icono[13];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	   
    	    	 entrada[13] = false;
    	    
 	        	    }
        	 
        	 
        	 if    (!((event.getX() > 175)  && (event.getX() <350) &&  (event.getY() > 1000 ))) 
        	 {
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView13); 
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono[13]));}else{
           			 dibujo.setImageResource(imagen("def_int"));
           		 }
        		entrada[13] = true;} 
        	 
        	 
        	 /* if (icon.Name.equals("reloj"))*/
        	 if ((event.getX() > 350)  && (event.getX() <525) &&  (event.getY() > 1000 )  && entrada[14])
				  
    	     {
        		 seleccion_tb();
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView14);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono_y[14]));}else{
            			 dibujo.setImageResource(imagen("def_int_y"));
            		 }
        		/* try{launcher.stop();
        	     	 mediaplayer.start();
    	    		 launcher.play(47);
	        		
	        		}catch (Exception e) 
	           		{}*/
        		 
        		 
    	    	 icono = cont_icono[14];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[14] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 350)  && (event.getX() <525) &&  (event.getY() > 1000 )) )
        	 { 
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView14);
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono[14]));}else{
            			 dibujo.setImageResource(imagen("def_int"));
            		 }
		    	 entrada[14]= true; }
        	 
        	 /* if (icon.Name.equals("instagram"))*/
        	 if ((event.getX() > 525)  && (event.getX() <700) &&  (event.getY() > 1000 )  && entrada[15])
    	     {
        		 seleccion_tb();
        		ImageView dibujo =  (ImageView) findViewById(R.id.ImageView15); 
        		if (Util.InfoVisual){
           		 dibujo.setImageResource(imagen(cont_icono_y[15]));}else{
           			 dibujo.setImageResource(imagen("def_int_y"));
           		 }
        		
        		
        		
    	    	 icono = cont_icono[15];
    	    	 if (Util.InfoAuditiva)
    	    	 Util.PlaySound(icono);
    	    	
    	    	 entrada[15] = false;
    	    
 	        	    }
        	 
        	 if    (!((event.getX() > 525)  && (event.getX() <700) &&(event.getY() > 1000 )) )
        	 {
        		 ImageView dibujo =  (ImageView) findViewById(R.id.ImageView15);
        		 entrada[15]= true; 
        		 if (Util.InfoVisual){
            		 dibujo.setImageResource(imagen(cont_icono[15]));}else{
            			 dibujo.setImageResource(imagen("def_int"));
            		 }
        	 }
        	 
        	 if (event.getY()<150)
        	 {
        		 icono = " ";
        	 }
        	 
        	 
}
        	 
       
		
		 public void mensaje_pantalla( String texto){
			 
			 if (Util.MostrarMensajes){
		  		
				 Toast b=Toast.makeText(getApplicationContext(), texto, 25);
                 b.show();
				  
			 }
			 
		 	}
		 
		 
		 
		 
		 public void seleccion_tb()
		 
		 {  
			 estado_tb = 1;
			 Util.Cr_h.Iniciar();
			 mensaje_tb = true;
			 	 
			/* Util.PlaySound(icono);*/
			 
			 if(Util.VibrarOnClick){
			 try{launcher.stop(); 
	          	 
	          	 launcher.play(3);
    		
    		}catch (Exception e) 
       		{}
			 }
			 
			
			 hilador();
			
			 
		 }
			
		
		 
		 public void vibraciones_iconos(String icono )
		 {
			int codigo_vibra =3 ;
			String sonido = "";
			
			
			if (Util.DiferIconosHapt)
			{
			 
			 if ( icono == "facebook")
				 {try{
					 device.playIVTEffect(ivtBuffer1,facebook.Palmas);
	             }
	          catch(Exception e){}
				 
				}
			 
			 if (icono == "twitter")
			 {  try{
				 device.playIVTEffect(ivtBuffer2,twitter.Timeline);
             }
          catch(Exception e){}
			   }
			     
			 if (icono == "linkedin")
			 { try{
				 device.playIVTEffect(ivtBuffer3,linkedin.Pitido);
             }
          catch(Exception e){}
			
			     }
				 
			 if (icono == "wasapp")
			 { try{
				 device.playIVTEffect(ivtBuffer4,guasapp.Rafaga);
             }
          catch(Exception e){}
			
			     }
			    
				 
			
			 if (icono == "email")
			 {  try{
				 device.playIVTEffect(ivtBuffer7,email.Alarma);
             }
          catch(Exception e){}
			}
			 if (icono == "line")
				 try{
					 device.playIVTEffect(ivtBuffer8,line.Morse);
                 }
              catch(Exception e){}
			 
			 if (icono == "phone")
				 try{
					 device.playIVTEffect(ivtBuffer5,phone.Phone);
	             }
	          catch(Exception e){}
			 
			 if (icono == "wifi")
				 try{
					 device.playIVTEffect(ivtBuffer10,wifi.Latido);
                 }
              catch(Exception e){}
			 if (icono == "sms")
				 try{
					 device.playIVTEffect(ivtBuffer6,esemese.Palmas);
	             }
	          catch(Exception e){}
			 if (icono == "update")
				 try{
					 device.playIVTEffect(ivtBuffer11,update.Brian);
                 }
              catch(Exception e){}
			 if (icono == "talk")
				 try{
					 device.playIVTEffect(ivtBuffer12,tolk.Puerta);
                 }
              catch(Exception e){}
			 if (icono == "googleplus")
				 try{
					 device.playIVTEffect(ivtBuffer9,googleplus.Tambor);
                 }
              catch(Exception e){}
			 if (icono == "calendario")
				 try{
					 device.playIVTEffect(ivtBuffer14,calendario.Balon);
                 }
              catch(Exception e){}
			 if (icono == "camara")
				 try{
					 device.playIVTEffect(ivtBuffer16,camara.Crescendo);
                 }
              catch(Exception e){}
			 
			 if (icono == "reloj")
				 try{
					 device.playIVTEffect(ivtBuffer15,reloj.Lascuatro);
                 } catch(Exception e){}
			 
			 
			 if (icono == "bateria")
				 try{
					 device.playIVTEffect(ivtBuffer13,bateria.Decrescendo);
                 }
                   catch(Exception e){}
			 
			}else	{ 
				 try{launcher.stop(); 
	          	  /*mediaplayer.start();*/
	          	   launcher.play(codigo_vibra);
    		
    	   	}catch (Exception e) 
       		{}
			}
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
						
					
						Intent intent = new Intent( getApplicationContext(), Act_parejas.class);
						startActivity( intent );	
						
						return true;
					case KeyEvent.KEYCODE_VOLUME_DOWN:
						/*Toast.makeText(this, "Boton de Volumen Down presionado",
		                                                        Toast.LENGTH_SHORT).show();*/
						finish();
						super.finish();
						
						
						return true;
						
					case KeyEvent.KEYCODE_BACK:
						/*Toast.makeText(this, "Boton de Volumen Down presionado",
		                                                        Toast.LENGTH_SHORT).show();*/
						
				}
				return super.onKeyDown(keyCode, event);
			}


		 
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
			                        /*	Util.Cr.Iniciar();*/
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
			           	                               estado_tb = 1;
			           	                               
			           	                              
			           	                           }
			           	                        catch(Exception e){                    
			           	                                Toast b=Toast.makeText(getApplicationContext(), e.toString(), 2000);
			           	                            b.show();     }
			           	                }};


}
