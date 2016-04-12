package com.cui.databinding.entity;


import android.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuiyang on 16/4/11.
 */
public class ResponseEntity{


    public List<SubjectsEntity> subjects = new ArrayList<SubjectsEntity>();


    public class SubjectsEntity {
        /**
         * max : 10
         * average : 7.5
         * stars : 40
         * min : 0
         */

        private RatingEntity rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        /**
         * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2226063824.jpg
         * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2226063824.jpg
         * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2226063824.jpg
         */

        private ImagesEntity images;
        private String alt;
        private String id;
        private List<String> genres;
        /**
         * alt : https://movie.douban.com/celebrity/1010552/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/908.jpg","large":"https://img1.doubanio.com/img/celebrity/large/908.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/908.jpg"}
         * name : 乔斯·韦登
         * id : 1010552
         */

        private List<CastsEntity> casts;
        /**
         * alt : null
         * avatars : null
         * name : Des Doyle
         * id : null
         */

        private List<DirectorsEntity> directors;

        public RatingEntity getRating() {
            return rating;
        }

        public void setRating(RatingEntity rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesEntity getImages() {
            return images;
        }

        public void setImages(ImagesEntity images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsEntity> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsEntity> casts) {
            this.casts = casts;
        }

        public List<DirectorsEntity> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsEntity> directors) {
            this.directors = directors;
        }

        public class RatingEntity {
            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public class ImagesEntity {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public class CastsEntity {
            private String alt;
            /**
             * small : https://img1.doubanio.com/img/celebrity/small/908.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/908.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/908.jpg
             */

            private AvatarsEntity avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public class AvatarsEntity {
                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public class DirectorsEntity {
            private Object alt;
            private Object avatars;
            private String name;
            private Object id;

            public Object getAlt() {
                return alt;
            }

            public void setAlt(Object alt) {
                this.alt = alt;
            }

            public Object getAvatars() {
                return avatars;
            }

            public void setAvatars(Object avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }
        }
    }
}
