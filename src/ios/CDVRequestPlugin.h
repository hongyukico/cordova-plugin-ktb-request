//
//  CDVRequestPlugin.h
//  MyFamily
//
//  Created by zyj7815 on 16/10/19.
//  Copyright © 2016年 ZYJ. All rights reserved.
//

#import <Cordova/CDVPlugin.h>

@interface CDVRequestPlugin : CDVPlugin

- (void)postRequest:(CDVInvokedUrlCommand *)command;

- (void)getRequest:(CDVInvokedUrlCommand *)command;

- (void)putRequest:(CDVInvokedUrlCommand *)command;

- (void)deleteRequest:(CDVInvokedUrlCommand *)command;

@end
