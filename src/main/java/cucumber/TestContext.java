package cucumber;

import managers.PageObjectManager;
import managers.WebdriverManager;

public class TestContext {
	private WebdriverManager WebdriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		WebdriverManager = new WebdriverManager();
		pageObjectManager = new PageObjectManager(WebdriverManager.getDriver());
	}

	public WebdriverManager getWebdriverManager() {
		return WebdriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}