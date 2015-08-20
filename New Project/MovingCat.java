/******************************************************************************
 * A <CODE>MovingCat</CODE> provides an ascii art cat that can be moved around
 * a small field in the command prompt using operations such as \a up() \a down()
 * \a left() \a right().
 *
 * To use this class, create an instance of moving cat.
 *
 * @version Jul 22, 2005
 ******************************************************************************/
public class MovingCat
{
  //region public attributes
  //! The movement in the x direction ( AKA moving left to right );
  public int DX = 8;

  //! The movement in the y direction ( AKA moving up and down );
  public int DY = 2;

  //endregion


  /**
   * Moving Cat class that handles the location of where he/she is on the screen.
   **/
  public MovingCat() {
    int intialPosition = 0;
    _leftPadding = creatPaddingString(intialPosition);
  }

  /**
   * Moves the cat left on the screen if it has space to move.  Prints cats new location to the command prompt.
   */
  public void left() {
    if( _leftPadding.length() > 0 ) {
      int newPosition = _leftPadding.length() - DX;

      _leftPadding = creatPaddingString(newPosition);
    }

    displayCat();
  }

  /**
   * Moves the cat right on the screen if it has space to move.  Prints cats new location to the command prompt.
   */
  public void right() {
    if( _leftPadding.length() < MAX_MOVEMENT_ON_RIGHT ) {
      int newPosition = _leftPadding.length() + DX;

      _leftPadding = creatPaddingString(newPosition);
    }

    displayCat();
  }

  /**
   * Moves the cat up on the screen if it has space to move.  Prints cats new location to the command prompt.
   */
  public void up() {
    if( _topPadding > 0 )
      _topPadding = _topPadding - DY;

    displayCat();
  }

  /**
   * Moves the cat down on the screen if it has space to move.  Prints cats new location to the command prompt.
   */
  public void down() {
    if( _topPadding <= MAX_MOVEMENT_GOING_DOWN )
      _topPadding = _topPadding + DY;

    displayCat();
  }

  /**
   * Prints the cats to the command prompt according to it's current position according to the
   * \a DX and \a DY attributes (the speed in the left/right, up/down).
   */
  public void displayCat() {
    System.out.flush();
    printHeader();

    //! Prints the top spacing to make cat appear to be going up and down
    for( int index = 0; index < _topPadding; index++ ) {
      System.out.println("| ");
    }

    //! Prints the cat with the padding
    System.out.println( "| " + _leftPadding + "   /\\_/\\  /\\");
    System.out.println( "| " +_leftPadding + "  / o o \\ \\ \\");
    System.out.println( "| " + _leftPadding + " /   Y   \\/ /");
    System.out.println( "| " +_leftPadding + "/         \\/");
    System.out.println( "| " + _leftPadding + "\\ | | | | /");
    System.out.println( "| " + _leftPadding + " `|_|-|_|'");

    //! Prints the remainder of the spots
    int remainderOfLines = MAX_MOVEMENT_GOING_DOWN - CAT_HEIGHT - _topPadding;
    for( int index = 0; index < remainderOfLines; index++ )
    {
      System.out.println("| ");
    }
  }

  /**
   * Creates the amount of padding needed to simulate the cat moving left or right.
   * @param size
   *        the amount of spaces needed to move left or right
   * @return  a string with the necessary amount of spaces of padding
   */
  private String creatPaddingString( final int size ) {
    return new String(new char[size]).replace('\0', ' ');
  }

  /**
   * Prints a string of '-' characters according to the maximum of movement the cat can go to the right
   */
  private void printHeader() {
    System.out.println( new String(new char[MAX_MOVEMENT_ON_RIGHT]).replace('\0', '-') );
  }

  //! This is a don't touch zone for things to work
  //region PRIVATE ATTRIBUTES
  //!  The amount of new lines printed to make the cat to appear to be going up and down
  private int _topPadding = 0;


  //!  The spacing on the left side of drawing the cat used in order to
  //! make the cat to appear to be moving left to right
  private String _leftPadding = "";

  final int MAX_MOVEMENT_ON_RIGHT = 30;
  final int MAX_MOVEMENT_GOING_DOWN = 10;
  final int CAT_HEIGHT = 6;
  //endregion

}