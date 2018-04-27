package models;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class EnemyFinalBoss extends Enemy {

	float timer;
	boolean one;
	boolean two;

	public EnemyFinalBoss(String movementType, String BulletType, String BulletMovement) {
		// hard coded test enemy
		// add unique functionality to this class as well
		super("EnemyFinalBoss", 50, BulletType, BulletMovement);
		movement = mFac.Create(movementType, new Texture("hitlermega.png"), 300, 500, -5f);
		timer = 0;
		one = false;
		two = false;
	}

	@Override
	public boolean bosstimer(float delta) {
		timer += delta;
		if (timer > 80)
			return true;
		return false;
	}

	private void extraBossStuff() {
		this.movement = mFac.Create("zigzag", new Texture("minion.jpg"), movement.sprite.getX(), movement.sprite.getY(), -5f);
	}

	private void extraBossStuff2() {
		this.movement = mFac.Create("stationary", new Texture("cat.jpg"), 300, 500, -5f);
	}

	@Override
	public ArrayList<Bullet> shoot(float delta) {
		
		timer += delta;
		try {
		if (timer > 10 && one == false) {
			extraBossStuff();
			one = true;
		}
		if (timer > 20 && two == false) {
			extraBossStuff2();
			two = true;
		}
		}catch (Exception e) {
		}
		
		
		
		ArrayList<Bullet> b = new ArrayList<Bullet>();
		Bullet newBullet = null;
		lastShot += delta;
		if ((lastShot - delta) >= 2f) {
			newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() - 10,
					this.movement.sprite.getY() - 20, -100f);
			if(newBullet != null)
				b.add(newBullet);
		}

		if ((lastShot - delta) >= 2f) {
			newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX(),
					this.movement.sprite.getY() - 20, -100f);
			if(newBullet != null)
				b.add(newBullet);
			if (timer > 7) {
				if ((lastShot - delta) >= 2f) {
					newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 40,
							this.movement.sprite.getY() - 20, -100f);
					if(newBullet != null)
						b.add(newBullet);
				}

				if ((lastShot - delta) >= 2f) {
					newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 20,
							this.movement.sprite.getY() - 20, -100f);
					if(newBullet != null)
						b.add(newBullet);
				}
				if (timer > 20) {
					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create("zigzag", "bulletA", this.movement.sprite.getX() + 40,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}

					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create("zigzag", "bulletB", this.movement.sprite.getX() + 100,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}
					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create("zigzag", "bulletA", this.movement.sprite.getX() + 150,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}

					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create("zigzag", "bulletB", this.movement.sprite.getX() + 175,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}
					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create("zigzag", "bulletA", this.movement.sprite.getX() + 250,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}

					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 100,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}
					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 110,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}

					if ((lastShot - delta) >= 2f) {
						newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 20,
								this.movement.sprite.getY() - 20, -100f);
						if(newBullet != null)
							b.add(newBullet);
					}
				}

			}
			if (timer > 14) {
				if ((lastShot - delta) >= 2f) {
					newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 30,
							this.movement.sprite.getY() - 20, -100f);
					if(newBullet != null)
						b.add(newBullet);
				}

				if ((lastShot - delta) >= 2f) {
					newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 50,
							this.movement.sprite.getY() - 20, -100f);
					if(newBullet != null)
						b.add(newBullet);
				}

			}

		}

		if ((lastShot - delta) >= 2f) {
			newBullet = bFac.Create(getBulletMovement(), getBulletType(), this.movement.sprite.getX() + 17,
					this.movement.sprite.getY() - 20, -100f);
			if(newBullet != null)
				b.add(newBullet);
			lastShot = 0;
		}

				return b;
	}
}
