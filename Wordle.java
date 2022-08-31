import java.util.*;
import java.io.File;
public class Wordle
{
    static Scanner s = new Scanner(System.in);
    static int attempts = 0;
    public static void main(String[] args) throws Exception
    {
        File f = new File("C:\\Users\\sisso\\Desktop\\Codes\\Java\\Coding Fun\\WordList.txt");
        Scanner sc = new Scanner(f);
        String w = "";
        while (sc.hasNextLine())
        {
            w += sc.nextLine();
        }
        Words.setWords(w);
        String[] YourWordLetters = new String[5];
        String YourWord;
        Words wordle;
        String yn = "y";
        boolean done = false;
        boolean win = true;
        while (yn.equalsIgnoreCase("y"))
        {
            System.out.print('\u000C');
            System.out.println("Welcome to wordle!");
            wordle = new Words();
            done = false;
            while (!done)
            {
                YourWord = enterWord(YourWordLetters);
                int[] b = score(YourWordLetters, wordle.getLetters());
                print(b);
                done = success(b);
                if (attempts > 4)
                {
                    win = false;
                    break;
                }
                else
                    win = true;
            }
            if (win)
                System.out.println("It took you "+attempts+" to get the right answer");
            else
            {
                System.out.println("You failed to find the right answer, F");
                System.out.println("The word was:" + wordle.getWord());
                
            }
            attempts = 0;
            System.out.println("Would you like to play again? (y/n)");
            yn = s.nextLine();
        }
    }
    public static String enterWord(String[] arr)
    {
        if (attempts == 0)
            System.out.println("Enter a 5 letter word:");
        String W = s.nextLine();
        while (W.length() != 5)
        {
            if (W.equals("cancel program"))
            {
                System.exit(0);
            }
            System.out.println("That word is not 5 letters long: ");
            W = s.nextLine();
        }
        for (int i =0; i< 5; i++)
        {
            arr[i] = W.substring(i,i+1);
        }
        attempts++;
        return W;
    }
    public static int[] score(String[] arr, String[] word)
    {
        int[] b = new int[5];
        for (int i = 0; i<5; i++)
        {
            for (int j = 0; j<5; j++)
            {
                b[i] = 3;
                if (i==j && arr[i].equalsIgnoreCase(word[j]))
                {
                    b[i] = 1; //It's in the right spot
                    break;
                }
                else if(arr[i].equalsIgnoreCase(word[j]))
                {
                    b[i] = 2; //It exists
                    break;
                }
            }
        }
        return b;
    }
    public static void print(int[] a)
    {
        for (int i = 0; i < 5; i++)
        {
            if (a[i] == 1)
                System.out.print("O");
            else if(a[i] == 2)
                System.out.print("-");
            else if(a[i] == 3)
                System.out.print("X");
            else
                System.out.print("?");
        }
        System.out.println("");
    }
    public static void print(String[] a)
    {
        for (String W: a)
        {
            System.out.print(W);
        }
        System.out.println("");
    }
    public static boolean success(int[] arr)
    {
        for (int x: arr)
        {
            if (x != 1)
            {
                return false;
            }
        }
        return true;
    }
}
