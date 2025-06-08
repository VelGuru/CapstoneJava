from selenium.webdriver.common.by import By
from utils.helpers import click_element, get_element_text, wait_for_element

class HomePage:
    def __init__(self, driver):
        self.driver = driver

    def verify_logo(self):
        return get_element_text(self.driver, (By.CLASS_NAME, "app_logo")) == "Swag Labs"

    def add_item_to_cart(self):
        click_element(self.driver, (By.XPATH, "//button[contains(text(),'Add to cart')]"))

    def get_cart_count(self):
        return get_element_text(self.driver, (By.CLASS_NAME, "shopping_cart_badge"))

    def open_menu(self):
        click_element(self.driver, (By.ID, "react-burger-menu-btn"))

    def logout(self):
        wait_for_element(self.driver, (By.ID, "logout_sidebar_link"))
        click_element(self.driver, (By.ID, "logout_sidebar_link"))
