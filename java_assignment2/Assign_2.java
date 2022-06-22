package java_assignment2;

import java.io.*;
import java.util.ArrayList;



/* file1 - file2 = file3*/
public class Assign_2 {
	public static void main(String args[]) throws FileNotFoundException, IOException
	{
		String file1="C:\\Users\\surhari\\OneDrive - Capgemini\\eclipse-workspace\\java_batch3\\src\\java_assignment2\\File1.csv";
		String file2="C:\\Users\\surhari\\OneDrive - Capgemini\\eclipse-workspace\\java_batch3\\src\\java_assignment2\\File2.csv";
		String file3="C:\\Users\\surhari\\OneDrive - Capgemini\\eclipse-workspace\\java_batch3\\src\\java_assignment2\\Result.csv";
		ArrayList al1=new ArrayList();
		ArrayList al3=new ArrayList();
		ArrayList al2=new ArrayList();
		BufferedReader CSVFile1 = new BufferedReader(new FileReader(file1));
		String dataRow1 = CSVFile1.readLine();
		
		while (dataRow1 != null)
		{
			String[] dataArray1 = dataRow1.split(",");
			for (String item1:dataArray1)
			{
				al1.add(item1);
				al3.add(item1);
			}
			dataRow1 = CSVFile1.readLine(); // Read next line of data.
		}

		BufferedReader CSVFile2 = new BufferedReader(new FileReader(file2));
		String dataRow2 = CSVFile2.readLine();
	
		while (dataRow2 != null)
		{
			String[] dataArray2 = dataRow2.split(",");
			for (String item2:dataArray2)
			{
				al2.add(item2);
			}
			dataRow2 = CSVFile2.readLine(); // Read next line of data.
		}
		//System.out.println(al3);
		//System.out.println(al2);
		for(Object bs: al2)
		{
			al1.remove(bs);
		}
		
		for(Object bs: al3)
		{
			al2.remove(bs);
		}
		
		
		for(Object bs: al2 )
		{
			al1.add(bs);
		}
		
		int size=0;
		if(al1.size()>0)
			System.out.println("Mismatched data:");
		else
			System.out.println("both are similar");
		System.out.println(al1);
		try
		{
			FileWriter writer=new FileWriter(file3);
			writer.append("Mismatched data");
			writer.append('\n');
			while(size<al1.size())
			{
				writer.append(""+al1.get(size));
				writer.append('\n');
				size++;
			}
			writer.flush();
			writer.close();
			CSVFile2.close();
			CSVFile1.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}