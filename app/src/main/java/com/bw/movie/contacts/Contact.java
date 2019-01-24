package com.bw.movie.contacts;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/24 00248:39<p>
 */
public class Contact {
    //总接口
    public static final String BASE_URL = "http://172.17.8.100/movieApi/";
    //注册
    public static final String USER_REGISTER = "user/v1/registerUser";
    //登录
    public static final String USER_LOGIN = "user/v1/login";
    //查询会员首页信息
    public static final String USER_MEMBER_INFORMATION = "user/v1/verify/findUserHomeInfo";
    //修改用户信息
    public static final String USER_UPDATE_MESSAGE = "user/v1/verify/modifyUserInfo";
    //上传用户头像
    public static final String USER_HEADER = "user/v1/verify/uploadHeadPic";
    //修改密码
    public static final String USER_UPDATE_PASSWORD = "user/v1/verify/modifyUserPwd";
    //根据用户ID查询用户信息
    public static final String USER_DATA_USERID = "user/v1/verify/getUserInfoByUserId";
    //用户签到
    public static final String USER_SIGNIN = "user/v1/verify/userSignIn";
    //用户购票记录查询列表
    public static final String USER_TICKET_RECORD = "user/v1/verify/findUserBuyTicketRecordList";
    //微信登录
    public static final String WECHAT_LOGIN = "user/v1/weChatBindingLogin";
    //绑定微信账号
    public static final String BIND_WECHAT = "user/v1/verify/bindWeChat";
    //是否绑定微信账号
    public static final String IF_BIND_WECHAT = "user/v1/verify/whetherToBindWeChat";
    /**
     * 电影相关接口
     */
    //热门电影列表
    public static final String POPULAR_MOVIE = "movie/v1/findHotMovieList";
    //查询正在上映电影列表
    public static final String NOW_SHOWING_LIST = "movie/v1/findReleaseMovieList";
    //查询即将上映电影列表
    public static final String COMING_SHOWING_LIST = "movie/v1/findComingSoonMovieList";
    //根据电影ID查询电影信息(GET请求)
    public static final String MOVIE_DATA_BYID = "movie/v1/findMoviesById";
    //查看电影详情(GET请求)
    public static final String MOVIE_DETAILE = "movie/v1/findMoviesDetail";
    //查询用户关注的影片列表
    public static final String ATTENTION_MOVIE_LIST = "movie/v1/verify/findMoviePageList";
    //关注电影
    public static final String ATTENTION_MOVIE = "movie/v1/verify/followMovie";
    //取消关注电影
    public static final String CANCEL_ATTENTION_MOVIE = "movie/v1/verify/cancelFollowMovie";
    //查询影片评论
    public static final String MOVIE_COMMENT = "movie/v1/findAllMovieComment";
    //添加用户对影片的评论
    public static final String ADD_MOVIE_COMMENT = "movie/v1/verify/movieComment";
    //查询影片评论回复
    public static final String COMMENT_REPLY = "movie/v1/findCommentReply";
    //添加用户对评论的回复
    public static final String ADD_COMMENT_REPLY = "movie/v1/verify/commentReply";
    //电影评论点赞
    public static final String COMMENT_LIKE = "movie/v1/verify/movieCommentGreat";
    //根据影院ID查询该影院当前排期的电影列表
    public static final String MOVIE_SCHEDULE_BYCINEMAID = "movie/v1/findMovieListByCinemaId";
    //根据电影ID和影院ID查询电影排期列表
    public static final String MOVIE_SCHEDULE_BYMOVIEID_BYCINEMAID = "movie/v1/findMovieScheduleList";
    //根据电影ID查询当前排片该电影的影院列表
    public static final String MOVIE_SCHEDULE_BYMOVIEID = "movie/v1/findCinemasListByMovieId";
    //购票下单
    public static final String BUY_TICKET = "movie/v1/verify/buyMovieTicket";
    //支付
    public static final String PAYMENT = "movie/v1/verify/pay";
    //根据影院ID查询该影院下即将上映的电影列表
    public static final String COMING_SHOWING_BYCINEMAID = "movie/v1/findSoonMovieByCinemaId";
    /**
     * 影院相关接口
     */
    //查询推荐影院信息
    public static final String RECOMMEND_CINEMA = "cinema/v1/findRecommendCinemas";
    //查询附近影院
    public static final String NEARBY_CINEMA = "cinema/v1/findNearbyCinemas";
    //查询电影信息明细
    public static final String MOVIE_DATA_DETAIL = "cinema/v1/findCinemaInfo";
    //根据电影名称模糊查询电影院
    public static final String CINEMA_BYNAME = "cinema/v1/findRecommendCinemas";
    //查询用户关注的影院信息
    public static final String ATTENTION_CINEMADATA = "cinema/v1/verify/findCinemaPageList";
    //关注影院
    public static final String ATTENTION_CINEMA = "cinema/v1/verify/followCinema";
    //取消关注影院
    public static final String ANCEL_ATTENTION_CINEMA = "cinema/v1/findRecommendCinemas";
    //查询影院用户评论列表
    public static final String CINEMA_COMMENT_LIST = "cinema/v1/findNearbyCinemas";
    //影院评论（用户对影院的评论）
    public static final String CINEMA_COMMENT = "cinema/v1/verify/cinemaComment";
    //影院评论点赞(POST)
    public static final String CINEMA_COMMENT_LIKE = "cinema/v1/verify/cinemaCommentGreat";
    /**
     * 辅助相关接口
     */
    //意见反馈
    public static final String FEEDBACK = "tool/v1/verify/recordFeedBack";
    //查询新版本
    public static final String NEW_VERSION = "tool/v1/findNewVersion";
    //查询系统消息列表
    public static final String SYSTEM_DATA_LIST = "tool/v1/verify/findAllSysMsgList";
    //系统消息读取状态修改
    public static final String UPDATE_SYSTEM_DATA = "tool/v1/verify/changeSysMsgStatus";
    //查询用户当前未读消息数量
    public static final String UNREAD_DATA_NUMBER = "tool/v1/verify/findUnreadMessageCount";
    //上传消息推送使用的token
    public static final String PUSH_TOKEN = "tool/v1/verify/uploadPushToken";
    //微信分享前置接口，获取分享所需参数
    public static final String WECHAT_SHARE = "tool/v1/wxShare";
}
