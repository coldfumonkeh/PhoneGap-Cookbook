var MyPlugin = function(){};

MyPlugin.prototype.greeting = function(
message, successCallback, errorCallback) {
    cordova.exec(
        successCallback, 
        errorCallback, 
        'MyPlugin', 
        'greeting', 
        [message]
    );
};

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.MyPlugin) {
    window.plugins.MyPlugin = new MyPlugin();
}
