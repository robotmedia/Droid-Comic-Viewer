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
package net.robotmedia.acv.ui.settings.mobile;

import net.androidcomics.acv.R;
import net.robotmedia.acv.provider.HistoryManager;
import net.robotmedia.acv.ui.settings.SettingsHelper;
import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;

public class StorageSettingsActivity extends ExtendedPreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.helper.setOnPreferenceClickListener(SettingsHelper.PREFERENCE_CLEAR_HISTORY, new OnPreferenceClickListener() {
			
			@Override
			public boolean onPreferenceClick(Preference preference) {
				Activity activity = StorageSettingsActivity.this;
				HistoryManager.getInstance(activity).clear();
				activity.finish();
				return true;
			}
		});
	}
	
	@Override
	protected int getPreferencesResource() {
		return R.xml.visual_settings;
	}
	
}
