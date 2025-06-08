from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def wait_for_element(driver, locator, timeout=10):
    return WebDriverWait(driver, timeout).until(EC.presence_of_element_located(locator))

def click_element(driver, locator, timeout=10):
    element = wait_for_element(driver, locator, timeout)
    element.click()

def get_element_text(driver, locator, timeout=10):
    element = wait_for_element(driver, locator, timeout)
    return element.text
