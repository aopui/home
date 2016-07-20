package com.test;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.Callback;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import java.io.IOException;
public class RNTestAudioModule extends ReactContextBaseJavaModule {
  ReactApplicationContext reactContext;
	MediaPlayer mp;
  public RNTestAudioModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
	mp=new MediaPlayer();
  }
  
  

  @Override
  public String getName() {
    return "TestAudio";
  }

  @ReactMethod
  public void play(String fileName) {
	  
	  System.out.println(fileName);
	  try
	  {
		mp.setDataSource(fileName);
	  }catch(IOException o)
	  {
		  //throw(o);
	  }
   
	
	mp.setOnPreparedListener(new OnPreparedListener() {
      @Override
      public void onPrepared(MediaPlayer player) {
		player.start();
		}
    });
	mp.prepareAsync();
	
    mp.setOnCompletionListener(new OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer mp) {
        mp.reset();
        mp.release();
        mp = null;
      }
    });

  
    //System.out.println("abcccccccccccc");
      // SoundPool soundPool;
       // soundPool= new SoundPool(10,AudioManager.STREAM_SYSTEM,5);
       // soundPool.load("http://192.168.56.1:3000/a.mp3",1);
		//soundPool.load(audio,1);
       // soundPool.load("/assets/www/a.mp3",1);
      //System.out.println("调用了#########################");
       // soundPool.play(1,1, 1, 0, 0, 1);
  }
  
  	

}
