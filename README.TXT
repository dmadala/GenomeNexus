========================
Genome Nexus DESCRIPTION
========================

This project is created using 2 classes:
	-AnnotatedVariant: A java bean to hold values of chromosome, startPosition, endPosition, referenceAllele, variantAllele and gsvp
	-- GenomeNexus: This java file launches the application. It reads the tab delimited file, creates the beans instance and call the web service and store in built in object cache. It also parses the json output from web services and write the data into an html file.


GenomeNexus folder contains:
	- lib: It contains Junit libraries to run the Junit test cases
	-src: It has following java files in which functionality is implemented.
		AnnotatedVariant.java
		GenomeNexus.java
	- test: It has a java file that contains all the JUnit test cases performed successfully


To run the project from the command line, go to the GenomeNexus folder and type the following:
	
	java -jar "GenomeNexus.jar" 

It will generate genome.html file in the GenomeNexus folder

Prerequisite: Following are the requirements to run it.
	- JDK 1.8 or higher must be installed and path is already set
	- genomic-variants.tsv should be present in the GenomeNexus folder

