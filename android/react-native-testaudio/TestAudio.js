'use strict';

var { TestAudio } = require('react-native').NativeModules;
//var { Platform } = require('react-native');

var a = {
  play(fileName:string){
   // fileName = Platform.OS === 'ios' ? fileName : fileName.replace(/\.[^/.]+$/, "");
    TestAudio.play(fileName);
  }
};

module.exports = a;
