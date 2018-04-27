package models;

import java.util.ArrayList;

public class Wave {
	public ArrayList<Enemy> _wave = new ArrayList<Enemy>();
	public Long waveBegins;
	public Long waveLength;
	public Long waveSize;
	
public Wave(ArrayList<Enemy> w, Long wB, Long wL) {
	_wave = w;
	waveBegins = wB;
	waveLength = wL;
	}
}
