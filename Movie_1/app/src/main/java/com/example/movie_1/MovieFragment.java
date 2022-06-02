package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.movie_1.adapter.MovieAdapter;
import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment {

    // 안드로이드에서 만들어 준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;

    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewByid 대체 (뷰 바인딩 활용)
//         inflater.inflate(R.layout.fragment_movie, container, false);
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // 리사이클러 뷰 만들어주기
        // 아직 없음  (입체적으로 생각)
        setupRecyclerView(list);
        requestMoviesData(1);
        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        movieService.repoContributors("rating", 10, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨 받았으면 adapter에 데이터를 전달해서
                            // 화면을 갱신 처리
                            List<Movie> list = response.body().getData().getMovies();
                            movieAdapter.addItemList(list);
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }


    // 통신해서 JSON 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        movieAdapter.addItemList(movieList);

        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        // 3. xml 파일에 선언한 recyclerView에 세팅
        binding.recyclerView.setAdapter(movieAdapter);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.hasFixedSize();

        // 이벤트 리스너
    }

}