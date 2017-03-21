package com.jieleo.rxjavaplusretrofit;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/21.
 */


public class NewBean {

    /**
     * Result : 0
     * movieDetail : {"papaNo":66,"unlockUserNo":0,"coverUrl":"http://yf.jnwtv.com/MC2016092714014496405577.jpg?imageView2/1/w/480/h/267&e=2997426444","writeDate":"2016-09-30  14:27:08","unlockTm":0,"isPublic":"Y","playNums":84741,"movieDesc":"一晚错误的旖旎与缠绵","mId":1193,"episodeState":"P","title":"婚途陌路 第1集","playPermission":"Y","actorState":{},"healState":null,"playState":{"staffInfo":{"isUnlocked":"N","mPartTime":"55000","mPartUrl":"http://yf.jnwtv.com/M20161025121111756174414.mp4?e=2997426444","mType":"3","mUnlockJpoint":0,"mId":1193,"mpName":"YYB","mpId":1013,"mpIdFeature":0,"writeDate":"2016-09-27 12:07:50"},"endNodeNums":1,"isLike":"N","isCollection":"N","collectionNums":710,"shareUrl":"http://mp.weixin.qq.com/s?__biz=MzA3NTMzNTQ0NQ==&mid=2654257842&idx=1&sn=a37f1a7116c4f9f70a2b4be38f363ace&chksm=84b270c8b3c5f9dec5b1b3921f8ba981714044bddb0afa1cf93b9e2482d3c3e6837b3cf714ac#rd","likeNums":648,"isShareGuide":1,"shareNums":1347,"endNodeLists":[{"mId":1193,"mpId":1011,"nodeId":1095,"jpointMount":0,"writeDate":"2016-09-27 12:08:29","isUnlock":"N"}],"unlockEndNodeNums":0,"movieFeatureList":[{"isUnlocked":"N","mPartTime":"20000","mPartUrl":"http://yf.jnwtv.com/M20161025121142589488162.mp4?e=2997426444","mType":"2","mUnlockJpoint":"0","mId":"1193","mpName":"HX","mpId":"1012","mpIdFeature":"0","nodeNameFather":null,"nodeIdFather":null,"writeDate":"2016-09-27 12:07:25"}]},"papaInfoLists":[{"papaAccount":"13916251597","papaHeadImgUrl":"http://yf.jnwtv.com/5601d479dcbfda34bad5361d059443ab?imageView2/0/w/90/h/90&e=2997426444","userNick":"穿衣君","healAmount":"100000","isOwner":"N","isBigPapa":"Y","isFirstBlood":"N","isProjectCrew":"N","isPapa":"N","lvNo":"87"},{"papaAccount":"19911110011","papaHeadImgUrl":"http://yf.jnwtv.com/715b0209-d3f0-4d44-b14c-d781a602ce88?imageView2/0/w/90/h/90&e=2997426444","userNick":"无双","healAmount":"50000","isOwner":"N","isBigPapa":"N","isFirstBlood":"N","isProjectCrew":"N","isPapa":"Y","lvNo":"120"},{"papaAccount":"19911110012","papaHeadImgUrl":"http://yf.jnwtv.com/2147b2d7-4f64-4977-81ba-a891b3813778?imageView2/0/w/90/h/90&e=2997426444","userNick":"会有天使替我爱你","healAmount":"40000","isOwner":"N","isBigPapa":"N","isFirstBlood":"N","isProjectCrew":"N","isPapa":"Y","lvNo":"76"}],"unlockJpoint":0}
     * Desc : \u6210\u529f
     */

    private String Result;
    private MovieDetailBean movieDetail;
    private String Desc;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public MovieDetailBean getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetailBean movieDetail) {
        this.movieDetail = movieDetail;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public static class MovieDetailBean {
        /**
         * papaNo : 66
         * unlockUserNo : 0
         * coverUrl : http://yf.jnwtv.com/MC2016092714014496405577.jpg?imageView2/1/w/480/h/267&e=2997426444
         * writeDate : 2016-09-30  14:27:08
         * unlockTm : 0
         * isPublic : Y
         * playNums : 84741
         * movieDesc : 一晚错误的旖旎与缠绵
         * mId : 1193
         * episodeState : P
         * title : 婚途陌路 第1集
         * playPermission : Y
         * actorState : {}
         * healState : null
         * playState : {"staffInfo":{"isUnlocked":"N","mPartTime":"55000","mPartUrl":"http://yf.jnwtv.com/M20161025121111756174414.mp4?e=2997426444","mType":"3","mUnlockJpoint":0,"mId":1193,"mpName":"YYB","mpId":1013,"mpIdFeature":0,"writeDate":"2016-09-27 12:07:50"},"endNodeNums":1,"isLike":"N","isCollection":"N","collectionNums":710,"shareUrl":"http://mp.weixin.qq.com/s?__biz=MzA3NTMzNTQ0NQ==&mid=2654257842&idx=1&sn=a37f1a7116c4f9f70a2b4be38f363ace&chksm=84b270c8b3c5f9dec5b1b3921f8ba981714044bddb0afa1cf93b9e2482d3c3e6837b3cf714ac#rd","likeNums":648,"isShareGuide":1,"shareNums":1347,"endNodeLists":[{"mId":1193,"mpId":1011,"nodeId":1095,"jpointMount":0,"writeDate":"2016-09-27 12:08:29","isUnlock":"N"}],"unlockEndNodeNums":0,"movieFeatureList":[{"isUnlocked":"N","mPartTime":"20000","mPartUrl":"http://yf.jnwtv.com/M20161025121142589488162.mp4?e=2997426444","mType":"2","mUnlockJpoint":"0","mId":"1193","mpName":"HX","mpId":"1012","mpIdFeature":"0","nodeNameFather":null,"nodeIdFather":null,"writeDate":"2016-09-27 12:07:25"}]}
         * papaInfoLists : [{"papaAccount":"13916251597","papaHeadImgUrl":"http://yf.jnwtv.com/5601d479dcbfda34bad5361d059443ab?imageView2/0/w/90/h/90&e=2997426444","userNick":"穿衣君","healAmount":"100000","isOwner":"N","isBigPapa":"Y","isFirstBlood":"N","isProjectCrew":"N","isPapa":"N","lvNo":"87"},{"papaAccount":"19911110011","papaHeadImgUrl":"http://yf.jnwtv.com/715b0209-d3f0-4d44-b14c-d781a602ce88?imageView2/0/w/90/h/90&e=2997426444","userNick":"无双","healAmount":"50000","isOwner":"N","isBigPapa":"N","isFirstBlood":"N","isProjectCrew":"N","isPapa":"Y","lvNo":"120"},{"papaAccount":"19911110012","papaHeadImgUrl":"http://yf.jnwtv.com/2147b2d7-4f64-4977-81ba-a891b3813778?imageView2/0/w/90/h/90&e=2997426444","userNick":"会有天使替我爱你","healAmount":"40000","isOwner":"N","isBigPapa":"N","isFirstBlood":"N","isProjectCrew":"N","isPapa":"Y","lvNo":"76"}]
         * unlockJpoint : 0
         */

        private int papaNo;
        private int unlockUserNo;
        private String coverUrl;
        private String writeDate;
        private int unlockTm;
        private String isPublic;
        private int playNums;
        private String movieDesc;
        private int mId;
        private String episodeState;
        private String title;
        private String playPermission;
        private ActorStateBean actorState;
        private Object healState;
        private PlayStateBean playState;
        private int unlockJpoint;
        private List<PapaInfoListsBean> papaInfoLists;

        public int getPapaNo() {
            return papaNo;
        }

        public void setPapaNo(int papaNo) {
            this.papaNo = papaNo;
        }

        public int getUnlockUserNo() {
            return unlockUserNo;
        }

        public void setUnlockUserNo(int unlockUserNo) {
            this.unlockUserNo = unlockUserNo;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getWriteDate() {
            return writeDate;
        }

        public void setWriteDate(String writeDate) {
            this.writeDate = writeDate;
        }

        public int getUnlockTm() {
            return unlockTm;
        }

        public void setUnlockTm(int unlockTm) {
            this.unlockTm = unlockTm;
        }

        public String getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(String isPublic) {
            this.isPublic = isPublic;
        }

        public int getPlayNums() {
            return playNums;
        }

        public void setPlayNums(int playNums) {
            this.playNums = playNums;
        }

        public String getMovieDesc() {
            return movieDesc;
        }

        public void setMovieDesc(String movieDesc) {
            this.movieDesc = movieDesc;
        }

        public int getMId() {
            return mId;
        }

        public void setMId(int mId) {
            this.mId = mId;
        }

        public String getEpisodeState() {
            return episodeState;
        }

        public void setEpisodeState(String episodeState) {
            this.episodeState = episodeState;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPlayPermission() {
            return playPermission;
        }

        public void setPlayPermission(String playPermission) {
            this.playPermission = playPermission;
        }

        public ActorStateBean getActorState() {
            return actorState;
        }

        public void setActorState(ActorStateBean actorState) {
            this.actorState = actorState;
        }

        public Object getHealState() {
            return healState;
        }

        public void setHealState(Object healState) {
            this.healState = healState;
        }

        public PlayStateBean getPlayState() {
            return playState;
        }

        public void setPlayState(PlayStateBean playState) {
            this.playState = playState;
        }

        public int getUnlockJpoint() {
            return unlockJpoint;
        }

        public void setUnlockJpoint(int unlockJpoint) {
            this.unlockJpoint = unlockJpoint;
        }

        public List<PapaInfoListsBean> getPapaInfoLists() {
            return papaInfoLists;
        }

        public void setPapaInfoLists(List<PapaInfoListsBean> papaInfoLists) {
            this.papaInfoLists = papaInfoLists;
        }

        public static class ActorStateBean {
        }

        public static class PlayStateBean {
            /**
             * staffInfo : {"isUnlocked":"N","mPartTime":"55000","mPartUrl":"http://yf.jnwtv.com/M20161025121111756174414.mp4?e=2997426444","mType":"3","mUnlockJpoint":0,"mId":1193,"mpName":"YYB","mpId":1013,"mpIdFeature":0,"writeDate":"2016-09-27 12:07:50"}
             * endNodeNums : 1
             * isLike : N
             * isCollection : N
             * collectionNums : 710
             * shareUrl : http://mp.weixin.qq.com/s?__biz=MzA3NTMzNTQ0NQ==&mid=2654257842&idx=1&sn=a37f1a7116c4f9f70a2b4be38f363ace&chksm=84b270c8b3c5f9dec5b1b3921f8ba981714044bddb0afa1cf93b9e2482d3c3e6837b3cf714ac#rd
             * likeNums : 648
             * isShareGuide : 1
             * shareNums : 1347
             * endNodeLists : [{"mId":1193,"mpId":1011,"nodeId":1095,"jpointMount":0,"writeDate":"2016-09-27 12:08:29","isUnlock":"N"}]
             * unlockEndNodeNums : 0
             * movieFeatureList : [{"isUnlocked":"N","mPartTime":"20000","mPartUrl":"http://yf.jnwtv.com/M20161025121142589488162.mp4?e=2997426444","mType":"2","mUnlockJpoint":"0","mId":"1193","mpName":"HX","mpId":"1012","mpIdFeature":"0","nodeNameFather":null,"nodeIdFather":null,"writeDate":"2016-09-27 12:07:25"}]
             */

            private StaffInfoBean staffInfo;
            private int endNodeNums;
            private String isLike;
            private String isCollection;
            private int collectionNums;
            private String shareUrl;
            private int likeNums;
            private int isShareGuide;
            private int shareNums;
            private int unlockEndNodeNums;
            private List<EndNodeListsBean> endNodeLists;
            private List<MovieFeatureListBean> movieFeatureList;

            public StaffInfoBean getStaffInfo() {
                return staffInfo;
            }

            public void setStaffInfo(StaffInfoBean staffInfo) {
                this.staffInfo = staffInfo;
            }

            public int getEndNodeNums() {
                return endNodeNums;
            }

            public void setEndNodeNums(int endNodeNums) {
                this.endNodeNums = endNodeNums;
            }

            public String getIsLike() {
                return isLike;
            }

            public void setIsLike(String isLike) {
                this.isLike = isLike;
            }

            public String getIsCollection() {
                return isCollection;
            }

            public void setIsCollection(String isCollection) {
                this.isCollection = isCollection;
            }

            public int getCollectionNums() {
                return collectionNums;
            }

            public void setCollectionNums(int collectionNums) {
                this.collectionNums = collectionNums;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }

            public int getLikeNums() {
                return likeNums;
            }

            public void setLikeNums(int likeNums) {
                this.likeNums = likeNums;
            }

            public int getIsShareGuide() {
                return isShareGuide;
            }

            public void setIsShareGuide(int isShareGuide) {
                this.isShareGuide = isShareGuide;
            }

            public int getShareNums() {
                return shareNums;
            }

            public void setShareNums(int shareNums) {
                this.shareNums = shareNums;
            }

            public int getUnlockEndNodeNums() {
                return unlockEndNodeNums;
            }

            public void setUnlockEndNodeNums(int unlockEndNodeNums) {
                this.unlockEndNodeNums = unlockEndNodeNums;
            }

            public List<EndNodeListsBean> getEndNodeLists() {
                return endNodeLists;
            }

            public void setEndNodeLists(List<EndNodeListsBean> endNodeLists) {
                this.endNodeLists = endNodeLists;
            }

            public List<MovieFeatureListBean> getMovieFeatureList() {
                return movieFeatureList;
            }

            public void setMovieFeatureList(List<MovieFeatureListBean> movieFeatureList) {
                this.movieFeatureList = movieFeatureList;
            }

            public static class StaffInfoBean {
                /**
                 * isUnlocked : N
                 * mPartTime : 55000
                 * mPartUrl : http://yf.jnwtv.com/M20161025121111756174414.mp4?e=2997426444
                 * mType : 3
                 * mUnlockJpoint : 0
                 * mId : 1193
                 * mpName : YYB
                 * mpId : 1013
                 * mpIdFeature : 0
                 * writeDate : 2016-09-27 12:07:50
                 */

                private String isUnlocked;
                private String mPartTime;
                private String mPartUrl;
                private String mType;
                private int mUnlockJpoint;
                private int mId;
                private String mpName;
                private int mpId;
                private int mpIdFeature;
                private String writeDate;

                public String getIsUnlocked() {
                    return isUnlocked;
                }

                public void setIsUnlocked(String isUnlocked) {
                    this.isUnlocked = isUnlocked;
                }

                public String getMPartTime() {
                    return mPartTime;
                }

                public void setMPartTime(String mPartTime) {
                    this.mPartTime = mPartTime;
                }

                public String getMPartUrl() {
                    return mPartUrl;
                }

                public void setMPartUrl(String mPartUrl) {
                    this.mPartUrl = mPartUrl;
                }

                public String getMType() {
                    return mType;
                }

                public void setMType(String mType) {
                    this.mType = mType;
                }

                public int getMUnlockJpoint() {
                    return mUnlockJpoint;
                }

                public void setMUnlockJpoint(int mUnlockJpoint) {
                    this.mUnlockJpoint = mUnlockJpoint;
                }

                public int getMId() {
                    return mId;
                }

                public void setMId(int mId) {
                    this.mId = mId;
                }

                public String getMpName() {
                    return mpName;
                }

                public void setMpName(String mpName) {
                    this.mpName = mpName;
                }

                public int getMpId() {
                    return mpId;
                }

                public void setMpId(int mpId) {
                    this.mpId = mpId;
                }

                public int getMpIdFeature() {
                    return mpIdFeature;
                }

                public void setMpIdFeature(int mpIdFeature) {
                    this.mpIdFeature = mpIdFeature;
                }

                public String getWriteDate() {
                    return writeDate;
                }

                public void setWriteDate(String writeDate) {
                    this.writeDate = writeDate;
                }
            }

            public static class EndNodeListsBean {
                /**
                 * mId : 1193
                 * mpId : 1011
                 * nodeId : 1095
                 * jpointMount : 0
                 * writeDate : 2016-09-27 12:08:29
                 * isUnlock : N
                 */

                private int mId;
                private int mpId;
                private int nodeId;
                private int jpointMount;
                private String writeDate;
                private String isUnlock;

                public int getMId() {
                    return mId;
                }

                public void setMId(int mId) {
                    this.mId = mId;
                }

                public int getMpId() {
                    return mpId;
                }

                public void setMpId(int mpId) {
                    this.mpId = mpId;
                }

                public int getNodeId() {
                    return nodeId;
                }

                public void setNodeId(int nodeId) {
                    this.nodeId = nodeId;
                }

                public int getJpointMount() {
                    return jpointMount;
                }

                public void setJpointMount(int jpointMount) {
                    this.jpointMount = jpointMount;
                }

                public String getWriteDate() {
                    return writeDate;
                }

                public void setWriteDate(String writeDate) {
                    this.writeDate = writeDate;
                }

                public String getIsUnlock() {
                    return isUnlock;
                }

                public void setIsUnlock(String isUnlock) {
                    this.isUnlock = isUnlock;
                }
            }

            public static class MovieFeatureListBean {
                /**
                 * isUnlocked : N
                 * mPartTime : 20000
                 * mPartUrl : http://yf.jnwtv.com/M20161025121142589488162.mp4?e=2997426444
                 * mType : 2
                 * mUnlockJpoint : 0
                 * mId : 1193
                 * mpName : HX
                 * mpId : 1012
                 * mpIdFeature : 0
                 * nodeNameFather : null
                 * nodeIdFather : null
                 * writeDate : 2016-09-27 12:07:25
                 */

                private String isUnlocked;
                private String mPartTime;
                private String mPartUrl;
                private String mType;
                private String mUnlockJpoint;
                private String mId;
                private String mpName;
                private String mpId;
                private String mpIdFeature;
                private Object nodeNameFather;
                private Object nodeIdFather;
                private String writeDate;

                public String getIsUnlocked() {
                    return isUnlocked;
                }

                public void setIsUnlocked(String isUnlocked) {
                    this.isUnlocked = isUnlocked;
                }

                public String getMPartTime() {
                    return mPartTime;
                }

                public void setMPartTime(String mPartTime) {
                    this.mPartTime = mPartTime;
                }

                public String getMPartUrl() {
                    return mPartUrl;
                }

                public void setMPartUrl(String mPartUrl) {
                    this.mPartUrl = mPartUrl;
                }

                public String getMType() {
                    return mType;
                }

                public void setMType(String mType) {
                    this.mType = mType;
                }

                public String getMUnlockJpoint() {
                    return mUnlockJpoint;
                }

                public void setMUnlockJpoint(String mUnlockJpoint) {
                    this.mUnlockJpoint = mUnlockJpoint;
                }

                public String getMId() {
                    return mId;
                }

                public void setMId(String mId) {
                    this.mId = mId;
                }

                public String getMpName() {
                    return mpName;
                }

                public void setMpName(String mpName) {
                    this.mpName = mpName;
                }

                public String getMpId() {
                    return mpId;
                }

                public void setMpId(String mpId) {
                    this.mpId = mpId;
                }

                public String getMpIdFeature() {
                    return mpIdFeature;
                }

                public void setMpIdFeature(String mpIdFeature) {
                    this.mpIdFeature = mpIdFeature;
                }

                public Object getNodeNameFather() {
                    return nodeNameFather;
                }

                public void setNodeNameFather(Object nodeNameFather) {
                    this.nodeNameFather = nodeNameFather;
                }

                public Object getNodeIdFather() {
                    return nodeIdFather;
                }

                public void setNodeIdFather(Object nodeIdFather) {
                    this.nodeIdFather = nodeIdFather;
                }

                public String getWriteDate() {
                    return writeDate;
                }

                public void setWriteDate(String writeDate) {
                    this.writeDate = writeDate;
                }
            }
        }

        public static class PapaInfoListsBean {
            /**
             * papaAccount : 13916251597
             * papaHeadImgUrl : http://yf.jnwtv.com/5601d479dcbfda34bad5361d059443ab?imageView2/0/w/90/h/90&e=2997426444
             * userNick : 穿衣君
             * healAmount : 100000
             * isOwner : N
             * isBigPapa : Y
             * isFirstBlood : N
             * isProjectCrew : N
             * isPapa : N
             * lvNo : 87
             */

            private String papaAccount;
            private String papaHeadImgUrl;
            private String userNick;
            private String healAmount;
            private String isOwner;
            private String isBigPapa;
            private String isFirstBlood;
            private String isProjectCrew;
            private String isPapa;
            private String lvNo;

            public String getPapaAccount() {
                return papaAccount;
            }

            public void setPapaAccount(String papaAccount) {
                this.papaAccount = papaAccount;
            }

            public String getPapaHeadImgUrl() {
                return papaHeadImgUrl;
            }

            public void setPapaHeadImgUrl(String papaHeadImgUrl) {
                this.papaHeadImgUrl = papaHeadImgUrl;
            }

            public String getUserNick() {
                return userNick;
            }

            public void setUserNick(String userNick) {
                this.userNick = userNick;
            }

            public String getHealAmount() {
                return healAmount;
            }

            public void setHealAmount(String healAmount) {
                this.healAmount = healAmount;
            }

            public String getIsOwner() {
                return isOwner;
            }

            public void setIsOwner(String isOwner) {
                this.isOwner = isOwner;
            }

            public String getIsBigPapa() {
                return isBigPapa;
            }

            public void setIsBigPapa(String isBigPapa) {
                this.isBigPapa = isBigPapa;
            }

            public String getIsFirstBlood() {
                return isFirstBlood;
            }

            public void setIsFirstBlood(String isFirstBlood) {
                this.isFirstBlood = isFirstBlood;
            }

            public String getIsProjectCrew() {
                return isProjectCrew;
            }

            public void setIsProjectCrew(String isProjectCrew) {
                this.isProjectCrew = isProjectCrew;
            }

            public String getIsPapa() {
                return isPapa;
            }

            public void setIsPapa(String isPapa) {
                this.isPapa = isPapa;
            }

            public String getLvNo() {
                return lvNo;
            }

            public void setLvNo(String lvNo) {
                this.lvNo = lvNo;
            }
        }
    }
}
