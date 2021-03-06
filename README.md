[![pipeline status](https://gitlab.com/Frostdown/PEBCAK/badges/master/pipeline.svg)](https://gitlab.com/Frostdown/PEBCAK/commits/master)
*Project Vision*
_Team 16_

We will be implementing a bullet hell shooter video game based on the Touhou project. The objective of the game is for the main character, controlled by the user, to advance through a 
series of game phases. In each game phase the player must dodge various types and numbers of enemy projectiles. To pass the game, the user must advance through all phases of the game 
without losing a predetermined number of lives. A score count will be tabulated for various actions, detailed below, as the player progresses through the game. If a player loses all their 
lives before completing all phases of the game, the player loses, and game play will terminate. At the end of game play, win or lose, the players final score will be compared to the top 
ten previous high scores of the game. The players final score and name will be recorded if their final score is a top ten score.

Gameplay will consist of the following different characters: Player/User character, Regular enemy grunts (A and B), Mid Boss, and a Final Boss enemy. The Player/User character is the 
player that the user controls.  The user character appears at the beginning at the bottom of the screen. A player character responds to keyboard input from the user and moves 
in the corresponding 8 directions[TS1] . Its movements are confined to the gameplay of the screen. The user will be able to switch between normal speed and slow speed as it dodges 
projectiles and moves through the game play. The player will also be able to fire projectiles to damage/eliminate enemy grunts and bosses using keyboard inputs. For every enemy the 
player hits, the user will accumulate points. 5 points for every enemy grunt, 10 points for every hit on the mid boss, and 20 points for every hit on the final boss. In addition, 
the user will receive 100 points and 200 points for eliminating the mid boss and final boss respectively. The player will start off with 10 lives. For every enemy projectile it gets 
hit by, the user will lose a life. If there are still lives left, the player respawns from the center bottom screen. It remains invincible for a few seconds after respawning. 
The screen is also cleared of all projectiles for a few seconds after respawning. In addition, the player will be able to gain power-ups and lives throughout gameplay. 
Power-ups will be placed randomly throughout gameplay. Power-ups include the following: disable grunts from shooting, protective shield for 5 seconds, and a plus 10 score to 
the point total. An extra life will be added after every 100 points accumulated. An extra 5 and 10 lives will be added if the player reaches the mid boss or final boss phase respectively.

The regular enemy grunts (A and B) will enter and exit the game play as the player progresses through the game. These characters shoot projectiles at the player. 
Enemy grunts A and B will have different types of projectile and movement formations. Projectiles shot by enemy grunts will stay on the gameplay screen until the 
player advances past them. In addition, if a regular enemy grunt is hit by a player projectile, that enemy grunt is eliminated from gameplay. Throughout the game when enemy grunts 
re-enter game play, after first exiting, any grunts previously eliminated will be respawned in the same wave formation.

The mid boss and final boss characters will enter game play during the mid boss attack phase and final boss attack phase of the game respectively. Like the enemy grunts, the mid boss and 
final boss characters shoot projectiles at the player. These characters will have more elaborate projectile and movement formations than the enemy grunts. Projectiles shot by these 
characters will disappear as soon as they exit gameplay. In addition, these characters will have a health point (HP) value. If one of these characters is hit by a user projectile, their 
respective HP value will decrease by 10. If the HP value for either of these characters reaches 0, that character is eliminated from gameplay. The HP value of the final boss is 200 and 100 
for the mid boss.  The final boss will also have two different attack stages during the final attack boss phase. The second attack stage will be achieved if the user survives the 
initial 30 seconds of the final boss phase. The second attack stage will be more elaborate and difficult. This attack stage will remain until the final boss or player is eliminated.

Gameplay will consist of four phases: regular play phase, mid boss attack phase, another session of regular play phase, and finally a final boss attack phase. Regular play phase will consist 
of entries and exits of waves of regular type enemy grunts A and B. This phase will last approximately 30 seconds. Enemy waves of grunts will enter and exit after 10 seconds of gameplay. 
In this phase the grunts will shoot projectiles every 3 seconds. This will repeat until the first phase is completed. In the mid boss attack phase, the enemy grunts exit game play and 
the mid boss enters. This phase will last until either the mid boss or player is eliminated. The mid boss will shoot different types of projectiles and formations in intervals of 2 seconds. 
Another session of regular play phase will follow. This second session of regular play will also last approximately 30 seconds. The final boss attack phase will have two different attack stages. 
The first attack stage will last approximately 30 seconds. The second attack stage will remain until the final boss or player is eliminated. Game play ends when either the player loses 
all its lives, or the player passes the game. There will also be potentially be three different difficulty levels: Beginner, Moderate, and Expert. Each of these difficulties will differ 
in the movement speed of the enemies and their projectiles.

The game will have a start menu. In this menu, the player will be able select a difficulty level and start the game. In addition, the game will have a on screen menus containing pertinent 
game play information such as number of lives, current score, and mid/final boss HP values. There will also be a final menu that appears when the user runs out of lives or passes the game. 
In this menu, the user will be able to input their name, if they achieve a top ten score, select to replay, or exit the game.
