package Tests;

import static org.junit.Assert.assertTrue;
import graphics.OutputDecryptionPanel;
import graphics.OutputEncryptionPanel;

import java.io.IOException;
import java.util.Arrays;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import Encryption.Decrypt;
import Encryption.EncryptMessage;
import Encryption.googleMapsAPI;

public class Tests {
	@Test
	public void getCoordinates() throws IOException, ParseException{
		String addressInput = "Dovev 3, Ashkelon, Israel";
	    Double[] check = {31.6783435,34.5810802};
		assertTrue(Arrays.equals(check,googleMapsAPI.getCordinates(addressInput)));
	}
	@Test
	public void getChar() throws IOException, ParseException{
	    Double[] check = {31.6783435,34.5810802};
	   	String chr = "a";
	   	assertTrue(chr.equals(googleMapsAPI.getChar(check)));
	}
	@Test
	public void encryptionWorking() throws IOException, ParseException{
		String message = "Hey",key = "tony";
		EncryptMessage em = new EncryptMessage(key,message);
		em.Encrypting();
		Decrypt.Decryption(key, OutputEncryptionPanel.getEcryptMessage());
		String afterDec = OutputDecryptionPanel.getOutput();
		assertTrue(message.equals(afterDec));
	}
}
