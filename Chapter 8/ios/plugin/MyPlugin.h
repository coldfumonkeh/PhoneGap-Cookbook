//
//  MyPlugin.h
//  MyPlugin
//
//  Created by Matt Gifford on 31/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <Cordova/CDV.h>

@interface MyPlugin : CDVPlugin

- (void) greeting:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end
