import java.util.*;
import java.io.File;
public class Words
{
    private static String words;
    private String word;
    private String[] letters = new String[5];
    public Words()
    {
        int x = (int)(Math.random()*words.length()-5)/5*5;
        word = words.substring(x,x+5);
        for (int i = 0; i<5; i++)
        {
            letters[i] = word.substring(i,i+1);
        }
    }
    public String getWord()
    {
        return word;
    }
    public String[] getLetters()
    {
        return letters;
    }
    public String getWords()
    {
        return words;
    }
    public static void setWords(String s)
    {
        words = s;
    }
}
