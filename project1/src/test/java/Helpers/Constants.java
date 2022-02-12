package Helpers;

public class Constants {
	private static final String SEPARATOR = System.getProperty("file.separator");
	public static final String RUNTIME_SETTINGS_FILE_PATH = "run_tests/RuntimeSettings.txt".replace("/", SEPARATOR);

	public static int SHORT_TIME = 10;
	public static int MEDIUM_TIME = 2000;
	public static int LONG_TIME = 30;
	
	public static final String BASE_URL = "https://aspireapp.odoo.com";
	public static final String USER_NAME = "user@aspireapp.com";
	public static final String PASSWORD = "@sp1r3app";
	
	public static final String PRODUCT_NAME = "Pro_";
	public static final int QUANTITY = 15;
	public static final String ORDER_DEFAULT_QUANTITY_TEXT = "1.00";
}
