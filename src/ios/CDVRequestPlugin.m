//
//  CDVRequestPlugin.m
//  MyFamily
//
//  Created by zyj7815 on 16/10/19.
//  Copyright © 2016年 ZYJ. All rights reserved.
//

#import "CDVRequestPlugin.h"
#import "requestOperation.h"

@implementation CDVRequestPlugin
/*
 {"url":"xxxxxxxxx","params":{"id":"1"}}
 */

- (void)postRequest:(CDVInvokedUrlCommand *)command {
    
    [self.commandDelegate runInBackground:^{
        __block CDVPluginResult *pluginResult = nil;
        
        NSDictionary *dict = command.arguments[0];
        NSString *url = dict[@"url"];
        NSDictionary *params = dict[@"params"];
        
        [requestOperation AFAddPostDressname:url parmas:params RequestSuccess:^(id result) {
            
            NSData *jsonData = [NSJSONSerialization dataWithJSONObject:result options:NSJSONWritingPrettyPrinted error:nil];
            NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
            
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                             messageAsString:jsonString];
            
            [self.commandDelegate sendPluginResult:pluginResult
                                        callbackId:command.callbackId];
        } failBlcok:^(id error) {
            
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR
                                         messageAsDictionary:error];
            [self.commandDelegate sendPluginResult:pluginResult
                                        callbackId:command.callbackId];
        }];
    }];
}

/*
 {"url":"xxxxx"}
 */
- (void)getRequest:(CDVInvokedUrlCommand *)command {
    
    [self.commandDelegate runInBackground:^{
        __block CDVPluginResult *pluginResult = nil;
        
        NSString *urlStr = command.arguments[0];
        [requestOperation AFAddGetDressname:urlStr
                                     parmas:nil
                             RequestSuccess:^(id result)
         {
             NSData *jsonData = [NSJSONSerialization dataWithJSONObject:result options:NSJSONWritingPrettyPrinted error:nil];
             NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
             
             pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                              messageAsString:jsonString];
             [self.commandDelegate sendPluginResult:pluginResult
                                         callbackId:command.callbackId];
         } failBlcok:^(id error) {
             pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR
                                          messageAsDictionary:error];
             [self.commandDelegate sendPluginResult:pluginResult
                                         callbackId:command.callbackId];
         }];
    }];
}


- (void)putRequest:(CDVInvokedUrlCommand *)command {
    
    [self.commandDelegate runInBackground:^{
        __block CDVPluginResult *pluginResult = nil;
        
        NSDictionary *dict = command.arguments[0];
        NSString *url = dict[@"url"];
        NSDictionary *params = dict[@"params"];
        
        [requestOperation AFAddPutDressname:url paramas:params RequestSuccess:^(id result) {
            
            NSData *jsonData = [NSJSONSerialization dataWithJSONObject:result options:NSJSONWritingPrettyPrinted error:nil];
            NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
            
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                             messageAsString:jsonString];
            [self.commandDelegate sendPluginResult:pluginResult
                                        callbackId:command.callbackId];
        } failBlcok:^(id error) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR
                                         messageAsDictionary:error];
            [self.commandDelegate sendPluginResult:pluginResult
                                        callbackId:command.callbackId];
        }];
    }];
    
}


/*
 {"url":"xxxxx"}
 */
- (void)deleteRequest:(CDVInvokedUrlCommand *)command {
    
    [self.commandDelegate runInBackground:^{
        
        __block CDVPluginResult *pluginResult = nil;
        
        NSString *urlStr = command.arguments[0];
        [requestOperation AFAddPutDressname:urlStr
                                    paramas:urlStr
                             RequestSuccess:^(id result)
         {
             NSData *jsonData = [NSJSONSerialization dataWithJSONObject:result options:NSJSONWritingPrettyPrinted error:nil];
             NSString *jsonString = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
             
             pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                              messageAsString:jsonString];
             
             [self.commandDelegate sendPluginResult:pluginResult
                                         callbackId:command.callbackId];
         } failBlcok:^(id error) {
             pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR
                                          messageAsDictionary:error];
             [self.commandDelegate sendPluginResult:pluginResult
                                         callbackId:command.callbackId];
         }];
    }];
}


@end
