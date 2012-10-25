//
//  MyPlugin.m
//  CommandMe
//
//  Created by Matt Gifford on 31/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "MyPlugin.h"
#import <Cordova/CDVPluginResult.h>

@implementation MyPlugin

- (void) greeting:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options
{
    
    NSLog(@"Hello, this is a native function called from PhoneGap/Cordova!");
    
    NSString* callbackId = [arguments objectAtIndex:0];
    
    CDVPluginResult* pluginResult = nil;
    NSString* javaScript = nil;
    
    @try {
        NSString* result = [arguments objectAtIndex:1];
        
        if (result != nil && [result length] > 0) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:result];
            javaScript = [pluginResult toSuccessCallbackString:callbackId];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
            javaScript = [pluginResult toErrorCallbackString:callbackId];
        }
    } @catch (NSException* exception) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_JSON_EXCEPTION messageAsString:[exception reason]];
        javaScript = [pluginResult toErrorCallbackString:callbackId];
    }
    
    [self writeJavascript:javaScript];
}

@end