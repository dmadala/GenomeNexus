
package genomenexus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author divyamadala
 */
public class GenomeNexus {

    static final String FILE_NAME = "genomic-variants.tsv";
    static final String HTML_FILE_NAME = "genome.html";
    static final String GENOME_NEXUS_URL = "https://www.genomenexus.org/annotation/genomic/";
    Map<String, AnnotatedVariant> objectCache = Collections.synchronizedMap(new HashMap<String, AnnotatedVariant>());
    
    public boolean readFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line = reader.readLine();
        while (line != null){
            line = reader.readLine();
            System.out.println(line);
            if (line != null && line.length() > 0){
                String svArr[] = line.split("\t");
                AnnotatedVariant av = new AnnotatedVariant();
                if (svArr.length == 5){
                    av.setChromosome(svArr[0]);
                    av.setStartPosition(svArr[1]);
                    av.setEndPosition(svArr[2]);
                    av.setReferenceAllele(svArr[3]);
                    av.setVariantAllele(svArr[4]);
                    if (objectCache.get(line.replace("\t", "")) == null){
                        String jsonOutput = callGenomeNexusWebService(av);
                        if (jsonOutput != null && jsonOutput.length() > 0) {
                            av.setGvsp(processJson(jsonOutput));
                        }
                        objectCache.put(line.replace("\t", ""), av);
                    }
                }
            }
        }
        System.out.println("Object in Cache:" + objectCache.size());
        reader.close();
        return true;
    }
    
    public String callGenomeNexusWebService(AnnotatedVariant av){
        try{
            String jsonOutput = "";
            URL url = new URL(GENOME_NEXUS_URL + av.getChromosome() + "%2C" + av.getStartPosition() + "%2C" + av.getEndPosition() + "%2C" + av.getReferenceAllele() + "%2C" + av.getVariantAllele() + "?fields=hotspots%2Cmutation_assessor");
            System.out.println("Calling:" + url);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                jsonOutput += line;
            }
            in.close();
            connection.disconnect();
            return jsonOutput;
        }catch (Exception e){
            System.out.println("\nError while calling GenomeNexusWebService REST Service");
            System.out.println("ERROR:" + e.getMessage());
        }
        return null;
    }
    
    public List<String> processJson(String jsonStr){
        String strArr[] = jsonStr.split(",");
        List<String> hgvspList = new ArrayList<>();
        for (String hgvsp: strArr){
            if (hgvsp.contains("hgvsp")) {
                String hgvspValue = hgvsp.split(":")[1]+":"+hgvsp.split(":")[2];
                hgvspList.add(hgvspValue);
            }
        }
        return hgvspList;
    }
    
    public boolean writeHtmlFile() throws IOException{
        Iterator avIterator = objectCache.entrySet().iterator();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(HTML_FILE_NAME));
        bw.write("<html><head><title>Genome Nexus Web Service Data</title></head><body>");
        bw.write("<table><tr><td>Chromosome</td><td>Start_Position</td><td>End_Position</td><td>Reference_Allele</td><td>Tumor_Seq_Allele</td><td>hgvsp</td></tr>");
        
        while (avIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry) avIterator.next();
            AnnotatedVariant annotatedVariant = (AnnotatedVariant) mapElement.getValue();
            bw.write("<tr>"
                    + "<td>" + annotatedVariant.getChromosome() + "</td>"
                    + "<td>" + annotatedVariant.getStartPosition() + "</td>"
                    + "<td>" + annotatedVariant.getEndPosition() + "</td>"
                    + "<td>" + annotatedVariant.getReferenceAllele() + "</td>"
                    + "<td>" + annotatedVariant.getVariantAllele() + "</td>"
                    + "<td>" + annotatedVariant.getGvsp().toString() + "</td>"
                    + "</tr>");
        }
        bw.write("</table>");
        bw.write("</body></html>");
        bw.close();
        return true;  
    }
    public static void main(String[] args) {
        GenomeNexus genomenexus = new GenomeNexus();
        try{
            genomenexus.readFile();
            genomenexus.writeHtmlFile();
        } catch (IOException iOException){
            System.err.println("ERROR:" + iOException.getMessage());
            iOException.printStackTrace();
        }
    }
    
}
