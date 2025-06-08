from selenium.webdriver.common.by import By
from utils.helpers import wait_for_element, click_element

class LoginPage:
    def __init__(self, driver):
        self.driver = driver

    def load(self):
        self.driver.get("https://www.saucedemo.com/")

    def login(self, username="standard_user", password="secret_sauce"):
        wait_for_element(self.driver, (By.ID, "user-name")).send_keys(username)
        wait_for_element(self.driver, (By.ID, "password")).send_keys(password)
        click_element(self.driver, (By.ID, "login-button"))
