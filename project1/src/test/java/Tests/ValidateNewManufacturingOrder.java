package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Helpers.Constants;
import Helpers.Utils;
import Pages.HomePage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.ManufacturingPage;
import Pages.NewOrderPage;
import Pages.NewProductPage;
import Pages.OrdersPage;
import Pages.ProductsPage;
import Pages.UpdateQuantityPage;
import io.qameta.allure.Description;

public class ValidateNewManufacturingOrder extends TestBase {
	private String productName = Constants.PRODUCT_NAME + Utils.GetUDID();

	@Test()
	@Description("Validate the new Manufacturing Order")
	public void Test01() {
		
		
		
		log.info("Step 1: Login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(Constants.USER_NAME, Constants.PASSWORD);

		log.info("// Step 2: Navigate to Inventory feature");
		HomePage homePage = new HomePage(driver);
		homePage.NavigateToInventory();

		log.info("// Step 3: Navigate to Products");
		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.NavigateToProducts();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.NavigateToCreateNewProduct();

		NewProductPage newProductPage = new NewProductPage(driver);
		newProductPage.CreateANewProduct(this.productName);

		log.info("// Step 4: Update quantity");
		newProductPage.GotoUpdateQuality();
		log.info("// Step 4: 1");
		
		UpdateQuantityPage upQuaPage = new UpdateQuantityPage(driver);
		log.info("// Step 4: 2");
		upQuaPage.DefineQuantity(Constants.QUANTITY);
		log.info("// Step 4: 3");
		
		log.info("// Step 5: From top-left page, click on `Application` icon");
		upQuaPage.ClickOnApplicationIcon();
		
		log.info("// Step 6: Navigate to `Manufacturing` feature, then create a new Manufacturing Order item for the created Product on step #3");
		homePage = new HomePage(driver);
		homePage.NavigateToManufacturing();
		log.info("// Step 6: 1");
		ManufacturingPage manPage = new ManufacturingPage(driver);
		manPage.CreateOrder();
		log.info("// Step 6: 2");
		NewOrderPage newOrderPage = new NewOrderPage(driver);
		newOrderPage.CreateOrder(this.productName);
		log.info("// Step 6: 3");
		
		OrdersPage ordersPage = new OrdersPage(driver);
		log.info("// Verify:");
		log.info(ordersPage.getProductName());
		log.info(ordersPage.getQuantityText());
		Assert.assertEquals(this.productName, ordersPage.getProductName());
		Assert.assertEquals(Constants.ORDER_DEFAULT_QUANTITY_TEXT, ordersPage.getQuantityText());
	}
}
