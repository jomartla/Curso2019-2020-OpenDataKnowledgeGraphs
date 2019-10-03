package upm.oeg.wsld.jena;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

/**
 * Task 01: Reading and writing RDF files
 * 
 * @author elozano
 * @author isantana
 * 
 */
public class Task01
{
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		String filename = "resources/example1.rdf";
		
		// Create an empty model
		Model model = ModelFactory.createDefaultModel();
		
		// Use the FileManager to find the input file
		InputStream in = FileManager.get().open(filename);

		if (in == null)
			throw new IllegalArgumentException("File: "+filename+" not found");

		// Read the RDF/XML file
		model.read(in, null);

		// Write it to standard out
		model.write(System.out);

		// ** TASK 1.1: Now write the model in Turtle form **
		//If we change the second parameter, we can change de RDFFormat.
		model.write(System.out, "TURTLE");
		//model.write(System.out, "JSONLD");
		/*
		 * Jena writer name - RIOT RDFFormat
		 * TTL - TURTLE
		 * TURTLE - TURTLE
		 * Turtle - TURTLE
		 * N-TRIPLE - NTRIPLES
		 * NT-TRIPLE
		 */
		
		
		
		// ** TASK 1.2: Read a new model and merge it with the previous one **
		String filename2 = "resources/example2.rdf";
		InputStream in2 = FileManager.get().open(filename2);

		if (in2 == null)
			throw new IllegalArgumentException("File: "+filename2+" not found");

		// Read the RDF/XML file
		model.read(in2, null);

		// Write it to standard out
		model.write(System.out);
	}
}
