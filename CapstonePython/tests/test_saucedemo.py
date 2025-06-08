from pages.login_page import LoginPage
from pages.home_page import HomePage

def test_saucedemo_case(driver):
    login_page = LoginPage(driver)
    home_page = HomePage(driver)

    # Step 1: Load URL and login
    login_page.load()
    login_page.login()

    # Step 2: Verify "Swag Labs" logo
    assert home_page.verify_logo(), "Swag Labs logo not found"

    # Step 3: Add one item to cart
    home_page.add_item_to_cart()

    # Step 4: Check cart count is 1
    assert home_page.get_cart_count() == "1", "Item not added to cart"

    # Step 5: Click menu and logout
    home_page.open_menu()
    home_page.logout()
