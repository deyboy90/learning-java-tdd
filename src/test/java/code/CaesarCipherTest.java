package code;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaesarCipherTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testEncodeZeroShiftAndEmptyString() {
		String actual = CaesarCipher.encrypt("", 0);
		assertEquals(actual, "");
	}
	
	@Test
	public void testEncodeZeroShiftAndStringA() {
		String actual = CaesarCipher.encrypt("a", 0);
		assertThat(actual).isEqualTo("a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEncodeHandlesNPE() {
		String actual = CaesarCipher.encrypt(null, 0);
		assertThat(actual).isEqualTo("");
	}
	
	@Test
	public void testEncodeHandlesNPEUsingExpectedException() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(CaesarCipher.STRING_SHOULD_NOT_BE_NULL);
		
		String actual = CaesarCipher.encrypt(null, 0);
		assertThat(actual).isEqualTo("");
	}
	
	@Test
	public void testEncodeHandlesNPEUsingAssertJ() {
		assertThatThrownBy(() -> CaesarCipher.encrypt(null, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CaesarCipher.STRING_SHOULD_NOT_BE_NULL);
		
	}
	
	@Test
	public void testEncodeZeroShiftAndNonAlphabets() {
		assertThatThrownBy(() -> CaesarCipher.encrypt("1", 0))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage(CaesarCipher.TEXT_SHOULD_ONLY_BE_ALPHABETS);
		
	}
	
	@Test
	public void testEncodeReturnsAStringWhenCountIsOneAndStringIsSmallZ() {
		assertThat(CaesarCipher.encrypt("x", 26)).isEqualTo("x");
	}
	
	
}
