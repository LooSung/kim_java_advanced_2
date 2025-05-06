package charset;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

	private static final Charset EUC_KR = Charset.forName("EUC-KR");
	private static final Charset MS_949 = Charset.forName("MS949");


	public static void main(String[] args) {
		System.out.println("===" + "영문처리" + "===");
		encoding("A", US_ASCII);
		encoding("A", ISO_8859_1);
		encoding("A", EUC_KR);
		encoding("A", UTF_8);
		encoding("A", UTF_16BE);

		System.out.println("===" + "한글 처리" + "===");
		encoding("가", US_ASCII);
		encoding("가", ISO_8859_1);
		encoding("가", EUC_KR);
		encoding("가", UTF_8);
		encoding("가", UTF_16BE);
	}

	private static void encoding(String text, Charset charset) {
		// **
		// KEY POINT 항상 바이트를 인코딩 할 떄는 캐릭터 셋을 만들어줘서 보내줘야한다.
		// 그렇지 않으면 기본 케릭터 셋으로 들어간다.
		byte[] bytes = text.getBytes(charset);
		System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
	}
}
