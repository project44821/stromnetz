import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Main Klasse, die eine XML Datei mit einem bestimmten Namen einliest,
 * in diesem Fall "test.xml". * 
 * @author Daniel Zart
 */
public class Main {

	public static void main (String[] args)
	{
		getList();
	}
	
	public static ArrayList<Stromnetz> getList()
	{
		ArrayList<Stromnetz> list = new ArrayList<Stromnetz>();
		try{
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			
			FileReader reader = new FileReader("test.xml");
			
			DataContentHandler handler = new DataContentHandler(list);
			
			xmlReader.setContentHandler(handler);
			
			xmlReader.parse(new InputSource(reader));
			
			list = handler.getArrayList();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
