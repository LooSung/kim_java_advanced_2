package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

	private static final Charset EUC_KR = Charset.forName("EUC-KR");
	private static final Charset MS_949 = Charset.forName("MS949");


	public static void main(String[] args) {
		System.out.println("== 영문 ASCII 인코딩 ==");
		enDecoding("A", US_ASCII, US_ASCII);
		enDecoding("A", US_ASCII, ISO_8859_1); // ASCII 확장(LATIN-1)
		enDecoding("A", US_ASCII, EUC_KR); // ASCII 포함
		enDecoding("A", US_ASCII, MS_949); // ASCII 포함
		enDecoding("A", US_ASCII, UTF_8); // ASCII 포함
		enDecoding("A", US_ASCII, UTF_16BE); // UTF_16 디코딩 실패 X

		System.out.println("== 한글 인코딩 - 기본 ==");
		enDecoding("가", US_ASCII, US_ASCII); // 63이니까 ?라는 값을 넣었다. X
		enDecoding("가", ISO_8859_1, ISO_8859_1); // X
		enDecoding("가", EUC_KR, EUC_KR);
		enDecoding("가", MS_949, MS_949);
		enDecoding("가", UTF_8, UTF_8);
		enDecoding("가", UTF_16, UTF_16);

		System.out.println("== 한글 인코딩 - 복잡한 문자 ==");
		enDecoding("뷁", EUC_KR, EUC_KR); // X
		enDecoding("뷁", MS_949, MS_949);
		enDecoding("뷁", UTF_8, UTF_8);
		enDecoding("뷁", UTF_16BE, UTF_16BE);

		System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 ==");
		enDecoding("가", EUC_KR, MS_949);
		enDecoding("뷁", MS_949, EUC_KR); // 인코딩 가능, 디코딩 X
		enDecoding("가", EUC_KR, UTF_8); // X
		enDecoding("가", MS_949, UTF_8); // X
		enDecoding("가", UTF_8, MS_949); // X

		System.out.println("== 영문 인코딩 - 디코딩이 다른 경우");
		enDecoding("A", EUC_KR, UTF_8);
		enDecoding("A", MS_949, UTF_8);
		enDecoding("A", UTF_8, MS_949);
		enDecoding("A", UTF_8, UTF_16BE); // X

	}

	private static void enDecoding(String text, Charset enCodcharset, Charset deCocharset) {
		// **
		// KEY POINT 항상 바이트를 인코딩 및 디코딩 할 떄는 캐릭터 셋을 만들어줘서 보내줘야한다.
		// 그렇지 않으면 기본 케릭터 셋으로 들어간다.
		byte[] encoded = text.getBytes(enCodcharset);
		String decoded = new String(encoded, deCocharset);

		System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
				text, enCodcharset, Arrays.toString(encoded), encoded.length,
				deCocharset, decoded);
	}
}
