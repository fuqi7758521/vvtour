package com.usual.utils;

import com.common.utils.CodeConstants;


public enum IdTypeEnum {
 
	ADMIN_USER_ID(CodeConstants.ID_TYPE_INIT_NUM + 0),			/**   管理员表idType=10001   **/
	
	ADMIN_MENU_ID(CodeConstants.ID_TYPE_INIT_NUM + 1),			/**   管理菜单表idType=10002   **/
	
	ADMIN_AUTH_ID(CodeConstants.ID_TYPE_INIT_NUM + 2),			/**   管理员权限表idType=10003   **/
	
	ADMIN_ALBUM_ID(CodeConstants.ID_TYPE_INIT_NUM + 3),				/**   相册表idType=10004    **/
	
	ADMIN_WEB_IMAGES_ID(CodeConstants.ID_TYPE_INIT_NUM + 4),			/**   网站图片表idType=10005  **/
	
	ADMIN_VISIT_PARENT_ID(CodeConstants.ID_TYPE_INIT_NUM + 5),			/**   一级目的地标签表idType=10006  **/
	
	ADMIN_VISIT_TAG_ID(CodeConstants.ID_TYPE_INIT_NUM + 6),			/**   二级目的地标签表idType=10007  **/
	
	TOUR_PATH_ID(CodeConstants.ID_TYPE_INIT_NUM + 7),				/**   旅游路线idType=10008  **/
	
	PRODUCT_ID(CodeConstants.ID_TYPE_INIT_NUM + 8),				/**   产品分类idType=10009   **/
	
	CATEGORY_ID(CodeConstants.ID_TYPE_INIT_NUM + 9),				/**   产品分类idType=10010   **/
	
	CHIP_CATEGORY_ID(CodeConstants.ID_TYPE_INIT_NUM + 10),				/**   碎片分类idType=10011   **/
	
	CHIP_ID(CodeConstants.ID_TYPE_INIT_NUM + 11),			/**   碎片idType=10012   **/
	
	USER_ID(CodeConstants.ID_TYPE_INIT_NUM + 12);			/**  用户idType**/	

	private final int type;

	IdTypeEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
