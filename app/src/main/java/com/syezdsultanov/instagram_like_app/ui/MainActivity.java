package com.syezdsultanov.instagram_like_app.ui;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;


import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syezdsultanov.instagram_like_app.R;
import com.syezdsultanov.instagram_like_app.data.Image;
import com.syezdsultanov.instagram_like_app.data.ImageArrayAdapter;
import com.syezdsultanov.instagram_like_app.presenter.UserPresenter;
import com.syezdsultanov.instagram_like_app.presenter.UserView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends MvpAppCompatActivity implements UserView {

    @InjectPresenter
    UserPresenter presenter;

    TextView follow_this_profile, posts_num_tv, following_num_tv, followers_num_tv, display_name_tv, description;
    CircleImageView other_user_profile_image;
    int other_user_id, user_id;
    GridView images_grid_layout;
    ArrayList<Image> arrayListImages;
    ImageArrayAdapter imageArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        follow_this_profile = findViewById(R.id.follow_this_profile);
        posts_num_tv = findViewById(R.id.posts_num_tv);
        following_num_tv = findViewById(R.id.following_num_tv);
        followers_num_tv = findViewById(R.id.followers_num_tv);
        display_name_tv = findViewById(R.id.display_name_tv);
        description = findViewById(R.id.description);
        other_user_profile_image = findViewById(R.id.profile_image);
        images_grid_layout = findViewById(R.id.images_grid_layout);
        follow_this_profile.setEnabled(false);
        other_user_id = getIntent().getIntExtra("user_id", 0);

        arrayListImages = new ArrayList<>();
        imageArrayAdapter = new ImageArrayAdapter(MainActivity.this, 0, arrayListImages);
        images_grid_layout.setAdapter(imageArrayAdapter);


    }

//    private void getAllImages() {
//
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLS.get_all_images + other_user_id,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//
//                            if (!jsonObject.getBoolean("error")) {
//
//
//                                JSONArray jsonObjectImages = jsonObject.getJSONArray("images");
//
//                                Log.i("arrayImages", jsonObjectImages.toString());
//
//                                for (int i = 0; i < jsonObjectImages.length(); i++) {
//                                    JSONObject jsonObjectSingleImage = jsonObjectImages.getJSONObject(i);
//                                    Log.i("jsonsingleImage", jsonObjectSingleImage.toString());
//
//                                    Image image = new Image(jsonObjectSingleImage.getInt("id"),
//                                            jsonObjectSingleImage.getString("image_url"),
//                                            jsonObjectSingleImage.getString("image_name")
//                                            , jsonObjectSingleImage.getInt("user_id"));
//
//                                    arrayListImages.add(image);
//
//
//                                }
//
//
//                                imageArrayAdapter.notifyDataSetChanged();
//
//                            } else {
//
//                                Toast.makeText(ProfileActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
//
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(ProfileActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
//
//                    }
//                }
//
//
//        );
//
//        VolleyHandler.getInstance(getApplicationContext()).addRequetToQueue(stringRequest);
//
//
//    }
//
//        posts_num_tv.setText(String.valueOf(user.getPosts()));
//        following_num_tv.setText(String.valueOf(user.getFollowing()));
//        followers_num_tv.setText(String.valueOf(user.getFollowers()));
//        display_name_tv.setText(user.getUsername());
//        description.setText(user.getEmail());
//
//
//    }


    @Override
    public void setName(String name) {

    }

    @Override
    public void setImage(String imageUrl) {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void startLoad() {

    }

    @Override
    public void finishLoad() {

    }
}
