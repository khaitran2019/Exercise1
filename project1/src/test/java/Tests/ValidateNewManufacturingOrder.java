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
		
		LoginPage loginPage = new LoginPage(driver);
		log.info("Step 1: Login to web application"); 
		loginPage.Login(Constants.USER_NAME, Constants.PASSWORD);

		HomePage homePage = new HomePage(driver);
		log.info("Step 2: Navigate to `Inventory` feature");
		homePage.NavigateToInventory();

		InventoryPage inventoryPage = new InventoryPage(driver);
		log.info("Step 3: From the top-menu bar, select `Products -> Products` item, then create a new product. Step 3.1: Navigate to products page");
		inventoryPage.NavigateToProducts();

		ProductsPage productsPage = new ProductsPage(driver);
		log.info("Step 3.2: Go to create new product page");
		productsPage.NavigateToCreateNewProduct();

		NewProductPage newProductPage = new NewProductPage(driver);
		log.info("Step 3.3: Enter product name and create a new product");
		newProductPage.CreateANewProduct(this.productName);

		log.info("Step 4: Update the quantity of new product is more than 10");
		newProductPage.GotoUpdateQuality();
		
		UpdateQuantityPage upQuaPage = new UpdateQuantityPage(driver);
		log.info("Step 4.1: Define quantity in quantity page");
		upQuaPage.DefineQuantity(Constants.QUANTITY);
		
		log.info("Step 5: From top-left page, click on `Application` icon");
		upQuaPage.ClickOnApplicationIcon();
				
		homePage = new HomePage(driver);
		log.info("Step 6: Navigate to `Manufacturing` feature, then create a new Manufacturing Order item for the created Product on step #3");
		homePage.NavigateToManufacturing();

		ManufacturingPage manPage = new ManufacturingPage(driver);
		log.info("Step 6.1: Mavigate to create order page");
		manPage.NavigateToCreateOrder();
		
		NewOrderPage newOrderPage = new NewOrderPage(driver);
		log.info("Step 6.2: Create order");
		newOrderPage.CreateOrder(this.productName);

		log.info("Step 7: Update the status of new Orders to “Done” successfully"); 
		newOrderPage.MarkOrderAsDone();
				
		OrdersPage ordersPage = new OrdersPage(driver);
		log.info("Step 8: Validate the new Manufacturing Order is created with corrected information");
		Assert.assertTrue(ordersPage.doesProductNameExist(productName));
		Assert.assertTrue(ordersPage.doesQuantityExist(Constants.ORDER_DEFAULT_QUANTITY_TEXT));
	}
}
