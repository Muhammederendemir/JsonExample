import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class JsonParseTest {

    public static void main(String[] args)throws IOException {
        try {

            // Path path= Paths.get("jsonFile.json");
           // Path realPath=path.toRealPath(LinkOption.NOFOLLOW_LINKS);
           // System.out.println(realPath );

            URL url = JsonParseTest.class.getResource("jsonFile.json");//resource jsonFile.json dosyasının url sini alıyorum
            String path = url.getPath();//url den  get.path ile dosya yolunu alıyorum.
            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject list= (JSONObject) jsonObject.get("list");
            JSONArray entries= (JSONArray) list.get("entries");

           for (int i=0;i<entries.size();i++) {
               if(i==1){
            JSONObject entry = (JSONObject) entries.get(i);
            JSONObject entry1= (JSONObject) entry.get("entry");
            JSONObject target= (JSONObject) entry1.get("target");
            JSONObject site= (JSONObject) target.get("site");
            System.out.println(site.get("id").toString());
            }
           }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}