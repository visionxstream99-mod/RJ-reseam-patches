HyperLock 0.1.2 — Smali selector research

This report is generated from the supplied APKCube/decompiled archive. It is not an installable patch.

Package: com.appiolab.hyperlockscreenos
Manifest: AndroidManifest.xml
Smali files: 14845
App-owned Smali files under package prefix com/appiolab/hyperlockscreenos: 0

Manifest ad-related declarations:
  AndroidManifest.xml:5: <uses-permission android:name="android.permission.INTERNET"/>
  AndroidManifest.xml:17: <uses-permission android:name="android.permission.ACCESS_ADSERVICES_AD_ID"/>
  AndroidManifest.xml:18: <uses-permission android:name="android.permission.ACCESS_ADSERVICES_ATTRIBUTION"/>
  AndroidManifest.xml:19: <uses-permission android:name="android.permission.ACCESS_ADSERVICES_TOPICS"/>
  AndroidManifest.xml:104: <meta-data android:name="com.google.android.gms.ads.APPLICATION_ID" android:value="ca-app-pub-4008958369330245~6985023788"/>
  AndroidManifest.xml:105: <activity android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize" android:enableOnBackInvokedCallback="false" android:exported="false" android:name="com.google.android.gms.ads.AdActivity
  AndroidManifest.xml:106: <provider android:authorities="com.appiolab.hyperlockscreenos.mobileadsinitprovider" android:exported="false" android:initOrder="100" android:name="com.google.android.gms.ads.MobileAdsInitProvider"/>
  AndroidManifest.xml:107: <service android:enabled="true" android:exported="false" android:name="com.google.android.gms.ads.AdService"/>
  AndroidManifest.xml:108: <activity android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize" android:exported="false" android:name="com.google.android.gms.ads.OutOfContextTestingActivity"/>
  AndroidManifest.xml:109: <activity android:excludeFromRecents="true" android:exported="false" android:launchMode="singleTask" android:name="com.google.android.gms.ads.NotificationHandlerActivity" android:taskAffinity="" android:theme="@android:style/Theme.Transluce
  AndroidManifest.xml:110: <meta-data android:name="com.google.android.gms.ads.flag.OPTIMIZE_AD_LOADING" android:value="true"/>
  AndroidManifest.xml:111: <meta-data android:name="com.google.android.gms.ads.flag.OPTIMIZE_INITIALIZATION" android:value="true"/>
  AndroidManifest.xml:113: <meta-data android:name="com.google.android.play.billingclient.version" android:value="9.1.0"/>
  AndroidManifest.xml:120: <meta-data android:name="com.google.firebase.components:com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:121: <meta-data android:name="com.google.firebase.components:com.google.firebase.crashlytics.FirebaseCrashlyticsKtxRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:122: <meta-data android:name="com.google.firebase.components:com.google.firebase.crashlytics.CrashlyticsRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:123: <meta-data android:name="com.google.firebase.components:com.google.firebase.sessions.FirebaseSessionsRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:124: <meta-data android:name="com.google.firebase.components:com.google.firebase.installations.FirebaseInstallationsKtxRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:125: <meta-data android:name="com.google.firebase.components:com.google.firebase.installations.FirebaseInstallationsRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:126: <meta-data android:name="com.google.firebase.components:com.google.firebase.FirebaseCommonKtxRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:127: <meta-data android:name="com.google.firebase.components:com.google.firebase.datatransport.TransportRegistrar" android:value="com.google.firebase.components.ComponentRegistrar"/>
  AndroidManifest.xml:133: <meta-data android:name="androidx.work.WorkManagerInitializer" android:value="androidx.startup"/>
  AndroidManifest.xml:134: <meta-data android:name="androidx.emoji2.text.EmojiCompatInitializer" android:value="androidx.startup"/>
  AndroidManifest.xml:135: <meta-data android:name="androidx.lifecycle.ProcessLifecycleInitializer" android:value="androidx.startup"/>
  AndroidManifest.xml:136: <meta-data android:name="androidx.profileinstaller.ProfileInstallerInitializer" android:value="androidx.startup"/>
  AndroidManifest.xml:152: <uses-library android:name="android.ext.adservices" android:required="false"/>
  AndroidManifest.xml:153: <meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version"/>
  AndroidManifest.xml:169: <meta-data android:name="backend:com.google.android.datatransport.cct.CctBackendFactory" android:value="cct"/>

Ad SDK class inventory:

- AppLovin: 28 Smali files
- Google Ads legacy: 3 Smali files
- Google Mobile Ads: 659 Smali files

App-owned methods containing ad SDK call references:

No direct ad SDK invocations found in app-owned files. The ad UI may be loaded indirectly or via WebView/native extension.

App-owned ad/premium-related string constants:

No ad/premium-related strings found under the app package prefix.

Resource strings:

res/layout/activity_all_images_see.xml:6: <androidx.recyclerview.widget.RecyclerView android:id="@id/recyclerAllImages" android:paddingLeft="@dimen/_10sdp" android:paddingRight="@dimen/_10sdp" android:layout_width="match_parent" android:layout_height="0.0dp" and
res/layout/activity_all_images_see.xml:7: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_buy_premium.xml:7: <ImageView android:id="@id/imageViewCrown" android:layout_width="0.0dp" android:layout_height="wrap_content" android:src="@drawable/ic_premium_crown" android:adjustViewBounds="true" app:layout_constraintEnd_toEndOf="pare
res/layout/activity_buy_premium.xml:11: <TextView android:textSize="@dimen/_28sdp" android:textStyle="bold" android:textColor="@color/black" android:gravity="center" android:layout_gravity="center" android:id="@id/tvPremiumTitle" android:layout_width="match_pa
res/layout/activity_buy_premium.xml:12: <TextView android:textSize="@dimen/_10sdp" android:textColor="@color/black" android:gravity="center" android:layout_gravity="center" android:id="@id/tvSubtitle" android:layout_width="match_parent" android:layout_height="
res/layout/activity_buy_premium.xml:21: <TextView android:textSize="@dimen/_11sdp" android:textStyle="bold" android:textColor="@color/black" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Unlock All 1000+ Premium Wallpap
res/layout/activity_customize.xml:35: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize.xml:45: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize2.xml:40: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize2.xml:50: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize3.xml:46: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize3.xml:56: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize4.xml:37: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize4.xml:46: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize5.xml:38: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize5.xml:48: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize6.xml:39: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize6.xml:49: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize7.xml:34: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize7.xml:44: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize8.xml:35: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize8.xml:45: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_customize9.xml:39: <HorizontalScrollView android:id="@id/horizontalScrollView" android:scrollbars="none" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout
res/layout/activity_customize9.xml:49: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_main.xml:4: <androidx.constraintlayout.widget.ConstraintLayout android:id="@id/constraintLayout5" android:background="@drawable/bg_img" android:layout_width="match_parent" android:layout_height="0.0dp" app:layout_constraintBottom_to
res/layout/activity_main.xml:6: <androidx.constraintlayout.widget.ConstraintLayout android:id="@id/conBuyPremiumCard" android:background="@drawable/rounded_background_dark_blue" android:paddingLeft="@dimen/_10sdp" android:paddingRight="@dimen/_10sdp" a
res/layout/activity_main.xml:14: <ImageView android:id="@id/btnBuyPremium" android:layout_width="@dimen/_30sdp" android:layout_height="wrap_content" android:src="@drawable/ic_premium_crown" android:adjustViewBounds="true" android:layout_marginEnd="@dime
res/layout/activity_main.xml:34: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_setting.xml:6: <ScrollView android:scrollbars="none" android:layout_width="match_parent" android:layout_height="0.0dp" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout_constraintEnd_toEndOf="parent" app:layout_constraintSt
res/layout/activity_setting.xml:8: <ImageView android:id="@id/btnBuyPremium" android:layout_width="match_parent" android:layout_height="wrap_content" android:src="@drawable/btn_buy_premium" android:adjustViewBounds="true" />
res/layout/activity_setting.xml:75: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_splash.xml:4: <androidx.constraintlayout.widget.ConstraintLayout android:layout_width="match_parent" android:layout_height="0.0dp" app:layout_constraintBottom_toTopOf="@id/bannerAd" app:layout_constraintTop_toTopOf="parent">
res/layout/activity_splash.xml:18: <com.applovin.mediation.BannerAdLayout android:id="@id/bannerAd" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" app:layout_constraintEnd_toEndOf="
res/layout/activity_thank_you.xml:5: <TextView android:textSize="@dimen/_14sdp" android:textColor="@color/orange" android:id="@id/tvThankYouSubtitle" android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_marginBottom="@dime
res/layout/activity_thank_you.xml:13: <TextView android:textSize="@dimen/_10sdp" android:textStyle="bold" android:textColor="@color/black" android:layout_width="match_parent" android:layout_height="wrap_content" android:text="Unlock All 1000+ Premium Wallpap
res/layout/activity_thank_you.xml:36: <androidx.appcompat.widget.AppCompatButton android:textSize="@dimen/_14sdp" android:textColor="@android:color/white" android:id="@id/btnRestartApp" android:background="@drawable/rounded_background_dark_blue" android:padd
res/layout/dialog_yearly_discount.xml:10: <ImageView android:id="@id/btnClose" android:layout_width="0.0dp" android:layout_height="wrap_content" android:layout_margin="@dimen/_12sdp" android:src="@drawable/ic_premium_close_mini" android:adjustViewBounds="true" a
res/layout/item_image.xml:6: <ImageView android:id="@id/ivPremiumCrown" android:background="@drawable/bg_badge" android:padding="@dimen/_4sdp" android:layout_width="@dimen/_24sdp" android:layout_height="@dimen/_24sdp" android:src="@drawable/ic_premi
res/layout/offline_ads_dialog.xml:7: <TextView android:textColor="@android:color/darker_gray" android:gravity="center" android:id="@id/offline_dialog_advertiser_name" android:paddingTop="12.0dp" android:visibility="gone" android:layout_width="match_parent" 
res/values/ids.xml:116: <id name="bannerAd" />
res/values/ids.xml:148: <id name="btnBuyPremium" />
res/values/ids.xml:220: <id name="conBuyPremiumCard" />
res/values/ids.xml:416: <id name="ivPremiumCrown" />
res/values/ids.xml:578: <id name="offline_dialog_advertiser_name" />
res/values/ids.xml:834: <id name="tvPremiumTitle" />
res/values/public.xml:3202: <public type="drawable" name="admob_close_button_black_circle_white_cross" id="0x7f07007f" />
res/values/public.xml:3203: <public type="drawable" name="admob_close_button_white_circle_black_cross" id="0x7f070080" />
res/values/public.xml:3204: <public type="drawable" name="admob_close_button_white_cross" id="0x7f070081" />
res/values/public.xml:3227: <public type="drawable" name="btn_buy_premium" id="0x7f07009a" />
res/values/public.xml:3377: <public type="drawable" name="ic_premium_close_mini" id="0x7f07014a" />
res/values/public.xml:3378: <public type="drawable" name="ic_premium_crown" id="0x7f07014b" />
res/values/public.xml:3646: <public type="id" name="bannerAd" id="0x7f090071" />
res/values/public.xml:3678: <public type="id" name="btnBuyPremium" id="0x7f090091" />
res/values/public.xml:3750: <public type="id" name="conBuyPremiumCard" id="0x7f0900d9" />
res/values/public.xml:3946: <public type="id" name="ivPremiumCrown" id="0x7f09019d" />
res/values/public.xml:4108: <public type="id" name="offline_dialog_advertiser_name" id="0x7f09023f" />
res/values/public.xml:4364: <public type="id" name="tvPremiumTitle" id="0x7f09033f" />
res/values/public.xml:4534: <public type="layout" name="activity_buy_premium" id="0x7f0c001d" />
res/values/public.xml:4563: <public type="layout" name="admob_empty_layout" id="0x7f0c003a" />
res/values/public.xml:4611: <public type="layout" name="layout_banner_ad" id="0x7f0c006f" />
res/values/public.xml:4923: <public type="string" name="offline_notification_title_with_advertiser" id="0x7f1200f1" />
res/values/strings.xml:230: <string name="offline_notification_title_with_advertiser">You are back online! Continue learning about %s</string>
res/values/strings.xml:233: <string name="offline_opt_in_message">"We'll send you a notification with a link to the advertiser site."</string>
res/values/strings.xml:284: <string name="watermark_label_prefix">"AdMob - "</string>
res/values-ar/strings.xml:137: <string name="offline_notification_title_with_advertiser">تمت إعادة الاتصال بالإنترنت وبإمكانك الآن مواصلة التعرّف على \"%s\"</string>
res/values-ar/strings.xml:155: <string name="watermark_label_prefix">AdMob -</string>
res/values-de/strings.xml:136: <string name="offline_notification_title_with_advertiser">Du bist wieder online! Weitere Informationen zu %s</string>
res/values-de/strings.xml:160: <string name="watermark_label_prefix">AdMob –</string>
res/values-en-rGB/strings.xml:136: <string name="offline_notification_title_with_advertiser">You are back online! Continue learning about %s</string>
res/values-en-rGB/strings.xml:139: <string name="offline_opt_in_message">"We'll send you a notification with a link to the advertiser site."</string>
res/values-en-rGB/strings.xml:154: <string name="watermark_label_prefix">AdMob –</string>
res/values-es/strings.xml:136: <string name="offline_notification_title_with_advertiser">Vuelves a estar online. Sigue informándote sobre %s.</string>
res/values-es/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-es-rUS/strings.xml:136: <string name="offline_notification_title_with_advertiser">Estás en línea nuevamente. Sigue aprendiendo sobre %s</string>
res/values-es-rUS/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-et/strings.xml:136: <string name="offline_notification_title_with_advertiser">Olete tagasi! %s ootab teid edasi tutvuma</string>
res/values-et/strings.xml:154: <string name="watermark_label_prefix">AdMob –</string>
res/values-fi/strings.xml:136: <string name="offline_notification_title_with_advertiser">Olet taas yhteydessä verkkoon. Lue lisää: %s</string>
res/values-fi/strings.xml:158: <string name="watermark_label_prefix">AdMob -</string>
res/values-fr/strings.xml:136: <string name="offline_notification_title_with_advertiser">Connexion Internet rétablie ! Continuez à découvrir %s</string>
res/values-fr/strings.xml:157: <string name="watermark_label_prefix">AdMob -</string>
res/values-fr-rCA/strings.xml:136: <string name="offline_notification_title_with_advertiser">Vous êtes de retour en ligne! Continuez à en apprendre davantage sur %s</string>
res/values-fr-rCA/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-hi/strings.xml:136: <string name="offline_notification_title_with_advertiser">आप फिर से ऑनलाइन हैं! %s के बारे में ज़्यादा जानें</string>
res/values-hi/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-hu/strings.xml:136: <string name="offline_notification_title_with_advertiser">Újra van internetkapcsolata. Ismerje meg részletesebben a következőt: %s.</string>
res/values-hu/strings.xml:154: <string name="watermark_label_prefix">AdMob –</string>
res/values-in/strings.xml:136: <string name="offline_notification_title_with_advertiser">Anda kembali online. Lanjutkan mempelajari tentang %s</string>
res/values-in/strings.xml:160: <string name="watermark_label_prefix">AdMob -</string>
res/values-it/strings.xml:136: <string name="offline_notification_title_with_advertiser">Sei di nuovo online Continua a scoprire informazioni su %s</string>
res/values-it/strings.xml:143: <string name="s2">"Consentire ad AdMob di memorizzare l'immagine nella galleria Immagini?"</string>
res/values-it/strings.xml:147: <string name="s6">Consentire ad AdMob di creare un evento di calendario?</string>
res/values-it/strings.xml:157: <string name="watermark_label_prefix">AdMob -</string>
res/values-ja/strings.xml:136: <string name="offline_notification_title_with_advertiser">オンラインになりました: %sについて続きをご確認ください</string>
res/values-ja/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-ko/strings.xml:136: <string name="offline_notification_title_with_advertiser">인터넷에 다시 연결되었습니다. %s에 관해 계속 알아보세요</string>
res/values-ko/strings.xml:157: <string name="watermark_label_prefix">AdMob -</string>
res/values-ms/strings.xml:136: <string name="offline_notification_title_with_advertiser">Anda sudah kembali dalam talian! Teruskan pembelajaran tentang %s</string>
res/values-ms/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-nl/strings.xml:136: <string name="offline_notification_title_with_advertiser">Je bent weer online. Ga verder met leren over %s.</string>
res/values-nl/strings.xml:139: <string name="offline_opt_in_message">We sturen je een melding met een link naar de site van de adverteerder.</string>
res/values-nl/strings.xml:140: <string name="offline_opt_in_title">Advertentie openen als je weer online bent</string>
res/values-nl/strings.xml:143: <string name="s2">Advertentie toestaan om afbeelding op te slaan in fotogalerij?</string>
res/values-nl/strings.xml:147: <string name="s6">Advertentie toestaan om een agenda-afspraak te maken?</string>
res/values-nl/strings.xml:148: <string name="s7">Testadvertentie</string>
res/values-nl/strings.xml:160: <string name="watermark_label_prefix">AdMob -</string>
res/values-pl/strings.xml:136: <string name="offline_notification_title_with_advertiser">Znów jesteś online. Dowiedz się więcej o reklamodawcy %s</string>
res/values-pl/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-pt-rBR/strings.xml:136: <string name="offline_notification_title_with_advertiser">Você está on-line de novo. Continue aprendendo sobre %s</string>
res/values-pt-rBR/strings.xml:154: <string name="watermark_label_prefix">AdMob -</string>
res/values-pt-rPT/strings.xml:136: <string name="offline_notification_title_with_advertiser">Está novamente online! Continue a aprender sobre %s</string>
res/values-pt-rPT/strings.xml:154: <string name="watermark_label_prefix">AdMob –</string>
res/values-ru/strings.xml:136: <string name="offline_notification_title_with_advertiser">Вы подключились к интернету. Узнайте больше о рекламодателе (%s)</string>
res/values-ru/strings.xml:160: <string name="watermark_label_prefix">AdMob –</string>
res/values-sv/strings.xml:136: <string name="offline_notification_title_with_advertiser">Du är online igen. Fortsätt att läsa mer om %s</string>
res/values-sv/strings.xml:154: <string name="watermark_label_prefix">AdMob –</string>
res/values-th/strings.xml:136: <string name="offline_notification_title_with_advertiser">คุณกลับมาออนไลน์แล้ว เรียนรู้ข้อมูลเกี่ยวกับ %s ต่อ</string>
res/values-th/strings.xml:160: <string name="watermark_label_prefix">AdMob -</string>
res/values-tr/strings.xml:136: <string name="offline_notification_title_with_advertiser">İnternete tekrar bağlandınız. %s hakkında bilgi edinmeye devam edin</string>
res/values-tr/strings.xml:160: <string name="watermark_label_prefix">AdMob -</string>
