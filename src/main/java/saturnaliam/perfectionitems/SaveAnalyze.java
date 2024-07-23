package saturnaliam.perfectionitems;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.util.Iterator; 
import javax.xml.namespace.QName; 
import javax.xml.stream.XMLEventReader; 
import javax.xml.stream.XMLInputFactory; 
import javax.xml.stream.XMLStreamException; 
import javax.xml.stream.events.*; 

public class SaveAnalyze {
    public SaveAnalyze() {
        File file = new File("saves/Lucias_379186826");
        try {
            parser(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void parser(File file) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        Boolean recipe = false;
        Boolean isId = false;
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            if (event.isStartElement()) {
                StartElement element = (StartElement)event;
                Iterator<Attribute> iterator = element.getAttributes();
                if (element.getName().toString().equalsIgnoreCase("recipesCooked")) recipe = true;
                if (element.getName().toString().equalsIgnoreCase("string")) isId = true;

                while(iterator.hasNext()) {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    String value = attribute.getValue();
                    if (recipe) {
                        System.out.println(name + " = " + value);
                    }
                }

            }

            if (event.isEndElement()) {
                EndElement element = (EndElement) event;
                if (element.getName().toString().equalsIgnoreCase("recipesCooked")) recipe = false;
                if (element.getName().toString().equalsIgnoreCase("string")) isId = false;
            }

            if (event.isCharacters()) {
                Characters element = (Characters) event;
                if (recipe && isId) {
                    System.out.println(element.getData());
                }
            }
        }
    }
}
