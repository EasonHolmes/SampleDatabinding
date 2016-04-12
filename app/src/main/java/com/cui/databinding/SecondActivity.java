package com.cui.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.cui.databinding.http.ApiClient;
import com.cui.mvvms.R;
import com.cui.mvvms.databinding.SecondActBinding;
import com.cui.databinding.entity.PostEntity;
import com.cui.databinding.entity.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/*
                                                    .
                                          .,;irrrrrrrrrrrrrri:..
                                      ,;r11srri;:,.....,,;irrr11si:.
                                   :r11si:,                   .,;s1h1i,
          .ih55hr,              ,rhhs;.                            ,i1hs;
           ;1hS8831.          ,s51;.                                  ,r5h;              ,;;;,.
         .    i3889r        .r5s,                                       .r51:         .rS9889h;.
        .sShirS9999Ss:.    :11;;;.   .                                    .s5r       .18885i,
         ,1988889398G9Ss:,ihs;5G9;.iS1.         .,,,:::::::,,.              ;hh,    ,r3899S; .;r:
           .;rri:,;1S8G8995i.;shS9SSs;.      ,ih399999999933935r:            :h1:,r538888889398h:
                    .:s599i  ,;15S991,     :h98S1i;::::::::;i1S885i.          ,1388889hrsh5SS1;
                       :5r. .i35; .s39h:.;h98h;                :1985i.         ,S8S1;,    ..
                      .r5:    .   ..;589S9895r;iiiiiiiiiiiiiiii;ih9G95r;:      .shi
                      :1s.     ;hS3933998899999899888998889998888999988891,     ;hr
                      ih:     s9889998833399899999999999999989333998999988h,    .1s.
                      ih,    .S89998Ss;,..,;sS8898888888889Ss;,..,;sS899985,     rs,
                      ih,    .s9G89s..ih5S5r..i11111111111i,:s5SS1; .s9888s,     rs.
                      ih,     .iS3s.:585srh93sirrrrrrrrrrrr1931rs38h..135i.      11.
                      ;hr.      ..  s83,  .18G888888888888GG8r   i89;  .        :hs
                      ,s5,          :h8311S9Sr;;iiiiiiiiii;s3951h39s.           rhi
                       ;5r.          .;s11s;.               .is11r:            ,5s.
                       .rSi             :ri:,.             .,,;1s.            ,h1:
                        .s5i           .h8GG91rs1rri;:is11rs988G9;           ,s5:
                         .rhi          ,rrr53559GGG85h8GG8S1S351r,          ,15:
                          .s3s.       .r99hri::irsh1rihh11s;iir1S5;        ;S5:
                       ,i1S98GSi.     .;1S98Ssh5111si;s11h5159895r,      :h8G951;.
                   .;s538G895sr1hs:   .r51riii5998G85h888891s1siss:   .;1hss59G883hi,
          :irr;,,ihS8GG8Shi,.:sh1i. ;3835hriirsssii1111rr1h59Gh, :shhr,  .:r5988895r:,irri:
       .iS893393988895s;.         .i11srS88998993S5h55h5S399999891rshs:         ,i138889993399h;
       i88s, ,i3831i,               .;r1S88999999888888999939895si:.              .;1985:..:hG3;
       sG9i   :3G1                     .rS889999999999999988Sr.                    .5G5.  .s89i
       ,s99Sh598h:                       .ihS9888888888893hi,                       ;5835h383r.
          ,rh55s:                            .:;s11hhh1si:,                           .;s55hr,


       :r1111i,     ,1r,   ,ii.   ,rss1s:.          ;sss1r,   ,r1r,   ,r11sr,     ,r1s1s;    :sss1r,
     .sShi::i5S;.  .i98h:  iS5.   ;91;;;,          .hSi:iS5:  .191.  .i31:;:.   .s5hi:;;:   .13i:;:.
    .;3s     :5S:  .rhrsSi ;5h.   ;S1;;:.          .h5:.:5S;   iSi    ;S1;;:.  .i3s         .sSr::,
    .i3r     ,hS:  .rSi r3rihh.   ;S1ii;.          .13h1hs:    iS;.   ;S1ii;.  .r3r         .sSrii:
     .hSs,..;hSi.  .r3r  :h331.   i3s,.,.          .hS:..     .s9s.  .i3s..,.   ,h5s:..:,   .1S;.,,.
      .ihhs1hs:    .;1;   ,15i    :hh111i.         .ss.       :1S1,   :1h111;.   .ihh111i    i5111s:
         ...                          ..                                            ...           .

*/
public class SecondActivity extends AppCompatActivity {
    List<ResponseEntity.SubjectsEntity> list = new ArrayList<ResponseEntity.SubjectsEntity>();
    ImgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SecondActBinding binding = DataBindingUtil.setContentView(this, R.layout.second_act);
        binding.mToolbar.setTitle(SecondActivity.class.getSimpleName());
        setSupportActionBar(binding.mToolbar);
        binding.listRecycler.setHasFixedSize(true);
        binding.listRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.listRecycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new ImgAdapter(list);
        binding.listRecycler.setAdapter(adapter);

        ApiClient.SERVICE_rx.getCookListResult(new PostEntity("美剧", 0, 30))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseEntity>() {
                    @Override
                    public void call(ResponseEntity responseEntity) {
                        list.addAll(responseEntity.subjects);
                        adapter.notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(getClass().getName(), "throwable===" + throwable.getMessage().toString());
                    }
                });
    }
}
