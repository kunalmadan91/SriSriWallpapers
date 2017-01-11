package com.madan.kunal.srisriwallpapers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private AdView mAdView;
    Image img[] = {new Image (R.drawable.img),
            new Image (R.drawable.img1),
            new Image(R.drawable.img2),
            new Image (R.drawable.img3),
            new Image(R.drawable.img4),
            new Image(R.drawable.img5),
            new Image(R.drawable.img6),
            new Image(R.drawable.img7),
            new Image(R.drawable.img8),
            new Image(R.drawable.img9),
            new Image(R.drawable.img10),
            new Image(R.drawable.img11),
            new Image(R.drawable.img12),
            new Image(R.drawable.img13),
            new Image(R.drawable.img14),
            new Image(R.drawable.img15),
            new Image(R.drawable.img16),
            new Image(R.drawable.img17),
            new Image(R.drawable.img18),
            new Image(R.drawable.img19),
            new Image(R.drawable.img20),
            new Image(R.drawable.img21),
            new Image(R.drawable.img22),
            new Image(R.drawable.img23),
            new Image(R.drawable.img24),
            new Image(R.drawable.img25),
            new Image(R.drawable.img26),
            new Image(R.drawable.img27),
            new Image(R.drawable.img28),
            new Image(R.drawable.img29),
            new Image(R.drawable.img30),
            new Image(R.drawable.img34),
            new Image(R.drawable.img35),
            new Image(R.drawable.img36),
            new Image(R.drawable.img37),
            new Image(R.drawable.img38),
            new Image(R.drawable.img39),
            new Image(R.drawable.img40),
            new Image(R.drawable.img41),
            new Image(R.drawable.img42),
            new Image(R.drawable.img43),
            new Image(R.drawable.img44),
            new Image(R.drawable.img45),
            new Image(R.drawable.img46),
            new Image(R.drawable.img47),
            new Image(R.drawable.img48),
            new Image(R.drawable.img49),
            new Image(R.drawable.img50),
            new Image(R.drawable.img51),
            new Image(R.drawable.img52),
            new Image(R.drawable.img53),
            new Image(R.drawable.img54),
            new Image(R.drawable.img55),
            new Image(R.drawable.img56),
            new Image(R.drawable.img57),
            new Image(R.drawable.img58),
            new Image(R.drawable.img59),
            new Image(R.drawable.img60),
            new Image(R.drawable.img61),
            new Image(R.drawable.img62),
            new Image(R.drawable.img63),
            new Image(R.drawable.img64),
            new Image(R.drawable.img65),
            new Image(R.drawable.img66),
            new Image(R.drawable.img67),
            new Image(R.drawable.img68),
            new Image(R.drawable.img69),
            new Image(R.drawable.img70),
            new Image(R.drawable.img71),
            new Image(R.drawable.img72),
            new Image(R.drawable.img73),
            new Image(R.drawable.img74),
            new Image(R.drawable.img75),
            new Image(R.drawable.img76),
            new Image(R.drawable.img77),
            new Image(R.drawable.img78),
            new Image(R.drawable.img79),
            new Image(R.drawable.img80),
            new Image(R.drawable.img81),
            new Image(R.drawable.img82),
            new Image(R.drawable.img83),
            new Image(R.drawable.img84),
            new Image(R.drawable.img85),
            new Image(R.drawable.img86),
            new Image(R.drawable.img87),
            new Image(R.drawable.img88),
            new Image(R.drawable.img89),
            new Image(R.drawable.img90),
            new Image(R.drawable.img91),
            new Image(R.drawable.img92),
            new Image(R.drawable.img93),
            new Image(R.drawable.img93),
            new Image(R.drawable.img93),
            new Image(R.drawable.img93),
            new Image(R.drawable.img100),
            new Image(R.drawable.img101),
            new Image(R.drawable.img102),
            new Image(R.drawable.img103),
            new Image(R.drawable.img104),
            new Image(R.drawable.img105),
            new Image(R.drawable.img106),
            new Image(R.drawable.img107),
            new Image(R.drawable.img108),
            new Image(R.drawable.img109),
            new Image(R.drawable.img110),
            new Image(R.drawable.img111),
            new Image(R.drawable.img112),
            new Image(R.drawable.img113),
            new Image(R.drawable.img114),
            new Image(R.drawable.img115),
            new Image(R.drawable.img116),
            new Image(R.drawable.img117),
            new Image(R.drawable.img118),
            new Image(R.drawable.img119),
            new Image(R.drawable.img120),
            new Image(R.drawable.img121),
            new Image(R.drawable.img122),
            new Image(R.drawable.img123),
            new Image(R.drawable.img124),
            new Image(R.drawable.img125),
            new Image(R.drawable.img126),
            new Image(R.drawable.img127),
            new Image(R.drawable.img128),
            new Image(R.drawable.img129),
            new Image(R.drawable.img130),
            new Image(R.drawable.img131),
            new Image(R.drawable.img132),
            new Image(R.drawable.img133),
            new Image(R.drawable.img134),
            new Image(R.drawable.img135),
            new Image(R.drawable.img136),
            new Image(R.drawable.img137),
            new Image(R.drawable.img138),
            new Image(R.drawable.img139),
            new Image(R.drawable.img140),
            new Image(R.drawable.img141),
            new Image(R.drawable.img142),
            new Image(R.drawable.img143),
            new Image(R.drawable.img144),
            new Image(R.drawable.img145),
            new Image(R.drawable.img146),
            new Image(R.drawable.img147),
            new Image(R.drawable.img148),
    };

    ImagesAdapter imagesAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.movies_grid);

        List imgList = Arrays.asList(img);
        Collections.shuffle(imgList);
        imagesAdapter = new ImagesAdapter(getActivity(), new ArrayList<Image>());
        imagesAdapter.addAll(imgList);
        gridView.setAdapter(imagesAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Image img = imagesAdapter.getItem(position);

                Intent detailView = new Intent(getActivity(),WallpaperActivity.class);

                detailView.putExtra("KEY",img.getImageId());

                startActivity(detailView);
            }
        });

        mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

       /* RelativeLayout adViewContainer = (RelativeLayout) rootView.findViewById(R.id.adViewContainer);

        adView = new AdView(getActivity(), "326817451028391_326871724356297", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();*/
        return rootView;
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);

        return array[rnd];
    }
}
