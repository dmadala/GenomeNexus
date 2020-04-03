/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genomenexus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author divyamadala
 */
public class AnnotatedVariant {
    private String chromosome;
    private String startPosition;
    private String endPosition;
    private String referenceAllele;
    private String variantAllele;
    private List<String> gvsp = new ArrayList<String>();//(this is a list of all returned hgvsp)
    
    public AnnotatedVariant() {}
    
    public AnnotatedVariant(String chromosome, String startPosition, String endPosition, String referenceAllele, String variantAllele) {
        this.chromosome = chromosome;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.referenceAllele = referenceAllele;
        this.variantAllele = variantAllele;
    }
    
    public String getChromosome() {
        return chromosome;
    }
    
    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }
     
    public String getStartPosition() {
        return startPosition;
    }
     
    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }
    
    public String getEndPosition() {
        return endPosition;
    }
    
    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }
    
    public String getReferenceAllele() {
        return referenceAllele;
    }
    
    public void setReferenceAllele(String referenceAllele) {
        this.referenceAllele = referenceAllele;
    }
    
    public String getVariantAllele() {
        return variantAllele;
    }
    
    public void setVariantAllele(String variantAllele) {
        this.variantAllele = variantAllele;
    }
    
    public List<String> getGvsp() {
        return gvsp;
    }
    
    public void setGvsp(List<String> gvsp) {
        this.gvsp = gvsp;
    }
}
