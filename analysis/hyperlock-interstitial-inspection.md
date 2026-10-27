HyperLock 0.1.2 — interstitial ad path

## .class public interface abstract Lcom/applovin/mediation/InterstitialAdManager$AdCallback; (smali/com/applovin/mediation/InterstitialAdManager$AdCallback.smali)
## .class public final Lcom/applovin/mediation/InterstitialAdManager$loadAd$1; (smali/com/applovin/mediation/InterstitialAdManager$loadAd$1.smali)
50: .method public final onAdFailedToLoad(Lcom/google/android/gms/ads/LoadAdError;)V
54: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
62: invoke-static {p0}, Lcom/applovin/mediation/InterstitialAdManager;->a(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V
74: return-void

77: .method public final onAdLoaded(Ljava/lang/Object;)V
85: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
90: invoke-static {p1}, Lcom/applovin/mediation/InterstitialAdManager;->a(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V
102: return-void

## .class public final Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1; (smali/com/applovin/mediation/InterstitialAdManager$performShowAd$1$1.smali)
35: .method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
39: iput-object p1, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->a:Landroid/app/Activity;
43: iput-object p2, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->b:Ljava/lang/String;
47: iput-object p3, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
51: invoke-direct {p0}, Lcom/google/android/gms/ads/FullScreenContentCallback;-><init>()V
56: return-void

128: .method public final onAdFailedToShowFullScreenContent(Lcom/google/android/gms/ads/AdError;)V
132: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
140: invoke-static {p1}, Lcom/applovin/mediation/InterstitialAdManager;->a(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V
149: iget-object v0, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->a:Landroid/app/Activity;
153: iget-object v1, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->b:Ljava/lang/String;
157: invoke-virtual {p1, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
162: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
166: if-eqz p0, :cond_0
170: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
176: return-void

179: .method public final onAdShowedFullScreenContent()V
183: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
187: if-eqz p0, :cond_0
191: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->b()V
197: return-void

## .class public final Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1; (smali/com/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1.smali)
44: .method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
48: iput-object p1, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->a:Landroid/app/Activity;
52: iput-object p2, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->b:Ljava/lang/String;
56: iput-object p3, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
60: invoke-direct {p0}, Lcom/google/android/gms/ads/FullScreenContentCallback;-><init>()V
65: return-void

137: .method public final onAdFailedToShowFullScreenContent(Lcom/google/android/gms/ads/AdError;)V
141: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
149: invoke-static {p1}, Lcom/applovin/mediation/InterstitialAdManager;->a(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V
158: iget-object v0, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->b:Ljava/lang/String;
162: iget-object v1, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->a:Landroid/app/Activity;
166: invoke-virtual {p1, v1, v0}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
171: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
175: invoke-static {v1, p0}, Lcom/applovin/mediation/InterstitialAdManager;->f(Landroid/app/Activity;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
180: return-void

183: .method public final onAdShowedFullScreenContent()V
187: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;->c:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
191: if-eqz p0, :cond_0
195: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->b()V
201: return-void

## .class public final Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1; (smali/com/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1.smali)
31: .method public constructor <init>(Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
35: iput-object p1, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1;->a:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
39: invoke-direct {p0}, Lcom/google/android/gms/ads/FullScreenContentCallback;-><init>()V
44: return-void

91: .method public final onAdFailedToShowFullScreenContent(Lcom/google/android/gms/ads/AdError;)V
95: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
100: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1;->a:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
104: if-eqz p0, :cond_0
108: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
114: return-void

117: .method public final onAdShowedFullScreenContent()V
121: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1;->a:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
125: if-eqz p0, :cond_0
129: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->b()V
135: return-void

## .class public final Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1; (smali/com/applovin/mediation/InterstitialAdManager$showRewardedFallback$1.smali)
33: .method public constructor <init>(Landroid/app/Activity;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
37: iput-object p1, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->a:Landroid/app/Activity;
41: iput-object p2, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->b:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
45: invoke-direct {p0}, Lcom/google/android/gms/ads/rewarded/RewardedAdLoadCallback;-><init>()V
50: return-void

55: .method public final onAdFailedToLoad(Lcom/google/android/gms/ads/LoadAdError;)V
59: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
68: iget-object v0, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->a:Landroid/app/Activity;
72: invoke-virtual {p1, v0}, Lq7;->hide(Landroid/app/Activity;)V
77: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->b:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
81: if-eqz p0, :cond_0
85: invoke-interface {p0}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
91: return-void

94: .method public final onAdLoaded(Ljava/lang/Object;)V
102: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
111: iget-object v1, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->a:Landroid/app/Activity;
115: invoke-virtual {v0, v1}, Lq7;->hide(Landroid/app/Activity;)V
124: iget-object p0, p0, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;->b:Lcom/applovin/mediation/InterstitialAdManager$AdCallback;
128: invoke-direct {v0, p0}, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1$onAdLoaded$1;-><init>(Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
133: invoke-virtual {p1, v0}, Lcom/google/android/gms/ads/rewarded/RewardedAd;->setFullScreenContentCallback(Lcom/google/android/gms/ads/FullScreenContentCallback;)V
146: invoke-direct {p0, v0}, Lhv0;-><init>(I)V
151: invoke-virtual {p1, v1, p0}, Lcom/google/android/gms/ads/rewarded/RewardedAd;->show(Landroid/app/Activity;Lcom/google/android/gms/ads/OnUserEarnedRewardListener;)V
156: return-void

## .class public final Lcom/applovin/mediation/InterstitialAdManager; (smali/com/applovin/mediation/InterstitialAdManager.smali)
94: .method public static final synthetic a(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V
102: return-void

130: .method public static final d(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
138: invoke-virtual {v0, p0}, Lq7;->hide(Landroid/app/Activity;)V
147: if-eqz v0, :cond_0
155: invoke-direct {v1, p0, p1, p2}, Lcom/applovin/mediation/InterstitialAdManager$performShowAd$1$1;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
160: invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->setFullScreenContentCallback(Lcom/google/android/gms/ads/FullScreenContentCallback;)V
170: if-eqz p1, :cond_1
174: invoke-virtual {p1, p0}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->show(Landroid/app/Activity;)V
180: return-void

183: .method public static final e(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
191: invoke-virtual {v0, p0}, Lq7;->hide(Landroid/app/Activity;)V
200: if-eqz v0, :cond_0
208: invoke-direct {v1, p0, p1, p2}, Lcom/applovin/mediation/InterstitialAdManager$showAdWithRewardFallback$1$1;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
213: invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->setFullScreenContentCallback(Lcom/google/android/gms/ads/FullScreenContentCallback;)V
223: if-eqz p1, :cond_1
227: invoke-virtual {p1, p0}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->show(Landroid/app/Activity;)V
233: return-void

236: .method public static f(Landroid/app/Activity;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
244: invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
253: if-nez v1, :cond_3
257: invoke-virtual {v0, p0}, Ldc;->isDeviceOnline(Landroid/content/Context;)Z
265: if-nez v0, :cond_0
277: invoke-direct {v0, p0}, Lx24;-><init>(Landroid/content/Context;)V
282: invoke-virtual {v0}, Lx24;->getAdmobRewardedCommonAdUnit()Ljava/lang/String;
290: if-nez v0, :cond_1
294: const-string v0, ""
299: invoke-virtual {v0}, Ljava/lang/String;->length()I
307: if-nez v1, :cond_2
311: if-eqz p1, :cond_4
315: invoke-interface {p1}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
320: return-void
328: invoke-virtual {v1, p0}, Lq7;->show(Landroid/app/Activity;)V
337: invoke-direct {v1}, Lcom/google/android/gms/ads/AdRequest$Builder;-><init>()V
342: invoke-virtual {v1}, Lcom/google/android/gms/ads/AdRequest$Builder;->build()Lcom/google/android/gms/ads/AdRequest;
350: invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
359: invoke-direct {v2, p0, p1}, Lcom/applovin/mediation/InterstitialAdManager$showRewardedFallback$1;-><init>(Landroid/app/Activity;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
364: invoke-static {p0, v0, v1, v2}, Lcom/google/android/gms/ads/rewarded/RewardedAd;->load(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/AdRequest;Lcom/google/android/gms/ads/rewarded/RewardedAdLoadCallback;)V
369: return-void
374: if-eqz p1, :cond_4
378: invoke-interface {p1}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
384: return-void

389: .method public final c(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
397: invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
406: if-eqz v1, :cond_0
410: if-eqz p3, :cond_3
414: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
419: return-void
423: invoke-virtual {v0, p1}, Ldc;->isDeviceOnline(Landroid/content/Context;)Z
431: if-nez v0, :cond_1
435: if-eqz p3, :cond_3
439: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
444: return-void
452: if-eqz v0, :cond_2
460: invoke-virtual {p0, p1}, Lq7;->show(Landroid/app/Activity;)V
469: invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
477: invoke-direct {p0, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
489: invoke-direct {v0, p1, p2, p3, v1}, Li22;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;I)V
498: invoke-virtual {p0, v0, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
503: return-void
507: invoke-virtual {p0, p1, p2}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
512: if-eqz p3, :cond_3
516: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
522: return-void

525: .method public final loadAd(Landroid/app/Activity;Ljava/lang/String;)V
529: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
538: invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
547: if-eqz p0, :cond_0
559: if-nez p0, :cond_4
567: if-eqz p0, :cond_1
582: if-nez p2, :cond_2
590: invoke-direct {p0, p1}, Lx24;-><init>(Landroid/content/Context;)V
595: invoke-virtual {p0}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
603: if-nez p2, :cond_2
607: const-string p2, ""
612: invoke-interface {p2}, Ljava/lang/CharSequence;->length()I
620: if-nez p0, :cond_3
631: return-void
639: invoke-direct {p0}, Lcom/google/android/gms/ads/AdRequest$Builder;-><init>()V
644: invoke-virtual {p0}, Lcom/google/android/gms/ads/AdRequest$Builder;->build()Lcom/google/android/gms/ads/AdRequest;
652: invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
661: invoke-direct {v0}, Lcom/applovin/mediation/InterstitialAdManager$loadAd$1;-><init>()V
666: invoke-static {p1, p2, p0, v0}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->load(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/AdRequest;Lcom/google/android/gms/ads/interstitial/InterstitialAdLoadCallback;)V
673: return-void

676: .method public final showAdWithCount(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
680: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
689: invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
698: if-eqz v0, :cond_0
702: if-eqz p3, :cond_1
706: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
711: return-void
731: if-eqz v0, :cond_2
735: if-eqz p3, :cond_1
739: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
745: return-void
749: invoke-virtual {p0, p1, p2, p3}, Lcom/applovin/mediation/InterstitialAdManager;->c(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
754: return-void

757: .method public final showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
761: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
770: invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
779: if-eqz v1, :cond_0
783: if-eqz p3, :cond_1
787: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->a()V
792: return-void
796: invoke-virtual {v0, p1}, Ldc;->isDeviceOnline(Landroid/content/Context;)Z
804: if-nez v0, :cond_2
808: if-eqz p3, :cond_1
812: invoke-interface {p3}, Lcom/applovin/mediation/InterstitialAdManager$AdCallback;->c()V
818: return-void
826: if-eqz v0, :cond_3
834: invoke-virtual {p0, p1}, Lq7;->show(Landroid/app/Activity;)V
843: invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
851: invoke-direct {p0, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
863: invoke-direct {v0, p1, p2, p3, v1}, Li22;-><init>(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;I)V
872: invoke-virtual {p0, v0, p1, p2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
877: return-void
881: invoke-virtual {p0, p1, p2}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
886: invoke-static {p1, p3}, Lcom/applovin/mediation/InterstitialAdManager;->f(Landroid/app/Activity;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
891: return-void

894: .method public final showAdWithoutCount(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
898: invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
903: invoke-virtual {p0, p1, p2, p3}, Lcom/applovin/mediation/InterstitialAdManager;->c(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
908: return-void


## HyperLock caller methods referencing the interstitial manager or ad unit keys

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/AllImagesSeeActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1465: invoke-virtual {v0, p1}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 44
  
  .line 45

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onClick(Landroid/view/View;)V | line 1075: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onClick(Landroid/view/View;)V | line 1087: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onClick(Landroid/view/View;)V | line 1104: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onCreate(Landroid/os/Bundle;)V | line 1959: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onCreate(Landroid/os/Bundle;)V | line 1990: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onCreate(Landroid/os/Bundle;)V | line 2002: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA1; | .method public onCreate(Landroid/os/Bundle;)V | line 2010: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onClick(Landroid/view/View;)V | line 1258: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onClick(Landroid/view/View;)V | line 1270: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onClick(Landroid/view/View;)V | line 1287: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onCreate(Landroid/os/Bundle;)V | line 2142: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onCreate(Landroid/os/Bundle;)V | line 2173: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onCreate(Landroid/os/Bundle;)V | line 2185: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA2; | .method public onCreate(Landroid/os/Bundle;)V | line 2193: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onClick(Landroid/view/View;)V | line 1036: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onClick(Landroid/view/View;)V | line 1048: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onClick(Landroid/view/View;)V | line 1065: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onCreate(Landroid/os/Bundle;)V | line 1922: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onCreate(Landroid/os/Bundle;)V | line 1953: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onCreate(Landroid/os/Bundle;)V | line 1965: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA3; | .method public onCreate(Landroid/os/Bundle;)V | line 1973: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onClick(Landroid/view/View;)V | line 1062: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onClick(Landroid/view/View;)V | line 1074: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onClick(Landroid/view/View;)V | line 1091: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onCreate(Landroid/os/Bundle;)V | line 1863: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onCreate(Landroid/os/Bundle;)V | line 1894: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onCreate(Landroid/os/Bundle;)V | line 1906: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA4; | .method public onCreate(Landroid/os/Bundle;)V | line 1914: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onClick(Landroid/view/View;)V | line 1109: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onClick(Landroid/view/View;)V | line 1121: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onClick(Landroid/view/View;)V | line 1138: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onCreate(Landroid/os/Bundle;)V | line 1995: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onCreate(Landroid/os/Bundle;)V | line 2026: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onCreate(Landroid/os/Bundle;)V | line 2038: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA5; | .method public onCreate(Landroid/os/Bundle;)V | line 2046: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onClick(Landroid/view/View;)V | line 1114: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onClick(Landroid/view/View;)V | line 1126: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onClick(Landroid/view/View;)V | line 1143: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onCreate(Landroid/os/Bundle;)V | line 2000: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onCreate(Landroid/os/Bundle;)V | line 2031: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onCreate(Landroid/os/Bundle;)V | line 2043: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA6; | .method public onCreate(Landroid/os/Bundle;)V | line 2051: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onClick(Landroid/view/View;)V | line 1115: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onClick(Landroid/view/View;)V | line 1127: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onClick(Landroid/view/View;)V | line 1144: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onCreate(Landroid/os/Bundle;)V | line 1916: invoke-virtual {p1, v4}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onCreate(Landroid/os/Bundle;)V | line 1947: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onCreate(Landroid/os/Bundle;)V | line 1959: invoke-virtual {v4}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA7; | .method public onCreate(Landroid/os/Bundle;)V | line 1967: invoke-virtual {p1, p0, v4}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onClick(Landroid/view/View;)V | line 952: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onClick(Landroid/view/View;)V | line 964: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onClick(Landroid/view/View;)V | line 981: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onCreate(Landroid/os/Bundle;)V | line 1838: invoke-virtual {p1, v3}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onCreate(Landroid/os/Bundle;)V | line 1869: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onCreate(Landroid/os/Bundle;)V | line 1881: invoke-virtual {v3}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA8; | .method public onCreate(Landroid/os/Bundle;)V | line 1889: invoke-virtual {p1, p0, v3}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onClick(Landroid/view/View;)V | line 1158: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 47
  .line 48
  
  .line 49

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onClick(Landroid/view/View;)V | line 1170: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 53
  .line 54
  
  .line 55

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onClick(Landroid/view/View;)V | line 1187: invoke-virtual {p1, p0, v0, v1}, Lcom/applovin/mediation/InterstitialAdManager;->showAdWithRewardFallback(Landroid/app/Activity;Ljava/lang/String;Lcom/applovin/mediation/InterstitialAdManager$AdCallback;)V
  .line 62
  .line 63
  
  .line 64

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onCreate(Landroid/os/Bundle;)V | line 2044: invoke-virtual {v0, v2}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 87
  
  .line 88

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onCreate(Landroid/os/Bundle;)V | line 2075: sget-object v0, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 103
  .line 104
  
  .line 105

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onCreate(Landroid/os/Bundle;)V | line 2087: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 109
  .line 110
  
  .line 111

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CA/CA9; | .method public onCreate(Landroid/os/Bundle;)V | line 2095: invoke-virtual {v0, p0, v2}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 114
  
  .line 115

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePasswordActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 794: sget-object v0, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 30
  .line 31
  
  .line 32

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePasswordActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 798: invoke-virtual {p1}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 32
  .line 33
  
  .line 34

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePasswordActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 806: invoke-virtual {v0, p0, p1}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 37
  
  .line 38

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePatternActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 205: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 54
  .line 55
  
  .line 56

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePatternActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 220: invoke-virtual {v0}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 61
  .line 62
  
  .line 63

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/CreatePatternActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 228: invoke-virtual {p1, p0, v0}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 66
  
  .line 67

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/IntroActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 699: invoke-virtual {v0, p1}, Lcom/applovin/mediation/NativeAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 44
  
  .line 45

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/IntroActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 742: invoke-virtual {p1, v2}, Lcom/applovin/mediation/NativeAdLayout;->loadAd(Ljava/lang/String;)V
  .line 66
  .line 67
  
  .line 68

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/MainActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1887: invoke-virtual {p1, v2}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 57
  
  .line 58

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/SettingActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1496: invoke-virtual {p1, v2}, Lcom/applovin/mediation/BannerAdLayout;->loadAd(Ljava/lang/String;)V
  
  .line 57
  
  .line 58

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/SettingActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1527: sget-object p1, Lcom/applovin/mediation/InterstitialAdManager;->INSTANCE:Lcom/applovin/mediation/InterstitialAdManager;
  .line 73
  .line 74
  
  .line 75

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/SettingActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1539: invoke-virtual {v2}, Lx24;->getAdmobInterstitialCommonAdUnit()Ljava/lang/String;
  .line 79
  .line 80
  
  .line 81

.class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/SettingActivity; | .method public onCreate(Landroid/os/Bundle;)V | line 1547: invoke-virtual {p1, p0, v2}, Lcom/applovin/mediation/InterstitialAdManager;->loadAd(Landroid/app/Activity;Ljava/lang/String;)V
  
  .line 84
  
  .line 85

