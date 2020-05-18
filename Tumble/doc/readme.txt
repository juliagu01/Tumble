Tumble (a game by VanillaChip)
Authors: Amanda Xu, Andra Liu, Julia Gu
Revision: May 17, 2020

Introduction: 
  Meet Tumble, a bright yellow ball determined to bring color and life to his quiet, gray world. As he bounces his way 
through this heartwarming metroidvania in search of the White Orb of Color, he finds friends in the most unexpected of 
places. 

Instructions:
  Click the play button on the start screen to begin a new game. Use the left and right arrows to move and the up arrow 
to jump. All other controls will be revealed during gameplay. A pause button will be provided, along with the option to 
restart if need be. 

Features List:
  A. must-have:
    1. start screen (done) - cover page with simple and intuitive design. Offers the option to start the game.
    2. detailed map (done) - one large, muted map that guides players through the game. Often leaves players with limited 
       directions of exploration to guide them towards the abilities and knowledge necessary to complete the game.
    3. working physics and collisions (done) - traditional platformer-style physics and collisions. No detracting bugs or 
       glitches.
    4. power-ups (done) - each grants the player a previously unknown ability. The player cannot make meaningful progress 
       without gaining these colorful items in an order laid out by the map.
    5. messages (done) - moves the story forward. Used sparingly. Displayed when players find new power-ups. 
  B. want-to-have:
    1. sound - sets a quiet mood, with bright sound effects as contrast. Sound effects play when the player jumps, uses 
       an ability, or finds a power-up. Provides a mute option on the start screen and during gameplay.
    2. save slots - saves the current state of the game at checkpoints to be reloaded at a later time. Allows for up to 
       three separate slots. Colorful flags act as checkpoints during gameplay. 
    3. sprite animation - change to Tumble's shape during gameplay. Can include breathing animation when player is at 
       rest, bounce animations and particle systems during platform collisions, and a visual representation of 
       power-ups as they are being used.
    4. parallax background - background that shifts as players move to different areas of the map. Adds a sense of 
       perspective. 
    5. pause screen (done) - simple screen that appears when player pauses the game. Provides the option to continue or exit 
       the game. 
  C. stretch:
    1. complete post-game - a continuation of Tumble's adventures, with all of his newfound abilities and a colored 
       map. 
    2. hidden areas - areas of the map for added exploration. Can include small puzzles or additional messages. 
    3. interactive credits - a colorful map made from the names in the game's credits.

Class List:
  game
    items
      Leaf - the power-up that increases Tumble's horizontal velocity
      Feather - the power-up that increases the height of Tumble's jumps
      Stick - the power-up that helps Tumble pass through vines
      Straw - the power-up that gives Tumble boosts
      Kite - the power-up that allows Tumble to glide in air
      Orb - the White Orb of Color
    Game - facilitates how elements interact during the game
    Map - the map that Tumble can explore
    MovableRectangle - the hitbox for all movable objects
    Player - Tumble, a physics object with platform collision
    Platform - a platform that Tumble can collide with
    Vine - a patch of vines that Tumble can interact with
    Item (abstract) - the blueprint for all power-ups
    Camera - the area of the map shown to players at a given moment
  gui
    buttons
      PlayButton - a button that directs players to the game screen
      PauseButton - a button that directs players to the pause screen
      RestartButton - a button that directs players to a restarted game
      MuteButton - a button that toggles the game's volume (unused)
    screens
      StartScreen - the game's cover page
      GameScreen - the game's main screen
      PauseScreen - the game's pause screen
    Main - creates a window with an instance of the game
    DrawingSurface - the area in the window where the game is drawn
    KeyHandler (interface) - helps handle key-events
    ScreenSwitcher (interface) - helps switch screens
    Screen (abstract) - the blueprint for all screens in the game
    Button (abstract) - a circular button that can lead to other screens
    Message - a colored banner that helps move the story forward

Credits:
  Processing library - graphics
  Mr. Shelby's AnimationDemo project - relationships between Main, DrawingSurface, Player, and MovableRectangle
  Mr. Shelby's ScreenSwitching code - basic class structures of Screen and ScreenSwitcher
  an anonymous younger brother - being a phenomenal QA!

Responsibilities:
  Amanda - screens, map
  Andra - items, animations
  Julia - physics, design