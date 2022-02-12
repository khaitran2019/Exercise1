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
		log.info("Step 1: Login to web application"); 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(Constants.USER_NAME, Constants.PASSWORD);

		log.info("Step 2: Navigate to `Inventory` feature");
		HomePage homePage = new HomePage(driver);
		homePage.NavigateToInventory();

		log.info("Step 3: From the top-menu bar, select `Products -> Products` item, then create a new product");
		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.NavigateToProducts();

		log.info("Step 3.1: Go to create new product page");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.NavigateToCreateNewProduct();

		log.info("Step 3.2: Enter product name and create a new product");
		NewProductPage newProductPage = new NewProductPage(driver);
		newProductPage.CreateANewProduct(this.productName);

		log.info("Step 4: Update the quantity of new product is more than 10");
		newProductPage.GotoUpdateQuality();
		
		log.info("Step 4.1: Define quantity in quantity page");
		UpdateQuantityPage upQuaPage = new UpdateQuantityPage(driver);
		upQuaPage.DefineQuantity(Constants.QUANTITY);
		
		log.info("Step 5: From top-left page, click on `Application` icon");
		upQuaPage.ClickOnApplicationIcon();
		
		log.info("Step 6: Navigate to `Manufacturing` feature, then create a new Manufacturing Order item for the created Product on step #3");
		homePage = new HomePage(driver);
		homePage.NavigateToManufacturing();

		log.info("Step 6.1: Mavigate to create order page");
		ManufacturingPage manPage = new ManufacturingPage(driver);
		manPage.NavigateToCreateOrder();
		
		log.info("Step 6.2: Create order");
		NewOrderPage newOrderPage = new NewOrderPage(driver);
		newOrderPage.CreateOrder(this.productName);

		log.info("Step 7: Update the status of new Orders to “Done” successfully"); 
		newOrderPage.MarkOrderAsDone();
		
		log.info("Step 8: Validate the new Manufacturing Order is created with corrected information");
		OrdersPage ordersPage = new OrdersPage(driver);
		Assert.assertEquals(this.productName, ordersPage.getProductName());
		Assert.assertEquals(Constants.ORDER_DEFAULT_QUANTITY_TEXT, ordersPage.getQuantityText());
	}
}
