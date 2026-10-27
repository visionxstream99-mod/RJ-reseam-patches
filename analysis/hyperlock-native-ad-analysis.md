HyperLock 0.1.2 — native/rewarded ad path inspection

Inspection only; this file is not an installable patch.

## .class public final synthetic Lbo7; — smali/bo7.smali
.method public final zza(Ljava/lang/Object;)Lih2;
   80: .method public final zza(Ljava/lang/Object;)Lih2;
  436: 
  437:     .line 170
  438:     .line 171
  439:     invoke-interface/range {v8 .. v31}, Lc77;->zzab(Lcom/google/android/gms/ads/internal/client/zza;Lun6;Lcom/google/android/gms/ads/internal/overlay/zzr;Lvn6;Lcom/google/android/gms/ads/internal/overlay/zzad;ZLjo6;Lcom/google/android/gms/ads/internal/zzb;Lev6;Lk07;Lgx7;Lwe8;Lxr7;Lyo6;Lxj7;Lxo6;Lqo6
  440: 
  441:     .line 172
  442:     .line 173
  443:     .line 174
  444:     const-string v6, "/getNativeAdViewSignals"
  445: 
  446:     .line 175
  447:     .line 176
  448:     sget-object v8, Lgo6;->n:Lyn6;
  449: 
  450:     .line 177
  451:     .line 178
  452:     invoke-interface {v2, v6, v8}, Lt57;->L(Ljava/lang/String;Lho6;)V
  453: 
  649: .end method
(method body truncated to match context)

## .class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/AllImagesSeeActivity; — smali/com/appiolab/hyperlock_screen_and_aod/Activitys/AllImagesSeeActivity.smali
.method public final m(Lf25;)V
  123: .method public final m(Lf25;)V
  476:     .line 178
  477:     const/4 v4, 0x0
  478: 
  479:     .line 179
  480:     if-eqz v3, :cond_5
  481: 
  482:     .line 180
  483:     .line 181
  484:     invoke-virtual {v3}, Lx24;->getAdmobNativeCommonAdUnit()Ljava/lang/String;
  485: 
  486:     .line 182
  487:     .line 183
  488:     .line 184
  489:     move-result-object v3
  490: 
  491:     .line 185
  492:     new-instance v5, Lu8;
  493: 
  591: .end method
(method body truncated to match context)

## .class public final Lcom/appiolab/hyperlock_screen_and_aod/Activitys/IntroActivity; — smali/com/appiolab/hyperlock_screen_and_aod/Activitys/IntroActivity.smali
.method public onCreate(Landroid/os/Bundle;)V
  612: .method public onCreate(Landroid/os/Bundle;)V
  683:     if-eqz v0, :cond_6
  684: 
  685:     .line 37
  686:     .line 38
  687:     iget-object v0, v0, Ls5;->nativeAdLayout:Lcom/applovin/mediation/NativeAdLayout;
  688: 
  689:     .line 39
  690:     .line 40
  691:     invoke-virtual {p1}, Lx24;->getAdmobNativeCommonAdUnit()Ljava/lang/String;
  692: 
  693:     .line 41
  694:     .line 42
  695:     .line 43
  696:     move-result-object p1
  697: 
  698:     .line 44
  699:     invoke-virtual {v0, p1}, Lcom/applovin/mediation/NativeAdLayout;->loadAd(Ljava/lang/String;)V
  700: 
  925: .end method
(method body truncated to match context)

## .class public abstract Lcom/google/ads/mediation/AbstractAdViewAdapter; — smali/com/google/ads/mediation/AbstractAdViewAdapter.smali
.method public newAdLoader(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/ads/AdLoader$Builder;
  305: .method public newAdLoader(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/ads/AdLoader$Builder;
  306:     .locals 0
  307: 
  308:     .line 1
  309:     new-instance p0, Lcom/google/android/gms/ads/AdLoader$Builder;
  310: 
  311:     .line 2
  312:     .line 3
  313:     invoke-direct {p0, p1, p2}, Lcom/google/android/gms/ads/AdLoader$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V
  314: 
  315:     .line 4
  316:     .line 5
  317:     .line 6
  318:     return-object p0
  319: .end method

## .class public abstract Lcom/google/ads/mediation/AbstractAdViewAdapter; — smali/com/google/ads/mediation/AbstractAdViewAdapter.smali
.method public requestNativeAd(Landroid/content/Context;Lcom/google/android/gms/ads/mediation/MediationNativeListener;Landroid/os/Bundle;Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;Landroid/os/Bundle;)V
  577: .method public requestNativeAd(Landroid/content/Context;Lcom/google/android/gms/ads/mediation/MediationNativeListener;Landroid/os/Bundle;Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;Landroid/os/Bundle;)V
  578:     .locals 5
  579: 
  580:     .line 1
  581:     new-instance v0, Lpr7;
  582: 
  583:     .line 2
  584:     .line 3
  585:     invoke-direct {v0, p0, p2}, Lpr7;-><init>(Lcom/google/ads/mediation/AbstractAdViewAdapter;Lcom/google/android/gms/ads/mediation/MediationNativeListener;)V
  586: 
  587:     .line 4
  588:     .line 5
  589:     .line 6
  590:     const-string p2, "pubid"
  591: 
  592:     .line 7
  593:     .line 8
  594:     invoke-virtual {p3, p2}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;
  595: 
  596:     .line 9
  597:     .line 10
  598:     .line 11
  599:     move-result-object p2
  600: 
  601:     .line 12
  602:     invoke-virtual {p0, p1, p2}, Lcom/google/ads/mediation/AbstractAdViewAdapter;->newAdLoader(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/ads/AdLoader$Builder;
  603: 
  604:     .line 13
  605:     .line 14
  606:     .line 15
  607:     move-result-object p2
  608: 
  609:     .line 16
  610:     invoke-virtual {p2, v0}, Lcom/google/android/gms/ads/AdLoader$Builder;->withAdListener(Lcom/google/android/gms/ads/AdListener;)Lcom/google/android/gms/ads/AdLoader$Builder;
  611: 
  612:     .line 17
  613:     .line 18
  614:     .line 19
  615:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->getNativeAdOptions()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  616: 
  617:     .line 20
  618:     .line 21
  619:     .line 22
  620:     move-result-object v1
  621: 
  622:     .line 23
  623:     invoke-virtual {p2, v1}, Lcom/google/android/gms/ads/AdLoader$Builder;->zzc(Lcom/google/android/gms/ads/formats/NativeAdOptions;)Lcom/google/android/gms/ads/AdLoader$Builder;
  624: 
  625:     .line 24
  626:     .line 25
  627:     .line 26
  628:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->getNativeAdRequestOptions()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  629: 
  630:     .line 27
  631:     .line 28
  632:     .line 29
  633:     move-result-object v1
  634: 
  635:     .line 30
  636:     invoke-virtual {p2, v1}, Lcom/google/android/gms/ads/AdLoader$Builder;->withNativeAdOptions(Lcom/google/android/gms/ads/nativead/NativeAdOptions;)Lcom/google/android/gms/ads/AdLoader$Builder;
  637: 
  638:     .line 31
  639:     .line 32
  640:     .line 33
  641:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->isUnifiedNativeAdRequested()Z
  642: 
  643:     .line 34
  644:     .line 35
  645:     .line 36
  646:     move-result v1
  647: 
  648:     .line 37
  649:     if-eqz v1, :cond_0
  650: 
  651:     .line 38
  652:     .line 39
  653:     invoke-virtual {p2, v0}, Lcom/google/android/gms/ads/AdLoader$Builder;->zza(Lcom/google/android/gms/ads/formats/zzg;)Lcom/google/android/gms/ads/AdLoader$Builder;
  654: 
  655:     .line 40
  656:     .line 41
  657:     .line 42
  658:     :cond_0
  659:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->zza()Z
  660: 
  661:     .line 43
  662:     .line 44
  663:     .line 45
  664:     move-result v1
  665: 
  666:     .line 46
  667:     if-eqz v1, :cond_2
  668: 
  669:     .line 47
  670:     .line 48
  671:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->zzb()Ljava/util/Map;
  672: 
  673:     .line 49
  674:     .line 50
  675:     .line 51
  676:     move-result-object v1
  677: 
  678:     .line 52
  679:     invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;
  680: 
  681:     .line 53
  682:     .line 54
  683:     .line 55
  684:     move-result-object v1
  685: 
  686:     .line 56
  687:     invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;
  688: 
  689:     .line 57
  690:     .line 58
  691:     .line 59
  692:     move-result-object v1
  693: 
  694:     .line 60
  695:     :goto_0
  696:     invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z
  697: 
  698:     .line 61
  699:     .line 62
  700:     .line 63
  701:     move-result v2
  702: 
  703:     .line 64
  704:     if-eqz v2, :cond_2
  705: 
  706:     .line 65
  707:     .line 66
  708:     invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;
  709: 
  710:     .line 67
  711:     .line 68
  712:     .line 69
  713:     move-result-object v2
  714: 
  715:     .line 70
  716:     check-cast v2, Ljava/lang/String;
  717: 
  718:     .line 71
  719:     .line 72
  720:     invoke-interface {p4}, Lcom/google/android/gms/ads/mediation/NativeMediationAdRequest;->zzb()Ljava/util/Map;
  721: 
  722:     .line 73
  723:     .line 74
  724:     .line 75
  725:     move-result-object v3
  726: 
  727:     .line 76
  728:     invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
  729: 
  730:     .line 77
  731:     .line 78
  732:     .line 79
  733:     move-result-object v3
  734: 
  735:     .line 80
  736:     check-cast v3, Ljava/lang/Boolean;
  737: 
  738:     .line 81
  739:     .line 82
  740:     invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z
  741: 
  742:     .line 83
  743:     .line 84
  744:     .line 85
  745:     move-result v3
  746: 
  747:     .line 86
  748:     const/4 v4, 0x1
  749: 
  750:     .line 87
  751:     if-eq v4, v3, :cond_1
  752: 
  753:     .line 88
  754:     .line 89
  755:     const/4 v3, 0x0
  756: 
  757:     .line 90
  758:     goto :goto_1
  759: 
  760:     .line 91
  761:     :cond_1
  762:     move-object v3, v0
  763: 
  764:     .line 92
  765:     :goto_1
  766:     invoke-virtual {p2, v2, v0, v3}, Lcom/google/android/gms/ads/AdLoader$Builder;->zzb(Ljava/lang/String;Lcom/google/android/gms/ads/formats/zze;Lcom/google/android/gms/ads/formats/zzd;)Lcom/google/android/gms/ads/AdLoader$Builder;
  767: 
  768:     .line 93
  769:     .line 94
  770:     .line 95
  771:     goto :goto_0
  772: 
  773:     .line 96
  774:     :cond_2
  775:     invoke-virtual {p2}, Lcom/google/android/gms/ads/AdLoader$Builder;->build()Lcom/google/android/gms/ads/AdLoader;
  776: 
  777:     .line 97
  778:     .line 98
  779:     .line 99
  780:     move-result-object p2
  781: 
  782:     .line 100
  783:     iput-object p2, p0, Lcom/google/ads/mediation/AbstractAdViewAdapter;->adLoader:Lcom/google/android/gms/ads/AdLoader;
  784: 
  785:     .line 101
  786:     .line 102
  787:     invoke-virtual {p0, p1, p4, p5, p3}, Lcom/google/ads/mediation/AbstractAdViewAdapter;->buildAdRequest(Landroid/content/Context;Lcom/google/android/gms/ads/mediation/MediationAdRequest;Landroid/os/Bundle;Landroid/os/Bundle;)Lcom/google/android/gms/ads/AdRequest;
  788: 
  789:     .line 103
  790:     .line 104
  791:     .line 105
  792:     move-result-object p0
  793: 
  794:     .line 106
  795:     invoke-virtual {p2, p0}, Lcom/google/android/gms/ads/AdLoader;->loadAd(Lcom/google/android/gms/ads/AdRequest;)V
  796: 
  797:     .line 107
  798:     .line 108
  799:     .line 109
  800:     return-void
  801: .end method

## .class public final Lgl6; — smali/gl6.smali
.method public constructor <init>(Lcom/google/android/gms/ads/formats/NativeAdOptions;)V
   98: .method public constructor <init>(Lcom/google/android/gms/ads/formats/NativeAdOptions;)V
   99:     .locals 12
  100:     .annotation runtime Ljava/lang/Deprecated;
  101:     .end annotation
  102: 
  103:     .line 1
  104:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->shouldReturnUrlsForImageAssets()Z
  105: 
  106:     .line 2
  107:     .line 3
  108:     .line 4
  109:     move-result v2
  110: 
  111:     .line 5
  112:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->getImageOrientation()I
  113: 
  114:     .line 6
  115:     .line 7
  116:     .line 8
  117:     move-result v3
  118: 
  119:     .line 9
  120:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->shouldRequestMultipleImages()Z
  121: 
  122:     .line 10
  123:     .line 11
  124:     .line 12
  125:     move-result v4
  126: 
  127:     .line 13
  128:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->getAdChoicesPlacement()I
  129: 
  130:     .line 14
  131:     .line 15
  132:     .line 16
  133:     move-result v5
  134: 
  135:     .line 17
  136:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->getVideoOptions()Lcom/google/android/gms/ads/VideoOptions;
  137: 
  138:     .line 18
  139:     .line 19
  140:     .line 20
  141:     move-result-object v0
  142: 
  143:     .line 21
  144:     if-eqz v0, :cond_0
  145: 
  146:     .line 22
  147:     .line 23
  148:     new-instance v0, Lcom/google/android/gms/ads/internal/client/zzfw;
  149: 
  150:     .line 24
  151:     .line 25
  152:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->getVideoOptions()Lcom/google/android/gms/ads/VideoOptions;
  153: 
  154:     .line 26
  155:     .line 27
  156:     .line 28
  157:     move-result-object v1
  158: 
  159:     .line 29
  160:     invoke-direct {v0, v1}, Lcom/google/android/gms/ads/internal/client/zzfw;-><init>(Lcom/google/android/gms/ads/VideoOptions;)V
  161: 
  162:     .line 30
  163:     .line 31
  164:     .line 32
  165:     :goto_0
  166:     move-object v6, v0
  167: 
  168:     .line 33
  169:     goto :goto_1
  170: 
  171:     .line 34
  172:     :cond_0
  173:     const/4 v0, 0x0
  174: 
  175:     .line 35
  176:     goto :goto_0
  177: 
  178:     .line 36
  179:     :goto_1
  180:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->zza()Z
  181: 
  182:     .line 37
  183:     .line 38
  184:     .line 39
  185:     move-result v7
  186: 
  187:     .line 40
  188:     invoke-virtual {p1}, Lcom/google/android/gms/ads/formats/NativeAdOptions;->getMediaAspectRatio()I
  189: 
  190:     .line 41
  191:     .line 42
  192:     .line 43
  193:     move-result v8
  194: 
  195:     .line 44
  196:     const/4 v10, 0x0
  197: 
  198:     .line 45
  199:     const/4 v11, 0x0
  200: 
  201:     .line 46
  202:     const/4 v1, 0x4
  203: 
  204:     .line 47
  205:     const/4 v9, 0x0
  206: 
  207:     .line 48
  208:     move-object v0, p0
  209: 
  210:     .line 49
  211:     invoke-direct/range {v0 .. v11}, Lgl6;-><init>(IZIZILcom/google/android/gms/ads/internal/client/zzfw;ZIIZI)V
  212: 
  213:     .line 50
  214:     .line 51
  215:     .line 52
  216:     return-void
  217: .end method

## .class public final Lgl6; — smali/gl6.smali
.method public static zza(Lgl6;)Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  219: .method public static zza(Lgl6;)Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  220:     .locals 5
  221: 
  222:     .line 1
  223:     new-instance v0, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  224: 
  225:     .line 2
  226:     .line 3
  227:     invoke-direct {v0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;-><init>()V
  228: 
  229:     .line 4
  230:     .line 5
  231:     .line 6
  232:     if-nez p0, :cond_0
  233: 
  234:     .line 7
  235:     .line 8
  236:     invoke-virtual {v0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  237: 
  238:     .line 9
  239:     .line 10
  240:     .line 11
  241:     move-result-object p0
  242: 
  243:     .line 12
  244:     return-object p0
  245: 
  246:     .line 13
  247:     :cond_0
  248:     iget v1, p0, Lgl6;->zza:I
  249: 
  250:     .line 14
  251:     .line 15
  252:     const/4 v2, 0x2
  253: 
  254:     .line 16
  255:     if-eq v1, v2, :cond_6
  256: 
  257:     .line 17
  258:     .line 18
  259:     const/4 v3, 0x3
  260: 
  261:     .line 19
  262:     if-eq v1, v3, :cond_5
  263: 
  264:     .line 20
  265:     .line 21
  266:     const/4 v4, 0x4
  267: 
  268:     .line 22
  269:     if-eq v1, v4, :cond_1
  270: 
  271:     .line 23
  272:     .line 24
  273:     goto :goto_1
  274: 
  275:     .line 25
  276:     :cond_1
  277:     iget-boolean v1, p0, Lgl6;->zzg:Z
  278: 
  279:     .line 26
  280:     .line 27
  281:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setRequestCustomMuteThisAd(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  282: 
  283:     .line 28
  284:     .line 29
  285:     .line 30
  286:     iget v1, p0, Lgl6;->zzh:I
  287: 
  288:     .line 31
  289:     .line 32
  290:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setMediaAspectRatio(I)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  291: 
  292:     .line 33
  293:     .line 34
  294:     .line 35
  295:     iget v1, p0, Lgl6;->zzi:I
  296: 
  297:     .line 36
  298:     .line 37
  299:     iget-boolean v4, p0, Lgl6;->zzj:Z
  300: 
  301:     .line 38
  302:     .line 39
  303:     invoke-virtual {v0, v1, v4}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->enableCustomClickGestureDirection(IZ)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  304: 
  305:     .line 40
  306:     .line 41
  307:     .line 42
  308:     iget v1, p0, Lgl6;->zzk:I
  309: 
  310:     .line 43
  311:     .line 44
  312:     const/4 v4, 0x1
  313: 
  314:     .line 45
  315:     if-nez v1, :cond_3
  316: 
  317:     .line 46
  318:     .line 47
  319:     :cond_2
  320:     move v2, v4
  321: 
  322:     .line 48
  323:     goto :goto_0
  324: 
  325:     .line 49
  326:     :cond_3
  327:     if-ne v1, v2, :cond_4
  328: 
  329:     .line 50
  330:     .line 51
  331:     move v2, v3
  332: 
  333:     .line 52
  334:     goto :goto_0
  335: 
  336:     .line 53
  337:     :cond_4
  338:     if-ne v1, v4, :cond_2
  339: 
  340:     .line 54
  341:     .line 55
  342:     :goto_0
  343:     invoke-virtual {v0, v2}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->zzi(I)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  344: 
  345:     .line 56
  346:     .line 57
  347:     .line 58
  348:     :cond_5
  349:     iget-object v1, p0, Lgl6;->zzf:Lcom/google/android/gms/ads/internal/client/zzfw;
  350: 
  351:     .line 59
  352:     .line 60
  353:     if-eqz v1, :cond_6
  354: 
  355:     .line 61
  356:     .line 62
  357:     new-instance v2, Lcom/google/android/gms/ads/VideoOptions;
  358: 
  359:     .line 63
  360:     .line 64
  361:     invoke-direct {v2, v1}, Lcom/google/android/gms/ads/VideoOptions;-><init>(Lcom/google/android/gms/ads/internal/client/zzfw;)V
  362: 
  363:     .line 65
  364:     .line 66
  365:     .line 67
  366:     invoke-virtual {v0, v2}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setVideoOptions(Lcom/google/android/gms/ads/VideoOptions;)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  367: 
  368:     .line 68
  369:     .line 69
  370:     .line 70
  371:     :cond_6
  372:     iget v1, p0, Lgl6;->zze:I
  373: 
  374:     .line 71
  375:     .line 72
  376:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setAdChoicesPlacement(I)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  377: 
  378:     .line 73
  379:     .line 74
  380:     .line 75
  381:     :goto_1
  382:     iget-boolean v1, p0, Lgl6;->zzb:Z
  383: 
  384:     .line 76
  385:     .line 77
  386:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setReturnUrlsForImageAssets(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  387: 
  388:     .line 78
  389:     .line 79
  390:     .line 80
  391:     iget-boolean p0, p0, Lgl6;->zzd:Z
  392: 
  393:     .line 81
  394:     .line 82
  395:     invoke-virtual {v0, p0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setRequestMultipleImages(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
  396: 
  397:     .line 83
  398:     .line 84
  399:     .line 85
  400:     invoke-virtual {v0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  401: 
  402:     .line 86
  403:     .line 87
  404:     .line 88
  405:     move-result-object p0
  406: 
  407:     .line 89
  408:     return-object p0
  409: .end method

## .class public final Lhn7; — smali/hn7.smali
.method public final zza(Landroid/view/View;Landroid/view/WindowManager;)Landroid/view/View;
   44: .method public final zza(Landroid/view/View;Landroid/view/WindowManager;)Landroid/view/View;
   45:     .locals 11
   46: 
   47:     .line 1
   48:     invoke-static {}, Lcom/google/android/gms/ads/internal/client/zzr;->zzb()Lcom/google/android/gms/ads/internal/client/zzr;
   49: 
   50:     .line 2
   51:     .line 3
   52:     .line 4
   53:     move-result-object v0
   54: 
   55:     .line 5
   56:     const/4 v1, 0x0
   57: 
   58:     .line 6
   59:     iget-object v2, p0, Lhn7;->a:Liq7;
   60: 
   61:     .line 7
   62:     .line 8
   63:     invoke-virtual {v2, v0, v1, v1}, Liq7;->zza(Lcom/google/android/gms/ads/internal/client/zzr;Lja8;Lma8;)Lt57;
   64: 
   65:     .line 9
   66:     .line 10
   67:     .line 11
   68:     move-result-object v0
   69: 
   70:     .line 12
   71:     invoke-interface {v0}, Lt57;->zzE()Landroid/view/View;
   72: 
   73:     .line 13
   74:     .line 14
   75:     .line 15
   76:     move-result-object v1
   77: 
   78:     .line 16
   79:     const/4 v2, 0x4
   80: 
   81:     .line 17
   82:     invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V
   83: 
   84:     .line 18
   85:     .line 19
   86:     .line 20
   87:     invoke-interface {v0}, Lt57;->zzE()Landroid/view/View;
   88: 
   89:     .line 21
   90:     .line 22
   91:     .line 23
   92:     move-result-object v1
   93: 
   94:     .line 24
   95:     const-string v2, "policy_validator"
   96: 
   97:     .line 25
   98:     .line 26
   99:     invoke-virtual {v1, v2}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V
  100: 
  101:     .line 27
  102:     .line 28
  103:     .line 29
  104:     new-instance v1, Ltn6;
  105: 
  106:     .line 30
  107:     .line 31
  108:     const/4 v2, 0x7
  109: 
  110:     .line 32
  111:     invoke-direct {v1, p0, v2}, Ltn6;-><init>(Ljava/lang/Object;I)V
  112: 
  113:     .line 33
  114:     .line 34
  115:     .line 35
  116:     const-string v2, "/sendMessageToSdk"
  117: 
  118:     .line 36
  119:     .line 37
  120:     invoke-interface {v0, v2, v1}, Lt57;->L(Ljava/lang/String;Lho6;)V
  121: 
  122:     .line 38
  123:     .line 39
  124:     .line 40
  125:     new-instance v1, Lfn7;
  126: 
  127:     .line 41
  128:     .line 42
  129:     invoke-direct {v1, p0, p2, p1}, Lfn7;-><init>(Lhn7;Landroid/view/WindowManager;Landroid/view/View;)V
  130: 
  131:     .line 43
  132:     .line 44
  133:     .line 45
  134:     const-string v2, "/hideValidatorOverlay"
  135: 
  136:     .line 46
  137:     .line 47
  138:     invoke-interface {v0, v2, v1}, Lt57;->L(Ljava/lang/String;Lho6;)V
  139: 
  140:     .line 48
  141:     .line 49
  142:     .line 50
  143:     new-instance v3, Lpo6;
  144: 
  145:     .line 51
  146:     .line 52
  147:     const/4 v9, 0x0
  148: 
  149:     .line 53
  150:     const/4 v10, 0x0
  151: 
  152:     .line 54
  153:     const/4 v4, 0x0
  154: 
  155:     .line 55
  156:     const/4 v5, 0x0
  157: 
  158:     .line 56
  159:     const/4 v6, 0x0
  160: 
  161:     .line 57
  162:     const/4 v7, 0x0
  163: 
  164:     .line 58
  165:     const/4 v8, 0x0
  166: 
  167:     .line 59
  168:     invoke-direct/range {v3 .. v10}, Lpo6;-><init>(Lcom/google/android/gms/ads/internal/zzb;Lav6;Lgx7;Lxr7;Lra7;Lvf7;Lrf7;)V
  169: 
  170:     .line 60
  171:     .line 61
  172:     .line 62
  173:     const-string v1, "/open"
  174: 
  175:     .line 63
  176:     .line 64
  177:     invoke-interface {v0, v1, v3}, Lt57;->L(Ljava/lang/String;Lho6;)V
  178: 
  179:     .line 65
  180:     .line 66
  181:     .line 67
  182:     new-instance v1, Ljava/lang/ref/WeakReference;
  183: 
  184:     .line 68
  185:     .line 69
  186:     invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
  187: 
  188:     .line 70
  189:     .line 71
  190:     .line 72
  191:     new-instance v2, Lfn7;
  192: 
  193:     .line 73
  194:     .line 74
  195:     invoke-direct {v2, p0, p1, p2}, Lfn7;-><init>(Lhn7;Landroid/view/View;Landroid/view/WindowManager;)V
  196: 
  197:     .line 75
  198:     .line 76
  199:     .line 77
  200:     new-instance p1, Ljl7;
  201: 
  202:     .line 78
  203:     .line 79
  204:     iget-object p0, p0, Lhn7;->b:Lip7;
  205: 
  206:     .line 80
  207:     .line 81
  208:     const-string p2, "/loadNativeAdPolicyViolations"
  209: 
  210:     .line 82
  211:     .line 83
  212:     invoke-direct {p1, p0, v1, p2, v2}, Ljl7;-><init>(Lip7;Ljava/lang/ref/WeakReference;Ljava/lang/String;Lho6;)V
  213: 
  214:     .line 84
  215:     .line 85
  216:     .line 86
  217:     invoke-virtual {p0, p2, p1}, Lip7;->b(Ljava/lang/String;Lho6;)V
  218: 
  219:     .line 87
  220:     .line 88
  221:     .line 89
  222:     new-instance p1, Ljava/lang/ref/WeakReference;
  223: 
  224:     .line 90
  225:     .line 91
  226:     invoke-direct {p1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
  227: 
  228:     .line 92
  229:     .line 93
  230:     .line 94
  231:     sget-object p2, Lyn6;->B:Lyn6;
  232: 
  233:     .line 95
  234:     .line 96
  235:     new-instance v1, Ljl7;
  236: 
  237:     .line 97
  238:     .line 98
  239:     const-string v2, "/showValidatorOverlay"
  240: 
  241:     .line 99
  242:     .line 100
  243:     invoke-direct {v1, p0, p1, v2, p2}, Ljl7;-><init>(Lip7;Ljava/lang/ref/WeakReference;Ljava/lang/String;Lho6;)V
  244: 
  245:     .line 101
  246:     .line 102
  247:     .line 103
  248:     invoke-virtual {p0, v2, v1}, Lip7;->b(Ljava/lang/String;Lho6;)V
  249: 
  250:     .line 104
  251:     .line 105
  252:     .line 106
  253:     invoke-interface {v0}, Lt57;->zzE()Landroid/view/View;
  254: 
  255:     .line 107
  256:     .line 108
  257:     .line 109
  258:     move-result-object p0
  259: 
  260:     .line 110
  261:     return-object p0
  262: .end method

## .class public final Lht6; — smali/ht6.smali
.method public final zzr(Lbx1;Lcom/google/android/gms/ads/internal/client/zzm;Ljava/lang/String;Ljava/lang/String;Lss6;Lgl6;Ljava/util/List;)V
 5712: .method public final zzr(Lbx1;Lcom/google/android/gms/ads/internal/client/zzm;Ljava/lang/String;Ljava/lang/String;Lss6;Lgl6;Ljava/util/List;)V
 6363: 
 6364:     .line 311
 6365:     .line 312
 6366:     invoke-direct/range {v9 .. v20}, Lcom/google/android/gms/ads/mediation/MediationNativeAdConfiguration;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZLandroid/location/Location;IILjava/lang/String;Ljava/lang/String;Lgl6;)V
 6367: 
 6368:     .line 313
 6369:     .line 314
 6370:     .line 315
 6371:     invoke-virtual {v0, v9, v7}, Lcom/google/android/gms/ads/mediation/Adapter;->loadNativeAdMapper(Lcom/google/android/gms/ads/mediation/MediationNativeAdConfiguration;Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;)V
 6372:     :try_end_2
 6373:     .catchall {:try_start_2 .. :try_end_2} :catchall_1
 6374: 
 6375:     .line 316
 6376:     .line 317
 6377:     .line 318
 6378:     return-void
 6379: 
 6380:     .line 319
 6394:     .line 323
 6395:     .line 324
 6396:     :goto_5
 6397:     invoke-static {v8, v0}, Lcom/google/android/gms/ads/internal/util/client/zzo;->zzg(Ljava/lang/String;Ljava/lang/Throwable;)V
 6398: 
 6399:     .line 325
 6400:     .line 326
 6401:     .line 327
 6402:     const-string v7, "adapter.loadNativeAdMapper"
 6403: 
 6404:     .line 328
 6405:     .line 329
 6406:     invoke-static {v2, v0, v7}, Lnn9;->p(Lbx1;Ljava/lang/Throwable;Ljava/lang/String;)V
 6407: 
 6408:     .line 330
 6409:     .line 331
 6410:     .line 332
 6411:     invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
 6552: 
 6553:     .line 402
 6554:     .line 403
 6555:     invoke-direct/range {v9 .. v20}, Lcom/google/android/gms/ads/mediation/MediationNativeAdConfiguration;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZLandroid/location/Location;IILjava/lang/String;Ljava/lang/String;Lgl6;)V
 6556: 
 6557:     .line 404
 6558:     .line 405
 6559:     .line 406
 6560:     invoke-virtual {v7, v9, v0}, Lcom/google/android/gms/ads/mediation/Adapter;->loadNativeAd(Lcom/google/android/gms/ads/mediation/MediationNativeAdConfiguration;Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;)V
 6561:     :try_end_3
 6562:     .catchall {:try_start_3 .. :try_end_3} :catchall_3
 6563: 
 6564:     .line 407
 6565:     .line 408
 6566:     .line 409
 6567:     goto :goto_6
 6568: 
 6569:     .line 410
 6571:     move-exception v0
 6572: 
 6573:     .line 411
 6574:     invoke-static {v8, v0}, Lcom/google/android/gms/ads/internal/util/client/zzo;->zzg(Ljava/lang/String;Ljava/lang/Throwable;)V
 6575: 
 6576:     .line 412
 6577:     .line 413
 6578:     .line 414
 6579:     const-string v1, "adapter.loadNativeAd"
 6580: 
 6581:     .line 415
 6582:     .line 416
 6583:     invoke-static {v2, v0, v1}, Lnn9;->p(Lbx1;Ljava/lang/Throwable;Ljava/lang/String;)V
 6584: 
 6585:     .line 417
 6586:     .line 418
 6587:     .line 419
 6588:     invoke-static {}, Lhs6;->a()V
 6605: .end method
(method body truncated to match context)

## .class public final Lju7; — smali/ju7.smali
.method public static g(Ljava/lang/Object;)Ljava/lang/String;
   62: .method public static g(Ljava/lang/Object;)Ljava/lang/String;
   63:     .locals 1
   64: 
   65:     .line 1
   66:     instance-of v0, p0, Lcom/google/android/gms/ads/LoadAdError;
   67: 
   68:     .line 2
   69:     .line 3
   70:     if-eqz v0, :cond_0
   71: 
   72:     .line 4
   73:     .line 5
   74:     check-cast p0, Lcom/google/android/gms/ads/LoadAdError;
   75: 
   76:     .line 6
   77:     .line 7
   78:     invoke-virtual {p0}, Lcom/google/android/gms/ads/LoadAdError;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
   79: 
   80:     .line 8
   81:     .line 9
   82:     .line 10
   83:     move-result-object p0
   84: 
   85:     .line 11
   86:     goto :goto_0
   87: 
   88:     .line 12
   89:     :cond_0
   90:     instance-of v0, p0, Lcom/google/android/gms/ads/appopen/AppOpenAd;
   91: 
   92:     .line 13
   93:     .line 14
   94:     if-eqz v0, :cond_1
   95: 
   96:     .line 15
   97:     .line 16
   98:     check-cast p0, Lcom/google/android/gms/ads/appopen/AppOpenAd;
   99: 
  100:     .line 17
  101:     .line 18
  102:     invoke-virtual {p0}, Lcom/google/android/gms/ads/appopen/AppOpenAd;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  103: 
  104:     .line 19
  105:     .line 20
  106:     .line 21
  107:     move-result-object p0
  108: 
  109:     .line 22
  110:     goto :goto_0
  111: 
  112:     .line 23
  113:     :cond_1
  114:     instance-of v0, p0, Lcom/google/android/gms/ads/interstitial/InterstitialAd;
  115: 
  116:     .line 24
  117:     .line 25
  118:     if-eqz v0, :cond_2
  119: 
  120:     .line 26
  121:     .line 27
  122:     check-cast p0, Lcom/google/android/gms/ads/interstitial/InterstitialAd;
  123: 
  124:     .line 28
  125:     .line 29
  126:     invoke-virtual {p0}, Lcom/google/android/gms/ads/interstitial/InterstitialAd;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  127: 
  128:     .line 30
  129:     .line 31
  130:     .line 32
  131:     move-result-object p0
  132: 
  133:     .line 33
  134:     goto :goto_0
  135: 
  136:     .line 34
  137:     :cond_2
  138:     instance-of v0, p0, Lcom/google/android/gms/ads/rewarded/RewardedAd;
  139: 
  140:     .line 35
  141:     .line 36
  142:     if-eqz v0, :cond_3
  143: 
  144:     .line 37
  145:     .line 38
  146:     check-cast p0, Lcom/google/android/gms/ads/rewarded/RewardedAd;
  147: 
  148:     .line 39
  149:     .line 40
  150:     invoke-virtual {p0}, Lcom/google/android/gms/ads/rewarded/RewardedAd;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  151: 
  152:     .line 41
  153:     .line 42
  154:     .line 43
  155:     move-result-object p0
  156: 
  157:     .line 44
  158:     goto :goto_0
  159: 
  160:     .line 45
  161:     :cond_3
  162:     instance-of v0, p0, Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;
  163: 
  164:     .line 46
  165:     .line 47
  166:     if-eqz v0, :cond_4
  167: 
  168:     .line 48
  169:     .line 49
  170:     check-cast p0, Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;
  171: 
  172:     .line 50
  173:     .line 51
  174:     invoke-virtual {p0}, Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  175: 
  176:     .line 52
  177:     .line 53
  178:     .line 54
  179:     move-result-object p0
  180: 
  181:     .line 55
  182:     goto :goto_0
  183: 
  184:     .line 56
  185:     :cond_4
  186:     instance-of v0, p0, Lcom/google/android/gms/ads/AdView;
  187: 
  188:     .line 57
  189:     .line 58
  190:     if-eqz v0, :cond_5
  191: 
  192:     .line 59
  193:     .line 60
  194:     check-cast p0, Lcom/google/android/gms/ads/AdView;
  195: 
  196:     .line 61
  197:     .line 62
  198:     invoke-virtual {p0}, Lcom/google/android/gms/ads/BaseAdView;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  199: 
  200:     .line 63
  201:     .line 64
  202:     .line 65
  203:     move-result-object p0
  204: 
  205:     .line 66
  206:     goto :goto_0
  207: 
  208:     .line 67
  209:     :cond_5
  210:     instance-of v0, p0, Lcom/google/android/gms/ads/nativead/NativeAd;
  211: 
  212:     .line 68
  213:     .line 69
  214:     if-eqz v0, :cond_7
  215: 
  216:     .line 70
  217:     .line 71
  218:     check-cast p0, Lcom/google/android/gms/ads/nativead/NativeAd;
  219: 
  220:     .line 72
  221:     .line 73
  222:     invoke-virtual {p0}, Lcom/google/android/gms/ads/nativead/NativeAd;->getResponseInfo()Lcom/google/android/gms/ads/ResponseInfo;
  223: 
  224:     .line 74
  225:     .line 75
  226:     .line 76
  227:     move-result-object p0
  228: 
  229:     .line 77
  230:     :goto_0
  231:     if-nez p0, :cond_6
  232: 
  233:     .line 78
  234:     .line 79
  235:     goto :goto_1
  236: 
  237:     .line 80
  238:     :cond_6
  239:     invoke-virtual {p0}, Lcom/google/android/gms/ads/ResponseInfo;->zzd()Lcom/google/android/gms/ads/internal/client/zzdx;
  240: 
  241:     .line 81
  242:     .line 82
  243:     .line 83
  244:     move-result-object p0
  245: 
  246:     .line 84
  247:     if-eqz p0, :cond_7
  248: 
  249:     .line 85
  250:     .line 86
  251:     :try_start_0
  252:     invoke-interface {p0}, Lcom/google/android/gms/ads/internal/client/zzdx;->zzj()Ljava/lang/String;
  253: 
  254:     .line 87
  255:     .line 88
  256:     .line 89
  257:     move-result-object p0
  258:     :try_end_0
  259:     .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
  260: 
  261:     .line 90
  262:     return-object p0
  263: 
  264:     .line 91
  265:     :catch_0
  266:     :cond_7
  267:     :goto_1
  268:     const-string p0, ""
  269: 
  270:     .line 92
  271:     .line 93
  272:     return-object p0
  273: .end method

## .class public final Lju7; — smali/ju7.smali
.method public final zze(Ljava/lang/String;Lbx1;Lbx1;)V
  602: .method public final zze(Ljava/lang/String;Lbx1;Lbx1;)V
  742:     if-eqz p0, :cond_8
  743: 
  744:     .line 71
  745:     .line 72
  746:     check-cast p3, Lcom/google/android/gms/ads/nativead/NativeAd;
  747: 
  748:     .line 73
  749:     .line 74
  750:     new-instance p0, Lcom/google/android/gms/ads/nativead/NativeAdView;
  751: 
  752:     .line 75
  753:     .line 76
  754:     invoke-direct {p0, v0}, Lcom/google/android/gms/ads/nativead/NativeAdView;-><init>(Landroid/content/Context;)V
  755: 
  756:     .line 77
  757:     .line 78
  758:     .line 79
  759:     const-string v1, "ad_view_tag"
  760: 
  761:     .line 80
  762:     .line 81
  763:     invoke-virtual {p0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V
  882:     move-result-object v1
  883: 
  884:     .line 145
  885:     invoke-virtual {p2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
  886: 
  887:     .line 146
  888:     .line 147
  889:     .line 148
  890:     invoke-virtual {p3}, Lcom/google/android/gms/ads/nativead/NativeAd;->getHeadline()Ljava/lang/String;
  891: 
  892:     .line 149
  893:     .line 150
  894:     .line 151
  895:     move-result-object v1
  896: 
  897:     .line 152
  898:     const-string v6, ""
  899: 
  927:     invoke-static/range {v0 .. v5}, Llu7;->a(Landroid/content/Context;Ljava/lang/String;IIFLjava/lang/String;)Landroid/widget/TextView;
  928: 
  929:     .line 167
  930:     .line 168
  931:     .line 169
  932:     move-result-object v1
  933: 
  934:     .line 170
  935:     invoke-virtual {p0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdView;->setHeadlineView(Landroid/view/View;)V
  936: 
  937:     .line 171
  938:     .line 172
  939:     .line 173
  940:     invoke-virtual {p2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
  941: 
  942:     .line 174
  943:     .line 175
  944:     .line 176
  992:     move-result-object v1
  993: 
  994:     .line 200
  995:     invoke-virtual {p2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
  996: 
  997:     .line 201
  998:     .line 202
  999:     .line 203
 1000:     invoke-virtual {p3}, Lcom/google/android/gms/ads/nativead/NativeAd;->getBody()Ljava/lang/String;
 1001: 
 1002:     .line 204
 1003:     .line 205
 1004:     .line 206
 1005:     move-result-object v1
 1006: 
 1007:     .line 207
 1008:     if-nez v1, :cond_6
 1009: 
 1033:     invoke-static/range {v0 .. v5}, Llu7;->a(Landroid/content/Context;Ljava/lang/String;IIFLjava/lang/String;)Landroid/widget/TextView;
 1034: 
 1035:     .line 220
 1036:     .line 221
 1037:     .line 222
 1038:     move-result-object v1
 1039: 
 1040:     .line 223
 1041:     invoke-virtual {p0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdView;->setBodyView(Landroid/view/View;)V
 1042: 
 1043:     .line 224
 1044:     .line 225
 1045:     .line 226
 1046:     invoke-virtual {p2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
 1047: 
 1048:     .line 227
 1049:     .line 228
 1050:     .line 229
 1123: 
 1124:     .line 264
 1125:     .line 265
 1126:     invoke-virtual {p1, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V
 1127: 
 1128:     .line 266
 1129:     .line 267
 1130:     .line 268
 1131:     invoke-virtual {p0, p1}, Lcom/google/android/gms/ads/nativead/NativeAdView;->setMediaView(Lcom/google/android/gms/ads/nativead/MediaView;)V
 1132: 
 1133:     .line 269
 1134:     .line 270
 1135:     .line 271
 1136:     invoke-virtual {p2, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
 1137: 
 1138:     .line 272
 1139:     .line 273
 1140:     .line 274
 1141:     invoke-virtual {p0, p3}, Lcom/google/android/gms/ads/nativead/NativeAdView;->setNativeAd(Lcom/google/android/gms/ads/nativead/NativeAd;)V
 1142: 
 1143:     .line 275
 1144:     .line 276
 1145:     .line 277
 1146:     :cond_8
 1147:     :goto_4
 1148:     return-void
 1149: .end method
(method body truncated to match context)

## .class public final Lku7; — smali/ku7.smali
.method public final a(Lcom/google/android/gms/ads/nativead/NativeAdOptions;)V
   23: .method public final a(Lcom/google/android/gms/ads/nativead/NativeAdOptions;)V
   24:     .locals 0
   25: 
   26:     .line 1
   27:     iput-object p1, p0, Lku7;->zzb:Lcom/google/android/gms/ads/nativead/NativeAdOptions;
   28: 
   29:     .line 2
   30:     .line 3
   31:     return-void
   32: .end method

## .class public final Lku7; — smali/ku7.smali
.method public final zze()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
   45: .method public final zze()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
   46:     .locals 0
   47: 
   48:     .line 1
   49:     iget-object p0, p0, Lku7;->zzb:Lcom/google/android/gms/ads/nativead/NativeAdOptions;
   50: 
   51:     .line 2
   52:     .line 3
   53:     return-object p0
   54: .end method

## .class public final Llv6; — smali/lv6.smali
.method public constructor <init>(Lkn6;)V
   21: .method public constructor <init>(Lkn6;)V
   22:     .locals 5
   23: 
   24:     .line 1
   25:     const-string v0, ""
   26: 
   27:     .line 2
   28:     .line 3
   29:     invoke-direct {p0}, Lcom/google/android/gms/ads/nativead/NativeAd;-><init>()V
   30: 
   31:     .line 4
   32:     .line 5
   33:     .line 6
   34:     new-instance v1, Ljava/util/ArrayList;
   35: 
   36:     .line 7
   37:     .line 8
   38:     invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V
  430: .end method
(method body truncated to match context)

## .class public final Lmn6; — smali/mn6.smali
.method public final synthetic getRemoteCreator(Landroid/os/IBinder;)Ljava/lang/Object;
    7: .method public final synthetic getRemoteCreator(Landroid/os/IBinder;)Ljava/lang/Object;
    8:     .locals 1
    9: 
   10:     .line 1
   11:     if-nez p1, :cond_0
   12: 
   13:     .line 2
   14:     .line 3
   15:     const/4 p0, 0x0
   16: 
   17:     .line 4
   18:     return-object p0
   19: 
   20:     .line 5
   21:     :cond_0
   22:     const-string p0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator"
   23: 
   24:     .line 6
   25:     .line 7
   26:     invoke-interface {p1, p0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;
   27: 
   28:     .line 8
   29:     .line 9
   30:     .line 10
   31:     move-result-object p0
   32: 
   33:     .line 11
   34:     instance-of v0, p0, Lbm6;
   35: 
   36:     .line 12
   37:     .line 13
   38:     if-eqz v0, :cond_1
   39: 
   40:     .line 14
   41:     .line 15
   42:     check-cast p0, Lbm6;
   43: 
   44:     .line 16
   45:     .line 17
   46:     return-object p0
   47: 
   48:     .line 18
   49:     :cond_1
   50:     new-instance p0, Lzl6;
   51: 
   52:     .line 19
   53:     .line 20
   54:     invoke-direct {p0, p1}, Lzl6;-><init>(Landroid/os/IBinder;)V
   55: 
   56:     .line 21
   57:     .line 22
   58:     .line 23
   59:     return-object p0
   60: .end method

## .class public final Lmn6; — smali/mn6.smali
.method public final zza(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;)Lul6;
   62: .method public final zza(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;)Lul6;
   63:     .locals 2
   64: 
   65:     .line 1
   66:     const/4 v0, 0x0
   67: 
   68:     .line 2
   69:     :try_start_0
   70:     invoke-static {p1}, Lt33;->wrap(Ljava/lang/Object;)Lbx1;
   71: 
   72:     .line 3
   73:     .line 4
   74:     .line 5
   75:     move-result-object v1
   76: 
   77:     .line 6
   78:     invoke-static {p2}, Lt33;->wrap(Ljava/lang/Object;)Lbx1;
   79: 
   80:     .line 7
   81:     .line 8
   82:     .line 9
   83:     move-result-object p2
   84: 
   85:     .line 10
   86:     invoke-static {p3}, Lt33;->wrap(Ljava/lang/Object;)Lbx1;
   87: 
   88:     .line 11
   89:     .line 12
   90:     .line 13
   91:     move-result-object p3
   92: 
   93:     .line 14
   94:     invoke-virtual {p0, p1}, Lan3;->getRemoteCreatorInstance(Landroid/content/Context;)Ljava/lang/Object;
   95: 
   96:     .line 15
   97:     .line 16
   98:     .line 17
   99:     move-result-object p0
  100: 
  101:     .line 18
  102:     check-cast p0, Lbm6;
  103: 
  104:     .line 19
  105:     .line 20
  106:     check-cast p0, Lzl6;
  107: 
  108:     .line 21
  109:     .line 22
  110:     const p1, 0xfa08ca0
  111: 
  112:     .line 23
  113:     .line 24
  114:     .line 25
  115:     invoke-virtual {p0, v1, p2, p3, p1}, Lzl6;->zze(Lbx1;Lbx1;Lbx1;I)Landroid/os/IBinder;
  116: 
  117:     .line 26
  118:     .line 27
  119:     .line 28
  120:     move-result-object p0
  121: 
  122:     .line 29
  123:     if-nez p0, :cond_0
  124: 
  125:     .line 30
  126:     .line 31
  127:     return-object v0
  128: 
  129:     .line 32
  130:     :cond_0
  131:     const-string p1, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate"
  132: 
  133:     .line 33
  134:     .line 34
  135:     invoke-interface {p0, p1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;
  136: 
  137:     .line 35
  138:     .line 36
  139:     .line 37
  140:     move-result-object p1
  141: 
  142:     .line 38
  143:     instance-of p2, p1, Lul6;
  144: 
  145:     .line 39
  146:     .line 40
  147:     if-eqz p2, :cond_1
  148: 
  149:     .line 41
  150:     .line 42
  151:     check-cast p1, Lul6;
  152: 
  153:     .line 43
  154:     .line 44
  155:     return-object p1
  156: 
  157:     .line 45
  158:     :catch_0
  159:     move-exception p0
  160: 
  161:     .line 46
  162:     goto :goto_0
  163: 
  164:     .line 47
  165:     :catch_1
  166:     move-exception p0
  167: 
  168:     .line 48
  169:     goto :goto_0
  170: 
  171:     .line 49
  172:     :cond_1
  173:     new-instance p1, Lsl6;
  174: 
  175:     .line 50
  176:     .line 51
  177:     invoke-direct {p1, p0}, Lsl6;-><init>(Landroid/os/IBinder;)V
  178:     :try_end_0
  179:     .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1
  180:     .catch Lan3$a; {:try_start_0 .. :try_end_0} :catch_0
  181: 
  182:     .line 52
  183:     .line 53
  184:     .line 54
  185:     return-object p1
  186: 
  187:     .line 55
  188:     :goto_0
  189:     const-string p1, "Could not create remote NativeAdViewDelegate."
  190: 
  191:     .line 56
  192:     .line 57
  193:     invoke-static {p1, p0}, Lcom/google/android/gms/ads/internal/util/client/zzo;->zzj(Ljava/lang/String;Ljava/lang/Throwable;)V
  194: 
  195:     .line 58
  196:     .line 59
  197:     .line 60
  198:     return-object v0
  199: .end method

## .class public final Lnn6; — smali/nn6.smali
.method public final getRemoteCreator(Landroid/os/IBinder;)Ljava/lang/Object;
    7: .method public final getRemoteCreator(Landroid/os/IBinder;)Ljava/lang/Object;
    8:     .locals 2
    9: 
   10:     .line 1
   11:     if-nez p1, :cond_0
   12: 
   13:     .line 2
   14:     .line 3
   15:     const/4 p0, 0x0
   16: 
   17:     .line 4
   18:     return-object p0
   19: 
   20:     .line 5
   21:     :cond_0
   22:     const-string p0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator"
   23: 
   24:     .line 6
   25:     .line 7
   26:     invoke-interface {p1, p0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;
   27: 
   28:     .line 8
   29:     .line 9
   30:     .line 10
   31:     move-result-object v0
   32: 
   33:     .line 11
   34:     instance-of v1, v0, Lem6;
   35: 
   36:     .line 12
   37:     .line 13
   38:     if-eqz v1, :cond_1
   39: 
   40:     .line 14
   41:     .line 15
   42:     check-cast v0, Lem6;
   43: 
   44:     .line 16
   45:     .line 17
   46:     return-object v0
   47: 
   48:     .line 18
   49:     :cond_1
   50:     new-instance v0, Lem6;
   51: 
   52:     .line 19
   53:     .line 20
   54:     invoke-direct {v0, p1, p0}, Lld6;-><init>(Landroid/os/IBinder;Ljava/lang/String;)V
   55: 
   56:     .line 21
   57:     .line 22
   58:     .line 23
   59:     return-object v0
   60: .end method

## .class public final Lnt6; — smali/nt6.smali
.method public final getNativeAdOptions()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  348: .method public final getNativeAdOptions()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  349:     .locals 3
  350: 
  351:     .line 1
  352:     new-instance v0, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  353: 
  354:     .line 2
  355:     .line 3
  356:     invoke-direct {v0}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;-><init>()V
  357: 
  358:     .line 4
  359:     .line 5
  360:     .line 6
  361:     iget-object p0, p0, Lnt6;->g:Lgl6;
  362: 
  363:     .line 7
  364:     .line 8
  365:     if-nez p0, :cond_0
  366: 
  367:     .line 9
  368:     .line 10
  369:     invoke-virtual {v0}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  370: 
  371:     .line 11
  372:     .line 12
  373:     .line 13
  374:     move-result-object p0
  375: 
  376:     .line 14
  377:     return-object p0
  378: 
  379:     .line 15
  380:     :cond_0
  381:     iget v1, p0, Lgl6;->zza:I
  382: 
  383:     .line 16
  384:     .line 17
  385:     const/4 v2, 0x2
  386: 
  387:     .line 18
  388:     if-eq v1, v2, :cond_3
  389: 
  390:     .line 19
  391:     .line 20
  392:     const/4 v2, 0x3
  393: 
  394:     .line 21
  395:     if-eq v1, v2, :cond_2
  396: 
  397:     .line 22
  398:     .line 23
  399:     const/4 v2, 0x4
  400: 
  401:     .line 24
  402:     if-eq v1, v2, :cond_1
  403: 
  404:     .line 25
  405:     .line 26
  406:     goto :goto_0
  407: 
  408:     .line 27
  409:     :cond_1
  410:     iget-boolean v1, p0, Lgl6;->zzg:Z
  411: 
  412:     .line 28
  413:     .line 29
  414:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setRequestCustomMuteThisAd(Z)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  415: 
  416:     .line 30
  417:     .line 31
  418:     .line 32
  419:     iget v1, p0, Lgl6;->zzh:I
  420: 
  421:     .line 33
  422:     .line 34
  423:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setMediaAspectRatio(I)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  424: 
  425:     .line 35
  426:     .line 36
  427:     .line 37
  428:     :cond_2
  429:     iget-object v1, p0, Lgl6;->zzf:Lcom/google/android/gms/ads/internal/client/zzfw;
  430: 
  431:     .line 38
  432:     .line 39
  433:     if-eqz v1, :cond_3
  434: 
  435:     .line 40
  436:     .line 41
  437:     new-instance v2, Lcom/google/android/gms/ads/VideoOptions;
  438: 
  439:     .line 42
  440:     .line 43
  441:     invoke-direct {v2, v1}, Lcom/google/android/gms/ads/VideoOptions;-><init>(Lcom/google/android/gms/ads/internal/client/zzfw;)V
  442: 
  443:     .line 44
  444:     .line 45
  445:     .line 46
  446:     invoke-virtual {v0, v2}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setVideoOptions(Lcom/google/android/gms/ads/VideoOptions;)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  447: 
  448:     .line 47
  449:     .line 48
  450:     .line 49
  451:     :cond_3
  452:     iget v1, p0, Lgl6;->zze:I
  453: 
  454:     .line 50
  455:     .line 51
  456:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setAdChoicesPlacement(I)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  457: 
  458:     .line 52
  459:     .line 53
  460:     .line 54
  461:     :goto_0
  462:     iget-boolean v1, p0, Lgl6;->zzb:Z
  463: 
  464:     .line 55
  465:     .line 56
  466:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setReturnUrlsForImageAssets(Z)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  467: 
  468:     .line 57
  469:     .line 58
  470:     .line 59
  471:     iget v1, p0, Lgl6;->zzc:I
  472: 
  473:     .line 60
  474:     .line 61
  475:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setImageOrientation(I)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  476: 
  477:     .line 62
  478:     .line 63
  479:     .line 64
  480:     iget-boolean p0, p0, Lgl6;->zzd:Z
  481: 
  482:     .line 65
  483:     .line 66
  484:     invoke-virtual {v0, p0}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->setRequestMultipleImages(Z)Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  485: 
  486:     .line 67
  487:     .line 68
  488:     .line 69
  489:     invoke-virtual {v0}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  490: 
  491:     .line 70
  492:     .line 71
  493:     .line 72
  494:     move-result-object p0
  495: 
  496:     .line 73
  497:     return-object p0
  498: .end method

## .class public final Lnt6; — smali/nt6.smali
.method public final getNativeAdRequestOptions()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  500: .method public final getNativeAdRequestOptions()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  501:     .locals 0
  502: 
  503:     .line 1
  504:     iget-object p0, p0, Lnt6;->g:Lgl6;
  505: 
  506:     .line 2
  507:     .line 3
  508:     invoke-static {p0}, Lgl6;->zza(Lgl6;)Lcom/google/android/gms/ads/nativead/NativeAdOptions;
  509: 
  510:     .line 4
  511:     .line 5
  512:     .line 6
  513:     move-result-object p0
  514: 
  515:     .line 7
  516:     return-object p0
  517: .end method

## .class public final Lpo7; — smali/po7.smali
.method public static final c(Lt57;)V
   87: .method public static final c(Lt57;)V
   88:     .locals 3
   89: 
   90:     .line 1
   91:     const-string v0, "/videoClicked"
   92: 
   93:     .line 2
   94:     .line 3
   95:     sget-object v1, Lgo6;->d:Lyn6;
   96: 
   97:     .line 4
   98:     .line 5
   99:     invoke-interface {p0, v0, v1}, Lt57;->L(Ljava/lang/String;Lho6;)V
  100: 
  101:     .line 6
  102:     .line 7
  103:     .line 8
  104:     invoke-interface {p0}, Lt57;->zzP()Lw57;
  105: 
  106:     .line 9
  107:     .line 10
  108:     .line 11
  109:     move-result-object v0
  110: 
  111:     .line 12
  112:     iget-object v1, v0, Lw57;->x:Ljava/lang/Object;
  113: 
  114:     .line 13
  115:     .line 14
  116:     monitor-enter v1
  117: 
  118:     .line 15
  119:     const/4 v2, 0x1
  120: 
  121:     .line 16
  122:     :try_start_0
  123:     iput-boolean v2, v0, Lw57;->L:Z
  124: 
  125:     .line 17
  126:     .line 18
  127:     monitor-exit v1
  128:     :try_end_0
  129:     .catchall {:try_start_0 .. :try_end_0} :catchall_0
  130: 
  131:     .line 19
  132:     const-string v0, "/getNativeAdViewSignals"
  133: 
  134:     .line 20
  135:     .line 21
  136:     sget-object v1, Lgo6;->n:Lyn6;
  137: 
  138:     .line 22
  139:     .line 23
  140:     invoke-interface {p0, v0, v1}, Lt57;->L(Ljava/lang/String;Lho6;)V
  141: 
  142:     .line 24
  143:     .line 25
  144:     .line 26
  145:     const-string v0, "/getNativeClickMeta"
  146: 
  147:     .line 27
  148:     .line 28
  149:     sget-object v1, Lgo6;->o:Lyn6;
  150: 
  151:     .line 29
  152:     .line 30
  153:     invoke-interface {p0, v0, v1}, Lt57;->L(Ljava/lang/String;Lho6;)V
  154: 
  155:     .line 31
  156:     .line 32
  157:     .line 33
  158:     return-void
  159: 
  160:     .line 34
  161:     :catchall_0
  162:     move-exception p0
  163: 
  164:     .line 35
  165:     :try_start_1
  166:     monitor-exit v1
  167:     :try_end_1
  168:     .catchall {:try_start_1 .. :try_end_1} :catchall_0
  169: 
  170:     .line 36
  171:     throw p0
  172: .end method

## .class public final Lqm7; — smali/qm7.smali
.method public constructor <init>(Landroid/view/View;Ljava/util/HashMap;Ljava/util/HashMap;)V
   26: .method public constructor <init>(Landroid/view/View;Ljava/util/HashMap;Ljava/util/HashMap;)V
   27:     .locals 4
   28: 
   29:     .line 1
   30:     const-string v0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate"
   31: 
   32:     .line 2
   33:     .line 3
   34:     invoke-direct {p0, v0}, Lmd6;-><init>(Ljava/lang/String;)V
   35: 
   36:     .line 4
   37:     .line 5
   38:     .line 6
   39:     new-instance v0, Ljava/util/HashMap;
  460: .end method
(method body truncated to match context)

## .class public final Lqm7; — smali/qm7.smali
.method public final declared-synchronized zzc(Lbx1;)V
 1176: .method public final declared-synchronized zzc(Lbx1;)V
 1177:     .locals 2
 1178: 
 1179:     .line 1
 1180:     monitor-enter p0
 1181: 
 1182:     .line 2
 1183:     :try_start_0
 1184:     iget-object v0, p0, Lqm7;->z:Lam7;
 1185: 
 1186:     .line 3
 1187:     .line 4
 1188:     if-eqz v0, :cond_1
 1189: 
 1190:     .line 5
 1191:     .line 6
 1192:     invoke-static {p1}, Lt33;->unwrap(Lbx1;)Ljava/lang/Object;
 1193: 
 1194:     .line 7
 1195:     .line 8
 1196:     .line 9
 1197:     move-result-object p1
 1198: 
 1199:     .line 10
 1200:     instance-of v0, p1, Landroid/view/View;
 1201: 
 1202:     .line 11
 1203:     .line 12
 1204:     if-nez v0, :cond_0
 1205: 
 1206:     .line 13
 1207:     .line 14
 1208:     sget v0, Lcom/google/android/gms/ads/internal/util/zze;->zza:I
 1209: 
 1210:     .line 15
 1211:     .line 16
 1212:     const-string v0, "Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object"
 1213: 
 1214:     .line 17
 1215:     .line 18
 1216:     invoke-static {v0}, Lcom/google/android/gms/ads/internal/util/client/zzo;->zzi(Ljava/lang/String;)V
 1217: 
 1218:     .line 19
 1219:     .line 20
 1220:     .line 21
 1221:     goto :goto_0
 1222: 
 1223:     .line 22
 1224:     :catchall_0
 1225:     move-exception p1
 1226: 
 1227:     .line 23
 1228:     goto :goto_1
 1229: 
 1230:     .line 24
 1231:     :cond_0
 1232:     :goto_0
 1233:     iget-object v0, p0, Lqm7;->z:Lam7;
 1234: 
 1235:     .line 25
 1236:     .line 26
 1237:     check-cast p1, Landroid/view/View;
 1238: 
 1239:     .line 27
 1240:     .line 28
 1241:     monitor-enter v0
 1242:     :try_end_0
 1243:     .catchall {:try_start_0 .. :try_end_0} :catchall_0
 1244: 
 1245:     .line 29
 1246:     :try_start_1
 1247:     iget-object v1, v0, Lam7;->m:Lhm7;
 1248: 
 1249:     .line 30
 1250:     .line 31
 1251:     invoke-interface {v1, p1}, Lhm7;->a(Landroid/view/View;)V
 1252:     :try_end_1
 1253:     .catchall {:try_start_1 .. :try_end_1} :catchall_1
 1254: 
 1255:     .line 32
 1256:     .line 33
 1257:     .line 34
 1258:     :try_start_2
 1259:     monitor-exit v0
 1260:     :try_end_2
 1261:     .catchall {:try_start_2 .. :try_end_2} :catchall_0
 1262: 
 1263:     .line 35
 1264:     monitor-exit p0
 1265: 
 1266:     .line 36
 1267:     return-void
 1268: 
 1269:     .line 37
 1270:     :catchall_1
 1271:     move-exception p1
 1272: 
 1273:     .line 38
 1274:     :try_start_3
 1275:     monitor-exit v0
 1276:     :try_end_3
 1277:     .catchall {:try_start_3 .. :try_end_3} :catchall_1
 1278: 
 1279:     .line 39
 1280:     :try_start_4
 1281:     throw p1
 1282:     :try_end_4
 1283:     .catchall {:try_start_4 .. :try_end_4} :catchall_0
 1284: 
 1285:     .line 40
 1286:     :cond_1
 1287:     monitor-exit p0
 1288: 
 1289:     .line 41
 1290:     return-void
 1291: 
 1292:     .line 42
 1293:     :goto_1
 1294:     :try_start_5
 1295:     monitor-exit p0
 1296:     :try_end_5
 1297:     .catchall {:try_start_5 .. :try_end_5} :catchall_0
 1298: 
 1299:     .line 43
 1300:     throw p1
 1301: .end method

## .class public final Lqo6; — smali/qo6.smali
.method public final b(Ljava/util/Map;Ljava/lang/Object;)V
  444: .method public final b(Ljava/util/Map;Ljava/lang/Object;)V
 2113:     move-result v0
 2114: 
 2115:     .line 820
 2116:     if-eqz v0, :cond_1f
 2117: 
 2118:     .line 821
 2119:     .line 822
 2120:     :cond_18
 2121:     new-instance v0, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2122: 
 2123:     .line 823
 2124:     .line 824
 2125:     invoke-direct {v0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;-><init>()V
 2126: 
 2127:     .line 825
 2128:     .line 826
 2129:     .line 827
 2130:     const-string v1, "disableImageLoading"
 2131: 
 2132:     .line 828
 2133:     .line 829
 2134:     invoke-interface {p1, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
 2166:     invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
 2167: 
 2168:     .line 846
 2169:     .line 847
 2170:     .line 848
 2171:     move-result v1
 2172: 
 2173:     .line 849
 2174:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setReturnUrlsForImageAssets(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2175: 
 2176:     .line 850
 2177:     .line 851
 2178:     .line 852
 2179:     :cond_19
 2180:     const-string v1, "mediaAspectRatio"
 2181: 
 2182:     .line 853
 2183:     .line 854
 2225:     invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
 2226: 
 2227:     .line 875
 2228:     .line 876
 2229:     .line 877
 2230:     move-result v1
 2231: 
 2232:     .line 878
 2233:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setMediaAspectRatio(I)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2234:     :try_end_3
 2235:     .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_3
 2236: 
 2237:     .line 879
 2238:     .line 880
 2239:     .line 881
 2240:     goto :goto_9
 2241: 
 2242:     .line 882
 2243:     :catch_3
 2244:     move-exception v1
 2245: 
 2246:     .line 883
 2247:     const-string v2, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.mediaAspectRatio"
 2248: 
 2249:     .line 884
 2250:     .line 885
 2251:     invoke-static {}, Lcom/google/android/gms/ads/internal/zzt;->zzh()Lv17;
 2252: 
 2253:     .line 886
 2254:     .line 887
 2255:     .line 888
 2256:     move-result-object v3
 2302:     invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
 2303: 
 2304:     .line 911
 2305:     .line 912
 2306:     .line 913
 2307:     move-result v1
 2308: 
 2309:     .line 914
 2310:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setRequestMultipleImages(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2311: 
 2312:     .line 915
 2313:     .line 916
 2314:     .line 917
 2315:     :cond_1b
 2316:     const-string v1, "preferredAdChoicesPosition"
 2317: 
 2318:     .line 918
 2319:     .line 919
 2361:     invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
 2362: 
 2363:     .line 940
 2364:     .line 941
 2365:     .line 942
 2366:     move-result v1
 2367: 
 2368:     .line 943
 2369:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setAdChoicesPlacement(I)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2370:     :try_end_4
 2371:     .catch Ljava/lang/NumberFormatException; {:try_start_4 .. :try_end_4} :catch_4
 2372: 
 2373:     .line 944
 2374:     .line 945
 2375:     .line 946
 2376:     goto :goto_a
 2377: 
 2378:     .line 947
 2379:     :catch_4
 2380:     move-exception v1
 2381: 
 2382:     .line 948
 2383:     const-string v2, "OutOfContextTestingGmsgHandler.generateNativeAdOptionsBuilder.preferredAdChoicesPosition"
 2384: 
 2385:     .line 949
 2386:     .line 950
 2387:     invoke-static {}, Lcom/google/android/gms/ads/internal/zzt;->zzh()Lv17;
 2388: 
 2389:     .line 951
 2390:     .line 952
 2391:     .line 953
 2392:     move-result-object v3
 2438:     invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
 2439: 
 2440:     .line 976
 2441:     .line 977
 2442:     .line 978
 2443:     move-result v1
 2444: 
 2445:     .line 979
 2446:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setRequestCustomMuteThisAd(Z)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2447: 
 2448:     .line 980
 2449:     .line 981
 2450:     .line 982
 2451:     :cond_1d
 2452:     invoke-virtual {p2}, Lku7;->zzf()Lcom/google/android/gms/ads/VideoOptions;
 2453: 
 2454:     .line 983
 2455:     .line 984
 2456:     .line 985
 2457:     move-result-object v1
 2458: 
 2459:     .line 986
 2460:     if-eqz v1, :cond_1e
 2461: 
 2462:     .line 987
 2463:     .line 988
 2464:     invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->setVideoOptions(Lcom/google/android/gms/ads/VideoOptions;)Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;
 2465: 
 2466:     .line 989
 2467:     .line 990
 2468:     .line 991
 2469:     :cond_1e
 2470:     invoke-virtual {v0}, Lcom/google/android/gms/ads/nativead/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
 2471: 
 2472:     .line 992
 2473:     .line 993
 2474:     .line 994
 2475:     move-result-object v0
 2476: 
 2477:     .line 995
 2478:     invoke-virtual {p2, v0}, Lku7;->a(Lcom/google/android/gms/ads/nativead/NativeAdOptions;)V
 2479: 
 2480:     .line 996
 2481:     .line 997
 2482:     .line 998
 2483:     :cond_1f
 2484:     const-string v0, "action"
 2485: 
 2486:     .line 999
 2487:     .line 1000
 3056:     if-eqz p0, :cond_22
 3057: 
 3058:     .line 1275
 3059:     .line 1276
 3060:     iget-object p0, p2, Lku7;->c:Ljava/lang/String;
 3061: 
 3062:     .line 1277
 3063:     .line 1278
 3064:     new-instance p1, Lcom/google/android/gms/ads/AdLoader$Builder;
 3065: 
 3066:     .line 1279
 3067:     .line 1280
 3068:     invoke-virtual {v0}, Lju7;->f()Landroid/content/Context;
 3069: 
 3070:     .line 1281
 3071:     .line 1282
 3072:     .line 1283
 3073:     move-result-object v1
 3074: 
 3075:     .line 1284
 3076:     invoke-direct {p1, v1, p0}, Lcom/google/android/gms/ads/AdLoader$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V
 3077: 
 3078:     .line 1285
 3079:     .line 1286
 3080:     .line 1287
 3081:     new-instance v1, Lsm7;
 3082: 
 3083:     .line 1288
 3084:     .line 1289
 3085:     const/4 v2, 0x5
 3086: 
 3087:     .line 1290
 3088:     invoke-direct {v1, v2, v0, p0}, Lsm7;-><init>(ILjava/lang/Object;Ljava/lang/Object;)V
 3089: 
 3090:     .line 1291
 3091:     .line 1292
 3092:     .line 1293
 3093:     invoke-virtual {p1, v1}, Lcom/google/android/gms/ads/AdLoader$Builder;->forNativeAd(Lcom/google/android/gms/ads/nativead/NativeAd$OnNativeAdLoadedListener;)Lcom/google/android/gms/ads/AdLoader$Builder;
 3094: 
 3095:     .line 1294
 3096:     .line 1295
 3097:     .line 1296
 3098:     new-instance p0, Lhu7;
 3099: 
 3100:     .line 1297
 3101:     .line 1298
 3102:     invoke-direct {p0, v0}, Lhu7;-><init>(Lju7;)V
 3103: 
 3104:     .line 1299
 3105:     .line 1300
 3106:     .line 1301
 3107:     invoke-virtual {p1, p0}, Lcom/google/android/gms/ads/AdLoader$Builder;->withAdListener(Lcom/google/android/gms/ads/AdListener;)Lcom/google/android/gms/ads/AdLoader$Builder;
 3108: 
 3109:     .line 1302
 3110:     .line 1303
 3111:     .line 1304
 3112:     invoke-virtual {p2}, Lku7;->zze()Lcom/google/android/gms/ads/nativead/NativeAdOptions;
 3113: 
 3114:     .line 1305
 3115:     .line 1306
 3116:     .line 1307
 3117:     move-result-object p0
 3118: 
 3119:     .line 1308
 3120:     sget-object v1, Lmi6;->Va:Lfi6;
 3121: 
 3152:     if-eqz v1, :cond_23
 3153: 
 3154:     .line 1325
 3155:     .line 1326
 3156:     if-eqz p0, :cond_23
 3157: 
 3158:     .line 1327
 3159:     .line 1328
 3160:     invoke-virtual {p1, p0}, Lcom/google/android/gms/ads/AdLoader$Builder;->withNativeAdOptions(Lcom/google/android/gms/ads/nativead/NativeAdOptions;)Lcom/google/android/gms/ads/AdLoader$Builder;
 3161: 
 3162:     .line 1329
 3163:     .line 1330
 3164:     .line 1331
 3165:     :cond_23
 3166:     invoke-virtual {p1}, Lcom/google/android/gms/ads/AdLoader$Builder;->build()Lcom/google/android/gms/ads/AdLoader;
 3167: 
 3168:     .line 1332
 3169:     .line 1333
 3170:     .line 1334
 3171:     move-result-object p0
 3172: 
 3173:     .line 1335
 3174:     iget-object p1, p2, Lku7;->a:Lcom/google/android/gms/ads/AdRequest;
 3175: 
 3176:     .line 1336
 3177:     .line 1337
 3178:     invoke-virtual {p0, p1}, Lcom/google/android/gms/ads/AdLoader;->loadAd(Lcom/google/android/gms/ads/AdRequest;)V
 3179:     :try_end_a
 3180:     .catchall {:try_start_a .. :try_end_a} :catchall_0
 3181: 
 3182:     .line 1338
 3183:     .line 1339
 3184:     .line 1340
 3185:     monitor-exit v0
 3186: 
 3187:     .line 1341
 3621: .end method
(method body truncated to match context)

## .class public final Lr32; — smali/r32.smali
.method private constructor <init>(Landroidx/cardview/widget/CardView;Lcom/applovin/mediation/NativeAdLayout;)V
   16: .method private constructor <init>(Landroidx/cardview/widget/CardView;Lcom/applovin/mediation/NativeAdLayout;)V
   17:     .locals 0
   18: 
   19:     .line 1
   20:     invoke-direct {p0}, Ljava/lang/Object;-><init>()V
   21: 
   22:     .line 2
   23:     .line 3
   24:     .line 4
   25:     iput-object p1, p0, Lr32;->rootView:Landroidx/cardview/widget/CardView;
   26: 
   27:     .line 5
   28:     .line 6
   29:     iput-object p2, p0, Lr32;->nativeAdView:Lcom/applovin/mediation/NativeAdLayout;
   30: 
   31:     .line 7
   32:     .line 8
   33:     return-void
   34: .end method

## .class public final Lrm7; — smali/rm7.smali
.method public constructor <init>(Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;)V
   97: .method public constructor <init>(Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;)V
   98:     .locals 2
   99: 
  100:     .line 1
  101:     invoke-direct {p0}, Ltl6;-><init>()V
  102: 
  103:     .line 2
  104:     .line 3
  105:     .line 4
  106:     new-instance v0, Ljava/util/HashMap;
  107: 
  108:     .line 5
  109:     .line 6
  110:     invoke-direct {v0}, Ljava/util/HashMap;-><init>()V
  111: 
  112:     .line 7
  113:     .line 8
  114:     .line 9
  115:     iput-object v0, p0, Lrm7;->w:Ljava/util/HashMap;
  116: 
  117:     .line 10
  118:     .line 11
  119:     const/4 v0, 0x0
  120: 
  121:     .line 12
  122:     iput-object v0, p0, Lrm7;->E:Lbx1;
  123: 
  124:     .line 13
  125:     .line 14
  126:     const/4 v0, 0x0
  127: 
  128:     .line 15
  129:     iput-boolean v0, p0, Lrm7;->H:Z
  130: 
  131:     .line 16
  132:     .line 17
  133:     iput-object p1, p0, Lrm7;->x:Landroid/widget/FrameLayout;
  134: 
  135:     .line 18
  136:     .line 19
  137:     iput-object p2, p0, Lrm7;->y:Landroid/widget/FrameLayout;
  138: 
  139:     .line 20
  140:     .line 21
  141:     const p2, 0xfa08ca0
  142: 
  143:     .line 22
  144:     .line 23
  145:     .line 24
  146:     iput p2, p0, Lrm7;->B:I
  147: 
  148:     .line 25
  149:     .line 26
  150:     invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;
  151: 
  152:     .line 27
  153:     .line 28
  154:     .line 29
  155:     move-result-object p2
  156: 
  157:     .line 30
  158:     invoke-virtual {p2}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;
  159: 
  160:     .line 31
  161:     .line 32
  162:     .line 33
  163:     move-result-object p2
  164: 
  165:     .line 34
  166:     const-string v0, "com.google.android.gms.ads.formats.NativeContentAdView"
  167: 
  168:     .line 35
  169:     .line 36
  170:     invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
  171: 
  172:     .line 37
  173:     .line 38
  174:     .line 39
  175:     move-result v0
  176: 
  177:     .line 40
  178:     if-eqz v0, :cond_0
  179: 
  180:     .line 41
  181:     .line 42
  182:     const-string p2, "1007"
  183: 
  184:     .line 43
  185:     .line 44
  186:     goto :goto_0
  187: 
  188:     .line 45
  189:     :cond_0
  190:     const-string v0, "com.google.android.gms.ads.formats.NativeAppInstallAdView"
  191: 
  192:     .line 46
  193:     .line 47
  194:     invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
  195: 
  196:     .line 48
  197:     .line 49
  198:     .line 50
  199:     move-result v0
  200: 
  201:     .line 51
  202:     if-eqz v0, :cond_1
  203: 
  204:     .line 52
  205:     .line 53
  206:     const-string p2, "2009"
  207: 
  208:     .line 54
  209:     .line 55
  210:     goto :goto_0
  211: 
  212:     .line 56
  213:     :cond_1
  214:     const-string v0, "com.google.android.gms.ads.formats.UnifiedNativeAdView"
  215: 
  216:     .line 57
  217:     .line 58
  218:     invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
  219: 
  220:     .line 59
  221:     .line 60
  222:     .line 61
  223:     const-string p2, "3012"
  224: 
  225:     .line 62
  226:     .line 63
  227:     :goto_0
  228:     iput-object p2, p0, Lrm7;->e:Ljava/lang/String;
  229: 
  230:     .line 64
  231:     .line 65
  232:     invoke-static {}, Lcom/google/android/gms/ads/internal/zzt;->zzC()Lp27;
  233: 
  234:     .line 66
  235:     .line 67
  236:     .line 68
  237:     new-instance p2, Lq27;
  238: 
  239:     .line 69
  240:     .line 70
  241:     invoke-direct {p2, p1, p0}, Lq27;-><init>(Landroid/view/View;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
  242: 
  243:     .line 71
  244:     .line 72
  245:     .line 73
  246:     invoke-virtual {p2}, Ls27;->zze()Landroid/view/ViewTreeObserver;
  247: 
  248:     .line 74
  249:     .line 75
  250:     .line 76
  251:     move-result-object v0
  252: 
  253:     .line 77
  254:     if-eqz v0, :cond_2
  255: 
  256:     .line 78
  257:     .line 79
  258:     invoke-virtual {p2, v0}, Lq27;->a(Landroid/view/ViewTreeObserver;)V
  259: 
  260:     .line 80
  261:     .line 81
  262:     .line 82
  263:     :cond_2
  264:     invoke-static {}, Lcom/google/android/gms/ads/internal/zzt;->zzC()Lp27;
  265: 
  266:     .line 83
  267:     .line 84
  268:     .line 85
  269:     new-instance p2, Lr27;
  270: 
  271:     .line 86
  272:     .line 87
  273:     invoke-direct {p2, p1, p0}, Lr27;-><init>(Landroid/view/View;Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
  274: 
  275:     .line 88
  276:     .line 89
  277:     .line 90
  278:     invoke-virtual {p2}, Ls27;->zze()Landroid/view/ViewTreeObserver;
  279: 
  280:     .line 91
  281:     .line 92
  282:     .line 93
  283:     move-result-object v0
  284: 
  285:     .line 94
  286:     if-eqz v0, :cond_3
  287: 
  288:     .line 95
  289:     .line 96
  290:     invoke-virtual {p2, v0}, Lr27;->a(Landroid/view/ViewTreeObserver;)V
  291: 
  292:     .line 97
  293:     .line 98
  294:     .line 99
  295:     :cond_3
  296:     sget-object p2, Lf27;->f:Le27;
  297: 
  298:     .line 100
  299:     .line 101
  300:     iput-object p2, p0, Lrm7;->z:Le27;
  301: 
  302:     .line 102
  303:     .line 103
  304:     new-instance p2, Lcom/google/android/gms/internal/ads/b;
  305: 
  306:     .line 104
  307:     .line 105
  308:     iget-object v0, p0, Lrm7;->x:Landroid/widget/FrameLayout;
  309: 
  310:     .line 106
  311:     .line 107
  312:     invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;
  313: 
  314:     .line 108
  315:     .line 109
  316:     .line 110
  317:     move-result-object v0
  318: 
  319:     .line 111
  320:     iget-object v1, p0, Lrm7;->x:Landroid/widget/FrameLayout;
  321: 
  322:     .line 112
  323:     .line 113
  324:     invoke-direct {p2, v0, v1}, Lcom/google/android/gms/internal/ads/b;-><init>(Landroid/content/Context;Landroid/view/View;)V
  325: 
  326:     .line 114
  327:     .line 115
  328:     .line 116
  329:     iput-object p2, p0, Lrm7;->D:Lcom/google/android/gms/internal/ads/b;
  330: 
  331:     .line 117
  332:     .line 118
  333:     invoke-virtual {p1, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
  334: 
  335:     .line 119
  336:     .line 120
  337:     .line 121
  338:     invoke-virtual {p1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
  339: 
  340:     .line 122
  341:     .line 123
  342:     .line 124
  343:     return-void
  344: .end method

## .class public final Ls8; — smali/s8.smali
.method public onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$a;I)V
  248: .method public onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$a;I)V
  861:     invoke-virtual {p1}, Ls8$b;->getBinding()Lr32;
  862: 
  863:     .line 304
  864:     .line 305
  865:     .line 306
  866:     move-result-object p1
  867: 
  868:     .line 307
  869:     iget-object p1, p1, Lr32;->nativeAdView:Lcom/applovin/mediation/NativeAdLayout;
  870: 
  871:     .line 308
  872:     .line 309
  873:     iget-object p0, p0, Ls8;->nativeAdId:Ljava/lang/String;
  874: 
  875:     .line 310
  876:     .line 311
  877:     invoke-virtual {p1, p0}, Lcom/applovin/mediation/NativeAdLayout;->loadAd(Ljava/lang/String;)V
  878: 
  884: .end method
(method body truncated to match context)

## .class public final Lsl6; — smali/sl6.smali
.method public constructor <init>(Landroid/os/IBinder;)V
   10: .method public constructor <init>(Landroid/os/IBinder;)V
   11:     .locals 1
   12: 
   13:     .line 1
   14:     const-string v0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate"
   15: 
   16:     .line 2
   17:     .line 3
   18:     invoke-direct {p0, p1, v0}, Lld6;-><init>(Landroid/os/IBinder;Ljava/lang/String;)V
   19: 
   20:     .line 4
   21:     .line 5
   22:     .line 6
   23:     return-void
   24: .end method

## .class public abstract Ltl6; — smali/tl6.smali
.method public constructor <init>()V
   10: .method public constructor <init>()V
   11:     .locals 1
   12: 
   13:     .line 1
   14:     const-string v0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate"
   15: 
   16:     .line 2
   17:     .line 3
   18:     invoke-direct {p0, v0}, Lmd6;-><init>(Ljava/lang/String;)V
   19: 
   20:     .line 4
   21:     .line 5
   22:     .line 6
   23:     return-void
   24: .end method

## .class public abstract Ltl6; — smali/tl6.smali
.method public static zzdG(Landroid/os/IBinder;)Lul6;
   26: .method public static zzdG(Landroid/os/IBinder;)Lul6;
   27:     .locals 2
   28: 
   29:     .line 1
   30:     if-nez p0, :cond_0
   31: 
   32:     .line 2
   33:     .line 3
   34:     const/4 p0, 0x0
   35: 
   36:     .line 4
   37:     return-object p0
   38: 
   39:     .line 5
   40:     :cond_0
   41:     const-string v0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate"
   42: 
   43:     .line 6
   44:     .line 7
   45:     invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;
   46: 
   47:     .line 8
   48:     .line 9
   49:     .line 10
   50:     move-result-object v0
   51: 
   52:     .line 11
   53:     instance-of v1, v0, Lul6;
   54: 
   55:     .line 12
   56:     .line 13
   57:     if-eqz v1, :cond_1
   58: 
   59:     .line 14
   60:     .line 15
   61:     check-cast v0, Lul6;
   62: 
   63:     .line 16
   64:     .line 17
   65:     return-object v0
   66: 
   67:     .line 18
   68:     :cond_1
   69:     new-instance v0, Lsl6;
   70: 
   71:     .line 19
   72:     .line 20
   73:     invoke-direct {v0, p0}, Lsl6;-><init>(Landroid/os/IBinder;)V
   74: 
   75:     .line 21
   76:     .line 22
   77:     .line 23
   78:     return-object v0
   79: .end method

## .class public final Lwa8; — smali/wa8.smali
.method public synthetic constructor <init>(Lva8;)V
   57: .method public synthetic constructor <init>(Lva8;)V
  469:     if-nez v2, :cond_5
  470: 
  471:     .line 198
  472:     .line 199
  473:     new-instance v3, Lgl6;
  474: 
  475:     .line 200
  476:     .line 201
  477:     new-instance v2, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;
  478: 
  479:     .line 202
  480:     .line 203
  481:     invoke-direct {v2}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;-><init>()V
  482: 
  483:     .line 204
  484:     .line 205
  485:     .line 206
  486:     invoke-virtual {v2}, Lcom/google/android/gms/ads/formats/NativeAdOptions$Builder;->build()Lcom/google/android/gms/ads/formats/NativeAdOptions;
  487: 
  488:     .line 207
  489:     .line 208
  490:     .line 209
  491:     move-result-object v2
  492: 
  493:     .line 210
  494:     invoke-direct {v3, v2}, Lgl6;-><init>(Lcom/google/android/gms/ads/formats/NativeAdOptions;)V
  495: 
  496:     .line 211
  497:     .line 212
  498:     .line 213
  499:     goto :goto_3
  500: 
  501:     .line 214
  502:     :cond_5
  503:     invoke-virtual {v1}, Lva8;->d()Lgl6;
  700: .end method
(method body truncated to match context)

## .class public final Lx24; — smali/x24.smali
.method public final getAdmobNativeCommonAdUnit()Ljava/lang/String;
 1439: .method public final getAdmobNativeCommonAdUnit()Ljava/lang/String;
 1440:     .locals 2
 1441: 
 1442:     .line 1
 1443:     iget-object v0, p0, Lx24;->sharedPreferences:Landroid/content/SharedPreferences;
 1444: 
 1445:     .line 2
 1446:     .line 3
 1447:     iget-object p0, p0, Lx24;->KEY_ADS_NATIVE_COMMON:Ljava/lang/String;
 1448: 
 1449:     .line 4
 1450:     .line 5
 1451:     sget-object v1, Lcom/applovin/mediation/AdIdHelper;->INSTANCE:Lcom/applovin/mediation/AdIdHelper;
 1452: 
 1453:     .line 6
 1454:     .line 7
 1455:     invoke-virtual {v1}, Lcom/applovin/mediation/AdIdHelper;->getNativeCommonId()Ljava/lang/String;
 1456: 
 1457:     .line 8
 1458:     .line 9
 1459:     .line 10
 1460:     move-result-object v1
 1461: 
 1462:     .line 11
 1463:     invoke-interface {v0, p0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 1464: 
 1465:     .line 12
 1466:     .line 13
 1467:     .line 14
 1468:     move-result-object p0
 1469: 
 1470:     .line 15
 1471:     return-object p0
 1472: .end method

## .class public final Lyn6; — smali/yn6.smali
.method public final b(Ljava/util/Map;Ljava/lang/Object;)V
  155: .method public final b(Ljava/util/Map;Ljava/lang/Object;)V
 4256:     .line 1957
 4257:     .line 1958
 4258:     .line 1959
 4259:     :goto_1f
 4260:     return-void
 4261: 
 4262:     .line 1960
 4263:     :pswitch_18
 4264:     const-string v0, "nativeAdViewSignalsReady"
 4265: 
 4266:     .line 1961
 4267:     .line 1962
 4268:     move-object/from16 v1, p2
 4269: 
 4270:     .line 1963
 4271:     .line 1964
 4272:     check-cast v1, Lt57;
 4273: 
 4523: .end method
(method body truncated to match context)

## .class public final Lzl6; — smali/zl6.smali
.method public constructor <init>(Landroid/os/IBinder;)V
   10: .method public constructor <init>(Landroid/os/IBinder;)V
   11:     .locals 1
   12: 
   13:     .line 1
   14:     const-string v0, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator"
   15: 
   16:     .line 2
   17:     .line 3
   18:     invoke-direct {p0, p1, v0}, Lld6;-><init>(Landroid/os/IBinder;Ljava/lang/String;)V
   19: 
   20:     .line 4
   21:     .line 5
   22:     .line 6
   23:     return-void
   24: .end method


## Resource layouts mentioning native ads

- res/layout/activity_intro.xml: <androidx.constraintlayout.widget.ConstraintLayout android:orientation="horizontal" android:id="@id/topContainer" android:padding="@dimen/_10sdp" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraint <com.applovin.mediation.NativeAdLayout android:id="@id/nativeAdLayout" android:layout_width="match_parent" android:layout_height="wrap_content" app:layout_constraintBottom_toBottomOf="parent" />
- res/layout/item_native_ad.xml: <com.applovin.mediation.NativeAdLayout android:id="@id/nativeAdView" android:padding="@dimen/_5sdp" android:layout_width="match_parent" android:layout_height="wrap_content" />
- res/layout/large_native_ad.xml: <com.google.android.gms.ads.nativead.NativeAdView android:layout_width="match_parent" android:layout_height="280.0dp" android:minHeight="280.0dp" <com.google.android.gms.ads.nativead.MediaView android:layout_gravity="center_horizontal" android:id="@id/ad_media" android:layout_width="match_parent" android:layout_height="match_parent" android:layout_marginLeft="@dimen/_10sdp" android:l </com.google.android.gms.ads.nativead.NativeAdView>
- res/layout/layout_native_ad.xml: <include android:id="@id/nativeAdLayout" layout="@layout/shimmer_native_ad" />

## Aggregate

Matching smali instructions: 385
Classes with matching methods: 44
