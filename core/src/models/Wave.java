package models;

import java.util.ArrayList;

public class Wave {
	public ArrayList<Enemy> _wave = new ArrayList<Enemy>();
	public Float waveBegins;
	public Float waveLength;
	public Long waveSize;
	
public Wave(ArrayList<Enemy> w, Float wB, Float wL) {
	_wave = w;
	waveBegins = wB;
	waveLength = wL;
	}
}
