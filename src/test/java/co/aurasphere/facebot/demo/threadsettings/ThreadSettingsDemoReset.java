package co.aurasphere.facebot.demo.threadsettings;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.threadsettings.FaceBotThreadSettingsConfiguration;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.*;

/**
 * Demo of resetting the Thread Settings configuration.
 * 
 * @author Donato Rimenti
 * @date Aug 28, 2016
 */
public class ThreadSettingsDemoReset {

	/**
	 * Resets the Get Started Button and the Persistent Menu.
	 * 
	 * @param args
	 *            should be empty.
	 */
	public static void main(String[] args) {
		// Configuration.
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		FbBotMillThreadSettingsConfiguration.deleteGetStartedButton();
		FbBotMillThreadSettingsConfiguration.deletePersistentMenu();
	}
}
