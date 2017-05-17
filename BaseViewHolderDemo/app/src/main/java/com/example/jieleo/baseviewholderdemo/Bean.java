package com.example.jieleo.baseviewholderdemo;

import java.util.List;

/**
 * Created by OldFour on 2017/4/25.
 */

public class Bean {

    /**
     * code : 200
     * data : {"columns":[{"author":"鹿欧尼","banner_image_url":"http://img03.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1493028531},{"author":"Mia","banner_image_url":"http://img02.liwushuo.com/image/160902/fm7knqhbd.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160902/fm7knqhbd.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160902/7obqmumbf.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160902/7obqmumbf.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472820604,"description":"明星的美丽秘诀永远是大家最感兴趣的话题之一，现在就让我们一一揭秘。","id":105,"order":0,"post_published_at":1493028411,"status":0,"subtitle":"","title":"星美妆报告","updated_at":1493028411},{"author":"叫我小公举","banner_image_url":"http://img01.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1493089200,"status":0,"subtitle":"","title":"解忧杂货铺","updated_at":1493028251},{"author":"穿衣大队长","banner_image_url":"http://img03.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，精心搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1493026591},{"author":"美物娘","banner_image_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1493026486,"status":0,"subtitle":"","title":"美物收割机","updated_at":1493026486},{"author":"小爱","banner_image_url":"http://img03.liwushuo.com/image/160706/bsfcyilj0.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160706/bsfcyilj0.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160713/nkxdwgmos.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/nkxdwgmos.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467783110,"description":"在这里，满满都是我对你的爱。","id":88,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"甜蜜礼物社","updated_at":1493025887},{"author":"Dr.Bag","banner_image_url":"http://img01.liwushuo.com/image/161103/q1hgyfj7h.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/161103/q1hgyfj7h.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img03.liwushuo.com/image/161108/aw8q54ale.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161108/aw8q54ale.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1478153753,"description":"最会挑鞋子包包的老司机，带你2分钟Get最IN流行款","id":119,"order":0,"post_published_at":1493110800,"status":0,"subtitle":"","title":"鞋包研究所","updated_at":1492755985},{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467340938,"description":"iPhone腿、A4腰、锁骨放硬币、反手摸肚脐\r\n没有最严苛的审美，只有最病态的减肥！\r\n还是既健康又美丽来的实际！","id":85,"order":0,"post_published_at":1493089200,"status":0,"subtitle":"","title":"美体小铺","updated_at":1492685257},{"author":"灰姑娘","banner_image_url":"http://img01.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img03.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1493002800,"status":0,"subtitle":"","title":"靠脸吃饭","updated_at":1492684715},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/170119/gjv9kljjh.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/170119/gjv9kljjh.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/161219/0kmwa8wby.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161219/0kmwa8wby.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1482140135,"description":"职场人士必备贴","id":122,"order":0,"post_published_at":1491966000,"status":0,"subtitle":"礼物","title":"因礼不同","updated_at":1491879260},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160905/f5g5ouwkz.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160905/f5g5ouwkz.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/160905/xqyvy9n1z.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160905/xqyvy9n1z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473045022,"description":"动心的太多，走心的1个足矣","id":106,"order":0,"post_published_at":1491523200,"status":0,"subtitle":"","title":"一个","updated_at":1491468421},{"author":"上上签","banner_image_url":"http://img01.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1490745600,"status":0,"subtitle":"","title":"日复一签","updated_at":1490701519},{"author":"小C","banner_image_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1490929200,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1490616463},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160815/v2p80ao8y.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160815/v2p80ao8y.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160815/fervz0o5x.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160815/fervz0o5x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1471225655,"description":"品质、考究、精心遴选；细节、严格、甄添筛减；处女座强迫症的挑选小组，一份有态度的最佳礼物大赏。","id":94,"order":0,"post_published_at":1490572800,"status":0,"subtitle":"","title":"最佳礼物大赏","updated_at":1490613768},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/160623/56osnquwa.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160623/56osnquwa.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160628/fwwz5zua2.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160628/fwwz5zua2.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1466495336,"description":"完美礼物指南，送亲人送爱人送友人送陌生人，一次性拯救你的选礼困难症。","id":59,"order":0,"post_published_at":1490619600,"status":0,"subtitle":"","title":"万能礼物清单","updated_at":1490603301},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/170217/zslvdoe9q.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/170217/zslvdoe9q.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img02.liwushuo.com/image/170217/sy8p3ity3.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170217/sy8p3ity3.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1487322761,"description":"礼物实验室，珍藏时光、实现愿望，让礼物星人，找到最有温度、乐趣的礼物。","id":125,"order":0,"post_published_at":1490443200,"status":0,"subtitle":"","title":"礼物实验室","updated_at":1490427889},{"author":"朵朵酱","banner_image_url":"http://img01.liwushuo.com/image/170213/oirsx0w49.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/170213/oirsx0w49.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img02.liwushuo.com/image/170213/02gecacdu.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170213/02gecacdu.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1486984168,"description":"这城市总是风很大，孤独的人总是晚回家。","id":124,"order":0,"post_published_at":1490356800,"status":0,"subtitle":"","title":"夜猫酒馆","updated_at":1490337450},{"author":"4K馆长","banner_image_url":"http://img02.liwushuo.com/image/160905/558q5j6sx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/558q5j6sx.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img03.liwushuo.com/image/160905/75rv8fj87.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160905/75rv8fj87.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472806296,"description":"搜罗天下数码好物，每周测评体验极客最前沿。","id":99,"order":0,"post_published_at":1488499200,"status":0,"subtitle":"","title":"数码体验馆","updated_at":1488272660},{"author":"你作姐","banner_image_url":"http://img02.liwushuo.com/image/160612/81bq8qx6e.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160612/81bq8qx6e.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/5aj2kn3iy.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/5aj2kn3iy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1465722171,"description":"既然青春留不住，活得漂亮也赚了。","id":48,"order":0,"post_published_at":1487408400,"status":0,"subtitle":"","title":"作美指南","updated_at":1487316011},{"author":"穿衣大队长","banner_image_url":"http://img03.liwushuo.com/image/170116/7y4ef23ze.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/170116/7y4ef23ze.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/170116/tk01xov8x.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170116/tk01xov8x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1484561725,"description":"❀ 爱一但发了芽就算雨水都不下，也阻止不了它开花❀","id":123,"order":0,"post_published_at":1487041200,"status":0,"subtitle":"","title":"恋爱丄丄签","updated_at":1486980273}],"paging":{"next_url":"http://api.liwushuo.com/v2/columns?limit=20&offset=20"}}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * columns : [{"author":"鹿欧尼","banner_image_url":"http://img03.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1493028531},{"author":"Mia","banner_image_url":"http://img02.liwushuo.com/image/160902/fm7knqhbd.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160902/fm7knqhbd.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160902/7obqmumbf.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160902/7obqmumbf.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472820604,"description":"明星的美丽秘诀永远是大家最感兴趣的话题之一，现在就让我们一一揭秘。","id":105,"order":0,"post_published_at":1493028411,"status":0,"subtitle":"","title":"星美妆报告","updated_at":1493028411},{"author":"叫我小公举","banner_image_url":"http://img01.liwushuo.com/image/160608/muk9fdsya.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/muk9fdsya.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/1p98sh06h.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/1p98sh06h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501717,"description":"僻静的街角有一家杂货铺，或许你带着忧愁走进店中，但不期而遇的小物却让你展露欢颜。","id":14,"order":0,"post_published_at":1493089200,"status":0,"subtitle":"","title":"解忧杂货铺","updated_at":1493028251},{"author":"穿衣大队长","banner_image_url":"http://img03.liwushuo.com/image/160608/ygqtl238c.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/ygqtl238c.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160713/4egoefdla.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/4egoefdla.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501669,"description":"做你的私人搭配师，精心搭配治好你的选择困难症，满足你多睡5分钟的小小心愿。","id":13,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"明天穿什么","updated_at":1493026591},{"author":"美物娘","banner_image_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1493026486,"status":0,"subtitle":"","title":"美物收割机","updated_at":1493026486},{"author":"小爱","banner_image_url":"http://img03.liwushuo.com/image/160706/bsfcyilj0.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160706/bsfcyilj0.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160713/nkxdwgmos.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/nkxdwgmos.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467783110,"description":"在这里，满满都是我对你的爱。","id":88,"order":0,"post_published_at":1493078400,"status":0,"subtitle":"","title":"甜蜜礼物社","updated_at":1493025887},{"author":"Dr.Bag","banner_image_url":"http://img01.liwushuo.com/image/161103/q1hgyfj7h.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/161103/q1hgyfj7h.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img03.liwushuo.com/image/161108/aw8q54ale.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161108/aw8q54ale.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1478153753,"description":"最会挑鞋子包包的老司机，带你2分钟Get最IN流行款","id":119,"order":0,"post_published_at":1493110800,"status":0,"subtitle":"","title":"鞋包研究所","updated_at":1492755985},{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160701/39gumoiqc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/o9rsmpl0c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467340938,"description":"iPhone腿、A4腰、锁骨放硬币、反手摸肚脐\r\n没有最严苛的审美，只有最病态的减肥！\r\n还是既健康又美丽来的实际！","id":85,"order":0,"post_published_at":1493089200,"status":0,"subtitle":"","title":"美体小铺","updated_at":1492685257},{"author":"灰姑娘","banner_image_url":"http://img01.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img03.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1493002800,"status":0,"subtitle":"","title":"靠脸吃饭","updated_at":1492684715},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/170119/gjv9kljjh.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/170119/gjv9kljjh.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/161219/0kmwa8wby.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161219/0kmwa8wby.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1482140135,"description":"职场人士必备贴","id":122,"order":0,"post_published_at":1491966000,"status":0,"subtitle":"礼物","title":"因礼不同","updated_at":1491879260},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160905/f5g5ouwkz.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160905/f5g5ouwkz.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/160905/xqyvy9n1z.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160905/xqyvy9n1z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473045022,"description":"动心的太多，走心的1个足矣","id":106,"order":0,"post_published_at":1491523200,"status":0,"subtitle":"","title":"一个","updated_at":1491468421},{"author":"上上签","banner_image_url":"http://img01.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1490745600,"status":0,"subtitle":"","title":"日复一签","updated_at":1490701519},{"author":"小C","banner_image_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1490929200,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1490616463},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160815/v2p80ao8y.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160815/v2p80ao8y.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160815/fervz0o5x.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160815/fervz0o5x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1471225655,"description":"品质、考究、精心遴选；细节、严格、甄添筛减；处女座强迫症的挑选小组，一份有态度的最佳礼物大赏。","id":94,"order":0,"post_published_at":1490572800,"status":0,"subtitle":"","title":"最佳礼物大赏","updated_at":1490613768},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/160623/56osnquwa.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160623/56osnquwa.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160628/fwwz5zua2.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160628/fwwz5zua2.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1466495336,"description":"完美礼物指南，送亲人送爱人送友人送陌生人，一次性拯救你的选礼困难症。","id":59,"order":0,"post_published_at":1490619600,"status":0,"subtitle":"","title":"万能礼物清单","updated_at":1490603301},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/170217/zslvdoe9q.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/170217/zslvdoe9q.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img02.liwushuo.com/image/170217/sy8p3ity3.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170217/sy8p3ity3.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1487322761,"description":"礼物实验室，珍藏时光、实现愿望，让礼物星人，找到最有温度、乐趣的礼物。","id":125,"order":0,"post_published_at":1490443200,"status":0,"subtitle":"","title":"礼物实验室","updated_at":1490427889},{"author":"朵朵酱","banner_image_url":"http://img01.liwushuo.com/image/170213/oirsx0w49.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/170213/oirsx0w49.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img02.liwushuo.com/image/170213/02gecacdu.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170213/02gecacdu.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1486984168,"description":"这城市总是风很大，孤独的人总是晚回家。","id":124,"order":0,"post_published_at":1490356800,"status":0,"subtitle":"","title":"夜猫酒馆","updated_at":1490337450},{"author":"4K馆长","banner_image_url":"http://img02.liwushuo.com/image/160905/558q5j6sx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/558q5j6sx.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img03.liwushuo.com/image/160905/75rv8fj87.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160905/75rv8fj87.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472806296,"description":"搜罗天下数码好物，每周测评体验极客最前沿。","id":99,"order":0,"post_published_at":1488499200,"status":0,"subtitle":"","title":"数码体验馆","updated_at":1488272660},{"author":"你作姐","banner_image_url":"http://img02.liwushuo.com/image/160612/81bq8qx6e.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160612/81bq8qx6e.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/5aj2kn3iy.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/5aj2kn3iy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1465722171,"description":"既然青春留不住，活得漂亮也赚了。","id":48,"order":0,"post_published_at":1487408400,"status":0,"subtitle":"","title":"作美指南","updated_at":1487316011},{"author":"穿衣大队长","banner_image_url":"http://img03.liwushuo.com/image/170116/7y4ef23ze.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/170116/7y4ef23ze.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/170116/tk01xov8x.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/170116/tk01xov8x.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1484561725,"description":"❀ 爱一但发了芽就算雨水都不下，也阻止不了它开花❀","id":123,"order":0,"post_published_at":1487041200,"status":0,"subtitle":"","title":"恋爱丄丄签","updated_at":1486980273}]
         * paging : {"next_url":"http://api.liwushuo.com/v2/columns?limit=20&offset=20"}
         */

        private PagingBean paging;
        private List<ColumnsBean> columns;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class PagingBean {
            /**
             * next_url : http://api.liwushuo.com/v2/columns?limit=20&offset=20
             */

            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ColumnsBean {
            /**
             * author : 鹿欧尼
             * banner_image_url : http://img03.liwushuo.com/image/160630/npssjj3yc.jpg-w300
             * banner_webp_url : http://img03.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp
             * category : 美食
             * cover_image_url : http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg-w720
             * cover_webp_url : http://img02.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp
             * created_at : 1467265951
             * description : 无论是山珍海味还是街边小吃，
             无论是飞禽走兽还是五谷香料，
             美食不分贵贱没有国界
             我们都犯着一种罪，叫做“食宗最”
             * id : 83
             * order : 0
             * post_published_at : 1493078400
             * status : 0
             * subtitle :
             * title : 吃货俱乐部
             * updated_at : 1493028531
             */

            private String author;
            private String banner_image_url;
            private String banner_webp_url;
            private String category;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int id;
            private int order;
            private int post_published_at;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_webp_url() {
                return banner_webp_url;
            }

            public void setBanner_webp_url(String banner_webp_url) {
                this.banner_webp_url = banner_webp_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPost_published_at() {
                return post_published_at;
            }

            public void setPost_published_at(int post_published_at) {
                this.post_published_at = post_published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}