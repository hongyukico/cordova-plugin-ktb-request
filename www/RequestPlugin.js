var exec = require('cordova/exec');

exports.getRequest = function(arg0, success, error) {
    exec(success, error, "RequestPlugin", "getRequest", [arg0]);
};

exports.postRequest = function(arg0, success, error) {
    exec(success, error, "RequestPlugin", "postRequest", [arg0]);
};

exports.putRequest = function(arg0, success, error) {
    exec(success, error, "RequestPlugin", "putRequest", [arg0]);
};

exports.deleteRequest = function(arg0, success, error) {
    exec(success, error, "RequestPlugin", "deleteRequest", [arg0]);
};