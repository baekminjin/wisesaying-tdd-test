package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
// 컨트롤러가 아닌 앱수준에서 해야되기 때문에 -> test가 2개가 됨
	@Test
	@DisplayName("== 명언 앱 ==")
	public void t1() {
		String output = AppTest.run("");

		assertThat(output)
				.contains("== 명언 앱 ==");
	}

	@Test
	@DisplayName("명령) ")
	public void t2() {
		String output = AppTest.run("""
				목록
				""");
		assertThat(output)
				.contains("명령)");
	}

	@Test
	@DisplayName("명령을 2번 이상 입력할 수 있습니다. ")
	public void t3() {
		String output = AppTest.run("""
				목록
				목록
				""");

		String[] split = output.split("명령\\)");
		//명령) 기준으로 짜른다. 각 명령을 개별적으로 확인하기 위해서
		assertThat(split).hasSize(4);
	}

	public static String run(String input){
		//공통 종료도 공통으로 있어서 리팩토링함
		input = input.stripIndent().trim() + "\n종료" ; //앞의 공백 없애기 / 뒤에 공백 없애기
		Scanner scanner = TestUtil.getScanner(input);
		//출력 모드 끄기
		ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

		App app = new App(scanner);
		app.run();

		String output = outputStream.toString();

		//출력 켜기
		TestUtil.clearSetOutToByteArray(outputStream);
		return output;
	}
}
