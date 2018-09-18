package code;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public class CaesarCipher {
	public static final String TEXT_SHOULD_ONLY_BE_ALPHABETS = "Text should only be alphabets";
	public static final String STRING_SHOULD_NOT_BE_NULL = "String should not be null";
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static String encrypt(String plainText, int shiftKey) {
		Preconditions.checkArgument(plainText != null, STRING_SHOULD_NOT_BE_NULL);
		Preconditions.checkArgument(StringUtils.isAlphaSpace(plainText) == true, TEXT_SHOULD_ONLY_BE_ALPHABETS);
		
		plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
	}

	public static String decrypt(String cipherText, int shiftKey) {
		cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
	}
	
	
	protected void abc() {
		
	}

}
