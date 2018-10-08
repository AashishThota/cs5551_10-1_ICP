import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireModule } from 'angularfire2';
import { Camera } from '@ionic-native/camera';


import { HomePage } from '../pages/home/home';


import { LoginPageModule } from '../pages/login/login.module';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

var config = {
     apiKey: "AIzaSyBB2y91mhAl2KAp4uAX2lbrIUHuTTtVh9g",
    authDomain: "icp7-60dad.firebaseapp.com",
    databaseURL: "https://icp7-60dad.firebaseio.com",
    projectId: "icp7-60dad",
    storageBucket: "icp7-60dad.appspot.com",
    messagingSenderId: "217196295106"
};

@NgModule({
  declarations: [
    MyApp,
    HomePage,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    LoginPageModule,
    AngularFireDatabaseModule,
    IonicModule.forRoot(MyApp),
    AngularFireAuthModule,
    AngularFireModule.initializeApp(config)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,

    HomePage,
    
  ],
  providers: [
    StatusBar,
    Camera,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
