
package lab9;

public class Score {
    static int scoreRight = 0, scoreLeft = 0;
    public static void setRightScore(String stringSetScore)
    {
        setRightScore(Integer.valueOf(stringSetScore));
    }
    public static void setRightScore(int setScore)
    {
        scoreRight += setScore;
    }
    public static void setLeftScore(String stringSetScore)
    {
        setLeftScore(Integer.valueOf(stringSetScore));
    }
    public static void setLeftScore(int setScore)
    {
        scoreLeft += setScore;
    }
    public static int getRightScore()
    {
        return scoreRight;
    }
    public static int getLeftScore()
    {
        return scoreLeft;
    }
    public static void resetScore()
    {
        scoreRight = 0;
        scoreLeft = 0;
    }
    
}
