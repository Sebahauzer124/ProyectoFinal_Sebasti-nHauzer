import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoAPComponent } from './components/logo-ap/logo-ap.component';
import { AcercadeComponent } from './components/acercade/acercade.component';
import { BannerComponent } from './components/banner/banner.component';
import { SkillComponent } from './components/skill/skill.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
 

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoAPComponent,
    AcercadeComponent,
    BannerComponent,
    SkillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
