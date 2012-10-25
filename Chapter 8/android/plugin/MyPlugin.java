package com.coldfumonkeh;

import android.content.Context;
import android.telephony.TelephonyManager;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class MyPlugin extends Plugin {

	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {

		TelephonyManager telephonyManager = (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
		PluginResult.Status status = PluginResult.Status.OK;
		String result = "";
		
		try {
			if ("greeting".equals(action)) {
				result = args.getString(0); 
                if (result != null && result.length() > 0) { 
                	PluginResult pluginResult = new PluginResult(status, result);
                	return pluginResult;
                } else {
                    return new PluginResult(PluginResult.Status.ERROR);
                }
            } else if (action.equals("getdeviceimei")) {
            	
            	result = telephonyManager.getDeviceId();
                
            	PluginResult pluginResult = new PluginResult(status, result);
            	return pluginResult;
			} else if (action.equals("getdevicesoftwareversion")) {
            	
            	result = telephonyManager.getDeviceSoftwareVersion();
                
            	PluginResult pluginResult = new PluginResult(status, result);
            	return pluginResult;
			} else if (action.equals("getvoicemailnumber")) {
            	
            	result = telephonyManager.getVoiceMailNumber();
                
            	PluginResult pluginResult = new PluginResult(status, result);
            	return pluginResult;
			} else {
                status = PluginResult.Status.INVALID_ACTION;
            }
			return new PluginResult(status, result);
		} catch (JSONException e) {
            return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
        }
	}

}
