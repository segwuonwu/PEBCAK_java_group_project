package Controllers;

import java.util.ArrayList;

import models.Enemy;
import models.ObjectManagerInterface;
import models.Wave;

public class WaveController implements WaveControllerInterface {

	private ObjectManagerInterface OM;
	float waveTimer;
	float spawnTimer;

	public WaveController(ObjectManagerInterface om) {
		OM = om;
		waveTimer = 0;
		spawnTimer = 0;
	}

	@Override
	public void update(float delta) {
		waveTimer += delta;
		spawnTimer += delta;

		ArrayList<Wave> W = OM.getWave();
		try {
			for (Wave current : W) {

				System.out.println("TIMER:" + current.waveBegins);

				if (current.waveBegins < waveTimer) {
					System.out.println("TIMER PASS");

					if (current.waveLength < spawnTimer) {
						spawnTimer = 0;
						Enemy e = current._wave.get(0);
						OM.addEnemy(e);
						current._wave.remove(0);
						System.out.println("ADD ENEMY");

						if (current._wave.isEmpty()) {
							OM.removeWave(current);
						}

					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

}
