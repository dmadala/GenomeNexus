
package GenomeNexusTest;
import genomenexus.AnnotatedVariant;
import genomenexus.GenomeNexus;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author divyamadala
 */
public class GenomeNexusTest {

    public GenomeNexusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readFile method, of class GenomeNexus.
     */
    @org.junit.Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        GenomeNexus instance = new GenomeNexus();
        assertTrue("File written Successfully", instance.readFile());
    }

    /**
     * Test of callGenomeNexusWebService method, of class GenomeNexus.
     */
    @org.junit.Test
    public void testCallGenomeNexusWebService() {
        System.out.println("callGenomeNexusWebService");
        AnnotatedVariant av = new AnnotatedVariant();
        av.setChromosome("X");//chromosome
        av.setStartPosition("66931258");//startPosition
        av.setEndPosition("66931258");//endPosition
        av.setReferenceAllele("A");//referenceAllele
        av.setVariantAllele("C");//variantAllele
        GenomeNexus instance = new GenomeNexus();
        String expResult = "{\"variant\":\"X:g.66931258A>C\",\"hgvsg\":\"X:g.66931258A>C\",\"id\":\"X:g.66931258A>C\",\"assembly_name\":\"GRCh37\",\"seq_region_name\":\"X\",\"start\":66931258,\"end\":66931258,\"allele_string\":\"A/C\",\"strand\":1,\"most_severe_consequence\":\"missense_variant\",\"transcript_consequences\":[{\"exon\":\"4/8\",\"transcript_id\":\"ENST00000374690\",\"hgvsp\":\"ENSP00000363822.3:p.Lys634Gln\",\"hgvsc\":\"ENST00000374690.3:c.1900A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000363822\",\"protein_start\":634,\"protein_end\":634,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"canonical\":\"1\",\"polyphen_score\":0.998,\"polyphen_prediction\":\"probably_damaging\",\"sift_score\":0.0,\"sift_prediction\":\"deleterious\",\"refseq_transcript_ids\":[\"NM_000044.3\"],\"consequence_terms\":[\"missense_variant\"]},{\"exon\":\"4/8\",\"transcript_id\":\"ENST00000396043\",\"hgvsp\":\"ENSP00000379358.2:p.Lys102Gln\",\"hgvsc\":\"ENST00000396043.2:c.304A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000379358\",\"protein_start\":102,\"protein_end\":102,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"polyphen_score\":0.71,\"polyphen_prediction\":\"possibly_damaging\",\"sift_score\":0.02,\"sift_prediction\":\"deleterious\",\"refseq_transcript_ids\":[\"NM_001011645.2\"],\"consequence_terms\":[\"missense_variant\"]},{\"exon\":\"4/5\",\"transcript_id\":\"ENST00000396044\",\"hgvsp\":\"ENSP00000379359.3:p.Lys634Gln\",\"hgvsc\":\"ENST00000396044.3:c.1900A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000379359\",\"protein_start\":634,\"protein_end\":634,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"polyphen_score\":0.997,\"polyphen_prediction\":\"probably_damaging\",\"sift_score\":0.0,\"sift_prediction\":\"deleterious\",\"consequence_terms\":[\"missense_variant\"]}],\"successfully_annotated\":true,\"mutation_assessor\":{\"license\":\"http://mutationassessor.org/r3/about.php\",\"annotation\":{\"input\":\"X,66931258,A,C\",\"hgvs\":\"X:g.66931258A>C\",\"hugoSymbol\":\"AR\",\"referenceGenomeVariant\":\"K>Q\",\"referenceGenomeVariantType\":\"missense\",\"functionalImpact\":\"medium\",\"functionalImpactScore\":3.485,\"msaLink\":\"http://mutationassessor.org/r3/?cm=msa&ty=f&p=ANDR_HUMAN&rb=627&re=686&var=K633Q\",\"pdbLink\":\"\",\"variantConservationScore\":4.2,\"variantSpecificityScore\":2.77,\"mappingIssue\":\"\",\"variant\":\"K633Q\",\"uniprotId\":\"ANDR_HUMAN\",\"refseqId\":\"NP_000035\",\"msaGaps\":0.0,\"msaHeight\":73,\"codonStartPosition\":\"hg19:chrX:66931258\",\"uniprotPosition\":633,\"uniprotResidue\":\"K\",\"refseqPosition\":634,\"refseqResidue\":\"K\",\"snpCount\":51}},\"hotspots\":{\"license\":\"https://opendatacommons.org/licenses/odbl/1.0/\",\"annotation\":[[],[],[]]}}";
        String result = instance.callGenomeNexusWebService(av);
        assertEquals(expResult, result);
    }

    /**
     * Test of processJson method, of class GenomeNexus.
     */
    @org.junit.Test
    public void testProcessJson() {
        System.out.println("processJson");
        String jsonStr = "{\"variant\":\"X:g.66931258A>C\",\"hgvsg\":\"X:g.66931258A>C\",\"id\":\"X:g.66931258A>C\",\"assembly_name\":\"GRCh37\",\"seq_region_name\":\"X\",\"start\":66931258,\"end\":66931258,\"allele_string\":\"A/C\",\"strand\":1,\"most_severe_consequence\":\"missense_variant\",\"transcript_consequences\":[{\"exon\":\"4/8\",\"transcript_id\":\"ENST00000374690\",\"hgvsp\":\"ENSP00000363822.3:p.Lys634Gln\",\"hgvsc\":\"ENST00000374690.3:c.1900A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000363822\",\"protein_start\":634,\"protein_end\":634,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"canonical\":\"1\",\"polyphen_score\":0.998,\"polyphen_prediction\":\"probably_damaging\",\"sift_score\":0.0,\"sift_prediction\":\"deleterious\",\"refseq_transcript_ids\":[\"NM_000044.3\"],\"consequence_terms\":[\"missense_variant\"]},{\"exon\":\"4/8\",\"transcript_id\":\"ENST00000396043\",\"hgvsp\":\"ENSP00000379358.2:p.Lys102Gln\",\"hgvsc\":\"ENST00000396043.2:c.304A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000379358\",\"protein_start\":102,\"protein_end\":102,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"polyphen_score\":0.71,\"polyphen_prediction\":\"possibly_damaging\",\"sift_score\":0.02,\"sift_prediction\":\"deleterious\",\"refseq_transcript_ids\":[\"NM_001011645.2\"],\"consequence_terms\":[\"missense_variant\"]},{\"exon\":\"4/5\",\"transcript_id\":\"ENST00000396044\",\"hgvsp\":\"ENSP00000379359.3:p.Lys634Gln\",\"hgvsc\":\"ENST00000396044.3:c.1900A>C\",\"variant_allele\":\"C\",\"codons\":\"Aaa/Caa\",\"protein_id\":\"ENSP00000379359\",\"protein_start\":634,\"protein_end\":634,\"gene_symbol\":\"AR\",\"gene_id\":\"ENSG00000169083\",\"amino_acids\":\"K/Q\",\"hgnc_id\":\"644\",\"polyphen_score\":0.997,\"polyphen_prediction\":\"probably_damaging\",\"sift_score\":0.0,\"sift_prediction\":\"deleterious\",\"consequence_terms\":[\"missense_variant\"]}],\"successfully_annotated\":true,\"mutation_assessor\":{\"license\":\"http://mutationassessor.org/r3/about.php\",\"annotation\":{\"input\":\"X,66931258,A,C\",\"hgvs\":\"X:g.66931258A>C\",\"hugoSymbol\":\"AR\",\"referenceGenomeVariant\":\"K>Q\",\"referenceGenomeVariantType\":\"missense\",\"functionalImpact\":\"medium\",\"functionalImpactScore\":3.485,\"msaLink\":\"http://mutationassessor.org/r3/?cm=msa&ty=f&p=ANDR_HUMAN&rb=627&re=686&var=K633Q\",\"pdbLink\":\"\",\"variantConservationScore\":4.2,\"variantSpecificityScore\":2.77,\"mappingIssue\":\"\",\"variant\":\"K633Q\",\"uniprotId\":\"ANDR_HUMAN\",\"refseqId\":\"NP_000035\",\"msaGaps\":0.0,\"msaHeight\":73,\"codonStartPosition\":\"hg19:chrX:66931258\",\"uniprotPosition\":633,\"uniprotResidue\":\"K\",\"refseqPosition\":634,\"refseqResidue\":\"K\",\"snpCount\":51}},\"hotspots\":{\"license\":\"https://opendatacommons.org/licenses/odbl/1.0/\",\"annotation\":[[],[],[]]}}";
        GenomeNexus instance = new GenomeNexus();
        List<String> expResult = new ArrayList<>();
        expResult.add("\"ENSP00000363822.3:p.Lys634Gln\"");
        expResult.add("\"ENSP00000379358.2:p.Lys102Gln\"");
        expResult.add("\"ENSP00000379359.3:p.Lys634Gln\"");
        List<String> result = instance.processJson(jsonStr);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeHtmlFile method, of class GenomeNexus.
     */
    @org.junit.Test
    public void testWriteHtmlFile() throws Exception {
        System.out.println("writeHtmlFile");
        GenomeNexus instance = new GenomeNexus();
        assertTrue("File written Successfully", instance.writeHtmlFile());
    }

    /**
     * Test of main method, of class GenomeNexus.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        boolean instanceCreated = true;
        GenomeNexus.main(args);
        assertTrue("GenomeNexus instance Successfully Created", instanceCreated);
    }

}
