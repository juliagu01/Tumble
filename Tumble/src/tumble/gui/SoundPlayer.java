package tumble.gui;

/**
 * Represents the mechanism for playing sound. Is a utility class.
 * Credit to soundbible.com and themushroomkingdom.net/media/smw/wav for sound files.
 * @author Amanda Xu, Julia Gu
 * @version Jun. 27, 2021
 */
public class SoundPlayer {
	
	/**
	 * Sound constants.
	 */
	public static final int BOING = 0, SWOOSH = 1, CLINK = 2, TOOT = 3;
	
	private static boolean HAS_SOUND = true;
	private static Sound[] SOUNDS = new Sound[] {new Sound("/media/audio/jump.wav"), new Sound("/media/audio/boost.wav"), 
                                                 new Sound("/media/audio/powerup.wav"), new Sound("/media/audio/orb.wav")};

	/**
	 * Plays a sound.
	 * @param sound  sound to be played
	 */
	public static void playSound(int sound) {
		if (HAS_SOUND)
			SOUNDS[sound].play();
	}
	
	/**
	 * Toggles sound.
	 */
	public static void toggleSound() {
		HAS_SOUND = !HAS_SOUND;
	}
	
	/**
	 * Returns sound state.
	 * @return whether this player has sound
	 */
	public static boolean hasSound() {
		return HAS_SOUND;
	}

}