import java.util.*;
import javax.swing.*;

public class MainProgram
{

    //Main Program
	public static ArrayList<String> objItem = new ArrayList<String>();
	public static ArrayList<Integer> objQuantity = new ArrayList<Integer>();
	public static ArrayList<Float> objPrice = new ArrayList<Float>();
	public static ArrayList<Float> objTotal = new ArrayList<Float>();
	public static ArrayList<String> objCups = new ArrayList<String>();
	public static ArrayList<String> objIngredients = new ArrayList<String>();
	public static ArrayList<Float> objIngrPrice = new ArrayList<Float>();

    public static ArrayList<Integer> objPercent = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                LoginPage frmLoginPage = new LoginPage();
	        frmLoginPage.setVisible(true);
            }
        });
    }
}
