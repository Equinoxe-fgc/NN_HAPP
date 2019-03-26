package com.diana.nn_happ;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import com.immersion.uhl.Device;
import com.immersion.uhl.IVTBuffer;
import com.immersion.uhl.Launcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import uma.diana.nn_happ.R;


/** Se implementa esta clase para ahorrar tiempo y memoria al cargar im�genes.
 *  A partir de nombres de fichero devuelve un bitmap con la imagen correspondiente. */
class CacheBitmap
{
	/** Tama�o de la cach� (n�mero de objetos Bitmap que se pueden guardar) */
	private final int Size = 20;
	/** �ndice que indica la pr�xima posici�n de la cach� en la que se a�adir� un nuevo elemento */
	private int Index = 0;
	/** Nombres de fichero png sin extensi�n */
	private String Files[];
	/** Objetos Bitmap creados que se guardan en la cach� */
	private Bitmap BM[];
	
	/** Recibe un nombre de fichero png (sin extensi�n) y devuelve un objeto Bitmap con la imagen 
	 * asociada a file cargada. Esa imagen debe estar en la carpeta assets.
	 *  El objeto Bitmap se crear� si no se encuentra en la cach�. */
	public Bitmap Get( String file )
	{
		if( Files == null || BM == null || Files.length != BM.length )
			return null;
		
		try
		{
			// B�squeda del fichero:
			for( int c=0; c < Files.length; c++ )
			{
				if( Files[c] == file )
					return BM[c];
			}
			
			// file no est� en la cach�:
			InputStream is = Util.AM.open( file + ".png" );
			android.graphics.Bitmap bm = BitmapFactory.decodeStream( is );
			is.close();
			
			Files[ Index ] = file;
			BM   [ Index ] = bm;
			Index++;
			if( Index == Files.length )
				Index = 0;
			
			return bm;	
		}
		catch( Exception e )
		{
			Util.Log( e.getMessage() );
		}
		return null;
	}
	
	CacheBitmap()
	{
		Files = new String[ Size ];
		BM    = new Bitmap[ Size ];
	}	
}

/** El objetivo de esta clase es facilitar las tareas relacionadas con la animaci�n de objetos View a 
 * trav�s de la clase ViewAnimator. */
class Animador
{
	/** Objeto ViewAnimator que se usar� para las animaciones */
	public ViewAnimator VA;
	
	/** Im�genes que se usan para hacer la animaci�n. Una de ellas se muestra mientras que la otra se prepara
	 * para mostrarse. */
	public ImageView ImgA;
	public ImageView ImgB;
	
	/** A true indica que la animaci�n de translaci�n actual va de izquierda a derecha */
	private boolean LToR;

	// Animaciones de entrada y salida en las direcciones izq a der y der a izq:
	private AnimationSet  inAnimSet_LToR;
	private AnimationSet outAnimSet_LToR;
	private AnimationSet  inAnimSet_RToL;
	private AnimationSet outAnimSet_RToL;
	
	/** Duraci�n en ms del efecto actual */
	private int Duracion_ms;
	
	/** Permitir� implementar la funci�n animando */
	private Crono Cr = new Crono();
	
	/** Constructor de la clase. 
	 *  Conviene que va no est� configurado con Width y Height a wrap content.  */
	Animador( ViewAnimator va )
	{
		VA = va;
		
		ImgA = new ImageView( va.getContext() );
		ImgB = new ImageView( va.getContext() );
		
		/* No parece necesario
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT );
		ImgA.setLayoutParams( params );
		ImgB.setLayoutParams( params ); */
		
		VA.addView( ImgA );
		VA.addView( ImgB );
		
        SetConfigOpacidad( 500 );
	}
	
	/** Aplica un tipo de animaci�n que consiste en reemplazar un control mediante una escala 
	 * y un cambio en la opacidad */
	public void SetConfig_Escala_y_Opacidad( int duracion_ms, int imgSide )
	{
		if( VA == null )
			return;
		
		Duracion_ms = duracion_ms;		
		
		// ���� Definici�n de animaciones individuales
		Animation  inAnimO = new AlphaAnimation( 0, 1 );
    	Animation outAnimO = new AlphaAnimation( 1, 0 );
    	
    	 inAnimO.setDuration( duracion_ms );
    	outAnimO.setDuration( duracion_ms );
    	
		Animation  inAnimS = new ScaleAnimation( 0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f );
		Animation outAnimS = new ScaleAnimation( 1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f );
				
		 inAnimS.setDuration( duracion_ms );
		outAnimS.setDuration( duracion_ms );
    	
    	// ���� Definici�n de Conjuntos de Animaciones 
    	
    	AnimationSet inAnimSet  = new AnimationSet( false );
    	AnimationSet outAnimSet = new AnimationSet( false );
    	
    	inAnimSet  .addAnimation( inAnimO   );
    	inAnimSet  .addAnimation( inAnimS   );
    	outAnimSet .addAnimation( outAnimO  );
    	outAnimSet .addAnimation( outAnimS  );
    	
    	
    	// ���� Asignaci�n de los conjuntos de animaciones:
    	VA.setInAnimation ( inAnimSet  );
    	VA.setOutAnimation( outAnimSet );			
	}
	
	
	/** Aplica un tipo de animaci�n que consiste en reemplazar un control mediante un desplazamiento 
	 * horizontal y un cambio en la opacidad */
	public void SetConfig_Desplaz_y_Opacidad( int duracion_ms, int incrX )
	{
		if( VA == null )
			return;
		
		Duracion_ms = duracion_ms;		
		
		// ���� Definici�n de animaciones individuales
		Animation  inAnimO = new AlphaAnimation( 0.2f,    1 );
    	Animation outAnimO = new AlphaAnimation(    1, 0.2f );
    	
    	 inAnimO.setDuration( duracion_ms );
    	outAnimO.setDuration( duracion_ms );
    	
		Animation  inAnimT_LToR = new TranslateAnimation (-incrX,      0, 0, 0 );
    	Animation outAnimT_LToR = new TranslateAnimation (     0,  incrX, 0, 0 );
    	 inAnimT_LToR.setDuration( duracion_ms );
    	outAnimT_LToR.setDuration( duracion_ms );
    	
		Animation  inAnimT_RToL = new TranslateAnimation ( incrX,      0, 0, 0 );
    	Animation outAnimT_RToL = new TranslateAnimation (     0, -incrX, 0, 0 );
    	 inAnimT_RToL.setDuration( duracion_ms );
    	outAnimT_RToL.setDuration( duracion_ms );
    	
    	// ���� Definici�n de Conjuntos de Animaciones de Izq a Der
    	
    	 inAnimSet_LToR = new AnimationSet( false );
    	outAnimSet_LToR = new AnimationSet( false );
    	
    	inAnimSet_LToR  .addAnimation( inAnimO       );
    	inAnimSet_LToR  .addAnimation( inAnimT_LToR  );
    	outAnimSet_LToR .addAnimation( outAnimO      );
    	outAnimSet_LToR .addAnimation( outAnimT_LToR );
    	
    	// ���� Definici�n de Conjuntos de Animaciones de Der a Izq
    	
    	 inAnimSet_RToL = new AnimationSet( false );
    	outAnimSet_RToL = new AnimationSet( false );
    	
    	inAnimSet_RToL  .addAnimation( inAnimO       );
    	inAnimSet_RToL  .addAnimation( inAnimT_RToL  );
    	outAnimSet_RToL .addAnimation( outAnimO      );
    	outAnimSet_RToL .addAnimation( outAnimT_RToL );
    	
    	
    	// ���� Asignaci�n de los conjuntos de animaciones:

    	LToR = true;
    	VA.setInAnimation ( inAnimSet_LToR  );
    	VA.setOutAnimation( outAnimSet_LToR );			
	}
	
	/** Aplica un tipo de animaci�n que consiste en reemplazar un control mediante un desplazamiento 
	 * horizontal y un cambio en la opacidad */
	public void SetConfigOpacidad( int duracion_ms )
	{
		if( VA == null )
			return;
		
		Duracion_ms = duracion_ms;		
		
		// ���� Definici�n de animaciones individuales
		Animation  inAnimO = new AlphaAnimation( 0, 1 );
    	Animation outAnimO = new AlphaAnimation( 1, 0 );
    	
    	 inAnimO.setDuration( duracion_ms );
    	outAnimO.setDuration( duracion_ms );
    	
    	// ���� Definici�n de Conjuntos de Animaciones 
    	
    	 AnimationSet  inAnimSet = new AnimationSet( false );
    	 AnimationSet outAnimSet = new AnimationSet( false );
    	
    	 inAnimSet.addAnimation(  inAnimO );
    	outAnimSet.addAnimation( outAnimO );
    	
    	// ���� Asignaci�n de los conjuntos de animaciones:
    	VA.setInAnimation ( inAnimSet  );
    	VA.setOutAnimation( outAnimSet );			
	}
	
	/** Devuelve true si se est� aplicando alguna animaci�n */
	public boolean Animando()
	{
		return !Cr.Detenido() && Cr.Update() < (long)(Duracion_ms + 50 ); 
	}
	
	/** Carga la imagen asociada al nombre de fichero pasado png (sin extensi�n) e inicia la animaci�n */
	public void LoadAndAnimImg( String file_img, String file_icon )
	{
		ImageView img = (VA.getCurrentView() == ImgA) ? ImgB : ImgA;
		Util.LoadImg( img, file_img, file_icon );
		Cr.Iniciar();
		VA.showNext();
	}

	/** Carga la imagen asociada al nombre de fichero pasado png (sin extensi�n) e inicia la animaci�n de izq a der */
	public void LoadAndAnimImgFromLeftToRight( String file_img, String file_icon )
	{
		if( !LToR )
		{
	    	VA.setInAnimation (  inAnimSet_LToR );
	    	VA.setOutAnimation( outAnimSet_LToR );			
	    	LToR = true;
		}
		Util.LoadImg( (VA.getCurrentView() == ImgA) ? ImgB : ImgA, file_img, file_icon );
		Cr.Iniciar();
		VA.showNext();
	}
	
	/** Carga la imagen asociada al nombre de fichero pasado png (sin extensi�n) e inicia la animaci�n de der a izq */
	public void LoadAndAnimImgFromRightToLeft( String file_img, String file_icon )
	{
		if( LToR )
		{
	    	VA.setInAnimation (  inAnimSet_RToL );
	    	VA.setOutAnimation( outAnimSet_RToL );			
	    	LToR = false;
		}
		
		Util.LoadImg( (VA.getCurrentView() == ImgA) ? ImgB : ImgA, file_img, file_icon );
		Cr.Iniciar();
		VA.showNext();
	}
}


/** El objetivo de esta clase es guardar la configuraci�n que personaliza el usuario al asociar im�genes y sonidos a
 * cada patr�n h�ptico */
class AsocFiles
{
	/** Nombre del fichero asociado al patr�n h�ptico (sin extensi�n, debe ser ivt)*/
	public String Hap;
	/** Nombre del fichero de imagen que se asocia al patr�n h�ptico (sin extensi�n, se asume png) */
	public String Img;
	/** Nombre del fichero de sonido que se asocia al patr�n h�ptico (sin extensi�n se asume mp3) */
	public String Snd;	
}

/** Guarda informaci�n que permite asociar im�genes, patrones h�pticos y autidivos a un control ImageView */
class HapticIcon{
	
	/** Control asociado a la imagen que se va a mostrar. Se debe usar uno u otro. */
	public ImageView Img;
	public Animador An;  // -> Permite animar el cambio de im�genes
	
	/** Guarda una cadena que coincide con el nombre del patron y de los ficheros (sin extensi�n) de la 
	 * descripci�n auditiva y de los iconos h�ptico y visual. */
	public String Name;
	
	/** Guarda el nombre del fichero de la carpeta assets que contiene el patr�n h�pico de vibraci�n */
	public String FileH = "";
	/** Guarda el nombre del fichero de la carpeta assets que contiene la imagen asociada a this */
	public String FileI = "";
	/** Guarda el nombre del fichero de la carpeta assets que contiene el sonido asociado a this */
	public String FileS = "";
	
	/* Booleano asociado al icono que permitir� implementar el comportamiento que se desee desde el
	 * exterior, por ejemplo dejar de atender pulsaciones sobre la imagen  */
	public boolean Enabled = true;
	
	/* A true cuando este el icono solo debe vibrar sin proporcionar informaci�n visual ni auditiva */
	public boolean SoloVibrar = false;
	
	/** Carga en Img el fichero de la carpeta assets "Name" */
	public void RefreshImg()
	{
		     if(  An != null ) An.LoadAndAnimImg( FileI,FileI);
		else if( Img != null ) Util.LoadImg( Img, FileI, FileI );
	}
	
	/** Carga el fichero png (sin extensi�n ni punto) que se pasa en png. El valor de Name no cambia. */
	public void LoadImg( String png, String icon)
	{
		if     (  An != null ) An.LoadAndAnimImg( png, icon);
		else if( Img != null ) Util.LoadImg( Img, png, icon);
	}
	
	/** Reproduce el fichero mp3 de nombre Name que se encuentre en la carpeta assets
	 *  Name ser� el nombre del fichero sin la extensi�n. */
	public void PlaySound()
	{
	   Util.PlaySound( FileS );
	}
	
	/** Reproduce el fichero de vibraci�n ivt de nombre Name que se encuentre en la carpeta assets
	 *  Name ser� el nombre del fichero sin la extensi�n. */
	public void Vibra()
	{
	   Util.uhl_PlayFile( FileH );
	}	
	
	public HapticIcon()
	{
		
	}	
}

/** Permite medir intervalos de tiempo */
class Crono {
	
	/** Guardar� el instante en el que comienza a contar el tiempo.
	 *  Cuando es null indica que el crono est� detenido. */
	private Date TIni;
	
	/** Contiene el n�mero de ms transcurridos desde la llamada a Iniciar
	 *   Es necesario llamar a Update para que se actualice. */
	public long T;
	
	/** Empieza a contabilizar el tiempo */
	public void Iniciar()
	{
		TIni = new Date();
		T = 0;
	}
	
	/** Para el cronometro */
	public void Detener()
	{
		Update();
		TIni = null;		
	}
	
	/** Devuelve true cuando el cron�metro est� detenido */
	public boolean Detenido()
	{
		return TIni == null;
	}
	
	/** Actualiza el tiempo: this.T y devuelve su valor */
	public long Update()
	{
		if( TIni != null )
			T = (new Date()).getTime() - TIni.getTime();
		else 
			T = 0;
		return T;
	}
	
	/* Devuelve una cadena en formato minutos:SS con SS = segundos */
	public String GetStr()
	{
		int sec = (int)(T / 1000); 
		int min = sec / 60;
		sec = sec % 60;
		
		return String.format( "%d:%02d", min, sec );
	}
}

/** Permite medir intervalos de tiempo */
class Crono_hilador {
	
	/** Guardar� el instante en el que comienza a contar el tiempo.
	 *  Cuando es null indica que el crono est� detenido. */
	private Date TIni;
	
	/** Contiene el n�mero de ms transcurridos desde la llamada a Iniciar
	 *   Es necesario llamar a Update para que se actualice. */
	public long T;
	
	/** Empieza a contabilizar el tiempo */
	public void Iniciar()
	{
		TIni = new Date();
		T = 0;
	}
	
	/** Para el cronometro */
	public void Detener()
	{
		Update();
		TIni = null;		
	}
	
	/** Devuelve true cuando el cron�metro est� detenido */
	public boolean Detenido()
	{
		return TIni == null;
	}
	
	/** Actualiza el tiempo: this.T y devuelve su valor */
	public long Update()
	{
		if( TIni != null )
			T = (new Date()).getTime() - TIni.getTime();
		else 
			T = 0;
		return T;
	}
	
	/* Devuelve una cadena en formato minutos:SS con SS = segundos */
	public String GetStr()
	{
		int sec = (int)(T / 1000); 
		int min = sec / 60;
		sec = sec % 60;
		
		return String.format( "%d:%02d", min, sec );
	}
}


/** Permite medir intervalos de tiempo */
class Crono_pantalla {
	
	/** Guardar� el instante en el que comienza a contar el tiempo.
	 *  Cuando es null indica que el crono est� detenido. */
	private Date TIni;
	
	/** Contiene el n�mero de ms transcurridos desde la llamada a Iniciar
	 *   Es necesario llamar a Update para que se actualice. */
	public long T;
	
	/** Empieza a contabilizar el tiempo */
	public void Iniciar()
	{
		TIni = new Date();
		T = 0;
	}
	
	/** Para el cronometro */
	public void Detener()
	{
		Update();
		TIni = null;		
	}
	
	/** Devuelve true cuando el cron�metro est� detenido */
	public boolean Detenido()
	{
		return TIni == null;
	}
	
	/** Actualiza el tiempo: this.T y devuelve su valor */
	public long Update()
	{
		if( TIni != null )
			T = (new Date()).getTime() - TIni.getTime();
		else 
			T = 0;
		return T;
	}
	
	
	
	/* Devuelve una cadena en formato minutos:SS con SS = segundos */
	public String GetStr()
	{
		int sec = (int)(T / 1000); 
		int min = sec / 60;
		sec = sec % 60;
		
		return String.format( "%d:%02d", min, sec );
	}
}

class Crono_nombrar {
	
	/** Guardar� el instante en el que comienza a contar el tiempo.
	 *  Cuando es null indica que el crono est� detenido. */
	private Date TIni;
	
	/** Contiene el n�mero de ms transcurridos desde la llamada a Iniciar
	 *   Es necesario llamar a Update para que se actualice. */
	public long T;
	
	/** Empieza a contabilizar el tiempo */
	public void Iniciar()
	{
		TIni = new Date();
		T = 0;
	}
	
	/** Para el cronometro */
	public void Detener()
	{
		Update();
		TIni = null;		
	}
	
	/** Devuelve true cuando el cron�metro est� detenido */
	public boolean Detenido()
	{
		return TIni == null;
	}
	
	/** Actualiza el tiempo: this.T y devuelve su valor */
	public long Update()
	{
		if( TIni != null )
			T = (new Date()).getTime() - TIni.getTime();
		else 
			T = 0;
		return T;
	}
	
	
	
	/* Devuelve una cadena en formato minutos:SS con SS = segundos */
	public String GetStr()
	{
		int sec = (int)(T / 1000); 
		int min = sec / 60;
		sec = sec % 60;
		
		return String.format( "%d:%02d", min, sec );
	}
}

class Crono_espera {
	
	/** Guardar� el instante en el que comienza a contar el tiempo.
	 *  Cuando es null indica que el crono est� detenido. */
	private Date TIni;
	
	/** Contiene el n�mero de ms transcurridos desde la llamada a Iniciar
	 *   Es necesario llamar a Update para que se actualice. */
	public long T;
	
	/** Empieza a contabilizar el tiempo */
	public void Iniciar()
	{
		TIni = new Date();
		T = 0;
	}
	
	/** Para el cronometro */
	public void Detener()
	{
		Update();
		TIni = null;		
	}
	
	/** Devuelve true cuando el cron�metro est� detenido */
	public boolean Detenido()
	{
		return TIni == null;
	}
	
	/** Actualiza el tiempo: this.T y devuelve su valor */
	public long Update()
	{
		if( TIni != null )
			T = (new Date()).getTime() - TIni.getTime();
		else 
			T = 0;
		return T;
	}
	
	
	
	/* Devuelve una cadena en formato minutos:SS con SS = segundos */
	public String GetStr()
	{
		int sec = (int)(T / 1000); 
		int min = sec / 60;
		sec = sec % 60;
		
		return String.format( "%d:%02d", min, sec );
	}
}
/** Implementa variables y m�todos est�ticos con utilidades que se pueden usar desde otras Activities
 * sin crear instancias de la clase.*/
public class Util {
	
	/** Define los distintos modos de funcionamiento de la aplicaci�n */
	public enum ModoFunc { ESTANDAR, SHORT, DIY};
	/** Contiene el modo actual de funcionamiento de la aplicaci�n */
	public static ModoFunc MF = ModoFunc.ESTANDAR;
	
	/** Guarda el nombre de la aplicaci�n */
	public static String ApplicationName;
	
	/** Contiene el nombre del icono por defecto */
	public static String DefIcon;
	/** Contiene el nombre del icono por defecto que se asocia a los iconos descubiertos en los que solo se reproduce vibraci�n */
	public static String DefHapticIcon;
	/** Contiene el nombre del icono por defecto que se asocia a los iconos cubiertos en los que solo se reproduce vibraci�n */
	public static String DefHapticIconDisabled;
	
	/** Es el n�mero m�nimo de p�xeles horizontales que hay que deslizar el dedo para iniciar
	 * una operaci�n de cambio de pantalla.  */
	public static float UmbralScreenSlide = 200;
	
	/** A true cuando se debe usar la descripci�n visual */
	public static boolean InfoVisual = true;
	
	/** A true cuando se debe usar la descripci�n auditiva */
	public static boolean InfoAuditiva = true;
	
	/** Cuando es true se mostrar� el tiempo transcurrido desde que se inicia la fase */
	public static boolean MostrarTiempo;	
	
	/** Si es true se mostrar�n cuadros de di�logo al usuario */
	public static boolean MostrarMensajes = true;
	
	/** A true si el dispositivo debe vibrar al detectar un click en alg�n control de usuario */
	public static boolean VibrarOnClick = true;
	
	/** Ancho de la pantalla en p�xeles */
	public static int ScreenWidth;
	/** Alto de la pantalla en p�xeles */
	public static int ScreenHeight;
	
	/** Si es true se diferenciar�n los iconos h�pticos de los no h�pticos a la hora de hacer
	 * parejas. Se considerar�n iconos h�pticos los ubicados en la mitad superior de la pantalla. */
	public static boolean DiferIconosHapt = true;	
	
	/** Esta variable permitir� el acceso a todos los ficheros contenidos en la carpeta assets */
	public static AssetManager AM = null;	
	
	/** Contiene la configuraci�n de la aplicaci�n */
	public static Properties Conf = null;

	/** Es una instancia com�n de la clase Crono resulta �til porque se usa desde distintas clases,
	 * T�picamente la rutina de atenci�n a un bot�n es una clase distinta de la activity. Y desde esa
	 * clase no se ven las propiedades de la activity. */
	public static Crono Cr = new Crono();
	
	public static Crono_pantalla Cr_p= new Crono_pantalla();
	
	
	public static Crono_hilador Cr_h= new Crono_hilador();
	
	public static Crono_hilador Cr_c= new Crono_hilador();
	
	public static Crono_nombrar Cr_n= new  Crono_nombrar();
	
	public static Crono_espera Cr_es= new  Crono_espera();
	
	
	/** Player que se usar� para reproducir sonidos */
	private static MediaPlayer player;
	
	/** Instancia del dispositivo h�ptico que permitir� controlar la vibraci�n del m�vil */
	private static Device uhl_Device = null;
	
	/** �ndice del efecto de la librer�a de Immersi�n que se asociar� a los click sobre controles de usuario. */
	public static final int ulh_IndexForClickEffect = 13;
	
	/** Haptic Launcher -> Reproduce patrones de vibraci�n */
	private static Launcher uhl_Player;
	
	/** Guarda el nombre del �ltimo fichero cargado en uhl_IVT_Buffer */
	private static String uhl_LastLoadedFile; 
	
	/** Buffer que contiene el �ltimo efecto cargado con uhl PlayFile */
	private static IVTBuffer uhl_IVT_Buffer;
	
	/** Tama�o del buffer que se usa para leer ficheros IVT */
	private static byte uhl_ByteBuffer[];
	
	/** M�ximo tama�o de fichero IVT que se puede cargar */
	private static int uhl_MaxIVT_FileSize = 51200;

	/** Guarda el conjunto de asociaciones que hace el usuario entre patrones h�pticos e im�genes o sonidos */
	public static AsocFiles UserConf[] = null;
	
	/** Convierte String a entero */
	public static int StrToInt( String str )
	{
		return Integer.parseInt( str );
	}
	
	/** Convierte entero a String */
	public static String IntToStr( int v )
	{
		return Integer.toString( v );
	}
	
	/** Convierte un double a String */
	public static String DoubleToStr( double v )
	{	
		return String.format("%.3f", v );
	}
	
	/** Recibe un valor de un modo de funcionamiento y devuelve la cadena correspondiente */
	public static String ModoFuncToStr( ModoFunc m )
	{
		     if( m == ModoFunc.ESTANDAR ) return "Est�ndar"; 
		else if( m == ModoFunc.SHORT    ) return "Short";
		else if( m == ModoFunc.DIY      ) return "DIY";
	    return "";
	}
	
	
	/** Recibe un valor de un modo de funcionamiento y devuelve el entero correspondiente */
	public static int ModoFuncToInt( ModoFunc m )
	{
		     if( m == ModoFunc.ESTANDAR ) return 0; 
		else if( m == ModoFunc.SHORT    ) return 1;
		else if( m == ModoFunc.DIY      ) return 2;
	    return -1;
	}
	/** Recibe un valor entero y devuelve el modo de funcionamiento correspondiente */	
	public static ModoFunc IntToModoFunc(int m)
	{
		switch( m )
		{
		   case 0: return ModoFunc.ESTANDAR; // break;
		   case 1: return ModoFunc.SHORT   ; // break;
		   case 2: return ModoFunc.DIY     ; // break;		
		}
	    return ModoFunc.ESTANDAR; 		
	}
	
	
	/** Carga la configuraci�n del fichero local de la aplicaci�n.
	 *   Desde el exterior de la clase llamar a LoadConf  */
	static private void LoadInternalStorageConf( Activity act ) 
	{
   		try 
   		{
   			InputStream fileStream = act.openFileInput(  act.getString( R.string.config_file ) );   			   			
   			Conf.load( fileStream );
   			fileStream.close();
   			
   			InfoVisual      = GetConfBool( "InfoVisual"      );
   			InfoAuditiva    = GetConfBool( "InfoAuditiva"    );
   			MostrarTiempo   = GetConfBool( "MostrarTiempo"   );		
   			MostrarMensajes = GetConfBool( "MostrarMensajes" );   			
   			DiferIconosHapt = GetConfBool( "DiferIconosHapt" );
   			VibrarOnClick   = GetConfBool( "VibrarOnClick"   );
   			MF              = IntToModoFunc( GetConfInt ( "ModoDeFuncionamiento" ) );        
   		} 
   		catch (Exception e) 
   		{
   			Log( "Error al cargar la configuraci�n: " + act.getString( R.string.config_file ) + " (" + e.getMessage() + ")" );
   		}
	}
	
	/** Carga la configuraci�n por defecto de la aplicaci�n (la que se encuentra en la carpeta assets) */
	public static void LoadConf_DefaultValues( Activity act )
	{
		try
		{
			String fileName = act.getString( R.string.config_file );
			
			InputStream       in = act.getAssets().open( fileName );
			FileOutputStream out = act.openFileOutput( fileName, Context.MODE_PRIVATE);
			
			// Copiamos el fichero
		    byte[] buf = new byte[1024];
		    int len;
		    while ((len = in.read(buf)) > 0) {
		        out.write(buf, 0, len);
		    }
		    
	       in.close();
	       out.flush();
	       out.close();
	       in = null;
	       out = null;
	       
			LoadInternalStorageConf( act );
			
			SetConfBool( "PrimeraEjecucion", false );
			
			SaveConf( act );
    	}   			
   		catch (Exception e) 
   		{
   			Log( "Error al cargar la configuraci�n: " + act.getString( R.string.config_file) + " (" + e.getMessage() + ")" );
   		}
	}
	
	/** Carga las propiedades del fichero de configuraci�n en this.Conf. */
    public static void LoadConf( Activity act ) 
    {
    	// Existe el siguiente problema:
    	// El fichero de configuraci�n que se dise�a en el PC se guarda en la carpeta assets que se empaqueta
    	// en un solo fichero en el m�vil por tanto solo se puede leer ese fichero de configuraci�n y no se
    	// puede escribir.
    	//    Para tener un fichero de lectura/escritura para guardar la configuraci�n de la aplicaci�n se 
    	// copiar� en la primera ejecuci�n desde el PC el fichero de configuraci�n de la carpeta assets al
    	// internal storage y luego se usar� este fichero para leer y guardar la configuraci�n de la aplicaci�n.
    	
    	Conf = new Properties();    	
    	
    	LoadInternalStorageConf( act );
    	
    	if( GetConfBool( "PrimeraEjecucion" ) )
    	{
    		LoadConf_DefaultValues( act );
    	}
    	
    	DisplayMetrics displaymetrics = new DisplayMetrics();
    	act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    	ScreenHeight = displaymetrics.heightPixels;
    	ScreenWidth  = displaymetrics.widthPixels;
    	UmbralScreenSlide  = displaymetrics.widthPixels / 4;
    }
    
	/** Salva las propiedades del fichero de configuraci�n a disco. */
    public static void SaveConf( Activity act ) 
    {    	
    	if( Conf == null || act == null )
    		return;
    	
   		try 
   		{
   			SetConfBool( "InfoVisual"     , InfoVisual      );      
   			SetConfBool( "InfoAuditiva"   , InfoAuditiva    );   
   			SetConfBool( "MostrarTiempo"  , MostrarTiempo   );  		
   			SetConfBool( "MostrarMensajes", MostrarMensajes );
   			SetConfBool( "DiferIconosHapt", DiferIconosHapt );
   			SetConfBool( "VibrarOnClick"  , VibrarOnClick   );   			
   			SetConfInt ( "ModoDeFuncionamiento", ModoFuncToInt( MF ) );
   			SetConfBool( "PrimeraEjecucion", false );
   			
   			
   			Conf.store( act.openFileOutput( act.getString( R.string.config_file ), Context.MODE_PRIVATE ), null);
   		} 
   		catch (Exception e) {
   			Log( "Error al salvar la configuraci�n: " + act.getString( R.string.config_file ) + " (" + e.getMessage() + ")" );
   		}
    }
    
	/** Devuelve el entero asociado a la clave que se pasa del fichero de configuraci�n */
	public static int GetConfInt( String key )	
	{
		String s = Conf.getProperty( key );
		return (s == null) ? 0 : StrToInt( s.trim() );
	}
	
	/** Devuelve la cadena asociada a la clave que se pasa del fichero de configuraci�n */
	public static String GetConfSrt( String key )
	{
		String s = Conf.getProperty( key );
		return (s == null) ? null : s.trim();
	}	
	
	/** Devuelve el booleano asociado a la clave que se pasa del fichero de configuraci�n */
	public static boolean GetConfBool( String key )
	{
		String s = Conf.getProperty( key );
		if( s == null )
			return false;
		
		s = s.trim().toUpperCase();
	
		return s.equals( "S" ) || s.equals( "SI" ) || s.equals( "Y" ) || s.equals( "YES" );		
	}
	
	/** Guarda en la configuraci�n el valor v asociado a la clave key */
	public static void SetConfInt( String key, int v )	
	{
		Conf.setProperty( key, IntToStr(v) );
	}
	
	/** Guarda en la configuraci�n el valor v asociado a la clave key */
	public static void SetConfSrt( String key, String v )
	{
		Conf.setProperty( key, v );
	}	
	
	/** Guarda en la configuraci�n el valor v asociado a la clave key */
	public static void SetConfBool( String key, boolean v )
	{
		Conf.setProperty( key, v ? "si" : "No" );
	}
	
	/** Permitir� ahorrar tiempo y memoria al implementar una cach� con los bitmaps utilizados */
	private static CacheBitmap CBM = new CacheBitmap();
	
	/** Carga en img la imagen asociada al fichero file de la carpeta assets 
	 *  File se debe pasar sin extensi�n */
	public static void LoadImg( ImageView img, String file_img, String file_icon)
	{		
	    try 
	    {
			img.setImageBitmap( CBM.Get( file_img ) );
			img.setContentDescription(file_icon);   // Para locuci�n funcionanado talkback
	    } 
	    catch (Exception e) 
	    {
	    	Log( e.getMessage() );
	    }
	}
	
	/** Espera a que acabe el sonido que se est� reproduciendo actualmente */
	public static void WaitSoundForFinish()
	{
        try {
        	while( player != null && player.isPlaying() )
               Thread.sleep(200);

        } catch (InterruptedException e) {
        	Log( e.getMessage() );
        }		
	}
	
	/** Si se est� reproduciendo alg�n sonido debido a una llamada a PlaySound, 
	 *   se detiene la reproducci�n. */
	public static void StopSound( ){

		if ( player != null && player.isPlaying() ){
			player.stop();
			player.release();
			player = null;			
        }
	}
	
	
	/** Recibe un fichero que debe estar en la carpeta assets y lo reproduce. 
	 *  Si hab�a algo reproduci�ndose se detiene la reproducci�n y comienza la nueva.
	 *  El fichero se pasa sin la extensi�n (se a�adir� ".mp3") */
	public static void PlaySound( String file ) {
	    try {
	    	StopSound( );
	    	
	    /*	if( !InfoAuditiva  )
	    		StopSound();
	    	
	    	if( !InfoAuditiva )
	    		return;*/
	    	
	    	file = file + ".mp3";
	    	
	    	player = new MediaPlayer();

	        AssetFileDescriptor descriptor = AM.openFd( file );
	        player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
	        descriptor.close();

	        player.prepare();
	        // El "volumen multimedia" que se ajusta en el m�vil prevalece frente a esta llamada:
	        player.setVolume(1f, 1f); 
	        player.setLooping( false );
	        player.start();
	    } catch (Exception e) {
	    	Log( e.getMessage() );
	    }
	}
	
	/** Libera los recursos asociados al player */
	public static void ReleasePlayer()
	{
		if ( player.isPlaying() ){
			player.stop();
		}
		player.release();
		player = null;		
	}
	
	/** Reproduce el sonido asociado a la pulsaci�n del bot�n siguiente */
	public static void PlaySoundSiguiente(){		
		PlaySound( "siguiente" );
		WaitSoundForFinish();
	}
	
	/** Reproduce el sonido asociado a la pulsaci�n del bot�n anterior*/
	public static void PlaySoundAnterior(){		
		PlaySound( "anterior" );
		WaitSoundForFinish();
	}
	
	/** Escribe una l�nea en blanco en el fichero de log. */
	public static void LogWrLn( )
	{
		Util.Log( "");
	}
	
	/** Escribe una l�nea en blanco en el fichero de excel. */
	public static void LogWrLn_excel( )
	{
		Util.Log_Excel( "");
	}
	/** A�ade al fichero de log la cadena pasada */
	public static void Log( String text)
	{    
	   File logFile = new File( Environment.getExternalStorageDirectory(), Util.ApplicationName + ".txt" );
	   if (!logFile.exists())
	   {
	      try
	      {
	         logFile.createNewFile();
	      } 
	      catch (IOException e)
	      {
	    	  Log( e.getMessage() );
	      }
	   }
	   try
	   {
		   String dateTimeStr;
		   // if( useTime )
		   {
			   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			   java.util.Date date   = new java.util.Date();
			   dateTimeStr = dateFormat.format(date) + " ";
		   }
           
		   BufferedWriter buf = new BufferedWriter(new FileWriter( logFile, true )); 
		   buf.append( dateTimeStr + text + "\r" );
		   buf.newLine();
		   buf.close();
		   buf = null;
	   }
	   catch (IOException e)
	   {
		   Log( e.getMessage() );
	   }
	}
	
	
	public static void Log_Excel( String text)
	{    
	   File logFile = new File( Environment.getExternalStorageDirectory(), Util.ApplicationName +  "_exel.txt" );
	   if (!logFile.exists())
	   {
	      try
	      {
	         logFile.createNewFile();
	      } 
	      catch (IOException e)
	      {
	    	  Log( e.getMessage() );
	      }
	   }
	   try
	   {
		   String dateTimeStr;
		   // if( useTime )
		   {
			   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			   java.util.Date date   = new java.util.Date();
			   dateTimeStr = dateFormat.format(date) + " ";
		   }
           
		   BufferedWriter buf = new BufferedWriter(new FileWriter( logFile, true )); 
		   buf.append( text + "\r" );
		  /* buf.newLine();*/
		   buf.close();
		   buf = null;
	   }
	   catch (IOException e)
	   {
		   Log( e.getMessage() );
	   }
	}
	
	public static void Log_Excel_nl()
	{    
	   File logFile = new File( Environment.getExternalStorageDirectory(), Util.ApplicationName +  "_exel.txt" );
	   if (!logFile.exists())
	   {
	      try
	      {
	         logFile.createNewFile();
	      } 
	      catch (IOException e)
	      {
	    	  Log( e.getMessage() );
	      }
	   }
	   try
	   {
		   String dateTimeStr;
		   // if( useTime )
		   {
			   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			   java.util.Date date   = new java.util.Date();
			   dateTimeStr = dateFormat.format(date) + " ";
		   }
           
		   BufferedWriter buf = new BufferedWriter(new FileWriter( logFile, true )); 
		   buf.append( "\r" );
		   buf.newLine();
		   buf.close();
		   buf = null;
	   }
	   catch (IOException e)
	   {
		   Log( e.getMessage() );
	   }
	}
	
	
	
	 public static void Load_config()
		
		{
			 File logFile = new File( Environment.getExternalStorageDirectory(), Util.ApplicationName +  "_conf.txt" );
			   if (!logFile.exists())
			   {
			      try
			      {
			         logFile.createNewFile();
			      } 
			      catch (IOException e)
			      {
			    	  Log( e.getMessage() );
			      }
			   }else
			   {
			   try{     
				   BufferedReader fin = new BufferedReader( new FileReader(logFile)); 
				   String texto = fin.readLine();
				   fin.close(); }
			      catch (Exception ex) {     }
			   
			   }
		}
	
	/** Devuelve la instancia asociada al nombre del ID que se pasa */
	public static View GetViewFromIdName( Activity act, String idName )
	{
		int id = act.getResources().getIdentifier( idName, "id", act.getApplicationContext().getPackageName() );
		return act.findViewById(id); 
	}
	
	/** Devuelve la instancia asociada al nombre del ID que se pasa */
	public static ImageView GetImageViewFromIdName( Activity act, String idName )
	{
		int id = act.getResources().getIdentifier( idName, "id", act.getApplicationContext().getPackageName() );
		return (ImageView)act.findViewById(id); 
	}

	
	/** Inicializa la librer�a para la reproducci�n de patrones h�pticos.  */
	public static boolean uhl_Init(Activity act)
	{	
		if( uhl_Player != null )
			return false;
		
		try
		{
			uhl_Device = Device.newDevice( act.getApplicationContext(), 0);
			
			uhl_Player = new Launcher( act );
			
			uhl_MaxIVT_FileSize = GetConfInt( "max_ivt_file_size" );
			
			if( uhl_MaxIVT_FileSize > 0 )
			   uhl_ByteBuffer = new byte[ uhl_MaxIVT_FileSize ];			

			return true;
		}
		catch (RuntimeException e)
		{
			Log( e.getMessage() );
			return false;
		}
	}
	
	/** Reproduce el efecto que se pasa como par�metro de la librer�a de Immersion.  */
	public static boolean uhl_Play(int index )
	{
		try
		{
			uhl_Player.play( index );
			return true;
		}
		catch (RuntimeException e)
		{
			Log( e.getMessage() );
			return false;
		}	
	}
	
	/** Reproduce el efecto que se asocia a la pulsaci�n de un bot�n u opci�n de un control de usuario.
	 *  Cuando applyDelay sea true se har� un sleep de duraci�n aproximadamente igual a la vibraci�n. 
	 *  Esto facilitar� que se reproduzca a continuaci�n de una pulsaci�n otra vibraci�n  */
	public static void uhl_PlayClick( boolean applyDelay )
	{
		if( VibrarOnClick )
		{
		   uhl_Play( ulh_IndexForClickEffect );
			if( applyDelay )
				Util.Sleep(250);		   
		}
	}
	
	/** Reproduce el efecto que se asocia a la pulsaci�n de un bot�n u opci�n de un control de usuario. */
	public static void uhl_PlayClick(  )
	{
		uhl_PlayClick( false );		
	}
	
	/** Detiene la reproducci�n del patr�n de vibraci�n.  */
	public static void uhl_Stop()
	{
		try
		{
			//uhl_Player.stop();
			uhl_Device.stopAllPlayingEffects();
		}
		catch (RuntimeException e)
		{
			Log( e.getMessage() );
		}	
	}	
	
	/** Carga el contenido de f y reproduce el patr�n de vibraci�n. Se a�ade la extensi�n ivt */
	public static boolean uhl_PlayFile( String f )
	{
		String fileName = f + ".ivt";
		
		if( fileName != null && fileName.equals( uhl_LastLoadedFile) )
		{
			uhl_PlayBuffer();
			return true;
		}
		
		boolean ok = true;
		
		try {
			
			InputStream is = AM.open( fileName );
			
			int bytesLeidos = is.read( uhl_ByteBuffer, 0, uhl_MaxIVT_FileSize ); 
			
			if( bytesLeidos > 0 && bytesLeidos < uhl_MaxIVT_FileSize )
			{
				uhl_IVT_Buffer = new IVTBuffer( uhl_ByteBuffer );		    	   
				uhl_LastLoadedFile = fileName;
			}
			else
			{
				ok = false; // Fichero mayor que uhl_MaxIVT_FileSize
			}
		}
        catch (IOException ioe) {
            ok = false;
        }
		
		if ( ok )
		   uhl_PlayBuffer();
		return ok;
	}
	
	/** Reproduce la vibraci�n asociada al contenido de uhl_Buffer */
	public static void uhl_PlayBuffer()
	{
		if( uhl_Device == null || uhl_IVT_Buffer == null )
			return;
		
		uhl_Device.playIVTEffect( uhl_IVT_Buffer, 0 );
	}

	/** Busca en el array icons un objeto que tenga como propiedad Img, v. Si lo encuentra lo devuelve.*/
	public static HapticIcon GetHapticIconFromView( HapticIcon []icons, View v)
	{
		HapticIcon hi;
		for(int c=0; c < icons.length; c++ )
		{
			hi = icons[c];
			if( hi == null )
				continue;
		   if( hi.Img == v ) 
			   return hi;
		   
		   if( hi.An != null && ( v == hi.An.ImgA || v == hi.An.ImgB ) )
			   return hi;
		}
		return null;
	}
	
	/** Instancia que permite mostrar cuadros de di�logo con informaci�n al usuario */
	private static AlertDialog alertInfo;
	
	/** Inicializa el sistema que permite mostrar cuadros de di�logo al usuario. 
	 *  Es necesario hacerlo cada vez que se empieza a trabajar con una activiadad, por ejemplo
	 *  en el evento OnStart � en OnCreate y en OnRestart.
	 *  listener se puede pasar a null o se puede crear una funci�n para realizar alg�n procesado cuando
	 *  se pulsa el bot�n ok:
	 *     new android.content.DialogInterface.OnClickListener() {
	 *          @Override
	 *  	    public void onClick(DialogInterface dialog, int which) {
	 *				// c�digo para manejar el click en ok
	 *          }
     *      } );
	 *     */
	public static void DlgInfoInit( Activity act, android.content.DialogInterface.OnClickListener listener )
	{
		AlertDialog.Builder dlgBuilder = new AlertDialog.Builder( act );
		
		if( listener == null )
		{
			// Creamos un manejador por defecto que solo se encargue de producir vibraci�n.
			android.content.DialogInterface.OnClickListener dlgHandler = new android.content.DialogInterface.OnClickListener() {
		           @Override
				   public void onClick(DialogInterface dialog, int which) {	        	   
		        	   Util.uhl_PlayClick();
		           }
				};
			dlgBuilder.setPositiveButton( "OK", dlgHandler );
		}
		else		
		   dlgBuilder.setPositiveButton( "OK", listener );
	   
	    alertInfo = dlgBuilder.create();
	/*    alertInfo.setIcon( uma.diana.nn_ext.R.drawable.infob );*/
	}
	
	/** Muestra un cuadro de di�logo con un icono de informaci�n y el mensaje pasado.
	 *  Antes de llamar a esta funci�n es necesario llamar a DlgInfoInit  */
	public static void DlgInfoShow( String title, String msg )
	{
		alertInfo.setTitle ( title );
		alertInfo.setMessage( msg );
		alertInfo.show();		
	}
	
	/** Detiene la ejecuci�n durante ms ms */
	public static void Sleep( int ms )
	{
		try
		{  
			Thread.sleep( ms ); 
		} 
		catch(Exception ie)
		{	
		}        		
	}
	
	/** Busca en Util.UserConf un objeto AsocFiles que tenga como nombre hapticFile 
	 *  Si lo encuentra lo devuelve. En otro caso de vuelve null. */
	public static AsocFiles GetHapticIcon_AsocFiles( String hapticFile )
	{
		if( UserConf == null )
			return null;
		
		for(int c=0; c < UserConf.length; c++ )
		{
			if( UserConf[c] != null && UserConf[c].Hap == hapticFile )
				return UserConf[c];
		}
		return null;
	}
	
	/** Guarda en el log la configuraci�n actual */
    public static void ConfigToLog()
    {    
    	Log( "��������� Configuraci�n Actual:" );

    	Log( "   Modo de Funcionamiento: " + ModoFuncToStr( MF ) );
    	Log( "   Informaci�n Visual  :       " + ( InfoVisual      ? "Si" : "No" ) );    
        Log( "   Informaci�n Auditiva:       " + ( InfoAuditiva    ? "Si" : "No" ) );
        Log( "   Mostrar Tiempo:             " + ( MostrarTiempo   ? "Si" : "No" ) );
        Log( "   Mostrar Mensajes:           " + ( MostrarMensajes ? "Si" : "No" ) );
        Log( "   Vibrar con cada Click:      " + ( VibrarOnClick   ? "Si" : "No" ) );
        Log( "   Distinguir iconos h�pticos: " + ( VibrarOnClick   ? "Si" : "No" ) );
        
        LogWrLn();
    }
}

 