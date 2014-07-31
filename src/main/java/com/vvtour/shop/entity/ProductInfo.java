package com.vvtour.shop.entity;

import java.util.Arrays;

import com.usual.entity.BaseEntity;

public class ProductInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7652209194727077900L;
	
	private final static String collectionName = "product_info";
	
	public ProductInfo() {
		super(collectionName);
	}
	
	/**
     * 保存暂未发布
     */
    public static final int PRODUCT_UNPUB = 0;
    
    /**
     * 已发布
     */
    public static final int PRODUCT_PUB = 1;
	
	/**
     * 删除
     */
    public static final int PRODUCT_LOCK = -1;
    
    public final static String ACTION_PRODUCT_URL = "/admin/viewProduct.htm?pro_id=";
    
	
	/**
	 * 
	 * .主键：				pro_id
	 * .路线类型：				ca_type			例如：出境游，国内游									      		[频道页]
	 * .一级目的地(景点)属性标签：parent_id,parent_name 自定义		欧洲，东南亚，马尔代夫，（类似于）					[搜索标签]
	 * .二级目的地(景点)属性标签：ca_id,ca_name         自定义		如：英国，卡尼岛（类似于途牛网热点目的地）				[搜索标签]
	 * .旅游路线属性：			tour_path 	(适合出境游)自定义	如：多国，一国,马尔代夫+香港，德意瑞						[搜索标签]
	 * .行程天数	  			tour_days	1,2,3,4,5,6														[搜索标签]
	 * .路线标题：				tour_title
	 * .路线图片：				tour_images  	数组类型/images/12324.jpg,/images/23423.jpg
	 * .出发城市：				start_city		北京
	 * .目的地：				end_city		曼谷
	 * .发团日期：				start_dates		天天发的 记录数据为:1|{100|50},固定格式的：2|{100|50|1,3,5,7}
	 * 										指定格式的：3|{2014-7-2|100|50,2014-7-3|120|60,2014-7-5|100|50}
	 * .推荐理由：内容			tour_commend
	 * .行程特色：内容			tour_feature
	 * .行程安排：内容			tour_con
	 * .重要提示：内容			tour_tip
	 * .费用说明：内容			tour_fee
	 * .签证说明：内容			tour_visa
	 * 
	 * 
	 * .往返交通：				vehicle			飞机，直飞往返，火车
	 * .主题路线标签：			topic_tag		亲子游，夕阳红，蜜月游，游轮，自由行，跟团游，周边游，海岛游   				[搜索标签]
	 * .特色路线标签：			feature_tag		直飞，五星酒店													[搜索标签]
	 * .景点包含标签：			views_tag		故宫，天安门，水立方，埃菲尔铁塔									[搜索标签]
	 * .搜索标签组:			search_tag		(visit_parent,visit_tag,tour_path,end_city,views_tag)
	 * 
	 * 
	 * .会员价格：				member_price	
	 * .市场价格：				market_price
	 * .优惠标签：				discount_tag	促销，积分抵用，网购返现	
	 * .促销标题：				sale_title		奢华蜜月私密性极强，水下餐厅让您感受奢华浪漫的蜜月！
	 * .支付方式: 			pay_form		现金支付
	 *
	 * 
	 * .页面标题：				page_title
	 * .页面关键字：			page_keyword
	 * .页面描述：				page_descript
	 * 
	 * .所属大洲：				continent		亚洲			可以为空
	 * .所属国家标签：			country			韩国			可以为空
	 * .所属省标签：			province	(适合用于国内游)	可以为空
	 * .所属城市标签：			city			首尔			可以为空
	 * 
	 * 
	 * .发布时间：				pub_time
	 * .修改时间:				edit_time
	 * .发布人：				pub_user
	 * .发布人昵称：			pub_nick
	 * .状态					status   0未发布 1已发布生成Html -1删除
	 * .静态地址：				link_url
	 * 
	 * 39个字段
	 * */
	
	private String pro_id;
	private String ca_type;
	private String parent_id;
	private String parent_name;
	private String ca_id;
	private String ca_name;
	private String tour_path;
	private Integer tour_days;
	private String tour_title;
	private String[] tour_images;
	private String start_city;
	private String end_city;
	private String[] start_dates;
	private String tour_commend;
	private String tour_feature;
	private String tour_con;
	private String tour_tip;
	private String tour_fee;
	private String tour_visa;

	//tab2
	private String vehicle;
	private String[] topic_tag;
	private String[] feature_tag;
	private String[] views_tag;
	private String[] search_tag;

	//tab3
	private Integer member_price;
	private Integer market_price;
	private String[] discount_tag;
	private String sale_title;
	private String[] pay_form;

	//tab4
	private String page_title;
	private String page_keyword;
	private String page_descript;

	private String continent;
	private String country;
	private String province;
	private String city;

	private String pub_user;
	private String pub_nick;
	private Long pub_time;
	private Long edit_time;
	private Integer status;
	private String link_url;

	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	
	public String getCa_type() {
		return ca_type;
	}
	public void setCa_type(String ca_type) {
		this.ca_type = ca_type;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getCa_id() {
		return ca_id;
	}
	public void setCa_id(String ca_id) {
		this.ca_id = ca_id;
	}
	public String getCa_name() {
		return ca_name;
	}
	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
	}
	public String getTour_path() {
		return tour_path;
	}
	public void setTour_path(String tour_path) {
		this.tour_path = tour_path;
	}
	public Integer getTour_days() {
		return tour_days;
	}
	public void setTour_days(Integer tour_days) {
		this.tour_days = tour_days;
	}
	public String getTour_title() {
		return tour_title;
	}
	public void setTour_title(String tour_title) {
		this.tour_title = tour_title;
	}
	public String[] getTour_images() {
		return tour_images;
	}
	public void setTour_images(String[] tour_images) {
		this.tour_images = tour_images;
	}
	public String getStart_city() {
		return start_city;
	}
	public void setStart_city(String start_city) {
		this.start_city = start_city;
	}
	public String getEnd_city() {
		return end_city;
	}
	public void setEnd_city(String end_city) {
		this.end_city = end_city;
	}
	public String[] getStart_dates() {
		return start_dates;
	}
	public void setStart_dates(String[] start_dates) {
		this.start_dates = start_dates;
	}
	public String getTour_commend() {
		return tour_commend;
	}
	public void setTour_commend(String tour_commend) {
		this.tour_commend = tour_commend;
	}
	public String getTour_feature() {
		return tour_feature;
	}
	public void setTour_feature(String tour_feature) {
		this.tour_feature = tour_feature;
	}
	public String getTour_con() {
		return tour_con;
	}
	public void setTour_con(String tour_con) {
		this.tour_con = tour_con;
	}
	public String getTour_tip() {
		return tour_tip;
	}
	public void setTour_tip(String tour_tip) {
		this.tour_tip = tour_tip;
	}
	public String getTour_fee() {
		return tour_fee;
	}
	public void setTour_fee(String tour_fee) {
		this.tour_fee = tour_fee;
	}
	public String getTour_visa() {
		return tour_visa;
	}
	public void setTour_visa(String tour_visa) {
		this.tour_visa = tour_visa;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String[] getTopic_tag() {
		return topic_tag;
	}
	public void setTopic_tag(String[] topic_tag) {
		this.topic_tag = topic_tag;
	}
	public String[] getFeature_tag() {
		return feature_tag;
	}
	public void setFeature_tag(String[] feature_tag) {
		this.feature_tag = feature_tag;
	}
	public String[] getViews_tag() {
		return views_tag;
	}
	public void setViews_tag(String[] views_tag) {
		this.views_tag = views_tag;
	}
	public String[] getSearch_tag() {
		return search_tag;
	}
	public void setSearch_tag(String[] search_tag) {
		this.search_tag = search_tag;
	}
	public Integer getMember_price() {
		return member_price;
	}
	public void setMember_price(Integer member_price) {
		this.member_price = member_price;
	}
	public Integer getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Integer market_price) {
		this.market_price = market_price;
	}
	public String[] getDiscount_tag() {
		return discount_tag;
	}
	public void setDiscount_tag(String[] discount_tag) {
		this.discount_tag = discount_tag;
	}
	public String getSale_title() {
		return sale_title;
	}
	public void setSale_title(String sale_title) {
		this.sale_title = sale_title;
	}
	public String[] getPay_form() {
		return pay_form;
	}
	public void setPay_form(String[] pay_form) {
		this.pay_form = pay_form;
	}
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public String getPage_keyword() {
		return page_keyword;
	}
	public void setPage_keyword(String page_keyword) {
		this.page_keyword = page_keyword;
	}
	public String getPage_descript() {
		return page_descript;
	}
	public void setPage_descript(String page_descript) {
		this.page_descript = page_descript;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPub_time() {
		return pub_time;
	}
	public void setPub_time(Long pub_time) {
		this.pub_time = pub_time;
	}
	public Long getEdit_time() {
		return edit_time;
	}
	public void setEdit_time(Long edit_time) {
		this.edit_time = edit_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	
	public String getPub_user() {
		return pub_user;
	}
	public void setPub_user(String pub_user) {
		this.pub_user = pub_user;
	}
	public String getPub_nick() {
		return pub_nick;
	}
	public void setPub_nick(String pub_nick) {
		this.pub_nick = pub_nick;
	}
	@Override
	public String toString() {
		return "ProductInfo [pro_id=" + pro_id + ", ca_type=" + ca_type
				+ ", parent_id=" + parent_id + ", parent_name=" + parent_name
				+ ", ca_id=" + ca_id + ", ca_name=" + ca_name + ", tour_path="
				+ tour_path + ", tour_days=" + tour_days + ", tour_title="
				+ tour_title + ", tour_images=" + Arrays.toString(tour_images)
				+ ", start_city=" + start_city + ", end_city=" + end_city
				+ ", start_dates=" + Arrays.toString(start_dates)
				+ ", tour_commend=" + tour_commend + ", tour_feature="
				+ tour_feature + ", tour_con=" + tour_con + ", tour_tip="
				+ tour_tip + ", tour_fee=" + tour_fee + ", tour_visa="
				+ tour_visa + ", vehicle=" + vehicle + ", topic_tag="
				+ Arrays.toString(topic_tag) + ", feature_tag="
				+ Arrays.toString(feature_tag) + ", views_tag="
				+ Arrays.toString(views_tag) + ", search_tag="
				+ Arrays.toString(search_tag) + ", member_price="
				+ member_price + ", market_price=" + market_price
				+ ", discount_tag=" + Arrays.toString(discount_tag)
				+ ", sale_title=" + sale_title + ", pay_form="
				+ Arrays.toString(pay_form) + ", page_title=" + page_title
				+ ", page_keyword=" + page_keyword + ", page_descript="
				+ page_descript + ", continent=" + continent + ", country="
				+ country + ", province=" + province + ", city=" + city
				+ ", pub_user=" + pub_user + ", pub_nick=" + pub_nick
				+ ", pub_time=" + pub_time + ", edit_time=" + edit_time
				+ ", status=" + status + ", link_url=" + link_url + "]";
	}
	
	
}
