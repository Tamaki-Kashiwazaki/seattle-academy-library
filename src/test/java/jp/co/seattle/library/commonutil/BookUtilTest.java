package jp.co.seattle.library.commonutil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.seattle.library.dto.BookDetailsInfo;

public class BookUtilTest {
	final static Logger logger = LoggerFactory.getLogger(BookUtil.class);
	private static final String REQUIRED_ERROR = "未入力の必須項目があります";
	private static final String ISBN_ERROR = "ISBNの桁数または半角数字が正しくありません";
	private static final String PUBLISHDATE_ERROR = "出版日は半角数字のYYYYMMDD形式で入力してください";

	private BookUtil bookUtil = new BookUtil();

	@Test
	public void test01() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));

	}

	@Test
	public void test02() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("20503051");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));

	}

	@Test
	public void test03() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("12345111111");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(ISBN_ERROR));
	}

	@Test
	public void test04() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));

	}

	@Test
	public void test05() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234511111");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));
	}

	@Test
	public void test06() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111");
		bookInfo.setIsbn("1234511111");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));
	}

	@Test
	public void test07() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("");
		bookInfo.setIsbn("1234511111");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR, PUBLISHDATE_ERROR));
	}

	@Test
	public void test08() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("２０００１０３０");
		bookInfo.setIsbn("1234511111");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));
	}

	@Test
	public void test09() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));

	}

	@Test
	public void test10() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));
	}

	@Test
	public void test11() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567891110");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));
	}

	@Test
	public void test12() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("123456789a");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(ISBN_ERROR));
	}
}
