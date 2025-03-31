package com.jhomlala.alice

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** AlicePlugin */

class AlicePlugin : FlutterPlugin, MethodCallHandler {  
    // The MethodChannel that will handle communication between Flutter and native Android
    private lateinit var channel: MethodChannel

    // Called when the plugin is attached to the Flutter engine
    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "alice")
        channel.setMethodCallHandler(this)
    }

    // Handle incoming method calls from Flutter
    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            result.notImplemented()
        }
    }

    // Called when the plugin is detached from the Flutter engine
    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
