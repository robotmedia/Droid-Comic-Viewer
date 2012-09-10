/*******************************************************************************
 * Copyright 2009 Robot Media SL
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.robotmedia.acv;

import net.robotmedia.acv.billing.BillingManager;
import net.robotmedia.acv.logic.PreferencesController;
import android.app.Application;

public class ACVApplication extends Application {

	private static String pkgName;
	
	@Override
	public void onCreate() {
		super.onCreate();
		final PreferencesController preferences = new PreferencesController(this);
		preferences.legacy();
		preferences.setMaxImageResolution();
		
		pkgName = this.getPackageName();

		BillingManager.getInstance(this).initialize();
	}

	public static String getPkgName() {
		return pkgName;
	}
}