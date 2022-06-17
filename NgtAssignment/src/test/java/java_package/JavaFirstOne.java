package java_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class JavaFirstOne 
{
	@Test
	public void LocalFile() throws IOException {
		File file = new File("C://Users//surhari//OneDrive - Capgemini//Desktop/46133458_EN_SureshChandra_CV.pdf");
		FileInputStream Fis= new FileInputStream(file);
		PDDocument doc= PDDocument.load(Fis);
		System.out.println(doc.getPages().getCount());
		PDFTextStripper pdfTextStripper =new PDFTextStripper();
		String docText =pdfTextStripper.getText(doc);
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of keywords in array:");
		int n = s.nextInt();
		String keywords[] = new String[n];
		System.out.println("Enter all the keywords:");
		for(int i = 0; i < n ; i++)
		{
		keywords[i] = s.next();
		}

	int index=0;
	double percentage=0, sum=0;
	for(index = 0; index < keywords.length ; index++) {
		Pattern pattern = Pattern.compile(keywords[index], Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(docText);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("keyword found");
	      sum=sum+1;
		  percentage=(sum/n)*100;
	    } else {
	      System.out.println("keyword not found");
	    }
	}
		System.out.println("the match is "+ percentage+"%");
		doc.close();
		Fis.close();
		}
	
	@Test
	public void ThroughUrl() throws IOException {
		
		URL url = new URL("https://shriresume.com/sample-the-seeker-resume.pdf");
		PDDocument doc= PDDocument.load(url.openStream());
		System.out.println(doc.getPages().getCount());
		PDFTextStripper pdfTextStripper =new PDFTextStripper();
		String docText =pdfTextStripper.getText(doc);
		System.out.println(docText);
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of keywords in array:");
		int n = s.nextInt();
		String keywords[] = new String[n];
		System.out.println("Enter all the keywords:");
		for(int i = 0; i < n ; i++)
		{
		keywords[i] = s.next();
		}

	int index=0;
	double percentage=0, sum=0;
	for(index = 0; index < keywords.length ; index++) {
		Pattern pattern = Pattern.compile(keywords[index], Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(docText);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("keyword found");
	      sum=sum+1;
		  percentage=(sum/n)*100;
	    } else {
	      System.out.println("keyword not found");
	    }
	}
		System.out.println("the match is "+ percentage+"%");
		doc.close();
		}
	}


