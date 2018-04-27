package Controllers;

import java.io.File;
import java.util.logging.FileHandler;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

public class SoundController {
	
	Sound enemySound;
	Sound bulletSound;
	Sound CheatCode;
	Music backgroundTrack;
	Sound HealthDrink;
	int instance=0;
	
	private static SoundController sc  = new SoundController();
	
	private SoundController()
	{
		
		FileHandle f = new FileHandle("enemyDestroyBasic.wav");
		enemySound = Gdx.audio.newSound(f);
		FileHandle f2 = new FileHandle("lazergun.wav");
		bulletSound = Gdx.audio.newSound(f2);
		FileHandle f3 = new FileHandle("AirHorn.wav");
		CheatCode = Gdx.audio.newSound(f3);
		FileHandle f5 = new FileHandle("healthdrink.wav");
		HealthDrink = Gdx.audio.newSound(f5);
		FileHandle f4 = new FileHandle("nyanCat.mp3");
		backgroundTrack = Gdx.audio.newMusic(f4);
		instance++;
	}
	
	public static SoundController getSC()
	{
		
		return sc;
	}
	
	public void playenemyDestroy()
	{
		
		enemySound.play();
	}
	
	public void playBullet()
	{
		bulletSound.play();
	}
	
	public void playCheatCode()
	{
		CheatCode.play();
	}
	
	public void PlaySoundTrack()
	{
		backgroundTrack.setVolume(.2f);
		backgroundTrack.play();
	}
	
	public void PauseSoundTrack()
	{
		backgroundTrack.pause();
	}
	
	public void playHealth()
	{
		HealthDrink.play();
	}
}
