package model;

/**
 *  A class representing a User Story
 * @author Nichita Railean
 * @version 1.0 dec 3
 */

public class UserStory
{
  private String what;
  private String how;
  private String who;

  /**
   *  A 3 argument constructor creating an UserStory
   * @param what what
   * @param how how
   * @param who who
   *
   */

  public UserStory (String what, String how, String who ) {
    this.what = what;
    this.how = how;
    this.who = who;
  }

  /**
   * A one argument creting a User story
   * Setting why, who to an empty String
   * @param what what
   */

  public UserStory (String what){
    this.what = what;
    this.how = "";
    this.who = "";
  }

  /**
   * A method copying the UserStory
   * @return the copy named other
   */

  public UserStory copy(){
    UserStory other = new UserStory(what, how, who);
    return other;
  }
}

