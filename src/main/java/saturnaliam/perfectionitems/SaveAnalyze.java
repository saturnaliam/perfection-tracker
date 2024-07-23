package saturnaliam.perfectionitems;

import java.io.File; 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader; 
import javax.xml.stream.XMLInputFactory; 
import javax.xml.stream.events.*; 

public class SaveAnalyze {
    public SaveAnalyze() {
        File file = new File("saves/Lucias_379186826");
        try {
            List<String> ids = parser(file);
            System.out.println(ids + " Length: " + ids.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> parser(File file) throws Exception {
        List<String> cookedIds = new ArrayList<>();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        Boolean recipe = false;
        Boolean isId = false;
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            // opening / closing the cooked recipes and the ids for each recipe
            if (event.isStartElement()) {
                StartElement element = (StartElement)event;
                if (element.getName().toString().equalsIgnoreCase("recipesCooked")) recipe = true;
                if (element.getName().toString().equalsIgnoreCase("string")) isId = true;
            }

            if (event.isEndElement()) {
                EndElement element = (EndElement) event;
                if (element.getName().toString().equalsIgnoreCase("recipesCooked")) recipe = false;
                if (element.getName().toString().equalsIgnoreCase("string")) isId = false;
            }

            if (event.isCharacters()) {
                Characters element = (Characters) event;
                if (recipe && isId) {
                    cookedIds.add(element.getData());
                }
            }
        }

        return cookedIds;
    }
}
