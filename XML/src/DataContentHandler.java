import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * Klasse, die das Interface ContentHandler implementiert.
 * Sucht in jeder Zeile des XML Dokuments nach einem bestimmten Schlüsselwort,
 * speichert das in ein Objekt des Stromnetz und wird anschließend in einer
 * ArrayList stromNetze gespeichert.
 * 
 * @author Daniel Zart
 */
public class DataContentHandler implements ContentHandler{

	private String currentValue;
	private ArrayList<Stromnetz> stromNetze = new ArrayList<Stromnetz>();
	private Stromnetz stromnetz;
	
	public String power, ref, id, lat, lon;
	
	public DataContentHandler(ArrayList<Stromnetz> stromNetze)
	{
		this.stromNetze = stromNetze;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		stromnetz = new Stromnetz();
		if(localName.equals("node"))
		{
			id = atts.getValue("id");
			lat = atts.getValue("lat");
			lon = atts.getValue("lon");
		}
		if("tag".equals(qName))
		{
			currentValue = atts.getValue("k");
			if(currentValue.equals("power"))
			{
				power = atts.getValue("v");
				stromnetz.setPower(atts.getValue("v"));
			}
			if(currentValue.equals("ref"))
			{
				ref = atts.getValue("v");
				stromnetz.setRef(atts.getValue("v"));
			}
		}
		stromnetz.setID(id);
		stromnetz.setPower(power);
		stromnetz.setRef(ref);
		stromnetz.setLat(lat);
		stromnetz.setLong(lon);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equals("node"))
		{
			stromNetze.add(stromnetz);
		}
	}
	
	@Override
	public void endDocument() throws SAXException 
	{
		//System.out.println("Stromnetze: " + stromNetze);
		//System.out.print("ID: ");
		//System.out.print(stromNetze.get(0).getID());
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException
	{}
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {}
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}
	@Override
	public void processingInstruction(String target, String data) throws SAXException {}
	@Override
	public void setDocumentLocator(Locator locator) {}
	@Override
	public void skippedEntity(String name) throws SAXException {}
	@Override
	public void startDocument() throws SAXException {}
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {}
	
	public ArrayList<Stromnetz> getArrayList()
	{
		return stromNetze;
	}
}	