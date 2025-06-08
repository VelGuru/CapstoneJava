import pytest
from utils.base_driver import init_driver

@pytest.fixture
def driver():
    driver = init_driver()
    yield driver
    driver.quit()
